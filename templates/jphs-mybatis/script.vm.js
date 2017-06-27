var Predicate = Java.type("java.util.function.Predicate");
var HashSet = Java.type("java.util.HashSet");

(function(global) {

	var context;
	var properties;
	var templatePackage;

	/**
	 * 初始化事件（这个事件触发时Spring还未初始化）
	 * event.properties : 当前模板包配置属性
	 * event.velocityContext : velocity上下文
	 * event.source : 当前模板包的TemplatePackage实例
	 *
	 * 1.在这里可以对模板包配置进行修改，
	 * 2.可以对上下文进行修改，如放入帮助类，放入常用变量等
	 * 3.可以通过TemplatePackage获取当前模板包里所有的模板
	 * 注意：event.source.config获取的配置属性和event.properties获取的不同
	 * event.source.config仅仅是当前模板包配置的属性，
	 * 而event.properties是正式运行模板包是的属性（包含了系统默认属性）
	 * 修改event.properties可以直接影响到运行是的配置，修改event.source.config对运行没有任何影响
	 */
	on("init", function(event) {

		logger.debug("=============init(Car2share)================");

		context = event.velocityContext;
		properties = event.properties;
		templatePackage = event.source;
		
		context.put("d", "$");
		context.put("s", ":");

		//把baseFields的类型更改为集合
		var baseFields = new HashSet();
		context.get("baseFields").split(",").forEach(function(e) {
			baseFields.add(e);
		});
		context.put("baseFields", baseFields);
	});

	/**
	 * 数据转换事件，event.from:转换前的对象，
	 * event.to转换后的对象，
	 * 可以在这里对对象的属性进行修改，即可以自定义转换规则
	 */
	on("transformer", function(event) {
		if (event.to instanceof Table) {
			if (event.from instanceof Tables) {
				if (event.from.tableType.indexOf('TABLE') != -1) {
					//表别名去掉系统前缀
					event.to.schema = event.to.schema.toUpperCase();
					event.to.name = event.to.name.toUpperCase();
					event.to.alias = event.to.alias.toUpperCase();
					context.put("group", event.to.name.split("_")[0].toLowerCase());
				} else {
					//视图别名去掉V+系统前缀
					event.to.schema = event.to.schema.toUpperCase();
					event.to.name = event.to.name.toUpperCase();
					event.to.alias = event.to.alias.substring(1).toUpperCase();
					context.put("group", event.to.name.split("_")[1].toLowerCase());
				}
				context.put("base", ["com", context.get("company"), context.get("project"),context.get("group")].join("."));
			}
		} else if (event.to instanceof Bean) {
			if (event.from instanceof Tables) {
				if (event.from.tableType.indexOf('TABLE') != -1) {
					event.to.name = StringUtils.toCamelCase(event.from.tableName, 0, true);
					event.to.alias = StringUtils.toCamelCase(event.from.tableName, 0, false);
				} else {event.to.name = StringUtils.toCamelCase(event.from.tableName, 1, true);
					event.to.alias = StringUtils.toCamelCase(event.from.tableName, 1, false);
				}
			}
		}
	});
	
	on("velocityContextPrepared", function(){
		var table = context.get("table");
		var skip = table.type === "TABLE" ? 0 : 1;
		var parts = table.name.split("_").slice(skip).map(function(e){
			return e.toLowerCase();
		});
		var path = parts.join("/");
		var strictPath = context.get("group") + "." + path;
		if(parts[0] != context.get("group")){
			path = context.get("group") + "/" + path;
		}
		var module = context.get("module");
		var location = context.get("module")+"/" + path;
		context.put("path", path);
		context.put("strictPath", strictPath);
		context.put("module", module);
		context.put("location", location);
	});

})(this);

