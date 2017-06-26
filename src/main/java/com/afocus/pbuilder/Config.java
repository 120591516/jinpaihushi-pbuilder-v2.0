package com.afocus.pbuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.afocus.pbuilder.common.utils.ScriptUtils;

@Component
public class Config {

	private static final String CONFIG_PATH = "/config/application.properties";

	private static VelocityContext CONTEXT = new VelocityContext();

	private static final String CONTEXT_PREFIX = "context.";

	private static final VelocityContext DEFAULT_CONTEXT = new VelocityContext();

	private static final Properties DEFAULT_PROPERTIES = new Properties();

	private static final Logger logger = Logger.getLogger(Config.class);

	private static Properties PROPERTIES = new Properties();

	// 初始化默认配置与上下文
	static {
		try {
			logger.debug("[load] classpath:" + CONFIG_PATH);
			DEFAULT_PROPERTIES.load(Config.class
					.getResourceAsStream(CONFIG_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		DEFAULT_CONTEXT.put("DateUtils", new DateUtils());
		DEFAULT_CONTEXT.put("toList", Collectors.toList());
		DEFAULT_CONTEXT.put("toSet", Collectors.toSet());
	}

	private static void copyPropertiesToContext() {
		for (Object _key : PROPERTIES.keySet()) {
			String key = _key.toString();
			if (key.startsWith(CONTEXT_PREFIX)) {
				String newKey = key.substring(CONTEXT_PREFIX.length());
				Object value = PROPERTIES.get(_key);
				CONTEXT.put(newKey, value);
			}
		}
	}

	public static Context getContext() {
		return CONTEXT;
	}

	public static Properties getProperties() {
		return PROPERTIES;
	}

	public static void init(TemplatePackage tp) {
		// 刷新上下文（清空原来的上下文，设置默认上下文）
		for (Object key : CONTEXT.getKeys()) {
			CONTEXT.remove(key);
		}
		for (Object key : DEFAULT_CONTEXT.getKeys()) {
			CONTEXT.put(key.toString(), DEFAULT_CONTEXT.get(key.toString()));
		}
		// 刷新配置属性（清空原来的配置属性，设置默认配置属性）
		PROPERTIES.clear();
		PROPERTIES.putAll(DEFAULT_PROPERTIES);
		// 把模板包的属性填入模板属性中去
		PROPERTIES.putAll(tp.getConfig());
		// 使用solution更新属性
		Config.useSolution();
		// 把配置属性中配置的上下文添加到上下文中去
		Config.copyPropertiesToContext();
		// 重新加载JavaScript
		Config.refreshJavascript();
		// 执行模板脚本
		tp.evalScript();
	}

	private static void refreshJavascript() {
		Stream.of(
				DEFAULT_PROPERTIES.getProperty("pbuilder.scripts", "").split(
						",")).forEach(
				js -> {
					try (InputStream jsStream = Config.class
							.getResourceAsStream(js)){
						logger.debug("[eval] " + js);
						ScriptUtils.getScriptEngine().eval(new InputStreamReader(jsStream));
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
	}

	private static Properties useSolution() {
		String solution = PROPERTIES.getProperty("solution", "");
		if (solution.isEmpty())
			return PROPERTIES;
		Map<String, String> map = new HashMap<String, String>();
		String prefix = "solution." + solution + '.';
		for (Object _key : PROPERTIES.keySet()) {
			String key = _key.toString();
			if (key.startsWith(prefix)) {
				String value = PROPERTIES.getProperty(key);
				String newKey = key.substring(prefix.length());
				map.put(newKey, value);
			}
		}
		PROPERTIES.putAll(map);
		return PROPERTIES;
	}

	/**
	 * 数据源配置
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(PROPERTIES.getProperty("jdbc.driverClassName"));
		bds.setUrl(PROPERTIES.getProperty("jdbc.url"));
		bds.setUsername(PROPERTIES.getProperty("jdbc.username"));
		bds.setPassword(PROPERTIES.getProperty("jdbc.password"));
		return bds;
	}

	/**
	 * myBatis Mapper Scanner 配置
	 * @return
	 */
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer msc = new MapperScannerConfigurer();
		msc.setBasePackage(PROPERTIES
				.getProperty("mybatis.MapperScannerConfigurer.basePackage"));
		return msc;
	}

	/**
	 * myBatis sqlSessionFactory 配置
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
		sfb.setDataSource(dataSource());
		sfb.setTypeAliasesPackage(PROPERTIES
				.getProperty("mybatis.sqlSessionFactory.typeAliasesPackage"));
		return sfb.getObject();
	}
}
