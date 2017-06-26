package com.afocus.pbuilder.oracle.model;

import java.util.Date;
import java.util.List;

/**
 * USER_TABLES Description of the user's own relational tables
 * 
 * @author liuwu
 * @date 2015-09-11
 * @company afocus
 * @version 5.0
 */
@SuppressWarnings("serial")
public class UserTables extends UserTabOrViews{
	

    /** @column Name of the table */
	private String tableName;

    /** @column Name of the tablespace containing the table */
	private String tablespaceName;

    /** @column Name of the cluster, if any, to which the table belongs */
	private String clusterName;

    /** @column Name of the index-only table, if any, to which the overflow or mapping table entry belongs */
	private String iotName;

    /** @column Status of the table will be UNUSABLE if a previous DROP TABLE operation failed,
VALID otherwise */
	private String status;

    /** @column Minimum percentage of free space in a block */
	private Integer pctFree;

    /** @column Minimum percentage of used space in a block */
	private Integer pctUsed;

    /** @column Initial number of transactions */
	private Integer iniTrans;

    /** @column Maximum number of transactions */
	private Integer maxTrans;

    /** @column Size of the initial extent in bytes */
	private Integer initialExtent;

    /** @column Size of secondary extents in bytes */
	private Integer nextExtent;

    /** @column Minimum number of extents allowed in the segment */
	private Integer minExtents;

    /** @column Maximum number of extents allowed in the segment */
	private Integer maxExtents;

    /** @column Percentage increase in extent size */
	private Integer pctIncrease;

    /** @column Number of process freelists allocated in this segment */
	private Integer freelists;

    /** @column Number of freelist groups allocated in this segment */
	private Integer freelistGroups;

    /** @column Logging attribute */
	private String logging;

    /** @column Has table been backed up since last modification? */
	private String backedUp;

    /** @column The number of rows in the table */
	private Integer numRows;

    /** @column The number of used blocks in the table */
	private Integer blocks;

    /** @column The number of empty (never used) blocks in the table */
	private Integer emptyBlocks;

    /** @column The average available free space in the table */
	private Integer avgSpace;

    /** @column The number of chained rows in the table */
	private Integer chainCnt;

    /** @column The average row length, including row overhead */
	private Integer avgRowLen;

    /** @column The average freespace of all blocks on a freelist */
	private Integer avgSpaceFreelistBlocks;

    /** @column The number of blocks on the freelist */
	private Integer numFreelistBlocks;

    /** @column The number of threads per instance for scanning the table */
	private String degree;

    /** @column The number of instances across which the table is to be scanned */
	private String instances;

    /** @column Whether the table is to be cached in the buffer cache */
	private String cache;

    /** @column Whether table locking is enabled or disabled */
	private String tableLock;

    /** @column The sample size used in analyzing this table */
	private Integer sampleSize;

    /** @column The date of the most recent time this table was analyzed */
	private Date lastAnalyzed;

    /** @column Is this table partitioned? YES or NO */
	private String partitioned;

    /** @column If index-only table, then IOT_TYPE is IOT or IOT_OVERFLOW or IOT_MAPPING else NULL */
	private String iotType;

    /** @column Can the current session only see data that it place in this object itself? */
	private String temporary;

    /** @column Is this table object created as part of icreate for domain indexes? */
	private String secondary;

    /** @column Is the table a nested table? */
	private String nested;

    /** @column The default buffer pool to be used for table blocks */
	private String bufferPool;

    /** @column Whether partitioned row movement is enabled or disabled */
	private String rowMovement;

    /** @column Are the statistics calculated without merging underlying partitions? */
	private String globalStats;

    /** @column Were the statistics entered directly by the user? */
	private String userStats;

    /** @column If temporary table, then duration is sys$session or sys$transaction else NULL */
	private String duration;

    /** @column Whether skip corrupt blocks is enabled or disabled */
	private String skipCorrupt;

    /** @column Should we keep track of the amount of modification? */
	private String monitoring;

    /** @column Owner of the cluster, if any, to which the table belongs */
	private String clusterOwner;

    /** @column Should we keep track of row level dependencies? */
	private String dependencies;

    /** @column Whether table compression is enabled or not */
	private String compression;

    /** @column Whether table is dropped and is in Recycle Bin */
	private String dropped;
	
	/**
	 * 关联注释
	 */
	private String comments;
	
	private List<UserTabColumns> userTabColumnsList;

	public UserTables(){}


	/**
	 * 获取Name of the table
	 */
	public String getTableName() {
    	return tableName;
    }
  	
