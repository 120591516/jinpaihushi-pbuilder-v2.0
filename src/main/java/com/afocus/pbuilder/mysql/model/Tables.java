package com.afocus.pbuilder.mysql.model;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

import com.afocus.pbuilder.common.context.impl.TableImpl;
import com.afocus.pbuilder.common.model.BaseModel;

/**
 * TABLES 
 * 
 * @author liuwu
 * @date 2015-09-07
 * @company afocus
 * @version 5.0
 */
@SuppressWarnings("serial")
public class Tables extends BaseModel{
	

    /** @column  */
	private String tableCatalog;

    /** @column  */
	private String tableSchema;

    /** @column  */
	private String tableName;

    /** @column  */
	private String tableType;

    /** @column  */
	private String engine;

    /** @column  */
	private Long version;

    /** @column  */
	private String rowFormat;

    /** @column  */
	private Long tableRows;

    /** @column  */
	private Long avgRowLength;

    /** @column  */
	private Long dataLength;

    /** @column  */
	private Long maxDataLength;

    /** @column  */
	private Long indexLength;

    /** @column  */
	private Long dataFree;

    /** @column  */
	private Long autoIncrement;

    /** @column  */
	private Date createTime;

    /** @column  */
	private Date updateTime;

    /** @column  */
	private Date checkTime;

    /** @column  */
	private String tableCollation;

    /** @column  */
	private Long checksum;

    /** @column  */
	private String createOptions;

    /** @column  */
	private String tableComment;
	
	private List<Columns> columnsList;

	public Tables(){}


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
	public String getTableType() {
    	return tableType;
    }
  	
	/**
	 * 设置
	 */
	public void setTableType(String tableType) {
    	this.tableType = tableType;
    }

	/**
	 * 获取
	 */
	public String getEngine() {
    	return engine;
    }
  	
	/**
	 * 设置
	 */
	public void setEngine(String engine) {
    	this.engine = engine;
    }

	/**
	 * 获取
	 */
	public Long getVersion() {
    	return version;
    }
  	
	/**
	 * 设置
	 */
	public void setVersion(Long version) {
    	this.version = version;
    }

	/**
	 * 获取
	 */
	public String getRowFormat() {
    	return rowFormat;
    }
  	
	/**
	 * 设置
	 */
	public void setRowFormat(String rowFormat) {
    	this.rowFormat = rowFormat;
    }

	/**
	 * 获取
	 */
	public Long getTableRows() {
    	return tableRows;
    }
  	
	/**
	 * 设置
	 */
	public void setTableRows(Long tableRows) {
    	this.tableRows = tableRows;
    }

	/**
	 * 获取
	 */
	public Long getAvgRowLength() {
    	return avgRowLength;
    }
  	
	/**
	 * 设置
	 */
	public void setAvgRowLength(Long avgRowLength) {
    	this.avgRowLength = avgRowLength;
    }

	/**
	 * 获取
	 */
	public Long getDataLength() {
    	return dataLength;
    }
  	
	/**
	 * 设置
	 */
	public void setDataLength(Long dataLength) {
    	this.dataLength = dataLength;
    }

	/**
	 * 获取
	 */
	public Long getMaxDataLength() {
    	return maxDataLength;
    }
  	
	/**
	 * 设置
	 */
	public void setMaxDataLength(Long maxDataLength) {
    	this.maxDataLength = maxDataLength;
    }

	/**
	 * 获取
	 */
	public Long getIndexLength() {
    	return indexLength;
    }
  	
	/**
	 * 设置
	 */
	public void setIndexLength(Long indexLength) {
    	this.indexLength = indexLength;
    }

	/**
	 * 获取
	 */
	public Long getDataFree() {
    	return dataFree;
    }
  	
	/**
	 * 设置
	 */
	public void setDataFree(Long dataFree) {
    	this.dataFree = dataFree;
    }

	/**
	 * 获取
	 */
	public Long getAutoIncrement() {
    	return autoIncrement;
    }
  	
	/**
	 * 设置
	 */
	public void setAutoIncrement(Long autoIncrement) {
    	this.autoIncrement = autoIncrement;
    }

	/**
	 * 获取
	 */
	public Date getCreateTime() {
    	return createTime;
    }
  	
	/**
	 * 设置
	 */
	public void setCreateTime(Date createTime) {
    	this.createTime = createTime;
    }

	/**
	 * 获取
	 */
	public Date getUpdateTime() {
    	return updateTime;
    }
  	
