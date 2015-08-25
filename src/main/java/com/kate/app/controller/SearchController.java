package com.kate.app.controller;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.kate.app.dao.ProjectInputDao;
import com.kate.app.dao.SearchListDao;
import com.kate.app.dao.UserDao;
import com.kate.app.model.AreaInfo;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.BrokerInfoQuyu;
import com.kate.app.model.BrokerServiceArea;
import com.kate.app.model.HouseProject;
import com.kate.app.model.LeiXing;
import com.kate.app.model.ProjectDescImage;
import com.kate.app.model.ProjectKey;
import com.kate.app.model.SearchList;
import com.kate.app.model.User;
import com.kate.app.service.BingMapService;

@Controller
public class SearchController {
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
	@Autowired
	private ProjectInputDao projectInputDao;
	@Autowired
	private BingMapDao bingMapDao;
	@Autowired
	private BingMapService bingMapService;
	
	
	private List<SearchList> seachListResult;
	
	private  List<BrokerInfoQuyu> seachBrokerListResult;
	private  List<HouseProject> typeListResult;
	private  List<HouseProject> typeListResultShengxu;
	private  List<HouseProject> typeListResultJiangxu;
	
	private  List<HouseProject>  seachListResult1;
	private  List<HouseProject>  seachListResult1Shengxu;
	private  List<HouseProject>  seachListResult1Jiangxu;
	
	
	private  int flagInfo = 0;
	private  int orderFlag = 0;
	private String Information = "";
	
	
	/*
	 * 服务团队控制层
	 */
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
		if(suozaiarea!=null && !"".equals(suozaiarea) && suozaiarea.equals("所在区域")){
			suozaiarea = "";
		}
		if(fuwuarea!=null && !"".equals(fuwuarea) && fuwuarea.equals("服务区域")){
			fuwuarea = "";
		}
		if(fuwuarea!=null && !"".equals(fuwuarea)){
			String[] strs = fuwuarea.split(",");
			String areaName = "";
			if(strs.length>0){
				areaName = strs[0]; 
			}
			
			area_code = areaInfoDao.getAreaNum(areaName);  //通过区域名称查找区域信息
		}
		List<String> brokerNumList = searchListDao.searchSericeList(brokerName, type, suozaiarea, area_code, lang);   //经纪人信息的搜索
		List<BrokerInfo> brokerInfoList = new ArrayList<BrokerInfo>();
		for(String item : brokerNumList){
			BrokerInfo data = brokerInfoDao.BrokerInfoListByNum(item);
			if(data!=null){
				brokerInfoList.add(data);
			}
		}
		
		int count = brokerInfoList.size();
		List<BrokerInfoQuyu> resultList = new ArrayList<BrokerInfoQuyu>();
		List<BrokerInfoQuyu> resultListQuyu = new ArrayList<BrokerInfoQuyu>();
		
		/*if(count>=10){
			resultList = brokerInfoList.subList(0, 10);
		}
		else{
			resultList = brokerInfoList;
		}*/
		
		for(BrokerInfo item : brokerInfoList){
			BrokerInfoQuyu data = new BrokerInfoQuyu();
			String broker_num = item.getBroker_num();
			if(broker_num!=null && !"".equals(broker_num)){
				if(item!=null){
					int t = item.getId();
					data.setId(t);
					data.setBroker_name(item.getBroker_name()==null?"":item.getBroker_name());
					data.setBroker_img(item.getBroker_img()==null?"":item.getBroker_img());
					data.setBroker_num(item.getBroker_num()==null?"":item.getBroker_num());
					data.setBroker_type(item.getBroker_type()==null?"":item.getBroker_type());
					data.setBroker_region(item.getBroker_region()==null?"":item.getBroker_region());
					data.setBroker_language(item.getBroker_language()==null?"":item.getBroker_language().replace("+", " "));
					List<LeiXing> list = searchListDao.searchSericeListBroker(broker_num);
					if (list!=null && list.size()>0) {
						data.setLeixingInfo(list);
						
					}
					//得到该经纪人的服务区域
					List<String> fuwuArea = searchListDao.findFuwuAreaByNum(broker_num);
					if (fuwuArea!=null && fuwuArea.size()>0) {
						data.setAreaList(fuwuArea);
					}
					resultListQuyu.add(data);
				}
				
			}
			
		}
		
	
		