	/**
	 * 设置Name of the table
	 */
	public void setTableName(String tableName) {
    	this.tableName = tableName;
    }

	/**
	 * 获取Name of the tablespace containing the table
	 */
	public String getTablespaceName() {
    	return tablespaceName;
    }
  	
	/**
	 * 设置Name of the tablespace containing the table
	 */
	public void setTablespaceName(String tablespaceName) {
    	this.tablespaceName = tablespaceName;
    }

	/**
	 * 获取Name of the cluster, if any, to which the table belongs
	 */
	public String getClusterName() {
    	return clusterName;
    }
  	
	/**
	 * 设置Name of the cluster, if any, to which the table belongs
	 */
	public void setClusterName(String clusterName) {
    	this.clusterName = clusterName;
    }

	/**
	 * 获取Name of the index-only table, if any, to which the overflow or mapping table entry belongs
	 */
	public String getIotName() {
    	return iotName;
    }
  	
	/**
	 * 设置Name of the index-only table, if any, to which the overflow or mapping table entry belongs
	 */
	public void setIotName(String iotName) {
    	this.iotName = iotName;
    }

	/**
	 * 获取Status of the table will be UNUSABLE if a previous DROP TABLE operation failed,
VALID otherwise
	 */
	public String getStatus() {
    	return status;
    }
  	
	/**
	 * 设置Status of the table will be UNUSABLE if a previous DROP TABLE operation failed,
VALID otherwise
	 */
	public void setStatus(String status) {
    	this.status = status;
    }

	/**
	 * 获取Minimum percentage of free space in a block
	 */
	public Integer getPctFree() {
    	return pctFree;
    }
  	
	/**
	 * 设置Minimum percentage of free space in a block
	 */
	public void setPctFree(Integer pctFree) {
    	this.pctFree = pctFree;
    }

	/**
	 * 获取Minimum percentage of used space in a block
	 */
	public Integer getPctUsed() {
    	return pctUsed;
    }
  	
	/**
	 * 设置Minimum percentage of used space in a block
	 */
	public void setPctUsed(Integer pctUsed) {
    	this.pctUsed = pctUsed;
    }

	/**
	 * 获取Initial number of transactions
	 */
	public Integer getIniTrans() {
    	return iniTrans;
    }
  	
	/**
	 * 设置Initial number of transactions
	 */
	public void setIniTrans(Integer iniTrans) {
    	this.iniTrans = iniTrans;
    }

	/**
	 * 获取Maximum number of transactions
	 */
	public Integer getMaxTrans() {
    	return maxTrans;
    }
  	
	/**
	 * 设置Maximum number of transactions
	 */
	public void setMaxTrans(Integer maxTrans) {
    	this.maxTrans = maxTrans;
    }

	/**
	 * 获取Size of the initial extent in bytes
	 */
	public Integer getInitialExtent() {
    	return initialExtent;
    }
  	
	/**
	 * 设置Size of the initial extent in bytes
	 */
	public void setInitialExtent(Integer initialExtent) {
    	this.initialExtent = initialExtent;
    }

	/**
	 * 获取Size of secondary extents in bytes
	 */
	public Integer getNextExtent() {
    	return nextExtent;
    }
  	
	/**
	 * 设置Size of secondary extents in bytes
	 */
	public void setNextExtent(Integer nextExtent) {
    	this.nextExtent = nextExtent;
    }

	/**
	 * 获取Minimum number of extents allowed in the segment
	 */
	public Integer getMinExtents() {
    	return minExtents;
    }
  	
	/**
	 * 设置Minimum number of extents allowed in the segment
	 */
	public void setMinExtents(Integer minExtents) {
    	this.minExtents = minExtents;
    }

	/**
	 * 获取Maximum number of extents allowed in the segment
	 */
	public Integer getMaxExtents() {
    	return maxExtents;
    }
  	
	/**
	 * 设置Maximum number of extents allowed in the segment
	 */
	public void setMaxExtents(Integer maxExtents) {
    	this.maxExtents = maxExtents;
    }

	/**
	 * 获取Percentage increase in extent size
	 */
	public Integer getPctIncrease() {
    	return pctIncrease;
    }
  	
	/**
	 * 设置Percentage increase in extent size
	 */
	public void setPctIncrease(Integer pctIncrease) {
    	this.pctIncrease = pctIncrease;
    }

	/**
	 * 获取Number of process freelists allocated in this segment
	 */
	public Integer getFreelists() {
    	return freelists;
    }
  	
