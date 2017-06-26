package com.afocus.pbuilder.oracle.model;

import java.util.Date;
import com.afocus.pbuilder.common.model.BaseModel;

/**
 * DBA_TAB_COLS Columns of user's tables, views and clusters
 * 
 * @author liuwu
 * @date 2015-09-11
 * @company afocus
 * @version 5.0
 */
@SuppressWarnings("serial")
public class DbaTabCols extends BaseModel{
	

    /** @column  */
	private String owner;

    /** @column Table, view or cluster name */
	private String tableName;

    /** @column Column name */
	private String columnName;

    /** @column Datatype of the column */
	private String dataType;

    /** @column Datatype modifier of the column */
	private String dataTypeMod;

    /** @column Owner of the datatype of the column */
	private String dataTypeOwner;

    /** @column Length of the column in bytes */
	private Integer dataLength;

    /** @column Length: decimal digits (NUMBER) or binary digits (FLOAT) */
	private Integer dataPrecision;

    /** @column Digits to right of decimal point in a number */
	private Integer dataScale;

    /** @column Does column allow NULL values? */
	private String nullable;

    /** @column Sequence number of the column as created */
	private Integer columnId;

    /** @column Length of default value for the column */
	private Integer defaultLength;

    /** @column Default value for the column */
	private String dataDefault;

    /** @column The number of distinct values in the column */
	private Integer numDistinct;

    /** @column The low value in the column */
	private String lowValue;

    /** @column The high value in the column */
	private String highValue;

    /** @column The density of the column */
	private Integer density;

    /** @column The number of nulls in the column */
	private Integer numNulls;

    /** @column The number of buckets in histogram for the column */
	private Integer numBuckets;

    /** @column The date of the most recent time this column was analyzed */
	private Date lastAnalyzed;

    /** @column The sample size used in analyzing this column */
	private Integer sampleSize;

    /** @column Character set name */
	private String characterSetName;

    /** @column Declaration length of character type column */
	private Integer charColDeclLength;

    /** @column Are the statistics calculated without merging underlying partitions? */
	private String globalStats;

    /** @column Were the statistics entered directly by the user? */
	private String userStats;

    /** @column The average length of the column in bytes */
	private Integer avgColLen;

    /** @column The maximum length of the column in characters */
	private Integer charLength;

    /** @column C if the width was specified in characters, B if in bytes */
	private String charUsed;

    /** @column Is column data in 8.0 image format? */
	private String v80FmtImage;

    /** @column Has column data been upgraded to the latest type version format? */
	private String dataUpgraded;

    /** @column Is this a hidden column? */
	private String hiddenColumn;

    /** @column Is this a virtual column? */
	private String virtualColumn;

    /** @column Sequence number of the column in the segment */
	private Integer segmentColumnId;

    /** @column Internal sequence number of the column */
	private Integer internalColumnId;

    /** @column  */
	private String histogram;

    /** @column Qualified column name */
	private String qualifiedColName;

	public DbaTabCols(){}


	/**
	 * 获取
	 */
	public String getOwner() {
    	return owner;
    }
  	
	/**
	 * 设置
	 */
	public void setOwner(String owner) {
    	this.owner = owner;
    }

	/**
	 * 获取Table, view or cluster name
	 */
	public String getTableName() {
    	return tableName;
    }
  	
	/**
	 * 设置Table, view or cluster name
	 */
	public void setTableName(String tableName) {
    	this.tableName = tableName;
    }

	/**
	 * 获取Column name
	 */
	public String getColumnName() {
    	return columnName;
    }
  	
	/**
	 * 设置Column name
	 */
	public void setColumnName(String columnName) {
    	this.columnName = columnName;
    }

	/**
	 * 获取Datatype of the column
	 */
	public String getDataType() {
    	return dataType;
    }
  	
	/**
	 * 设置Datatype of the column
	 */
	public void setDataType(String dataType) {
    	this.dataType = dataType;
    }

	/**
	 * 获取Datatype modifier of the column
	 */
	public String getDataTypeMod() {
    	return dataTypeMod;
    }
  	
	/**
	 * 设置Datatype modifier of the column
	 */
	public void setDataTypeMod(String dataTypeMod) {
    	this.dataTypeMod = dataTypeMod;
    }

	/**
	 * 获取Owner of the datatype of the column
	 */
	public String getDataTypeOwner() {
    	return dataTypeOwner;
    }
  	
