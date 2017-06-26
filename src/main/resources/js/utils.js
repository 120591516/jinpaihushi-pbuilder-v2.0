//通用工具包
(function(global) {

	var StringUtils = {};

	/**
	 * 转化为驼峰命名法命名的字段
	 * @param {Object} str 字符串
	 * @param {Object} skip 跳过的单词数
	 * @param {Object} isFirstCharUpper 是否首字母大写
	 */
	StringUtils.toCamelCase = function(str, skip, isFirstCharUpper) {
		var name = str.split('_').slice(skip).map(function(e){
			return e.charAt(0).toUpperCase() + e.substring(1).toLowerCase();
		}).join('');
		if(isFirstCharUpper){
			return name;
		}
		return name.charAt(0).toLowerCase() + name.substring(1);
	};

	global.StringUtils = StringUtils;
})(this); 