		seachBrokerListResult = resultListQuyu;   //将搜索结果赋值给静态变量
		if(count>=10){
			resultList = resultListQuyu.subList(0, 10);
		}
		else{
			resultList = resultListQuyu;
		}

		for(BrokerInfo item : brokerInfoList){
			String brokerNum=item.getBroker_num();
			List<BrokerServiceArea> listBrokerServiceArea=brokerInfoDao.listBrokerServiceArea(brokerNum);
			
			List<AreaInfo> listAreaInfo=new ArrayList<AreaInfo>();
			for(BrokerServiceArea data : listBrokerServiceArea){
				String areaCode=data.getArea_code();
				listAreaInfo=brokerInfoDao.listAreaInfo(areaCode);
			}
		}

		
		List<User> userList=userDao.listUser(username);  //通过用户名，得到用户信息
		List<String> typeList=brokerInfoDao.getBrokerTypeList();   //查询经纪人擅长类型
		List<String> regionList=brokerInfoDao.getBrokerRegionList();  //查询经纪人所有的所在地区
		Set<String> languageList=brokerInfoDao.getBrokerLanguageList();   //查询经纪人的语言

	/*	req.setAttribute("resultListQuyu", resultListQuyu);*/
		req.setAttribute("resultListQuyu", resultList);
		

