package com.kate.app.controller;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import com.kate.app.dao.BingMapDao;
import com.kate.app.model.BingMapVo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.SearchList;
import com.kate.app.service.BingMapService;
import com.mysql.jdbc.StreamingNotifiable;
@Controller
public class BingMapController {
	@Autowired
	private BingMapService bingMapService;
	@Autowired
	private BingMapDao bingMapDao;

	
	private static List<HouseProject>  seachListResult;
	
	private static List<HouseProject> typeListResult;
	
	private static int flagInfo = 0;
	
	@RequestMapping({"/MapCenterInput"})
	public String mapCenterInput(HttpServletRequest req,HttpServletResponse resp){
		List<String> list1= new ArrayList<String>();
		List<String> areaNameSet=bingMapDao.getAreaName();
		for(String i:areaNameSet){  
	        if(!list1.contains(i)){  
	        	list1.add(i);  
	        }  
	    }  
		List<String> cityNameSet=bingMapDao.getCityName();
		for(String j:cityNameSet){  
	        if(!list1.contains(j)){  
	        	list1.add(j);  
	        }  
	    }  
		req.setAttribute("areacityNameSet", list1);
		return "/GpsCenterInput.jsp";
	}
	
	@RequestMapping({"/BingMap"})    //首页加载
	public String listBingMap(HttpServletRequest req,HttpServletResponse resp){
		List<BingMapVo> bingMapList=bingMapService.listBingMap();
		
		req.setAttribute("bingMapList", bingMapList);
		List<String> areaNameSet=bingMapDao.getAreaName();
		req.setAttribute("areaNameSet", areaNameSet);
		List<String> cityNameSet=bingMapDao.getCityName();
		req.setAttribute("cityNameSet", cityNameSet);
		List<String> addressNameSet=bingMapDao.getAddressName();
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
	
	
	@RequestMapping({"/OrderByPrice"})            //排序
	public String OrderByPrice(HttpServletRequest req,HttpServletResponse resp){
		int order=Integer.parseInt(req.getParameter("order"));
		List<BingMapVo> bingMapList = new ArrayList<BingMapVo>();
		if(flagInfo==2){
			for(HouseProject item : seachListResult){
				DecimalFormat df = new DecimalFormat("#,###,###");
				int id = item.getId();
				String project_img = item.getProject_img();
				String project_num = item.getProject_num();
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
				String project_price_int_qi = item.getProject_price_qi();
				String house_type = item.getProject_house_type();
				String tempPrice = item.getProject_min_price();
				String project_min_price = item.getProject_min_price();
				String project_high_price = item.getProject_high_price();
				String mianji = item.getMianji();
				String return_money = item.getReturn_money();
				
				String project_key = "";
				if(project_num!=null && !"".equals(project_num)){
					project_key =bingMapDao.findProjectKeyByNum(project_num);
				}
				BingMapVo  bingMapVo=new BingMapVo(id,project_name,project_img,project_num,project_address, project_name_short, project_price,minarea, maxarea, project_sales_remain, project_price_int_qi,house_type,project_min_price,project_high_price,mianji,return_money,project_price_int_qi,project_key,project_address_short);
				bingMapList.add(bingMapVo);
				
			}
			
			if(order==1){
				Collections.sort(bingMapList,new Comparator<BingMapVo>(){  
		            public int compare(BingMapVo arg0, BingMapVo arg1) { 
		            	String a = String.valueOf(arg0.getProject_price_int_qi());
		            	String b = String.valueOf(arg1.getProject_price_int_qi());
		                return a.compareTo(b);  
		            }  
		        });  
				
			}
			else{
				Collections.sort(bingMapList,Collections.reverseOrder(new Comparator<BingMapVo>(){  
		            public int compare(BingMapVo arg0, BingMapVo arg1) { 
		            	String a = String.valueOf(arg0.getProject_price_int_qi());
		            	String b = String.valueOf(arg1.getProject_price_int_qi());
		                return a.compareTo(b);  
		            }  
		        }));
			}
		}
		else if(flagInfo==1){
			for(HouseProject item : typeListResult){
				DecimalFormat df = new DecimalFormat("#,###,###");
				int id = item.getId();
				String project_img = item.getProject_img();
				String project_num = item.getProject_num();
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
				String project_price_qi = item.getProject_price_qi();
				String house_type = item.getProject_house_type();
				String project_min_price = item.getProject_min_price()==null?"N/A":df.format(Integer.parseInt(item.getProject_min_price()));
				String project_high_price = item.getProject_high_price()==null?"N/A":df.format(Integer.parseInt(item.getProject_high_price()));
				String mianji = item.getMianji();
				String return_money = item.getReturn_money();
				String project_price_int_qi = item.getProject_price_int_qi()==0?"N/A":df.format(item.getProject_price_int_qi());
				
				String project_key = "";
				if(project_num!=null && !"".equals(project_num)){
					project_key =bingMapDao.findProjectKeyByNum(project_num);
				}
				BingMapVo  bingMapVo=new BingMapVo(id,project_name,project_img,project_num,project_address, project_name_short, project_price,minarea, maxarea, project_sales_remain, project_price_int_qi,house_type,project_min_price,project_high_price,mianji,return_money,project_price_int_qi,project_key,project_address_short);
				bingMapList.add(bingMapVo);
				
			}
			
			if(order==1){
				Collections.sort(bingMapList,new Comparator<BingMapVo>(){  
		            public int compare(BingMapVo arg0, BingMapVo arg1) { 
		            	String a = String.valueOf(arg0.getProject_price_int_qi());
		            	String b = String.valueOf(arg1.getProject_price_int_qi());
		                return a.compareTo(b);  
		            }  
		        });  
				
			}
			else{
				Collections.sort(bingMapList,Collections.reverseOrder(new Comparator<BingMapVo>(){  
		            public int compare(BingMapVo arg0, BingMapVo arg1) { 
		            	String a = String.valueOf(arg0.getProject_price_int_qi());
		            	String b = String.valueOf(arg1.getProject_price_int_qi());
		                return a.compareTo(b);  
		            }  
		        }));
			}
		}
		else{
			bingMapList=bingMapService.orderByPrice(order);
		}
		
		
		req.setAttribute("bingMapList", bingMapList);
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
	@RequestMapping({ "/BingMap/Coordinates" })    
	public void listMap(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONArray array2 = new JSONArray();
		JSONArray array3 = new JSONArray();
		JSONArray arrayCenter = new JSONArray();
		JSONArray arrayCentermoren = new JSONArray();
		List<String> city=new ArrayList<String>();
		array = bingMapService.jsonCoordinates();
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
		json.put("ListCentermoren", arrayCentermoren);
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({ "/BingMap/FileterType2" })    
	public void filterByHouseType2(HttpServletRequest req, HttpServletResponse resp){    //公寓
		flagInfo = 1;          //根据类型进行查询
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONArray array2 = new JSONArray();
		JSONArray array3 = new JSONArray();
		JSONArray arrayCenter = new JSONArray();
		JSONArray arrayCentermoren = new JSONArray();
		List<String> city=new ArrayList<String>();
		int type=Integer.parseInt(req.getParameter("house_type"));
		List<HouseProject> list = bingMapDao.filterByHouseType2(type);
		typeListResult = list;    //根据类型查询结果集合
		
		array = bingMapService.filterByHouseType2(type);
		
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
		array = bingMapService.filterByKeyWord(area,city1,address);
		
		List<HouseProject> list = bingMapDao.filterByKeyWord(area,city1,address);
		seachListResult = list;
		
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
	
	/*@RequestMapping({ "/BingMap/FileterKeyWord" })    
	public void filterByKeyWord(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONArray array2 = new JSONArray();
		JSONArray array3 = new JSONArray();
		List<String> city=new ArrayList<String>();
		String key=req.getParameter("keyword");
		array = bingMapService.filterByKeyWord(key);
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
		System.out.println(array2);
		System.out.println(array3);
		System.out.println(array2.size());
		System.out.println(array3.size());
		json.put("List", array);
		json.put("List2", array2);
		json.put("List3", JSONArray.parseArray(JSON.toJSONString(array3, SerializerFeature.DisableCircularReferenceDetect)));
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	
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
