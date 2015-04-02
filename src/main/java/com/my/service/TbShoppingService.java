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
import com.my.dao.TbShoppingDao;
import com.my.entity.TbShopping;
/**
 * service层
 */
@Service
@Transactional
public class TbShoppingService {
	@Resource
	private TbShoppingDao tbShoppingDao;
	/**
	*保存
	*/
	public void save(TbShopping t) throws Exception{
		this.tbShoppingDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbShopping t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getGoodsId())){
			parameter.addQuery("goodsId", t.getGoodsId());
		}
		if(StringUtils.isNotBlank(t.getGoodsName())){
			parameter.addQuery("goodsName", t.getGoodsName());
		}
		if(StringUtils.isNotBlank(t.getGoodsNum())){
			parameter.addQuery("goodsNum", t.getGoodsNum());
		}
		if(StringUtils.isNotBlank(t.getGoodsUrl())){
			parameter.addQuery("goodsUrl", t.getGoodsUrl());
		}
		if(StringUtils.isNotBlank(t.getGoodsCount())){
			parameter.addQuery("goodsCount", t.getGoodsCount());
		}
		if(StringUtils.isNotBlank(t.getGoodsPrice())){
			parameter.addQuery("goodsPrice", t.getGoodsPrice());
		}
		if(StringUtils.isNotBlank(t.getShoppingCount())){
			parameter.addQuery("shoppingCount", t.getShoppingCount());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		this.tbShoppingDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbShoppingDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbShopping t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getGoodsId())){
			parameter.addUpdate("goodsId", t.getGoodsId());
		}
		if(StringUtils.isNotBlank(t.getGoodsName())){
			parameter.addUpdate("goodsName", t.getGoodsName());
		}
		if(StringUtils.isNotBlank(t.getGoodsNum())){
			parameter.addUpdate("goodsNum", t.getGoodsNum());
		}
		if(StringUtils.isNotBlank(t.getGoodsUrl())){
			parameter.addUpdate("goodsUrl", t.getGoodsUrl());
		}
		if(StringUtils.isNotBlank(t.getGoodsCount())){
			parameter.addUpdate("goodsCount", t.getGoodsCount());
		}
		if(StringUtils.isNotBlank(t.getGoodsPrice())){
			parameter.addUpdate("goodsPrice", t.getGoodsPrice());
		}
		if(StringUtils.isNotBlank(t.getShoppingCount())){
			parameter.addUpdate("shoppingCount", t.getShoppingCount());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addUpdate("userId", t.getUserId());
		}
		this.tbShoppingDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbShopping detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbShopping> result = this.tbShoppingDao.page(parameter);
		for (TbShopping t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbShopping t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getGoodsId())){
			parameter.addQuery("goodsId", t.getGoodsId());
		}
		if(StringUtils.isNotBlank(t.getGoodsName())){
			parameter.addQuery("goodsName", t.getGoodsName());
		}
		if(StringUtils.isNotBlank(t.getGoodsNum())){
			parameter.addQuery("goodsNum", t.getGoodsNum());
		}
		if(StringUtils.isNotBlank(t.getGoodsUrl())){
			parameter.addQuery("goodsUrl", t.getGoodsUrl());
		}
		if(StringUtils.isNotBlank(t.getGoodsCount())){
			parameter.addQuery("goodsCount", t.getGoodsCount());
		}
		if(StringUtils.isNotBlank(t.getGoodsPrice())){
			parameter.addQuery("goodsPrice", t.getGoodsPrice());
		}
		if(StringUtils.isNotBlank(t.getShoppingCount())){
			parameter.addQuery("shoppingCount", t.getShoppingCount());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbShopping> list=this.tbShoppingDao.page(parameter);
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
		return tbShoppingDao.totalCount(parameter);
	}
}