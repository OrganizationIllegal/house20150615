package com.kate.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.AdDao;
import com.kate.app.model.HouseInfo;
import com.kate.app.service.BuyInfoService;
import com.kate.app.service.HouseInfoService;
import com.kate.app.service.RecoProjectSerivice;
import com.kate.app.service.SearchService;
import com.kate.app.model.HistorySearch;

import java.io.PrintWriter;
import java.sql.*;

@Controller
public class AdController {
	@Autowired
	private AdDao addao;

	//显示后台管理广告编辑页面（里面管理项目页面3个广告和服务团队1个广告）

	@RequestMapping({"/adEdit" })
	public String search(HttpServletRequest req,HttpServletResponse resp){
	
		List<String> ad1=addao.getad1();
		List<String> ad2=addao.getad2();
		List<String> ad3=addao.getad3();
		List<String> ad4=addao.getad4();
		req.setAttribute("ad1", ad1.get(0));
		req.setAttribute("ad2", ad2.get(0));
		req.setAttribute("ad3", ad3.get(0));
		req.setAttribute("ad4", ad4.get(0));
		req.setAttribute("ad1href", ad1.get(1));
		req.setAttribute("ad2href", ad2.get(1));
		req.setAttribute("ad3href", ad3.get(1));
		req.setAttribute("ad4href", ad4.get(1));
		return "/admanage.jsp";
	}

	//接受后台管理广告页面修改后的提交数据处理

	@RequestMapping({"/UpdateAdImage" })
	public void updateadimage(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		int result=0;
		String id=req.getParameter("id");
		String imagename=req.getParameter("imagename");
		String href=req.getParameter("href");
		if(id.equals("1")){
			result=addao.setad1(imagename,href);
		}
		else if(id.equalsIgnoreCase("2")){
			result=addao.setad2(imagename,href);
		}
		else if(id.equals("3")){
			result=addao.setad3(imagename,href);
		}
		else if(id.equals("4")){
			result=addao.setad4(imagename,href);
		}
		json.put("flag", result);		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//返回前端的json公用方法
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