	/**
	 * 设置
	 */
	public void setUpdateTime(Date updateTime) {
    	this.updateTime = updateTime;
    }

	/**
	 * 获取
	 */
	public Date getCheckTime() {
    	return checkTime;
    }
  	
	/**
	 * 设置
	 */
	public void setCheckTime(Date checkTime) {
    	this.checkTime = checkTime;
    }

	/**
	 * 获取
	 */
	public String getTableCollation() {
    	return tableCollation;
    }
  	
	/**
	 * 设置
	 */
	public void setTableCollation(String tableCollation) {
    	this.tableCollation = tableCollation;
    }

	/**
	 * 获取
	 */
	public Long getChecksum() {
    	return checksum;
    }
  	
	/**
	 * 设置
	 */
	public void setChecksum(Long checksum) {
    	this.checksum = checksum;
    }

	/**
	 * 获取
	 */
	public String getCreateOptions() {
    	return createOptions;
    }
  	
	/**
	 * 设置
	 */
	public void setCreateOptions(String createOptions) {
    	this.createOptions = createOptions;
    }

	/**
	 * 获取
	 */
	public String getTableComment() {
    	return tableComment;
    }
  	
	/**
	 * 设置
	 */
	public void setTableComment(String tableComment) {
    	this.tableComment = tableComment;
    }

	@Override
    public String toString() {
		return new StringBuilder().append("Tables{").
			append("tableCatalog=").append(tableCatalog).
			append(",tableSchema=").append(tableSchema).
			append(",tableName=").append(tableName).
			append(",tableType=").append(tableType).
			append(",engine=").append(engine).
			append(",version=").append(version).
			append(",rowFormat=").append(rowFormat).
			append(",tableRows=").append(tableRows).
			append(",avgRowLength=").append(avgRowLength).
			append(",dataLength=").append(dataLength).
			append(",maxDataLength=").append(maxDataLength).
			append(",indexLength=").append(indexLength).
			append(",dataFree=").append(dataFree).
			append(",autoIncrement=").append(autoIncrement).
			append(",createTime=").append(createTime).
			append(",updateTime=").append(updateTime).
			append(",checkTime=").append(checkTime).
			append(",tableCollation=").append(tableCollation).
			append(",checksum=").append(checksum).
			append(",createOptions=").append(createOptions).
			append(",tableComment=").append(tableComment).
			append('}').toString();
    }
    
    /**
	 * 比较字段：
	 * tableCatalog, tableSchema, tableName, tableType, engine,
	 * version, rowFormat, tableRows, avgRowLength, dataLength,
	 * maxDataLength, indexLength, dataFree, autoIncrement, createTime,
	 * updateTime, checkTime, tableCollation, checksum, createOptions,
	 * tableComment
	 */
	public boolean equals(Object o){
		if(!(o instanceof Tables)) return false;
		Tables v = (Tables)o;
		return (tableCatalog==null && v.tableCatalog==null || tableCatalog != null && tableCatalog.equals(v.tableCatalog))
			&& (tableSchema==null && v.tableSchema==null || tableSchema != null && tableSchema.equals(v.tableSchema))
			&& (tableName==null && v.tableName==null || tableName != null && tableName.equals(v.tableName))
			&& (tableType==null && v.tableType==null || tableType != null && tableType.equals(v.tableType))
			&& (engine==null && v.engine==null || engine != null && engine.equals(v.engine))
			&& (version==null && v.version==null || version != null && version.equals(v.version))
			&& (rowFormat==null && v.rowFormat==null || rowFormat != null && rowFormat.equals(v.rowFormat))
			&& (tableRows==null && v.tableRows==null || tableRows != null && tableRows.equals(v.tableRows))
			&& (avgRowLength==null && v.avgRowLength==null || avgRowLength != null && avgRowLength.equals(v.avgRowLength))
			&& (dataLength==null && v.dataLength==null || dataLength != null && dataLength.equals(v.dataLength))
			&& (maxDataLength==null && v.maxDataLength==null || maxDataLength != null && maxDataLength.equals(v.maxDataLength))
			&& (indexLength==null && v.indexLength==null || indexLength != null && indexLength.equals(v.indexLength))
			&& (dataFree==null && v.dataFree==null || dataFree != null && dataFree.equals(v.dataFree))
			&& (autoIncrement==null && v.autoIncrement==null || autoIncrement != null && autoIncrement.equals(v.autoIncrement))
			&& (createTime==null && v.createTime==null || createTime != null && createTime.equals(v.createTime))
			&& (updateTime==null && v.updateTime==null || updateTime != null && updateTime.equals(v.updateTime))
			&& (checkTime==null && v.checkTime==null || checkTime != null && checkTime.equals(v.checkTime))
			&& (tableCollation==null && v.tableCollation==null || tableCollation != null && tableCollation.equals(v.tableCollation))
			&& (checksum==null && v.checksum==null || checksum != null && checksum.equals(v.checksum))
			&& (createOptions==null && v.createOptions==null || createOptions != null && createOptions.equals(v.createOptions))
			&& (tableComment==null && v.tableComment==null || tableComment != null && tableComment.equals(v.tableComment))
		;
	}
	
