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
import com.kate.app.dao.IndexRecoProManageDao;
import com.kate.app.model.HouseInfo;
import com.kate.app.service.BuyInfoService;
import com.kate.app.service.HouseInfoService;
import com.kate.app.service.RecoProjectSerivice;
import com.kate.app.service.SearchService;
import com.kate.app.model.HistorySearch;

import java.io.PrintWriter;
import java.sql.*;

@Controller
public class IndexRecommendManageController {
	@Autowired
	private IndexRecoProManageDao indexrecodao;
	
	//后台编辑首页推荐项目的action
	@RequestMapping({"/IndexRecoEdit" })
	public String search(HttpServletRequest req,HttpServletResponse resp){
		List<String> recos=new ArrayList<String>();
		recos=indexrecodao.getRecos();
		req.setAttribute("mreco1", recos.get(0));
		req.setAttribute("mreco2", recos.get(1));
		req.setAttribute("mreco3", recos.get(2));
		req.setAttribute("sreco1", recos.get(3));
		req.setAttribute("sreco2", recos.get(4));
		req.setAttribute("sreco3", recos.get(5));
		return "/IndexRecommendProjects.jsp";
	}
	//接收后台编辑首页推荐项目的ajax action
	@RequestMapping({"/UpdateIndexRecoPro" })
	public void updateadimage(HttpServletRequest req, HttpServletResponse resp){
		List<String> recos=new ArrayList<String>();
		JSONObject json = new JSONObject();
		int result=0;
		recos.add(req.getParameter("mreco1"));
		recos.add(req.getParameter("mreco2"));
		recos.add(req.getParameter("mreco3"));
		recos.add(req.getParameter("sreco1"));
		recos.add(req.getParameter("sreco2"));
		recos.add(req.getParameter("sreco3"));
		result=indexrecodao.setRecos(recos);
		json.put("flag", result);		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//返回json公用写方法
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