	/**
	 * 设置Owner of the datatype of the column
	 */
	public void setDataTypeOwner(String dataTypeOwner) {
    	this.dataTypeOwner = dataTypeOwner;
    }

	/**
	 * 获取Length of the column in bytes
	 */
	public Integer getDataLength() {
    	return dataLength;
    }
  	
	/**
	 * 设置Length of the column in bytes
	 */
	public void setDataLength(Integer dataLength) {
    	this.dataLength = dataLength;
    }

	/**
	 * 获取Length: decimal digits (NUMBER) or binary digits (FLOAT)
	 */
	public Integer getDataPrecision() {
    	return dataPrecision;
    }
  	
	/**
	 * 设置Length: decimal digits (NUMBER) or binary digits (FLOAT)
	 */
	public void setDataPrecision(Integer dataPrecision) {
    	this.dataPrecision = dataPrecision;
    }

	/**
	 * 获取Digits to right of decimal point in a number
	 */
	public Integer getDataScale() {
    	return dataScale;
    }
  	
	/**
	 * 设置Digits to right of decimal point in a number
	 */
	public void setDataScale(Integer dataScale) {
    	this.dataScale = dataScale;
    }

	/**
	 * 获取Does column allow NULL values?
	 */
	public String getNullable() {
    	return nullable;
    }
  	
	/**
	 * 设置Does column allow NULL values?
	 */
	public void setNullable(String nullable) {
    	this.nullable = nullable;
    }

	/**
	 * 获取Sequence number of the column as created
	 */
	public Integer getColumnId() {
    	return columnId;
    }
  	
	/**
	 * 设置Sequence number of the column as created
	 */
	public void setColumnId(Integer columnId) {
    	this.columnId = columnId;
    }

	/**
	 * 获取Length of default value for the column
	 */
	public Integer getDefaultLength() {
    	return defaultLength;
    }
  	
	/**
	 * 设置Length of default value for the column
	 */
	public void setDefaultLength(Integer defaultLength) {
    	this.defaultLength = defaultLength;
    }

	/**
	 * 获取Default value for the column
	 */
	public String getDataDefault() {
    	return dataDefault;
    }
  	
	/**
	 * 设置Default value for the column
	 */
	public void setDataDefault(String dataDefault) {
    	this.dataDefault = dataDefault;
    }

	/**
	 * 获取The number of distinct values in the column
	 */
	public Integer getNumDistinct() {
    	return numDistinct;
    }
  	
	/**
	 * 设置The number of distinct values in the column
	 */
	public void setNumDistinct(Integer numDistinct) {
    	this.numDistinct = numDistinct;
    }

	/**
	 * 获取The low value in the column
	 */
	public String getLowValue() {
    	return lowValue;
    }
  	
	/**
	 * 设置The low value in the column
	 */
	public void setLowValue(String lowValue) {
    	this.lowValue = lowValue;
    }

	/**
	 * 获取The high value in the column
	 */
	public String getHighValue() {
    	return highValue;
    }
  	
	/**
	 * 设置The high value in the column
	 */
	public void setHighValue(String highValue) {
    	this.highValue = highValue;
    }

	/**
	 * 获取The density of the column
	 */
	public Integer getDensity() {
    	return density;
    }
  	
	/**
	 * 设置The density of the column
	 */
	public void setDensity(Integer density) {
    	this.density = density;
    }

	/**
	 * 获取The number of nulls in the column
	 */
	public Integer getNumNulls() {
    	return numNulls;
    }
  	
	/**
	 * 设置The number of nulls in the column
	 */
	public void setNumNulls(Integer numNulls) {
    	this.numNulls = numNulls;
    }

	/**
	 * 获取The number of buckets in histogram for the column
	 */
	public Integer getNumBuckets() {
    	return numBuckets;
    }
  	
	/**
	 * 设置The number of buckets in histogram for the column
	 */
	public void setNumBuckets(Integer numBuckets) {
    	this.numBuckets = numBuckets;
    }

	/**
	 * 获取The date of the most recent time this column was analyzed
	 */
	public Date getLastAnalyzed() {
    	return lastAnalyzed;
    }
  	
	/**
	 * 设置The date of the most recent time this column was analyzed
	 */
	public void setLastAnalyzed(Date lastAnalyzed) {
    	this.lastAnalyzed = lastAnalyzed;
    }

	/**
	 * 获取The sample size used in analyzing this column
	 */
	public Integer getSampleSize() {
    	return sampleSize;
    }
  	
