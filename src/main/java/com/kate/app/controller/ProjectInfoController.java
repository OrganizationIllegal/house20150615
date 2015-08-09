package com.kate.app.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;

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
import com.kate.app.dao.AreaInputDao;
import com.kate.app.dao.BrokerInfoDao;
import com.kate.app.dao.ImageDao;
import com.kate.app.dao.ProjectInputDao;
import com.kate.app.dao.SchoolInfoDao;
import com.kate.app.dao.SchoolNearDao;
import com.kate.app.dao.ZhiYeDao;
import com.kate.app.model.Broker;
import com.kate.app.model.BrokerInfo;
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
import com.kate.app.model.ProjectKey;
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
	@Autowired
	private ZhiYeDao zhiYeDao;
	@Autowired
	private SchoolInfoDao schoolinfodao;
	@Autowired
	private BrokerInfoDao brokerInfoDao;
	@Autowired
	private AreaInputDao areaInputDao;
	
	private List<HouseInfo1> houseInfoListbefore;
	private List <ProjectPeiTao> projectPeiTaoListbefore;
	private List<FujinPeiTao> fujinPeitaoListbefore;
	private List<FujinSchool> fujinSchoolListbefore;
	private List<HoldCost> holdCostListbefore;
	private List<HouseTax> houseTaxListbefore;
	private List <ProjectDescImage> projectImageListbefore;
	private List<ServiceArea> brokerServiceAreaListbefore;
	private List<BrokerType> brokerIntegertypeListbefore;
	private List <BrokerInfo> brokerlistbefore;
	//
	/**
	 * 后台维护项目录入,页面加载时动态返回开发商列表，学校列表，经纪人姓名等信息
	 * @param req
	 * @param resp
	 * @return "/ProjectInputBroker.jsp"
	 */
	@RequestMapping({"/ProjectInput"})
	public String getProjectCodeAndName(HttpServletRequest req,HttpServletResponse resp){
		//寰楀埌寮�鍙戝晢鐨勭紪鍙峰拰鍚嶇О
		List<String> codeAndNameSet=projectInputDao.getDeveloperCodeName();
		req.setAttribute("codeAndNameSet", codeAndNameSet);
		//寰楀埌鎵�鏈夊鏍＄殑鍚嶇О
		List<String> schoolList=projectInputDao.getAllSchoolName();
		req.setAttribute("schoolList", schoolList);
		//不包含推荐经纪人的ProjectInput.jsp
		//return "/ProjectInput.jsp";
		//包含推荐经纪人的ProjectInputBroker.jsp
		getBrokerName(req,resp);
		return "/ProjectInputBroker.jsp";
	}
	//项目录入的
		@RequestMapping({"/ProjectInput/Broker"})
		public void getBrokerName(HttpServletRequest req,HttpServletResponse resp){
			List<BrokerInfo> brokerSet=areaInputDao.getBrokers();
			req.setAttribute("brokerSet", brokerSet);
		}

	//ajax获取学校信息的List

	//学校信息列表

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

	//ajax获取开发上的jsonList

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

	//获取新闻列表

	/**
	 * 新闻博客列表
	 * @param req
	 * @param resp
	 */

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

		//获取置业指导列表

	/**
	 * 置业指导列表
	 * @param req
	 * @param resp
	 */

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

				//获取经纪人列表

				/**
				 * 经纪人列表
				 * @param req
				 * @param resp
				 */

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
	/**
	 * 项目列表
	 * @param req
	 * @param resp
	 */
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
	//灏唈sons
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

	 /**
	  * 添加项目  经纪人按区域进行推荐
	  * @param req
	  * @param resp
	  */
	@RequestMapping({ "/AddprojectInfo" })
	public void InsertProjectInfo(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		//获取项目编号
		String project_num=req.getParameter("project_num");
		//项目信息
		String project=req.getParameter("project");
		JSONArray projectArray = JSONArray.parseArray(project);
		List<Project> projectlist=new ArrayList<Project>();
		for (int i=0;i<projectArray.size();i++){
			 JSONObject object = (JSONObject)projectArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
			 Project e = (Project) JSONToObj(object.toString(), Project.class);
			 projectlist.add(e);
		}
		System.out.println("projectlist.length():"+projectlist.size());
		//项目关键字
		String projectkey=req.getParameter("keylist");
		JSONArray keyArray = JSONArray.parseArray(projectkey);
		List<ProjectKey> keylist=new ArrayList<ProjectKey>();
		for (int i=0;i<keyArray.size();i++){
			 JSONObject object = (JSONObject)keyArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
			 ProjectKey e = (ProjectKey) JSONToObj(object.toString(), ProjectKey.class);
			 keylist.add(e);
		}

		//户型及价格
		String huxing=req.getParameter("huxinglist");
		JSONArray huxingArray = JSONArray.parseArray(huxing);
		List<HouseInfo1> houseInfolist=new ArrayList<HouseInfo1>();
		for (int i=0;i<huxingArray.size();i++){
			 JSONObject object = (JSONObject)huxingArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
			 HouseInfo1 e = (HouseInfo1) JSONToObj(object.toString(), HouseInfo1.class);
			 houseInfolist.add(e);
		}
		System.out.println("houseInfolist.length():"+houseInfolist.size());
		//项目图片
		    String images=req.getParameter("imagelist");
			JSONArray imageArray = JSONArray.parseArray(images);
			List<ProjectDescImage> projectimagelist=new ArrayList<ProjectDescImage>();
			for (int i=0;i<imageArray.size();i++){
				 JSONObject object = (JSONObject)imageArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 ProjectDescImage e = (ProjectDescImage) JSONToObj(object.toString(), ProjectDescImage.class);
				 projectimagelist.add(e);
			}
	    //项目配套
	    String peitao=req.getParameter("peitaolist");
		JSONArray peitaoArray = JSONArray.parseArray(peitao);
		List<ProjectPeiTao> projectPeitaolist=new ArrayList<ProjectPeiTao>();
		for (int i=0;i<peitaoArray.size();i++){
			 JSONObject object = (JSONObject)peitaoArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
			 ProjectPeiTao e = (ProjectPeiTao) JSONToObj(object.toString(), ProjectPeiTao.class);
			 projectPeitaolist.add(e);
		}
		System.out.println("projectPeitaolist.length():"+projectPeitaolist.size());
		//附近配套
		String fujinpeitao=req.getParameter("fujinlist");
		JSONArray fujinArray = JSONArray.parseArray(fujinpeitao);
	    List<FujinPeiTao> fujinpeitaoList=new ArrayList<FujinPeiTao>();
		for (int i=0;i<fujinArray.size();i++){
				 JSONObject object = (JSONObject)fujinArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 FujinPeiTao e = (FujinPeiTao) JSONToObj(object.toString(), FujinPeiTao.class);
				 fujinpeitaoList.add(e);
		}
		System.out.println("fujinpeitaoList.length():"+fujinpeitaoList.size());
		//附近学校
		String schoolInfo=req.getParameter("schoollist");
		JSONArray schoolArray = JSONArray.parseArray(schoolInfo);
	    List<FujinSchool> fujinSchoolList=new ArrayList<FujinSchool>();
		for (int i=0;i<schoolArray.size();i++){
				 JSONObject object = (JSONObject)schoolArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 FujinSchool e = (FujinSchool) JSONToObj(object.toString(), FujinSchool.class);
				 fujinSchoolList.add(e);
		}
		System.out.println("fujinSchoolList.length():"+fujinSchoolList.size());
		//持有成本
		String holdingcost=req.getParameter("holdingcostlist");
		JSONArray holdCostArray = JSONArray.parseArray(holdingcost);
	    List<HoldCost> holdCostList=new ArrayList<HoldCost>();
		for (int i=0;i<holdCostArray.size();i++){
				 JSONObject object = (JSONObject)holdCostArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 HoldCost e = (HoldCost) JSONToObj(object.toString(), HoldCost.class);
				 holdCostList.add(e);
		}
		System.out.println("holdCostList.length():"+holdCostList.size());
		//购房税费
		String houseTax=req.getParameter("housetaxformlist");
		JSONArray houseTaxArray = JSONArray.parseArray(houseTax);
		List<HouseTax> houseTaxList=new ArrayList<HouseTax>();
		for (int i=0;i<houseTaxArray.size();i++){
				 JSONObject object = (JSONObject)houseTaxArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 HouseTax e = (HouseTax) JSONToObj(object.toString(), HouseTax.class);
				 houseTaxList.add(e);
		}
		System.out.println("houseTaxList.length():"+houseTaxList.size());
		//判断项目编号是否重复
		int isDuplicate=projectInputDao.isDuplicateNum(project_num);
		if(isDuplicate==1){
			json.put("duplicate", "1");//1表示项目编号重复
		}
		else{
	    try {
			int result=projectInputDao.AddProject(projectlist,houseInfolist,projectimagelist,projectPeitaolist,fujinpeitaoList,fujinSchoolList,holdCostList,houseTaxList,keylist);
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
	/**
	 * 添加项目 ,其中经纪人是按项目进行推荐的
	 * @param req
	 * @param resp
	 */
	@RequestMapping({ "/AddprojectInfo2" })
	public void InsertProjectInfo2(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		//获取项目编号
		String project_num=req.getParameter("project_num");
		//项目信息
		String project=req.getParameter("project");
		JSONArray projectArray = JSONArray.parseArray(project);
		List<Project> projectlist=new ArrayList<Project>();
		for (int i=0;i<projectArray.size();i++){
			 JSONObject object = (JSONObject)projectArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
			 Project e = (Project) JSONToObj(object.toString(), Project.class);
			 projectlist.add(e);
		}
		System.out.println("projectlist.length():"+projectlist.size());
		//项目关键字
		String projectkey=req.getParameter("keylist");
		JSONArray keyArray = JSONArray.parseArray(projectkey);
		List<ProjectKey> keylist=new ArrayList<ProjectKey>();
		for (int i=0;i<keyArray.size();i++){
			 JSONObject object = (JSONObject)keyArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
			 ProjectKey e = (ProjectKey) JSONToObj(object.toString(), ProjectKey.class);
			 keylist.add(e);
		}

		//户型及价格
		String huxing=req.getParameter("huxinglist");
		JSONArray huxingArray = JSONArray.parseArray(huxing);
		List<HouseInfo1> houseInfolist=new ArrayList<HouseInfo1>();
		for (int i=0;i<huxingArray.size();i++){
			 JSONObject object = (JSONObject)huxingArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
			 HouseInfo1 e = (HouseInfo1) JSONToObj(object.toString(), HouseInfo1.class);
			 houseInfolist.add(e);
		}
		System.out.println("houseInfolist.length():"+houseInfolist.size());
		//项目图片
		    String images=req.getParameter("imagelist");
			JSONArray imageArray = JSONArray.parseArray(images);
			List<ProjectDescImage> projectimagelist=new ArrayList<ProjectDescImage>();
			for (int i=0;i<imageArray.size();i++){
				 JSONObject object = (JSONObject)imageArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 ProjectDescImage e = (ProjectDescImage) JSONToObj(object.toString(), ProjectDescImage.class);
				 projectimagelist.add(e);
			}
	    //项目配套
	    String peitao=req.getParameter("peitaolist");
		JSONArray peitaoArray = JSONArray.parseArray(peitao);
		List<ProjectPeiTao> projectPeitaolist=new ArrayList<ProjectPeiTao>();
		for (int i=0;i<peitaoArray.size();i++){
			 JSONObject object = (JSONObject)peitaoArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
			 ProjectPeiTao e = (ProjectPeiTao) JSONToObj(object.toString(), ProjectPeiTao.class);
			 projectPeitaolist.add(e);
		}
		System.out.println("projectPeitaolist.length():"+projectPeitaolist.size());
		//附近配套
		String fujinpeitao=req.getParameter("fujinlist");
		JSONArray fujinArray = JSONArray.parseArray(fujinpeitao);
	    List<FujinPeiTao> fujinpeitaoList=new ArrayList<FujinPeiTao>();
		for (int i=0;i<fujinArray.size();i++){
				 JSONObject object = (JSONObject)fujinArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 FujinPeiTao e = (FujinPeiTao) JSONToObj(object.toString(), FujinPeiTao.class);
				 fujinpeitaoList.add(e);
		}
		System.out.println("fujinpeitaoList.length():"+fujinpeitaoList.size());
		//附近学校
		String schoolInfo=req.getParameter("schoollist");
		JSONArray schoolArray = JSONArray.parseArray(schoolInfo);
	    List<FujinSchool> fujinSchoolList=new ArrayList<FujinSchool>();
		for (int i=0;i<schoolArray.size();i++){
				 JSONObject object = (JSONObject)schoolArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 FujinSchool e = (FujinSchool) JSONToObj(object.toString(), FujinSchool.class);
				 fujinSchoolList.add(e);
		}
		System.out.println("fujinSchoolList.length():"+fujinSchoolList.size());
		//持有成本
		String holdingcost=req.getParameter("holdingcostlist");
		JSONArray holdCostArray = JSONArray.parseArray(holdingcost);
	    List<HoldCost> holdCostList=new ArrayList<HoldCost>();
		for (int i=0;i<holdCostArray.size();i++){
				 JSONObject object = (JSONObject)holdCostArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 HoldCost e = (HoldCost) JSONToObj(object.toString(), HoldCost.class);
				 holdCostList.add(e);
		}
		System.out.println("holdCostList.length():"+holdCostList.size());
		//购房税费
		String houseTax=req.getParameter("housetaxformlist");
		JSONArray houseTaxArray = JSONArray.parseArray(houseTax);
		List<HouseTax> houseTaxList=new ArrayList<HouseTax>();
		for (int i=0;i<houseTaxArray.size();i++){
				 JSONObject object = (JSONObject)houseTaxArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 HouseTax e = (HouseTax) JSONToObj(object.toString(), HouseTax.class);
				 houseTaxList.add(e);
		}
		System.out.println("houseTaxList.length():"+houseTaxList.size());
		//推荐经纪人   按项目进行推荐
				String broker=req.getParameter("brokerlist");
				JSONArray brokerArray = JSONArray.parseArray(broker);
				List<BrokerInfo> brokerList=new ArrayList<BrokerInfo>();
				for (int i=0;i<brokerArray.size();i++){
						 JSONObject object = (JSONObject)brokerArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
						 BrokerInfo e = (BrokerInfo) JSONToObj(object.toString(), BrokerInfo.class);
						 brokerList.add(e);
				}
		//判断项目编号是否重复
		int isDuplicate=projectInputDao.isDuplicateNum(project_num);//1琛ㄧず姝ょ紪鍙峰凡瀛樺湪,0琛ㄧず姝ょ紪鍙蜂笉瀛樺湪
		if(isDuplicate==1){
			json.put("duplicate", "1");
		}
		else{
		
	    try {
			int result=projectInputDao.AddProject2(projectlist,houseInfolist,projectimagelist,projectPeitaolist,fujinpeitaoList,fujinSchoolList,holdCostList,houseTaxList,keylist,brokerList);
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
/**
 * 项目编辑  经纪人是按区域进行推荐的（现在经纪人是在项目里推荐的，区域里现在在后台不填了）现在这个action弃用了，下面的EditProject2是最新的，EditProject2包括了推荐经纪人的处理。EditPorject不包括推荐经纪人的处理。
 * @param req
 * @param resp
 */
	@RequestMapping({ "/EditProject" })
	public void  EditProject(HttpServletRequest req,HttpServletResponse resp){
		//
		//String project_num=req.getParameter("project_num");
		JSONObject json=new JSONObject();
		//
		int id=Integer.parseInt(req.getParameter("id"));
		//
		String project=req.getParameter("project");
		JSONArray projectArray = JSONArray.parseArray(project);
		List<Project> projectlist=new ArrayList<Project>();
		for (int i=0;i<projectArray.size();i++){
				JSONObject object = (JSONObject)projectArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				Project e = (Project) JSONToObj(object.toString(), Project.class);
			    projectlist.add(e);
		  }
		System.out.println("projectlist.length():"+projectlist.size());
		//
	    String huxing=req.getParameter("huxinglist");
		JSONArray huxingArray = JSONArray.parseArray(huxing);
		List<HouseInfo1> houseInfolist=new ArrayList<HouseInfo1>();//瀛樻斁瑕佺紪杈戠殑椤�
		List<HouseInfo1> houseInfolist2=new ArrayList<HouseInfo1>();//瀛樻斁鏂版坊鍔犵殑椤�
		for (int i=0;i<huxingArray.size();i++){
				JSONObject object = (JSONObject)huxingArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
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

		//项目图片
	    String projectImage=req.getParameter("imagelist");
		JSONArray imageArray = JSONArray.parseArray(projectImage);
		List<ProjectDescImage> imagelist=new ArrayList<ProjectDescImage>();//存放要编辑的项
		List<ProjectDescImage> imagelist2=new ArrayList<ProjectDescImage>();//存放新添加的项
		List<ProjectDescImage> imagelistdelete=new ArrayList<ProjectDescImage>();//存放新添加的项
		for (int i=0;i<imageArray.size();i++){
				JSONObject object = (JSONObject)imageArray.get(i); //对于每个json对象
				ProjectDescImage e = (ProjectDescImage) JSONToObj(object.toString(), ProjectDescImage.class);
			    if(e.getId()==0){
			    	imagelist2.add(e);//添加
			    }
			    else{
			    	imagelist.add(e);
			    }
			}
		//项目图片，和修改之前的项目图片list做对比，然后把删除了的项目图片item保存到deleteList里，然后传到dao层删除。
		for (int i=0;i<projectImageListbefore.size();i++){
			boolean flag=false;

			for(int j=0;j<imagelist.size();j++){
				if(projectImageListbefore.get(i).getId()==imagelist.get(j).getId()){
					flag=true;
					break;
				}
			}
			if (flag==false) {
				imagelistdelete.add(projectImageListbefore.get(i));
			}
		}
		
		//项目配套
		    String projectpeitao=req.getParameter("peitaolist");
			JSONArray peitaoArray = JSONArray.parseArray(projectpeitao);
			List<ProjectPeiTao> peitaolist=new ArrayList<ProjectPeiTao>();//存放要编辑的项
			List<ProjectPeiTao> peitaolist2=new ArrayList<ProjectPeiTao>();//存放新添加的项
			List<ProjectPeiTao> peitaolistdelete=new ArrayList<ProjectPeiTao>();//存放新添加的项
			for (int i=0;i<peitaoArray.size();i++){
					JSONObject object = (JSONObject)peitaoArray.get(i); //对于每个json对象
					ProjectPeiTao e = (ProjectPeiTao) JSONToObj(object.toString(), ProjectPeiTao.class);
				    if(e.getId()==0){
				    	peitaolist2.add(e);//添加
				    }
				    else{
				    	peitaolist.add(e);
				    }
				}
			//项目配套，和修改之前的项目配套做对比，然后把删除的项目配套item的保存到deletelist，然后再dao层做删除
			for (int i=0;i<projectPeiTaoListbefore.size();i++){
				boolean flag=false;

				for(int j=0;j<peitaolist.size();j++){
					if(projectPeiTaoListbefore.get(i).getId()==peitaolist.get(j).getId()){
						flag=true;
						break;
					}
				}
				if (flag==false) {
					peitaolistdelete.add(projectPeiTaoListbefore.get(i));
				}
			}

		//附近配套

		String fujinpeitao=req.getParameter("fujinlist");
		JSONArray fujinArray = JSONArray.parseArray(fujinpeitao);
	    List<FujinPeiTao> fujinpeitaoList=new ArrayList<FujinPeiTao>();//鐢ㄤ簬缂栬緫鐨勯」
	    List<FujinPeiTao> fujinpeitaoList2=new ArrayList<FujinPeiTao>();//鐢ㄤ簬娣诲姞鐨勯」
	    List<FujinPeiTao> fujinpeitaoListdelete=new ArrayList<FujinPeiTao>();
		for (int i=0;i<fujinArray.size();i++){
				 JSONObject object = (JSONObject)fujinArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 FujinPeiTao e = (FujinPeiTao) JSONToObj(object.toString(), FujinPeiTao.class);
				 if(e.getId()==0){
					 fujinpeitaoList2.add(e);//id涓�0锛屾坊鍔�
				 }
				 else{
					 fujinpeitaoList.add(e);//鍚﹀垯锛岀紪杈�
				 }
		}
		//附近配套，和修改之前的附近配套做对比。把删除的附近配套item保存到deletelist，然后再传到dao层做删除
		for (int i=0;i<fujinPeitaoListbefore.size();i++){
			boolean flag=false;
			for(int j=0;j<fujinpeitaoList.size();j++){
				if(fujinPeitaoListbefore.get(i).getId()==fujinpeitaoList.get(j).getId()){
					flag=true;
					break;
				}
			}
			if(flag==false){
				fujinpeitaoListdelete.add(fujinPeitaoListbefore.get(i));
			}
		}

		System.out.println("fujinpeitaoList.length():"+fujinpeitaoList.size());
		System.out.println("fujinpeitaoList2.length():"+fujinpeitaoList2.size());
		//学校信息
		String schoolInfo=req.getParameter("schoollist");
		JSONArray schoolArray = JSONArray.parseArray(schoolInfo);
		List<FujinSchool> fujinSchoolList=new ArrayList<FujinSchool>();//鐢ㄤ簬缂栬緫鐨勯」
		List<FujinSchool> fujinSchoolList2=new ArrayList<FujinSchool>();//鐢ㄤ簬娣诲姞鐨勯」
		List<FujinSchool> fujinSchoolListdelete=new ArrayList<FujinSchool>();//鐢ㄤ簬娣诲姞鐨勯」
		for (int i=0;i<schoolArray.size();i++){
						 JSONObject object = (JSONObject)schoolArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
						 FujinSchool e = (FujinSchool) JSONToObj(object.toString(), FujinSchool.class);
						 if(e.getId()==0){
							 fujinSchoolList2.add(e);
						 }
						 else{
							 fujinSchoolList.add(e);
						 }
		   }
		//附近学校，和修改之前的学习list做对比。把删除的附近学校的item保存到deletelist里，然后传到dao层删除。
		for (int i=0;i<fujinSchoolListbefore.size();i++){
			boolean flag=false;
			for(int j=0;j<fujinSchoolList.size();j++){
				if(fujinSchoolListbefore.get(i).getId()==fujinSchoolList.get(j).getId()){
					flag=true;
					break;
				}
			}

			if(flag==false){
				fujinSchoolListdelete.add(fujinSchoolListbefore.get(i));
			}
		}
		System.out.println("fujinSchoolList.length():"+fujinSchoolList.size());
		System.out.println("fujinSchoolList2.length():"+fujinSchoolList2.size());
		//持有成本
		String holdingcost=req.getParameter("holdingcostlist");
		JSONArray holdCostArray = JSONArray.parseArray(holdingcost);
		List<HoldCost> holdCostList=new ArrayList<HoldCost>();//鐢ㄤ簬缂栬緫鐨勯」
		List<HoldCost> holdCostList2=new ArrayList<HoldCost>();//鐢ㄤ簬娣诲姞鐨勯」
		List<HoldCost> holdCostListdelete=new ArrayList<HoldCost>();//鐢ㄤ簬娣诲姞鐨勯」
		for (int i=0;i<holdCostArray.size();i++){
				JSONObject object = (JSONObject)holdCostArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
			    HoldCost e = (HoldCost) JSONToObj(object.toString(), HoldCost.class);
			    if(e.getId()==0){
			    	holdCostList2.add(e);//缂栬緫鐨勯」
			    }
			    else{
			    	holdCostList.add(e);//娣诲姞鐨勯」
			    }
			}
		//持有成本，和修改之前的持有成本list做对比，把 删除的持有成本保存到deletelist列表里，然后再dao层做删除。
		for (int i=0;i<holdCostListbefore.size();i++){
			boolean flag=false;
			for(int j=0;j<holdCostList.size();j++){
				if(holdCostListbefore.get(i).getId()==holdCostList.get(j).getId()){
					flag=true;
					break;
				}
			}
			if(flag==false){
				holdCostListdelete.add(holdCostListbefore.get(i));
			}
		}

		System.out.println("holdCostList.length():"+holdCostList.size());
		System.out.println("holdCostList2.length():"+holdCostList2.size());
		//璐埧绋庤垂
		String houseTax=req.getParameter("housetaxformlist");
		JSONArray houseTaxArray = JSONArray.parseArray(houseTax);
		List<HouseTax> houseTaxList=new ArrayList<HouseTax>();//鐢ㄤ簬缂栬緫
		List<HouseTax> houseTaxList2=new ArrayList<HouseTax>();//鐢ㄤ簬娣诲姞
		List<HouseTax> houseTaxListdelete=new ArrayList<HouseTax>();//鐢ㄤ簬娣诲姞
		for (int i=0;i<houseTaxArray.size();i++){
					JSONObject object = (JSONObject)houseTaxArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
					HouseTax e = (HouseTax) JSONToObj(object.toString(), HouseTax.class);
					if(e.getId()==0){
						 houseTaxList2.add(e);//鐢ㄤ簬娣诲姞
					}
					else{
						 houseTaxList.add(e);//鐢ㄤ簬缂栬緫
					}
		}
		//购房税费，和修改之前的购房税费做对比，把删除的购房税费的item保存到购房税费deletelist，然后再dao层做删除。
		for (int i=0;i<houseTaxListbefore.size();i++){
			boolean flag=false;

			for(int j=0;j<houseTaxList.size();j++){
				if(houseTaxListbefore.get(i).getId()==houseTaxList.get(j).getId()){
					flag=true;
					break;
				}
			}
			if(flag==false){
				houseTaxListdelete.add(houseTaxListbefore.get(i));
			}
		}
		System.out.println("houseTaxList.length():"+houseTaxList.size());
		System.out.println("houseTaxList2.length():"+houseTaxList2.size());
		//项目关键字
				String projectkey=req.getParameter("keylist");
				JSONArray keyArray = JSONArray.parseArray(projectkey);
				List<ProjectKey> keylist=new ArrayList<ProjectKey>();
				for (int i=0;i<keyArray.size();i++){
					 JSONObject object = (JSONObject)keyArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
					 ProjectKey e = (ProjectKey) JSONToObj(object.toString(), ProjectKey.class);
					 keylist.add(e);
				}
		/*int isDuplicate=projectInputDao.isDuplicateNum(project_num);
		if(isDuplicate==1){
			json.put("isDuplicate", "1");
		}
		else{*/
		//鏇存柊
	    try {
			int result=projectInputDao.EditProject(id, projectlist,houseInfolist,houseInfolist2,peitaolist,peitaolist2,imagelist,imagelist2,fujinpeitaoList,fujinpeitaoList2,fujinSchoolList,fujinSchoolList2,holdCostList,holdCostList2,houseTaxList,houseTaxList2,imagelistdelete,peitaolistdelete,fujinpeitaoListdelete,fujinSchoolListdelete,holdCostListdelete,houseTaxListdelete,keylist);
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
	/**
	 * 项目编辑   经纪人按项目进行推荐
	 * @param req
	 * @param resp
	 */
	@RequestMapping({ "/EditProject2" })
	public void  EditProject2(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json=new JSONObject();
		//得到项目id
		int id=Integer.parseInt(req.getParameter("id"));
		//项目信息
		String project=req.getParameter("project");
		JSONArray projectArray = JSONArray.parseArray(project);
		List<Project> projectlist=new ArrayList<Project>();
		for (int i=0;i<projectArray.size();i++){
				JSONObject object = (JSONObject)projectArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				Project e = (Project) JSONToObj(object.toString(), Project.class);
			    projectlist.add(e);
		  }
		System.out.println("projectlist.length():"+projectlist.size());
		//户型及价格
	    String huxing=req.getParameter("huxinglist");
		JSONArray huxingArray = JSONArray.parseArray(huxing);
		List<HouseInfo1> houseInfolist=new ArrayList<HouseInfo1>();//瀛樻斁瑕佺紪杈戠殑椤�
		List<HouseInfo1> houseInfolist2=new ArrayList<HouseInfo1>();//瀛樻斁鏂版坊鍔犵殑椤�
		List<HouseInfo1> houseInfolistdelete=new ArrayList<HouseInfo1>();
		for (int i=0;i<huxingArray.size();i++){
				JSONObject object = (JSONObject)huxingArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
			    HouseInfo1 e = (HouseInfo1) JSONToObj(object.toString(), HouseInfo1.class);
			    if(e.getId()==0){
			    	houseInfolist2.add(e);
			    }
			    else{
			    	houseInfolist.add(e);
			    }
			}
		//户型价格，和修改之前的户型价格list做对比，然后把删除了的户型价格item保存到deleteList里，然后传到dao层删除。
		for (int i=0;i<houseInfoListbefore.size();i++){
			boolean flag=false;

			for(int j=0;j<houseInfolist.size();j++){
				if(houseInfoListbefore.get(i).getId()==houseInfolist.get(j).getId()){
					flag=true;
					break;
				}
			}
			if (flag==false) {
				houseInfolistdelete.add(houseInfoListbefore.get(i));
			}
		}
		System.out.println("houseInfolist.length():"+houseInfolist.size());
		System.out.println("houseInfolist2.length():"+houseInfolist2.size());

		//项目图片
	    String projectImage=req.getParameter("imagelist");
		JSONArray imageArray = JSONArray.parseArray(projectImage);
		List<ProjectDescImage> imagelist=new ArrayList<ProjectDescImage>();//存放要编辑的项
		List<ProjectDescImage> imagelist2=new ArrayList<ProjectDescImage>();//存放新添加的项
		List<ProjectDescImage> imagelistdelete=new ArrayList<ProjectDescImage>();//存放新添加的项
		for (int i=0;i<imageArray.size();i++){
				JSONObject object = (JSONObject)imageArray.get(i); //对于每个json对象
				ProjectDescImage e = (ProjectDescImage) JSONToObj(object.toString(), ProjectDescImage.class);
			    if(e.getId()==0){
			    	imagelist2.add(e);//添加
			    }
			    else{
			    	imagelist.add(e);
			    }
			}
		//项目图片，和修改之前的项目图片list做对比，然后把删除了的项目图片item保存到deleteList里，然后传到dao层删除。
		for (int i=0;i<projectImageListbefore.size();i++){
			boolean flag=false;

			for(int j=0;j<imagelist.size();j++){
				if(projectImageListbefore.get(i).getId()==imagelist.get(j).getId()){
					flag=true;
					break;
				}
			}
			if (flag==false) {
				imagelistdelete.add(projectImageListbefore.get(i));
			}
		}
		
		//项目配套
		    String projectpeitao=req.getParameter("peitaolist");
			JSONArray peitaoArray = JSONArray.parseArray(projectpeitao);
			List<ProjectPeiTao> peitaolist=new ArrayList<ProjectPeiTao>();//存放要编辑的项
			List<ProjectPeiTao> peitaolist2=new ArrayList<ProjectPeiTao>();//存放新添加的项
			List<ProjectPeiTao> peitaolistdelete=new ArrayList<ProjectPeiTao>();//存放新添加的项
			for (int i=0;i<peitaoArray.size();i++){
					JSONObject object = (JSONObject)peitaoArray.get(i); //对于每个json对象
					ProjectPeiTao e = (ProjectPeiTao) JSONToObj(object.toString(), ProjectPeiTao.class);
				    if(e.getId()==0){
				    	peitaolist2.add(e);//添加
				    }
				    else{
				    	peitaolist.add(e);
				    }
				}
			//项目配套，和修改之前的项目配套做对比，然后把删除的项目配套item的保存到deletelist，然后再dao层做删除
			for (int i=0;i<projectPeiTaoListbefore.size();i++){
				boolean flag=false;

				for(int j=0;j<peitaolist.size();j++){
					if(projectPeiTaoListbefore.get(i).getId()==peitaolist.get(j).getId()){
						flag=true;
						break;
					}
				}
				if (flag==false) {
					peitaolistdelete.add(projectPeiTaoListbefore.get(i));
				}
			}

		//附近配套

		String fujinpeitao=req.getParameter("fujinlist");
		JSONArray fujinArray = JSONArray.parseArray(fujinpeitao);
	    List<FujinPeiTao> fujinpeitaoList=new ArrayList<FujinPeiTao>();//鐢ㄤ簬缂栬緫鐨勯」
	    List<FujinPeiTao> fujinpeitaoList2=new ArrayList<FujinPeiTao>();//鐢ㄤ簬娣诲姞鐨勯」
	    List<FujinPeiTao> fujinpeitaoListdelete=new ArrayList<FujinPeiTao>();
		for (int i=0;i<fujinArray.size();i++){
				 JSONObject object = (JSONObject)fujinArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 FujinPeiTao e = (FujinPeiTao) JSONToObj(object.toString(), FujinPeiTao.class);
				 if(e.getId()==0){
					 fujinpeitaoList2.add(e);//id涓�0锛屾坊鍔�
				 }
				 else{
					 fujinpeitaoList.add(e);//鍚﹀垯锛岀紪杈�
				 }
		}
		//附近配套，和修改之前的附近配套做对比。把删除的附近配套item保存到deletelist，然后再传到dao层做删除
		for (int i=0;i<fujinPeitaoListbefore.size();i++){
			boolean flag=false;
			for(int j=0;j<fujinpeitaoList.size();j++){
				if(fujinPeitaoListbefore.get(i).getId()==fujinpeitaoList.get(j).getId()){
					flag=true;
					break;
				}
			}
			if(flag==false){
				fujinpeitaoListdelete.add(fujinPeitaoListbefore.get(i));
			}
		}

		System.out.println("fujinpeitaoList.length():"+fujinpeitaoList.size());
		System.out.println("fujinpeitaoList2.length():"+fujinpeitaoList2.size());
		//附近学校
		String schoolInfo=req.getParameter("schoollist");
		JSONArray schoolArray = JSONArray.parseArray(schoolInfo);
		List<FujinSchool> fujinSchoolList=new ArrayList<FujinSchool>();//鐢ㄤ簬缂栬緫鐨勯」
		List<FujinSchool> fujinSchoolList2=new ArrayList<FujinSchool>();//鐢ㄤ簬娣诲姞鐨勯」
		List<FujinSchool> fujinSchoolListdelete=new ArrayList<FujinSchool>();//鐢ㄤ簬娣诲姞鐨勯」
		for (int i=0;i<schoolArray.size();i++){
						 JSONObject object = (JSONObject)schoolArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
						 FujinSchool e = (FujinSchool) JSONToObj(object.toString(), FujinSchool.class);
						 if(e.getId()==0){
							 fujinSchoolList2.add(e);
						 }
						 else{
							 fujinSchoolList.add(e);
						 }
		   }
		//附近学校，和修改之前的学习list做对比。把删除的附近学校的item保存到deletelist里，然后传到dao层删除。
		for (int i=0;i<fujinSchoolListbefore.size();i++){
			boolean flag=false;
			for(int j=0;j<fujinSchoolList.size();j++){
				if(fujinSchoolListbefore.get(i).getId()==fujinSchoolList.get(j).getId()){
					flag=true;
					break;
				}
			}

			if(flag==false){
				fujinSchoolListdelete.add(fujinSchoolListbefore.get(i));
			}
		}
		System.out.println("fujinSchoolList.length():"+fujinSchoolList.size());
		System.out.println("fujinSchoolList2.length():"+fujinSchoolList2.size());
		//持有成本
		String holdingcost=req.getParameter("holdingcostlist");
		JSONArray holdCostArray = JSONArray.parseArray(holdingcost);
		List<HoldCost> holdCostList=new ArrayList<HoldCost>();//鐢ㄤ簬缂栬緫鐨勯」
		List<HoldCost> holdCostList2=new ArrayList<HoldCost>();//鐢ㄤ簬娣诲姞鐨勯」
		List<HoldCost> holdCostListdelete=new ArrayList<HoldCost>();//鐢ㄤ簬娣诲姞鐨勯」
		for (int i=0;i<holdCostArray.size();i++){
				JSONObject object = (JSONObject)holdCostArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
			    HoldCost e = (HoldCost) JSONToObj(object.toString(), HoldCost.class);
			    if(e.getId()==0){
			    	holdCostList2.add(e);//缂栬緫鐨勯」
			    }
			    else{
			    	holdCostList.add(e);//娣诲姞鐨勯」
			    }
			}
		//持有成本，和修改之前的持有成本list做对比，把 删除的持有成本保存到deletelist列表里，然后再dao层做删除。
		for (int i=0;i<holdCostListbefore.size();i++){
			boolean flag=false;
			for(int j=0;j<holdCostList.size();j++){
				if(holdCostListbefore.get(i).getId()==holdCostList.get(j).getId()){
					flag=true;
					break;
				}
			}
			if(flag==false){
				holdCostListdelete.add(holdCostListbefore.get(i));
			}
		}

		System.out.println("holdCostList.length():"+holdCostList.size());
		System.out.println("holdCostList2.length():"+holdCostList2.size());
		//购房税费
		String houseTax=req.getParameter("housetaxformlist");
		JSONArray houseTaxArray = JSONArray.parseArray(houseTax);
		List<HouseTax> houseTaxList=new ArrayList<HouseTax>();//鐢ㄤ簬缂栬緫
		List<HouseTax> houseTaxList2=new ArrayList<HouseTax>();//鐢ㄤ簬娣诲姞
		List<HouseTax> houseTaxListdelete=new ArrayList<HouseTax>();//鐢ㄤ簬娣诲姞
		for (int i=0;i<houseTaxArray.size();i++){
					JSONObject object = (JSONObject)houseTaxArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
					HouseTax e = (HouseTax) JSONToObj(object.toString(), HouseTax.class);
					if(e.getId()==0){
						 houseTaxList2.add(e);//鐢ㄤ簬娣诲姞
					}
					else{
						 houseTaxList.add(e);//鐢ㄤ簬缂栬緫
					}
		}
		//购房税费，和修改之前的购房税费做对比，把删除的购房税费的item保存到购房税费deletelist，然后再dao层做删除。
		for (int i=0;i<houseTaxListbefore.size();i++){
			boolean flag=false;

			for(int j=0;j<houseTaxList.size();j++){
				if(houseTaxListbefore.get(i).getId()==houseTaxList.get(j).getId()){
					flag=true;
					break;
				}
			}
			if(flag==false){
				houseTaxListdelete.add(houseTaxListbefore.get(i));
			}
		}
		System.out.println("houseTaxList.length():"+houseTaxList.size());
		System.out.println("houseTaxList2.length():"+houseTaxList2.size());
		//项目关键字
				String projectkey=req.getParameter("keylist");
				JSONArray keyArray = JSONArray.parseArray(projectkey);
				List<ProjectKey> keylist=new ArrayList<ProjectKey>();
				for (int i=0;i<keyArray.size();i++){
					 JSONObject object = (JSONObject)keyArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
					 ProjectKey e = (ProjectKey) JSONToObj(object.toString(), ProjectKey.class);
					 keylist.add(e);
				}
				//推荐经纪人 经纪人按项目进行推荐
				String brokerlist=req.getParameter("brokerlist");
				JSONArray brokerlistArray = JSONArray.parseArray(brokerlist);
				int length = brokerlistArray.size() >= 3 ? 3: brokerlistArray.size();
				
				List<BrokerInfo> brokerlistList=new ArrayList<BrokerInfo>();
				List<BrokerInfo> brokerlistList2=new ArrayList<BrokerInfo>();
				/*List<BrokerInfo> brokerlistListdelete=new ArrayList<BrokerInfo>();*/
				for (int i = 0; i < length; i++){
					 JSONObject object = (JSONObject)brokerlistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
					 BrokerInfo e = (BrokerInfo) JSONToObj(object.toString(), BrokerInfo.class);
					 if(e.getId()==0){
						 brokerlistList2.add(e);//用于添加
					 }else{
						 brokerlistList.add(e);//用于编辑
					 }
					 /*brokerlistList.add(e);*/
				}
		/*int isDuplicate=projectInputDao.isDuplicateNum(project_num);
		if(isDuplicate==1){
			json.put("isDuplicate", "1");
		}
		else{*/
		//鏇存柊
	    try {
			int result=projectInputDao.EditProject(id, projectlist,houseInfolist,houseInfolist2,peitaolist,peitaolist2,imagelist,imagelist2,fujinpeitaoList,fujinpeitaoList2,fujinSchoolList,fujinSchoolList2,holdCostList,holdCostList2,houseTaxList,houseTaxList2,houseInfolistdelete,imagelistdelete,peitaolistdelete,fujinpeitaoListdelete,fujinSchoolListdelete,holdCostListdelete,houseTaxListdelete,keylist,brokerlistList2,brokerlistList);
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
	

	//后台编辑经纪人信息。

	/**
	 * 经纪人编辑
	 * @param req
	 * @param resp
	 */

		@RequestMapping({ "/EditBrokerInfo" })
		public void  EditBroker(HttpServletRequest req,HttpServletResponse resp){
			JSONObject json=new JSONObject();
			String idstr=req.getParameter("id");
			int id=Integer.parseInt(req.getParameter("id"));
			
			//经济人基本信息
			String brokerinfo=req.getParameter("broker");
			JSONObject brokerInfo = JSONObject.parseObject(brokerinfo);
			Broker broker= (Broker) JSONToObj(brokerInfo.toString(), Broker.class);
		
			//经纪人服务区域
		    String arealist=req.getParameter("arealist");
			JSONArray areaArray = JSONArray.parseArray(arealist);
			List<ServiceArea> serviceArealist=new ArrayList<ServiceArea>();
			List<ServiceArea> serviceArealist2=new ArrayList<ServiceArea>();
			List<ServiceArea> serviceArealistdelete=new ArrayList<ServiceArea>();
			for (int i=0;i<areaArray.size();i++){
					JSONObject object = (JSONObject)areaArray.get(i);
					ServiceArea e = (ServiceArea) JSONToObj(object.toString(), ServiceArea.class);
				    if(e.getId()==0){
				    	serviceArealist2.add(e);//用于添加
				    }
				    else{
				    	serviceArealist.add(e);//用于更新
				    }
				}
			//服务区域，和修改之前的服务区域列表做列表，把删除的服务区域item存在deletelist列表里，然后再dao层做删除。
			for (int i=0;i<brokerServiceAreaListbefore.size();i++){
				boolean flag=false;
				for(int j=0;j<serviceArealist.size();j++){
					if(brokerServiceAreaListbefore.get(i).getId()==serviceArealist.get(j).getId()){
						flag=true;
						break;
					}
				}
				if(flag==false){
					serviceArealistdelete.add(brokerServiceAreaListbefore.get(i));
				}
			}

			//经纪人擅长的类型。

			//经纪人擅长类型

			String typelist=req.getParameter("typelist");
			JSONArray typeArray = JSONArray.parseArray(typelist);
			List<BrokerType> brokerTypelist=new ArrayList<BrokerType>();
			List<BrokerType> brokerTypelist2=new ArrayList<BrokerType>();
			List<BrokerType> brokerTypelistdelete=new ArrayList<BrokerType>();
			for (int i=0;i<typeArray.size();i++){
					JSONObject object = (JSONObject)typeArray.get(i); 
					BrokerType e = (BrokerType) JSONToObj(object.toString(), BrokerType.class);
				    if(e.getId()==0){
				    	brokerTypelist2.add(e);//用于添加
				    }
				    else{
				    	if("公寓".equals(e.getInterested_num())){
							e.setInterested_num("house_01");
						}else if("别墅".equals(e.getInterested_num())){
							e.setInterested_num("house_02");
						}else if("联排别墅".equals(e.getInterested_num())){
							e.setInterested_num("house_03");
						}
				    	brokerTypelist.add(e);//用于更新
				    }
				}

			/*if(brokerTypelist.size()==0){
				brokerTypelistdelete=brokerIntegertypeListbefore;
			}*/
			//擅长类型，和修改之前的擅长类型的列表做对比，把删除的擅长类型保存在deletelist，然后再dao层做删除。

			

			for (int i=0;i<brokerIntegertypeListbefore.size();i++){
				boolean flag=false;
				for(int j=0;j<brokerTypelist.size();j++){
					if(brokerIntegertypeListbefore.get(i).getId()==brokerTypelist.get(j).getId()){
						flag=true;
						break;
					}
				}
				if(flag==false){
					brokerTypelistdelete.add(brokerIntegertypeListbefore.get(i));
				}
			}
			int isDuplicate=0;//brokerInfoDao.isDuplicate(broker.getBroker_num());
			if (isDuplicate==1) {
				json.put("isDuplicate", "1");
			}
			else{
				try {
					int result=projectInputDao.UpdateBroker(id, broker, serviceArealist,serviceArealist2, brokerTypelist,brokerTypelist2,serviceArealistdelete,brokerTypelistdelete);
					if(result==1){
						json.put("flag", "1");
					}
					else{
						json.put("flag", "0");
					}
					System.out.println("result::"+result);
			    } catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	

	//后台接受添加学校的action

	//添加学校信息

	@RequestMapping({ "/AddschoolInfo" })
	public void InsertSchoolInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean flag = false;
		String school_name=req.getParameter("school_name");
		String school_ranking=req.getParameter("school_rank");
		String  school_type=req.getParameter("school_type");
		 String nation=req.getParameter("nation");
		 String city=req.getParameter("city");
		String school_total_str=req.getParameter("school_total");
		int school_total = 0;
		if(school_total_str == null || "".equals(school_total_str)){
			school_total = 0;
		}
		else{
			school_total = Integer.parseInt(school_total_str);
		}
		//int school_total = school_total_str == "" ? -1 :Integer.parseInt(school_total_str);
		
		String teacher_total_str=req.getParameter("teacher_num");
		int teacher_total = 0;
		if(teacher_total_str == null || "".equals(teacher_total_str)){
			teacher_total = 0;
		}
		else{
			teacher_total = Integer.parseInt(teacher_total_str);
		}
		//int teacher_total = teacher_total_str == "" ? -1 :Integer.parseInt(teacher_total_str);
		
		String school_position=req.getParameter("school_position");
		String gps=req.getParameter("school_gps");
		String net_info=req.getParameter("school_url");
		
		String  not_en_stu_bili_str=req.getParameter("non_en_studen_trate");
		int not_en_stu_bili = 0;
		if(not_en_stu_bili_str == null || "".equals(not_en_stu_bili_str)){
			not_en_stu_bili = 0;
		}
		else{
			not_en_stu_bili = Integer.parseInt(not_en_stu_bili_str);
		}
		//int not_en_stu_bili = not_en_stu_bili_str == "" ? -1 :Integer.parseInt(not_en_stu_bili_str);
		
		String school_image=req.getParameter("schoolimg");
		String school_desc=req.getParameter("school_intro");
		int isDuplicate=schoolinfodao.isDuplicate(school_name,nation,city);
		if (isDuplicate==1) {
			json.put("isDuplicate", "1");
		}
		else{
			flag=projectInputDao.InsertSchoolInfo(school_name, school_ranking, school_type, school_total, teacher_total, school_position, gps, net_info, not_en_stu_bili, school_image, school_desc, nation, city);
			if(flag==false){
		    	json.put("flag", "0");
		    }
		    else{
		    	json.put("flag", "1");
		    }
		}
	    try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//后台编辑学校信息 ，  接收修改后的学校信息的action

	//更新学校信息

	@RequestMapping({ "/EditSchoolInfo" })
	public void updateSchoolInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean flag = false;
	    int id=Integer.parseInt(req.getParameter("id"));
		String school_name=req.getParameter("school_name");
		String school_ranking=req.getParameter("school_rank");
		String  school_type=req.getParameter("school_type");
		String nation=req.getParameter("nation");
		String  city=req.getParameter("city");
		String school_total_str=req.getParameter("school_total");
		int school_total = 0;
		if(school_total_str == null || "".equals(school_total_str)){
			school_total = 0;
		}
		else{
			school_total = Integer.parseInt(school_total_str);
		}
		//int school_total = school_total_str == "" ? -1 :Integer.parseInt(school_total_str);
		
		String teacher_total_str=req.getParameter("teacher_num");
		int teacher_total = 0;
		if(teacher_total_str == null || "".equals(teacher_total_str)){
			teacher_total = 0;
		}
		else{
			teacher_total = Integer.parseInt(teacher_total_str);
		}
		//int teacher_total = teacher_total_str == "" ? -1 :Integer.parseInt(teacher_total_str);
		
		String school_position=req.getParameter("school_position");
		String gps=req.getParameter("school_gps");
		String net_info=req.getParameter("school_url");
		
		String  not_en_stu_bili_str=req.getParameter("non_en_studen_trate");
		int not_en_stu_bili = 0;
		if(not_en_stu_bili_str == null || "".equals(not_en_stu_bili_str)){
			not_en_stu_bili = 0;
		}
		else{
			not_en_stu_bili = Integer.parseInt(not_en_stu_bili_str);
		}
		//int not_en_stu_bili = not_en_stu_bili_str == "" ? -1 :Integer.parseInt(not_en_stu_bili_str);
		
		String school_image=req.getParameter("schoolimg");
		String school_desc=req.getParameter("school_intro");
		int isDuplicate=0;//schoolinfodao.isDuplicate(school_name,nation,city);
		if (isDuplicate==1) {
			json.put("isDuplicate", "1");
		}
		else {
			flag=projectInputDao.UpdateSchoolInfo(id, school_name, school_ranking, school_type, school_total, teacher_total, school_position, gps, net_info, not_en_stu_bili, school_image, school_desc,nation,city);
		    if(flag==false){
		    	json.put("flag", "0");
		    }
		    else{
		    	json.put("flag", "1");
		    }
		}
	    try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//后台添加开发商信息的action，接收新的开发商数据

	//添加开发商信息

	@RequestMapping({ "/AddDeveloperInfo" })
	public void InsertDeveloperInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		String developer_name=req.getParameter("developer_name");
		String developer_logo=req.getParameter("developer_logo");
		String  developer_desc=req.getParameter("developer_desc");
		String  nation=req.getParameter("nation");
		String developer_num=req.getParameter("developer_num");
		int isDuplicate=projectInputDao.isDeveloperDuplicate(developer_name,nation);
		if (isDuplicate==1) {
			json.put("isDuplicate", "1");
		}
		else {
			boolean flagbol=projectInputDao.InsertDeveloperInfo(developer_name, developer_logo, developer_desc, developer_num, nation);
		    if(flagbol==false){
		    	json.put("flag", "0");
			}
		    else{
		    	json.put("flag", "1");
		    }
		}
		try{
			 PrintWriter out = resp.getWriter();
			 out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		}
	}
	/**
	 * 根据项目id删除项目
	 * @param req
	 * @param resp
	 */
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

	//后台项目列表上架项目

	/**
	 * 上架一个项目
	 * @param req
	 * @param resp
	 */

	@RequestMapping({ "/ShowProject" })
	public void ShowProject(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		int id=Integer.parseInt(req.getParameter("id"));
		int result=projectInputDao.ShowProject(id);
	    if(result==1){
	    	json.put("flag", "1");
		}
	    else{
	    	json.put("flag", "0");
	    }
		try{
			 PrintWriter out = resp.getWriter();
			 out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		}
	}

	//后台项目列表下架项目

	/**
	 * 下架一个项目
	 * @param req
	 * @param resp
	 */

	@RequestMapping({ "/UnShowProject" })
	public void UnShowProject(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		int id=Integer.parseInt(req.getParameter("id"));
		int result=projectInputDao.UnShowProject(id);
	    if(result==1){
	    	json.put("flag", "1");
		}
	    else{
	    	json.put("flag", "0");
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

	//后台开发商列表，删除指定的开发商

	//根据id删除开发商信息

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
		//后台置业指导列表，删除指定的职业指导信息。
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

				//后台经纪人列表，删除指定的经纪人

				/**
				 * 根据id删除经纪人
				 * @param req
				 * @param resp
				 */

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

				//后台新闻博客列表，删除指定的新闻

				/**
				 * 根据id删除新闻博客
				 * @param req
				 * @param resp
				 */

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

	//后台编辑开发商信息

	//更新开发商信息

	@RequestMapping({ "/EditDeveloperInfo" })
	public void UpdateDeveloperInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		int id=Integer.parseInt(req.getParameter("id"));
		String developer_name=req.getParameter("developer_name");
		String developer_logo=req.getParameter("developer_logo");
		String  developer_desc=req.getParameter("developer_desc");
		String  nation=req.getParameter("nation");
		String developer_num=req.getParameter("developer_num");
		int isDuplicate=0;//projectInputDao.isDeveloperDuplicate(developer_name,nation);
		if (isDuplicate==1) {
			json.put("isDuplicate", "1");
		}
		else {
			 boolean flagbol=projectInputDao.UpdateDeveloperInfo(id, developer_name, developer_logo, developer_desc, developer_num, nation);
			    if(flagbol==false){
			    	json.put("flag", "0");
				}
			    else{
			    	json.put("flag", "1");
			    }
		}
		try{
			 PrintWriter out = resp.getWriter();
			 out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		}
	}
	//ckeditor控件里的上传图片的处理action
	@RequestMapping(value = "/ckimageupload",produces = {"application/html;charset=UTF-8"})
    public void handleFormUpload(
            @RequestParam("upload") MultipartFile file,HttpServletRequest request, HttpServletResponse resp) {
		JSONObject json = new JSONObject();
		json.put("total", 1);
		json.put("rows", 1);
		PrintWriter out;
		String callback =request.getParameter("CKEditorFuncNum");
        if (!file.isEmpty()) {
        	try{
        			ImageDao.CopyImage(file,new String(file.getOriginalFilename().getBytes("ISO8859_1"),"utf-8"));
        			String name=new String(file.getOriginalFilename().getBytes("ISO8859_1"),"utf-8");
        			String fullPath ="/Uploadimages/"+ File.separator+name;
        			String s;
        			if(StringUtils.isNotBlank(callback)){
        	            s= "<script type='text/javascript'>"
        	            + "window.parent.CKEDITOR.tools.callFunction(" + callback
        	            + ",'" + fullPath + "',''" + ")"+"</script>";
        	        }else{
        	            s= "{" + file.getOriginalFilename() + "}!Success!";
        	        }
        			try {
        	            out = resp.getWriter();
        	            out.print(s);
        	            out.flush();
        	        } catch (IOException e) {
        	            e.printStackTrace();
        	        }
        	}
        	catch(Exception e){
        		e.printStackTrace();
        	}
        	try{
    			writeJson(json.toJSONString(),resp);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
        }
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
    }
	//处理后台上传图片的action
	@RequestMapping(value = "/imageupload")
    public void handleFormUpload(
            @RequestParam("file") MultipartFile file, HttpServletResponse resp) {
		JSONObject json = new JSONObject();
		json.put("total", 1);
		json.put("rows", 1);
		
        if (!file.isEmpty()) {
        	try{
        			ImageDao.CopyImage(file,new String(file.getOriginalFilename().getBytes("ISO8859_1"),"utf-8"));
        	}
        	catch(Exception e){
        		e.printStackTrace();
        	}
        	try{
    			writeJson(json.toJSONString(),resp);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
        }
        
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
    }
	/**
	 * 根据id查找项目信息
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping({ "/selectProject" })
	public String selectProject(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		int id =Integer.parseInt(req.getParameter("id"));
		//根据项目id查找项目信息
		HouseProject houseProject=projectInputDao.selectProjectInfo(id);
		req.setAttribute("houseProject", houseProject);
		//根据项目id查找项目编号
		String pronum=projectInputDao.getProNumById(id);
		//根据项目编号查找户型及价格信息
		List<HouseInfo1> houseInfoList=projectInputDao.getHouseInfoByProNum(pronum);
		houseInfoListbefore=projectInputDao.getHouseInfoByProNum(pronum);
		req.setAttribute("houseInfoList", houseInfoList);
		req.setAttribute("houseInfoListJson", ConvertJson.list2json(houseInfoList).replace("&nbsp;", " ").replace("&#39;", "\\'").replace("'", "\\'"));

		//根据项目编号获取项目图片

		List <ProjectPeiTao> projectPeiTaoList =projectInputDao.getProjectpeiTaoByProNum(pronum);
		projectPeiTaoListbefore=projectInputDao.getProjectpeiTaoByProNum(pronum);
		req.setAttribute("projectPeitaoList", projectPeiTaoList);
		req.setAttribute("projectPeitaoListJson", ConvertJson.list2json(projectPeiTaoList).replace("&nbsp;", " ").replace("&#39;", "\\'").replace("'", "\\'"));

		//根据项目编号获取项目配套
		List <ProjectDescImage> projectImageList =projectInputDao.getProjectImageByProNum(pronum);
		projectImageListbefore=projectInputDao.getProjectImageByProNum(pronum);
		req.setAttribute("projectImageList", projectImageList);
		req.setAttribute("projectImageListJson", ConvertJson.list2json(projectImageList).replace("&nbsp;", " ").replace("&#39;", "\\'").replace("'", "\\'"));
		//根据项目编号获取附近配套

		List<FujinPeiTao> fujinPeitaoList=projectInputDao.getFujinPeiTaoByProNum(pronum);
		fujinPeitaoListbefore=projectInputDao.getFujinPeiTaoByProNum(pronum);
		req.setAttribute("fujinPeitaoList",fujinPeitaoList );
		req.setAttribute("fujinPeitaoListJson", ConvertJson.list2json(fujinPeitaoList).replace("&nbsp;", " ").replace("&#39;", "\\'").replace("'", "\\'"));
		//根据项目编号获取附近学校信息
		List<FujinSchool> fujinSchoolList=projectInputDao.getFujinSchoolByProNum(pronum);
		fujinSchoolListbefore=projectInputDao.getFujinSchoolByProNum(pronum);
		req.setAttribute("fujinSchoolList",fujinSchoolList );
		req.setAttribute("fujinSchoolListJson", ConvertJson.list2json(fujinSchoolList).replace("&nbsp;", " ").replace("&#39;", "\\'").replace("'", "\\'"));
		//根据项目编号获取持有成本信息
		List<HoldCost> holdCostList=projectInputDao.getHoldCostByProNum(pronum);
		holdCostListbefore=projectInputDao.getHoldCostByProNum(pronum);
		req.setAttribute("holdCostList",holdCostList );
		req.setAttribute("holdCostListJson", ConvertJson.list2json(holdCostList).replace("&nbsp;", " ").replace("&#39;", "\\'").replace("'", "\\'"));
		//根据项目编号获取购房税费信息
		List<HouseTax> houseTaxList=projectInputDao.getHouseTaxByProNum(pronum);
		houseTaxListbefore=projectInputDao.getHouseTaxByProNum(pronum);
		req.setAttribute("houseTaxList",houseTaxList );
		req.setAttribute("houseTaxListJson", ConvertJson.list2json(houseTaxList).replace("&nbsp;", " ").replace("&#39;", "\\'").replace("'", "\\'"));
		//推荐经纪人    按项目进行推荐
		List<BrokerInfo> brokerlist=projectInputDao.getBrokerInfoByProNum(pronum);
		brokerlistbefore=projectInputDao.getBrokerInfoByProNum(pronum);
		req.setAttribute("brokerlist",brokerlist );
		req.setAttribute("brokerlistJson", ConvertJson.list2json(brokerlist).replace("&nbsp;", " ").replace("&#39;", "\\'").replace("'", "\\'"));

		
		//得到开发商信息
		List<String> codeAndNameSet=projectInputDao.getDeveloperCodeName();
		req.setAttribute("codeAndNameSet", codeAndNameSet);
		//得到学校信息
		List<String> schoolList=projectInputDao.getAllSchoolName();
		req.setAttribute("schoolList", schoolList);
		//根据项目编号获取项目关键字
		ProjectKey key=projectInputDao.getKeyByNum(pronum);
		req.setAttribute("key", key);
		//不包含推荐经纪人的返回页
		//return "/ProjectInfo.jsp";
		
		//包含推荐经纪人的代码如下
		getBrokerName1(req,resp);
		return "/ProjectInfoBroker.jsp";
	}
	@RequestMapping({"/selectProject/Broker"})
	public void getBrokerName1(HttpServletRequest req,HttpServletResponse resp){
		List<BrokerInfo> brokerSet=areaInputDao.getBrokers();
		req.setAttribute("brokerSet", brokerSet);
	}
	//根据id查找学校信息
	@RequestMapping({ "/selectSchoolInfo" })
	public String selectSchoolInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		int id =Integer.parseInt(req.getParameter("id"));
		SchoolInfo schoolInfo=projectInputDao.selectSchoolInfo(id);
		req.setAttribute("schoolInfo", schoolInfo);
		return "/SchoolInfoEdit.jsp";
	}
	//根据id查找开发商信息
		@RequestMapping({ "/selectDeveloperInfo" })
		public String selectDeveloperInfo(HttpServletRequest req,HttpServletResponse resp){
			JSONObject json = new JSONObject();
			int id =Integer.parseInt(req.getParameter("id"));
			DeveloperInfo developerInfo=projectInputDao.selectDeveloperInfo(id);
			req.setAttribute("developerInfo", developerInfo);
			return "/DeveloperInfo.jsp";
		}
		/**
		 * 根据id查找新闻博客信息
		 * @param req
		 * @param resp
		 * @return
		 */
				@RequestMapping({ "/selectNewsBokeInfo" })
				public String selectNewsbokeInfo(HttpServletRequest req,HttpServletResponse resp){
					JSONObject json = new JSONObject();
					int id =Integer.parseInt(req.getParameter("id"));
					NewsBoke newsBoke=projectInputDao.selectNewsBokeInfo(id);
					List<String> fenleiList = zhiYeDao.newsBokeFenlei();
					req.setAttribute("fenleiList",fenleiList);
					req.setAttribute("newsBoke", newsBoke);
					return "/newsInfoEdit.jsp";
				}
				/**
				 * 根据id查找置业指导信息
				 * @param req
				 * @param resp
				 * @return
				 */
				@RequestMapping({ "/selectZhiyeInfo" })
				public String selectZhiyeInfo(HttpServletRequest req,HttpServletResponse resp){
					JSONObject json = new JSONObject();
					int id =Integer.parseInt(req.getParameter("id"));
					//鏍规嵁椤圭洰id鍙栭」鐩俊鎭�
					ZhiYeZhiDao zhiYeZhiDao=projectInputDao.selectZhiyeInfo(id);
					req.setAttribute("zhiYeZhiDao", zhiYeZhiDao);
					return "/zhiyeInfo.jsp";
				}
				/**
				 * 根据id查找经纪人相关信息
				 * @param req
				 * @param resp
				 * @return
				 */
				@RequestMapping({ "/selectBroker" })
				public String selectBroker(HttpServletRequest req,HttpServletResponse resp){
					JSONObject json = new JSONObject();
					int id =Integer.parseInt(req.getParameter("id"));
					//根据id查找经纪人基本信息
					Broker broker=projectInputDao.selectBroker(id);
					req.setAttribute("broker", broker);
					//根据id查找经纪人编号
					String broker_num=projectInputDao.findBrokerNumById(id);
					//根据经纪人编号查找经纪人服务区域
					List<ServiceArea> brokerServiceAreaList=projectInputDao.findBrokerAreaList(broker_num);
					brokerServiceAreaListbefore=projectInputDao.findBrokerAreaList(broker_num);
					
					req.setAttribute("brokerServiceAreaList", brokerServiceAreaList);
					req.setAttribute("brokerServiceAreaListJson", ConvertJson.list2json(brokerServiceAreaList).replace(" ", "&nbsp;").replace("'", "&#39;"));
					//根据经济人编号得到经纪人擅长类型
					List<BrokerType> brokerIntegertypeList=projectInputDao.findBrokerTypeList(broker_num);
					for(int i=0;i<brokerIntegertypeList.size();i++){
						String num=brokerIntegertypeList.get(i).getInterested_num();
						if("house_01".equals(num)){
							brokerIntegertypeList.get(i).setInterested_num("公寓");
						}else if("house_02".equals(num)){
							brokerIntegertypeList.get(i).setInterested_num("别墅");
						}else if("house_03".equals(num)){
							brokerIntegertypeList.get(i).setInterested_num("联排别墅");
						}
					}
					brokerIntegertypeListbefore=projectInputDao.findBrokerTypeList(broker_num);
					req.setAttribute("brokerIntegertypeList", brokerIntegertypeList);
					req.setAttribute("brokerIntegertypeListJson", ConvertJson.list2json(brokerIntegertypeList).replace(" ", "&nbsp;").replace("'", "&#39;"));
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
