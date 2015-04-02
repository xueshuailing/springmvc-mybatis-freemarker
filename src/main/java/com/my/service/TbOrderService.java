package com.my.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.gitchina.framework.commons.dao.support.Order;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.gitchina.framework.commons.utils.Pager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.my.dao.TbOrderDao;
import com.my.entity.TbOrder;
/**
 * service层
 */
@Service
@Transactional
public class TbOrderService {
	@Resource
	private TbOrderDao tbOrderDao;
	/**
	*保存
	*/
	public void save(TbOrder t) throws Exception{
		this.tbOrderDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbOrder t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getInNum())){
			parameter.addQuery("inNum", t.getInNum());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getInPayment())){
			parameter.addQuery("inPayment", t.getInPayment());
		}
		if(StringUtils.isNotBlank(t.getInReceiptId())){
			parameter.addQuery("inReceiptId", t.getInReceiptId());
		}
		if(StringUtils.isNotBlank(t.getAddress())){
			parameter.addQuery("address", t.getAddress());
		}
		if(StringUtils.isNotBlank(t.getInCommitTime())){
			parameter.addQuery("inCommitTime", t.getInCommitTime());
		}
		if(StringUtils.isNotBlank(t.getInState())){
			parameter.addQuery("inState", t.getInState());
		}
		if(StringUtils.isNotBlank(t.getInSendTime())){
			parameter.addQuery("inSendTime", t.getInSendTime());
		}
		if(StringUtils.isNotBlank(t.getInReceiptTime())){
			parameter.addQuery("inReceiptTime", t.getInReceiptTime());
		}
		if(StringUtils.isNotBlank(t.getInRefundTime())){
			parameter.addQuery("inRefundTime", t.getInRefundTime());
		}
		if(StringUtils.isNotBlank(t.getInRefundFinishTime())){
			parameter.addQuery("inRefundFinishTime", t.getInRefundFinishTime());
		}
		if(StringUtils.isNotBlank(t.getInRefundMoney())){
			parameter.addQuery("inRefundMoney", t.getInRefundMoney());
		}
		if(StringUtils.isNotBlank(t.getInCarriage())){
			parameter.addQuery("inCarriage", t.getInCarriage());
		}
		if(StringUtils.isNotBlank(t.getInInvoiceType())){
			parameter.addQuery("inInvoiceType", t.getInInvoiceType());
		}
		if(StringUtils.isNotBlank(t.getInInvoiceCompany())){
			parameter.addQuery("inInvoiceCompany", t.getInInvoiceCompany());
		}
		if(StringUtils.isNotBlank(t.getInCancelTime())){
			parameter.addQuery("inCancelTime", t.getInCancelTime());
		}
		if(StringUtils.isNotBlank(t.getInPrivilegeMoney())){
			parameter.addQuery("inPrivilegeMoney", t.getInPrivilegeMoney());
		}
		if(StringUtils.isNotBlank(t.getInOriginalMoney())){
			parameter.addQuery("inOriginalMoney", t.getInOriginalMoney());
		}
		if(StringUtils.isNotBlank(t.getInNowMoney())){
			parameter.addQuery("inNowMoney", t.getInNowMoney());
		}
		if(StringUtils.isNotBlank(t.getInZfTime())){
			parameter.addQuery("inZfTime", t.getInZfTime());
		}
		if(StringUtils.isNotBlank(t.getInName())){
			parameter.addQuery("inName", t.getInName());
		}
		if(StringUtils.isNotBlank(t.getInReceiptPhone())){
			parameter.addQuery("inReceiptPhone", t.getInReceiptPhone());
		}
		this.tbOrderDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbOrderDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbOrder t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getInNum())){
			parameter.addUpdate("inNum", t.getInNum());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addUpdate("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getInPayment())){
			parameter.addUpdate("inPayment", t.getInPayment());
		}
		if(StringUtils.isNotBlank(t.getInReceiptId())){
			parameter.addUpdate("inReceiptId", t.getInReceiptId());
		}
		if(StringUtils.isNotBlank(t.getAddress())){
			parameter.addUpdate("address", t.getAddress());
		}
		if(StringUtils.isNotBlank(t.getInCommitTime())){
			parameter.addUpdate("inCommitTime", t.getInCommitTime());
		}
		if(StringUtils.isNotBlank(t.getInState())){
			parameter.addUpdate("inState", t.getInState());
		}
		if(StringUtils.isNotBlank(t.getInSendTime())){
			parameter.addUpdate("inSendTime", t.getInSendTime());
		}
		if(StringUtils.isNotBlank(t.getInReceiptTime())){
			parameter.addUpdate("inReceiptTime", t.getInReceiptTime());
		}
		if(StringUtils.isNotBlank(t.getInRefundTime())){
			parameter.addUpdate("inRefundTime", t.getInRefundTime());
		}
		if(StringUtils.isNotBlank(t.getInRefundFinishTime())){
			parameter.addUpdate("inRefundFinishTime", t.getInRefundFinishTime());
		}
		if(StringUtils.isNotBlank(t.getInRefundMoney())){
			parameter.addUpdate("inRefundMoney", t.getInRefundMoney());
		}
		if(StringUtils.isNotBlank(t.getInCarriage())){
			parameter.addUpdate("inCarriage", t.getInCarriage());
		}
		if(StringUtils.isNotBlank(t.getInInvoiceType())){
			parameter.addUpdate("inInvoiceType", t.getInInvoiceType());
		}
		if(StringUtils.isNotBlank(t.getInInvoiceCompany())){
			parameter.addUpdate("inInvoiceCompany", t.getInInvoiceCompany());
		}
		if(StringUtils.isNotBlank(t.getInCancelTime())){
			parameter.addUpdate("inCancelTime", t.getInCancelTime());
		}
		if(StringUtils.isNotBlank(t.getInPrivilegeMoney())){
			parameter.addUpdate("inPrivilegeMoney", t.getInPrivilegeMoney());
		}
		if(StringUtils.isNotBlank(t.getInOriginalMoney())){
			parameter.addUpdate("inOriginalMoney", t.getInOriginalMoney());
		}
		if(StringUtils.isNotBlank(t.getInNowMoney())){
			parameter.addUpdate("inNowMoney", t.getInNowMoney());
		}
		if(StringUtils.isNotBlank(t.getInZfTime())){
			parameter.addUpdate("inZfTime", t.getInZfTime());
		}
		if(StringUtils.isNotBlank(t.getInName())){
			parameter.addUpdate("inName", t.getInName());
		}
		if(StringUtils.isNotBlank(t.getInReceiptPhone())){
			parameter.addUpdate("inReceiptPhone", t.getInReceiptPhone());
		}
		this.tbOrderDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbOrder detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbOrder> result = this.tbOrderDao.page(parameter);
		for (TbOrder t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbOrder t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getInNum())){
			parameter.addQuery("inNum", t.getInNum());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getInPayment())){
			parameter.addQuery("inPayment", t.getInPayment());
		}
		if(StringUtils.isNotBlank(t.getInReceiptId())){
			parameter.addQuery("inReceiptId", t.getInReceiptId());
		}
		if(StringUtils.isNotBlank(t.getAddress())){
			parameter.addQuery("address", t.getAddress());
		}
		if(StringUtils.isNotBlank(t.getInCommitTime())){
			parameter.addQuery("inCommitTime", t.getInCommitTime());
		}
		if(StringUtils.isNotBlank(t.getInState())){
			parameter.addQuery("inState", t.getInState());
		}
		if(StringUtils.isNotBlank(t.getInSendTime())){
			parameter.addQuery("inSendTime", t.getInSendTime());
		}
		if(StringUtils.isNotBlank(t.getInReceiptTime())){
			parameter.addQuery("inReceiptTime", t.getInReceiptTime());
		}
		if(StringUtils.isNotBlank(t.getInRefundTime())){
			parameter.addQuery("inRefundTime", t.getInRefundTime());
		}
		if(StringUtils.isNotBlank(t.getInRefundFinishTime())){
			parameter.addQuery("inRefundFinishTime", t.getInRefundFinishTime());
		}
		if(StringUtils.isNotBlank(t.getInRefundMoney())){
			parameter.addQuery("inRefundMoney", t.getInRefundMoney());
		}
		if(StringUtils.isNotBlank(t.getInCarriage())){
			parameter.addQuery("inCarriage", t.getInCarriage());
		}
		if(StringUtils.isNotBlank(t.getInInvoiceType())){
			parameter.addQuery("inInvoiceType", t.getInInvoiceType());
		}
		if(StringUtils.isNotBlank(t.getInInvoiceCompany())){
			parameter.addQuery("inInvoiceCompany", t.getInInvoiceCompany());
		}
		if(StringUtils.isNotBlank(t.getInCancelTime())){
			parameter.addQuery("inCancelTime", t.getInCancelTime());
		}
		if(StringUtils.isNotBlank(t.getInPrivilegeMoney())){
			parameter.addQuery("inPrivilegeMoney", t.getInPrivilegeMoney());
		}
		if(StringUtils.isNotBlank(t.getInOriginalMoney())){
			parameter.addQuery("inOriginalMoney", t.getInOriginalMoney());
		}
		if(StringUtils.isNotBlank(t.getInNowMoney())){
			parameter.addQuery("inNowMoney", t.getInNowMoney());
		}
		if(StringUtils.isNotBlank(t.getInZfTime())){
			parameter.addQuery("inZfTime", t.getInZfTime());
		}
		if(StringUtils.isNotBlank(t.getInName())){
			parameter.addQuery("inName", t.getInName());
		}
		if(StringUtils.isNotBlank(t.getInReceiptPhone())){
			parameter.addQuery("inReceiptPhone", t.getInReceiptPhone());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbOrder> list=this.tbOrderDao.page(parameter);
		Pager page=new Pager(totalCount(parameter),pageNo,pageSize);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list",list);
		map.put("page",page);
		return map;
	}
	/**
	 * 查询总数
	 * @param parameter
	 * @return
	 */
	private long totalCount(SqlParameter parameter ) {
		return tbOrderDao.totalCount(parameter);
	}
}