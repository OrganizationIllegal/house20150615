package com.kate.app.controller;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kate.app.dao.AdDao;
import com.kate.app.dao.AjaxDao;
import com.kate.app.dao.AreaInfoDao;
import com.kate.app.dao.BingMapDao;
import com.kate.app.dao.BrokerInfoDao;
import com.kate.app.dao.HouseProjectDao;
import com.kate.app.dao.ProjectInputDao;
import com.kate.app.dao.SearchListDao;
import com.kate.app.dao.UserDao;
import com.kate.app.model.AreaInfo;
import com.kate.app.model.BingMapVo;
import com.kate.app.model.City;
import com.kate.app.model.HouseProject;
import com.kate.app.model.Nation;
import com.kate.app.model.ProjectDescImage;

import com.kate.app.model.ProjectKey;
import com.kate.app.model.SearchList;

import com.kate.app.model.Quyu;

import com.kate.app.service.BingMapService;
@Controller
public class BingMapController {
	@Autowired
	private BingMapService bingMapService;
	@Autowired
	private BingMapDao bingMapDao;
	@Autowired
	private HouseProjectDao houseProjectDao;
	@Autowired
	private ProjectInputDao projectInputDao;
	
	@Autowired
	private AdDao addao;
	@Autowired
	private SearchListDao searchListDao;
	@Autowired
	private AjaxDao ajaxDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private AreaInfoDao areaInfoDao;
	@Autowired
	private BrokerInfoDao brokerInfoDao;

	
	private static List<SearchList> seachListResult1;    //搜索之后的结果
	private static List<BingMapVo> BingMapVoList;    //搜索之后的结果
	
	private static List<HouseProject>  seachListResult;
	private static List<HouseProject>  seachListResultShengxu;
	private static List<HouseProject>  seachListResultJiangxu;
	
	private static List<HouseProject> typeListResult;
	private static List<HouseProject> typeListResultShengxu;
	private static List<HouseProject> typeListResultJiangxu;
	
	private static List<HouseProject> listResult;
	private static List<HouseProject> lianDongResult;
	
	
	private static int flagInfo = 0;
	private static int orderFlag = 0;
	private static int liandong = 0;
	
	//地图中心点录入
	@RequestMapping({"/MapCenterInput"})
	public String mapCenterInput(HttpServletRequest req,HttpServletResponse resp){
		List<String> list1= new ArrayList<String>();
		List<String> areaNameSet=bingMapDao.getAreaName1();
		for(String i:areaNameSet){  
	        if(!list1.contains(i)){  
	        	list1.add(i);  
	        }  
	    }  
		List<String> cityNameSet=bingMapDao.getCityName1();
		for(String j:cityNameSet){  
	        if(!list1.contains(j)){  
	        	list1.add(j);  
	        }  
	    }  
		req.setAttribute("areacityNameSet", list1);
		return "/GpsCenterInput.jsp";
	}
	
	
	/*
	 * 首页的搜索功能
	 */
		@RequestMapping({"/IndexSearch1"})
		public String IndexSearch(HttpServletRequest req, HttpServletResponse resp){
			flagInfo = 1;     //搜索结果页面
			NumberFormat nf = new DecimalFormat("#,###,###");
			String searchcity = req.getParameter("searchcity");
			String type = req.getParameter("type");
			String minimumprice = req.getParameter("minimumprice");
			String maximumprice = req.getParameter("maximumprice");
			String country = req.getParameter("country");
			String city2 = req.getParameter("city2");
			String xinkaipan = req.getParameter("xinkaipan");
			String huaren = req.getParameter("huaren");
			String remen = req.getParameter("remen");
			String xuequ = req.getParameter("xuequ");
			String baozu = req.getParameter("baozu");
			String daxue = req.getParameter("daxue");
			String center = req.getParameter("center");
			String traffic = req.getParameter("traffic");
			String xianfang = req.getParameter("xianfang");
			String maidi = req.getParameter("maidi");
			String city = null;
			List<HouseProject> list1 = new ArrayList<HouseProject>();
			List<HouseProject> resultList = new ArrayList<HouseProject>();
			HouseProject pro = new HouseProject();
			String areaNum = null;
			int flag = 0;
			if(searchcity!=null && !"".equals(searchcity)){
				flag = 1;
				String[] searchItemList = searchcity.split(",");
				if(searchItemList.length>2){
				//if(searchcity.indexOf(",") >= 0){      //包含逗号的情况
					String[] strs = searchcity.split(",");
					String areaName = "";
					if(strs.length>0){
						areaName = strs[0];
					}
					
					AreaInfo areaInfo = areaInfoDao.getAreaInfo(areaName);   //根据区域名称得到区域的信息
					if(areaInfo!=null){
						areaNum = areaInfo.getArea_num();
						list1 = searchListDao.searchIndexProject(areaNum);  //通过区域的名称在数据库中查找项目信息
					}
				}
				else if(searchItemList.length == 2){
					String[] strs1 = searchcity.split(",");
					String city1 = strs1[0];
					list1 = searchListDao.searchIndexProjectByCity(city1, searchcity);  //通过区域的名称在数据库中查找项目信息
				}
				else{
					if(searchcity.indexOf("项目名称")>0){   //包含项目名称字段
						int weizhi = searchcity.indexOf("(");
						String projectName = searchcity.substring(0,weizhi-1).trim();
						
						list1 = searchListDao.searchIndexProjectByPro(projectName);  //通过前台传来的信息，在数据库中查找项目信息
						
					}
					else{
						list1 = searchListDao.searchIndexList(searchcity);    //通过前台传来的数据，查找项目信息
						if(list1==null || list1.size()<=0){
							//String area_num = searchListDao.searchIndexList1(searchcity);  //通过关键字段，查找区域编号
							//list1 = searchListDao.searchIndexProject(area_num);   //通过区域编号在数据库中查找项目信息
							list1 = searchListDao.searchIndexProjectNew(searchcity);   //通过区域编号在数据库中查找项目信息
						}
						
					}
					
				}
			}
			if(city2!=null && !"".equals(city2)){
				city = city2;
			}
			/*
			 * 通过城市，类型等，进一步高级搜索，在数据库中查找项目信息
			 */
			List<HouseProject> list = searchListDao.indexSericeList(country, city, type, minimumprice, maximumprice, xinkaipan, huaren, remen, xuequ, baozu, daxue, center, traffic, xianfang, maidi);
			if(list1.size()>=0){
				if(list1.size()>list.size()){
					for(int i=0; i<list1.size();i++){
						for(int j=0;j<list.size();j++){
							if(list.get(j).getProject_num().equals(list1.get(i).getProject_num())){
								resultList.add(list.get(j));
								break;
							}
						}
					}
				}
				else if(list1.size()<=list.size() ){
					if(flag==0){
						resultList = list;
					}
					else{
						for(int i=0; i<list.size();i++){
							for(int j=0;j<list1.size();j++){
								if(list1.get(j).getProject_num().equals(list.get(i).getProject_num())){
									resultList.add(list1.get(j));
									break;
								}
							}
						}
					}
					
				}
			}
			else{
				resultList = list;
			}
			
			List<SearchList> searchList = new ArrayList<SearchList>();
			for(HouseProject item : resultList){
				int id=item.getId();
				String project_img = null;
				String proNum = item.getProject_num();
				List<ProjectDescImage> imageList = projectInputDao.getProjectImageByProNum(proNum);
				if(imageList!=null && imageList.size()>0){
					project_img = imageList.get(0).getName();
				}
				else{
					project_img = "";
				}
				
				String gps = null;
				//gps = item.getGps();
		    	String project_name=item.getProject_name();
		    	String project_name_short = item.getProject_name_short();
		    	
		    	int project_sales_remain=item.getProject_sales_remain();
		    	String maxPrice=item.getProject_high_price();
		    	String minprice=item.getProject_min_price();
		    	
		    	int maxarea=item.getMax_area();
		    	int minarea=item.getMin_area();
		    	String return_money=item.getReturn_money();
		    	String project_num =item.getProject_num();
		    	String project_lan_cn=item.getProject_lan_cn();
		    	String project_lan_en=item.getProject_lan_en();
		    	String mianji=item.getMianji();
		    	String project_address=item.getProject_address();
		    	String project_address_short=item.getProject_address_short();
		    	
		    	String project_logo = item.getProject_logo();
		    	String developer_id_name = item.getDeveloper_id_name();
		    	String project_price_int_qi_str = item.getProject_price_qi();
		    	String bijiao = item.getBijiao();
		    /*	int project_price_int_qi=Integer.parseInt(project_price_int_qi_str);*/
		    	String project_desc = item.getProject_desc();
		    	gps = item.getGps();
		    	String project_area=item.getProject_area();
		    	String project_type=item.getProject_type();
		    	String project_city = item.getProject_city();
		    	String xinkaipan1=null;
			    String huaren1=null;
			    String remen1=null;
			    String xuequ1=null;
			    String baozu1=null;
			    String daxue1=null;
			    String center1=null;
			    String traffic1=null;
			    String xianfang1=null;
			    String maidi1=null;
			    
		    	ProjectKey p = searchListDao.searchProjectKey(project_num);
		    	if(p!=null){
		    		xinkaipan1 = p.getXinkaipan();
		    		huaren1 = p.getHuaren();
		    		remen1 = p.getRemen();
		    		xuequ1 = p.getXuequ();
		    		baozu1 = p.getBaozu();
		    		daxue1 = p.getDaxue();
		    		center1 = p.getCenter();
		    		traffic1 = p.getTraffic();
		    		xianfang1 = p.getXianfang();
		    		maidi1 = p.getMaidi();
		    	}

		    	List<String> project_key = new ArrayList<String>();
		    	project_key=bingMapDao.findProjectKeyByNum(project_num);
		    	
		        
		    	SearchList data=new SearchList(id,bijiao,project_name_short,project_area,project_type,gps,project_num,project_img,project_name,maxPrice,minprice,maxarea,minarea,project_sales_remain,return_money,project_lan_cn,project_lan_en,mianji,project_address,project_logo,developer_id_name,xinkaipan1,huaren1,remen1,xuequ1,baozu1,daxue1,center1,traffic1,xianfang1,maidi1,project_price_int_qi_str,project_desc,project_key,project_address_short,project_city);
		    	searchList.add(data);
			}
			seachListResult1 = searchList;    //将查询的结果复制给静态变量
			//req.setAttribute("searchList",searchList);
			return "/BingMap?index=1";
		}
	
		
		
		
	//右侧地图显示
	@RequestMapping({"/BingMap"})    //首页加载
	public String listBingMap(HttpServletRequest req,HttpServletResponse resp){


		List<SearchList> searchList = null;
		List<BingMapVo> bingMapList = new ArrayList<BingMapVo>();
		searchList = SearchController.seachListResult;
		if(searchList!=null){
			liandong = 1;
			req.setAttribute("bingMapList", searchList);
		}
		else{
			liandong = 0;
			bingMapList=bingMapService.listBingMap();   //查询数据库，得到项目信息
			BingMapVoList = bingMapList;
			req.setAttribute("bingMapList", bingMapList);
		}
		
		List<Nation> nationList=bingMapDao.findGuojia();
		List<City> cityList=bingMapDao.findChengshi();   //查询数据库，得到项目信息
		List<Quyu> areaList=bingMapDao.findQuyu();   //查询数据库，得到项目信息
		
		
		req.setAttribute("bingMapList", bingMapList);
		
		req.setAttribute("nationList", nationList);
		req.setAttribute("cityList", cityList);
		req.setAttribute("areaList", areaList);
		

		
		List<String> areaNameSet=bingMapDao.getAreaName();  //得到区域名称
		req.setAttribute("areaNameSet", areaNameSet);
		List<String> cityNameSet=bingMapDao.getCityName();  //得到城市名称
		req.setAttribute("cityNameSet", cityNameSet);
		List<String> addressNameSet=bingMapDao.getAddressName();  //得到地址名称
		req.setAttribute("addressNameSet", addressNameSet);
		return "/bingMap.jsp";
	}
	
