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
import com.my.dao.TbGoodsPicDao;
import com.my.entity.TbGoodsPic;
/**
 * service层
 */
@Service
@Transactional
public class TbGoodsPicService {
	@Resource
	private TbGoodsPicDao tbGoodsPicDao;
	/**
	*保存
	*/
	public void save(TbGoodsPic t) throws Exception{
		this.tbGoodsPicDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbGoodsPic t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getGoodsOriginalPicUrl())){
			parameter.addQuery("goodsOriginalPicUrl", t.getGoodsOriginalPicUrl());
		}
		if(StringUtils.isNotBlank(t.getGoodsThumbPicUrl())){
			parameter.addQuery("goodsThumbPicUrl", t.getGoodsThumbPicUrl());
		}
		if(StringUtils.isNotBlank(t.getGoodsSort())){
			parameter.addQuery("goodsSort", t.getGoodsSort());
		}
		if(StringUtils.isNotBlank(t.getGoodsCreateTime())){
			parameter.addQuery("goodsCreateTime", t.getGoodsCreateTime());
		}
		if(StringUtils.isNotBlank(t.getGoodsNumber())){
			parameter.addQuery("goodsNumber", t.getGoodsNumber());
		}
		if(StringUtils.isNotBlank(t.getIsShow())){
			parameter.addQuery("isShow", t.getIsShow());
		}
		this.tbGoodsPicDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbGoodsPicDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbGoodsPic t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getGoodsOriginalPicUrl())){
			parameter.addUpdate("goodsOriginalPicUrl", t.getGoodsOriginalPicUrl());
		}
		if(StringUtils.isNotBlank(t.getGoodsThumbPicUrl())){
			parameter.addUpdate("goodsThumbPicUrl", t.getGoodsThumbPicUrl());
		}
		if(StringUtils.isNotBlank(t.getGoodsSort())){
			parameter.addUpdate("goodsSort", t.getGoodsSort());
		}
		if(StringUtils.isNotBlank(t.getGoodsCreateTime())){
			parameter.addUpdate("goodsCreateTime", t.getGoodsCreateTime());
		}
		if(StringUtils.isNotBlank(t.getGoodsNumber())){
			parameter.addUpdate("goodsNumber", t.getGoodsNumber());
		}
		if(StringUtils.isNotBlank(t.getIsShow())){
			parameter.addUpdate("isShow", t.getIsShow());
		}
		this.tbGoodsPicDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbGoodsPic detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbGoodsPic> result = this.tbGoodsPicDao.page(parameter);
		for (TbGoodsPic t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbGoodsPic t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getGoodsOriginalPicUrl())){
			parameter.addQuery("goodsOriginalPicUrl", t.getGoodsOriginalPicUrl());
		}
		if(StringUtils.isNotBlank(t.getGoodsThumbPicUrl())){
			parameter.addQuery("goodsThumbPicUrl", t.getGoodsThumbPicUrl());
		}
		if(StringUtils.isNotBlank(t.getGoodsSort())){
			parameter.addQuery("goodsSort", t.getGoodsSort());
		}
		if(StringUtils.isNotBlank(t.getGoodsCreateTime())){
			parameter.addQuery("goodsCreateTime", t.getGoodsCreateTime());
		}
		if(StringUtils.isNotBlank(t.getGoodsNumber())){
			parameter.addQuery("goodsNumber", t.getGoodsNumber());
		}
		if(StringUtils.isNotBlank(t.getIsShow())){
			parameter.addQuery("isShow", t.getIsShow());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbGoodsPic> list=this.tbGoodsPicDao.page(parameter);
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
		return tbGoodsPicDao.totalCount(parameter);
	}
}