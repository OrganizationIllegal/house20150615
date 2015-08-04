package com.kate.app.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.engine.jdbc.internal.TypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.ZhiYeDao;
import com.kate.app.model.NewsBoke;
import com.kate.app.model.SearchList;
import com.kate.app.model.ZhiYeZhiDao;

@Controller
public class ZhiYeZhiDaoController {
	@Autowired
	private ZhiYeDao zhiYeDao;
	
	private static final int PAGE_SIZE = 10;
	/*
	 * 置业百科数据信息的返回
	 */
	@RequestMapping({"/ZhiYeInfo"})
	public String ZhiYeInfo(HttpServletRequest req, HttpServletResponse resp){
		String fenlei = req.getParameter("type");
		List<ZhiYeZhiDao> zhiYeList = new ArrayList<ZhiYeZhiDao>();
		List<ZhiYeZhiDao> zhiYeList1 = new ArrayList<ZhiYeZhiDao>();
		if(fenlei!=null && !"".equals(fenlei)){
			zhiYeList = zhiYeDao.selectZhiYeByFenlei(fenlei);  //查找所有分类
			req.setAttribute("fenlei",fenlei);
		}
		else{
			zhiYeList = zhiYeDao.selectZhiYe();   //根据时间排序，查找置业百科列表
		}
		
		List<NewsBoke> newsList = zhiYeDao.selectNewsBoke();  //根据时间排序，查找新闻博客列表
		/*int total = zhiYeDao.countZhiYe();*/
		int total = zhiYeList.size();
		int pageCount = total%PAGE_SIZE == 0 ? total/PAGE_SIZE: total/PAGE_SIZE+1;
		List<ZhiYeZhiDao> lastestList = new ArrayList<ZhiYeZhiDao>();
		/*if(zhiYeList!=null){
			
		}*/
		/*if(zhiYeList1.size() > 3){
			lastestList = zhiYeList1.subList(0, 3);
		}
		else{
			lastestList = zhiYeList1;
		}*/
		if(zhiYeList.size() > 3){
		   lastestList = zhiYeList.subList(0, 3);
	    }
	    else{
		   lastestList = zhiYeList;
	     }
		if(newsList.size() > 3){
			newsList = newsList.subList(0, 3);
		}
		List<String> fenleiList = zhiYeDao.zhiYeFenlei();   //得到所有的分类列表
		
		//Collections.shuffle(zhiYeList);   //闅忔満鎺掑簭
		req.setAttribute("resultList",zhiYeList);
		req.setAttribute("lastestList",lastestList);
		req.setAttribute("newsList",newsList);
		req.setAttribute("fenleiList",fenleiList);
		req.setAttribute("fenleiList",fenleiList);
		req.setAttribute("total",total);
		req.setAttribute("pageCount",pageCount);
		
		return "/purchasing.jsp";
	}
	
