package com.slst.datapipe;

import io.netty.buffer.ByteBuf;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.slst.datapipe.coder.MsgEncoder;
import com.slst.datapipe.dao.pojo.TConnect;
import com.slst.datapipe.dao.pojo.TConnectterm;
import com.slst.datapipe.dao.pojo.TTerm;
import com.slst.datapipe.dbmanger.ConnectDBManger;
import com.slst.datapipe.dbmanger.ConnecttermDBManger;
import com.slst.datapipe.dbmanger.TermDBManger;

/**
 * 
 * @author tyj
 *
 */
@Component
public class DatapipeServerCore {
	private static Logger logger = Logger.getLogger(DatapipeServerCore.class);
	@Autowired
	private MsgEncoder encoder;
	@Autowired
	private ConnecttermDBManger t_connectterm_Mg;
	@Autowired
	private TermDBManger t_term_Mg;
	@Autowired
	private ConnectDBManger t_connect_Mg;

	/**
	 * 判断其IP是否变更 并更新
	 * 
	 * @param imei
	 * @param ip
	 * @return 有更新返回更新后结果 无更新返回NULL
	 */
	public TTerm findOrUpdateTerm(String imei, int newIp) {
		TTerm findTerm = t_term_Mg.findByIMEI(imei);
		if (findTerm != null) {
			t_term_Mg.updateHBTime(findTerm);
			int currentIp = findTerm.getIp();
			if (currentIp != newIp) { // 更新IP
				findTerm.setIp(newIp);
				int i = t_term_Mg.updateOne(findTerm);
				if (i > 0) {
					logger.info("[" + imei + "] IP地址更新: [ " + currentIp + " ==> " + newIp + " ]");
					// 更新配置时间
					TConnectterm currentConnectTerm = t_connectterm_Mg.findByIMEI(imei);
					t_connect_Mg.upDateCfgTime(currentConnectTerm.getConnect().getCid());
					return findTerm;
				}
			}
		}
		return null;
	}

	/**
	 * 查询连接配置时间
	 * 
	 * @param imei
	 * @return
	 */
	public long findCfgtimeByImei(String imei) {
		TConnectterm currentTerm = t_connectterm_Mg.findByIMEI(imei);
		TConnect findByCid = t_connect_Mg.findByCid(currentTerm.getConnect().getCid());
		return findByCid.getConfigtime();
	}

	/**
	 * 根据IMEI查找对应连接信息 (包含当前IMEI自身)
	 * 
	 * @param imei
	 *            当前IMEI
	 * @param b
	 *            是否同时更新连接配置时间
	 * @return IMEI相关的所有连接
	 */
	public List<TConnectterm> findAllImeiByImei(String imei) {
		TConnectterm currentConnectTerm = t_connectterm_Mg.findByIMEI(imei);
		if (currentConnectTerm != null) {
			List<TConnectterm> findList = t_connectterm_Mg.findAll(currentConnectTerm.getConnect().getCid());
			if (findList != null) {
				return findList;
			}
		}
		return null;
	}

	/**
	 * 根据IMEI查找对应连接信息 (不包含当前IMEI自身)
	 * 
	 * @param imei
	 *            当前IMEI
	 * @return 对应连接 [如果是客户端只有一条对端连接 如果是服务端则有多条对端连接]
	 */
	public ByteBuf initMsgByImei(String imei) {
		TConnectterm currentTerm = t_connectterm_Mg.findByIMEI(imei);
		if (currentTerm != null) {
			List<TConnectterm> findList = t_connectterm_Mg.findAllConnByCid(currentTerm);
			if (findList != null) {
				return encoder.initChannelInfoMsg2(currentTerm, findList);
			}
		}
		return null;
	}
}
