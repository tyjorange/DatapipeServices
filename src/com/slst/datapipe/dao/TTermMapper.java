package com.slst.datapipe.dao;

import com.slst.datapipe.dao.pojo.TTerm;
import com.slst.datapipe.dao.pojo.TTermExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTermMapper {
	int countByExample(TTermExample example);

	int deleteByExample(TTermExample example);

	int deleteByPrimaryKey(String imei);

	int insert(TTerm record);

	int insertSelective(TTerm record);

	List<TTerm> selectByExampleWithBLOBs(TTermExample example);

	List<TTerm> selectByExample(TTermExample example);

	TTerm selectByPrimaryKey(String imei);

	int updateByExampleSelective(@Param("record") TTerm record, @Param("example") TTermExample example);

	int updateByExampleWithBLOBs(@Param("record") TTerm record, @Param("example") TTermExample example);

	int updateByExample(@Param("record") TTerm record, @Param("example") TTermExample example);

	int updateByPrimaryKeySelective(TTerm record);

	int updateByPrimaryKeyWithBLOBs(TTerm record);

	int updateByPrimaryKey(TTerm record);
}