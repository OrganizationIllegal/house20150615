package com.kate.app.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.ProjectInputDao;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.User;

@Controller
public class ProjectInfoController {
	@Autowired
	private ProjectInputDao projectInputDao;
	
	@RequestMapping({"/ProjectInput"})
	public String getProjectCodeAndName(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("aaaaaaaaaaaaaaaa");
		List<String> codeAndNameSet=projectInputDao.getDeveloperCodeName();
		req.setAttribute("codeAndNameSet", codeAndNameSet);
		return "/ProjectInput.jsp";
	}
	//项目列表
	@RequestMapping({ "/ProjectInfoList" })    
	public void selectProjectList(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = projectInputDao.selectProjectList();
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
	
}