		List<String> serviceregionList=brokerInfoDao.getServiceRegionList();  //查询经纪人所有的服务区域
		List<String> liveregionlist=brokerInfoDao.getLiveRegionList();  //查询经纪人所有的所在区域

		
		List<String> numList = brokerInfoDao.getServiceRegionNumList();
		List<String> resultListRegion = new ArrayList<String>();
		for(String num : numList){
			AreaInfo item = brokerInfoDao.getAreaInfo(num);
			String result = "";
			if(item!=null){
				String name = item.getArea_name();
				String city = item.getArea_city();
				String zhou = item.getArea_zhou();
				String code = item.getArea_postcode();
				result = name+","+city+","+zhou+","+code;   //信息的综合显示
			}
			resultListRegion.add(result);
		}
		
		
		req.setAttribute("typeList", typeList);
		req.setAttribute("regionList", regionList);
		req.setAttribute("languageList", languageList);
		req.setAttribute("resultList", resultList);
		req.setAttribute("brokerInfoList",brokerInfoList);
		req.setAttribute("userList", userList);
		req.setAttribute("count", count);
		req.setAttribute("serviceregionlist", resultListRegion);
		req.setAttribute("liveregionlist", liveregionlist);
		req.setAttribute("ad", addao.getad4().get(0));
		req.setAttribute("adhref", addao.getad4().get(1));
		return "/serviceTeam.jsp";
		
	}
	
	/*
	 * 分页的实现
	 */
	@RequestMapping({"/brokerinfoPage"})
	public void BrokerListPage(HttpServletRequest req, HttpServletResponse resp){
		String pageIndex = req.getParameter("pageIndex");   //閿熸枻鎷峰墠椤甸敓鏂ゆ嫹
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //姣忛〉閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
		/*int pageSize  = pageSize_str==null? 4 :Integer.parseInt(pageSize_str);//榛樿姣忛〉4鏉¤褰�
*/		
		int pageSize  = pageSize_str==null? 10 :Integer.parseInt(pageSize_str);//榛樿姣忛〉4鏉¤褰�
		List<BrokerInfoQuyu> brokerList = seachBrokerListResult;   //得到经纪人的列表
		 
		int total = brokerList.size();
		int pageEnd = pageNum * pageSize;
		int end = pageEnd < total ? pageEnd : total;
		
		int start = (pageNum-1) * pageSize;
		int pageStart = start == pageEnd ? 0 : start;
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(pageStart <= end){
			List<BrokerInfoQuyu> resultList=brokerList.subList(start, end);
			for(BrokerInfoQuyu item : resultList){
				String broker_num=item.getBroker_num();
				JSONObject obj = new JSONObject();
				obj.put("broker_zizhi", item.getBroker_zizhi()==null?"":item.getBroker_zizhi());
				obj.put("leixing_list", item.getLeixingInfo()==null?"":item.getLeixingInfo());
				obj.put("id", item.getId());
				obj.put("broker_img", item.getBroker_img()==null?"":item.getBroker_img());
				obj.put("broker_language", item.getBroker_language()==null?"":item.getBroker_language());
				obj.put("broker_name", item.getBroker_name()==null?"":item.getBroker_name());
				obj.put("broker_region", item.getBroker_region()==null?"":item.getBroker_region());
				obj.put("office", item.getOffice()==null?"":item.getOffice());
				obj.put("introduction", item.getIntroduction()==null?"":item.getIntroduction());
				obj.put("broker_num", item.getBroker_num()==null?"":item.getBroker_num());
				obj.put("broker_experience", item.getBroker_experience());
				obj.put("broker_type", item.getBroker_type()==null?"":item.getBroker_type());
				
				
				List<String> fuwuArea = searchListDao.findFuwuAreaByNum(broker_num);
			/*	if (fuwuArea!=null && fuwuArea.size()>0) {*/
					obj.put("areaList", fuwuArea);
			/*	}*/
				
				
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
	
	
	
	
	
	
	 
	 
		@RequestMapping({"/IndexSearch"})
		public String IndexSearch(HttpServletRequest req, HttpServletResponse resp){
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(60 * 60);
			req.setAttribute("nation", "");
			req.setAttribute("city", "");
			req.setAttribute("area", "");
			
			flagInfo = 1;     //搜索结果页面
			NumberFormat nf = new DecimalFormat("#,###,###");
			
			String type = req.getParameter("type");
			String minimumprice = req.getParameter("minimumprice");
			String maximumprice = req.getParameter("maximumprice");
			String searchcity = req.getParameter("searchcity");//城市
			String country = req.getParameter("country");//国家
			if("澳洲".equals(country)||"".equals(country)){
				country="澳大利亚";
			}
			String city2 = req.getParameter("city2");//城市
		    if(!"".equals(country)){
		    	req.getSession().setAttribute("nation", country);
		    }
		    if( city2!=null && !"".equals(city2) ){
				req.getSession().setAttribute("city", city2);
		    }
		    if( searchcity!=null && !"".equals(searchcity) ){
		    	req.getSession().setAttribute("city", searchcity);
		    }
		    //标签
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
			if(xinkaipan!=null){
				req.getSession().setAttribute("xinkaipan1", "1");
			}else{
				req.getSession().setAttribute("xinkaipan1", "0");
			}
			if(huaren!=null){
				req.getSession().setAttribute("huaren1", "1");
			}else{
				req.getSession().setAttribute("huaren1", "0");
			}
			if(remen!=null){
				req.getSession().setAttribute("remen1", "1");
			}else{
				req.getSession().setAttribute("remen1", "0");
			}
			if(xuequ!=null){
				req.getSession().setAttribute("xuequ1", "1");
			}else{
				req.getSession().setAttribute("xuequ1", "0");
			}
			if(baozu!=null){
				req.getSession().setAttribute("baozu1", "1");
			}else{
				req.getSession().setAttribute("baozu1", "0");
			}
			if(daxue!=null){
				req.getSession().setAttribute("daxue1", "1");
			}else{
				req.getSession().setAttribute("daxue1", "0");
			}
			if(center!=null){
				req.getSession().setAttribute("center1", "1");
			}else{
				req.getSession().setAttribute("center1", "0");
			}
			if(traffic!=null){
				req.getSession().setAttribute("traffic1", "1");
			}else{
				req.getSession().setAttribute("traffic1", "0");
			}
			if(xianfang!=null){
				req.getSession().setAttribute("xianfang1", "1");
			}else{
				req.getSession().setAttribute("xianfang1", "0");
			}
			if(maidi!=null){
				req.getSession().setAttribute("maidi1", "1");
			}else{
				req.getSession().setAttribute("maidi1", "0");
			}
			
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
					else {
						//if(city2==null || city2.equals("")){
							//city = searchcity;
							list1 = searchListDao.searchIndexList(searchcity);    //通过前台传来的数据，查找项目信息
							if(list1==null || list1.size()<=0){
								//String area_num = searchListDao.searchIndexList1(searchcity);  //通过关键字段，查找区域编号
								//list1 = searchListDao.searchIndexProject(area_num);   //通过区域编号在数据库中查找项目信息
								list1 = searchListDao.searchIndexProjectNew(searchcity);   //通过区域编号在数据库中查找项目信息
							}
							
							
					//}
						
						
					}
					
				}
			}
			if(city2!=null && !"".equals(city2)){
				city = city2;
			}
			
			
			
			 //通过城市，类型等，进一步高级搜索，在数据库中查找项目信息
			 
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
					if(list1.size()==0){
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
		    	String project_zhou = item.getProject_zhou();
		    	String project_nation = item.getProject_nation();
		    	
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
		    	//int project_price_int_qi=Integer.parseInt(project_price_int_qi_str);
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
		    	
		        
		    	SearchList data=new SearchList(id,bijiao,project_zhou,project_nation,project_name_short,project_area,project_type,gps,project_num,project_img,project_name,maxPrice,minprice,maxarea,minarea,project_sales_remain,return_money,project_lan_cn,project_lan_en,mianji,project_address,project_logo,developer_id_name,xinkaipan1,huaren1,remen1,xuequ1,baozu1,daxue1,center1,traffic1,xianfang1,maidi1,project_price_int_qi_str,project_desc,project_key,project_address_short,project_city);
		    	searchList.add(data);
			}
			//SearchController.seachListResult = searchList;    //将查询的结果复制给静态变量
			//req.setAttribute("searchList",searchList);
			//Information = "Index";
			seachListResult = searchList;
			req.getSession().setAttribute("listResult", resultList);
			session.setAttribute("seachListResult", searchList);
			session.setAttribute("Information", "Index");
			
			return "/BingMap";
		}
	
		
		
		/*
		 * 首页搜索结果返回项目列表
		 */
		@RequestMapping({"/BingMap01"})
		public String listBingMap01(HttpServletRequest req,HttpServletResponse resp){
			List<SearchList> searchList = seachListResult;
			/*List<BingMapVo> bingMapList = new ArrayList<BingMapVo>();
			for(SearchList item : searchList){
				BingMapVo temp = new BingMapVo();
				temp.setAverage_price(ite);
			}
			List<BingMapVo> bingMapList=bingMapService.listBingMap();*/
			List<String> list1= new ArrayList<String>();
			List<String> list2= new ArrayList<String>();
			List<String> list3= new ArrayList<String>();
			List<String> areaNameSet=bingMapDao.getAreaName();
			for(String i:areaNameSet){  
		        if(!list1.contains(i)){  
		        	list1.add(i);  
		        }  
		    }  
			req.setAttribute("areaNameSet", list1);
			List<String> cityNameSet=bingMapDao.getCityName();
			for(String i:cityNameSet){  
		        if(!list2.contains(i)){  
		        	list2.add(i);  
		        }  
		    }  
			req.setAttribute("cityNameSet", list2);
			List<String> addressNameSet=bingMapDao.getAddressName();
			for(String i:addressNameSet){  
		        if(!list3.contains(i)){  
		        	list3.add(i);  
		        }  
		    }  
			req.setAttribute("addressNameSet", list3);
			req.setAttribute("bingMapList", searchList);
			return "/bingMap01.jsp";
		}
		
		/*
		 * 对应项目列表的地图的加载
		 */
		@RequestMapping({ "/BingMap/Coordinates01" })    
		public void listMap(HttpServletRequest req, HttpServletResponse resp){
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			/*JSONArray array2 = new JSONArray();
			JSONArray array3 = new JSONArray();
			JSONArray arrayCenter = new JSONArray();
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
			array = jsonCoordinates();
			
			
			/*arrayCenter=bingMapService.jsonMapCenter();
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
		
		
		
		
		@RequestMapping({"/OrderByPrice01"})
		public String OrderByPrice(HttpServletRequest req,HttpServletResponse resp){
			orderFlag = 1;
			int order=Integer.parseInt(req.getParameter("order"));
			
			List<SearchList> searchList = seachListResult;  //根据首页的搜索结果查找的项目列表
			
			List<HouseProject> typeList = typeListResult;   //根据房屋类型查找的项目列表
			List<HouseProject> filterList = seachListResult1;  //根据地图页面的搜索结果查找的项目列表
			
			if(flagInfo==1){
				if(order==1){  //升序
					Collections.sort(searchList,new Comparator<SearchList>(){  
			            public int compare(SearchList arg0, SearchList arg1) { 
			            	Integer a = Integer.parseInt(arg0.getBijiao());
			            	Integer b =  Integer.parseInt(arg1.getBijiao());
			                return a.compareTo(b);  
			            }  
			        });  
					req.setAttribute("bingMapList", searchList);
				}
				else{  //降序
					Collections.sort(searchList,Collections.reverseOrder(new Comparator<SearchList>(){  
			            public int compare(SearchList arg0, SearchList arg1) { 
			            	Integer a = Integer.parseInt(arg0.getBijiao());
			            	Integer b =  Integer.parseInt(arg1.getBijiao());
			                return a.compareTo(b);  
			            }  
			        }));
					req.setAttribute("bingMapList", searchList);
				}
				
			}
			
			else if(flagInfo == 2){   //点击房屋类型之后，按照类型结果排序
				if(order==1){
					req.setAttribute("bingMapList", typeListResultShengxu);
					 
					
				}
				else{
					req.setAttribute("bingMapList", typeListResultJiangxu);
				}
				
			}
			else{   //按照地图页面的搜索结果排序
				if(order==1){
					req.setAttribute("bingMapList", seachListResult1Shengxu);
					
					
				}
				else{
					req.setAttribute("bingMapList", seachListResult1Jiangxu);
				}
				
			}
		
			List<String> areaNameSet=bingMapDao.getAreaName();
			req.setAttribute("areaNameSet", areaNameSet);
			List<String> cityNameSet=bingMapDao.getCityName();
			req.setAttribute("cityNameSet", cityNameSet);
			List<String> addressNameSet=bingMapDao.getAddressName();
			req.setAttribute("addressNameSet", addressNameSet);
			
			return "/bingMap01.jsp";
		}
		
		
		public JSONArray jsonCoordinates(){    //加载
			JSONArray array = new JSONArray();
			DecimalFormat df = new DecimalFormat("#,###,###");
			if(orderFlag == 0){
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
					obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
					obj.put("project_price_int_qi", data.getProject_price_int_qi()==0?"N/A":df.format(data.getProject_price_int_qi()));
					obj.put("project_price_int_qi", data.getProject_price_int_qi_str());
					obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
					obj.put("project_nation", data.getProject_nation());
					obj.put("project_city", data.getProject_city());
					obj.put("project_area", data.getProject_area());
					obj.put("project_zhou", data.getProject_zhou());
					array.add(obj);
				}
			}else if(orderFlag!=0 && flagInfo==2){
				List<HouseProject> typeList = typeListResult;
				for(HouseProject data : typeList){
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
					obj.put("project_nation", data.getProject_nation());
					obj.put("project_city", data.getProject_city());
					obj.put("project_area", data.getProject_area());
					obj.put("project_zhou", data.getProject_zhou());
					array.add(obj);
				}
				
			}else if(orderFlag!=0 && flagInfo==3){
				List<HouseProject> filterList = seachListResult1;
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
					obj.put("project_nation", data.getProject_nation());
					obj.put("project_city", data.getProject_city());
					obj.put("project_area", data.getProject_area());
					obj.put("project_zhou", data.getProject_zhou());
					array.add(obj);
				}
			}
			else{
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
					obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
					obj.put("project_price_int_qi", data.getProject_price_int_qi_str());
					obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
					obj.put("project_nation", data.getProject_nation());
					obj.put("project_city", data.getProject_city());
					obj.put("project_area", data.getProject_area());
					obj.put("project_zhou", data.getProject_zhou());
					array.add(obj);
				}
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
		
		@RequestMapping({ "/BingMap1/FileterType2" })    
		public void filterByHouseType2(HttpServletRequest req, HttpServletResponse resp){    //公寓
			flagInfo = 2;          //根据类型进行查询
			
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONArray array2 = new JSONArray();
			JSONArray array3 = new JSONArray();
			JSONArray arrayCenter = new JSONArray();
			JSONArray arrayCentermoren = new JSONArray();
			List<String> city=new ArrayList<String>();
			int type=Integer.parseInt(req.getParameter("house_type"));
			List<HouseProject> list = bingMapDao.filterByHouseType2(type,0);
			for(HouseProject item : list){
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
			typeListResult = list;    //根据类型查询结果集合
			typeListResultShengxu = bingMapDao.filterByHouseType2(type,1);    //根据类型查询结果集合
			for(HouseProject item : typeListResultShengxu){
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
			typeListResultJiangxu = bingMapDao.filterByHouseType2(type,2);    //根据类型查询结果集合
			for(HouseProject item : typeListResultJiangxu){
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
		
		
		@RequestMapping({ "/BingMap1/filterByGPS" })    
		public void filterByGPS(HttpServletRequest req, HttpServletResponse resp){    //公寓
			String gpsLeftX = req.getParameter("gpsLeftX");
			String gpsLeftY = req.getParameter("gpsLeftY");
			String gpsRightX = req.getParameter("gpsRightX");
			String gpsRightY = req.getParameter("gpsRightY");
			
			List<HouseProject> list = bingMapService.filterByGPS(gpsLeftX,gpsLeftY,gpsRightX,gpsRightY);
			
			
			
			flagInfo = 2;          //根据类型进行查询
			
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			JSONArray array2 = new JSONArray();
			JSONArray array3 = new JSONArray();
			JSONArray arrayCenter = new JSONArray();
			JSONArray arrayCentermoren = new JSONArray();
			List<String> city=new ArrayList<String>();
			/*int type=Integer.parseInt(req.getParameter("house_type"));
			List<HouseProject> list = bingMapDao.filterByHouseType2(type,0);
			for(HouseProject item : list){
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
			typeListResult = list;    //根据类型查询结果集合
			typeListResultShengxu = bingMapDao.filterByHouseType2(type,1);    //根据类型查询结果集合
			for(HouseProject item : typeListResultShengxu){
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
			typeListResultJiangxu = bingMapDao.filterByHouseType2(type,2);    //根据类型查询结果集合
			for(HouseProject item : typeListResultJiangxu){
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
			array = bingMapService.filterByGPSJson(gpsLeftX,gpsLeftY,gpsRightX,gpsRightY);
			
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
		
		
		
		
		
		@RequestMapping({ "/BingMap1/FileterKeyWord" })    
		public void filterByKeyWord(HttpServletRequest req, HttpServletResponse resp){
			flagInfo = 3;
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
			//String key=req.getParameter("keyword");
			array = bingMapService.filterByKeyWord(area, city1, address,0);
			
			List<HouseProject> list = bingMapDao.filterByKeyWord(area, city1, address,0);
			seachListResult1 = list;
			seachListResult1Shengxu = bingMapDao.filterByKeyWord(area, city1, address,1);
			seachListResult1Jiangxu = bingMapDao.filterByKeyWord(area, city1, address,2);
			
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
			//System.out.println(array);
			//System.out.println(array3);
			//System.out.println(array2.size());
			//System.out.println(array3.size());
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
