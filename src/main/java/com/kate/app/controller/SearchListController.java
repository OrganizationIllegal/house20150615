package com.kate.app.controller;

import java.io.PrintWriter;
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
import com.kate.app.dao.ProjectInputDao;
import com.kate.app.dao.SearchListDao;
import com.kate.app.dao.UserDao;
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
	private ProjectInputDao projectInputDao;
	
	//閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熷彨鎲嬫嫹閿熸枻鎷风ず
	@RequestMapping({"/SearchList"})
	public String search_controller(HttpServletRequest req, HttpServletResponse resp){
		//List<SearchList> searchList=searchListDao.listSearchList().subList(0, 5);
		//req.setAttribute("searchList",searchList);
		return "/searchList.jsp";
	}
	//宸︿晶鎼滅储
	@RequestMapping({"/FilterList"})
	public void filter_controller(HttpServletRequest req, HttpServletResponse resp){
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
				
		}
			
		String zongjiatemp=req.getParameter("zongjia");
		String danjiatemp=req.getParameter("danjia");
		String[] zongjiaarray=zongjiatemp.split(";");
		String[] danjiaarray=danjiatemp.split(";");
		int zongjiamin=Integer.parseInt(zongjiaarray[0]);
		int zongjiamax=Integer.parseInt(zongjiaarray[1]);
		int danjiamin=Integer.parseInt(danjiaarray[0]);
		int danjiamax=Integer.parseInt(danjiaarray[1]);
		String woshi=req.getParameter("woshi");
		
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
		
		List<SearchList> searchList=searchListDao.filterSearchList(projecttype, zongjiamin, zongjiamax,danjiamin,danjiamax,xinaipan,remen,youxiu,center,baozu,huaren,zuixin,daxue,xianfang,traffic);
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
				obj.put("MaxPrice", item.getMaxPrice());
				obj.put("MinArea", item.getMinArea());
				obj.put("MinPrice", item.getMinPrice());
				
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
		

	}
	
	
	
	//閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熷彨鎲嬫嫹閿熸枻鎷风ず
		@RequestMapping({"/SearchListPage"})
		public void SearchListPage(HttpServletRequest req, HttpServletResponse resp){
			String pageIndex = req.getParameter("pageIndex");   //閿熸枻鎷峰墠椤甸敓鏂ゆ嫹
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //姣忛〉閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
			int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
			
			List<SearchList> searchList=searchListDao.listSearchList();
			
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
		}
		//鎸夋帹鑽愬害鎺掑簭
		@RequestMapping({"/OrderPage"})
		public void OrderListPage(HttpServletRequest req, HttpServletResponse resp){
			//String orderBy=req.getParameter("orderBy");
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
		}
		//鏀惰棌鍒楄〃鍒嗛〉
		@RequestMapping({"/ColloectListPage"})
		public void CollectListPage(HttpServletRequest req, HttpServletResponse resp){
			String pageIndex = req.getParameter("pageIndex");   //閿熸枻鎷峰墠椤甸敓鏂ゆ嫹
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //姣忛〉閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
			int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
			
			String username = (String)req.getSession().getAttribute("username");
			int userid=userDao.findUserByName(username);
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
		
		//鏀惰棌鍒楄〃娣诲姞
		@RequestMapping({"/AddCollect"})
		public void AddCollect(HttpServletRequest req, HttpServletResponse resp){
			JSONObject json = new JSONObject();
			String username = (String)req.getSession().getAttribute("username");
			if(username==null){//濡傛灉鐢ㄦ埛娌℃湁鐧诲綍
				json.put("user", "0");
				System.out.println("鐢ㄦ埛娌℃湁鐧诲綍");
			}
			else{
				int userid=userDao.findUserByName(username);
				String proNum=req.getParameter("proNum");
				int flag=searchListDao.AddCollect(userid, proNum);
				if(flag==0){
					json.put("flag", "0");
					System.out.println("娣诲姞澶辫触");
				}else{
					json.put("flag", "1");
					System.out.println("娣诲姞鎴愬姛");
				}
				json.put("user", "1");
			}
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//鏀惰棌鍒楄〃鍒犻櫎
		@RequestMapping({"/DelCollect"})
		public void DelCollect(HttpServletRequest req, HttpServletResponse resp){
			//TODO鑾峰緱session涓殑鐢ㄦ埛id
			String proNum=req.getParameter("proNum");
			String username = (String)req.getSession().getAttribute("username");
			int userid=userDao.findUserByName(username);
			int flag=searchListDao.DelCollect(userid, proNum);
			JSONObject json = new JSONObject();
			if(flag==0){
				json.put("flag", "0");
				System.out.println("鍒犻櫎澶辫触");
			}else{
				json.put("flag", "1");
				System.out.println("鍒犻櫎鎴愬姛");
			}
			//return "/Collect.jsp";
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
