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
import com.my.dao.TbFinancialDao;
import com.my.entity.TbFinancial;
/**
 * 家庭收入、支出表service层
 */
@Service
@Transactional
public class TbFinancialService {
	@Resource
	private TbFinancialDao tbFinancialDao;
	/**
	*保存
	*/
	public void save(TbFinancial t) throws Exception{
		this.tbFinancialDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbFinancial t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getTypeId())){
			parameter.addQuery("typeId", t.getTypeId());
		}
		if(StringUtils.isNotBlank(t.getNum())){
			parameter.addQuery("num", t.getNum());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addQuery("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getFamilyId())){
			parameter.addQuery("familyId", t.getFamilyId());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getFamilySex())){
			parameter.addQuery("familySex", t.getFamilySex());
		}
		if(StringUtils.isNotBlank(t.getFamilyAge())){
			parameter.addQuery("familyAge", t.getFamilyAge());
		}
		if(StringUtils.isNotBlank(t.getFlag())){
			parameter.addQuery("flag", t.getFlag());
		}
		if(StringUtils.isNotBlank(t.getRemark())){
			parameter.addQuery("remark", t.getRemark());
		}
		this.tbFinancialDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbFinancialDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbFinancial t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getTypeId())){
			parameter.addUpdate("typeId", t.getTypeId());
		}
		if(StringUtils.isNotBlank(t.getNum())){
			parameter.addUpdate("num", t.getNum());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addUpdate("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getFamilyId())){
			parameter.addUpdate("familyId", t.getFamilyId());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addUpdate("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getFamilySex())){
			parameter.addUpdate("familySex", t.getFamilySex());
		}
		if(StringUtils.isNotBlank(t.getFamilyAge())){
			parameter.addUpdate("familyAge", t.getFamilyAge());
		}
		if(StringUtils.isNotBlank(t.getFlag())){
			parameter.addUpdate("flag", t.getFlag());
		}
		if(StringUtils.isNotBlank(t.getRemark())){
			parameter.addUpdate("remark", t.getRemark());
		}
		this.tbFinancialDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbFinancial detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbFinancial> result = this.tbFinancialDao.page(parameter);
		for (TbFinancial t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbFinancial t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getTypeId())){
			parameter.addQuery("typeId", t.getTypeId());
		}
		if(StringUtils.isNotBlank(t.getNum())){
			parameter.addQuery("num", t.getNum());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addQuery("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getFamilyId())){
			parameter.addQuery("familyId", t.getFamilyId());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getFamilySex())){
			parameter.addQuery("familySex", t.getFamilySex());
		}
		if(StringUtils.isNotBlank(t.getFamilyAge())){
			parameter.addQuery("familyAge", t.getFamilyAge());
		}
		if(StringUtils.isNotBlank(t.getFlag())){
			parameter.addQuery("flag", t.getFlag());
		}
		if(StringUtils.isNotBlank(t.getRemark())){
			parameter.addQuery("remark", t.getRemark());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbFinancial> list=this.tbFinancialDao.page(parameter);
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
		return tbFinancialDao.totalCount(parameter);
	}
}