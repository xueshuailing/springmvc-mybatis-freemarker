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
import com.my.dao.TbGoodsDao;
import com.my.entity.TbGoods;
/**
 * service层
 */
@Service
@Transactional
public class TbGoodsService {
	@Resource
	private TbGoodsDao tbGoodsDao;
	/**
	*保存
	*/
	public void save(TbGoods t) throws Exception{
		this.tbGoodsDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbGoods t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getGoodsNumber())){
			parameter.addQuery("goodsNumber", t.getGoodsNumber());
		}
		if(StringUtils.isNotBlank(t.getGoodsName())){
			parameter.addQuery("goodsName", t.getGoodsName());
		}
		if(StringUtils.isNotBlank(t.getGoodsPrice())){
			parameter.addQuery("goodsPrice", t.getGoodsPrice());
		}
		if(StringUtils.isNotBlank(t.getGoodsDescribe())){
			parameter.addQuery("goodsDescribe", t.getGoodsDescribe());
		}
		if(StringUtils.isNotBlank(t.getGoodsCreateTime())){
			parameter.addQuery("goodsCreateTime", t.getGoodsCreateTime());
		}
		if(StringUtils.isNotBlank(t.getGoodsCreateUser())){
			parameter.addQuery("goodsCreateUser", t.getGoodsCreateUser());
		}
		if(StringUtils.isNotBlank(t.getGoodsPostage())){
			parameter.addQuery("goodsPostage", t.getGoodsPostage());
		}
		if(StringUtils.isNotBlank(t.getGoodsScprice())){
			parameter.addQuery("goodsScprice", t.getGoodsScprice());
		}
		if(StringUtils.isNotBlank(t.getGoodsKccount())){
			parameter.addQuery("goodsKccount", t.getGoodsKccount());
		}
		this.tbGoodsDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbGoodsDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbGoods t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getGoodsNumber())){
			parameter.addUpdate("goodsNumber", t.getGoodsNumber());
		}
		if(StringUtils.isNotBlank(t.getGoodsName())){
			parameter.addUpdate("goodsName", t.getGoodsName());
		}
		if(StringUtils.isNotBlank(t.getGoodsPrice())){
			parameter.addUpdate("goodsPrice", t.getGoodsPrice());
		}
		if(StringUtils.isNotBlank(t.getGoodsDescribe())){
			parameter.addUpdate("goodsDescribe", t.getGoodsDescribe());
		}
		if(StringUtils.isNotBlank(t.getGoodsCreateTime())){
			parameter.addUpdate("goodsCreateTime", t.getGoodsCreateTime());
		}
		if(StringUtils.isNotBlank(t.getGoodsCreateUser())){
			parameter.addUpdate("goodsCreateUser", t.getGoodsCreateUser());
		}
		if(StringUtils.isNotBlank(t.getGoodsPostage())){
			parameter.addUpdate("goodsPostage", t.getGoodsPostage());
		}
		if(StringUtils.isNotBlank(t.getGoodsScprice())){
			parameter.addUpdate("goodsScprice", t.getGoodsScprice());
		}
		if(StringUtils.isNotBlank(t.getGoodsKccount())){
			parameter.addUpdate("goodsKccount", t.getGoodsKccount());
		}
		this.tbGoodsDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbGoods detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbGoods> result = this.tbGoodsDao.page(parameter);
		for (TbGoods t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbGoods t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getGoodsNumber())){
			parameter.addQuery("goodsNumber", t.getGoodsNumber());
		}
		if(StringUtils.isNotBlank(t.getGoodsName())){
			parameter.addQuery("goodsName", t.getGoodsName());
		}
		if(StringUtils.isNotBlank(t.getGoodsPrice())){
			parameter.addQuery("goodsPrice", t.getGoodsPrice());
		}
		if(StringUtils.isNotBlank(t.getGoodsDescribe())){
			parameter.addQuery("goodsDescribe", t.getGoodsDescribe());
		}
		if(StringUtils.isNotBlank(t.getGoodsCreateTime())){
			parameter.addQuery("goodsCreateTime", t.getGoodsCreateTime());
		}
		if(StringUtils.isNotBlank(t.getGoodsCreateUser())){
			parameter.addQuery("goodsCreateUser", t.getGoodsCreateUser());
		}
		if(StringUtils.isNotBlank(t.getGoodsPostage())){
			parameter.addQuery("goodsPostage", t.getGoodsPostage());
		}
		if(StringUtils.isNotBlank(t.getGoodsScprice())){
			parameter.addQuery("goodsScprice", t.getGoodsScprice());
		}
		if(StringUtils.isNotBlank(t.getGoodsKccount())){
			parameter.addQuery("goodsKccount", t.getGoodsKccount());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbGoods> list=this.tbGoodsDao.page(parameter);
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
		return tbGoodsDao.totalCount(parameter);
	}
}