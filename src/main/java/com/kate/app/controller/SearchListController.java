package com.kate.app.controller;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.AjaxDao;
import com.kate.app.dao.BingMapDao;
import com.kate.app.dao.HouseProjectDao;
import com.kate.app.dao.ProjectInputDao;
import com.kate.app.dao.SearchListDao;
import com.kate.app.dao.UserDao;
import com.kate.app.model.HouseProject;
import com.kate.app.model.Nation;
import com.kate.app.model.ProjectDescImage;
import com.kate.app.model.SearchList;

@Controller
public class SearchListController {
	@Autowired
	private SearchListDao searchListDao;
	@Autowired
	private AjaxDao ajaxDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BingMapDao bingMapDao;
	@Autowired
	private ProjectInputDao projectInputDao;
	@Autowired
	private HouseProjectDao houseProjectDao;
	/*public static List<SearchList> searchList_final=new ArrayList<SearchList>();*/
	private static List<SearchList> searchList_final=new ArrayList<SearchList>();
	public static String flagSearch = "";
	private static String nation=null;
	private static String city=null;
	private static String area=null;

	
	
	/**
	 * 项目列表页
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping({"/SearchList"})
	public String search_controller(HttpServletRequest req, HttpServletResponse resp){
			req.getSession().setAttribute("Information", "List");
	    String flag=req.getParameter("flag");
		if("1".equals(flag)){
			Object o = req.getSession().getAttribute("listResult");
			o = null;
		    req.getSession().setAttribute("listResult", null);
			req.getSession().setAttribute("searchList_final", null);
			req.getSession().setAttribute("nation", "国家");
			req.getSession().setAttribute("city", "城市");
			req.getSession().setAttribute("area", "区域");
			req.setAttribute("xinkaipan1", "0");
			req.setAttribute("huaren1", "0");
			req.setAttribute("remen1", "0");
			req.setAttribute("xuequ1", "0");
			req.setAttribute("baozu1", "0");
			req.setAttribute("daxue1", "0");
			req.setAttribute("center1", "0");
			req.setAttribute("traffic1", "0");
			req.setAttribute("xianfang1", "0");
			req.setAttribute("maidi1", "0");
			
		}
		//得到所有的国家名称
		List<String> nations=searchListDao.findAllNation();
		req.setAttribute("nations", nations);
		//SearchController.Information = "List";
		if("0".equals(flag)){
			String nation=(String)req.getSession().getAttribute("nation");
			String city=(String)req.getSession().getAttribute("city");
			String area=(String)req.getSession().getAttribute("area");
	        req.setAttribute("nation", nation);
			List<String>cities=searchListDao.findCityByNation(nation);
			req.setAttribute("cities", cities);
			req.setAttribute("city", city);
			List<String>areas=searchListDao.findAreaByCity(city);
			req.setAttribute("areas", areas);
			req.setAttribute("area", area);
			//从session中拿到标签参数
			String xinkaipan=(String)req.getSession().getAttribute("xinkaipan1");
			String huaren=(String)req.getSession().getAttribute("huaren1");
			String remen=(String)req.getSession().getAttribute("remen1");
			String xuequ=(String)req.getSession().getAttribute("xuequ1");
			String baozu=(String)req.getSession().getAttribute("baozu1");
			String daxue=(String)req.getSession().getAttribute("daxue1");
			String center=(String)req.getSession().getAttribute("center1");
			String traffic=(String)req.getSession().getAttribute("traffic1");
			String xianfang=(String)req.getSession().getAttribute("xianfang1");
			String maidi=(String)req.getSession().getAttribute("maidi1");
			req.setAttribute("xinkaipan1", xinkaipan);
			req.setAttribute("huaren1", huaren);
			req.setAttribute("remen1", remen);
			req.setAttribute("xuequ1", xuequ);
			req.setAttribute("baozu1", baozu);
			req.setAttribute("daxue1", daxue);
			req.setAttribute("center1", center);
			req.setAttribute("traffic1", traffic);
			req.setAttribute("xianfang1", xianfang);
			req.setAttribute("maidi1", maidi);
			
		}
		
		return "/searchList.jsp";
	}
	/**
	 * 列表页左侧搜索
	 * @param req
	 * @param resp
	 */
	@RequestMapping({"/FilterList"})
	public void filter_controller(HttpServletRequest req, HttpServletResponse resp){
		NumberFormat nf = new DecimalFormat("#,###,###");
		int projecttypeNum=Integer.parseInt(req.getParameter("projecttype"));
		String projecttype=null;
		switch(projecttypeNum){
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
		String nation=req.getParameter("nation");
		String city=req.getParameter("city");
		String area=req.getParameter("area");
		/*SearchListController.nation=nation;
		SearchListController.area=area;
		SearchListController.city=city;*/
		req.getSession().setAttribute("nation", nation);
		req.getSession().setAttribute("city", city);
		req.getSession().setAttribute("area", area);
		
		
		String zongjiatemp=req.getParameter("zongjia");
		String danjiatemp=req.getParameter("danjia");
		String[] zongjiaarray=zongjiatemp.split(";");
		String[] danjiaarray=danjiatemp.split(";");
		int zongjiamin=Integer.parseInt(zongjiaarray[0]);
		int zongjiamax=Integer.parseInt(zongjiaarray[1]);
		int danjiamin=Integer.parseInt(danjiaarray[0]);
		int danjiamax=Integer.parseInt(danjiaarray[1]);
		
		String woshitemp=req.getParameter("woshi");
		String[] woshiarray=woshitemp.split(";");
		int woshimin=Integer.parseInt(woshiarray[0]);
		int woshimax=Integer.parseInt(woshiarray[1]);
		
		
		String xinaipan=req.getParameter("xinaipan");
		String remen=req.getParameter("remen");
		String youxiu=req.getParameter("youxiu");
		String center=req.getParameter("center");
		String baozu=req.getParameter("baozu");
		String huaren=req.getParameter("huaren");
		String zuixin=req.getParameter("zuixin");
		String daxue=req.getParameter("daxue");
		String xianfang=req.getParameter("xianfang");
		String traffic=req.getParameter("traffic");
		
		String pageIndex = req.getParameter("pageIndex");   //閿熸枻鎷峰墠椤甸敓鏂ゆ嫹
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //姣忛〉閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
		int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
		
		List<SearchList> searchList=searchListDao.filterSearchList(projecttype, zongjiamin, zongjiamax,danjiamin,danjiamax,xinaipan,remen,youxiu,center,baozu,huaren,zuixin,daxue,xianfang,traffic,woshimin,woshimax,nation,city,area);
		for(SearchList a:searchList){
			String project_num=a.getProject_num();
			List<ProjectDescImage> imageList2 = houseProjectDao.HouseProjectImageList(project_num);
			String image1 = "";
			if(imageList2!=null && imageList2.size()>0){
				image1 = imageList2.get(0).getName();
			}
			a.setProject_img(image1);
		}
		/*SearchListController.searchList_final=searchList;*/
		req.getSession().setAttribute("searchList_final", searchList);
		//SearchController.Information = "List";
		req.getSession().setAttribute("Information", "List");
		int total = searchList.size();
		int pageEnd = pageNum * pageSize;
		int end = pageEnd < total ? pageEnd : total;
		
		int start = (pageNum-1) * pageSize;
		int pageStart = start == pageEnd ? 0 : start;
		//寰楀埌褰撳墠鐢ㄦ埛鐨刬d
		String username = (String)req.getSession().getAttribute("username");
		int userid=userDao.findUserByName(username);
		//寰楀埌褰撳墠鐢ㄦ埛鏀惰棌鐨凱roNum鐨勯泦鍚�
		Set<String> proNumList=searchListDao.proNumList(userid);
		
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
				obj.put("MaxPrice", item.getMaxPrice()==null?"N/A":nf.format(Integer.parseInt(item.getMaxPrice())));
				obj.put("MinArea", item.getMinArea());
				obj.put("MinPrice", item.getMinPrice()==null?"N/A":nf.format(Integer.parseInt(item.getMinPrice())));
				
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
				obj.put("project_price_int_qi", nf.format(item.getProject_price_int_qi()));
				obj.put("project_desc", item.getProject_desc());
				String lan = item.getProject_lan_cn();
				String lan_en = item.getProject_lan_en();
				
				if(null == lan || "".equals(lan)){
					lan = lan_en;
				}
				obj.put("project_lan_cn", lan);
				//寰幆閬嶅巻褰撳墠鐢ㄦ埛鏀惰棌鐨勯」鐩紝鑻ユ湁锛屽皢isCollected缃负1,琛ㄧず褰撳墠鐢ㄦ埛鏀惰棌;鑻ユ棤锛屽皢isCollected缃负0锛岃〃绀哄綋鍓嶇敤鎴锋病鏈夋敹钘�
				String pronum=item.getProject_num();
				int flag=0;//娌℃湁鏀惰棌
				if(proNumList.contains(pronum)){
					flag=1;//鏀惰棌
				}
				obj.put("isCollected", flag);
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
		try {
			//resp.sendRedirect("/SearchList");      //重定向
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}
	
	
	
/**
 * 项目列表页  ajax分页
 * @param req
 * @param resp
 */
		@RequestMapping({"/SearchListPage"})
		public void SearchListPage(HttpServletRequest req, HttpServletResponse resp){
			NumberFormat nf = new DecimalFormat("#,###,###");
			String pageIndex = req.getParameter("pageIndex");   //閿熸枻鎷峰墠椤甸敓鏂ゆ嫹
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //姣忛〉閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
			int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
			
			/*List<SearchList> searchList=searchListDao.listSearchList();*/
			List<SearchList> searchList=new ArrayList<SearchList>();
			Object obj1 = req.getSession().getAttribute("listResult");
			List<HouseProject> houseProjectList = null;
			if(obj1!=null){
				houseProjectList = (List<HouseProject>)obj1;
			for(HouseProject houseProject:houseProjectList){
				SearchList ss=new SearchList();
	        	int id=houseProject.getId();
	        	String project_img=houseProject.getProject_img();
	        	String project_num=houseProject.getProject_num();
	        	String project_address=houseProject.getProject_address();
	        	String project_address_short=houseProject.getProject_address_short();
	        	String project_name=houseProject.getProject_name();
	        	int project_price_int_qi=houseProject.getProject_price_int_qi();
	        	String project_price=houseProject.getProject_price_int_qi_str();
	        	int minArea=houseProject.getMinArea();
	        	int maxArea=houseProject.getMaxArea();
	        	/*int keshou=*/
	        	String average_price=houseProject.getProject_price_int_qi_str();
	        	String house_type=null;///////////
	        	String  project_min_price=houseProject.getProject_min_price();
	        	String  project_high_price=houseProject.getProject_high_price();
	        	String mianji=houseProject.getMianji();
	        	/*String return_money=houseProject.getFanxian();*/
	        	String project_price_int_qi_str=houseProject.getProject_price_int_qi_str();
	        	List<String> project_key=houseProject.getProject_key();
	        	String project_name_full=houseProject.getProject_name();
	        	String bijiao=houseProject.getBijiao();
	        	String gps=houseProject.getGps();
	        	String project_lan_cn=houseProject.getProject_lan_cn();
	        	String developer_id_name=houseProject.getDeveloper_id_name();
	        	String xinkaipan=houseProject.getXinkaipan();
	        	String remen=houseProject.getRemen();
	        	String xuequ=houseProject.getXuequ();
	        	String center=houseProject.getCenter();
	        	String baozu=houseProject.getBaozu();
	        	String huaren=houseProject.getHuaren();
	        	String maidi=houseProject.getMaidi();
	        	String daxue=houseProject.getDaxue();
	        	String xianfang=houseProject.getXianfang();
	        	String traffic=houseProject.getTraffic();
	        	
	        	
	        	
	        	
	        	ss.setId(id);
	        	ss.setProject_img(project_img);
	        	ss.setProject_num(project_num);
	        	ss.setProject_address(project_address);
	        	ss.setProject_address_short(project_address_short);
	        	ss.setProject_name(project_name);
	        	ss.setProject_price_int_qi_str(project_price_int_qi_str);
	        	ss.setProject_price_int_qi(project_price_int_qi);
	        	ss.setMinArea(minArea);
	        	ss.setMaxArea(maxArea);
	        	ss.setMaxPrice(project_high_price);
	        	ss.setMinPrice(project_min_price);
	        	ss.setMianji(mianji);
	        	ss.setProject_key(project_key);
	        	ss.setProject_name(project_name_full);
	        	ss.setBijiao(bijiao);
	        	ss.setGps(gps);
	        	ss.setProject_lan_cn(project_lan_cn);
	        	ss.setDeveloper_id_name(developer_id_name);
	        	ss.setXinkaipan(xinkaipan);
	        	ss.setRemen(remen);
	        	ss.setXuequ(xuequ);
	        	ss.setCenter(center);
	        	ss.setBaozu(baozu);
	        	ss.setHuaren(huaren);
	        	ss.setMaidi(maidi);
	        	ss.setDaxue(daxue);
	        	ss.setXianfang(xianfang);
	        	ss.setTraffic(traffic);
	        	searchList.add(ss);
			}
			}
			if(searchList.size()==0){
				 searchList=searchListDao.listSearchList();
			}
			
			for(SearchList item : searchList){
				if(item!=null){
					String image1 = "";
					String proNum = item.getProject_num();
					if(proNum!=null && !"".equals(proNum)){
						List<ProjectDescImage> imageList2 = houseProjectDao.HouseProjectImageList(proNum);
						
						if(imageList2!=null && imageList2.size()>0){
							image1 = imageList2.get(0).getName();
						}
					}
					item.setProject_img(image1);
				}
			}
			int total = searchList.size();
			int pageEnd = pageNum * pageSize;
			int end = pageEnd < total ? pageEnd : total;
			
			int start = (pageNum-1) * pageSize;
			int pageStart = start == pageEnd ? 0 : start;
			//寰楀埌褰撳墠鐢ㄦ埛鐨刬d
			String username = (String)req.getSession().getAttribute("username");
			/*int userid=userDao.findUserByName(username);*/
			int userid=userDao.findUserByEmailAndTel(username);
			//寰楀埌褰撳墠鐢ㄦ埛鏀惰棌鐨凱roNum鐨勯泦鍚�
			Set<String> proNumList=searchListDao.proNumList(userid);
			
			//SearchController.Information = "List";
			req.getSession().setAttribute("Information", "List");
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

					/*obj.put("MaxPrice", item.getMaxPrice()==null||"".equals(item.getMaxPrice())?"":nf.format(Integer.parseInt(item.getMaxPrice())));*/
					obj.put("MaxPrice", item.getMaxPrice()==null||"".equals(item.getMaxPrice())?"":item.getMaxPrice());

					obj.put("MinArea", item.getMinArea());
					/*obj.put("MinPrice", item.getMinPrice()==null||"".equals(item.getMinPrice())?"":nf.format(Integer.parseInt(item.getMinPrice())));	*/
					obj.put("MinPrice", item.getMinPrice()==null||"".equals(item.getMinPrice())?"":item.getMinPrice());	
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
					/*obj.put("project_price_int_qi", nf.format(item.getProject_price_int_qi()));*/
					obj.put("project_price_int_qi", item.getProject_price_int_qi());
					obj.put("project_desc", item.getProject_desc());
					String lan = item.getProject_lan_cn();
					String lan_en = item.getProject_lan_en();
					if(null == lan || "".equals(lan)){
						lan = lan_en;
					}
					obj.put("project_lan_cn", lan);
					String pronum=item.getProject_num();
					int flag=0;
					if(proNumList.contains(pronum)){
						flag=1;
					}
					obj.put("isCollected", flag);
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
		/**
		 * 按推荐度进行排序
		 * @param req
		 * @param resp
		 */
		@RequestMapping({"/OrderPage"})
		public void OrderListPage(HttpServletRequest req, HttpServletResponse resp){
			//String orderBy=req.getParameter("orderBy");
			NumberFormat nf = new DecimalFormat("#,###,###");
			String pageIndex = req.getParameter("pageIndex");   //閿熸枻鎷峰墠椤甸敓鏂ゆ嫹
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //姣忛〉閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
			int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
			
			
			List<SearchList> searchList=searchListDao.OrderlistSearchList();
			int total = searchList.size();
			int pageEnd = pageNum * pageSize;
			int end = pageEnd < total ? pageEnd : total;
			
			int start = (pageNum-1) * pageSize;
			int pageStart = start == pageEnd ? 0 : start;
	
			String username = (String)req.getSession().getAttribute("username");
			int userid=userDao.findUserByName(username);

			Set<String> proNumList=searchListDao.proNumList(userid);
			
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
					obj.put("MaxPrice", item.getMaxPrice()==null?"":nf.format(Integer.parseInt(item.getMaxPrice())));
					obj.put("MinArea", item.getMinArea());
					obj.put("MinPrice", item.getMinPrice()==null?"":nf.format(Integer.parseInt(item.getMinPrice())));
					
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
					obj.put("project_price_int_qi", nf.format(item.getProject_price_int_qi()));
					obj.put("project_desc", item.getProject_desc());
					String lan = item.getProject_lan_cn();
					String lan_en = item.getProject_lan_en();
					if(null == lan || "".equals(lan)){
						lan = lan_en;
					}
					obj.put("project_lan_cn", lan);
					
					String pronum=item.getProject_num();
					int flag=0;
					if(proNumList.contains(pronum)){
						flag=1;
					}
					obj.put("isCollected", flag);
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
		/**
		 * 我的收藏列表页
		 * @param req
		 * @param resp
		 */
		@RequestMapping({"/ColloectListPage"})
		public void CollectListPage(HttpServletRequest req, HttpServletResponse resp){
			String pageIndex = req.getParameter("pageIndex");   //閿熸枻鎷峰墠椤甸敓鏂ゆ嫹
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //姣忛〉閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
			int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
			
			String username = (String)req.getSession().getAttribute("username");
			/*int userid=userDao.findUserByName(username);*/
			int userid=userDao.findUserByEmailAndTel(username);
			List<SearchList> searchList=searchListDao.listCollectList(userid);
			
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
		
		/**
		 * 添加收藏
		 * @param req
		 * @param resp
		 */
		@RequestMapping({"/AddCollect"})
		public void AddCollect(HttpServletRequest req, HttpServletResponse resp){
			JSONObject json = new JSONObject();
			String username = (String)req.getSession().getAttribute("username");
			if(username==null){//濡傛灉鐢ㄦ埛娌℃湁鐧诲綍
				json.put("user", "0");
			}
			else{
				int userid=userDao.findUserByEmailAndTel(username);
				String proNum=req.getParameter("proNum");
				int flag=searchListDao.AddCollect(userid, proNum);
				if(flag==0){
					json.put("flag", "0");
				}else{
					json.put("flag", "1");
				}
				json.put("user", "1");
			}
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		/**
		 * 取消收藏
		 * @param req
		 * @param resp
		 */
		@RequestMapping({"/DelCollect"})
		public void DelCollect(HttpServletRequest req, HttpServletResponse resp){
			String proNum=req.getParameter("proNum");
			String username = (String)req.getSession().getAttribute("username");
			int userid=userDao.findUserByEmailAndTel(username);
			int flag=searchListDao.DelCollect(userid, proNum);
			JSONObject json = new JSONObject();
			if(flag==0){
				json.put("flag", "0");
			}else{
				json.put("flag", "1");
			}
			//return "/Collect.jsp";
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		/**
		 * 根据所选国家得到所有城市
		 * @param req
		 * @param resp
		 */
		@RequestMapping({"/findCityByNation"})
		public void findCityByNation(HttpServletRequest req, HttpServletResponse resp){
			JSONArray array = new JSONArray();
			JSONObject json=new JSONObject();
			String nation=req.getParameter("nation");
			List<String> citys=searchListDao.findCityByNation(nation);
			for(String item : citys){
				JSONObject obj=new JSONObject();
				obj.put("city", item);
				array.add(obj);
			}
			json.put("cityArray", array);
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		/**
		 * 根据所选城市得到所选 区域
		 * @param req
		 * @param resp
		 */
		@RequestMapping({"/findAreaByCity"})
		public void findAreaByCity(HttpServletRequest req, HttpServletResponse resp){
			JSONArray array = new JSONArray();
			JSONObject json=new JSONObject();
			String city=req.getParameter("city");
			List<String> areas=searchListDao.findAreaByCity(city);
			for(String item : areas){
				JSONObject obj=new JSONObject();
				obj.put("area", item);
				array.add(obj);
			}
			json.put("areaArray", array);
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
