package com.kate.app.controller;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.AjaxDao;
import com.kate.app.dao.ImageDao;
import com.kate.app.dao.ProjectInputDao;
import com.kate.app.dao.SchoolNearDao;
import com.kate.app.model.HouseInfo1;
import com.kate.app.model.HouseProject;
import com.kate.app.model.Project;

@Controller
public class ProjectInfoController {
	@Autowired
	private ProjectInputDao projectInputDao;
	@Autowired
	private AjaxDao ajaxDao;
	@Autowired
	private SchoolNearDao schoolNearDao;
	
	//显示开发商信息
	@RequestMapping({"/ProjectInput"})
	public String getProjectCodeAndName(HttpServletRequest req,HttpServletResponse resp){
		//得到开发商的编号和名称
		List<String> codeAndNameSet=projectInputDao.getDeveloperCodeName();
		req.setAttribute("codeAndNameSet", codeAndNameSet);
		//得到所有学校的名称
		List<String> schoolList=projectInputDao.getAllSchoolName();
		req.setAttribute("schoolList", schoolList);
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
	//将jsons
	 public static<T> Object JSONToObj(String jsonStr,Class<T> obj) {
	        T t = null;
	        try {
	            ObjectMapper objectMapper = new ObjectMapper();
	            t = objectMapper.readValue(jsonStr,
	                    obj);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return t;
	    }
	//添加项目
	@RequestMapping({ "/AddprojectInfo" })
	public void InsertProjectInfo(HttpServletRequest req, HttpServletResponse resp){
		String project=req.getParameter("project");
		JSONArray projectArray = JSONArray.parseArray(project);
		List<Project> projectlist=new ArrayList<Project>();
		for (int i=0;i<projectArray.size();i++){
			 JSONObject object = (JSONObject)projectArray.get(i); //对于每个json对象
			 Project e = (Project) JSONToObj(object.toString(), Project.class);
			 projectlist.add(e);
		}
		System.out.println("projectlist.length():"+projectlist.size());
		
		String huxing=req.getParameter("huxinglist");
		JSONArray huxingArray = JSONArray.parseArray(huxing);
		List<HouseInfo1> houseInfolist=new ArrayList<HouseInfo1>();
		for (int i=0;i<huxingArray.size();i++){
			 JSONObject object = (JSONObject)huxingArray.get(i); //对于每个json对象
			 HouseInfo1 e = (HouseInfo1) JSONToObj(object.toString(), HouseInfo1.class);
			 houseInfolist.add(e);
		}
		System.out.println("houseInfolist.length():"+houseInfolist.size());
		
		
		
		
	    try {
			int result=projectInputDao.AddProject(projectlist);
			System.out.println("result::"+result);
	    } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*String bb=req.getParameter("bb");
		JSONArray jsonArray1 = JSONArray.parseArray(bb);//JSON数组
		List<BB> bblist=new ArrayList<BB>();
		for (int i=0;i<jsonArray1.size();i++){
			 JSONObject object = (JSONObject)jsonArray1.get(i); //对于每个json对象
			 BB e = (BB) JSONToObj(object.toString(), BB.class);
			 bblist.add(e);
		}
		System.out.println("bblist.length():"+bblist.size());
*/
		
		
		//int result=0;
		//System.out.println(aa.getProject_name());
	/*	String prolist=req.getParameter("prolist");*/
		//String[] prolist=req.getParameterValues("prolist");
		/*String prolist=req.getParameter("prolist");*/
		/*Enumeration strEn = req.getParameterNames();
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
		int min_area = min_area_str=="" ? 0 : Integer.parseInt(min_area_str);
		
		String max_area_str=req.getParameter("maxarea");
		int max_area = max_area_str == "" ? 0 : Integer.parseInt(max_area_str);
		
		
		String area_num=null;//excel中没有这个字段
		
		//String developer_num_str=req.getParameter("develop_id");
		//int developer_num = developer_num_str == "" ? 0 : Integer.parseInt(developer_num_str);
		//String developer_num=req.getParameter("develop_id");//开发商编号
		String developer_num=req.getParameter("developer_code");//开发商编号
		//接收户型及价格的参数
		String house_name=req.getParameter("housename");
		String house_img=req.getParameter("houseimg");
		String house_price=req.getParameter("houseprice");
		String house_room_num_str=req.getParameter("room_num");
		int house_room_num=house_room_num_str=="" ? -1 : Integer.parseInt(house_room_num_str);
		String tudi_area=req.getParameter("tudi_mianji");
		String jianzhu_area=req.getParameter("jianzhu_mianji");
		String house_size_in=req.getParameter("shinei_mianji");
		String house_size_out=req.getParameter("shiwai_mianji");
		String house_toilet_size_str=req.getParameter("wc_num");
		int house_toilet_size=house_toilet_size_str=="" ? -1 : Integer.parseInt(house_toilet_size_str);
		//项目配套的参数
		String image_name=req.getParameter("projectimage");
		//接收附近配套的参数
		String peitao_type=req.getParameter("peitao_type");
		String peitao_name=req.getParameter("peitao_name");
		String  peitao_distance=req.getParameter("peitao_distance");
		//接收附近学习的参数
		String school_name=req.getParameter("school_name");
		String school_distance=req.getParameter("school_distance");
		//接收持有成本的参数
		String hold_type=req.getParameter("holdcosttype");
		
		String hold_price_str=req.getParameter("holdcostprice");
		int hold_price = hold_price_str == "" ? -1 : Integer.parseInt(hold_price_str);
		
		String hold_description=req.getParameter("holdcostdesc");
		String hold_housename=req.getParameter("holdcost_housename");
		//购房税费
		String tax_type=req.getParameter("houseTaxtype");
		
		String tax_price_str=req.getParameter("houseTaxprice");
		int tax_price = tax_price_str == "" ? -1 : Integer.parseInt(tax_price_str);
		
		String tax_description=req.getParameter("houseTaxdesc");
		String tax_housename=req.getParameter("houseTax_housename");
		//String aa=req.getParameter("list");
		//String [] aa=req.getParameterValues("list");
		
		
		
		
	    try {
			result=projectInputDao.addPro(project_name, project_img, project_nation, project_address, project_area, project_price_qi, project_type, project_sales_remain, project_finish_time, project_desc, project_city, project_house_type, project_high, project_price, project_lan_cn, project_lan_en, project_num, project_vedio, project_zhou, area_qujian, gps, return_money, walk_num, mianji, project_min_price, project_high_price, tuijiandu, housePrice_update_time, buytaxInfo, holdInfo, min_area, max_area, area_num, developer_num,
					peitao_type,peitao_name,peitao_distance,
					house_name,house_img,house_price,house_room_num,tudi_area,jianzhu_area,house_size_in,house_size_out,house_toilet_size,
					image_name,
					school_name,school_distance,
					hold_type,hold_price,hold_description,hold_housename,
					tax_type,tax_price,tax_description,tax_housename
					);
	    } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		json.put("flag", result);
		try{
			 PrintWriter out = resp.getWriter();
			 out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		}*/
		//return "/ProjectInput.jsp";
	}
	//修改项目
	@RequestMapping({ "/EditprojectInfo" })
	public String  EditProjectInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean flag = false;
		int id=Integer.parseInt(req.getParameter("project_code"));
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
		int min_area = min_area_str=="" ? 0 : Integer.parseInt(min_area_str);
		
		String max_area_str=req.getParameter("maxarea");
		int max_area = max_area_str == "" ? 0 : Integer.parseInt(max_area_str);
		
		
		String area_num=null;//excel中没有这个字段
		
		//String developer_num_str=req.getParameter("develop_id");
		//int developer_num = developer_num_str == "" ? 0 : Integer.parseInt(developer_num_str);
		String developer_num=req.getParameter("develop_id");//开发商编号
		
		
		
		//接收附近配套的参数
		String peitao_type=req.getParameter("peitao_type");
		String peitao_name=req.getParameter("peitao_name");
		String  peitao_distance=req.getParameter("peitao_distance");
		
		
	    try {
			flag=ajaxDao.editPro(id, project_name, project_img, project_nation, project_address, project_area, project_price_qi, project_type, project_sales_remain, project_finish_time, project_desc, project_city, project_house_type, project_high, project_price, project_lan_cn, project_lan_en, project_num, project_vedio, project_zhou, area_qujian, gps, return_money, walk_num, mianji, project_min_price, project_high_price, tuijiandu, housePrice_update_time, buytaxInfo, holdInfo, min_area, max_area, area_num, developer_num);
					
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
		return "/ProjectList.jsp";
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
	}
	@RequestMapping(value = "/projectinput")
    public void handleFormUpload(
            @RequestParam("file") MultipartFile file, HttpServletResponse resp) {
		JSONObject json = new JSONObject();
		json.put("total", 1);
		json.put("rows", 1);
		
        if (!file.isEmpty()) {
//            byte[] bytes = file.getBytes();
            // store the bytes somewhere
//        	file.
        	try{
        		/*for(int i=0;i<file.length;i++){*/
        			ImageDao.CopyImage(file,new String(file.getOriginalFilename().getBytes("ISO8859_1"),"utf-8"));
        		/*}*/
        		
        		/*System.out.println(new String(file.getOriginalFilename().getBytes("utf-8"),"utf-8"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("utf-8"),"GBK"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("utf-8"),"gb2312"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("utf-8"),"iso-8859-1"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("GBK"),"utf-8"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("GBK"),"GBK"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("GBK"),"gb2312"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("GBK"),"iso-8859-1"));
        		System.out.println(new String(file.getOriginalFilename().getBytes(),"utf-8"));
        		System.out.println(new String(file.getOriginalFilename().getBytes(),"GBK"));
        		System.out.println(new String(file.getOriginalFilename().getBytes(),"gb2312"));
        		System.out.println(new String(file.getOriginalFilename().getBytes(),"iso-8859-1"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("GBK"),"iso-8859-1"));
        		System.out.println(new String(file.getOriginalFilename().getBytes()));
        		System.out.println(new String(file.getOriginalFilename().getBytes()));
        		System.out.println(new String(file.getOriginalFilename().getBytes()));*/
//        		System.out.println(new String(file.getOriginalFilename().getBytes("ISO8859_1"),"utf-8"));
        		/*System.out.println("中文");

                System.out.println("中文".getBytes());

                System.out.println("中文".getBytes("GB2312"));

                System.out.println("中文".getBytes("ISO8859_1"));

                System.out.println(new String("中文".getBytes()));

                System.out.println(new String("中文".getBytes(), "GB2312"));

                System.out.println(new String("中文".getBytes(), "ISO8859_1"));

                System.out.println(new String("中文".getBytes("GB2312")));

                System.out.println(new String("中文".getBytes("GB2312"), "GB2312"));

                System.out.println(new String("中文".getBytes("GB2312"), "ISO8859_1"));

                System.out.println(new String("中文".getBytes("ISO8859_1")));

                System.out.println(new String("中文".getBytes("ISO8859_1"), "GB2312"));

                System.out.println(new String("中文".getBytes("ISO8859_1"), "ISO8859_1"));*/
        	}
        	catch(Exception e){
        		e.printStackTrace();
        	}
        	try{
    			writeJson(json.toJSONString(),resp);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
            //return "redirect:uploadSuccess";
        }
        
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
        //return "redirect:uploadFailure";
    }
	//查找项目信息
	@RequestMapping({ "/selectProject" })
	public String selectProject(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		int id =Integer.parseInt(req.getParameter("id"));
		HouseProject houseProject=projectInputDao.selectProjectInfo(id);
		req.setAttribute("houseProject", houseProject);
		return "/ProjectInfo.jsp";
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
