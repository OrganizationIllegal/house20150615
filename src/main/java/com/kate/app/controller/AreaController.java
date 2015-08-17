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
import com.kate.app.dao.AreaDao;
import com.kate.app.dao.CityDao;
import com.kate.app.model.Area;

@Controller
public class AreaController {
	@Autowired
	private AreaDao areadao;
	@Autowired
	private CityDao citydao;
	
	//根据id查找开发商信息
	@RequestMapping({ "/LiandongAreaAdd" })
	public String LiandongAreaEdit(HttpServletRequest req,HttpServletResponse resp){
		List<String> citylist=citydao.CityList();
		req.setAttribute("citylist", citylist);
		return "/LiandongAreaAdd.jsp";
	}
	//国家列表
	@RequestMapping({ "/areaList" })    
	public void selectAreaList(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array =areadao.selectAreaList();
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
	@RequestMapping({"/SaveAddArea" })
	public void saveAddNation(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean result=false;
		result=areadao.SaveAddArea(req.getParameter("area_name"),req.getParameter("area_num"),req.getParameter("center_gps"),req.getParameter("pre_num"));
		json.put("flag", result);		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//保存修改国家
	@RequestMapping({"/SaveUpdateArea" })
	public void saveUpdateNation(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean result=false;
		result=areadao.SaveUpdateArea(Integer.parseInt(req.getParameter("id")),req.getParameter("area_name"),req.getParameter("area_num"),req.getParameter("center_gps"),req.getParameter("pre_num"));
		json.put("flag", result);		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//根据id查找开发商信息
	@RequestMapping({ "/selectLiandongArea" })
	public String selectArea(HttpServletRequest req,HttpServletResponse resp){
		int id =Integer.parseInt(req.getParameter("id"));
		Area area=areadao.selectAreaInfo(id);
		req.setAttribute("area", area);
		List<String> citylist=citydao.CityList();
		req.setAttribute("citylist", citylist);
		return "/LiandongAreaEdit.jsp";
	}
	//保存修改国家
	@RequestMapping({"/deleteLiandongArea" })
	public void deleteCity(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean result=false;
		result=areadao.deleteArea(Integer.parseInt(req.getParameter("id")));
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
