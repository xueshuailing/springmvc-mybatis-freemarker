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
import com.my.dao.TbClassifyGoodsDao;
import com.my.entity.TbClassifyGoods;
/**
 * service层
 */
@Service
@Transactional
public class TbClassifyGoodsService {
	@Resource
	private TbClassifyGoodsDao tbClassifyGoodsDao;
	/**
	*保存
	*/
	public void save(TbClassifyGoods t) throws Exception{
		this.tbClassifyGoodsDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbClassifyGoods t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getClassifyId())){
			parameter.addQuery("classifyId", t.getClassifyId());
		}
		if(StringUtils.isNotBlank(t.getGoodsId())){
			parameter.addQuery("goodsId", t.getGoodsId());
		}
		if(StringUtils.isNotBlank(t.getGoodsNum())){
			parameter.addQuery("goodsNum", t.getGoodsNum());
		}
		this.tbClassifyGoodsDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbClassifyGoodsDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbClassifyGoods t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getClassifyId())){
			parameter.addUpdate("classifyId", t.getClassifyId());
		}
		if(StringUtils.isNotBlank(t.getGoodsId())){
			parameter.addUpdate("goodsId", t.getGoodsId());
		}
		if(StringUtils.isNotBlank(t.getGoodsNum())){
			parameter.addUpdate("goodsNum", t.getGoodsNum());
		}
		this.tbClassifyGoodsDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbClassifyGoods detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbClassifyGoods> result = this.tbClassifyGoodsDao.page(parameter);
		for (TbClassifyGoods t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbClassifyGoods t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getClassifyId())){
			parameter.addQuery("classifyId", t.getClassifyId());
		}
		if(StringUtils.isNotBlank(t.getGoodsId())){
			parameter.addQuery("goodsId", t.getGoodsId());
		}
		if(StringUtils.isNotBlank(t.getGoodsNum())){
			parameter.addQuery("goodsNum", t.getGoodsNum());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbClassifyGoods> list=this.tbClassifyGoodsDao.page(parameter);
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
		return tbClassifyGoodsDao.totalCount(parameter);
	}
}