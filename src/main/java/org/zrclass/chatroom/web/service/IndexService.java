package org.zrclass.chatroom.web.service;

import org.springframework.stereotype.Service;
import org.zrclass.chatroom.common.vo.IndexPageInfo;
import org.zrclass.chatroom.web.websocket.Consumer;
import org.zrclass.chatroom.web.websocket.Customer;
import org.zrclass.chatroom.web.websocket.Manager;
import org.zrclass.chatroom.web.websocket.Setting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 业务实现
 * 
 * @author Administrator
 *
 */
@Service
public class IndexService {

	/**
	 * 查询监控页信息
	 * 
	 * @return
	 */
	public IndexPageInfo getIndexPageInfo() {

		IndexPageInfo ip = new IndexPageInfo();

		List<Consumer> consumer = new ArrayList<Consumer>();
		Manager.consumerQuenen.forEach((c) -> {
			c.setDurationTime(new Date());
			consumer.add(c);
		});
		ip.setConsumerList(consumer);

		List<Customer> customer = new ArrayList<Customer>();
		Manager.customerQuenen.forEach((c) -> {
			c.setDurationTime(new Date());
			customer.add(c);
		});
		ip.setCustomerList(customer);

		return ip;
	}

	public String contorAd() {
		if (Setting.isAdReply) {
			Setting.isAdReply = false;
		} else {
			Setting.isAdReply = true;
		}
		return Setting.isAdReply.toString();
	}

	public String contorAuto() {
		if (Setting.isAutoReply) {
			Setting.isAutoReply = false;
		} else {
			Setting.isAutoReply = true;
		}
		return Setting.isAutoReply.toString();
	}
}
