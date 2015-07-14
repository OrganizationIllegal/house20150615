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
import com.kate.app.model.Broker;
import com.kate.app.model.BrokerType;
import com.kate.app.model.DeveloperInfo;
import com.kate.app.model.FujinPeiTao;
import com.kate.app.model.FujinSchool;
import com.kate.app.model.HoldCost;
import com.kate.app.model.HouseInfo1;
import com.kate.app.model.HouseProject;
import com.kate.app.model.HouseTax;
import com.kate.app.model.NewsBoke;
import com.kate.app.model.Project;
import com.kate.app.model.ProjectDescImage;
import com.kate.app.model.ProjectPeiTao;
import com.kate.app.model.SchoolInfo;
import com.kate.app.model.ServiceArea;
import com.kate.app.model.ZhiYeZhiDao;
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
	//学校列表
	@RequestMapping({ "/SchoolInfoList" })    
	public void selectSchoolList(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = projectInputDao.selectSchoolList();
		int count = array.size();
		json.put("total", count);
		json.put("rows", array);
		
		try{
			writeJson(array.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//开发商列表
	@RequestMapping({ "/DeveloperInfoList" })    
	public void selectDeveloperList(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = projectInputDao.selectDeveloperList();
		int count = array.size();
		json.put("total", count);
		json.put("rows", array);
		
		try{
			writeJson(array.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//新闻博客列表
		@RequestMapping({ "/newsList" })    
		public void selectnewsList(HttpServletRequest req, HttpServletResponse resp){
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			array = projectInputDao.selectnewsList();
			int count = array.size();
			json.put("total", count);
			json.put("rows", array);
			
			try{
				writeJson(array.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//置业指导列表
				@RequestMapping({ "/zhiyeList" })    
				public void selectzhiyeList(HttpServletRequest req, HttpServletResponse resp){
					JSONObject json = new JSONObject();
					JSONArray array = new JSONArray();
					array = projectInputDao.selectzhiyeList();
					int count = array.size();
					json.put("total", count);
					json.put("rows", array);
					
					try{
						writeJson(array.toJSONString(),resp);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				//经纪人列表
				@RequestMapping({ "/brokerList" })    
				public void selectBrokerList(HttpServletRequest req, HttpServletResponse resp){
					JSONObject json = new JSONObject();
					JSONArray array = new JSONArray();
					array = projectInputDao.selectBrokerList();
					int count = array.size();
					json.put("total", count);
					json.put("rows", array);
					
					try{
						writeJson(array.toJSONString(),resp);
					}catch(Exception e){
						e.printStackTrace();
					}
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
				writeJson(array.toJSONString(),resp);
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
		JSONObject json = new JSONObject();
		//接收项目编号
		String project_num=req.getParameter("project_num");
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
		//项目图片
		    String images=req.getParameter("imagelist");
			JSONArray imageArray = JSONArray.parseArray(images);
			List<ProjectDescImage> projectimagelist=new ArrayList<ProjectDescImage>();
			for (int i=0;i<imageArray.size();i++){
				 JSONObject object = (JSONObject)imageArray.get(i); //对于每个json对象
				 ProjectDescImage e = (ProjectDescImage) JSONToObj(object.toString(), ProjectDescImage.class);
				 projectimagelist.add(e);
			}
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
		//判断项目编号不能重复
		int isDuplicate=projectInputDao.isDuplicateNum(project_num);//1表示此编号已存在,0表示此编号不存在
		if(isDuplicate==1){
			json.put("duplicate", "1");
		}
		else{
		//添加
	    try {
			int result=projectInputDao.AddProject(projectlist,houseInfolist,projectimagelist,projectPeitaolist,fujinpeitaoList,fujinSchoolList,holdCostList,houseTaxList);
			System.out.println("result::"+result);
			if(result==1){
				json.put("flag", "1");
			}
			else{
				json.put("flag", "0");
			}
			
	    } catch (SQLException e1) {
	    
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 }
		  try {
				writeJson(json.toJSONString(),resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		
	}
	//编辑项目
	@RequestMapping({ "/EditProject" })
	public void  EditProject(HttpServletRequest req,HttpServletResponse resp){
		//接收项目编号参数
		//String project_num=req.getParameter("project_num");
		JSONObject json=new JSONObject();
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
		//附近配套
		String fujinpeitao=req.getParameter("fujinlist");
		JSONArray fujinArray = JSONArray.parseArray(fujinpeitao);
	    List<FujinPeiTao> fujinpeitaoList=new ArrayList<FujinPeiTao>();//用于编辑的项
	    List<FujinPeiTao> fujinpeitaoList2=new ArrayList<FujinPeiTao>();//用于添加的项
		for (int i=0;i<fujinArray.size();i++){
				 JSONObject object = (JSONObject)fujinArray.get(i); //对于每个json对象
				 FujinPeiTao e = (FujinPeiTao) JSONToObj(object.toString(), FujinPeiTao.class);
				 if(e.getId()==0){
					 fujinpeitaoList2.add(e);//id为0，添加
				 }
				 else{
					 fujinpeitaoList.add(e);//否则，编辑
				 }
		}
		System.out.println("fujinpeitaoList.length():"+fujinpeitaoList.size());
		System.out.println("fujinpeitaoList2.length():"+fujinpeitaoList2.size());
		//附近学校
		String schoolInfo=req.getParameter("schoollist");
		JSONArray schoolArray = JSONArray.parseArray(schoolInfo);
		List<FujinSchool> fujinSchoolList=new ArrayList<FujinSchool>();//用于编辑的项
		List<FujinSchool> fujinSchoolList2=new ArrayList<FujinSchool>();//用于添加的项
		for (int i=0;i<schoolArray.size();i++){
						 JSONObject object = (JSONObject)schoolArray.get(i); //对于每个json对象
						 FujinSchool e = (FujinSchool) JSONToObj(object.toString(), FujinSchool.class);
						 if(e.getId()==0){
							 fujinSchoolList2.add(e);
						 }
						 else{
							 fujinSchoolList.add(e);
						 }
		   }
		System.out.println("fujinSchoolList.length():"+fujinSchoolList.size());
		System.out.println("fujinSchoolList2.length():"+fujinSchoolList2.size());
		//持有成本
		String holdingcost=req.getParameter("holdingcostlist");
		JSONArray holdCostArray = JSONArray.parseArray(holdingcost);
		List<HoldCost> holdCostList=new ArrayList<HoldCost>();//用于编辑的项
		List<HoldCost> holdCostList2=new ArrayList<HoldCost>();//用于添加的项
		for (int i=0;i<holdCostArray.size();i++){
				JSONObject object = (JSONObject)holdCostArray.get(i); //对于每个json对象
			    HoldCost e = (HoldCost) JSONToObj(object.toString(), HoldCost.class);
			    if(e.getId()==0){
			    	holdCostList2.add(e);//编辑的项
			    }
			    else{
			    	holdCostList.add(e);//添加的项
			    }
			}
		System.out.println("holdCostList.length():"+holdCostList.size());
		System.out.println("holdCostList2.length():"+holdCostList2.size());
		//购房税费
		String houseTax=req.getParameter("housetaxformlist");
		JSONArray houseTaxArray = JSONArray.parseArray(houseTax);
		List<HouseTax> houseTaxList=new ArrayList<HouseTax>();//用于编辑
		List<HouseTax> houseTaxList2=new ArrayList<HouseTax>();//用于添加
		for (int i=0;i<houseTaxArray.size();i++){
					JSONObject object = (JSONObject)houseTaxArray.get(i); //对于每个json对象
					HouseTax e = (HouseTax) JSONToObj(object.toString(), HouseTax.class);
					if(e.getId()==0){
						 houseTaxList2.add(e);//用于添加
					}
					else{
						 houseTaxList.add(e);//用于编辑
					}
		}
		System.out.println("houseTaxList.length():"+houseTaxList.size());
		System.out.println("houseTaxList2.length():"+houseTaxList2.size());
		/*int isDuplicate=projectInputDao.isDuplicateNum(project_num);
		if(isDuplicate==1){
			json.put("isDuplicate", "1");
		}
		else{*/
		//更新
	    try {
			int result=projectInputDao.EditProject(id, projectlist,houseInfolist,houseInfolist2,fujinpeitaoList,fujinpeitaoList2,fujinSchoolList,fujinSchoolList2,holdCostList,holdCostList2,houseTaxList,houseTaxList2);
			System.out.println("result::"+result);
			if(result==1){
				json.put("flag", "1");
			}else{
				json.put("flag", "0");
			}
	    } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   // }
		 try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		
	}
	
	//编辑经纪人
		@RequestMapping({ "/EditBrokerInfo" })
		public void  EditBroker(HttpServletRequest req,HttpServletResponse resp){
			//接收经纪人id
			String idstr=req.getParameter("id");
			int id=Integer.parseInt(req.getParameter("id"));
			
			//经纪人信息
			String brokerinfo=req.getParameter("broker");
			JSONObject brokerInfo = JSONObject.parseObject(brokerinfo);
			Broker broker= (Broker) JSONToObj(brokerInfo.toString(), Broker.class);
		
			//经纪人服务区域
		    String arealist=req.getParameter("arealist");
			JSONArray areaArray = JSONArray.parseArray(arealist);
			List<ServiceArea> serviceArealist=new ArrayList<ServiceArea>();//存放要编辑的项
			List<ServiceArea> serviceArealist2=new ArrayList<ServiceArea>();//存放新添加的项
			for (int i=0;i<areaArray.size();i++){
					JSONObject object = (JSONObject)areaArray.get(i); //对于每个json对象
					ServiceArea e = (ServiceArea) JSONToObj(object.toString(), ServiceArea.class);
				    if(e.getId()==0){
				    	serviceArealist2.add(e);//用于添加
				    }
				    else{
				    	serviceArealist.add(e);//用于编辑
				    }
				}
			//经纪人擅长类型
			String typelist=req.getParameter("typelist");
			JSONArray typeArray = JSONArray.parseArray(typelist);
			List<BrokerType> brokerTypelist=new ArrayList<BrokerType>();//存放要编辑的项
			List<BrokerType> brokerTypelist2=new ArrayList<BrokerType>();//存放新添加的项
			for (int i=0;i<typeArray.size();i++){
					JSONObject object = (JSONObject)typeArray.get(i); //对于每个json对象
					BrokerType e = (BrokerType) JSONToObj(object.toString(), BrokerType.class);
				    if(e.getId()==0){
				    	brokerTypelist2.add(e);//用于添加
				    }
				    else{
				    	brokerTypelist.add(e);//用于编辑
				    }
				}
			//更新
		  try {
				int result=projectInputDao.UpdateBroker(id, broker, serviceArealist,serviceArealist2, brokerTypelist,brokerTypelist2);
				System.out.println("result::"+result);
		    } catch (Exception e1) {
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
	//编辑学校信息
	@RequestMapping({ "/EditSchoolInfo" })
	public void updateSchoolInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean flag = false;
	    int id=Integer.parseInt(req.getParameter("id"));
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
	    flag=projectInputDao.UpdateSchoolInfo(id, school_name, school_ranking, school_type, school_total, teacher_total, school_position, gps, net_info, not_en_stu_bili, school_image, school_desc);
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
	@RequestMapping({ "/deleteProject" })
	public void DeleteDeveloperInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		int id=Integer.parseInt(req.getParameter("id"));
		HouseProject houseProject=projectInputDao.selectProjectInfo(id);
		String proNum=houseProject.getProject_num();
	    int flagbol=projectInputDao.deleteProjectById(id,proNum);
	    if(flagbol==1){
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
	//删除学校信息
	@RequestMapping({ "/deleteSchool" })
	public void DeleteSchool(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		int id=Integer.parseInt(req.getParameter("id"));
	    int flagbol=projectInputDao.deleteSchool(id);
	    if(flagbol==1){
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
	//删除开发商信息
		@RequestMapping({ "/deleteDeveloper" })
		public void DeleteDeveloper(HttpServletRequest req,HttpServletResponse resp){
			JSONObject json = new JSONObject();
			int id=Integer.parseInt(req.getParameter("id"));
		    int flagbol=projectInputDao.deleteDeveloper(id);
		    if(flagbol==1){
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
		//删除置业指导
				@RequestMapping({ "/deleteZhiye" })
				public void DeleteZhiye(HttpServletRequest req,HttpServletResponse resp){
					JSONObject json = new JSONObject();
					int id=Integer.parseInt(req.getParameter("id"));
				    int flagbol=projectInputDao.deleteZhiye(id);
				    if(flagbol==1){
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
				//删除经纪人
				@RequestMapping({ "/deleteBroker" })
				public void DeleteBroker(HttpServletRequest req,HttpServletResponse resp){
					JSONObject json = new JSONObject();
					int id=Integer.parseInt(req.getParameter("id"));
					String brokerNum=projectInputDao.findBrokerNumById(id);
				    int flagbol=projectInputDao.deleteBroker(id, brokerNum);
				    if(flagbol==1){
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
				//删除新闻博客
				@RequestMapping({ "/deleteNewsBoke" })
				public void DeleteNewsBoke(HttpServletRequest req,HttpServletResponse resp){
					JSONObject json = new JSONObject();
					int id=Integer.parseInt(req.getParameter("id"));
				    int flagbol=projectInputDao.deleteNewsBoke(id);
				    if(flagbol==1){
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
	//编辑开发商信息
	@RequestMapping({ "/EditDeveloperInfo" })
	public void UpdateDeveloperInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		int id=Integer.parseInt(req.getParameter("id"));
		String developer_name=req.getParameter("developer_name");
		String developer_logo=req.getParameter("developer_logo");
		String  developer_desc=req.getParameter("developer_desc");
		
		String developer_num=req.getParameter("developer_num");
		
	   boolean flagbol=projectInputDao.UpdateDeveloperInfo(id, developer_name, developer_logo, developer_desc, developer_num);
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
		req.setAttribute("projectPeitaoListJson", ConvertJson.list2json(projectPeiTaoList));
		//根据项目编号获取附近配套
		List<FujinPeiTao> fujinPeitaoList=projectInputDao.getFujinPeiTaoByProNum(pronum);
		req.setAttribute("fujinPeitaoList",fujinPeitaoList );
		req.setAttribute("fujinPeitaoListJson", ConvertJson.list2json(fujinPeitaoList));
		//根据项目编号获取附近学校
		List<FujinSchool> fujinSchoolList=projectInputDao.getFujinSchoolByProNum(pronum);
		req.setAttribute("fujinSchoolList",fujinSchoolList );
		req.setAttribute("fujinSchoolListJson", ConvertJson.list2json(fujinSchoolList));
		//根据项目编号获取持有成本
		List<HoldCost> holdCostList=projectInputDao.getHoldCostByProNum(pronum);
		req.setAttribute("holdCostList",holdCostList );
		req.setAttribute("holdCostListJson", ConvertJson.list2json(holdCostList));
		//根据项目编号获取购房税费
		List<HouseTax> houseTaxList=projectInputDao.getHouseTaxByProNum(pronum);
		req.setAttribute("houseTaxList",houseTaxList );
		req.setAttribute("houseTaxListJson", ConvertJson.list2json(houseTaxList));
		
		
		//得到开发商的编号和名称
		List<String> codeAndNameSet=projectInputDao.getDeveloperCodeName();
		req.setAttribute("codeAndNameSet", codeAndNameSet);
		//得到所有学校的名称
		List<String> schoolList=projectInputDao.getAllSchoolName();
		req.setAttribute("schoolList", schoolList);
		return "/ProjectInfo.jsp";
	}
	//根据id取学校信息
	@RequestMapping({ "/selectSchoolInfo" })
	public String selectSchoolInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		int id =Integer.parseInt(req.getParameter("id"));
		//根据项目id取项目信息
		SchoolInfo schoolInfo=projectInputDao.selectSchoolInfo(id);
		req.setAttribute("schoolInfo", schoolInfo);
		return "/SchoolInfoEdit.jsp";
	}
	//根据id取开发商信息
		@RequestMapping({ "/selectDeveloperInfo" })
		public String selectDeveloperInfo(HttpServletRequest req,HttpServletResponse resp){
			JSONObject json = new JSONObject();
			int id =Integer.parseInt(req.getParameter("id"));
			//根据项目id取项目信息
			DeveloperInfo developerInfo=projectInputDao.selectDeveloperInfo(id);
			req.setAttribute("developerInfo", developerInfo);
			return "/DeveloperInfo.jsp";
		}
		//根据id取新闻博客信息
				@RequestMapping({ "/selectNewsBokeInfo" })
				public String selectNewsbokeInfo(HttpServletRequest req,HttpServletResponse resp){
					JSONObject json = new JSONObject();
					int id =Integer.parseInt(req.getParameter("id"));
					//根据项目id取项目信息
					NewsBoke newsBoke=projectInputDao.selectNewsBokeInfo(id);
					req.setAttribute("newsBoke", newsBoke);
					return "/newsInfoEdit.jsp";
				}
				//根据id取置业指导信息
				@RequestMapping({ "/selectZhiyeInfo" })
				public String selectZhiyeInfo(HttpServletRequest req,HttpServletResponse resp){
					JSONObject json = new JSONObject();
					int id =Integer.parseInt(req.getParameter("id"));
					//根据项目id取项目信息
					ZhiYeZhiDao zhiYeZhiDao=projectInputDao.selectZhiyeInfo(id);
					req.setAttribute("zhiYeZhiDao", zhiYeZhiDao);
					return "/zhiyeInfo.jsp";
				}
				//根据id取经纪人信息
				@RequestMapping({ "/selectBroker" })
				public String selectBroker(HttpServletRequest req,HttpServletResponse resp){
					JSONObject json = new JSONObject();
					int id =Integer.parseInt(req.getParameter("id"));
					//根据项目id取项目信息
					Broker broker=projectInputDao.selectBroker(id);
					req.setAttribute("broker", broker);
					//获取经纪人编号
					String broker_num=projectInputDao.findBrokerNumById(id);
					//获取经纪人服务区域
					List<ServiceArea> brokerServiceAreaList=projectInputDao.findBrokerAreaList(broker_num);
					req.setAttribute("brokerServiceAreaList", brokerServiceAreaList);
					req.setAttribute("brokerServiceAreaListJson", ConvertJson.list2json(brokerServiceAreaList));
					//获取经纪人擅长类型
					List<BrokerType> brokerIntegertypeList=projectInputDao.findBrokerTypeList(broker_num);
					req.setAttribute("brokerIntegertypeList", brokerIntegertypeList);
					req.setAttribute("brokerIntegertypeListJson", ConvertJson.list2json(brokerIntegertypeList));
					return "/brokerInfo.jsp";
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
