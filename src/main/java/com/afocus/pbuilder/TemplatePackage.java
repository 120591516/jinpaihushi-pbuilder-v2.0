package com.afocus.pbuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.afocus.pbuilder.common.utils.ArrayList;
import com.afocus.pbuilder.common.utils.List;
import com.afocus.pbuilder.common.utils.ScriptUtils;

/**
 * 模板包
 * 
 * @author liuwu
 *
 */
public class TemplatePackage {

	private static final String EXCLUDES = "pbuilder.template.excludes";
	private static final String ENABLE = "pbuilder.template.enable";
	private static final String EXCLUDE_COMMON = "pbuilder.template.excludes.common";

	private static final Logger logger = Logger
			.getLogger(TemplatePackage.class);

	private final File directory;
	private boolean enable;
	private boolean excludeCommonFile;
	private final Properties config = new Properties();
	private final List<File> javascripts = new ArrayList<>();
	private final List<File> properties = new ArrayList<>();
	private final List<File> files = new ArrayList<>();

	public TemplatePackage(File directory) {
		Objects.requireNonNull(directory, "directory");
		if (!directory.exists() || !directory.isDirectory()) {
			throw new IllegalArgumentException("not exsits or not a directory");
		}
		try {
			this.directory = directory;

			// 扫描Properties文件
			File[] properties = directory.listFiles(e -> e.isFile()
					&& e.getName().endsWith(".vm.properties"));
			// 扫描JavaScript文件
			File[] scriptFiles = directory.listFiles(e -> e.isFile()
					&& e.getName().endsWith(".vm.js"));

			// 排除在模板外的文件名集合
			Set<String> excludes = new HashSet<String>();
			// 提取Properties
			for (File prop : properties) {
				logger.debug("[load] " + prop);
				Properties p = new Properties();
				p.load(new FileInputStream(prop));
				config.putAll(p);
				if (!enable
						&& "true".equalsIgnoreCase(p.getProperty(ENABLE,
								"false"))) {
					enable = true;
				}
				if (!excludeCommonFile
						&& "true".equalsIgnoreCase(p.getProperty(
								EXCLUDE_COMMON, "false"))) {
					excludeCommonFile = true;
				}
				excludes.add(prop.getName());
				Stream.of(p.getProperty(EXCLUDES, "").split(",")).forEach(
						excludes::add);
			}
			Stream.of(scriptFiles).forEach(script -> {
				this.javascripts.add(script);
				excludes.add(script.getName());
			});
			config.put(EXCLUDES,
					excludes.stream().collect(Collectors.joining(",")));

			// 如果已经关闭，就不浪费性能去扫描模板文件了
			if (!enable) {
				return;
			}

			java.util.List<File> fileList = Stream.of(directory.listFiles((dir, name) -> !excludes
					.contains(name))).filter(e -> !e.isHidden()).collect(Collectors.toList());
			File[] commonFiles = fileList.toArray(new File[fileList.size()]);
			listFiles(commonFiles, files);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 递归列出所有叶子节点的文件/文件夹
	 * 
	 * @param in
	 *            输入文件/文件夹数组
	 * @param out
	 *            输出文件/文件夹列表
	 */
	private void listFiles(File[] in, List<File> out) {
		for (File file : in) {
			if (file.isDirectory()) {
				File[] childs = file.listFiles(e -> !e.isHidden());
				if (childs == null || childs.length == 0) {
					out.add(file);
				} else {
					listFiles(childs, out);
				}
			} else {
				out.add(file);
			}
		}
	}

	public Properties getConfig() {
		return config;
	}

	public List<File> getJavascripts() {
		return javascripts;
	}

	public List<File> getProperties() {
		return properties;
	}

	public List<File> getFiles() {
		return files;
	}

	/**
	 * 判断是否已经启用<br/>
	 * 对于未启用的模板包，getConfig(),getProperties(),getJavascripts()这三个方法可以正常获取值，
	 * 但是getFiles()一定是空的，因为一旦发现模板包是未启用的，就没有必要去扫描模板文件了
	 * 
	 * @return 如果已经关闭返回true，未关闭返回false，
	 */
	public boolean isEnable() {
		return enable;
	}

	public boolean isExcludeCommonFile() {
		return excludeCommonFile;
	}

	public List<String> getRelativePaths() {
		String base = directory.getAbsolutePath();
		return files.stream()
				.map(e -> e.getAbsolutePath().substring(base.length()))
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	}

	public File getDirectory() {
		return directory;
	}

	public void evalScript() {
		this.getJavascripts().forEach(
				js -> {
					try {
						logger.debug("[eval] " + js);
						ScriptUtils.getScriptEngine().eval(
								FileUtils.readFileToString(js));
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
	}
	
	public String getName(){
		return directory.getName();
	}

	@Override
	public String toString() {
		return "TemplatePackage [directory=" + directory + ", enable=" + enable
				+ "]";
	}

}
