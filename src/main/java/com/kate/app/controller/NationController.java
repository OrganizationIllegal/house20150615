package com.kate.app.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.NationDao;
import com.kate.app.model.Nation;

@Controller
public class NationController {
	@Autowired
	private NationDao ndao;
	//国家列表
	@RequestMapping({ "/nationList" })    
	public void selectAreaList(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array =ndao.selectNationList();
		int count = array.size();
		json.put("total", count);
		json.put("rows", array);
		
		try{
			writeJson(array.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//保存新增国家
	@RequestMapping({"/SaveAddNation" })
	public void saveAddNation(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean result=false;
		result=ndao.SaveAddNation(req.getParameter("nation_name"),req.getParameter("nation_num"),req.getParameter("center_gps"));
		json.put("flag", result);		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//保存修改国家
	@RequestMapping({"/SaveUpdateNation" })
	public void saveUpdateNation(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean result=false;
		result=ndao.SaveUpdateNation(Integer.parseInt(req.getParameter("id")),req.getParameter("nation_name"),req.getParameter("nation_num"),req.getParameter("center_gps"));
		json.put("flag", result);		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//根据id查找开发商信息
	@RequestMapping({ "/selectNation" })
	public String selectDeveloperInfo(HttpServletRequest req,HttpServletResponse resp){
		int id =Integer.parseInt(req.getParameter("id"));
		Nation nation=ndao.selectNationInfo(id);
		req.setAttribute("nation", nation);
		return "/EditNation.jsp";
	}
	//保存修改国家
	@RequestMapping({"/deleteNation" })
	public void deleteNation(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean result=false;
		result=ndao.deleteNation(Integer.parseInt(req.getParameter("id")));
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
