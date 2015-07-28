package com.kate.app.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import com.kate.app.dao.AjaxDao;
import com.kate.app.dao.AreaInfoDao;
import com.kate.app.dao.BrokerInfoDao;
import com.kate.app.dao.ProjectInputDao;
import com.kate.app.dao.SearchListDao;
import com.kate.app.dao.UserDao;
import com.kate.app.model.AreaInfo;
import com.kate.app.model.BingMapVo;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.ProjectDescImage;
import com.kate.app.model.ProjectKey;
import com.kate.app.model.SearchList;
import com.kate.app.model.User;

@Controller
public class SearchController {
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
	@Autowired
	private ProjectInputDao projectInputDao;
	private static List<SearchList> seachListResult;
	
	private static List<BrokerInfo> seachBrokerListResult;
	
	//鏈嶅姟鍥㈤槦鎼滅储
	@RequestMapping({"/SearchService"})
	public String SearchService(HttpServletRequest req, HttpServletResponse resp){
		String username = (String)req.getSession().getAttribute("username");
		String brokerName = req.getParameter("brokerName");
		String type = req.getParameter("type");
		String suozaiarea = req.getParameter("suozaiarea");
		String fuwuarea = req.getParameter("fuwuarea");
		String lang = req.getParameter("lang");
		String area_code = null;
		if(type!=null && !"".endsWith(type) && type.equals("类型")){
			type = "";
		}
		if(lang!=null && !"".endsWith(lang) && lang.equals("语言")){
			lang = "";
		}
		if(fuwuarea!=null && !"".equals(fuwuarea)){
			area_code = areaInfoDao.getAreaNum(fuwuarea);
		}
		List<BrokerInfo> brokerInfoList = searchListDao.searchSericeList(brokerName, type, suozaiarea, area_code, lang);
		seachBrokerListResult = brokerInfoList;
		int count = brokerInfoList.size();
		List<BrokerInfo> resultList = new ArrayList<BrokerInfo>();
		/*if(count>=4){
			resultList = brokerInfoList.subList(0, 4);
		}
		else{
			resultList = brokerInfoList;
		}*/
		if(count>=10){
			resultList = brokerInfoList.subList(0, 10);
		}
		else{
			resultList = brokerInfoList;
		}
		List<User> userList=userDao.listUser(username);
		List<String> typeList=brokerInfoDao.getBrokerTypeList();
		List<String> regionList=brokerInfoDao.getBrokerRegionList();
		Set<String> languageList=brokerInfoDao.getBrokerLanguageList();
		req.setAttribute("typeList", typeList);
		req.setAttribute("regionList", regionList);
		req.setAttribute("languageList", languageList);
		req.setAttribute("resultList", resultList);
		req.setAttribute("brokerInfoList",brokerInfoList);
		req.setAttribute("userList", userList);
		req.setAttribute("count", count);
		return "/serviceTeam.jsp";
		/*JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		
			
			for(BrokerInfo item : brokerInfoList){
				JSONObject obj = new JSONObject();
				
				obj.put("id", item.getId());
				obj.put("broker_img", item.getBroker_img());
				obj.put("broker_language", item.getBroker_language());
				obj.put("broker_name", item.getBroker_name());
				obj.put("broker_region", item.getBroker_region());
				obj.put("office", item.getOffice());
				obj.put("introduction", item.getIntroduction());
				obj.put("broker_num", item.getBroker_num());
				obj.put("broker_experience", item.getBroker_experience());
				obj.put("broker_type", item.getBroker_type());
				obj.put("broker_zizhi", item.getBroker_zizhi());
				array.add(obj);
			}
			json.put("List", array);
			//json.put("total", total);
*/			/*try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}*/
	}
	
