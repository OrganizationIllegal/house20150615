package com.kate.app.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.BingMapDao;
import com.kate.app.model.BingMapCenter;
import com.kate.app.model.BingMapVo;
import com.kate.app.model.City;
import com.kate.app.model.HouseProject;
import com.kate.app.model.Nation;
import com.kate.app.model.Quyu;
@Service
public class BingMapService {
	@Autowired
	private BingMapDao bingMapDao;
	
	//加载左侧项目列表
	public List<BingMapVo> listBingMap(){    
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		bingMapList=bingMapDao.listBingMap();
		return bingMapList;
	}
	//左侧根据房屋类型搜索
	public List<BingMapVo> filterByHouseType(int type){
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		bingMapList=bingMapDao.filterByHouseType(type);
		return bingMapList;
	}
	//左侧根据价格排序
	public List<BingMapVo> orderByPrice(int order){
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		bingMapList=bingMapDao.orderByPrice(order);
		return bingMapList;
	}
//经纬度及其相关信息
	public JSONArray jsonCoordinates(){
		JSONArray array = new JSONArray();
		DecimalFormat df = new DecimalFormat("#,###,###");
		List<HouseProject> list = bingMapDao.listMap();
		
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("gps", data.getGps()==null?"":data.getGps());
			String project_name_short = data.getProject_name();
			if(project_name_short!=null && !"".equals(project_name_short)){
				if(project_name_short.length()>20){
					project_name_short = project_name_short.substring(0, 20);
				}
			}
			obj.put("project_name_short", project_name_short);
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
			obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
			obj.put("project_min_price", data.getProject_min_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_min_price())));
			obj.put("project_high_price", data.getProject_high_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_high_price())));
			obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
			obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
			obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
			obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
			obj.put("project_price_int_qi", data.getProject_price_int_qi()==0?"N/A":df.format(data.getProject_price_int_qi()));
			obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
			String project_address_short = data.getProject_address();
			if(project_address_short!=null && !"".equals(project_address_short)){
				if(project_address_short.length()>40){
					project_address_short = project_address_short.substring(0, 40);
				}
			}
			obj.put("project_address_short", project_address_short);
			obj.put("project_address", data.getProject_address()==null?"":data.getProject_address());
			obj.put("minArea", data.getMin_area()==0?0:data.getMin_area());
			obj.put("maxArea", data.getMax_area()==0?0:data.getMax_area());
			obj.put("return_money", data.getReturn_money()==null?"":data.getReturn_money());
			array.add(obj);
		}
		return array;
	}
	//查找地图中心点
	public JSONArray jsonMapCenter(){
		JSONArray array = new JSONArray();
		List<BingMapCenter> list = bingMapDao.listMapCenter();
		for(BingMapCenter data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("gps", data.getGps());
			obj.put("name", data.getName());
			obj.put("type", data.getType());
			array.add(obj);
		}
		return array;
	}
	
	//查找地图中心点--nation
		public JSONArray jsonMapCenterNation(){
			JSONArray array = new JSONArray();
			List<Nation> list = bingMapDao.listMapCenterNation();
			for(Nation data : list){
				JSONObject obj = new JSONObject();
				obj.put("id", data.getId());
				obj.put("gps", data.getCenter_gps());
				obj.put("name", data.getNation_name());
				//obj.put("type", data.getType());
				array.add(obj);
			}
			return array;
		}
	
		
		//查找地图中心点--city
				public JSONArray jsonMapCenterCity(){
					JSONArray array = new JSONArray();
					List<City> list = bingMapDao.listMapCenterCity();
					for(City data : list){
						JSONObject obj = new JSONObject();
						obj.put("id", data.getId());
						obj.put("gps", data.getCenter_gps());
						obj.put("name", data.getCity_name());
						//obj.put("type", data.getType());
						array.add(obj);
					}
					return array;
				}
				
				
				
				//查找地图中心点--area
				public JSONArray jsonMapCenterArea(){
					JSONArray array = new JSONArray();
					List<Quyu> list = bingMapDao.listMapCenterArea();
					for(Quyu data : list){
						JSONObject obj = new JSONObject();
						obj.put("id", data.getId());
						obj.put("gps", data.getCenter_gps());
						obj.put("name", data.getArea_name());
						//obj.put("type", data.getType());
						array.add(obj);
					}
					return array;
				}
	//根据房屋类型搜索及根据价格排序
	public JSONArray filterByLiandong(String nation, String city, String area){
		JSONArray array = new JSONArray();
		DecimalFormat df = new DecimalFormat("#,###,###");
		List<HouseProject> list = bingMapDao.filterByLiandong(nation, city, area);
		
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("gps", data.getGps()==null?"":data.getGps());
			/*String project_name_short = data.getProject_name();
			if(project_name_short!=null && !"".equals(project_name_short)){
				if(project_name_short.length()>20){
					project_name_short = project_name_short.substring(0, 20);
				}
			}*/
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
			obj.put("project_name_short", data.getProject_name_short());
			
			obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());

			/*obj.put("project_min_price", data.getProject_min_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_min_price())));
			obj.put("project_high_price", data.getProject_high_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_high_price())));*/
			obj.put("project_min_price", data.getProject_min_price());
			obj.put("project_high_price", data.getProject_high_price());
