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
	
	@RequestMapping({"/adEdit" })
	public String search(HttpServletRequest req,HttpServletResponse resp){
	
		String ad1=addao.getad1();
		String ad2=addao.getad2();
		String ad3=addao.getad3();
		req.setAttribute("ad1", ad1);
		req.setAttribute("ad2", ad2);
		req.setAttribute("ad3", ad3);
		return "/admanage.jsp";
	}
	@RequestMapping({"/UpdateAdImage" })
	public void updateadimage(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		int result=0;
		String id=req.getParameter("id");
		String imagename=req.getParameter("imagename");
		if(id.equals("1")){
			result=addao.setad1(imagename);
		}
		else if(id.equalsIgnoreCase("2")){
			result=addao.setad2(imagename);
		}
		else if(id.equals("3")){
			result=addao.setad3(imagename);
		}
		json.put("flag", result);		
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
