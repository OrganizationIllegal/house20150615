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
import com.kate.app.dao.CityDao;
import com.kate.app.dao.NationDao;
import com.kate.app.model.City;

@Controller
public class CityController {
	@Autowired
	private CityDao citydao;
	@Autowired
	private NationDao nationdao;
	//根据id查找开发商信息
	@RequestMapping({ "/CityAdd" })
	public String CityAdd(HttpServletRequest req,HttpServletResponse resp){
		List<String> nationlist=nationdao.NationList();
		req.setAttribute("nationlist", nationlist);
		return "/CityAdd.jsp";
	}
	
	//国家列表
	@RequestMapping({ "/cityList" })    
	public void selectAreaList(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array =citydao.selectCityList();
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
	@RequestMapping({"/SaveAddCity" })
	public void saveAddNation(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean result=false;
		result=citydao.SaveAddCity(req.getParameter("city_name"),req.getParameter("city_num"),req.getParameter("center_gps"),req.getParameter("pre_num"));
		json.put("flag", result);		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//保存修改国家
	@RequestMapping({"/SaveUpdateCity" })
	public void saveUpdateNation(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean result=false;
		result=citydao.SaveUpdateCity(Integer.parseInt(req.getParameter("id")),req.getParameter("city_name"),req.getParameter("city_num"),req.getParameter("center_gps"),req.getParameter("pre_num"));
		json.put("flag", result);		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//根据id查找开发商信息
	@RequestMapping({ "/selectCity" })
	public String selectCity(HttpServletRequest req,HttpServletResponse resp){
		int id =Integer.parseInt(req.getParameter("id"));
		City city=citydao.selectCityInfo(id);
		req.setAttribute("city", city);
		List<String> nationlist=nationdao.NationList();
		req.setAttribute("nationlist", nationlist);
		return "/CityEdit.jsp";
	}
	//保存修改国家
	@RequestMapping({"/deleteCity" })
	public void deleteCity(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean result=false;
		result=citydao.deleteCity(Integer.parseInt(req.getParameter("id")));
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
