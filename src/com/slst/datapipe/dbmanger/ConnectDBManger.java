package com.slst.datapipe.dbmanger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slst.datapipe.dao.TConnectMapper;
import com.slst.datapipe.dao.pojo.TConnect;
import com.slst.datapipe.dao.pojo.TConnectExample;

/**
 * 
 * @author tyj
 *
 */
@Service
@Transactional
public class ConnectDBManger {
	@Autowired
	private TConnectMapper mapper;
	@Autowired
	private TConnectExample example;

	/**
	 * 更新连接配置时间
	 * 
	 * @param cid
	 * @return
	 */
	public int upDateCfgTime(String cid) {
		TConnect rec = mapper.selectByPrimaryKey(cid);
		rec.setConfigtime(System.currentTimeMillis());
		return mapper.updateByPrimaryKey(rec);
	}

	/**
	 * 
	 * @param cid
	 * @return
	 */
	public TConnect findByCid(String cid) {
		return mapper.selectByPrimaryKey(cid);
	}

}