	/**
	 * 设置Number of process freelists allocated in this segment
	 */
	public void setFreelists(Integer freelists) {
    	this.freelists = freelists;
    }

	/**
	 * 获取Number of freelist groups allocated in this segment
	 */
	public Integer getFreelistGroups() {
    	return freelistGroups;
    }
  	
	/**
	 * 设置Number of freelist groups allocated in this segment
	 */
	public void setFreelistGroups(Integer freelistGroups) {
    	this.freelistGroups = freelistGroups;
    }

	/**
	 * 获取Logging attribute
	 */
	public String getLogging() {
    	return logging;
    }
  	
	/**
	 * 设置Logging attribute
	 */
	public void setLogging(String logging) {
    	this.logging = logging;
    }

	/**
	 * 获取Has table been backed up since last modification?
	 */
	public String getBackedUp() {
    	return backedUp;
    }
  	
	/**
	 * 设置Has table been backed up since last modification?
	 */
	public void setBackedUp(String backedUp) {
    	this.backedUp = backedUp;
    }

	/**
	 * 获取The number of rows in the table
	 */
	public Integer getNumRows() {
    	return numRows;
    }
  	
	/**
	 * 设置The number of rows in the table
	 */
	public void setNumRows(Integer numRows) {
    	this.numRows = numRows;
    }

	/**
	 * 获取The number of used blocks in the table
	 */
	public Integer getBlocks() {
    	return blocks;
    }
  	
	/**
	 * 设置The number of used blocks in the table
	 */
	public void setBlocks(Integer blocks) {
    	this.blocks = blocks;
    }

	/**
	 * 获取The number of empty (never used) blocks in the table
	 */
	public Integer getEmptyBlocks() {
    	return emptyBlocks;
    }
  	
	/**
	 * 设置The number of empty (never used) blocks in the table
	 */
	public void setEmptyBlocks(Integer emptyBlocks) {
    	this.emptyBlocks = emptyBlocks;
    }

	/**
	 * 获取The average available free space in the table
	 */
	public Integer getAvgSpace() {
    	return avgSpace;
    }
  	
	/**
	 * 设置The average available free space in the table
	 */
	public void setAvgSpace(Integer avgSpace) {
    	this.avgSpace = avgSpace;
    }

	/**
	 * 获取The number of chained rows in the table
	 */
	public Integer getChainCnt() {
    	return chainCnt;
    }
  	
	/**
	 * 设置The number of chained rows in the table
	 */
	public void setChainCnt(Integer chainCnt) {
    	this.chainCnt = chainCnt;
    }

	/**
	 * 获取The average row length, including row overhead
	 */
	public Integer getAvgRowLen() {
    	return avgRowLen;
    }
  	
	/**
	 * 设置The average row length, including row overhead
	 */
	public void setAvgRowLen(Integer avgRowLen) {
    	this.avgRowLen = avgRowLen;
    }

	/**
	 * 获取The average freespace of all blocks on a freelist
	 */
	public Integer getAvgSpaceFreelistBlocks() {
    	return avgSpaceFreelistBlocks;
    }
  	
	/**
	 * 设置The average freespace of all blocks on a freelist
	 */
	public void setAvgSpaceFreelistBlocks(Integer avgSpaceFreelistBlocks) {
    	this.avgSpaceFreelistBlocks = avgSpaceFreelistBlocks;
    }

	/**
	 * 获取The number of blocks on the freelist
	 */
	public Integer getNumFreelistBlocks() {
    	return numFreelistBlocks;
    }
  	
	/**
	 * 设置The number of blocks on the freelist
	 */
	public void setNumFreelistBlocks(Integer numFreelistBlocks) {
    	this.numFreelistBlocks = numFreelistBlocks;
    }

	/**
	 * 获取The number of threads per instance for scanning the table
	 */
	public String getDegree() {
    	return degree;
    }
  	
	/**
	 * 设置The number of threads per instance for scanning the table
	 */
	public void setDegree(String degree) {
    	this.degree = degree;
    }

	/**
	 * 获取The number of instances across which the table is to be scanned
	 */
	public String getInstances() {
    	return instances;
    }
  	
	/**
	 * 设置The number of instances across which the table is to be scanned
	 */
	public void setInstances(String instances) {
    	this.instances = instances;
    }

	/**
	 * 获取Whether the table is to be cached in the buffer cache
	 */
	public String getCache() {
    	return cache;
    }
  	
