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
import com.kate.app.model.FujinPeiTao;
import com.kate.app.model.FujinSchool;
import com.kate.app.model.HoldCost;
import com.kate.app.model.HouseInfo1;
import com.kate.app.model.HouseProject;
import com.kate.app.model.HouseTax;
import com.kate.app.model.Project;
import com.kate.app.model.ProjectPeiTao;
import com.kate.app.service.ConvertJson;

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
		//项目信息
		String project=req.getParameter("project");
		JSONArray projectArray = JSONArray.parseArray(project);
		List<Project> projectlist=new ArrayList<Project>();
		for (int i=0;i<projectArray.size();i++){
			 JSONObject object = (JSONObject)projectArray.get(i); //对于每个json对象
			 Project e = (Project) JSONToObj(object.toString(), Project.class);
			 projectlist.add(e);
		}
		System.out.println("projectlist.length():"+projectlist.size());
		//户型及价格
		String huxing=req.getParameter("huxinglist");
		JSONArray huxingArray = JSONArray.parseArray(huxing);
		List<HouseInfo1> houseInfolist=new ArrayList<HouseInfo1>();
		for (int i=0;i<huxingArray.size();i++){
			 JSONObject object = (JSONObject)huxingArray.get(i); //对于每个json对象
			 HouseInfo1 e = (HouseInfo1) JSONToObj(object.toString(), HouseInfo1.class);
			 houseInfolist.add(e);
		}
		System.out.println("houseInfolist.length():"+houseInfolist.size());
	    //项目配套
	    String peitao=req.getParameter("peitaolist");
		JSONArray peitaoArray = JSONArray.parseArray(peitao);
		List<ProjectPeiTao> projectPeitaolist=new ArrayList<ProjectPeiTao>();
		for (int i=0;i<peitaoArray.size();i++){
			 JSONObject object = (JSONObject)peitaoArray.get(i); //对于每个json对象
			 ProjectPeiTao e = (ProjectPeiTao) JSONToObj(object.toString(), ProjectPeiTao.class);
			 projectPeitaolist.add(e);
		}
		System.out.println("projectPeitaolist.length():"+projectPeitaolist.size());
		//附近配套
		String fujinpeitao=req.getParameter("fujinlist");
		JSONArray fujinArray = JSONArray.parseArray(fujinpeitao);
	    List<FujinPeiTao> fujinpeitaoList=new ArrayList<FujinPeiTao>();
		for (int i=0;i<fujinArray.size();i++){
				 JSONObject object = (JSONObject)fujinArray.get(i); //对于每个json对象
				 FujinPeiTao e = (FujinPeiTao) JSONToObj(object.toString(), FujinPeiTao.class);
				 fujinpeitaoList.add(e);
		}
		System.out.println("fujinpeitaoList.length():"+fujinpeitaoList.size());
		//附近学校
		String schoolInfo=req.getParameter("schoollist");
		JSONArray schoolArray = JSONArray.parseArray(schoolInfo);
	    List<FujinSchool> fujinSchoolList=new ArrayList<FujinSchool>();
		for (int i=0;i<schoolArray.size();i++){
				 JSONObject object = (JSONObject)schoolArray.get(i); //对于每个json对象
				 FujinSchool e = (FujinSchool) JSONToObj(object.toString(), FujinSchool.class);
				 fujinSchoolList.add(e);
		}
		System.out.println("fujinSchoolList.length():"+fujinSchoolList.size());
		//持有成本
		String holdingcost=req.getParameter("holdingcostlist");
		JSONArray holdCostArray = JSONArray.parseArray(holdingcost);
	    List<HoldCost> holdCostList=new ArrayList<HoldCost>();
		for (int i=0;i<holdCostArray.size();i++){
				 JSONObject object = (JSONObject)holdCostArray.get(i); //对于每个json对象
				 HoldCost e = (HoldCost) JSONToObj(object.toString(), HoldCost.class);
				 holdCostList.add(e);
		}
		System.out.println("holdCostList.length():"+holdCostList.size());
		//购房税费
		String houseTax=req.getParameter("housetaxformlist");
		JSONArray houseTaxArray = JSONArray.parseArray(houseTax);
		List<HouseTax> houseTaxList=new ArrayList<HouseTax>();
		for (int i=0;i<houseTaxArray.size();i++){
				 JSONObject object = (JSONObject)houseTaxArray.get(i); //对于每个json对象
				 HouseTax e = (HouseTax) JSONToObj(object.toString(), HouseTax.class);
				 houseTaxList.add(e);
		}
		System.out.println("houseTaxList.length():"+houseTaxList.size());
		//添加
	    try {
			int result=projectInputDao.AddProject(projectlist,houseInfolist,projectPeitaolist,fujinpeitaoList,fujinSchoolList,holdCostList,houseTaxList);
			System.out.println("result::"+result);
	    } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	//编辑项目
	@RequestMapping({ "/EditProject" })
	public void  EditProject(HttpServletRequest req,HttpServletResponse resp){
		//接收项目id
		int id=Integer.parseInt(req.getParameter("id"));
		//项目信息
		String project=req.getParameter("project");
		JSONArray projectArray = JSONArray.parseArray(project);
		List<Project> projectlist=new ArrayList<Project>();
		for (int i=0;i<projectArray.size();i++){
				JSONObject object = (JSONObject)projectArray.get(i); //对于每个json对象
				Project e = (Project) JSONToObj(object.toString(), Project.class);
			    projectlist.add(e);
		  }
		System.out.println("projectlist.length():"+projectlist.size());
		//户型及价格
	    String huxing=req.getParameter("huxinglist");
		JSONArray huxingArray = JSONArray.parseArray(huxing);
		List<HouseInfo1> houseInfolist=new ArrayList<HouseInfo1>();//存放要编辑的项
		List<HouseInfo1> houseInfolist2=new ArrayList<HouseInfo1>();//存放新添加的项
		for (int i=0;i<huxingArray.size();i++){
				JSONObject object = (JSONObject)huxingArray.get(i); //对于每个json对象
			    HouseInfo1 e = (HouseInfo1) JSONToObj(object.toString(), HouseInfo1.class);
			    if(e.getId()==0){
			    	houseInfolist2.add(e);
			    }
			    else{
			    	houseInfolist.add(e);
			    }
			}
		System.out.println("houseInfolist.length():"+houseInfolist.size());
		System.out.println("houseInfolist2.length():"+houseInfolist2.size());
		
		//更新
	    try {
			int result=projectInputDao.EditProject(id, projectlist,houseInfolist,houseInfolist2);
			System.out.println("result::"+result);
	    } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
	@RequestMapping(value = "/imageupload")
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
		//根据项目id取项目信息
		HouseProject houseProject=projectInputDao.selectProjectInfo(id);
		req.setAttribute("houseProject", houseProject);
		//根据项目id获取项目编号
		String pronum=projectInputDao.getProNumById(id);
		//根据项目编号获取户型及价格
		List<HouseInfo1> houseInfoList=projectInputDao.getHouseInfoByProNum(pronum);
		req.setAttribute("houseInfoList", houseInfoList);
		req.setAttribute("houseInfoListJson", ConvertJson.list2json(houseInfoList));
		//根据项目编号获取项目配套
		List <ProjectPeiTao> projectPeiTaoList =projectInputDao.getProjectpeiTaoByProNum(pronum);
		req.setAttribute("projectPeitaoList", projectPeiTaoList);
		//根据项目编号获取附近配套
		List<FujinPeiTao> fujinPeitaoList=projectInputDao.getFujinPeiTaoByProNum(pronum);
		req.setAttribute("fujinPeitaoList",fujinPeitaoList );
		//根据项目编号获取附近学校
		List<FujinSchool> fujinSchoolList=projectInputDao.getFujinSchoolByProNum(pronum);
		req.setAttribute("fujinSchoolList",fujinSchoolList );
		//根据项目编号获取持有成本
		List<HoldCost> holdCostList=projectInputDao.getHoldCostByProNum(pronum);
		req.setAttribute("holdCostList",holdCostList );
		//根据项目编号获取购房税费
		List<HouseTax> houseTaxList=projectInputDao.getHouseTaxByProNum(pronum);
		req.setAttribute("houseTaxList",houseTaxList );
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
