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
import com.kate.app.dao.SearchListDao;
import com.kate.app.dao.UserDao;
import com.kate.app.model.SearchList;

@Controller
public class SearchListController {
	@Autowired
	private SearchListDao searchListDao;
	@Autowired
	private AjaxDao ajaxDao;
	@Autowired
	private UserDao userDao;
	
	//锟斤拷锟斤拷锟斤拷锟斤拷锟叫憋拷锟斤拷示
	@RequestMapping({"/SearchList"})
	public String search_controller(HttpServletRequest req, HttpServletResponse resp){
		//List<SearchList> searchList=searchListDao.listSearchList().subList(0, 5);
		//req.setAttribute("searchList",searchList);
		return "/searchList.jsp";
	}
	//左侧搜索
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
		
		String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //每页锟斤拷锟斤拷锟斤拷锟�
		int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
		
		List<SearchList> searchList=searchListDao.filterSearchList(projecttype, zongjiamin, zongjiamax,danjiamin,danjiamax,xinaipan,remen,youxiu,center,baozu,huaren,zuixin,daxue,xianfang,traffic);
		int total = searchList.size();
		int pageEnd = pageNum * pageSize;
		int end = pageEnd < total ? pageEnd : total;
		
		int start = (pageNum-1) * pageSize;
		int pageStart = start == pageEnd ? 0 : start;
		//得到当前用户的id
		String username = (String)req.getSession().getAttribute("username");
		int userid=userDao.findUserByName(username);
		//得到当前用户收藏的ProNum的集合
		Set<String> proNumList=searchListDao.proNumList(userid);
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(pageStart <= end){
			List<SearchList> resultList=searchList.subList(start, end);
			for(SearchList item : resultList){
				JSONObject obj = new JSONObject();
				obj.put("id", item.getId());
				obj.put("Fanxian", item.getFanxian());
				obj.put("Keshou", item.getKeshou());
				obj.put("MaxArea", item.getMaxArea());
				obj.put("MaxPrice", item.getMaxPrice());
				obj.put("MinArea", item.getMinArea());
				obj.put("MinPrice", item.getMinPrice());
				obj.put("Project_img", item.getProject_img());
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
				obj.put("project_lan_cn", item.getProject_lan_cn());
				//循环遍历当前用户收藏的项目，若有，将isCollected置为1,表示当前用户收藏;若无，将isCollected置为0，表示当前用户没有收藏
				String pronum=item.getProject_num();
				int flag=0;//没有收藏
				if(proNumList.contains(pronum)){
					flag=1;//收藏
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
	
	
	
	//锟斤拷锟斤拷锟斤拷锟斤拷锟叫憋拷锟斤拷示
		@RequestMapping({"/SearchListPage"})
		public void SearchListPage(HttpServletRequest req, HttpServletResponse resp){
			String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //每页锟斤拷锟斤拷锟斤拷锟�
			int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
			
			List<SearchList> searchList=searchListDao.listSearchList();
			
			int total = searchList.size();
			int pageEnd = pageNum * pageSize;
			int end = pageEnd < total ? pageEnd : total;
			
			int start = (pageNum-1) * pageSize;
			int pageStart = start == pageEnd ? 0 : start;
			//得到当前用户的id
			String username = (String)req.getSession().getAttribute("username");
			int userid=userDao.findUserByName(username);
			//得到当前用户收藏的ProNum的集合
			Set<String> proNumList=searchListDao.proNumList(userid);
			
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			if(pageStart <= end){
				List<SearchList> resultList=searchList.subList(start, end);
				for(SearchList item : resultList){
					JSONObject obj = new JSONObject();
					obj.put("id", item.getId());
					obj.put("Fanxian", item.getFanxian());
					obj.put("Keshou", item.getKeshou());
					obj.put("MaxArea", item.getMaxArea());
					obj.put("MaxPrice", item.getMaxPrice());
					obj.put("MinArea", item.getMinArea());
					obj.put("MinPrice", item.getMinPrice());
					obj.put("Project_img", item.getProject_img());
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
					obj.put("project_lan_cn", item.getProject_lan_cn());
					//循环遍历当前用户收藏的项目，若有，将isCollected置为1,表示当前用户收藏;若无，将isCollected置为0，表示当前用户没有收藏
					String pronum=item.getProject_num();
					int flag=0;//没有收藏
					if(proNumList.contains(pronum)){
						flag=1;//收藏
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
		//按推荐度排序
		@RequestMapping({"/OrderPage"})
		public void OrderListPage(HttpServletRequest req, HttpServletResponse resp){
			//String orderBy=req.getParameter("orderBy");
			String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //每页锟斤拷锟斤拷锟斤拷锟�
			int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
			
			List<SearchList> searchList=searchListDao.OrderlistSearchList();
			
			int total = searchList.size();
			int pageEnd = pageNum * pageSize;
			int end = pageEnd < total ? pageEnd : total;
			
			int start = (pageNum-1) * pageSize;
			int pageStart = start == pageEnd ? 0 : start;
			//得到当前用户的id
			String username = (String)req.getSession().getAttribute("username");
			int userid=userDao.findUserByName(username);
			//得到当前用户收藏的ProNum的集合
			Set<String> proNumList=searchListDao.proNumList(userid);
			
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			if(pageStart <= end){
				List<SearchList> resultList=searchList.subList(start, end);
				for(SearchList item : resultList){
					JSONObject obj = new JSONObject();
					obj.put("id", item.getId());
					obj.put("Fanxian", item.getFanxian());
					obj.put("Keshou", item.getKeshou());
					obj.put("MaxArea", item.getMaxArea());
					obj.put("MaxPrice", item.getMaxPrice());
					obj.put("MinArea", item.getMinArea());
					obj.put("MinPrice", item.getMinPrice());
					obj.put("Project_img", item.getProject_img());
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
					obj.put("project_lan_cn", item.getProject_lan_cn());
					//循环遍历当前用户收藏的项目，若有，将isCollected置为1,表示当前用户收藏;若无，将isCollected置为0，表示当前用户没有收藏
					String pronum=item.getProject_num();
					int flag=0;//没有收藏
					if(proNumList.contains(pronum)){
						flag=1;//收藏
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
		//收藏列表分页
		@RequestMapping({"/ColloectListPage"})
		public void CollectListPage(HttpServletRequest req, HttpServletResponse resp){
			String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //每页锟斤拷锟斤拷锟斤拷锟�
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
					obj.put("id", item.getId());
					obj.put("Fanxian", item.getFanxian());
					obj.put("Keshou", item.getKeshou());
					obj.put("MaxArea", item.getMaxArea());
					obj.put("MaxPrice", item.getMaxPrice());
					obj.put("MinArea", item.getMinArea());
					obj.put("MinPrice", item.getMinPrice());
					obj.put("Project_img", item.getProject_img());
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
					obj.put("project_lan_cn", item.getProject_lan_cn());
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
		
		//收藏列表添加
		@RequestMapping({"/AddCollect"})
		public void AddCollect(HttpServletRequest req, HttpServletResponse resp){
			JSONObject json = new JSONObject();
			String username = (String)req.getSession().getAttribute("username");
			if(username==null){//如果用户没有登录
				json.put("user", "0");
				System.out.println("用户没有登录");
			}
			else{
				int userid=userDao.findUserByName(username);
				String proNum=req.getParameter("proNum");
				int flag=searchListDao.AddCollect(userid, proNum);
				if(flag==0){
					json.put("flag", "0");
					System.out.println("添加失败");
				}else{
					json.put("flag", "1");
					System.out.println("添加成功");
				}
				json.put("user", "1");
			}
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//收藏列表删除
		@RequestMapping({"/DelCollect"})
		public void DelCollect(HttpServletRequest req, HttpServletResponse resp){
			//TODO获得session中的用户id
			String proNum=req.getParameter("proNum");
			String username = (String)req.getSession().getAttribute("username");
			int userid=userDao.findUserByName(username);
			int flag=searchListDao.DelCollect(userid, proNum);
			JSONObject json = new JSONObject();
			if(flag==0){
				json.put("flag", "0");
				System.out.println("删除失败");
			}else{
				json.put("flag", "1");
				System.out.println("删除成功");
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
