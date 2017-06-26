package com.afocus.pbuilder.mysql.model;

import java.util.function.Function;

import com.afocus.pbuilder.common.context.impl.ColumnImpl;
import com.afocus.pbuilder.common.model.BaseModel;

/**
 * COLUMNS
 * 
 * @author liuwu
 * @date 2015-09-07
 * @company afocus
 * @version 5.0
 */
@SuppressWarnings("serial")
public class Columns extends BaseModel {

	/** @column */
	private String tableCatalog;

	/** @column */
	private String tableSchema;

	/** @column */
	private String tableName;

	/** @column */
	private String columnName;

	/** @column */
	private Long ordinalPosition;

	/** @column */
	private String columnDefault;

	/** @column */
	private String isNullable;

	/** @column */
	private String dataType;

	/** @column */
	private Long characterMaximumLength;

	/** @column */
	private Long characterOctetLength;

	/** @column */
	private Long numericPrecision;

	/** @column */
	private Long numericScale;

	/** @column */
	private Long datetimePrecision;

	/** @column */
	private String characterSetName;

	/** @column */
	private String collationName;

	/** @column */
	private String columnType;

	/** @column */
	private String columnKey;

	/** @column */
	private String extra;

	/** @column */
	private String privileges;

	/** @column */
	private String columnComment;

	public Columns() {
	}

	/**
	 * 获取
	 */
	public String getTableCatalog() {
		return tableCatalog;
	}

	/**
	 * 设置
	 */
	public void setTableCatalog(String tableCatalog) {
		this.tableCatalog = tableCatalog;
	}

	/**
	 * 获取
	 */
	public String getTableSchema() {
		return tableSchema;
	}

	/**
	 * 设置
	 */
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	/**
	 * 获取
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * 设置
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * 获取
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * 设置
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * 获取
	 */
	public Long getOrdinalPosition() {
		return ordinalPosition;
	}

	/**
	 * 设置
	 */
	public void setOrdinalPosition(Long ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

	/**
	 * 获取
	 */
	public String getColumnDefault() {
		return columnDefault;
	}

	/**
	 * 设置
	 */
	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}

	/**
	 * 获取
	 */
	public String getIsNullable() {
		return isNullable;
	}