	/**
	 * 设置The sample size used in analyzing this column
	 */
	public void setSampleSize(Integer sampleSize) {
    	this.sampleSize = sampleSize;
    }

	/**
	 * 获取Character set name
	 */
	public String getCharacterSetName() {
    	return characterSetName;
    }
  	
	/**
	 * 设置Character set name
	 */
	public void setCharacterSetName(String characterSetName) {
    	this.characterSetName = characterSetName;
    }

	/**
	 * 获取Declaration length of character type column
	 */
	public Integer getCharColDeclLength() {
    	return charColDeclLength;
    }
  	
	/**
	 * 设置Declaration length of character type column
	 */
	public void setCharColDeclLength(Integer charColDeclLength) {
    	this.charColDeclLength = charColDeclLength;
    }

	/**
	 * 获取Are the statistics calculated without merging underlying partitions?
	 */
	public String getGlobalStats() {
    	return globalStats;
    }
  	
	/**
	 * 设置Are the statistics calculated without merging underlying partitions?
	 */
	public void setGlobalStats(String globalStats) {
    	this.globalStats = globalStats;
    }

	/**
	 * 获取Were the statistics entered directly by the user?
	 */
	public String getUserStats() {
    	return userStats;
    }
  	
	/**
	 * 设置Were the statistics entered directly by the user?
	 */
	public void setUserStats(String userStats) {
    	this.userStats = userStats;
    }

	/**
	 * 获取The average length of the column in bytes
	 */
	public Integer getAvgColLen() {
    	return avgColLen;
    }
  	
	/**
	 * 设置The average length of the column in bytes
	 */
	public void setAvgColLen(Integer avgColLen) {
    	this.avgColLen = avgColLen;
    }

	/**
	 * 获取The maximum length of the column in characters
	 */
	public Integer getCharLength() {
    	return charLength;
    }
  	
	/**
	 * 设置The maximum length of the column in characters
	 */
	public void setCharLength(Integer charLength) {
    	this.charLength = charLength;
    }

	/**
	 * 获取C if the width was specified in characters, B if in bytes
	 */
	public String getCharUsed() {
    	return charUsed;
    }
  	
	/**
	 * 设置C if the width was specified in characters, B if in bytes
	 */
	public void setCharUsed(String charUsed) {
    	this.charUsed = charUsed;
    }

	/**
	 * 获取Is column data in 8.0 image format?
	 */
	public String getV80FmtImage() {
    	return v80FmtImage;
    }
  	
	/**
	 * 设置Is column data in 8.0 image format?
	 */
	public void setV80FmtImage(String v80FmtImage) {
    	this.v80FmtImage = v80FmtImage;
    }

	/**
	 * 获取Has column data been upgraded to the latest type version format?
	 */
	public String getDataUpgraded() {
    	return dataUpgraded;
    }
  	
	/**
	 * 设置Has column data been upgraded to the latest type version format?
	 */
	public void setDataUpgraded(String dataUpgraded) {
    	this.dataUpgraded = dataUpgraded;
    }

	/**
	 * 获取Is this a hidden column?
	 */
	public String getHiddenColumn() {
    	return hiddenColumn;
    }
  	
	/**
	 * 设置Is this a hidden column?
	 */
	public void setHiddenColumn(String hiddenColumn) {
    	this.hiddenColumn = hiddenColumn;
    }

	/**
	 * 获取Is this a virtual column?
	 */
	public String getVirtualColumn() {
    	return virtualColumn;
    }
  	
	/**
	 * 设置Is this a virtual column?
	 */
	public void setVirtualColumn(String virtualColumn) {
    	this.virtualColumn = virtualColumn;
    }

	/**
	 * 获取Sequence number of the column in the segment
	 */
	public Integer getSegmentColumnId() {
    	return segmentColumnId;
    }
  	
	/**
	 * 设置Sequence number of the column in the segment
	 */
	public void setSegmentColumnId(Integer segmentColumnId) {
    	this.segmentColumnId = segmentColumnId;
    }

	/**
	 * 获取Internal sequence number of the column
	 */
	public Integer getInternalColumnId() {
    	return internalColumnId;
    }
  	
	/**
	 * 设置Internal sequence number of the column
	 */
	public void setInternalColumnId(Integer internalColumnId) {
    	this.internalColumnId = internalColumnId;
    }

	/**
	 * 获取
	 */
	public String getHistogram() {
    	return histogram;
    }
  	
	/**
	 * 设置
	 */
	public void setHistogram(String histogram) {
    	this.histogram = histogram;
    }

