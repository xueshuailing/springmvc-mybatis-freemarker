package com.weixin.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.weixin.constant.Constant;
import com.weixin.dao.CoreDao;
import com.weixin.message.resp.TextMessage;
import com.weixin.utils.MessageUtils;
@Service
public class CoreService {
	@Resource
	private CoreDao coreDao;
	  /** 
     * 处理微信服务器发来的消息 
     */  
    public  String processRequest(HttpServletRequest request){  
    	String respMessage = null;
		try {
			// xml请求解析
			Map<String, String> requestMap = MessageUtils.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(Constant.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);
			// 文本消息
			if (msgType.equals(Constant.REQ_MESSAGE_TYPE_TEXT)) {
				// 接收用户发送的文本消息内容
				String content = requestMap.get("Content");

				if ("1".equals(content)) {
					textMessage.setContent("1是很好的");
					// 将文本消息对象转换成xml字符串
					respMessage = MessageUtils.textMessageToXml(textMessage);
				}else if ("2".equals(content)) {
					textMessage.setContent("我不是2货");
					// 将文本消息对象转换成xml字符串
					respMessage = MessageUtils.textMessageToXml(textMessage);
				}
			} 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}
}
