//common model
var Table = Java.type("com.afocus.pbuilder.common.context.Table");
var Column = Java.type("com.afocus.pbuilder.common.context.Column");
var Bean = Java.type("com.afocus.pbuilder.common.context.Bean");
var Field = Java.type("com.afocus.pbuilder.common.context.Field");

//mysql model
var Tables = Java.type("com.afocus.pbuilder.mysql.model.Tables");
var Columns = Java.type("com.afocus.pbuilder.mysql.model.Columns");

//oracle model
var UserTables = Java.type("com.afocus.pbuilder.oracle.model.UserTables");
var UserViews = Java.type("com.afocus.pbuilder.oracle.model.UserViews");
var UserTabOrViews = Java.type("com.afocus.pbuilder.oracle.model.UserTabOrViews");
var UserTabColumns = Java.type("com.afocus.pbuilder.oracle.model.UserTabColumns");

//log4j
var Logger = Java.type("org.apache.log4j.Logger");
var logger = Logger.getLogger("NashornScriptEngine");

(function(global) {

	var registeredListeners = {};

	/**
	 * 注册单个监听器 
	 */
	function registerListener(eventType, listener) {
		var listeners = registeredListeners[eventType];
		if (!listeners) {
			registeredListeners[eventType] = [listener];
		} else {
			listeners.push(listener);
		}
	}

	/**
	 * 触发事件 
	 * @param {String} eventType 事件类型
	 * @param {Object} event 任意对象
	 */
	function trigger(eventType, event) {
		var listeners = registeredListeners[eventType];
		if (!listeners)
			return;
		listeners.forEach(function(listener) {
			listener(event);
		});
	}

	/**
	 * 监听事件 
	 * @param {Object} eventTypes 事件类型，多个事件用空格隔开
	 * @param {Object} callback 事件回调函数 function(event){...}
	 */
	function on(eventTypes, callback) {
		if (!eventTypes || !callback || typeof callback != 'function') {
			return;
		}
		eventTypes.split(" ").forEach(function(eventType) {
			if (!!eventType) {
				registerListener(eventType, callback);
			}
		});
	}

	global.trigger = trigger;
	global.on = on;

})(this);