	/**
	 * 设置
	 */
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}

	/**
	 * 获取
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * 设置
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * 获取
	 */
	public Long getCharacterMaximumLength() {
		return characterMaximumLength;
	}

	/**
	 * 设置
	 */
	public void setCharacterMaximumLength(Long characterMaximumLength) {
		this.characterMaximumLength = characterMaximumLength;
	}

	/**
	 * 获取
	 */
	public Long getCharacterOctetLength() {
		return characterOctetLength;
	}

	/**
	 * 设置
	 */
	public void setCharacterOctetLength(Long characterOctetLength) {
		this.characterOctetLength = characterOctetLength;
	}

	/**
	 * 获取
	 */
	public Long getNumericPrecision() {
		return numericPrecision;
	}

	/**
	 * 设置
	 */
	public void setNumericPrecision(Long numericPrecision) {
		this.numericPrecision = numericPrecision;
	}

	/**
	 * 获取
	 */
	public Long getNumericScale() {
		return numericScale;
	}

	/**
	 * 设置
	 */
	public void setNumericScale(Long numericScale) {
		this.numericScale = numericScale;
	}

	/**
	 * 获取
	 */
	public Long getDatetimePrecision() {
		return datetimePrecision;
	}

	/**
	 * 设置
	 */
	public void setDatetimePrecision(Long datetimePrecision) {
		this.datetimePrecision = datetimePrecision;
	}

	/**
	 * 获取
	 */
	public String getCharacterSetName() {
		return characterSetName;
	}

	/**
	 * 设置
	 */
	public void setCharacterSetName(String characterSetName) {
		this.characterSetName = characterSetName;
	}

	/**
	 * 获取
	 */
	public String getCollationName() {
		return collationName;
	}

	/**
	 * 设置
	 */
	public void setCollationName(String collationName) {
		this.collationName = collationName;
	}

	/**
	 * 获取
	 */
	public String getColumnType() {
		return columnType;
	}

	/**
	 * 设置
	 */
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	/**
	 * 获取
	 */
	public String getColumnKey() {
		return columnKey;
	}

	/**
	 * 设置
	 */
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	/**
	 * 获取
	 */
	public String getExtra() {
		return extra;
	}

	/**
	 * 设置
	 */
	public void setExtra(String extra) {
		this.extra = extra;
	}

	/**
	 * 获取
	 */
	public String getPrivileges() {
		return privileges;
	}

	/**
	 * 设置
	 */
	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

	/**
	 * 获取
	 */
	public String getColumnComment() {
		return columnComment;
	}

	/**
	 * 设置
	 */
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Columns{").append("tableCatalog=")
				.append(tableCatalog).append(",tableSchema=")
				.append(tableSchema).append(",tableName=").append(tableName)
				.append(",columnName=").append(columnName)
				.append(",ordinalPosition=").append(ordinalPosition)
				.append(",columnDefault=").append(columnDefault)
				.append(",isNullable=").append(isNullable).append(",dataType=")
				.append(dataType).append(",characterMaximumLength=")
				.append(characterMaximumLength)
				.append(",characterOctetLength=").append(characterOctetLength)
				.append(",numericPrecision=").append(numericPrecision)
				.append(",numericScale=").append(numericScale)
				.append(",datetimePrecision=").append(datetimePrecision)
				.append(",characterSetName=").append(characterSetName)
				.append(",collationName=").append(collationName)
				.append(",columnType=").append(columnType)
				.append(",columnKey=").append(columnKey).append(",extra=")
				.append(extra).append(",privileges=").append(privileges)
				.append(",columnComment=").append(columnComment).append('}')
				.toString();
	}

	/**
	 * 比较字段： tableCatalog, tableSchema, tableName, columnName, ordinalPosition,
	 * columnDefault, isNullable, dataType, characterMaximumLength,
	 * characterOctetLength, numericPrecision, numericScale, datetimePrecision,
	 * characterSetName, collationName, columnType, columnKey, extra,
	 * privileges, columnComment
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Columns))
			return false;
		Columns v = (Columns) o;
		return (tableCatalog == null && v.tableCatalog == null || tableCatalog != null
				&& tableCatalog.equals(v.tableCatalog))
				&& (tableSchema == null && v.tableSchema == null || tableSchema != null
						&& tableSchema.equals(v.tableSchema))
				&& (tableName == null && v.tableName == null || tableName != null
						&& tableName.equals(v.tableName))
				&& (columnName == null && v.columnName == null || columnName != null
						&& columnName.equals(v.columnName))
				&& (ordinalPosition == null && v.ordinalPosition == null || ordinalPosition != null
						&& ordinalPosition.equals(v.ordinalPosition))
				&& (columnDefault == null && v.columnDefault == null || columnDefault != null
						&& columnDefault.equals(v.columnDefault))
				&& (isNullable == null && v.isNullable == null || isNullable != null
						&& isNullable.equals(v.isNullable))
				&& (dataType == null && v.dataType == null || dataType != null
						&& dataType.equals(v.dataType))
				&& (characterMaximumLength == null
						&& v.characterMaximumLength == null || characterMaximumLength != null
						&& characterMaximumLength
								.equals(v.characterMaximumLength))
				&& (characterOctetLength == null
						&& v.characterOctetLength == null || characterOctetLength != null
						&& characterOctetLength.equals(v.characterOctetLength))
				&& (numericPrecision == null && v.numericPrecision == null || numericPrecision != null
						&& numericPrecision.equals(v.numericPrecision))
				&& (numericScale == null && v.numericScale == null || numericScale != null
						&& numericScale.equals(v.numericScale))
				&& (datetimePrecision == null && v.datetimePrecision == null || datetimePrecision != null
						&& datetimePrecision.equals(v.datetimePrecision))
				&& (characterSetName == null && v.characterSetName == null || characterSetName != null
						&& characterSetName.equals(v.characterSetName))
				&& (collationName == null && v.collationName == null || collationName != null
						&& collationName.equals(v.collationName))
				&& (columnType == null && v.columnType == null || columnType != null
						&& columnType.equals(v.columnType))
				&& (columnKey == null && v.columnKey == null || columnKey != null
						&& columnKey.equals(v.columnKey))
				&& (extra == null && v.extra == null || extra != null
						&& extra.equals(v.extra))
				&& (privileges == null && v.privileges == null || privileges != null
						&& privileges.equals(v.privileges))
				&& (columnComment == null && v.columnComment == null || columnComment != null
						&& columnComment.equals(v.columnComment));
	}

	/**
	 * 散列字段： tableCatalog, tableSchema, tableName, columnName, ordinalPosition,
	 * columnDefault, isNullable, dataType, characterMaximumLength,
	 * characterOctetLength, numericPrecision, numericScale, datetimePrecision,
	 * characterSetName, collationName, columnType, columnKey, extra,
	 * privileges, columnComment
	 */
	public int hashCode() {
		int h = 1;
		h = 31 * h + (tableCatalog == null ? 0 : tableCatalog.hashCode());
		h = 31 * h + (tableSchema == null ? 0 : tableSchema.hashCode());
		h = 31 * h + (tableName == null ? 0 : tableName.hashCode());
		h = 31 * h + (columnName == null ? 0 : columnName.hashCode());
		h = 31 * h + (ordinalPosition == null ? 0 : ordinalPosition.hashCode());
		h = 31 * h + (columnDefault == null ? 0 : columnDefault.hashCode());
		h = 31 * h + (isNullable == null ? 0 : isNullable.hashCode());
		h = 31 * h + (dataType == null ? 0 : dataType.hashCode());
		h = 31
				* h
				+ (characterMaximumLength == null ? 0 : characterMaximumLength
						.hashCode());
		h = 31
				* h
				+ (characterOctetLength == null ? 0 : characterOctetLength
						.hashCode());
		h = 31 * h
				+ (numericPrecision == null ? 0 : numericPrecision.hashCode());
		h = 31 * h + (numericScale == null ? 0 : numericScale.hashCode());
		h = 31
				* h
				+ (datetimePrecision == null ? 0 : datetimePrecision.hashCode());
		h = 31 * h
				+ (characterSetName == null ? 0 : characterSetName.hashCode());
		h = 31 * h + (collationName == null ? 0 : collationName.hashCode());
		h = 31 * h + (columnType == null ? 0 : columnType.hashCode());
		h = 31 * h + (columnKey == null ? 0 : columnKey.hashCode());
		h = 31 * h + (extra == null ? 0 : extra.hashCode());
		h = 31 * h + (privileges == null ? 0 : privileges.hashCode());
		h = 31 * h + (columnComment == null ? 0 : columnComment.hashCode());
		return h;
	}

	/**
	 * 复制对象,复制了以下字段 tableCatalog, tableSchema, tableName, columnName,
	 * ordinalPosition, columnDefault, isNullable, dataType,
	 * characterMaximumLength, characterOctetLength, numericPrecision,
	 * numericScale, datetimePrecision, characterSetName, collationName,
	 * columnType, columnKey, extra, privileges, columnComment
	 */
	public Columns copy() {
		Columns m = new Columns();
		m.tableCatalog = tableCatalog;
		m.tableSchema = tableSchema;
		m.tableName = tableName;
		m.columnName = columnName;
		m.ordinalPosition = ordinalPosition;
		m.columnDefault = columnDefault;
		m.isNullable = isNullable;
		m.dataType = dataType;
		m.characterMaximumLength = characterMaximumLength;
		m.characterOctetLength = characterOctetLength;
		m.numericPrecision = numericPrecision;
		m.numericScale = numericScale;
		m.datetimePrecision = datetimePrecision;
		m.characterSetName = characterSetName;
		m.collationName = collationName;
		m.columnType = columnType;
		m.columnKey = columnKey;
		m.extra = extra;
		m.privileges = privileges;
		m.columnComment = columnComment;
		return m;
	}

	public ColumnImpl map(Function<Columns, ColumnImpl> mapper) {
		return mapper.apply(this);
	}
}
