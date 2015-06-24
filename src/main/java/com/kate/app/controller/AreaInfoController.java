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
import com.kate.app.dao.AreaInputDao;
import com.kate.app.dao.NewsBokeDao;

@Controller
public class AreaInfoController {
	@Autowired
	private AreaInputDao areaInputDao;
	@Autowired
	private NewsBokeDao newsBokeDao;
	
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
	
	@RequestMapping({ "/inputNewsBoke" })
	public void inputNewsBoke(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		System.out.println("haha");
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
		System.out.println(flag);
		json.put("flag", flag);
		try{
			//writeJson(json.toJSONString(),resp);
			 PrintWriter out = resp.getWriter();
			 out.print(json);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}