	/**
	 * 散列字段：
	 * tableCatalog, tableSchema, tableName, tableType, engine,
	 * version, rowFormat, tableRows, avgRowLength, dataLength,
	 * maxDataLength, indexLength, dataFree, autoIncrement, createTime,
	 * updateTime, checkTime, tableCollation, checksum, createOptions,
	 * tableComment
	 */
	public int hashCode(){
		int h = 1;
		h = 31 * h + (tableCatalog==null ? 0 : tableCatalog.hashCode());
		h = 31 * h + (tableSchema==null ? 0 : tableSchema.hashCode());
		h = 31 * h + (tableName==null ? 0 : tableName.hashCode());
		h = 31 * h + (tableType==null ? 0 : tableType.hashCode());
		h = 31 * h + (engine==null ? 0 : engine.hashCode());
		h = 31 * h + (version==null ? 0 : version.hashCode());
		h = 31 * h + (rowFormat==null ? 0 : rowFormat.hashCode());
		h = 31 * h + (tableRows==null ? 0 : tableRows.hashCode());
		h = 31 * h + (avgRowLength==null ? 0 : avgRowLength.hashCode());
		h = 31 * h + (dataLength==null ? 0 : dataLength.hashCode());
		h = 31 * h + (maxDataLength==null ? 0 : maxDataLength.hashCode());
		h = 31 * h + (indexLength==null ? 0 : indexLength.hashCode());
		h = 31 * h + (dataFree==null ? 0 : dataFree.hashCode());
		h = 31 * h + (autoIncrement==null ? 0 : autoIncrement.hashCode());
		h = 31 * h + (createTime==null ? 0 : createTime.hashCode());
		h = 31 * h + (updateTime==null ? 0 : updateTime.hashCode());
		h = 31 * h + (checkTime==null ? 0 : checkTime.hashCode());
		h = 31 * h + (tableCollation==null ? 0 : tableCollation.hashCode());
		h = 31 * h + (checksum==null ? 0 : checksum.hashCode());
		h = 31 * h + (createOptions==null ? 0 : createOptions.hashCode());
		h = 31 * h + (tableComment==null ? 0 : tableComment.hashCode());
		return h;
	}
	
	/**
	 * 复制对象,复制了以下字段
	 * tableCatalog, tableSchema, tableName, tableType, engine,
	 * version, rowFormat, tableRows, avgRowLength, dataLength,
	 * maxDataLength, indexLength, dataFree, autoIncrement, createTime,
	 * updateTime, checkTime, tableCollation, checksum, createOptions,
	 * tableComment
	 */
	public Tables copy(){
		Tables m = new Tables();
     	m.tableCatalog = tableCatalog;
     	m.tableSchema = tableSchema;
     	m.tableName = tableName;
     	m.tableType = tableType;
     	m.engine = engine;
     	m.version = version;
     	m.rowFormat = rowFormat;
     	m.tableRows = tableRows;
     	m.avgRowLength = avgRowLength;
     	m.dataLength = dataLength;
     	m.maxDataLength = maxDataLength;
     	m.indexLength = indexLength;
     	m.dataFree = dataFree;
     	m.autoIncrement = autoIncrement;
     	m.createTime = createTime;
     	m.updateTime = updateTime;
     	m.checkTime = checkTime;
     	m.tableCollation = tableCollation;
     	m.checksum = checksum;
     	m.createOptions = createOptions;
     	m.tableComment = tableComment;
		return m;
	}

	public List<Columns> getColumnsList() {
		return columnsList;
	}
	
	public void setColumnsList(List<Columns> columnsList) {
		this.columnsList = columnsList;
	}
	
	public TableImpl map(Function<Tables, TableImpl> mapper){
		return mapper.apply(this);
	}
}