	@RequestMapping({"/brokerinfoPage"})
	public void BrokerListPage(HttpServletRequest req, HttpServletResponse resp){
		String pageIndex = req.getParameter("pageIndex");   //閿熸枻鎷峰墠椤甸敓鏂ゆ嫹
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //姣忛〉閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
		/*int pageSize  = pageSize_str==null? 4 :Integer.parseInt(pageSize_str);//榛樿姣忛〉4鏉¤褰�
*/		
		int pageSize  = pageSize_str==null? 10 :Integer.parseInt(pageSize_str);//榛樿姣忛〉4鏉¤褰�
		List<BrokerInfo> brokerList = seachBrokerListResult;
		
		int total = brokerList.size();
		int pageEnd = pageNum * pageSize;
		int end = pageEnd < total ? pageEnd : total;
		
		int start = (pageNum-1) * pageSize;
		int pageStart = start == pageEnd ? 0 : start;
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(pageStart <= end){
			List<BrokerInfo> resultList=brokerList.subList(start, end);
			for(BrokerInfo item : resultList){
				JSONObject obj = new JSONObject();
				obj.put("id", item.getId());
				obj.put("broker_img", item.getBroker_img());
				obj.put("broker_language", item.getBroker_language());
				obj.put("broker_name", item.getBroker_name());
				obj.put("broker_region", item.getBroker_region());
				obj.put("office", item.getOffice());
				obj.put("introduction", item.getIntroduction());
				obj.put("broker_num", item.getBroker_num());
				obj.put("broker_experience", item.getBroker_experience());
				obj.put("broker_type", item.getBroker_type());
				obj.put("broker_zizhi", item.getBroker_zizhi());
				array.add(obj);
			}
			json.put("List", array);
			json.put("total", pageEnd-1);
			json.put("size", total);
			
		}
		else{
			json.put("List", array);
			json.put("total", pageEnd-1);
			json.put("size", total);
		}
		
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	//棣栭〉鎼滅储
		@RequestMapping({"/IndexSearch"})
		public String IndexSearch(HttpServletRequest req, HttpServletResponse resp){
			String searchcity = req.getParameter("searchcity");
			String type = req.getParameter("type");
			String minimumprice = req.getParameter("minimumprice");
			String maximumprice = req.getParameter("maximumprice");
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
				if(searchcity.indexOf(",") >= 0){      //包含逗号的情况
					String[] strs = searchcity.split(",");
					String areaName = strs[0];
					AreaInfo areaInfo = areaInfoDao.getAreaInfo(areaName);
					if(areaInfo!=null){
						areaNum = areaInfo.getArea_num();
						list1 = searchListDao.searchIndexProject(areaNum);
					}
				}
				else{
					if(searchcity.indexOf("项目名称")>0){
						int weizhi = searchcity.indexOf("(");
						String projectName = searchcity.substring(0,weizhi-1).trim();
						
						list1 = searchListDao.searchIndexProjectByPro(projectName);
						
					}
					else{
						list1 = searchListDao.searchIndexList(searchcity);
						if(list1==null || list1.size()<=0){
							String area_num = searchListDao.searchIndexList1(searchcity);
							list1 = searchListDao.searchIndexProject(area_num);
						}
						
					}
					
				}
			}
			if(city2!=null && !"".equals(city2)){
				city = city2;
			}
			
			List<HouseProject> list = searchListDao.indexSericeList(city, type, minimumprice, maximumprice, xinkaipan, huaren, remen, xuequ, baozu, daxue, center, traffic, xianfang, maidi);
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
		    	String project_logo = item.getProject_logo();
		    	String developer_id_name = item.getDeveloper_id_name();
		    	int project_price_int_qi = item.getProject_price_int_qi();
		    	String project_desc = item.getProject_desc();
		    	gps = item.getGps();
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
		    	SearchList data=new SearchList(id,gps,project_num,project_img,project_name,maxPrice,minprice,maxarea,minarea,project_sales_remain,return_money,project_lan_cn,project_lan_en,mianji,project_address,project_logo,developer_id_name,xinkaipan1,huaren1,remen1,xuequ1,baozu1,daxue1,center1,traffic1,xianfang1,maidi1,project_price_int_qi,project_desc);
		    	searchList.add(data);
			}
			seachListResult = searchList;
			//req.setAttribute("searchList",searchList);
			return "searchList01.jsp";
		}
	
		
		
		
		@RequestMapping({"/BingMap01"})
		public String listBingMap01(HttpServletRequest req,HttpServletResponse resp){
			List<SearchList> searchList = seachListResult;
			/*List<BingMapVo> bingMapList = new ArrayList<BingMapVo>();
			for(SearchList item : searchList){
				BingMapVo temp = new BingMapVo();
				temp.setAverage_price(ite);
			}
			List<BingMapVo> bingMapList=bingMapService.listBingMap();*/
			req.setAttribute("bingMapList", searchList);
			return "/bingMap01.jsp";
		}
		
		@RequestMapping({ "/BingMap/Coordinates01" })    
		public void listMap(HttpServletRequest req, HttpServletResponse resp){
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONArray array2 = new JSONArray();
			JSONArray array3 = new JSONArray();
			List<String> zhou=new ArrayList<String>();
			array = jsonCoordinates();
			int len=array.size();
			for(int i=0;i<len;i++){
				JSONObject obj=(JSONObject)array.get(i);
				String project_zhou=obj.getString("project_zhou");
				zhou.add(project_zhou);
			}
			Set<String> uniqueSet = new HashSet<String>(zhou);
			for (String temp : uniqueSet) {
				String str1=temp;
				int size=Collections.frequency(zhou, temp);
				JSONObject obj2 = new JSONObject();
				obj2.put("zhou", size);
				array2.add(obj2);
				for(int j=0;j<len;j++){
					JSONObject obj3=(JSONObject)array.get(j);
					String project_zhou2=obj3.getString("project_zhou");
					if(project_zhou2.equals(str1)){
						array3.add(obj3);
						break;
					}
				}
	        }
			json.put("List", array);
			json.put("List2", array2);
			json.put("List3", JSONArray.parseArray(JSON.toJSONString(array3, SerializerFeature.DisableCircularReferenceDetect)));
			
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		@RequestMapping({"/OrderByPrice01"})
		public String OrderByPrice(HttpServletRequest req,HttpServletResponse resp){
			int order=Integer.parseInt(req.getParameter("order"));
			List<SearchList> searchList = seachListResult;
			if(order==1){
				Collections.sort(searchList,new Comparator<SearchList>(){  
		            public int compare(SearchList arg0, SearchList arg1) { 
		            	String a = String.valueOf(arg0.getProject_price_int_qi());
		            	String b = String.valueOf(arg1.getProject_price_int_qi());
		                return a.compareTo(b);  
		            }  
		        });  
				
			}
			else{
				Collections.sort(searchList,Collections.reverseOrder(new Comparator<SearchList>(){  
		            public int compare(SearchList arg0, SearchList arg1) { 
		            	String a = String.valueOf(arg0.getProject_price_int_qi());
		            	String b = String.valueOf(arg1.getProject_price_int_qi());
		                return a.compareTo(b);  
		            }  
		        }));
				
				
			}
			
			req.setAttribute("bingMapList", searchList);
			return "/bingMap01.jsp";
		}
		
		
		public JSONArray jsonCoordinates(){
			JSONArray array = new JSONArray();
			List<SearchList> searchList = seachListResult;
			for(SearchList data : searchList){
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
				array.add(obj);
			}
			return array;
		}
		
		
		
		@RequestMapping({"/IndexSearchPage"})
		public void SearchListPage(HttpServletRequest req, HttpServletResponse resp){
			String pageIndex = req.getParameter("pageIndex");   //閿熸枻鎷峰墠椤甸敓鏂ゆ嫹
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //姣忛〉閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
			int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
			List<SearchList> searchList = seachListResult;
			
			
			int total = searchList.size();
			int pageEnd = pageNum * pageSize;
			int end = pageEnd < total ? pageEnd : total;
			
			int start = (pageNum-1) * pageSize;
			int pageStart = start == pageEnd ? 0 : start;
			
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			if(pageStart <= end){
				List<SearchList> resultList=searchList.subList(start, end);
				for(SearchList item : resultList){
					JSONObject obj = new JSONObject();
					String proNum = item.getProject_num();
					List<ProjectDescImage> imageList = projectInputDao.getProjectImageByProNum(proNum);
					if(imageList!=null && imageList.size()>0){
						obj.put("Project_img", imageList.get(0).getName());
					}
					else{
						obj.put("Project_img", "");
					}
					obj.put("id", item.getId());
					obj.put("Fanxian", item.getFanxian());
					obj.put("Keshou", item.getKeshou());
					obj.put("MaxArea", item.getMaxArea());
					obj.put("MaxPrice", item.getMaxPrice()==null?"":item.getMaxPrice());
					obj.put("MinArea", item.getMinArea());
					obj.put("MinPrice", item.getMinPrice()==null?"":item.getMinPrice());
					
					obj.put("Project_name", item.getProject_name());
					obj.put("project_num", item.getProject_num());
					obj.put("project_address", item.getProject_address());
					obj.put("project_logo", item.getProject_logo());
					obj.put("developer_id_name", item.getDeveloper_id_name());
					obj.put("xinkaipan", item.getXinkaipan());
					obj.put("huaren", item.getHuaren());
					obj.put("remen", item.getRemen());
					obj.put("xuequ", item.getXuequ());
					obj.put("baozu", item.getBaozu());
					obj.put("daxue", item.getDaxue());
					obj.put("center", item.getCenter());
					obj.put("traffic", item.getTraffic());
					obj.put("xianfang", item.getXianfang());
					obj.put("maidi", item.getMaidi());
					obj.put("project_price_int_qi", item.getProject_price_int_qi());
					String lan = item.getProject_lan_cn();
					String lan_en = item.getProject_lan_en();
					if(null == lan || "".equals(lan)){
						lan = lan_en;
					}
					obj.put("project_lan_cn", lan);
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
