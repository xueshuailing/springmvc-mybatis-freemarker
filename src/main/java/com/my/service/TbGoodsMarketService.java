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
import com.my.dao.TbGoodsMarketDao;
import com.my.entity.TbGoodsMarket;
/**
 * service层
 */
@Service
@Transactional
public class TbGoodsMarketService {
	@Resource
	private TbGoodsMarketDao tbGoodsMarketDao;
	/**
	*保存
	*/
	public void save(TbGoodsMarket t) throws Exception{
		this.tbGoodsMarketDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbGoodsMarket t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getGoodsId())){
			parameter.addQuery("goodsId", t.getGoodsId());
		}
		if(StringUtils.isNotBlank(t.getGoodsNum())){
			parameter.addQuery("goodsNum", t.getGoodsNum());
		}
		if(StringUtils.isNotBlank(t.getMarketId())){
			parameter.addQuery("marketId", t.getMarketId());
		}
		this.tbGoodsMarketDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbGoodsMarketDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbGoodsMarket t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getGoodsId())){
			parameter.addUpdate("goodsId", t.getGoodsId());
		}
		if(StringUtils.isNotBlank(t.getGoodsNum())){
			parameter.addUpdate("goodsNum", t.getGoodsNum());
		}
		if(StringUtils.isNotBlank(t.getMarketId())){
			parameter.addUpdate("marketId", t.getMarketId());
		}
		this.tbGoodsMarketDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbGoodsMarket detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbGoodsMarket> result = this.tbGoodsMarketDao.page(parameter);
		for (TbGoodsMarket t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbGoodsMarket t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getGoodsId())){
			parameter.addQuery("goodsId", t.getGoodsId());
		}
		if(StringUtils.isNotBlank(t.getGoodsNum())){
			parameter.addQuery("goodsNum", t.getGoodsNum());
		}
		if(StringUtils.isNotBlank(t.getMarketId())){
			parameter.addQuery("marketId", t.getMarketId());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbGoodsMarket> list=this.tbGoodsMarketDao.page(parameter);
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
		return tbGoodsMarketDao.totalCount(parameter);
	}
}