/*=======
			obj.put("project_min_price", data.getProject_min_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_min_price())));
			obj.put("project_high_price", data.getProject_high_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_high_price())));*/

			obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
			obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
			obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
			
			/*String project_address_short = data.getProject_address();
			if(project_address_short!=null && !"".equals(project_address_short)){
				if(project_address_short.length()>40){
					project_address_short = project_address_short.substring(0, 40);
				}
			}*/
			obj.put("project_address", data.getProject_address()==null?"":data.getProject_address());

			obj.put("project_address_short", data.getProject_address_short());			

			obj.put("minArea", data.getMin_area()==0?0:data.getMin_area());
			obj.put("maxArea", data.getMax_area()==0?0:data.getMax_area());
			obj.put("return_money", data.getReturn_money()==null?"":data.getReturn_money());
			//obj.put("project_price_int_qi", data.getProject_price_int_qi()==0?"N/A":df.format(data.getProject_price_int_qi()));
			obj.put("project_price_int_qi", data.getProject_price_int_qi_str());
			obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
			obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
			obj.put("project_key", data.getProject_key()==null?"":data.getProject_key());
			array.add(obj);
		}
		return array;
	}
	
	
	
	//根据房屋类型搜索及根据价格排序
		public JSONArray filterByHouseType2(int type,int order){
			JSONArray array = new JSONArray();
			DecimalFormat df = new DecimalFormat("#,###,###");
			List<HouseProject> list = bingMapDao.filterByHouseType2(type,order);
			
			for(HouseProject data : list){
				JSONObject obj = new JSONObject();
				obj.put("id", data.getId());
				obj.put("gps", data.getGps()==null?"":data.getGps());
				/*String project_name_short = data.getProject_name();
				if(project_name_short!=null && !"".equals(project_name_short)){
					if(project_name_short.length()>20){
						project_name_short = project_name_short.substring(0, 20);
					}
				}*/
				obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
				obj.put("project_name_short", data.getProject_name_short());
				
				obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
				obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
				obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());

				/*obj.put("project_min_price", data.getProject_min_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_min_price())));
				obj.put("project_high_price", data.getProject_high_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_high_price())));*/
				obj.put("project_min_price", data.getProject_min_price());
				obj.put("project_high_price", data.getProject_high_price());
	/*=======
				obj.put("project_min_price", data.getProject_min_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_min_price())));
				obj.put("project_high_price", data.getProject_high_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_high_price())));*/

				obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
				obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
				obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
				
				/*String project_address_short = data.getProject_address();
				if(project_address_short!=null && !"".equals(project_address_short)){
					if(project_address_short.length()>40){
						project_address_short = project_address_short.substring(0, 40);
					}
				}*/
				obj.put("project_address", data.getProject_address()==null?"":data.getProject_address());

				obj.put("project_address_short", data.getProject_address_short());			

				obj.put("minArea", data.getMin_area()==0?0:data.getMin_area());
				obj.put("maxArea", data.getMax_area()==0?0:data.getMax_area());
				obj.put("return_money", data.getReturn_money()==null?"":data.getReturn_money());
				//obj.put("project_price_int_qi", data.getProject_price_int_qi()==0?"N/A":df.format(data.getProject_price_int_qi()));
				obj.put("project_price_int_qi", data.getProject_price_int_qi_str());
				obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
				obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
				obj.put("project_key", data.getProject_key()==null?"":data.getProject_key());
				array.add(obj);
			}
			return array;
		}
		
		
		
		
	//根据城市、区域、邮编搜索以及根据价格排序
	public JSONArray filterByKeyWord(String area,String city,String addr,int order){
		JSONArray array = new JSONArray();
		DecimalFormat df = new DecimalFormat("#,###,###");
		List<HouseProject> list = bingMapDao.filterByKeyWord(area,city,addr,order);
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("gps", data.getGps()==null?"":data.getGps());
			String project_name_short = data.getProject_name();
			if(project_name_short!=null && !"".equals(project_name_short)){
				if(project_name_short.length()>20){
					project_name_short = project_name_short.substring(0, 20);
				}
			}
			obj.put("project_name_short", project_name_short);
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
			obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
			obj.put("project_min_price", data.getProject_min_price()==null?"N/A":data.getProject_min_price());
			obj.put("project_high_price", data.getProject_high_price()==null?"N/A":data.getProject_high_price());
			obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
			obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
			obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
			obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());

			obj.put("project_price_int_qi", data.getProject_price_int_qi_str());

			obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
			String project_address_short = data.getProject_address();
			if(project_address_short!=null && !"".equals(project_address_short)){
				if(project_address_short.length()>40){
					project_address_short = project_address_short.substring(0, 40);
				}
			}
			obj.put("project_address_short", project_address_short);
			obj.put("project_address", data.getProject_address()==null?"":data.getProject_address());
			
			obj.put("return_money", data.getReturn_money()==null?"":data.getReturn_money());
			obj.put("minArea", data.getMin_area()==0?0:data.getMin_area());
			obj.put("maxArea", data.getMax_area()==0?0:data.getMax_area());
			String project_num = data.getProject_num()==null?"":data.getProject_num();
			List<String> project_key = new ArrayList<String>();
			if(project_num!=null && !"".equals(project_num)){
				project_key = bingMapDao.findProjectKeyByNum(project_num);
			}
			obj.put("project_key", project_key);
			array.add(obj);
		}
		return array;
	}
	
	
	
	//根据城市、区域、邮编搜索以及根据价格排序
		public JSONArray filterByProjectName(String project_name){
			JSONArray array = new JSONArray();
			DecimalFormat df = new DecimalFormat("#,###,###");
			List<HouseProject> list = bingMapDao.filterByProjectName(project_name);
			for(HouseProject data : list){
				JSONObject obj = new JSONObject();
				obj.put("id", data.getId());
				obj.put("gps", data.getGps()==null?"":data.getGps());
				String project_name_short = data.getProject_name();
				if(project_name_short!=null && !"".equals(project_name_short)){
					if(project_name_short.length()>20){
						project_name_short = project_name_short.substring(0, 20);
					}
				}
				obj.put("project_name_short", project_name_short);
				obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
				obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
				obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
				obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
				obj.put("project_min_price", data.getProject_min_price()==null?"N/A":data.getProject_min_price());
				obj.put("project_high_price", data.getProject_high_price()==null?"N/A":data.getProject_high_price());
				obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
				obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
				obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
				obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());

				obj.put("project_price_int_qi", data.getProject_price_int_qi_str());

				obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
				String project_address_short = data.getProject_address();
				if(project_address_short!=null && !"".equals(project_address_short)){
					if(project_address_short.length()>40){
						project_address_short = project_address_short.substring(0, 40);
					}
				}
				obj.put("project_address_short", project_address_short);
				obj.put("project_address", data.getProject_address()==null?"":data.getProject_address());
				
				obj.put("return_money", data.getReturn_money()==null?"":data.getReturn_money());
				obj.put("minArea", data.getMin_area()==0?0:data.getMin_area());
				obj.put("maxArea", data.getMax_area()==0?0:data.getMax_area());
				String project_num = data.getProject_num()==null?"":data.getProject_num();
				List<String> project_key = new ArrayList<String>();
				if(project_num!=null && !"".equals(project_num)){
					project_key = bingMapDao.findProjectKeyByNum(project_num);
				}
				obj.put("project_key", project_key);
				array.add(obj);
			}
			return array;
		}
	
	
	
	/*public JSONArray filterByKeyWord(String key,int order){
		JSONArray array = new JSONArray();
		DecimalFormat df = new DecimalFormat("#,###,###");
		List<HouseProject> list = bingMapDao.filterByKeyWord(key, order);
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("gps", data.getGps()==null?"":data.getGps());
			String project_name_short = data.getProject_name();
			if(project_name_short!=null && !"".equals(project_name_short)){
				if(project_name_short.length()>20){
					project_name_short = project_name_short.substring(0, 20);
				}
			}
			obj.put("project_name_short", project_name_short);
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());			
			obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
			obj.put("project_min_price", data.getProject_min_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_min_price())));
			obj.put("project_high_price", data.getProject_high_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_high_price())));
			obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
			obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
			obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
			obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
			obj.put("project_price_int_qi", data.getProject_price_int_qi()==0?"N/A":df.format(data.getProject_price_int_qi()));
			obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
			obj.put("max_area", data.getMax_area());
			obj.put("min_area", data.getMin_area());
			obj.put("mianji", data.getMianji()==null?"":data.getMin_area());
			obj.put("return_money", data.getReturn_money()==null?"N/A":df.format(Integer.parseInt(data.getReturn_money())));
			String project_address_short = data.getProject_address();
			if(project_address_short!=null && !"".equals(project_address_short)){
				if(project_address_short.length()>40){
					project_address_short = project_address_short.substring(0, 40);
				}
			}
			obj.put("project_address_short", project_address_short);
			obj.put("project_address", data.getProject_address()==null?"":data.getProject_address());
			array.add(obj);
		}
		return array;
	}*/
	//根据项目名搜索
	public JSONArray filterByproNum(String pro){
		JSONArray array = new JSONArray();
		DecimalFormat df = new DecimalFormat("#,###,###");
		List<HouseProject> list = bingMapDao.filterByproNum(pro);
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("gps", data.getGps()==null?"":data.getGps());
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
			obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
			obj.put("project_min_price", data.getProject_min_price()==null?"":data.getProject_min_price());
			obj.put("project_high_price", data.getProject_high_price()==null?"":data.getProject_high_price());
			obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
			obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
			obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
			obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
			obj.put("project_price_int_qi", data.getProject_price_int_qi()==0?"N/A":df.format(data.getProject_price_int_qi()));
			obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
			obj.put("project_address", data.getProject_address()==null?"":data.getProject_address());
			obj.put("return_money", data.getReturn_money()==null?"":data.getReturn_money());
			obj.put("minArea", data.getMin_area()==0?0:data.getMin_area());
			obj.put("maxArea", data.getMax_area()==0?0:data.getMax_area());
			array.add(obj);
		}
		return array;
	}
	
	//根据项目名搜索
		public List<HouseProject> filterByGPS(String leftX, String leftY, String rightX, String rightY){
			Double leftX0 = Double.parseDouble(leftX);
			Double leftY0 = Double.parseDouble(leftY);
			Double rightX0 = Double.parseDouble(rightX);
			Double rightY0 = Double.parseDouble(rightY);
			Double trueX = 0.00;
			Double trueY = 0.00;
			JSONArray array = new JSONArray();
			DecimalFormat df = new DecimalFormat("#,###,###");
			List<HouseProject> resultList =  new ArrayList<HouseProject>();
			List<HouseProject> coordinatesList =  bingMapDao.filterByGPS(leftX, leftY, rightX, rightY);
			for(HouseProject item : coordinatesList){
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
			return resultList;
			
		}
		
		public JSONArray filterByGPSJson(String leftX, String leftY, String rightX, String rightY){
			List<HouseProject> resultList = filterByGPS(leftX,leftY,rightX,rightY);
			JSONArray array = new JSONArray();
			DecimalFormat df = new DecimalFormat("#,###,###");

		for(HouseProject data : resultList){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("gps", data.getGps()==null?"":data.getGps());
			/*String project_name_short = data.getProject_name();
			if(project_name_short!=null && !"".equals(project_name_short)){
				if(project_name_short.length()>20){
					project_name_short = project_name_short.substring(0, 20);
				}
			}*/
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
			obj.put("project_name_short", data.getProject_name_short());
			
			obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());

			/*obj.put("project_min_price", data.getProject_min_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_min_price())));
			obj.put("project_high_price", data.getProject_high_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_high_price())));*/
			obj.put("project_min_price", data.getProject_min_price());
			obj.put("project_high_price", data.getProject_high_price());
/*=======
			obj.put("project_min_price", data.getProject_min_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_min_price())));
			obj.put("project_high_price", data.getProject_high_price()==null?"N/A":df.format(Integer.parseInt(data.getProject_high_price())));*/

			obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
			obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
			obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
			
			/*String project_address_short = data.getProject_address();
			if(project_address_short!=null && !"".equals(project_address_short)){
				if(project_address_short.length()>40){
					project_address_short = project_address_short.substring(0, 40);
				}
			}*/
			obj.put("project_address", data.getProject_address()==null?"":data.getProject_address());

			obj.put("project_address_short", data.getProject_address_short());			

			obj.put("minArea", data.getMin_area()==0?0:data.getMin_area());
			obj.put("maxArea", data.getMax_area()==0?0:data.getMax_area());
			obj.put("return_money", data.getReturn_money()==null?"":data.getReturn_money());
			//obj.put("project_price_int_qi", data.getProject_price_int_qi()==0?"N/A":df.format(data.getProject_price_int_qi()));
			obj.put("project_price_int_qi", data.getProject_price_int_qi_str());
			obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
			obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
			obj.put("project_key", data.getProject_key()==null?"":data.getProject_key());
			array.add(obj);
		}
		return array;
	}
	
	
	
}