	/**
	 * 获取Qualified column name
	 */
	public String getQualifiedColName() {
    	return qualifiedColName;
    }
  	
	/**
	 * 设置Qualified column name
	 */
	public void setQualifiedColName(String qualifiedColName) {
    	this.qualifiedColName = qualifiedColName;
    }

	@Override
    public String toString() {
		return new StringBuilder().append("DbaTabCols{").
			append("owner=").append(owner).
			append(",tableName=").append(tableName).
			append(",columnName=").append(columnName).
			append(",dataType=").append(dataType).
			append(",dataTypeMod=").append(dataTypeMod).
			append(",dataTypeOwner=").append(dataTypeOwner).
			append(",dataLength=").append(dataLength).
			append(",dataPrecision=").append(dataPrecision).
			append(",dataScale=").append(dataScale).
			append(",nullable=").append(nullable).
			append(",columnId=").append(columnId).
			append(",defaultLength=").append(defaultLength).
			append(",dataDefault=").append(dataDefault).
			append(",numDistinct=").append(numDistinct).
			append(",lowValue=").append(lowValue).
			append(",highValue=").append(highValue).
			append(",density=").append(density).
			append(",numNulls=").append(numNulls).
			append(",numBuckets=").append(numBuckets).
			append(",lastAnalyzed=").append(lastAnalyzed).
			append(",sampleSize=").append(sampleSize).
			append(",characterSetName=").append(characterSetName).
			append(",charColDeclLength=").append(charColDeclLength).
			append(",globalStats=").append(globalStats).
			append(",userStats=").append(userStats).
			append(",avgColLen=").append(avgColLen).
			append(",charLength=").append(charLength).
			append(",charUsed=").append(charUsed).
			append(",v80FmtImage=").append(v80FmtImage).
			append(",dataUpgraded=").append(dataUpgraded).
			append(",hiddenColumn=").append(hiddenColumn).
			append(",virtualColumn=").append(virtualColumn).
			append(",segmentColumnId=").append(segmentColumnId).
			append(",internalColumnId=").append(internalColumnId).
			append(",histogram=").append(histogram).
			append(",qualifiedColName=").append(qualifiedColName).
			append('}').toString();
    }
    