	/*@RequestMapping({"/BingMap01"})
	public String listBingMap01(HttpServletRequest req,HttpServletResponse resp){
		List<BingMapVo> bingMapList=bingMapService.listBingMap();
		req.setAttribute("bingMapList", bingMapList);
		return "/bingMap01.jsp";
	}*/
	
	//分页
	@RequestMapping({"/BingMapPageList"})
	public void BingMapPageList(HttpServletRequest req,HttpServletResponse resp){
		String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //每页锟斤拷锟斤拷锟斤拷锟�
		int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
		
		List<BingMapVo> bingMapList=bingMapService.listBingMap();
		
		int total = bingMapList.size();
		int pageEnd = pageNum * pageSize;
		int end = pageEnd < total ? pageEnd : total;
		
		int start = (pageNum-1) * pageSize;
		int pageStart = start == pageEnd ? 0 : start;
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(pageStart <= end){
			List<BingMapVo> resultList=bingMapList.subList(start, end);
			for(BingMapVo item : resultList){
				JSONObject obj = new JSONObject();
				obj.put("project_id", item.getProject_id());
				obj.put("project_address", item.getProject_address());
				obj.put("project_name", item.getProject_name());
				obj.put("project_min_price", item.getProject_min_price());
				obj.put("project_high_price", item.getProject_high_price());
				obj.put("minArea", item.getMinArea());
				obj.put("maxArea", item.getMaxArea());
				obj.put("keshou", item.getKeshou());
				obj.put("average_price", item.getAverage_price());
				obj.put("house_type", item.getHouse_type());
				obj.put("project_img", item.getProject_img());
				obj.put("return_money",item.getReturn_money());
				obj.put("project_price_int_qi",item.getProject_price_int_qi());
				array.add(obj);
			}
			json.put("List", array);
			json.put("total", total);
		}
		else{
			json.put("List", "");
			json.put("total", total);
		}
		
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//根据房屋类型搜索
	@RequestMapping({"/BingMap/FileterType"})
	public String filterByHouseType(HttpServletRequest req,HttpServletResponse resp){
		int type=Integer.parseInt(req.getParameter("house_type"));
		List<BingMapVo> bingMapList=bingMapService.filterByHouseType(type);
		req.setAttribute("bingMapList", bingMapList);
		return "/bingMap.jsp";
	}
	
	
	@RequestMapping({"/BingMapFilterPageList"})
	public void BingMapFilterPageList(HttpServletRequest req,HttpServletResponse resp){
		int type=Integer.parseInt(req.getParameter("house_type"));
		String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //每页锟斤拷锟斤拷锟斤拷锟�
		int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
		
		List<BingMapVo> bingMapList=bingMapService.filterByHouseType(type);
		
		int total = bingMapList.size();
		int pageEnd = pageNum * pageSize;
		int end = pageEnd < total ? pageEnd : total;
		
		int start = (pageNum-1) * pageSize;
		int pageStart = start == pageEnd ? 0 : start;
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(pageStart <= end){
			List<BingMapVo> resultList=bingMapList.subList(start, end);
			for(BingMapVo item : resultList){
				JSONObject obj = new JSONObject();
				obj.put("project_id", item.getProject_id());
				obj.put("project_address", item.getProject_address());
				obj.put("project_name", item.getProject_name());
				obj.put("project_min_price", item.getProject_min_price());
				obj.put("project_high_price", item.getProject_high_price());
				obj.put("minArea", item.getMinArea());
				obj.put("maxArea", item.getMaxArea());
				obj.put("keshou", item.getKeshou());
				obj.put("average_price", item.getAverage_price());
				obj.put("house_type", item.getHouse_type());
				obj.put("project_img", item.getProject_img());
				obj.put("return_money",item.getReturn_money());
				obj.put("project_price_int_qi",item.getProject_price_int_qi());
				obj.put("project_key",item.getProject_key());
				array.add(obj);
			}
			json.put("List", array);
			json.put("total", total);
		}
		else{
			json.put("List", "");
			json.put("total", total);
		}
		
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({"/OrderByTypeLeft"})
	public String OrderByTypeLeft(HttpServletRequest req,HttpServletResponse resp){
		String type = req.getParameter("type");
		int typeFlag = 0;
		if(type!=null && !"".equals(type)){
			typeFlag = Integer.parseInt(type);
		}
		String projecttype=null;
		switch(typeFlag){
			case 1:
				projecttype="公寓";
				break;
			case 2:
				projecttype="别墅";
				break;
			case 3:
				projecttype="联排别墅";
				break;
			default:
				projecttype="";
				break;
		}

		List<BingMapVo> bingMapList = bingMapDao.orderByTypeLeft(projecttype);
		req.setAttribute("bingMapList", bingMapList);
		return "/bingMap.jsp";
	}
	
	 //排序
	@RequestMapping({"/OrderByPrice"})           
	public String OrderByPrice(HttpServletRequest req,HttpServletResponse resp){
		orderFlag = 1;
		int order=Integer.parseInt(req.getParameter("order"));
		List<BingMapVo> bingMapList = new ArrayList<BingMapVo>();
		if(flagInfo==2){
			if(seachListResultShengxu==null || seachListResultShengxu.size()<=0){
				req.setAttribute("bingMapList", null);
			}
			else{
				if(order==1){    //升序
					for(HouseProject item : seachListResultShengxu){
						DecimalFormat df = new DecimalFormat("#,###,###");
						int id = item.getId();
						String project_num = item.getProject_num();
						String project_img = item.getProject_img();
						/*if(project_img==null || "".equals(project_img)){
							List<ProjectDescImage> imageList = houseProjectDao.HouseProjectImageList(project_num);
							if(imageList!=null && imageList.size()>0){
								project_img = imageList.get(0).getName();
							}
							else{
								project_img = "";
							}
						}*/
						
						String project_address_short = item.getProject_address();
						
					
						if(project_address_short!=null && !"".equals(project_address_short)){
							if(project_address_short.length()>40){
								project_address_short = project_address_short.substring(0, 40);
							}
						}
						String project_address = item.getProject_address()==null?"":item.getProject_address();
						
						
						String project_name_short = item.getProject_name();
						if(project_name_short!=null && !"".equals(project_name_short)){
							if(project_name_short.length()>20){
								project_name_short = project_name_short.substring(0, 20);
							}
						}
						String project_name = item.getProject_name()==null?"":item.getProject_name();
				
						int project_sales_remain = item.getProject_sales_remain();
						int maxarea = item.getMax_area();
						int minarea = item.getMin_area();
						String project_price = item.getProject_price();
						String project_price_int_qi = item.getProject_price_int_qi_str();
						String house_type = item.getProject_house_type();
						String tempPrice = item.getProject_min_price();
						String project_min_price = item.getProject_min_price();
						String project_high_price = item.getProject_high_price();
						String mianji = item.getMianji();
						String return_money = item.getReturn_money();
						String bijiao = item.getBijiao();
						List<String> project_key = new ArrayList<String>();
						if(project_num!=null && !"".equals(project_num)){
							project_key =bingMapDao.findProjectKeyByNum(project_num);
						}
						BingMapVo  bingMapVo=new BingMapVo(id,bijiao, project_name,project_img,project_num,project_address, project_name_short, project_price,minarea, maxarea, project_sales_remain, project_price_int_qi,house_type,project_min_price,project_high_price,mianji,return_money,project_price_int_qi,project_key,project_address_short);
						bingMapList.add(bingMapVo); 
					}
					req.setAttribute("bingMapList", bingMapList);
				}
				else{  //降序
					for(HouseProject item : seachListResultJiangxu){
						DecimalFormat df = new DecimalFormat("#,###,###");
						int id = item.getId();
						String project_img = item.getProject_img();
						String project_num = item.getProject_num();
						/*if(project_img==null || "".equals(project_img)){
							List<ProjectDescImage> imageList = houseProjectDao.HouseProjectImageList(project_num);
							if(imageList!=null && imageList.size()>0){
								project_img = imageList.get(0).getName();
							}
							else{
								project_img = "";
							}
						}*/
						
						
						String project_address_short = item.getProject_address();
						
					
						if(project_address_short!=null && !"".equals(project_address_short)){
							if(project_address_short.length()>40){
								project_address_short = project_address_short.substring(0, 40);
							}
						}
						String project_address = item.getProject_address()==null?"":item.getProject_address();
						
						
						String project_name_short = item.getProject_name();
						if(project_name_short!=null && !"".equals(project_name_short)){
							if(project_name_short.length()>20){
								project_name_short = project_name_short.substring(0, 20);
							}
						}
						String project_name = item.getProject_name()==null?"":item.getProject_name();
				
						int project_sales_remain = item.getProject_sales_remain();
						int maxarea = item.getMax_area();
						int minarea = item.getMin_area();
						String project_price = item.getProject_price();
						String project_price_int_qi = item.getProject_price_int_qi_str();
						String house_type = item.getProject_house_type();
						String tempPrice = item.getProject_min_price();
						String project_min_price = item.getProject_min_price();
						String project_high_price = item.getProject_high_price();
						String mianji = item.getMianji();
						String return_money = item.getReturn_money();
						String bijiao = item.getBijiao();
						List<String> project_key = new ArrayList<String>();
						if(project_num!=null && !"".equals(project_num)){
							project_key =bingMapDao.findProjectKeyByNum(project_num);
						}
						BingMapVo  bingMapVo=new BingMapVo(id,bijiao, project_name,project_img,project_num,project_address, project_name_short, project_price,minarea, maxarea, project_sales_remain, project_price_int_qi,house_type,project_min_price,project_high_price,mianji,return_money,project_price_int_qi,project_key,project_address_short);
						bingMapList.add(bingMapVo); 
					}
					req.setAttribute("bingMapList", bingMapList);
				}
			}
			
		}
		else if(flagInfo==1){   //选择房屋类型之后的排序
			if(typeListResultShengxu==null || typeListResultShengxu.size()<=0){
				req.setAttribute("bingMapList", null);
			}
			else{
				if(order==1){
					for(HouseProject item : typeListResultShengxu){
						DecimalFormat df = new DecimalFormat("#,###,###");
						int id = item.getId();
						String project_num = item.getProject_num();
						String project_img = item.getProject_img();
						/*if(project_img==null || "".equals(project_img)){
							List<ProjectDescImage> imageList = houseProjectDao.HouseProjectImageList(project_num);
							if(imageList!=null && imageList.size()>0){
								project_img = imageList.get(0).getName();
							}
							else{
								project_img = "";
							}
						}*/
						
						String project_address_short = item.getProject_address();
						
					
						if(project_address_short!=null && !"".equals(project_address_short)){
							if(project_address_short.length()>40){
								project_address_short = project_address_short.substring(0, 40);
							}
						}
						String project_address = item.getProject_address()==null?"":item.getProject_address();
						
						
						String project_name_short = item.getProject_name();
						if(project_name_short!=null && !"".equals(project_name_short)){
							if(project_name_short.length()>20){
								project_name_short = project_name_short.substring(0, 20);
							}
						}
						String project_name = item.getProject_name()==null?"":item.getProject_name();
				
						int project_sales_remain = item.getProject_sales_remain();
						int maxarea = item.getMax_area();
						int minarea = item.getMin_area();
						String project_price = item.getProject_price();
						String house_type = item.getProject_house_type();
						/*String project_min_price = item.getProject_min_price()==null?"N/A":df.format(Integer.parseInt(item.getProject_min_price()));
						String project_high_price = item.getProject_high_price()==null?"N/A":df.format(Integer.parseInt(item.getProject_high_price()));*/
						
						String project_min_price = item.getProject_min_price();
						String project_high_price = item.getProject_high_price();
						
						String mianji = item.getMianji();
						String return_money = item.getReturn_money();
						/*String project_price_int_qi = item.getProject_price_int_qi()==0?"N/A":df.format(item.getProject_price_int_qi());*/
						String project_price_int_qi = item.getProject_price_int_qi_str();
						List<String> project_key = new ArrayList<String>();
						if(project_num!=null && !"".equals(project_num)){
							project_key =bingMapDao.findProjectKeyByNum(project_num);
						}
						String bijiao = item.getBijiao();
						BingMapVo  bingMapVo=new BingMapVo(id,bijiao,project_name,project_img,project_num,project_address, project_name_short, project_price,minarea, maxarea, project_sales_remain, project_price_int_qi,house_type,project_min_price,project_high_price,mianji,return_money,project_price_int_qi,project_key,project_address_short);
						bingMapList.add(bingMapVo);
					}
					req.setAttribute("bingMapList", bingMapList);
				}
				else{
					for(HouseProject item : typeListResultJiangxu){
						DecimalFormat df = new DecimalFormat("#,###,###");
						int id = item.getId();
						String project_num = item.getProject_num();
						String project_img = item.getProject_img();
						/*if(project_img==null || "".equals(project_img)){
							List<ProjectDescImage> imageList = houseProjectDao.HouseProjectImageList(project_num);
							if(imageList!=null && imageList.size()>0){
								project_img = imageList.get(0).getName();
							}
							else{
								project_img = "";
							}
						}*/
						
						String project_address_short = item.getProject_address();
						
					
						if(project_address_short!=null && !"".equals(project_address_short)){
							if(project_address_short.length()>40){
								project_address_short = project_address_short.substring(0, 40);
							}
						}
						String project_address = item.getProject_address()==null?"":item.getProject_address();
						
						
						String project_name_short = item.getProject_name();
						if(project_name_short!=null && !"".equals(project_name_short)){
							if(project_name_short.length()>20){
								project_name_short = project_name_short.substring(0, 20);
							}
						}
						String project_name = item.getProject_name()==null?"":item.getProject_name();
				
						int project_sales_remain = item.getProject_sales_remain();
						int maxarea = item.getMax_area();
						int minarea = item.getMin_area();
						String project_price = item.getProject_price();
						String house_type = item.getProject_house_type();
						/*String project_min_price = item.getProject_min_price()==null?"N/A":df.format(Integer.parseInt(item.getProject_min_price()));
						String project_high_price = item.getProject_high_price()==null?"N/A":df.format(Integer.parseInt(item.getProject_high_price()));*/
						
						String project_min_price = item.getProject_min_price();
						String project_high_price = item.getProject_high_price();
						
						String mianji = item.getMianji();
						String return_money = item.getReturn_money();
						/*String project_price_int_qi = item.getProject_price_int_qi()==0?"N/A":df.format(item.getProject_price_int_qi());*/
						String project_price_int_qi = item.getProject_price_int_qi_str();
						List<String> project_key = new ArrayList<String>();
						if(project_num!=null && !"".equals(project_num)){
							project_key =bingMapDao.findProjectKeyByNum(project_num);
						}
						String bijiao = item.getBijiao();
						BingMapVo  bingMapVo=new BingMapVo(id,bijiao,project_name,project_img,project_num,project_address, project_name_short, project_price,minarea, maxarea, project_sales_remain, project_price_int_qi,house_type,project_min_price,project_high_price,mianji,return_money,project_price_int_qi,project_key,project_address_short);
						bingMapList.add(bingMapVo);
					}
					req.setAttribute("bingMapList", bingMapList);
				}
			}
			
		}
		else{
			bingMapList=bingMapService.orderByPrice(order);
			req.setAttribute("bingMapList", bingMapList);
		}
		
		List<Nation> nationList=bingMapDao.findGuojia();
		List<City> cityList=bingMapDao.findChengshi();   //查询数据库，得到项目信息
		List<Quyu> areaList=bingMapDao.findQuyu();   //查询数据库，得到项目信息
		
		
		
		
		req.setAttribute("nationList", nationList);
		req.setAttribute("cityList", cityList);
		req.setAttribute("areaList", areaList);
		
		List<String> areaNameSet=bingMapDao.getAreaName();
		req.setAttribute("areaNameSet", areaNameSet);
		List<String> cityNameSet=bingMapDao.getCityName();
		req.setAttribute("cityNameSet", cityNameSet);
		List<String> addressNameSet=bingMapDao.getAddressName();
		req.setAttribute("addressNameSet", addressNameSet);
		return "/bingMap.jsp";
	}
	
	
	@RequestMapping({"/BingMapOrderPageList"})
	public void BingMapOrderPageList(HttpServletRequest req,HttpServletResponse resp){
		int order=Integer.parseInt(req.getParameter("order"));
		String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //每页锟斤拷锟斤拷锟斤拷锟�
		int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
		
		List<BingMapVo> bingMapList=bingMapService.orderByPrice(order);
		
		int total = bingMapList.size();
		int pageEnd = pageNum * pageSize;
		int end = pageEnd < total ? pageEnd : total;
		
		int start = (pageNum-1) * pageSize;
		int pageStart = start == pageEnd ? 0 : start;
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(pageStart <= end){
			List<BingMapVo> resultList=bingMapList.subList(start, end);
			for(BingMapVo item : resultList){
				JSONObject obj = new JSONObject();
				obj.put("project_id", item.getProject_id());
				obj.put("project_address", item.getProject_address());
				obj.put("project_name", item.getProject_name());
				obj.put("project_min_price", item.getProject_min_price());
				obj.put("project_high_price", item.getProject_high_price());
				obj.put("minArea", item.getMinArea());
				obj.put("maxArea", item.getMaxArea());
				obj.put("keshou", item.getKeshou());
				obj.put("average_price", item.getAverage_price());
				obj.put("house_type", item.getHouse_type());
				obj.put("project_img", item.getProject_img());
				obj.put("return_money",item.getReturn_money());
				obj.put("project_price_int_qi",item.getProject_price_int_qi());
				obj.put("project_key",item.getProject_key());
				array.add(obj);
			}
			json.put("List", array);
			json.put("total", total);
		}
		else{
			json.put("List", "");
			json.put("total", total);
		}
		
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * 首页地图加载时候，返回项目列表
	 */
	@RequestMapping({ "/BingMap/Coordinates" })    
	public void listMap(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONArray arrayCity1 = new JSONArray();
		JSONArray arrayCity2 = new JSONArray();
		JSONArray arrayNation1 = new JSONArray();
		JSONArray arrayNation2 = new JSONArray();
		JSONArray arrayZhou1 = new JSONArray();
		JSONArray arrayZhou2 = new JSONArray();
		JSONArray arrayArea1 = new JSONArray();
		JSONArray arrayArea2 = new JSONArray();
		JSONArray arrayCenter = new JSONArray();
		JSONArray arrayCentermoren = new JSONArray();
		List<String> city=new ArrayList<String>();
		List<String> nation=new ArrayList<String>();
		List<String> zhou=new ArrayList<String>();
		List<String> area=new ArrayList<String>();
		
		List<HouseProject> list = bingMapDao.listMap();
		listResult = list;
		array = jsonCoordinates();
		//array = bingMapService.jsonCoordinates();
		
		
		arrayCenter=bingMapService.jsonMapCenter();
		int lenCenter=arrayCenter.size();
		for(int k=0;k<lenCenter;k++){
			JSONObject objCenter=(JSONObject)arrayCenter.get(k);
			String type=objCenter.getString("type");
			if("默认".equals(type)){
				arrayCentermoren.add(objCenter);
			}
		}
		int len=array.size();
		for(int i=0;i<len;i++){
			JSONObject obj=(JSONObject)array.get(i);
			String project_city=obj.getString("project_city");
			String project_nation=obj.getString("project_nation");
			String project_zhou=obj.getString("project_zhou");
			String project_area=obj.getString("project_area");
			city.add(project_city);
			nation.add(project_nation);
			zhou.add(project_zhou);
			area.add(project_area);
		}
		//城市
		Set<String> uniqueSetCity = new HashSet<String>(city);
		for (String temp : uniqueSetCity) {
			String strCity=temp;
			int sizeCity=Collections.frequency(city, temp);
			JSONObject objCity1 = new JSONObject();
			objCity1.put("city", sizeCity);
			arrayCity1.add(objCity1);
			for(int j=0;j<len;j++){
				JSONObject objCity2=(JSONObject)array.get(j);
				String project_city2=objCity2.getString("project_city");
				if(project_city2.equals(strCity)){
					arrayCity2.add(objCity2);
					break;
				}
			}
        }
		//国家
		Set<String> uniqueSetNation = new HashSet<String>(nation);
		for (String temp : uniqueSetNation) {
			String strNation=temp;
			int sizeNation=Collections.frequency(nation, temp);
			JSONObject objNation1 = new JSONObject();
			objNation1.put("nation", sizeNation);
			arrayNation1.add(objNation1);
			for(int j=0;j<len;j++){
				JSONObject objNation2=(JSONObject)array.get(j);
				String project_nation2=objNation2.getString("project_nation");
				if(project_nation2.equals(strNation)){
					arrayNation2.add(objNation2);
					break;
				}
			}
        }
		//州
		Set<String> uniqueSetZhou = new HashSet<String>(zhou);
		for (String temp : uniqueSetZhou) {
			String strZhou=temp;
			int sizeZhou=Collections.frequency(zhou, temp);
			JSONObject objZhou1 = new JSONObject();
			objZhou1.put("zhou", sizeZhou);
			arrayZhou1.add(objZhou1);
			for(int j=0;j<len;j++){
				JSONObject objZhou2=(JSONObject)array.get(j);
				String project_zhou2=objZhou2.getString("project_zhou");
				if(project_zhou2.equals(strZhou)){
					arrayZhou2.add(objZhou2);
					break;
				}
			}
        }
		//区域
		Set<String> uniqueSetArea = new HashSet<String>(area);
		for (String temp : uniqueSetArea) {
			String strArea=temp;
			int sizeArea=Collections.frequency(area, temp);
			JSONObject objArea1 = new JSONObject();
			objArea1.put("area", sizeArea);
			arrayArea1.add(objArea1);
			for(int j=0;j<len;j++){
				JSONObject objArea2=(JSONObject)array.get(j);
				String project_area2=objArea2.getString("project_area");
				if(project_area2.equals(strArea)){
					arrayArea2.add(objArea2);
					break;
				}
			}
        }
		System.out.println("nation1:"+arrayNation1.size()+"---"+arrayNation1);
		System.out.println("nation2:"+arrayNation2.size()+"---"+arrayNation2);
		System.out.println("zhou1:"+arrayZhou1.size()+"---"+arrayZhou1);
		System.out.println("zhou2:"+arrayZhou2.size()+"---"+arrayZhou2);
		System.out.println("city1:"+arrayCity1.size()+"---"+arrayCity1);
		System.out.println("city2:"+arrayCity2.size()+"---"+arrayCity2);
		System.out.println("area1:"+arrayArea1.size()+"---"+arrayArea1);
		System.out.println("area2:"+arrayArea2.size()+"---"+arrayArea2);
		json.put("List", array);
		json.put("ListCity1", arrayCity1);
		json.put("ListCity2", JSONArray.parseArray(JSON.toJSONString(arrayCity2, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListNation1", arrayNation1);
		json.put("ListNation2", JSONArray.parseArray(JSON.toJSONString(arrayNation2, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListZhou1", arrayZhou1);
		json.put("ListZhou2", JSONArray.parseArray(JSON.toJSONString(arrayZhou2, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListArea1", arrayArea1);
		json.put("ListArea2", JSONArray.parseArray(JSON.toJSONString(arrayArea2, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListCentermoren", arrayCentermoren);
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * 根据类型查找结果列表
	 */
	@RequestMapping({ "/BingMap/FileterType2" })    
	public void filterByHouseType2(HttpServletRequest req, HttpServletResponse resp){    //公寓
		flagInfo = 1;          //根据类型进行查询
		liandong = 2;
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONArray array2 = new JSONArray();
		JSONArray array3 = new JSONArray();
		JSONArray arrayCenter = new JSONArray();
		JSONArray arrayCentermoren = new JSONArray();
		List<String> city=new ArrayList<String>();
		int type=Integer.parseInt(req.getParameter("house_type"));
		List<HouseProject> list = bingMapDao.filterByHouseType2(type,0);  //根据类型查找项目列表
		typeListResult = list;    //根据类型查询结果集合
		typeListResultShengxu = bingMapDao.filterByHouseType2(type,1);   //升序
		typeListResultJiangxu = bingMapDao.filterByHouseType2(type,2);   //降序
		
		array = bingMapService.filterByHouseType2(type,0);
		
		arrayCenter=bingMapService.jsonMapCenter();
		int lenCenter=arrayCenter.size();
		for(int k=0;k<lenCenter;k++){
			JSONObject objCenter=(JSONObject)arrayCenter.get(k);
			String typeCenter=objCenter.getString("type");
			if("默认".equals(typeCenter)){
				arrayCentermoren.add(objCenter);
			}
		}
		int len=array.size();
		for(int i=0;i<len;i++){
			JSONObject obj=(JSONObject)array.get(i);
			String project_city=obj.getString("project_city");
			city.add(project_city);
		}
		Set<String> uniqueSet = new HashSet<String>(city);
		for (String temp : uniqueSet) {
			String str1=temp;
			int size=Collections.frequency(city, temp);
			JSONObject obj2 = new JSONObject();
			obj2.put("city", size);
			array2.add(obj2);
			for(int j=0;j<len;j++){
				JSONObject obj3=(JSONObject)array.get(j);
				String project_city2=obj3.getString("project_city");
				if(project_city2.equals(str1)){
					array3.add(obj3);
					break;
				}
			}
        }
		/*System.out.println(array2);
		System.out.println(array3);
		System.out.println(array2.size());
		System.out.println(array3.size());*/
		json.put("List", array);
		json.put("List2", array2);
		json.put("List3", JSONArray.parseArray(JSON.toJSONString(array3, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListCentermoren", arrayCentermoren);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * 搜索得到项目列表
	 */
	@RequestMapping({ "/BingMap/FileterKeyWord" })    
	public void filterByKeyWord(HttpServletRequest req, HttpServletResponse resp){
		flagInfo = 2;
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONArray array2 = new JSONArray();
		JSONArray array3 = new JSONArray();
		JSONArray arrayCenter = new JSONArray();
		JSONArray arrayCenterarea = new JSONArray();
		JSONArray arrayCentercity = new JSONArray();
		JSONArray arrayCentermoren = new JSONArray();
		List<String> city=new ArrayList<String>();
		String area=req.getParameter("area");
		String city1=req.getParameter("city");
		String address=req.getParameter("address");
		array = bingMapService.filterByKeyWord(area, city1, address, 0);
		
		List<HouseProject> list = bingMapDao.filterByKeyWord(area, city1, address, 0);  //根据搜索结果返回项目列表,0不排序
		seachListResult = list;
		/*for(HouseProject item : seachListResult){
			if(item!=null){
				if(item.getProject_num()!=null && !"".equals(item.getProject_num())){
					String project_img = "";
					List<ProjectDescImage> imageList = projectInputDao.getProjectImageByProNum(item.getProject_num());
					if(imageList!=null && imageList.size()>0){
						project_img = imageList.get(0).getName();
					}
					else{
						project_img = "";
					}
					item.setProject_img(project_img);
				}
			}
			
		}*/
		seachListResultShengxu = bingMapDao.filterByKeyWord(area, city1, address,1);  //根据搜索结果返回项目列表,1升序
		for(HouseProject item : seachListResultShengxu){
			if(item!=null){
				if(item.getProject_num()!=null && !"".equals(item.getProject_num())){
					String project_img = "";
					List<ProjectDescImage> imageList = projectInputDao.getProjectImageByProNum(item.getProject_num());
					if(imageList!=null && imageList.size()>0){
						project_img = imageList.get(0).getName();
					}
					else{
						project_img = "";
					}
					item.setProject_img(project_img);
				}
			}
			
		}
		seachListResultJiangxu = bingMapDao.filterByKeyWord(area, city1, address,2);  //根据搜索结果返回项目列表,2降序
		for(HouseProject item : seachListResultJiangxu){
			if(item!=null){
				if(item.getProject_num()!=null && !"".equals(item.getProject_num())){
					String project_img = "";
					List<ProjectDescImage> imageList = projectInputDao.getProjectImageByProNum(item.getProject_num());
					if(imageList!=null && imageList.size()>0){
						project_img = imageList.get(0).getName();
					}
					else{
						project_img = "";
					}
					item.setProject_img(project_img);
				}
			}
			
		}
		
		arrayCenter=bingMapService.jsonMapCenter();
		int lenCenter=arrayCenter.size();
		for(int k=0;k<lenCenter;k++){
			JSONObject objCenter=(JSONObject)arrayCenter.get(k);
			String type=objCenter.getString("type");
			if("城市".equals(type)){
				arrayCentercity.add(objCenter);
			}else if("区域".equals(type)){
				arrayCenterarea.add(objCenter);
			}else if("默认".equals(type)){
				arrayCentermoren.add(objCenter);
			}
		}
		int len=array.size();
		for(int i=0;i<len;i++){
			JSONObject obj=(JSONObject)array.get(i);
			String project_city=obj.getString("project_city");
			city.add(project_city);
		}
		Set<String> uniqueSet = new HashSet<String>(city);
		for (String temp : uniqueSet) {
			String str1=temp;
			int size=Collections.frequency(city, temp);
			JSONObject obj2 = new JSONObject();
			obj2.put("city", size);
			array2.add(obj2);
			for(int j=0;j<len;j++){
				JSONObject obj3=(JSONObject)array.get(j);
				String project_city2=obj3.getString("project_city");
				if(project_city2.equals(str1)){
					array3.add(obj3);
					break;
				}
			}
        }

		json.put("List", array);
		json.put("List2", array2);
		json.put("List3", JSONArray.parseArray(JSON.toJSONString(array3, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListCentercity", arrayCentercity);
		json.put("ListCenterarea", arrayCenterarea);
		json.put("ListCentermoren", arrayCentermoren);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 根据类型查找结果列表
	 */
	@RequestMapping({ "/BingMap/Liandong" })    
	public void Liandong(HttpServletRequest req, HttpServletResponse resp){    //公寓
		flagInfo = 1;          //根据类型进行查询
		liandong = 3;
		JSONArray arrayCity = new JSONArray();
		JSONArray arrayArea = new JSONArray();
		//JSONObject json=new JSONObject();
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONArray array2 = new JSONArray();
		JSONArray array3 = new JSONArray();
		JSONArray arrayCenter = new JSONArray();
		JSONArray arrayCentermoren = new JSONArray();
		List<String> city=new ArrayList<String>();
		
		String nation = req.getParameter("nation");
		String city1 = req.getParameter("city");
		String area = req.getParameter("area");
		if(nation.equals("0")){
			nation = null;
		}
		if(city1.equals("0")){
			city1 = null;
		}
		if(area.equals("0")){
			area = null;
		}
		
		List<String> citys=searchListDao.findCityByNation(nation);
		for(String item : citys){
			JSONObject obj=new JSONObject();
			obj.put("city", item);
			arrayCity.add(obj);
		}
		json.put("cityArray", arrayCity);
		
		List<String> areas=searchListDao.findAreaByCity(city1);
		for(String item : areas){
			JSONObject obj=new JSONObject();
			obj.put("area", item);
			arrayArea.add(obj);
		}
		json.put("areaArray", arrayArea);
		
	
	
		
		List<HouseProject> list = bingMapDao.filterByLiandong(nation,city1,area);  //根据类型查找项目列表
		
			
		array = bingMapService.filterByLiandong(nation,city1,area);
		
		arrayCenter=bingMapService.jsonMapCenter();
		int lenCenter=arrayCenter.size();
		for(int k=0;k<lenCenter;k++){
			JSONObject objCenter=(JSONObject)arrayCenter.get(k);
			String typeCenter=objCenter.getString("type");
			if("默认".equals(typeCenter)){
				arrayCentermoren.add(objCenter);
			}
		}
		int len=array.size();
		for(int i=0;i<len;i++){
			JSONObject obj=(JSONObject)array.get(i);
			String project_city=obj.getString("project_city");
			city.add(project_city);
		}
		Set<String> uniqueSet = new HashSet<String>(city);
		for (String temp : uniqueSet) {
			String str1=temp;
			int size=Collections.frequency(city, temp);
			JSONObject obj2 = new JSONObject();
			obj2.put("city", size);
			array2.add(obj2);
			for(int j=0;j<len;j++){
				JSONObject obj3=(JSONObject)array.get(j);
				String project_city2=obj3.getString("project_city");
				if(project_city2.equals(str1)){
					array3.add(obj3);
					break;
				}
			}
        }
		/*System.out.println(array2);
		System.out.println(array3);
		System.out.println(array2.size());
		System.out.println(array3.size());*/
		
		json.put("List", array);
		json.put("List2", array2);
		json.put("List3", JSONArray.parseArray(JSON.toJSONString(array3, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListCentermoren", arrayCentermoren);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * 搜索得到项目列表
	 */
	@RequestMapping({ "/BingMap/FileterByProjectName" })    
	public void FileterByProjectName(HttpServletRequest req, HttpServletResponse resp){
		flagInfo = 2;
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONArray array2 = new JSONArray();
		JSONArray array3 = new JSONArray();
		JSONArray arrayCenter = new JSONArray();
		JSONArray arrayCenterarea = new JSONArray();
		JSONArray arrayCentercity = new JSONArray();
		JSONArray arrayCentermoren = new JSONArray();
		List<String> city=new ArrayList<String>();
		String project_name=req.getParameter("project_name");
		/*String city1=req.getParameter("city");
		String address=req.getParameter("address");*/
		array = bingMapService.filterByProjectName(project_name);
		
		/*List<HouseProject> list = bingMapDao.filterByKeyWord(area, city1, address, 0);  //根据搜索结果返回项目列表,0不排序
		seachListResult = list;*/
		/*for(HouseProject item : seachListResult){
			if(item!=null){
				if(item.getProject_num()!=null && !"".equals(item.getProject_num())){
					String project_img = "";
					List<ProjectDescImage> imageList = projectInputDao.getProjectImageByProNum(item.getProject_num());
					if(imageList!=null && imageList.size()>0){
						project_img = imageList.get(0).getName();
					}
					else{
						project_img = "";
					}
					item.setProject_img(project_img);
				}
			}
			
		}*/
		/*seachListResultShengxu = bingMapDao.filterByKeyWord(area, city1, address,1);  //根据搜索结果返回项目列表,1升序
		for(HouseProject item : seachListResultShengxu){
			if(item!=null){
				if(item.getProject_num()!=null && !"".equals(item.getProject_num())){
					String project_img = "";
					List<ProjectDescImage> imageList = projectInputDao.getProjectImageByProNum(item.getProject_num());
					if(imageList!=null && imageList.size()>0){
						project_img = imageList.get(0).getName();
					}
					else{
						project_img = "";
					}
					item.setProject_img(project_img);
				}
			}
			
		}
		seachListResultJiangxu = bingMapDao.filterByKeyWord(area, city1, address,2);  //根据搜索结果返回项目列表,2降序
		for(HouseProject item : seachListResultJiangxu){
			if(item!=null){
				if(item.getProject_num()!=null && !"".equals(item.getProject_num())){
					String project_img = "";
					List<ProjectDescImage> imageList = projectInputDao.getProjectImageByProNum(item.getProject_num());
					if(imageList!=null && imageList.size()>0){
						project_img = imageList.get(0).getName();
					}
					else{
						project_img = "";
					}
					item.setProject_img(project_img);
				}
			}
			
		}*/
		
		arrayCenter=bingMapService.jsonMapCenter();
		int lenCenter=arrayCenter.size();
		for(int k=0;k<lenCenter;k++){
			JSONObject objCenter=(JSONObject)arrayCenter.get(k);
			String type=objCenter.getString("type");
			if("城市".equals(type)){
				arrayCentercity.add(objCenter);
			}else if("区域".equals(type)){
				arrayCenterarea.add(objCenter);
			}else if("默认".equals(type)){
				arrayCentermoren.add(objCenter);
			}
		}
		int len=array.size();
		for(int i=0;i<len;i++){
			JSONObject obj=(JSONObject)array.get(i);
			String project_city=obj.getString("project_city");
			city.add(project_city);
		}
		Set<String> uniqueSet = new HashSet<String>(city);
		for (String temp : uniqueSet) {
			String str1=temp;
			int size=Collections.frequency(city, temp);
			JSONObject obj2 = new JSONObject();
			obj2.put("city", size);
			array2.add(obj2);
			for(int j=0;j<len;j++){
				JSONObject obj3=(JSONObject)array.get(j);
				String project_city2=obj3.getString("project_city");
				if(project_city2.equals(str1)){
					array3.add(obj3);
					break;
				}
			}
        }

		json.put("List", array);
		json.put("List2", array2);
		json.put("List3", JSONArray.parseArray(JSON.toJSONString(array3, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListCentercity", arrayCentercity);
		json.put("ListCenterarea", arrayCenterarea);
		json.put("ListCentermoren", arrayCentermoren);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
    //根据项目编号进行搜索
	@RequestMapping({ "/BingMap/FileterProNum" })    
	public void filterByProNum(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		String pro=req.getParameter("proNum");
		array = bingMapService.filterByproNum(pro);
		json.put("List", array);		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//地图中心点录入
	@RequestMapping({ "/AddMapCenter" })
	public void InsertMapCenter(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		String name=req.getParameter("name");
		String gps=req.getParameter("gps");
		String  type=req.getParameter("type");
		boolean flag=bingMapDao.InsertMapCenter(name, gps, type);
		    if(flag==false){
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
	//地图中心点列表
	@RequestMapping({ "/MapCenterList" })    
	public void selectMapCenterList(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = bingMapDao.selectMapCenterList();
		int count = array.size();
		json.put("total", count);
		json.put("rows", array);
		
		try{
			writeJson(array.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//地图中心点删除
	@RequestMapping({ "/deleteMapCenter" })
	public void DeleteMapCenter(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		int id=Integer.parseInt(req.getParameter("id"));
		boolean flag=bingMapDao.deleteMapCenter(id);
	    if(flag==false){
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
	
	//加载
	public JSONArray jsonCoordinates(){    
		JSONArray array = new JSONArray();
		DecimalFormat df = new DecimalFormat("#,###,###");
		if(orderFlag == 0){
			List<HouseProject> searchList = listResult;
			for(HouseProject data : searchList){
				JSONObject obj = new JSONObject();
				obj.put("id", data.getId());
				obj.put("gps", data.getGps()==null?"":data.getGps());
				obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
				obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
				obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
				obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
				obj.put("project_min_price", data.getProject_min_price()==null?"":df.format(Long.parseLong(data.getProject_min_price())));
				obj.put("project_high_price", data.getProject_high_price()==null?"":data.getProject_high_price());
				obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
				obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
				obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
				obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
				obj.put("project_price_int_qi", data.getProject_price_int_qi()==0?"N/A":df.format(data.getProject_price_int_qi()));
				obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
				array.add(obj);
			}
		}else if(orderFlag!=0 && flagInfo==1){
			List<HouseProject> typeList = typeListResult;
			for(HouseProject data : typeList){
				JSONObject obj = new JSONObject();
				obj.put("id", data.getId());
				obj.put("gps", data.getGps()==null?"":data.getGps());
				obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
				obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
				obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
				obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
				obj.put("project_min_price", data.getProject_min_price()==null?"":data.getMinPrice());
				obj.put("project_high_price", data.getProject_high_price()==null?"":data.getMaxPrice());
				obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
				obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
				obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
				obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
				obj.put("project_price_int_qi", data.getProject_price_int_qi_str());
				obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
				array.add(obj);
			}
			
		}else if(orderFlag!=0 && flagInfo==2){
			List<HouseProject> filterList = seachListResult;
			for(HouseProject data : filterList){
				JSONObject obj = new JSONObject();
				obj.put("id", data.getId());
				obj.put("gps", data.getGps()==null?"":data.getGps());
				obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
				obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
				obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
				obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
				obj.put("project_min_price", data.getMinPrice()==null?"":data.getMinPrice());
				obj.put("project_high_price", data.getMaxPrice()==null?"":data.getMaxPrice());
				obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
				obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
				obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
				obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
				obj.put("project_price_int_qi", data.getProject_price_int_qi_str());
				obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
				array.add(obj);
			}
		}
		else{
			List<HouseProject> searchList = listResult;
			for(HouseProject data : searchList){
				JSONObject obj = new JSONObject();
				obj.put("id", data.getId());
				obj.put("gps", data.getGps()==null?"":data.getGps());
				obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
				obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
				obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
				obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
				obj.put("project_min_price", data.getMinPrice()==null?"":data.getMinPrice());
				obj.put("project_high_price", data.getMaxPrice()==null?"":data.getMaxPrice());
				obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
				obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
				obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
				obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
				obj.put("project_price_int_qi", data.getProject_price_int_qi()==0?"N/A":df.format(data.getProject_price_int_qi()));
				obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
				array.add(obj);
			}
		}
		
		
		
		return array;
	}
	
	
	@RequestMapping({ "/BingMap1/filterByGPS1" })    
	public void filterByGPS(HttpServletRequest req, HttpServletResponse resp){    //公寓
		String gpsLeftX = req.getParameter("gpsLeftX");
		String gpsLeftY = req.getParameter("gpsLeftY");
		String gpsRightX = req.getParameter("gpsRightX");
		String gpsRightY = req.getParameter("gpsRightY");
		
		Double leftX0 = Double.parseDouble(gpsLeftX);
		Double leftY0 = Double.parseDouble(gpsLeftY);
		Double rightX0 = Double.parseDouble(gpsRightX);
		Double rightY0 = Double.parseDouble(gpsRightY);
		Double trueX = 0.00;
		Double trueY = 0.00;
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONArray array2 = new JSONArray();
		JSONArray array3 = new JSONArray();
		JSONArray arrayCenter = new JSONArray();
		JSONArray arrayCentermoren = new JSONArray();
		List<String> city=new ArrayList<String>();
		List<SearchList> resultList =  new ArrayList<SearchList>();
		
		List<HouseProject> list = bingMapService.filterByGPS(gpsLeftX,gpsLeftY,gpsRightX,gpsRightY);
		List<HouseProject> resultTypeList = new ArrayList<HouseProject>();
		List<HouseProject> resultLianDongList = new ArrayList<HouseProject>();
		
		
		if(liandong == 0){
			array = bingMapService.filterByGPSJson(gpsLeftX,gpsLeftY,gpsRightX,gpsRightY);
		}
		else if(liandong == 1){
			
			for(SearchList item : seachListResult1){
				String gps = item.getGps();
				String x = "";
				String y = "";
				String[] strs = null;
				if(gps!=null && !"".equals(gps)){
					strs = gps.split(",");
				}
				x = strs[0];
				y = strs[1];
				if(x!=null && !"".equals(x)){
					trueX = Double.parseDouble(x);
				}
				if(y!=null && !"".equals(y)){
					trueY = Double.parseDouble(y);
				}
				if(trueX >= leftX0 && trueX <= rightX0 && trueY>=leftY0 && trueY <=rightY0){
					resultList.add(item);
				}
			}
			
			
			DecimalFormat df = new DecimalFormat("#,###,###");

		for(SearchList data : resultList){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("gps", data.getGps()==null?"":data.getGps());
			
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
			obj.put("project_name_short", data.getProject_name_short());
			
			obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
			obj.put("project_min_price", data.getMinPrice());
			obj.put("project_high_price", data.getMaxPrice());

			obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
			obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
			obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
			
			obj.put("project_address", data.getProject_address()==null?"":data.getProject_address());

			obj.put("project_address_short", data.getProject_address_short());			

			obj.put("minArea", data.getMinArea()==0?0:data.getMinArea());
			obj.put("maxArea", data.getMaxArea()==0?0:data.getMaxArea());
			obj.put("return_money", data.getFanxian()==null?"":data.getFanxian());
			obj.put("project_price_int_qi", data.getProject_price_int_qi_str());
			obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
			obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
			obj.put("project_key", data.getProject_key()==null?"":data.getProject_key());
			array.add(obj);
			}
		}
		else if(liandong == 2){
			
			
			for(HouseProject item : typeListResult){
				String gps = item.getGps();
				String x = "";
				String y = "";
				String[] strs = null;
				if(gps!=null && !"".equals(gps)){
					strs = gps.split(",");
				}
				x = strs[0];
				y = strs[1];
				if(x!=null && !"".equals(x)){
					trueX = Double.parseDouble(x);
				}
				if(y!=null && !"".equals(y)){
					trueY = Double.parseDouble(y);
				}
				if(trueX >= leftX0 && trueX <= rightX0 && trueY>=leftY0 && trueY <=rightY0){
					resultTypeList.add(item);
				}
			}
			
			
			DecimalFormat df = new DecimalFormat("#,###,###");

		for(HouseProject data : resultTypeList){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("gps", data.getGps()==null?"":data.getGps());
			
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
			obj.put("project_name_short", data.getProject_name_short());
			
			obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
			obj.put("project_min_price", data.getMinPrice());
			obj.put("project_high_price", data.getMaxPrice());

			obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
			obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
			obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
			
			obj.put("project_address", data.getProject_address()==null?"":data.getProject_address());

			obj.put("project_address_short", data.getProject_address_short());			

			obj.put("minArea", data.getMin_area()==0?0:data.getMin_area());
			obj.put("maxArea", data.getMax_area()==0?0:data.getMax_area());
			obj.put("return_money", data.getReturn_money()==null?"":data.getReturn_money());
			obj.put("project_price_int_qi", data.getProject_price_int_qi_str());
			obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
			obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
			obj.put("project_key", data.getProject_key()==null?"":data.getProject_key());
			array.add(obj);
			}
		}
		else if(liandong ==3){
			for(HouseProject item : lianDongResult){
				String gps = item.getGps();
				String x = "";
				String y = "";
				String[] strs = null;
				if(gps!=null && !"".equals(gps)){
					strs = gps.split(",");
				}
				x = strs[0];
				y = strs[1];
				if(x!=null && !"".equals(x)){
					trueX = Double.parseDouble(x);
				}
				if(y!=null && !"".equals(y)){
					trueY = Double.parseDouble(y);
				}
				if(trueX >= leftX0 && trueX <= rightX0 && trueY>=leftY0 && trueY <=rightY0){
					resultLianDongList.add(item);
				}
			}
			
			
			DecimalFormat df = new DecimalFormat("#,###,###");

		for(HouseProject data : resultLianDongList){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("gps", data.getGps()==null?"":data.getGps());
			
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
			obj.put("project_name_short", data.getProject_name_short());
			
			obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
			obj.put("project_min_price", data.getMinPrice());
			obj.put("project_high_price", data.getMaxPrice());

			obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
			obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
			obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
			
			obj.put("project_address", data.getProject_address()==null?"":data.getProject_address());

			obj.put("project_address_short", data.getProject_address_short());			

			obj.put("minArea", data.getMin_area()==0?0:data.getMin_area());
			obj.put("maxArea", data.getMax_area()==0?0:data.getMax_area());
			obj.put("return_money", data.getReturn_money()==null?"":data.getReturn_money());
			obj.put("project_price_int_qi", data.getProject_price_int_qi_str());
			obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
			obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
			obj.put("project_key", data.getProject_key()==null?"":data.getProject_key());
			array.add(obj);
			}
		}

	
		
		
		
		//array = bingMapService.filterByGPSJson(gpsLeftX,gpsLeftY,gpsRightX,gpsRightY);
		
		arrayCenter=bingMapService.jsonMapCenter();
		int lenCenter=arrayCenter.size();
		for(int k=0;k<lenCenter;k++){
			JSONObject objCenter=(JSONObject)arrayCenter.get(k);
			String typeCenter=objCenter.getString("type");
			if("默认".equals(typeCenter)){
				arrayCentermoren.add(objCenter);
			}
		}
		int len=array.size();
		for(int i=0;i<len;i++){
			JSONObject obj=(JSONObject)array.get(i);
			String project_city=obj.getString("project_city");
			city.add(project_city);
		}
		Set<String> uniqueSet = new HashSet<String>(city);
		for (String temp : uniqueSet) {
			String str1=temp;
			int size=Collections.frequency(city, temp);
			JSONObject obj2 = new JSONObject();
			obj2.put("city", size);
			array2.add(obj2);
			for(int j=0;j<len;j++){
				JSONObject obj3=(JSONObject)array.get(j);
				String project_city2=obj3.getString("project_city");
				if(project_city2.equals(str1)){
					array3.add(obj3);
					break;
				}
			}
        }
		/*System.out.println(array2);
		System.out.println(array3);
		System.out.println(array2.size());
		System.out.println(array3.size());*/
		json.put("List", array);
		json.put("List2", array2);
		json.put("List3", JSONArray.parseArray(JSON.toJSONString(array3, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListCentermoren", arrayCentermoren);
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
