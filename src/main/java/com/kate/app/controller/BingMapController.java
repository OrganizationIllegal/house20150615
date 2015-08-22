package com.kate.app.controller;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.mail.Flags.Flag;
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
import com.kate.app.model.BingMapVo;
import com.kate.app.model.City;
import com.kate.app.model.HouseProject;
import com.kate.app.model.Nation;
import com.kate.app.model.ProjectDescImage;
import com.kate.app.model.Quyu;
import com.kate.app.model.SearchList;
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
	
	public static List<HouseProject> listResult=new ArrayList<HouseProject>();

	private static List<HouseProject> lianDongResult;
	
	
	private static int flagInfo = 0;
	private static int orderFlag = 0;
	private static int liandong = 0;
	
	private static String flagInformation = "";
	
	
	
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
	
	
	
	
		
		
		
	//右侧地图显示
	@RequestMapping({"/BingMap"})    //首页加载
	public String listBingMap(HttpServletRequest req,HttpServletResponse resp){

		List<SearchList> searchList=SearchListController.searchList_final;
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		List<BingMapVo> bingMapList2=new ArrayList<BingMapVo>();


		List<SearchList> searchListIndex = null;
		
		searchListIndex = SearchController.seachListResult;
		seachListResult1 = SearchController.seachListResult;
		flagInformation = SearchController.Information;
		/*flag1 = SearchController.flag;
		flagSearch1 = SearchListController.flagSearch;*/

		if(searchListIndex!=null && searchListIndex.size()>0 && flagInformation.equals("Index")){
			liandong = 1;
			for(SearchList s:searchListIndex){
	        	BingMapVo bingMapVo=new BingMapVo();
	        	int id=s.getId();
	        	String project_img=s.getProject_img();
	        	String project_num=s.getProject_num();
	        	String project_address=s.getProject_address();
	        	project_address=project_address.length()>40?project_address.substring(0, 40):project_address;
	        	String project_address_short=s.getProject_address_short();
	        	String project_name=s.getProject_name();
	        	project_name=project_name.length()>20?project_name.substring(0, 20):project_name;
	        	String project_price=s.getProject_price_int_qi_str();
	        	int minArea=s.getMinArea();
	        	int maxArea=s.getMaxArea();
	        	int keshou=s.getKeshou();
	        	String average_price=s.getProject_price_int_qi_str();
	        	String house_type=null;///////////
	        	String  project_min_price=s.getMinPrice();
	        	String  project_high_price=s.getMaxPrice();
	        	String mianji=s.getMianji();
	        	String return_money=s.getFanxian();
	        	String zhou = s.getProject_zhou();
	        	
	        	String project_price_int_qi=s.getProject_price_int_qi_str();
	        	/*List<String> project_key=s.getProject_key();*/
	        	List<String> project_key=bingMapDao.findProjectKeyByNum(project_num);
	        	String project_name_full=s.getProject_name();
	        	String bijiao=s.getBijiao();
	        	String gps=s.getGps();
	        	String project_lan_cn=s.getProject_lan_cn();
	        	String developer_id_name=s.getDeveloper_id_name();
	        	String xinkaipan=s.getXinkaipan();
	        	String remen=s.getRemen();
	        	String xuequ=s.getXuequ();
	        	String center=s.getCenter();
	        	String baozu=s.getBaozu();
	        	String huaren=s.getHuaren();
	        	String maidi=s.getMaidi();
	        	String daxue=s.getDaxue();
	        	String xianfang=s.getXianfang();
	        	String traffic=s.getTraffic();
	        	
	        	
	        	bingMapVo.setProject_id(id);
	        	bingMapVo.setProject_img(project_img);
	        	bingMapVo.setProject_num(project_num);
	        	bingMapVo.setProject_address(project_address);
	        	bingMapVo.setProject_address_short(project_address_short);
	        	bingMapVo.setProject_name(project_name);
	        	bingMapVo.setProject_price(project_price);
	        	bingMapVo.setMinArea(minArea);
	        	bingMapVo.setMaxArea(maxArea);
	        	bingMapVo.setKeshou(keshou);
	        	bingMapVo.setAverage_price(average_price);
	        	bingMapVo.setHouse_type(house_type);
	        	bingMapVo.setProject_min_price(project_min_price);
	        	bingMapVo.setProject_high_price(project_high_price);
	        	bingMapVo.setMianji(mianji);
	        	bingMapVo.setReturn_money(return_money);
	        	bingMapVo.setProject_price_int_qi(project_price_int_qi);
	        	bingMapVo.setProject_key(project_key);
	        	bingMapVo.setProject_name_full(project_name_full);
	        	bingMapVo.setBijiao(bijiao);
	        	bingMapVo.setGps(gps);
	        	bingMapVo.setZhou(zhou);
	        
	        	bingMapList.add(bingMapVo);
	        }
			//flag1 = 0;
			req.setAttribute("bingMapList", bingMapList);
			req.setAttribute("liandong", liandong);
		}
		else if(searchList!=null && searchList.size()>0 && flagInformation.equals("List") ){
			liandong = -1;
			for(SearchList s:searchList){
	        	BingMapVo bingMapVo=new BingMapVo();
	        	int id=s.getId();
	        	String project_img=s.getProject_img();
	        	String project_num=s.getProject_num();
	        	String project_address=s.getProject_address();
	        	project_address=project_address.length()>40?project_address.substring(0, 40):project_address;
	        	String project_address_short=s.getProject_address_short();
	        	String project_name=s.getProject_name();
	        	project_name=project_name.length()>20?project_name.substring(0, 20):project_name;
	        	String project_price=s.getProject_price_int_qi_str();
	        	int minArea=s.getMinArea();
	        	int maxArea=s.getMaxArea();
	        	int keshou=s.getKeshou();
	        	String average_price=s.getProject_price_int_qi_str();
	        	String house_type=null;///////////
	        	String  project_min_price=s.getMinPrice();
	        	String  project_high_price=s.getMaxPrice();
	        	String mianji=s.getMianji();
	        	String return_money=s.getFanxian();
	        	String project_price_int_qi_str=s.getProject_price_int_qi_str();
	        	int project_price_int_qi=s.getProject_price_int_qi();
	        	/*List<String> project_key=s.getProject_key();*/
	        	List<String> project_key=bingMapDao.findProjectKeyByNum(project_num);
	        	String project_name_full=s.getProject_name();
	        	String bijiao=s.getBijiao();
	        	String gps=s.getGps();
	        	String project_lan_cn=s.getProject_lan_cn();
	        	String developer_id_name=s.getDeveloper_id_name();
	        	String xinkaipan=s.getXinkaipan();
	        	String remen=s.getRemen();
	        	String xuequ=s.getXuequ();
	        	String center=s.getCenter();
	        	String baozu=s.getBaozu();
	        	String huaren=s.getHuaren();
	        	String maidi=s.getMaidi();
	        	String daxue=s.getDaxue();
	        	String xianfang=s.getXianfang();
	        	String traffic=s.getTraffic();
	        	
	        	
	        	bingMapVo.setProject_id(id);
	        	bingMapVo.setProject_img(project_img);
	        	bingMapVo.setProject_num(project_num);
	        	bingMapVo.setProject_address(project_address);
	        	bingMapVo.setProject_address_short(project_address);/////
	        	bingMapVo.setProject_name(project_name);
	        	bingMapVo.setProject_price(project_price);
	        	bingMapVo.setMinArea(minArea);
	        	bingMapVo.setMaxArea(maxArea);
	        	bingMapVo.setKeshou(keshou);
	        	bingMapVo.setAverage_price(average_price);
	        	bingMapVo.setHouse_type(house_type);
	        	bingMapVo.setProject_min_price(project_min_price);
	        	bingMapVo.setProject_high_price(project_high_price);
	        	bingMapVo.setMianji(mianji);
	        	bingMapVo.setReturn_money(return_money);
	            bingMapVo.setProject_price_int_qi(String.valueOf(project_price_int_qi));
	        	bingMapVo.setProject_key(project_key);
	        	bingMapVo.setProject_name_full(project_name_full);
	        	bingMapVo.setBijiao(bijiao);
	        	bingMapVo.setGps(gps);
	        /*	bingMapVo.setProject_lan_cn(project_lan_cn);
	        	bingMapVo.setDeveloper_id_name(developer_id_name);
	        	bingMapVo.setXinkaipan(xinkaipan);
	        	bingMapVo.setRemen(remen);
	        	bingMapVo.setXuequ(xuequ);
	        	bingMapVo.setCenter(center);
	        	bingMapVo.setBaozu(baozu);
	        	bingMapVo.setHuaren(huaren);
	        	bingMapVo.setMaidi(maidi);
	        	bingMapVo.setDaxue(daxue);
	        	bingMapVo.setXianfang(xianfang);
	        	bingMapVo.setTraffic(traffic);*/
	        	bingMapList2.add(bingMapVo);
	        }
			req.setAttribute("bingMapList", bingMapList2);
			req.setAttribute("liandong", "-1");
			//flagSearch1 = 0;
		}
		else{
			liandong = 0;
			bingMapList=bingMapService.listBingMap();   //查询数据库，得到项目信息
			BingMapVoList = bingMapList;
			req.setAttribute("bingMapList", bingMapList);
			req.setAttribute("liandong", "-1");
		}
		
	
        

		List<Nation> nationList=bingMapDao.findGuojia();
		List<City> cityList=bingMapDao.findChengshi();   //查询数据库，得到项目信息
		List<Quyu> areaList=bingMapDao.findQuyu();   //查询数据库，得到项目信息

		
		/*req.setAttribute("bingMapList", bingMapList);*/
		
		

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
		
		/*List<HouseProject> list = bingMapDao.listMap();*/
		List<HouseProject> houseProjectlist = new ArrayList<HouseProject>();
		List<SearchList> searchList=SearchListController.searchList_final;
		if(searchList!=null){
        for(SearchList s:searchList){
        	HouseProject houseProject=new HouseProject();
        	int id=s.getId();
        	String project_img=s.getProject_img();
        	String project_num=s.getProject_num();
        	String project_address=s.getProject_address();
        	String project_address_short=s.getProject_address_short();
        	String project_name=s.getProject_name();
        	String project_price=s.getProject_price_int_qi_str();
        	int minArea=s.getMinArea();
        	int maxArea=s.getMaxArea();
        	int keshou=s.getKeshou();
        	String average_price=s.getProject_price_int_qi_str();
        	String house_type=null;///////////
        	String  project_min_price=s.getMinPrice();
        	String  project_high_price=s.getMaxPrice();
        	String mianji=s.getMianji();
        	String return_money=s.getFanxian();
        	String project_price_int_qi_str=s.getProject_price_int_qi_str();
        	int project_price_int_qi=s.getProject_price_int_qi();
        	List<String> project_key=s.getProject_key();
        	String project_name_full=s.getProject_name();
        	String bijiao=s.getBijiao();
        	String gps=s.getGps();
        	String project_lan_cn=s.getProject_lan_cn();
        	String developer_id_name=s.getDeveloper_id_name();
        	
        	String xinkaipan=s.getXinkaipan();
        	String remen=s.getRemen();
        	String xuequ=s.getXuequ();
        	String center=s.getCenter();
        	String baozu=s.getBaozu();
        	String huaren=s.getHuaren();
        	String maidi=s.getMaidi();
        	String daxue=s.getDaxue();
        	String xianfang=s.getXianfang();
        	String traffic=s.getTraffic();
        	
        	
        	houseProject.setId(id);
        	houseProject.setProject_img(project_img);
        	houseProject.setProject_num(project_num);
        	houseProject.setProject_address(project_address);
        	houseProject.setProject_address_short(project_address);////
        	houseProject.setProject_name(project_name);
        	houseProject.setProject_price(project_price);
        	houseProject.setMinArea(minArea);
        	houseProject.setMaxArea(maxArea);
        	/*houseProject.setKeshou(keshou);*/
        	/*houseProject.setAverage_price(average_price);*/
        	/*houseProject.setHouse_type(house_type);*/
        	houseProject.setProject_min_price(project_min_price);
        	houseProject.setProject_high_price(project_high_price);
        	houseProject.setMianji(mianji);
        	houseProject.setReturn_money(return_money);
        	houseProject.setProject_price_int_qi_str(project_price_int_qi_str);
        	houseProject.setProject_price_int_qi(project_price_int_qi);
        	houseProject.setProject_key(project_key);
        	houseProject.setProject_name(project_name);;
        	houseProject.setBijiao(bijiao);
        	houseProject.setGps(gps);
        	houseProject.setProject_lan_cn(project_lan_cn);
        	houseProject.setDeveloper_id_name(developer_id_name);
        	houseProject.setXinkaipan(xinkaipan);
        	houseProject.setRemen(remen);
        	houseProject.setXuequ(xuequ);
        	houseProject.setCenter(center);
        	houseProject.setBaozu(baozu);
        	houseProject.setHuaren(huaren);
        	houseProject.setMaidi(maidi);
        	houseProject.setDaxue(daxue);
        	houseProject.setXianfang(xianfang);
        	houseProject.setTraffic(traffic);
        	
        	houseProjectlist.add(houseProject);
        }
		}
        if(houseProjectlist.size()==0){
        	List<HouseProject> list = bingMapDao.listMap();
        	listResult = list;
        }else{
        	 listResult = houseProjectlist;
        }
      
		/*listResult = list;*/
		array = jsonCoordinates();
		//array = bingMapService.jsonCoordinates();
		
		
		/*arrayCenter=bingMapService.jsonMapCenter();
		int lenCenter=arrayCenter.size();
		for(int k=0;k<lenCenter;k++){
			JSONObject objCenter=(JSONObject)arrayCenter.get(k);
			String type=objCenter.getString("type");
			if("默认".equals(type)){
				arrayCentermoren.add(objCenter);
			}
		}*/
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
		
		json.put("List", array);
		json.put("ListCity1", arrayCity1);
		json.put("ListCity2", JSONArray.parseArray(JSON.toJSONString(arrayCity2, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListNation1", arrayNation1);
		json.put("ListNation2", JSONArray.parseArray(JSON.toJSONString(arrayNation2, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListZhou1", arrayZhou1);
		json.put("ListZhou2", JSONArray.parseArray(JSON.toJSONString(arrayZhou2, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListArea1", arrayArea1);
		json.put("ListArea2", JSONArray.parseArray(JSON.toJSONString(arrayArea2, SerializerFeature.DisableCircularReferenceDetect)));
		/*json.put("ListCentermoren", arrayCentermoren);*/
		
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
		/*JSONArray array2 = new JSONArray();
		JSONArray array3 = new JSONArray();*/
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
		/*JSONArray array2 = new JSONArray();
		JSONArray array3 = new JSONArray();*/
		JSONArray arrayCity1 = new JSONArray();
		JSONArray arrayCity2 = new JSONArray();
		JSONArray arrayNation1 = new JSONArray();
		JSONArray arrayNation2 = new JSONArray();
		JSONArray arrayZhou1 = new JSONArray();
		JSONArray arrayZhou2 = new JSONArray();
		JSONArray arrayArea1 = new JSONArray();
		JSONArray arrayArea2 = new JSONArray();
		
		
		JSONArray arrayCenternation = new JSONArray();
		JSONArray arrayCentercity = new JSONArray();
		JSONArray arrayCenterarea = new JSONArray();
		List<String> city=new ArrayList<String>();
		List<String> nation=new ArrayList<String>();
		List<String> zhou=new ArrayList<String>();
		List<String> area=new ArrayList<String>();
		
		String nation1 = req.getParameter("nation");
		String city1 = req.getParameter("city");
		String area1 = req.getParameter("area");
		if(nation1.equals("0")){
			nation1 = null;
		}
		if(city1.equals("0")){
			city1 = null;
		}
		if(area1.equals("0")){
			area1 = null;
		}
		
		List<String> citys=searchListDao.findCityByNation(nation1);
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
		
	
	
		
		List<HouseProject> list = bingMapDao.filterByLiandong(nation1,city1,area1);  //根据类型查找项目列表
		
		lianDongResult = list;
		
		array = bingMapService.filterByLiandong(nation1,city1,area1);
		
		arrayCenternation=bingMapService.jsonMapCenterNation();
		arrayCentercity=bingMapService.jsonMapCenterCity();
		arrayCenterarea=bingMapService.jsonMapCenterArea();
		
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
		
		json.put("List", array);
		json.put("ListCity1", arrayCity1);
		json.put("ListCity2", JSONArray.parseArray(JSON.toJSONString(arrayCity2, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListNation1", arrayNation1);
		json.put("ListNation2", JSONArray.parseArray(JSON.toJSONString(arrayNation2, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListZhou1", arrayZhou1);
		json.put("ListZhou2", JSONArray.parseArray(JSON.toJSONString(arrayZhou2, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListArea1", arrayArea1);
		json.put("ListArea2", JSONArray.parseArray(JSON.toJSONString(arrayArea2, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListCenternation", arrayCenternation);
		json.put("ListCentercity", arrayCentercity);
		json.put("ListCenterarea", arrayCenterarea);
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
		/*JSONArray array2 = new JSONArray();
		JSONArray array3 = new JSONArray();
		JSONArray arrayCenter = new JSONArray();
		JSONArray arrayCenterarea = new JSONArray();
		JSONArray arrayCentercity = new JSONArray();
		JSONArray arrayCentermoren = new JSONArray();*/
		JSONArray arrayCity1 = new JSONArray();
		JSONArray arrayCity2 = new JSONArray();
		JSONArray arrayNation1 = new JSONArray();
		JSONArray arrayNation2 = new JSONArray();
		JSONArray arrayZhou1 = new JSONArray();
		JSONArray arrayZhou2 = new JSONArray();
		JSONArray arrayArea1 = new JSONArray();
		JSONArray arrayArea2 = new JSONArray();
		List<String> city=new ArrayList<String>();
		List<String> nation=new ArrayList<String>();
		List<String> zhou=new ArrayList<String>();
		List<String> area=new ArrayList<String>();
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
		
		/*arrayCenter=bingMapService.jsonMapCenter();
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
		}*/
		/*int len=array.size();
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
        }*/
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
		json.put("List", array);
		/*json.put("List2", array2);
		json.put("List3", JSONArray.parseArray(JSON.toJSONString(array3, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListCentercity", arrayCentercity);
		json.put("ListCenterarea", arrayCenterarea);
		json.put("ListCentermoren", arrayCentermoren);*/
		json.put("ListCity1", arrayCity1);
		json.put("ListCity2", JSONArray.parseArray(JSON.toJSONString(arrayCity2, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListNation1", arrayNation1);
		json.put("ListNation2", JSONArray.parseArray(JSON.toJSONString(arrayNation2, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListZhou1", arrayZhou1);
		json.put("ListZhou2", JSONArray.parseArray(JSON.toJSONString(arrayZhou2, SerializerFeature.DisableCircularReferenceDetect)));
		json.put("ListArea1", arrayArea1);
		json.put("ListArea2", JSONArray.parseArray(JSON.toJSONString(arrayArea2, SerializerFeature.DisableCircularReferenceDetect)));
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
				if(trueX >= rightX0 && trueX <= leftX0 && trueY>=leftY0 && trueY <=rightY0){
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
				if(trueX >= rightX0 && trueX <= leftX0 && trueY>=leftY0 && trueY <=rightY0){
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
			if(lianDongResult!=null){
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
					if(trueX >= rightX0 && trueX <= leftX0 && trueY>=leftY0 && trueY <=rightY0){
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
		}
			
			/*else if(liandong == 2){
				
				
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
					if(trueX >= rightX0 && trueX <= leftX0 && trueY>=leftY0 && trueY <=rightY0){
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
			}*/
			else if(liandong == -1){
				for(SearchList item : SearchListController.searchList_final){
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
						if(trueX >= rightX0 && trueX <= leftX0 && trueY>=leftY0 && trueY <=rightY0){
							resultList.add(item);
						}
					}
					
					
					DecimalFormat df = new DecimalFormat("#,###,###");

				for(SearchList data : resultList){
					JSONObject obj = new JSONObject();
					obj.put("id", data.getId());
					obj.put("gps", data.getGps()==null?"":data.getGps());
					
					obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
					/*obj.put("project_name_short", data.getProject_name_short());*/
					obj.put("project_name_short", data.getProject_name()==null?"":data.getProject_name());
					
					obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
					obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
					obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
					obj.put("project_min_price", data.getMinPrice());
					obj.put("project_high_price", data.getMaxPrice());

					obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
					obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
					obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
					
					obj.put("project_address", data.getProject_address()==null?"":data.getProject_address());

					/*obj.put("project_address_short", data.getProject_address_short());		*/
					obj.put("project_address_short", data.getProject_address()==null?"":data.getProject_address());		

					obj.put("minArea", data.getMinArea()==0?0:data.getMinArea());
					obj.put("maxArea", data.getMaxArea()==0?0:data.getMaxArea());
					obj.put("return_money", data.getFanxian()==null?"":data.getFanxian());
					/*obj.put("project_price_int_qi", data.getProject_price_int_qi_str());*/
					obj.put("project_price_int_qi", data.getProject_price_int_qi());
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
