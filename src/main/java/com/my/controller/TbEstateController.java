package com.my.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.my.service.TbEstateService;
import com.my.entity.TbEstate;
/**
 * controller层
 */
@Controller
@RequestMapping(value = "/my/tbestate")
public class TbEstateController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TbEstateController.class);
	@Resource
	private TbEstateService tbEstateService;
	/**
	*保存
	*/
	@RequestMapping(value = "/save.html", method = {RequestMethod.POST,RequestMethod.GET})
	public String  save(Model model,TbEstate t,HttpServletRequest request,HttpServletResponse response){
		try {
			 this.tbEstateService.save(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("保存出错："+e.getMessage());
		}
		return "";
	}
	/**
	*通过查询条件删除
	*/
	@RequestMapping(value = "/deleteByParameter.html", method = {RequestMethod.POST,RequestMethod.GET})
	public String  deleteByParameter(Model model,TbEstate t,HttpServletRequest request,HttpServletResponse response){
		try {
			 this.tbEstateService.deleteByParameter(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("通过查询条件删除出错："+e.getMessage());
		}
		return "";
	}
	/**
	*通过id删除
	*/
	@RequestMapping(value = "/deleteById.html", method = {RequestMethod.POST,RequestMethod.GET})
	public String  deleteById(Model model,@RequestParam(value="id", required=true, defaultValue="0") String id,HttpServletRequest request,HttpServletResponse response){
		try {
			 this.tbEstateService.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("通过id删除出错："+e.getMessage());
		}
		return "";
	}
	/**
	*通过id修改
	*/
	@RequestMapping(value = "/update.html", method = {RequestMethod.POST,RequestMethod.GET})
	public String  update(Model model,TbEstate t,HttpServletRequest request,HttpServletResponse response){
		try {
			 this.tbEstateService.update(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("通过id修改出错："+e.getMessage());
		}
		return "";
	}
	/**
	*通过id查询--详情
	*/
	@RequestMapping(value = "/detail.html", method = {RequestMethod.POST,RequestMethod.GET})
	public String  detail(Model model,String id,HttpServletRequest request,HttpServletResponse response){
	TbEstate t=new TbEstate();
		try {
			  t= this.tbEstateService.detail(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("通过id查询--详情出错："+e.getMessage());
		}
		model.addAttribute("t", t);
		return "";
	}
	/**
	*通过查询条件查询--分页
	*/
	@RequestMapping(value = "/query.html", method = {RequestMethod.POST,RequestMethod.GET})
	public String  query(Model model,TbEstate t,@RequestParam(value="pageNo", required=true, defaultValue="1")  int pageNo,@RequestParam(value="pageSize", required=true, defaultValue="10") int pageSize,HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		try {
				map= this.tbEstateService.query(t,pageNo,pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("通过查询条件查询--分页出错："+e.getMessage());
		}
		model.addAttribute("list", map.get("list"));
		model.addAttribute("page", map.get("page"));
		return "TbEstate/list";
	}
	
	 
}