	/**
	 * 设置Whether the table is to be cached in the buffer cache
	 */
	public void setCache(String cache) {
    	this.cache = cache;
    }

	/**
	 * 获取Whether table locking is enabled or disabled
	 */
	public String getTableLock() {
    	return tableLock;
    }
  	
	/**
	 * 设置Whether table locking is enabled or disabled
	 */
	public void setTableLock(String tableLock) {
    	this.tableLock = tableLock;
    }

	/**
	 * 获取The sample size used in analyzing this table
	 */
	public Integer getSampleSize() {
    	return sampleSize;
    }
  	
	/**
	 * 设置The sample size used in analyzing this table
	 */
	public void setSampleSize(Integer sampleSize) {
    	this.sampleSize = sampleSize;
    }

	/**
	 * 获取The date of the most recent time this table was analyzed
	 */
	public Date getLastAnalyzed() {
    	return lastAnalyzed;
    }
  	
	/**
	 * 设置The date of the most recent time this table was analyzed
	 */
	public void setLastAnalyzed(Date lastAnalyzed) {
    	this.lastAnalyzed = lastAnalyzed;
    }

	/**
	 * 获取Is this table partitioned? YES or NO
	 */
	public String getPartitioned() {
    	return partitioned;
    }
  	
	/**
	 * 设置Is this table partitioned? YES or NO
	 */
	public void setPartitioned(String partitioned) {
    	this.partitioned = partitioned;
    }

	/**
	 * 获取If index-only table, then IOT_TYPE is IOT or IOT_OVERFLOW or IOT_MAPPING else NULL
	 */
	public String getIotType() {
    	return iotType;
    }
  	
	/**
	 * 设置If index-only table, then IOT_TYPE is IOT or IOT_OVERFLOW or IOT_MAPPING else NULL
	 */
	public void setIotType(String iotType) {
    	this.iotType = iotType;
    }

	/**
	 * 获取Can the current session only see data that it place in this object itself?
	 */
	public String getTemporary() {
    	return temporary;
    }
  	
	/**
	 * 设置Can the current session only see data that it place in this object itself?
	 */
	public void setTemporary(String temporary) {
    	this.temporary = temporary;
    }

	/**
	 * 获取Is this table object created as part of icreate for domain indexes?
	 */
	public String getSecondary() {
    	return secondary;
    }
  	
	/**
	 * 设置Is this table object created as part of icreate for domain indexes?
	 */
	public void setSecondary(String secondary) {
    	this.secondary = secondary;
    }

	/**
	 * 获取Is the table a nested table?
	 */
	public String getNested() {
    	return nested;
    }
  	
	/**
	 * 设置Is the table a nested table?
	 */
	public void setNested(String nested) {
    	this.nested = nested;
    }

	/**
	 * 获取The default buffer pool to be used for table blocks
	 */
	public String getBufferPool() {
    	return bufferPool;
    }
  	
	/**
	 * 设置The default buffer pool to be used for table blocks
	 */
	public void setBufferPool(String bufferPool) {
    	this.bufferPool = bufferPool;
    }

	/**
	 * 获取Whether partitioned row movement is enabled or disabled
	 */
	public String getRowMovement() {
    	return rowMovement;
    }
  	