    /**
	 * 比较字段：
	 * owner, tableName, columnName, dataType, dataTypeMod,
	 * dataTypeOwner, dataLength, dataPrecision, dataScale, nullable,
	 * columnId, defaultLength, dataDefault, numDistinct, lowValue,
	 * highValue, density, numNulls, numBuckets, lastAnalyzed,
	 * sampleSize, characterSetName, charColDeclLength, globalStats, userStats,
	 * avgColLen, charLength, charUsed, v80FmtImage, dataUpgraded,
	 * hiddenColumn, virtualColumn, segmentColumnId, internalColumnId, histogram,
	 * qualifiedColName
	 */
	public boolean equals(Object o){
		if(!(o instanceof DbaTabCols)) return false;
		DbaTabCols v = (DbaTabCols)o;
		return (owner==null && v.owner==null || owner != null && owner.equals(v.owner))
			&& (tableName==null && v.tableName==null || tableName != null && tableName.equals(v.tableName))
			&& (columnName==null && v.columnName==null || columnName != null && columnName.equals(v.columnName))
			&& (dataType==null && v.dataType==null || dataType != null && dataType.equals(v.dataType))
			&& (dataTypeMod==null && v.dataTypeMod==null || dataTypeMod != null && dataTypeMod.equals(v.dataTypeMod))
			&& (dataTypeOwner==null && v.dataTypeOwner==null || dataTypeOwner != null && dataTypeOwner.equals(v.dataTypeOwner))
			&& (dataLength==null && v.dataLength==null || dataLength != null && dataLength.equals(v.dataLength))
			&& (dataPrecision==null && v.dataPrecision==null || dataPrecision != null && dataPrecision.equals(v.dataPrecision))
			&& (dataScale==null && v.dataScale==null || dataScale != null && dataScale.equals(v.dataScale))
			&& (nullable==null && v.nullable==null || nullable != null && nullable.equals(v.nullable))
			&& (columnId==null && v.columnId==null || columnId != null && columnId.equals(v.columnId))
			&& (defaultLength==null && v.defaultLength==null || defaultLength != null && defaultLength.equals(v.defaultLength))
			&& (dataDefault==null && v.dataDefault==null || dataDefault != null && dataDefault.equals(v.dataDefault))
			&& (numDistinct==null && v.numDistinct==null || numDistinct != null && numDistinct.equals(v.numDistinct))
			&& (lowValue==null && v.lowValue==null || lowValue != null && lowValue.equals(v.lowValue))
			&& (highValue==null && v.highValue==null || highValue != null && highValue.equals(v.highValue))
			&& (density==null && v.density==null || density != null && density.equals(v.density))
			&& (numNulls==null && v.numNulls==null || numNulls != null && numNulls.equals(v.numNulls))
			&& (numBuckets==null && v.numBuckets==null || numBuckets != null && numBuckets.equals(v.numBuckets))
			&& (lastAnalyzed==null && v.lastAnalyzed==null || lastAnalyzed != null && lastAnalyzed.equals(v.lastAnalyzed))
			&& (sampleSize==null && v.sampleSize==null || sampleSize != null && sampleSize.equals(v.sampleSize))
			&& (characterSetName==null && v.characterSetName==null || characterSetName != null && characterSetName.equals(v.characterSetName))
			&& (charColDeclLength==null && v.charColDeclLength==null || charColDeclLength != null && charColDeclLength.equals(v.charColDeclLength))
			&& (globalStats==null && v.globalStats==null || globalStats != null && globalStats.equals(v.globalStats))
			&& (userStats==null && v.userStats==null || userStats != null && userStats.equals(v.userStats))
			&& (avgColLen==null && v.avgColLen==null || avgColLen != null && avgColLen.equals(v.avgColLen))
			&& (charLength==null && v.charLength==null || charLength != null && charLength.equals(v.charLength))
			&& (charUsed==null && v.charUsed==null || charUsed != null && charUsed.equals(v.charUsed))
			&& (v80FmtImage==null && v.v80FmtImage==null || v80FmtImage != null && v80FmtImage.equals(v.v80FmtImage))
			&& (dataUpgraded==null && v.dataUpgraded==null || dataUpgraded != null && dataUpgraded.equals(v.dataUpgraded))
			&& (hiddenColumn==null && v.hiddenColumn==null || hiddenColumn != null && hiddenColumn.equals(v.hiddenColumn))
			&& (virtualColumn==null && v.virtualColumn==null || virtualColumn != null && virtualColumn.equals(v.virtualColumn))
			&& (segmentColumnId==null && v.segmentColumnId==null || segmentColumnId != null && segmentColumnId.equals(v.segmentColumnId))
			&& (internalColumnId==null && v.internalColumnId==null || internalColumnId != null && internalColumnId.equals(v.internalColumnId))
			&& (histogram==null && v.histogram==null || histogram != null && histogram.equals(v.histogram))
			&& (qualifiedColName==null && v.qualifiedColName==null || qualifiedColName != null && qualifiedColName.equals(v.qualifiedColName))
		;
	}
	
