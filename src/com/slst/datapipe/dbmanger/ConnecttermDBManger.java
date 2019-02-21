package com.slst.datapipe.dbmanger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slst.datapipe.dao.TConnecttermMapper;
import com.slst.datapipe.dao.pojo.TConnectterm;
import com.slst.datapipe.dao.pojo.TConnecttermExample;
import com.slst.datapipe.dao.pojo.TConnecttermExample.Criteria;

/**
 * 
 * @author tyj
 *
 */
@Service
@Transactional
public class ConnecttermDBManger {
	@Autowired
	private TConnecttermMapper mapper;
	@Autowired
	private TConnecttermExample example;

	/**
	 * 根据IMEI查找
	 * 
	 * @param imei
	 * @return
	 */
	public TConnectterm findByIMEI(String imei) {
		example.clear();
		Criteria criteria = example.or();
		criteria.andImeiEqualTo(imei);
		List<TConnectterm> list = mapper.selectByExampleWith(example);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 查找CID对应的所有TERM
	 * 
	 * @param current
	 *            本端信息 包含IMEI,CID,SOCKETMODE
	 * @return 对端信息列表
	 */
	public List<TConnectterm> findAllConnByCid(TConnectterm current) {
		example.clear();
		Criteria criteria = example.or();
		criteria.andCidEqualTo(current.getConnect().getCid());
		if (current.getSocketmode() == 0) {
			criteria.andSocketmodeEqualTo((byte) 1);
		}
		criteria.andImeiNotLike(current.getTerm().getImei());
		return mapper.selectByExampleWith(example);
	}

	/**
	 * 
	 * @param cid
	 * @return CID对应的所有TERM
	 */
	public List<TConnectterm> findAll(String cid) {
		example.clear();
		Criteria criteria = example.or();
		criteria.andCidEqualTo(cid);
		return mapper.selectByExampleWith(example);
	}
}
