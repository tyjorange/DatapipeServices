package com.slst.datapipe.dbmanger;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slst.datapipe.dao.TTermMapper;
import com.slst.datapipe.dao.pojo.TTerm;
import com.slst.datapipe.dao.pojo.TTermExample;
/**
 * 
 * @author tyj
 *
 */
@Service
@Transactional
public class TermDBManger {
	@Autowired
	private TTermMapper mapper;
	@Autowired
	private TTermExample example;

	/**
	 * 按IMEI查找
	 * 
	 * @param imei
	 * @return 查找到的记录 无结果返回null
	 */
	public TTerm findByIMEI(String imei) {
		return mapper.selectByPrimaryKey(imei);
	}

	/**
	 * 根据主键IMEI修改IP地址
	 * 
	 * @param newIp
	 * @return
	 */
	public int updateOne(TTerm newIp) {
		return mapper.updateByPrimaryKey(newIp);
	}

	/**
	 * 更新心跳时间
	 * 
	 * @param newHBTime
	 * @return
	 */
	public int updateHBTime(TTerm newHBTime) {
		newHBTime.setHbtime(new Date(System.currentTimeMillis()));
		return mapper.updateByPrimaryKey(newHBTime);
	}

}