	/*
	 * 新闻博客信息返回
	 */
	@RequestMapping({"/BlogList"})
	public String BlogList(HttpServletRequest req, HttpServletResponse resp){
		String fenlei = req.getParameter("type");
		List<NewsBoke> newsList = new ArrayList<NewsBoke>();
		List<NewsBoke> newsList1 = new ArrayList<NewsBoke>();
		if(fenlei!=null && !"".equals(fenlei)){
			newsList = zhiYeDao.selectNewsBokeByFenlei(fenlei);  //查找所有分类
			req.setAttribute("fenlei",fenlei);
		}
		else{
			newsList = zhiYeDao.selectNewsBoke();  //根据时间排序，查找新闻博客列表
		}
		
		List<ZhiYeZhiDao> zhiYeList=zhiYeDao.selectZhiYe();   //获取置业指导list
		newsList1 = zhiYeDao.selectNewsBoke();
		int total = newsList.size();
		int pageCount = total%PAGE_SIZE == 0 ? total/PAGE_SIZE: total/PAGE_SIZE+1;
		List<ZhiYeZhiDao> lastestList = new ArrayList<ZhiYeZhiDao>();
		List<NewsBoke> newslastestList = new ArrayList<NewsBoke>();
		/*if(zhiYeList!=null){
			
		}*/
		if(zhiYeList.size() > 3){
			lastestList = zhiYeList.subList(0, 3);
		}
		else{
			lastestList = zhiYeList;
		}
		if(newsList1.size() > 3){
			newslastestList = newsList1.subList(0, 3);
		}
		List<String> fenleiList = zhiYeDao.newsBokeFenlei();
		System.out.println(pageCount);
		//Collections.shuffle(zhiYeList);   
		req.setAttribute("resultList",zhiYeList);//
		req.setAttribute("lastestList",lastestList);//
		req.setAttribute("newsList",newsList);//
		req.setAttribute("newslastestList",newslastestList);//
		req.setAttribute("fenleiList",fenleiList);
		req.setAttribute("total",total);
		req.setAttribute("pageCount",pageCount);
		
		return "/BlogList.jsp";
	}
	//新闻列表分页控制
	@RequestMapping({"/NewsBokeFenYe"})
	public void NewsBokeFenYe(HttpServletRequest req, HttpServletResponse resp){
		String pageIndex = req.getParameter("pageIndex");   //
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		List<NewsBoke> newsBokeList = new ArrayList(); 
		String fenlei = req.getParameter("type");
		if(fenlei==null||"".equals(fenlei)||fenlei.equals("请选择一个类别")){
			newsBokeList = zhiYeDao.selectNewsBoke();  //
		}
		else{
			newsBokeList = zhiYeDao.selectNewsBokeByFenlei(fenlei);
		}
		int total = newsBokeList.size();
		int pageCount = total%PAGE_SIZE == 0 ? total/PAGE_SIZE: total/PAGE_SIZE+1;
		int pageEnd = pageNum * PAGE_SIZE;
		int end = pageEnd < total ? pageEnd : total;
		
		int start = (pageNum-1) * PAGE_SIZE;
		int pageStart = start == pageEnd ? 0 : start;
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(pageStart <= end){
			List<NewsBoke> resultList=newsBokeList.subList(start, end);
			
			for(NewsBoke item : resultList){
				JSONObject obj = new JSONObject();
				obj.put("id", item.getId());
				obj.put("news_num", item.getNews_num());
				obj.put("news_people", item.getNews_people());
				obj.put("news_fenlei", item.getNews_fenlei());
				String abstractInfo = item.getNews_abstract();
				if(abstractInfo!=null && !"".equals(abstractInfo)){
					if(abstractInfo.length()>60){
					abstractInfo = abstractInfo.substring(0,60)+"...";
					}
				}
				obj.put("news_abstract", abstractInfo);

				String detail = item.getNews_detail();
				detail = filter(detail);
				//obj.put("detail", detail);

				obj.put("detail", item.getNews_detail()/*.replaceAll("\\", "\n")*/);

				obj.put("image", item.getNews_image());
				obj.put("title", item.getNews_title());
				String newstime=item.getNews_time().toString();
				if(newstime!=null && !"".equals(newstime)){
					newstime = newstime.substring(0,10);
				}
				obj.put("newstime", newstime);
				array.add(obj);
				
			}
			json.put("List", array);
			json.put("total", total);
			json.put("start", start);
			json.put("end", end);
			json.put("pageCount", pageCount);
			
		}
		else{
			json.put("List", "");
			json.put("total", total);
			json.put("pageCount", pageCount);
		}
		
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	//置业指导分页ajax
			@RequestMapping({"/ZhiYeFenYe"})
			public void ZhiYeFenYe(HttpServletRequest req, HttpServletResponse resp){
				String pageIndex = req.getParameter("pageIndex");   //
				int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
				List<ZhiYeZhiDao> zhiYeList = new ArrayList(); 
				String fenlei = req.getParameter("type");
				if(fenlei==null||"".equals(fenlei)||fenlei.equals("请选择一个类别")){
					zhiYeList = zhiYeDao.selectZhiYe();   //
				}
				else{
					zhiYeList = zhiYeDao.selectZhiYeByFenlei(fenlei);
				}
				int total = zhiYeList.size();
				int pageCount = total%PAGE_SIZE == 0 ? total/PAGE_SIZE: total/PAGE_SIZE+1;
				int pageEnd = pageNum * PAGE_SIZE;
				int end = pageEnd < total ? pageEnd : total;
				
				int start = (pageNum-1) * PAGE_SIZE;
				int pageStart = start == pageEnd ? 0 : start;
				
				JSONObject json = new JSONObject();
				JSONArray array = new JSONArray();
				if(pageStart <= end){
					List<ZhiYeZhiDao> resultList=zhiYeList.subList(start, end);
					
					for(ZhiYeZhiDao item : resultList){
						JSONObject obj = new JSONObject();
						obj.put("id", item.getId());
						obj.put("zhiye_num", item.getZhiye_num());
						obj.put("fabu_people", item.getFabu_people());
						obj.put("fenlei", item.getFenlei());
						String abstractInfo = item.getZhiye_abstract();
						if(abstractInfo!=null && !"".equals(abstractInfo)){
							if(abstractInfo.length()>60){
							abstractInfo = abstractInfo.substring(0,60)+"...";
							}
						}
						obj.put("zhiye_abstract", abstractInfo);
						obj.put("detail", item.getDetail());
						obj.put("image", item.getImage());
						obj.put("title", item.getTitle());
						String fabutime=item.getFabu_time().toString();
						if(fabutime!=null && !"".equals(fabutime)){
							fabutime = fabutime.substring(0,10);
						}
						obj.put("fabu_time", fabutime);
					
						array.add(obj);
					}
					json.put("List", array);
					json.put("start", start);
					json.put("end", end);
					json.put("total", total);
					json.put("pageCount", pageCount);
					
				}
				else{
					json.put("List", "");
					json.put("total", total);
					json.put("pageCount", pageCount);
				}
				
				
				try{
					writeJson(json.toJSONString(),resp);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			//新闻详情和职业指导详情页面显示分类列表list的时候分页ajax
			@RequestMapping({"/DetailFenYe"})
			public void DetailFenYe(HttpServletRequest req, HttpServletResponse resp){
				String pageIndex = req.getParameter("pageIndex");   //閿熸枻鎷峰墠椤甸敓鏂ゆ嫹
				int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
				List<NewsBoke> newsBokeList = new ArrayList();     //新闻博客
				List<ZhiYeZhiDao> zhiYeList = new ArrayList();     //职业指导
				String fenlei = req.getParameter("type");
				String leixing = req.getParameter("typeInfo");
				int total = 0;
				
				if(fenlei==null||"".equals(fenlei)||fenlei.equals("请选择一个类别")){
					if(leixing.equals("0")){
						zhiYeList = zhiYeDao.selectZhiYe();   
					}
					else{
						newsBokeList = zhiYeDao.selectNewsBoke();  //
					}
					
				}
				else{
					if(leixing.equals("0")){
						zhiYeList = zhiYeDao.selectZhiYeByFenlei(fenlei);   //
					}
					else{
						newsBokeList = zhiYeDao.selectNewsBokeByFenlei(fenlei);  //
					}
					
				}
				if(leixing.equals("0")){
					total = zhiYeList.size();
				}
				else{
					total = newsBokeList.size();
				}
				
				int pageCount = total%PAGE_SIZE == 0 ? total/PAGE_SIZE: total/PAGE_SIZE+1;
				int pageEnd = pageNum * PAGE_SIZE;
				int end = pageEnd < total ? pageEnd : total;
				
				int start = (pageNum-1) * PAGE_SIZE;
				int pageStart = start == pageEnd ? 0 : start;
				
				JSONObject json = new JSONObject();
				JSONArray array = new JSONArray();
				if(pageStart <= end){
					if(leixing.equals("0")){
						List<ZhiYeZhiDao> resultList=zhiYeList.subList(start, end);
						
						for(ZhiYeZhiDao item : resultList){
							JSONObject obj = new JSONObject();
							obj.put("id", item.getId());
							obj.put("zhiye_num", item.getZhiye_num());
							obj.put("fabu_people", item.getFabu_people());
							obj.put("fenlei", item.getFenlei());
							String abstractInfo = item.getZhiye_abstract();
							if(abstractInfo!=null && !"".equals(abstractInfo)){
								if(abstractInfo.length()>60){
								abstractInfo = abstractInfo.substring(0,60)+"...";
								}
							}
							obj.put("zhiye_abstract", abstractInfo);
							obj.put("detail", item.getDetail());
							obj.put("image", item.getImage());
							obj.put("title", item.getTitle());
							String fabutime=item.getFabu_time().toString();
							if(fabutime!=null && !"".equals(fabutime)){
								fabutime = fabutime.substring(0,10);
							}
							obj.put("fabu_time", fabutime);
						
							array.add(obj);
						}
						json.put("List", array);
						json.put("total", total);
						json.put("pageCount", pageCount);
						
					}
					

					else{
						List<NewsBoke> resultList=newsBokeList.subList(start, end);
						
						for(NewsBoke item : resultList){
							JSONObject obj = new JSONObject();
							obj.put("id", item.getId());
							obj.put("news_num", item.getNews_num());
							obj.put("news_people", item.getNews_people());
							obj.put("news_fenlei", item.getNews_fenlei());
							String abstractInfo = item.getNews_abstract();
							if(abstractInfo!=null && !"".equals(abstractInfo)){
								if(abstractInfo.length()>60){
								abstractInfo = abstractInfo.substring(0,60)+"...";
								}
							}
							obj.put("news_abstract", abstractInfo);
							obj.put("detail", item.getNews_detail());
							obj.put("image", item.getNews_image());
							obj.put("title", item.getNews_title());
							String newstime=item.getNews_time().toString();
							if(newstime!=null && !"".equals(newstime)){
								newstime = newstime.substring(0,10);
							}
							obj.put("newstime", newstime);
							array.add(obj);
						}
						json.put("List", array);
						json.put("total", total);
						json.put("pageCount", pageCount);
						
					}
				}
				try{
					writeJson(json.toJSONString(),resp);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			//特殊字符处理filter
			public String filter(String text){
				String theString = text.replace(">", "&gt;");  
		        theString = theString.replace("<", "&lt;");  
		        /*theString = theString.replace(" ", "&nbsp;");  */
		        /*theString = theString.replace("\"", "&quot;");  */
		       // theString = theString.replace("\'", "&#39;"); 
		        /*theString = theString.replace("��", "&quot;"); 
		        theString = theString.replace("��", "&quot;"); */
		        theString = theString.replace("\\", "\\\\");      //��б�ߵ�ת��  
		        theString = theString.replace("\n", "\\n");  
		        theString = theString.replace("\r", "\\r"); 
		        theString = theString.replace("\"", "\'"); 
		        return theString;
			}
			
			
			
			//返回json公用写方法
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
