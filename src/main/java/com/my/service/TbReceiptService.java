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
import com.my.dao.TbReceiptDao;
import com.my.entity.TbReceipt;
/**
 * 用户收货地址表service层
 */
@Service
@Transactional
public class TbReceiptService {
	@Resource
	private TbReceiptDao tbReceiptDao;
	/**
	*保存
	*/
	public void save(TbReceipt t) throws Exception{
		this.tbReceiptDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbReceipt t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getReceiptPhone())){
			parameter.addQuery("receiptPhone", t.getReceiptPhone());
		}
		if(StringUtils.isNotBlank(t.getIsDefault())){
			parameter.addQuery("isDefault", t.getIsDefault());
		}
		if(StringUtils.isNotBlank(t.getAddress())){
			parameter.addQuery("address", t.getAddress());
		}
		if(StringUtils.isNotBlank(t.getReceiptName())){
			parameter.addQuery("receiptName", t.getReceiptName());
		}
		if(StringUtils.isNotBlank(t.getProId())){
			parameter.addQuery("proId", t.getProId());
		}
		if(StringUtils.isNotBlank(t.getCityId())){
			parameter.addQuery("cityId", t.getCityId());
		}
		if(StringUtils.isNotBlank(t.getCountId())){
			parameter.addQuery("countId", t.getCountId());
		}
		this.tbReceiptDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbReceiptDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbReceipt t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addUpdate("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getReceiptPhone())){
			parameter.addUpdate("receiptPhone", t.getReceiptPhone());
		}
		if(StringUtils.isNotBlank(t.getIsDefault())){
			parameter.addUpdate("isDefault", t.getIsDefault());
		}
		if(StringUtils.isNotBlank(t.getAddress())){
			parameter.addUpdate("address", t.getAddress());
		}
		if(StringUtils.isNotBlank(t.getReceiptName())){
			parameter.addUpdate("receiptName", t.getReceiptName());
		}
		if(StringUtils.isNotBlank(t.getProId())){
			parameter.addUpdate("proId", t.getProId());
		}
		if(StringUtils.isNotBlank(t.getCityId())){
			parameter.addUpdate("cityId", t.getCityId());
		}
		if(StringUtils.isNotBlank(t.getCountId())){
			parameter.addUpdate("countId", t.getCountId());
		}
		this.tbReceiptDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbReceipt detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbReceipt> result = this.tbReceiptDao.page(parameter);
		for (TbReceipt t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbReceipt t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getReceiptPhone())){
			parameter.addQuery("receiptPhone", t.getReceiptPhone());
		}
		if(StringUtils.isNotBlank(t.getIsDefault())){
			parameter.addQuery("isDefault", t.getIsDefault());
		}
		if(StringUtils.isNotBlank(t.getAddress())){
			parameter.addQuery("address", t.getAddress());
		}
		if(StringUtils.isNotBlank(t.getReceiptName())){
			parameter.addQuery("receiptName", t.getReceiptName());
		}
		if(StringUtils.isNotBlank(t.getProId())){
			parameter.addQuery("proId", t.getProId());
		}
		if(StringUtils.isNotBlank(t.getCityId())){
			parameter.addQuery("cityId", t.getCityId());
		}
		if(StringUtils.isNotBlank(t.getCountId())){
			parameter.addQuery("countId", t.getCountId());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbReceipt> list=this.tbReceiptDao.page(parameter);
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
		return tbReceiptDao.totalCount(parameter);
	}
}