	/**
	 * 散列字段：
	 * owner, tableName, columnName, dataType, dataTypeMod,
	 * dataTypeOwner, dataLength, dataPrecision, dataScale, nullable,
	 * columnId, defaultLength, dataDefault, numDistinct, lowValue,
	 * highValue, density, numNulls, numBuckets, lastAnalyzed,
	 * sampleSize, characterSetName, charColDeclLength, globalStats, userStats,
	 * avgColLen, charLength, charUsed, v80FmtImage, dataUpgraded,
	 * hiddenColumn, virtualColumn, segmentColumnId, internalColumnId, histogram,
	 * qualifiedColName
	 */
	public int hashCode(){
		int h = 1;
		h = 31 * h + (owner==null ? 0 : owner.hashCode());
		h = 31 * h + (tableName==null ? 0 : tableName.hashCode());
		h = 31 * h + (columnName==null ? 0 : columnName.hashCode());
		h = 31 * h + (dataType==null ? 0 : dataType.hashCode());
		h = 31 * h + (dataTypeMod==null ? 0 : dataTypeMod.hashCode());
		h = 31 * h + (dataTypeOwner==null ? 0 : dataTypeOwner.hashCode());
		h = 31 * h + (dataLength==null ? 0 : dataLength.hashCode());
		h = 31 * h + (dataPrecision==null ? 0 : dataPrecision.hashCode());
		h = 31 * h + (dataScale==null ? 0 : dataScale.hashCode());
		h = 31 * h + (nullable==null ? 0 : nullable.hashCode());
		h = 31 * h + (columnId==null ? 0 : columnId.hashCode());
		h = 31 * h + (defaultLength==null ? 0 : defaultLength.hashCode());
		h = 31 * h + (dataDefault==null ? 0 : dataDefault.hashCode());
		h = 31 * h + (numDistinct==null ? 0 : numDistinct.hashCode());
		h = 31 * h + (lowValue==null ? 0 : lowValue.hashCode());
		h = 31 * h + (highValue==null ? 0 : highValue.hashCode());
		h = 31 * h + (density==null ? 0 : density.hashCode());
		h = 31 * h + (numNulls==null ? 0 : numNulls.hashCode());
		h = 31 * h + (numBuckets==null ? 0 : numBuckets.hashCode());
		h = 31 * h + (lastAnalyzed==null ? 0 : lastAnalyzed.hashCode());
		h = 31 * h + (sampleSize==null ? 0 : sampleSize.hashCode());
		h = 31 * h + (characterSetName==null ? 0 : characterSetName.hashCode());
		h = 31 * h + (charColDeclLength==null ? 0 : charColDeclLength.hashCode());
		h = 31 * h + (globalStats==null ? 0 : globalStats.hashCode());
		h = 31 * h + (userStats==null ? 0 : userStats.hashCode());
		h = 31 * h + (avgColLen==null ? 0 : avgColLen.hashCode());
		h = 31 * h + (charLength==null ? 0 : charLength.hashCode());
		h = 31 * h + (charUsed==null ? 0 : charUsed.hashCode());
		h = 31 * h + (v80FmtImage==null ? 0 : v80FmtImage.hashCode());
		h = 31 * h + (dataUpgraded==null ? 0 : dataUpgraded.hashCode());
		h = 31 * h + (hiddenColumn==null ? 0 : hiddenColumn.hashCode());
		h = 31 * h + (virtualColumn==null ? 0 : virtualColumn.hashCode());
		h = 31 * h + (segmentColumnId==null ? 0 : segmentColumnId.hashCode());
		h = 31 * h + (internalColumnId==null ? 0 : internalColumnId.hashCode());
		h = 31 * h + (histogram==null ? 0 : histogram.hashCode());
		h = 31 * h + (qualifiedColName==null ? 0 : qualifiedColName.hashCode());
		return h;
	}
	
	/**
	 * 复制对象,复制了以下字段
	 * owner, tableName, columnName, dataType, dataTypeMod,
	 * dataTypeOwner, dataLength, dataPrecision, dataScale, nullable,
	 * columnId, defaultLength, dataDefault, numDistinct, lowValue,
	 * highValue, density, numNulls, numBuckets, lastAnalyzed,
	 * sampleSize, characterSetName, charColDeclLength, globalStats, userStats,
	 * avgColLen, charLength, charUsed, v80FmtImage, dataUpgraded,
	 * hiddenColumn, virtualColumn, segmentColumnId, internalColumnId, histogram,
	 * qualifiedColName
	 */
	public DbaTabCols copy(){
		DbaTabCols m = new DbaTabCols();
     	m.owner = owner;
     	m.tableName = tableName;
     	m.columnName = columnName;
     	m.dataType = dataType;
     	m.dataTypeMod = dataTypeMod;
     	m.dataTypeOwner = dataTypeOwner;
     	m.dataLength = dataLength;
     	m.dataPrecision = dataPrecision;
     	m.dataScale = dataScale;
     	m.nullable = nullable;
     	m.columnId = columnId;
     	m.defaultLength = defaultLength;
     	m.dataDefault = dataDefault;
     	m.numDistinct = numDistinct;
     	m.lowValue = lowValue;
     	m.highValue = highValue;
     	m.density = density;
     	m.numNulls = numNulls;
     	m.numBuckets = numBuckets;
     	m.lastAnalyzed = lastAnalyzed;
     	m.sampleSize = sampleSize;
     	m.characterSetName = characterSetName;
     	m.charColDeclLength = charColDeclLength;
     	m.globalStats = globalStats;
     	m.userStats = userStats;
     	m.avgColLen = avgColLen;
     	m.charLength = charLength;
     	m.charUsed = charUsed;
     	m.v80FmtImage = v80FmtImage;
     	m.dataUpgraded = dataUpgraded;
     	m.hiddenColumn = hiddenColumn;
     	m.virtualColumn = virtualColumn;
     	m.segmentColumnId = segmentColumnId;
     	m.internalColumnId = internalColumnId;
     	m.histogram = histogram;
     	m.qualifiedColName = qualifiedColName;
		return m;
	}
}
