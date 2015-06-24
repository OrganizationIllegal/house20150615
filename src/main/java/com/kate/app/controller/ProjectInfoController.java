package com.kate.app.controller;

import java.io.PrintWriter;
import java.sql.SQLException;
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
import com.kate.app.dao.ProjectInputDao;

@Controller
public class ProjectInfoController {
	@Autowired
	private ProjectInputDao projectInputDao;
	@Autowired
	private AjaxDao ajaxDao;
	//显示开发商信息
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
	
	//添加项目
	@RequestMapping({ "/AddprojectInfo" })
	public void InsertProjectInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean flag = false;
		String project_name=req.getParameter("project_name");
		String project_img=req.getParameter("project_img");//？？？？
		String project_nation=req.getParameter("project_nation");
		String project_address=req.getParameter("project_address");
		String project_area=req.getParameter("project_area");
		//String project_price_qi=req.getParameter("project_price_qi");
		String project_price_qi=null;
		String project_type=req.getParameter("project_type");
		
		String project_sales_remain_str=req.getParameter("keshou");
		int project_sales_remain = project_sales_remain_str == "" ? 0 : Integer.parseInt(project_sales_remain_str);
		
		String project_finish_time=req.getParameter("finish_time");
		String project_desc=req.getParameter("project_desc");
		String project_city=req.getParameter("project_city");
		String project_house_type=req.getParameter("house_type");
		String project_high=req.getParameter("ceng");
		String project_price=req.getParameter("danjia");
		String project_lan_cn=req.getParameter("project_lan_an");
		String  project_lan_en=req.getParameter("project_lan_en");
		String project_num=req.getParameter("project_code");
		String  project_vedio=req.getParameter("project_video");
		String  project_zhou=req.getParameter("project_zhou");
		String area_qujian=null;//新表中没有此字段
		String gps=req.getParameter("GPS");
		String  return_money=req.getParameter("return_money");
		
		String walk_num_str = req.getParameter("walk_num");
		int walk_num = walk_num_str==""? 0 :Integer.parseInt(walk_num_str);
		

		String mianji=req.getParameter("mianji");
		String project_min_price=req.getParameter("minprice");
		String project_high_price=req.getParameter("maxprice");
		
		String tuijiandu_str = req.getParameter("tuijian");
		int tuijiandu = tuijiandu_str==""? 0 :Integer.parseInt(tuijiandu_str);
		
		String housePrice_update_time=req.getParameter("update_time");
		String buytaxInfo=req.getParameter("buyTaxInfo");
		String holdInfo=req.getParameter("holdCostInfo");
		
		String min_area_str=req.getParameter("minarea");
		int min_area = min_area_str=="" ? 0 : Integer.parseInt("min_area_str");
		
		String max_area_str=req.getParameter("maxarea");
		int max_area = max_area_str == "" ? 0 : Integer.parseInt(max_area_str);
		
		
		String area_num=null;//excel中没有这个字段
		
		//String developer_num_str=req.getParameter("develop_id");
		//int developer_num = developer_num_str == "" ? 0 : Integer.parseInt(developer_num_str);
		String developer_num=req.getParameter("develop_id");//开发商编号
		
	    try {
			flag=ajaxDao.addPro(project_name, project_img, project_nation, project_address, project_area, project_price_qi, project_type, project_sales_remain, project_finish_time, project_desc, project_city, project_house_type, project_high, project_price, project_lan_cn, project_lan_en, project_num, project_vedio, project_zhou, area_qujian, gps, return_money, walk_num, mianji, project_min_price, project_high_price, tuijiandu, housePrice_update_time, buytaxInfo, holdInfo, min_area, max_area, area_num, developer_num);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		json.put("flag", flag);
		try{
			 PrintWriter out = resp.getWriter();
			 out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		}
	}
	//添加学校信息
	@RequestMapping({ "/AddschoolInfo" })
	public void InsertSchoolInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean flag = false;
		String school_name=req.getParameter("school_name");
		String school_ranking=req.getParameter("school_rank");
		String  school_type=req.getParameter("school_type");
		
		String school_total_str=req.getParameter("school_total");
		int school_total = school_total_str == "" ? -1 :Integer.parseInt(school_total_str);
		
		String teacher_total_str=req.getParameter("teacher_num");
		int teacher_total = teacher_total_str == "" ? -1 :Integer.parseInt(teacher_total_str);
		
		String school_position=req.getParameter("school_position");
		String gps=req.getParameter("school_gps");
		String net_info=req.getParameter("school_url");
		
		String  not_en_stu_bili_str=req.getParameter("non_en_studen_trate");
		int not_en_stu_bili = not_en_stu_bili_str == "" ? -1 :Integer.parseInt(not_en_stu_bili_str);
		
		String school_image=req.getParameter("schoolimg");
		String school_desc=req.getParameter("school_intro");
	    flag=projectInputDao.InsertSchoolInfo(school_name, school_ranking, school_type, school_total, teacher_total, school_position, gps, net_info, not_en_stu_bili, school_image, school_desc);
		
	    if(flag==false){
	    	json.put("flag", "0");
	    }
	    else{
	    	json.put("flag", "1");
	    }
	/*	try{
			 PrintWriter out = resp.getWriter();
			 out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		}*/
	    try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@RequestMapping({ "/AddDeveloperInfo" })
	public void InsertDeveloperInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		String developer_name=req.getParameter("developer_name");
		String developer_logo=req.getParameter("developer_logo");
		String  developer_desc=req.getParameter("developer_desc");
		
		String developer_num=req.getParameter("developer_num");
		
	   boolean flagbol=projectInputDao.InsertDeveloperInfo(developer_name, developer_logo, developer_desc, developer_num);
	    if(flagbol==false){
	    	json.put("flag", "0");
		}
	    else{
	    	json.put("flag", "1");
	    }
		try{
			 PrintWriter out = resp.getWriter();
			 out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		}
	  /*  try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}*/
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
