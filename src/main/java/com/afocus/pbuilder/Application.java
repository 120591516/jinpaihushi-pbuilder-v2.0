package com.afocus.pbuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.script.ScriptException;

import org.apache.log4j.Logger;
import org.apache.velocity.context.Context;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.afocus.pbuilder.common.event.CompleteEvent;
import com.afocus.pbuilder.common.event.InitEvent;
import com.afocus.pbuilder.common.service.ContextService;
import com.afocus.pbuilder.common.service.TableService;
import com.afocus.pbuilder.common.utils.ScriptUtils;

/**
 * 程序入口
 * 
 * @author liuwu
 *
 */
@SpringBootApplication
public class Application {

	private static final Logger logger = Logger.getLogger(Application.class);

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ScriptException, NoSuchMethodException {
		logger.debug("======================START========================");

		PbuilderEngine pbuilderEngine = new PbuilderEngine();
		pbuilderEngine.init();
		
		Properties properties = Config.getProperties();
		Context velocityContext = Config.getContext();

		String respository = properties.getProperty(
				"pbuilder.template.repository", "templates");

		// 扫描模板包
		List<TemplatePackage> packages = scan(respository);

		// 遍历模板包
		packages.forEach(tp -> {
			//System.out.println("tp.getName() = "+tp.getName());
			// 初始化配置/上下文/脚本
			Config.init(tp);

			// 触发启动事件
			ScriptUtils.trigger("init", new InitEvent(tp, properties,
					velocityContext));

			// 初始化spring环境
			SpringApplication springApplication = new SpringApplication(
					Application.class);
			springApplication.setDefaultProperties(properties);
			ApplicationContext applicationContext = springApplication.run(args);

			// 获取任务信息
			String database = properties.getProperty("task.database", "oracle");
			String schema = properties.getProperty("task.schema");
			String tables = properties.getProperty("task.tables", "");
			File export = new File(properties.getProperty(
					"pbuilder.template.export", "generate"));
			export.mkdirs();
			
			//编码配置
//			String inputEncoding = properties.getProperty("velocity.input.encoding", "UTF-8");
//			String outputEncoding = properties.getProperty("velocity.output.encoding", "UTF-8");
//			pbuilderEngine.setProperty(Velocity.INPUT_ENCODING, inputEncoding);
//			pbuilderEngine.setProperty(Velocity.OUTPUT_ENCODING, outputEncoding);
			
			
			// 获取实现Service
			TableService<?> tableService = (TableService<?>) applicationContext
					.getBean(database + "TableService");
			ContextService contextService = applicationContext
					.getBean(ContextService.class);

			// 遍历查询表结构
			List<?> resultTables = tableService.listTable(schema,
					tables.split(","));
			resultTables.forEach(t -> {
				try {
					// 设置上下文
					contextService.setContext(t, velocityContext);

					// 执行模板引擎
					pbuilderEngine.evaluate(velocityContext, export,
							Application.class.getName(), tp);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});

			ScriptUtils.trigger("complete", new CompleteEvent(springApplication, tp));
			SpringApplication.exit(applicationContext);
			logger.info("[COMPLETE] : " + tp.getDirectory());
		});
		logger.debug("=======================END=========================");
	}

	public static List<TemplatePackage> scan(String path)
			throws FileNotFoundException {
		return scan(new File(path));
	}

	/**
	 * 扫描并返回文件夹下所有已启用的模板包
	 * 
	 * @param directory
	 *            目标文件夹
	 * @return
	 * @throws FileNotFoundException
	 */
	public static List<TemplatePackage> scan(File directory)
			throws FileNotFoundException {
		Objects.requireNonNull(directory, "directory");
		if (!directory.exists()) {
			throw new FileNotFoundException(directory.toString());
		}
		if (!directory.isDirectory()) {
			throw new IllegalArgumentException("not support");
		}
		return Stream.of(directory.listFiles(File::isDirectory))
				.map(TemplatePackage::new).filter(TemplatePackage::isEnable)
				.collect(Collectors.toList());
	}

}
