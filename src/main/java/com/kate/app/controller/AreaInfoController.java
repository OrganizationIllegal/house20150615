package com.kate.app.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.AjaxDao;
import com.kate.app.dao.AreaInputDao;
import com.kate.app.dao.NewsBokeDao;
import com.kate.app.dao.ZhiYeDao;

@Controller
public class AreaInfoController {
	@Autowired
	private AreaInputDao areaInputDao;
	@Autowired
	private NewsBokeDao newsBokeDao;
	@Autowired
	private ZhiYeDao zhiYeDao;
	
	//区域录入
	@RequestMapping({"/AreaInput"})
	public String areaInput(HttpServletRequest req,HttpServletResponse resp){
		getBrokerName(req,resp);
		getProjectName(req,resp);
		return "/areaLuru.jsp";
	}
	
	//得到经纪人的姓名
	@RequestMapping({"/AreaInput/Broker"})
	public void getBrokerName(HttpServletRequest req,HttpServletResponse resp){
		List<String> brolerNameSet=areaInputDao.getBrokerName();
		req.setAttribute("brolerNameSet", brolerNameSet);
	}
	//得到项目的名称
		@RequestMapping({"/AreaInput/Project"})
		public void getProjectName(HttpServletRequest req,HttpServletResponse resp){
			List<String> projectNameSet=areaInputDao.getProjectName();
			req.setAttribute("projectNameSet", projectNameSet);
		}
	//区域列表
	@RequestMapping({ "/AreaInfoList" })    
	public void selectAreaList(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = areaInputDao.selectAreaList();
		int count = array.size();
		json.put("total", count);
		json.put("rows", array);
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//新闻博客录入
	@RequestMapping({ "/inputNewsBoke" })
	public void inputNewsBoke(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String news_num = req.getParameter("news_num");
		String news_title  = req.getParameter("news_title");
		String news_people  = req.getParameter("news_people");
		String news_time = req.getParameter("news_time");
		String news_fenlei = req.getParameter("news_fenlei");
		String news_detail  = req.getParameter("news_detail");
		String news_image  = req.getParameter("news_image");
		String news_abstract  = req.getParameter("news_abstract");
		int flag = 0;
		JSONObject json = new JSONObject();
		flag =newsBokeDao.InsertNewsBoke(news_num, news_title, news_people, news_time, news_fenlei, news_abstract, news_detail, news_image);
		json.put("flag", flag);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//置业指导录入
		@RequestMapping({ "/inputZhiYe" })
		public void inputZhiYe(HttpServletRequest req, HttpServletResponse resp) throws Exception{
			String zhiye_num = req.getParameter("zhiye_num");
			String title  = req.getParameter("title");
			String fabu_people  = req.getParameter("fabu_people");
			String fabu_time = req.getParameter("fabu_time");
			String fenlei = req.getParameter("fenlei");
			String zhiye_abstract  = req.getParameter("zhiye_abstract");
			String image  = req.getParameter("image");
			String detail  = req.getParameter("detail");
			int flag = 0;
			JSONObject json = new JSONObject();
			flag =zhiYeDao.InsertZhiye(zhiye_num, title, fabu_people, fabu_time, fenlei, zhiye_abstract, detail, image);
			json.put("flag", flag);
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		//添加经纪人服务区域
				@RequestMapping({ "/addServiceArea" })
				public void addServiceArea(HttpServletRequest req, HttpServletResponse resp) throws Exception{
					int shunxu=0;
					String broker_num = req.getParameter("broker_num");
					String area_code  = req.getParameter("area_code");
					String view_shunxu  = req.getParameter("view_shunxu");
					if(view_shunxu!=null && !"".equals(view_shunxu)){
					shunxu=Integer.parseInt(view_shunxu);
					}
					int flag = 0;
					JSONObject json = new JSONObject();
					flag =areaInputDao.InsertServiceArea(broker_num, area_code, shunxu);
					json.put("flag", flag);
					try{
						writeJson(json.toJSONString(),resp);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				
				//添加经纪人服务区域
				@RequestMapping({ "/addInteType" })
				public void addInteType(HttpServletRequest req, HttpServletResponse resp) throws Exception{
					int shunxu=0;
					String broker_num = req.getParameter("broker_num");
					String interested_num  = req.getParameter("interested_num");
					String view_shunxu  = req.getParameter("view_shunxu");
					if(view_shunxu!=null && !"".equals(view_shunxu)){
					shunxu=Integer.parseInt(view_shunxu);
					}
					int flag = 0;
					JSONObject json = new JSONObject();
					flag =areaInputDao.InsertInteType(broker_num, interested_num, shunxu);
					json.put("flag", flag);
					try{
						writeJson(json.toJSONString(),resp);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}

		//经纪人录入
				@RequestMapping({ "/inputBroker" })
				public void inputBroler(HttpServletRequest req, HttpServletResponse resp) throws Exception{
					int experience=0;
					String broker_num = req.getParameter("broker_num");
					String broker_name  = req.getParameter("broker_name");
					String broker_language  = req.getParameter("broker_language");
					String broker_region = req.getParameter("broker_region");
					String broker_type = req.getParameter("broker_type");
					String broker_zizhi  = req.getParameter("broker_zizhi");
					String broker_experience  = req.getParameter("broker_experience");
					String broker_img  = req.getParameter("broker_img");
					String introduction  = req.getParameter("introduction");
					String type_num  = req.getParameter("type_num");
					String type_name  = req.getParameter("type_name");
					String type_image  = req.getParameter("type_image");
					if(broker_experience!=null && !"".equals(broker_experience)){
						experience=Integer.parseInt(broker_experience);	
					}
					JSONObject json = new JSONObject();
					int flag1 =areaInputDao.insertBrokerInfo(broker_name, broker_language, broker_region, broker_img, experience, broker_num, broker_type, broker_zizhi, introduction);
					int flag2 =areaInputDao.InsertInteType2(type_num, type_name, type_image);
					//System.out.println(flag1);
					//System.out.println(flag2);
					json.put("flag", flag1+flag2);
					try{
						writeJson(json.toJSONString(),resp);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				
	public void writeJson(String json, HttpServletResponse response)throws Exception{
	    response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    if(StringUtils.isNotEmpty(json)){
	        out.println(json);
	    }
	    out.flush();
	    out.close();
	}
	
	
}
