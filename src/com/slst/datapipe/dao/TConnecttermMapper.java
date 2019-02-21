package com.slst.datapipe.dao;

import com.slst.datapipe.dao.pojo.TConnectterm;
import com.slst.datapipe.dao.pojo.TConnecttermExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TConnecttermMapper {
	int countByExample(TConnecttermExample example);

	int deleteByExample(TConnecttermExample example);

	int deleteByPrimaryKey(String ctid);

	int insert(TConnectterm record);

	int insertSelective(TConnectterm record);

	List<TConnectterm> selectByExample(TConnecttermExample example);

	List<TConnectterm> selectByExampleWith(TConnecttermExample example);

	TConnectterm selectByPrimaryKey(String ctid);

	int updateByExampleSelective(@Param("record") TConnectterm record, @Param("example") TConnecttermExample example);

	int updateByExample(@Param("record") TConnectterm record, @Param("example") TConnecttermExample example);

	int updateByPrimaryKeySelective(TConnectterm record);

	int updateByPrimaryKey(TConnectterm record);
}