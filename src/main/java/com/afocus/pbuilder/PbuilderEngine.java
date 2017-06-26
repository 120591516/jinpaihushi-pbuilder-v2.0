package com.afocus.pbuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import com.afocus.pbuilder.common.event.EvaluateEvent;
import com.afocus.pbuilder.common.utils.ScriptUtils;

/**
 * Pbuilder模板引擎
 * 
 * @author liuwu
 *
 */
public class PbuilderEngine extends VelocityEngine {

	public PbuilderEngine() {
		super();
	}

	public PbuilderEngine(Properties p) {
		super(p);
	}

	public PbuilderEngine(String propsFilename) {
		super(propsFilename);
	}

	/**
	 * 执行模板包
	 * 
	 * @param context
	 *            上下文
	 * @param export
	 *            导出文件夹
	 * @param logTag
	 *            日志TAG
	 * @param templatePackage
	 *            模板包
	 * @return 成功执行完毕返回true，否则返回false
	 * @throws ParseErrorException
	 * @throws MethodInvocationException
	 * @throws ResourceNotFoundException
	 */
	public boolean evaluate(Context context, File export, String logTag,
			TemplatePackage templatePackage) throws ParseErrorException,
			MethodInvocationException, ResourceNotFoundException {
		if (!export.isDirectory()) {
			throw new IllegalArgumentException("export is not a directory");
		}
		boolean success = true;
		List<File> generateFiles = evaluateGenerateFiles(context, export,
				logTag, templatePackage);
		List<File> templateFiles = templatePackage.getFiles();
		for (int i = 0; i < generateFiles.size(); i++) {
			File tf = templateFiles.get(i);
			File gf = generateFiles.get(i);
			// 生成文件夹
			if (tf.isFile()) {
				// 如果模板是文件，确保目标文件的父文件夹存在
				if (!gf.getParentFile().exists())
					gf.getParentFile().mkdirs();
			} else {
				// 如果模板是文件夹，创建目标文件夹并继续下一个模板文件
				if (!gf.exists())
					gf.mkdirs();
				continue;
			}
			// 非模板文件的处理
			if (!tf.getName().endsWith(".vm")) {
				// 如果非模板文件被排除在外，直接跳过该文件
				if (templatePackage.isExcludeCommonFile()) {
					continue;
				}
				try {
					// 如果非模板文件没有被排除在外，直接复制文件到目标文件并继续下一个模板文件
					FileUtils.copyFile(tf, gf);
					continue;
				} catch (IOException e) {
					success = false;
					e.printStackTrace();
				}
			}
			// 模板文件的处理
			FileWriter writer = null;
			FileReader reader = null;
			try {
				writer = new FileWriter(gf);
				reader = new FileReader(tf);
				super.evaluate(context, writer, logTag, reader);
				ScriptUtils.trigger("evaluate", new EvaluateEvent(this, tf, gf));
			} catch (Exception e) {
				success = false;
				e.printStackTrace();
			} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
						success = false;
						e.printStackTrace();
					}
				}
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						success = false;
						e.printStackTrace();
					}
				}
			}
		}
		return success;
	}

	/**
	 * 生成目标抽象文件（并没有实际上创建文件）
	 * 
	 * @param context
	 *            上下文
	 * @param export
	 *            导出文件夹
	 * @param logTag
	 *            日志TAG
	 * @param templatePackage
	 *            模板包
	 * @return 目标文件列表，与传入的模板文件列表一一对应
	 */
	private List<File> evaluateGenerateFiles(Context context, File export,
			String logTag, TemplatePackage templatePackage) {

		// 获取模板的相对路径列表（相对于模板包的路径）
		List<String> relativePaths = templatePackage.getRelativePaths();

		// 把相对路径合并成一个字符串，去掉.vm后缀，每个路径一行
		String paths = relativePaths
				.stream()
				.map(e -> e.endsWith(".vm") ? e.substring(0, e.length() - 3)
						: e).collect(Collectors.joining("\n"));
		// 如果文件分割符使用的是反斜杠，替换成斜杠（因为反斜杠同时是转义字符）
		if ("\\".equals(File.separator)) {
			paths = paths.replaceAll("\\\\", "/");
		}

		// 执行一次Velocity引擎
		StringWriter writer = new StringWriter();
		super.evaluate(context, writer, logTag, paths);
		String[] generatePaths;
		if ("\\".equals(File.separator)) {
			// 如果文件分割符使用的是反斜杠，那么把斜杠替换成默认的文件分隔符反斜杠
			generatePaths = writer.toString().replaceAll("/", "\\\\")
					.split("\n");
		} else {
			generatePaths = writer.toString().split("\n");
		}

		// 生成文件路径列表应该是与模板文件列表一一对应的
		if (templatePackage.getFiles().size() != generatePaths.length)
			throw new ParseErrorException(
					"cannot map template files to generate paths");

		// 转化目标成文件列表（在export文件夹下）
		List<File> generateFiles = Stream
				.of(generatePaths)
				.map(relativePath -> new File(export.getAbsolutePath()
						+ File.separator
						+ templatePackage.getDirectory().getName()
						+ relativePath)).collect(Collectors.toList());

		return generateFiles;
	}

}
