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
import com.my.dao.TbOrderGoodsDao;
import com.my.entity.TbOrderGoods;
/**
 * service层
 */
@Service
@Transactional
public class TbOrderGoodsService {
	@Resource
	private TbOrderGoodsDao tbOrderGoodsDao;
	/**
	*保存
	*/
	public void save(TbOrderGoods t) throws Exception{
		this.tbOrderGoodsDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbOrderGoods t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getGoodsId())){
			parameter.addQuery("goodsId", t.getGoodsId());
		}
		if(StringUtils.isNotBlank(t.getGoodsNumber())){
			parameter.addQuery("goodsNumber", t.getGoodsNumber());
		}
		if(StringUtils.isNotBlank(t.getInId())){
			parameter.addQuery("inId", t.getInId());
		}
		if(StringUtils.isNotBlank(t.getInNumber())){
			parameter.addQuery("inNumber", t.getInNumber());
		}
		if(StringUtils.isNotBlank(t.getGoodsCount())){
			parameter.addQuery("goodsCount", t.getGoodsCount());
		}
		this.tbOrderGoodsDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbOrderGoodsDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbOrderGoods t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getGoodsId())){
			parameter.addUpdate("goodsId", t.getGoodsId());
		}
		if(StringUtils.isNotBlank(t.getGoodsNumber())){
			parameter.addUpdate("goodsNumber", t.getGoodsNumber());
		}
		if(StringUtils.isNotBlank(t.getInId())){
			parameter.addUpdate("inId", t.getInId());
		}
		if(StringUtils.isNotBlank(t.getInNumber())){
			parameter.addUpdate("inNumber", t.getInNumber());
		}
		if(StringUtils.isNotBlank(t.getGoodsCount())){
			parameter.addUpdate("goodsCount", t.getGoodsCount());
		}
		this.tbOrderGoodsDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbOrderGoods detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbOrderGoods> result = this.tbOrderGoodsDao.page(parameter);
		for (TbOrderGoods t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbOrderGoods t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getGoodsId())){
			parameter.addQuery("goodsId", t.getGoodsId());
		}
		if(StringUtils.isNotBlank(t.getGoodsNumber())){
			parameter.addQuery("goodsNumber", t.getGoodsNumber());
		}
		if(StringUtils.isNotBlank(t.getInId())){
			parameter.addQuery("inId", t.getInId());
		}
		if(StringUtils.isNotBlank(t.getInNumber())){
			parameter.addQuery("inNumber", t.getInNumber());
		}
		if(StringUtils.isNotBlank(t.getGoodsCount())){
			parameter.addQuery("goodsCount", t.getGoodsCount());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbOrderGoods> list=this.tbOrderGoodsDao.page(parameter);
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
		return tbOrderGoodsDao.totalCount(parameter);
	}
}