	/**
	 * 设置Whether partitioned row movement is enabled or disabled
	 */
	public void setRowMovement(String rowMovement) {
    	this.rowMovement = rowMovement;
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
	 * 获取If temporary table, then duration is sys$session or sys$transaction else NULL
	 */
	public String getDuration() {
    	return duration;
    }
  	
	/**
	 * 设置If temporary table, then duration is sys$session or sys$transaction else NULL
	 */
	public void setDuration(String duration) {
    	this.duration = duration;
    }

	/**
	 * 获取Whether skip corrupt blocks is enabled or disabled
	 */
	public String getSkipCorrupt() {
    	return skipCorrupt;
    }
  	
	/**
	 * 设置Whether skip corrupt blocks is enabled or disabled
	 */
	public void setSkipCorrupt(String skipCorrupt) {
    	this.skipCorrupt = skipCorrupt;
    }

	/**
	 * 获取Should we keep track of the amount of modification?
	 */
	public String getMonitoring() {
    	return monitoring;
    }
  	
	/**
	 * 设置Should we keep track of the amount of modification?
	 */
	public void setMonitoring(String monitoring) {
    	this.monitoring = monitoring;
    }

	/**
	 * 获取Owner of the cluster, if any, to which the table belongs
	 */
	public String getClusterOwner() {
    	return clusterOwner;
    }
  	
	/**
	 * 设置Owner of the cluster, if any, to which the table belongs
	 */
	public void setClusterOwner(String clusterOwner) {
    	this.clusterOwner = clusterOwner;
    }

	/**
	 * 获取Should we keep track of row level dependencies?
	 */
	public String getDependencies() {
    	return dependencies;
    }
  	
	/**
	 * 设置Should we keep track of row level dependencies?
	 */
	public void setDependencies(String dependencies) {
    	this.dependencies = dependencies;
    }

	/**
	 * 获取Whether table compression is enabled or not
	 */
	public String getCompression() {
    	return compression;
    }
  	
	/**
	 * 设置Whether table compression is enabled or not
	 */
	public void setCompression(String compression) {
    	this.compression = compression;
    }

	/**
	 * 获取Whether table is dropped and is in Recycle Bin
	 */
	public String getDropped() {
    	return dropped;
    }
  	
	/**
	 * 设置Whether table is dropped and is in Recycle Bin
	 */
	public void setDropped(String dropped) {
    	this.dropped = dropped;
    }

	@Override
    public String toString() {
		return new StringBuilder().append("UserTables{").
			append("tableName=").append(tableName).
			append(",tablespaceName=").append(tablespaceName).
			append(",clusterName=").append(clusterName).
			append(",iotName=").append(iotName).
			append(",status=").append(status).
			append(",pctFree=").append(pctFree).
			append(",pctUsed=").append(pctUsed).
			append(",iniTrans=").append(iniTrans).
			append(",maxTrans=").append(maxTrans).
			append(",initialExtent=").append(initialExtent).
			append(",nextExtent=").append(nextExtent).
			append(",minExtents=").append(minExtents).
			append(",maxExtents=").append(maxExtents).
			append(",pctIncrease=").append(pctIncrease).
			append(",freelists=").append(freelists).
			append(",freelistGroups=").append(freelistGroups).
			append(",logging=").append(logging).
			append(",backedUp=").append(backedUp).
			append(",numRows=").append(numRows).
			append(",blocks=").append(blocks).
			append(",emptyBlocks=").append(emptyBlocks).
			append(",avgSpace=").append(avgSpace).
			append(",chainCnt=").append(chainCnt).
			append(",avgRowLen=").append(avgRowLen).
			append(",avgSpaceFreelistBlocks=").append(avgSpaceFreelistBlocks).
			append(",numFreelistBlocks=").append(numFreelistBlocks).
			append(",degree=").append(degree).
			append(",instances=").append(instances).
			append(",cache=").append(cache).
			append(",tableLock=").append(tableLock).
			append(",sampleSize=").append(sampleSize).
			append(",lastAnalyzed=").append(lastAnalyzed).
			append(",partitioned=").append(partitioned).
			append(",iotType=").append(iotType).
			append(",temporary=").append(temporary).
			append(",secondary=").append(secondary).
			append(",nested=").append(nested).
			append(",bufferPool=").append(bufferPool).
			append(",rowMovement=").append(rowMovement).
			append(",globalStats=").append(globalStats).
			append(",userStats=").append(userStats).
			append(",duration=").append(duration).
			append(",skipCorrupt=").append(skipCorrupt).
			append(",monitoring=").append(monitoring).
			append(",clusterOwner=").append(clusterOwner).
			append(",dependencies=").append(dependencies).
			append(",compression=").append(compression).
			append(",dropped=").append(dropped).
			append('}').toString();
    }
    
    /**
	 * 比较字段：
	 * tableName, tablespaceName, clusterName, iotName, status,
	 * pctFree, pctUsed, iniTrans, maxTrans, initialExtent,
	 * nextExtent, minExtents, maxExtents, pctIncrease, freelists,
	 * freelistGroups, logging, backedUp, numRows, blocks,
	 * emptyBlocks, avgSpace, chainCnt, avgRowLen, avgSpaceFreelistBlocks,
	 * numFreelistBlocks, degree, instances, cache, tableLock,
	 * sampleSize, lastAnalyzed, partitioned, iotType, temporary,
	 * secondary, nested, bufferPool, rowMovement, globalStats,
	 * userStats, duration, skipCorrupt, monitoring, clusterOwner,
	 * dependencies, compression, dropped
	 */
	public boolean equals(Object o){
		if(!(o instanceof UserTables)) return false;
		UserTables v = (UserTables)o;
		return (tableName==null && v.tableName==null || tableName != null && tableName.equals(v.tableName))
			&& (tablespaceName==null && v.tablespaceName==null || tablespaceName != null && tablespaceName.equals(v.tablespaceName))
			&& (clusterName==null && v.clusterName==null || clusterName != null && clusterName.equals(v.clusterName))
			&& (iotName==null && v.iotName==null || iotName != null && iotName.equals(v.iotName))
			&& (status==null && v.status==null || status != null && status.equals(v.status))
			&& (pctFree==null && v.pctFree==null || pctFree != null && pctFree.equals(v.pctFree))
			&& (pctUsed==null && v.pctUsed==null || pctUsed != null && pctUsed.equals(v.pctUsed))
			&& (iniTrans==null && v.iniTrans==null || iniTrans != null && iniTrans.equals(v.iniTrans))
			&& (maxTrans==null && v.maxTrans==null || maxTrans != null && maxTrans.equals(v.maxTrans))
			&& (initialExtent==null && v.initialExtent==null || initialExtent != null && initialExtent.equals(v.initialExtent))
			&& (nextExtent==null && v.nextExtent==null || nextExtent != null && nextExtent.equals(v.nextExtent))
			&& (minExtents==null && v.minExtents==null || minExtents != null && minExtents.equals(v.minExtents))
			&& (maxExtents==null && v.maxExtents==null || maxExtents != null && maxExtents.equals(v.maxExtents))
			&& (pctIncrease==null && v.pctIncrease==null || pctIncrease != null && pctIncrease.equals(v.pctIncrease))
			&& (freelists==null && v.freelists==null || freelists != null && freelists.equals(v.freelists))
			&& (freelistGroups==null && v.freelistGroups==null || freelistGroups != null && freelistGroups.equals(v.freelistGroups))
			&& (logging==null && v.logging==null || logging != null && logging.equals(v.logging))
			&& (backedUp==null && v.backedUp==null || backedUp != null && backedUp.equals(v.backedUp))
			&& (numRows==null && v.numRows==null || numRows != null && numRows.equals(v.numRows))
			&& (blocks==null && v.blocks==null || blocks != null && blocks.equals(v.blocks))
			&& (emptyBlocks==null && v.emptyBlocks==null || emptyBlocks != null && emptyBlocks.equals(v.emptyBlocks))
			&& (avgSpace==null && v.avgSpace==null || avgSpace != null && avgSpace.equals(v.avgSpace))
			&& (chainCnt==null && v.chainCnt==null || chainCnt != null && chainCnt.equals(v.chainCnt))
			&& (avgRowLen==null && v.avgRowLen==null || avgRowLen != null && avgRowLen.equals(v.avgRowLen))
			&& (avgSpaceFreelistBlocks==null && v.avgSpaceFreelistBlocks==null || avgSpaceFreelistBlocks != null && avgSpaceFreelistBlocks.equals(v.avgSpaceFreelistBlocks))
			&& (numFreelistBlocks==null && v.numFreelistBlocks==null || numFreelistBlocks != null && numFreelistBlocks.equals(v.numFreelistBlocks))
			&& (degree==null && v.degree==null || degree != null && degree.equals(v.degree))
			&& (instances==null && v.instances==null || instances != null && instances.equals(v.instances))
			&& (cache==null && v.cache==null || cache != null && cache.equals(v.cache))
			&& (tableLock==null && v.tableLock==null || tableLock != null && tableLock.equals(v.tableLock))
			&& (sampleSize==null && v.sampleSize==null || sampleSize != null && sampleSize.equals(v.sampleSize))
			&& (lastAnalyzed==null && v.lastAnalyzed==null || lastAnalyzed != null && lastAnalyzed.equals(v.lastAnalyzed))
			&& (partitioned==null && v.partitioned==null || partitioned != null && partitioned.equals(v.partitioned))
			&& (iotType==null && v.iotType==null || iotType != null && iotType.equals(v.iotType))
			&& (temporary==null && v.temporary==null || temporary != null && temporary.equals(v.temporary))
			&& (secondary==null && v.secondary==null || secondary != null && secondary.equals(v.secondary))
			&& (nested==null && v.nested==null || nested != null && nested.equals(v.nested))
			&& (bufferPool==null && v.bufferPool==null || bufferPool != null && bufferPool.equals(v.bufferPool))
			&& (rowMovement==null && v.rowMovement==null || rowMovement != null && rowMovement.equals(v.rowMovement))
			&& (globalStats==null && v.globalStats==null || globalStats != null && globalStats.equals(v.globalStats))
			&& (userStats==null && v.userStats==null || userStats != null && userStats.equals(v.userStats))
			&& (duration==null && v.duration==null || duration != null && duration.equals(v.duration))
			&& (skipCorrupt==null && v.skipCorrupt==null || skipCorrupt != null && skipCorrupt.equals(v.skipCorrupt))
			&& (monitoring==null && v.monitoring==null || monitoring != null && monitoring.equals(v.monitoring))
			&& (clusterOwner==null && v.clusterOwner==null || clusterOwner != null && clusterOwner.equals(v.clusterOwner))
			&& (dependencies==null && v.dependencies==null || dependencies != null && dependencies.equals(v.dependencies))
			&& (compression==null && v.compression==null || compression != null && compression.equals(v.compression))
			&& (dropped==null && v.dropped==null || dropped != null && dropped.equals(v.dropped))
		;
	}
	
	/**
	 * 散列字段：
	 * tableName, tablespaceName, clusterName, iotName, status,
	 * pctFree, pctUsed, iniTrans, maxTrans, initialExtent,
	 * nextExtent, minExtents, maxExtents, pctIncrease, freelists,
	 * freelistGroups, logging, backedUp, numRows, blocks,
	 * emptyBlocks, avgSpace, chainCnt, avgRowLen, avgSpaceFreelistBlocks,
	 * numFreelistBlocks, degree, instances, cache, tableLock,
	 * sampleSize, lastAnalyzed, partitioned, iotType, temporary,
	 * secondary, nested, bufferPool, rowMovement, globalStats,
	 * userStats, duration, skipCorrupt, monitoring, clusterOwner,
	 * dependencies, compression, dropped
	 */
	public int hashCode(){
		int h = 1;
		h = 31 * h + (tableName==null ? 0 : tableName.hashCode());
		h = 31 * h + (tablespaceName==null ? 0 : tablespaceName.hashCode());
		h = 31 * h + (clusterName==null ? 0 : clusterName.hashCode());
		h = 31 * h + (iotName==null ? 0 : iotName.hashCode());
		h = 31 * h + (status==null ? 0 : status.hashCode());
		h = 31 * h + (pctFree==null ? 0 : pctFree.hashCode());
		h = 31 * h + (pctUsed==null ? 0 : pctUsed.hashCode());
		h = 31 * h + (iniTrans==null ? 0 : iniTrans.hashCode());
		h = 31 * h + (maxTrans==null ? 0 : maxTrans.hashCode());
		h = 31 * h + (initialExtent==null ? 0 : initialExtent.hashCode());
		h = 31 * h + (nextExtent==null ? 0 : nextExtent.hashCode());
		h = 31 * h + (minExtents==null ? 0 : minExtents.hashCode());
		h = 31 * h + (maxExtents==null ? 0 : maxExtents.hashCode());
		h = 31 * h + (pctIncrease==null ? 0 : pctIncrease.hashCode());
		h = 31 * h + (freelists==null ? 0 : freelists.hashCode());
		h = 31 * h + (freelistGroups==null ? 0 : freelistGroups.hashCode());
		h = 31 * h + (logging==null ? 0 : logging.hashCode());
		h = 31 * h + (backedUp==null ? 0 : backedUp.hashCode());
		h = 31 * h + (numRows==null ? 0 : numRows.hashCode());
		h = 31 * h + (blocks==null ? 0 : blocks.hashCode());
		h = 31 * h + (emptyBlocks==null ? 0 : emptyBlocks.hashCode());
		h = 31 * h + (avgSpace==null ? 0 : avgSpace.hashCode());
		h = 31 * h + (chainCnt==null ? 0 : chainCnt.hashCode());
		h = 31 * h + (avgRowLen==null ? 0 : avgRowLen.hashCode());
		h = 31 * h + (avgSpaceFreelistBlocks==null ? 0 : avgSpaceFreelistBlocks.hashCode());
		h = 31 * h + (numFreelistBlocks==null ? 0 : numFreelistBlocks.hashCode());
		h = 31 * h + (degree==null ? 0 : degree.hashCode());
		h = 31 * h + (instances==null ? 0 : instances.hashCode());
		h = 31 * h + (cache==null ? 0 : cache.hashCode());
		h = 31 * h + (tableLock==null ? 0 : tableLock.hashCode());
		h = 31 * h + (sampleSize==null ? 0 : sampleSize.hashCode());
		h = 31 * h + (lastAnalyzed==null ? 0 : lastAnalyzed.hashCode());
		h = 31 * h + (partitioned==null ? 0 : partitioned.hashCode());
		h = 31 * h + (iotType==null ? 0 : iotType.hashCode());
		h = 31 * h + (temporary==null ? 0 : temporary.hashCode());
		h = 31 * h + (secondary==null ? 0 : secondary.hashCode());
		h = 31 * h + (nested==null ? 0 : nested.hashCode());
		h = 31 * h + (bufferPool==null ? 0 : bufferPool.hashCode());
		h = 31 * h + (rowMovement==null ? 0 : rowMovement.hashCode());
		h = 31 * h + (globalStats==null ? 0 : globalStats.hashCode());
		h = 31 * h + (userStats==null ? 0 : userStats.hashCode());
		h = 31 * h + (duration==null ? 0 : duration.hashCode());
		h = 31 * h + (skipCorrupt==null ? 0 : skipCorrupt.hashCode());
		h = 31 * h + (monitoring==null ? 0 : monitoring.hashCode());
		h = 31 * h + (clusterOwner==null ? 0 : clusterOwner.hashCode());
		h = 31 * h + (dependencies==null ? 0 : dependencies.hashCode());
		h = 31 * h + (compression==null ? 0 : compression.hashCode());
		h = 31 * h + (dropped==null ? 0 : dropped.hashCode());
		return h;
	}
	
	/**
	 * 复制对象,复制了以下字段
	 * tableName, tablespaceName, clusterName, iotName, status,
	 * pctFree, pctUsed, iniTrans, maxTrans, initialExtent,
	 * nextExtent, minExtents, maxExtents, pctIncrease, freelists,
	 * freelistGroups, logging, backedUp, numRows, blocks,
	 * emptyBlocks, avgSpace, chainCnt, avgRowLen, avgSpaceFreelistBlocks,
	 * numFreelistBlocks, degree, instances, cache, tableLock,
	 * sampleSize, lastAnalyzed, partitioned, iotType, temporary,
	 * secondary, nested, bufferPool, rowMovement, globalStats,
	 * userStats, duration, skipCorrupt, monitoring, clusterOwner,
	 * dependencies, compression, dropped
	 */
	public UserTables copy(){
		UserTables m = new UserTables();
     	m.tableName = tableName;
     	m.tablespaceName = tablespaceName;
     	m.clusterName = clusterName;
     	m.iotName = iotName;
     	m.status = status;
     	m.pctFree = pctFree;
     	m.pctUsed = pctUsed;
     	m.iniTrans = iniTrans;
     	m.maxTrans = maxTrans;
     	m.initialExtent = initialExtent;
     	m.nextExtent = nextExtent;
     	m.minExtents = minExtents;
     	m.maxExtents = maxExtents;
     	m.pctIncrease = pctIncrease;
     	m.freelists = freelists;
     	m.freelistGroups = freelistGroups;
     	m.logging = logging;
     	m.backedUp = backedUp;
     	m.numRows = numRows;
     	m.blocks = blocks;
     	m.emptyBlocks = emptyBlocks;
     	m.avgSpace = avgSpace;
     	m.chainCnt = chainCnt;
     	m.avgRowLen = avgRowLen;
     	m.avgSpaceFreelistBlocks = avgSpaceFreelistBlocks;
     	m.numFreelistBlocks = numFreelistBlocks;
     	m.degree = degree;
     	m.instances = instances;
     	m.cache = cache;
     	m.tableLock = tableLock;
     	m.sampleSize = sampleSize;
     	m.lastAnalyzed = lastAnalyzed;
     	m.partitioned = partitioned;
     	m.iotType = iotType;
     	m.temporary = temporary;
     	m.secondary = secondary;
     	m.nested = nested;
     	m.bufferPool = bufferPool;
     	m.rowMovement = rowMovement;
     	m.globalStats = globalStats;
     	m.userStats = userStats;
     	m.duration = duration;
     	m.skipCorrupt = skipCorrupt;
     	m.monitoring = monitoring;
     	m.clusterOwner = clusterOwner;
     	m.dependencies = dependencies;
     	m.compression = compression;
     	m.dropped = dropped;
		return m;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<UserTabColumns> getUserTabColumnsList() {
		return userTabColumnsList;
	}

	public void setUserTabColumnsList(List<UserTabColumns> userTabColumnsList) {
		this.userTabColumnsList = userTabColumnsList;
	}

	@Override
	public String getTableType() {
		return "TABLE";
	}
}
