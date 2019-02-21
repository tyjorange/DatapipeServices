package com.slst.datapipe.dao;

import com.slst.datapipe.dao.pojo.TConnect;
import com.slst.datapipe.dao.pojo.TConnectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TConnectMapper {
	int countByExample(TConnectExample example);

	int deleteByExample(TConnectExample example);

	int deleteByPrimaryKey(String cid);

	int insert(TConnect record);

	int insertSelective(TConnect record);

	List<TConnect> selectByExampleWithBLOBs(TConnectExample example);

	List<TConnect> selectByExample(TConnectExample example);

	TConnect selectByPrimaryKey(String cid);

	int updateByExampleSelective(@Param("record") TConnect record, @Param("example") TConnectExample example);

	int updateByExampleWithBLOBs(@Param("record") TConnect record, @Param("example") TConnectExample example);

	int updateByExample(@Param("record") TConnect record, @Param("example") TConnectExample example);

	int updateByPrimaryKeySelective(TConnect record);

	int updateByPrimaryKeyWithBLOBs(TConnect record);

	int updateByPrimaryKey(TConnect record);
}