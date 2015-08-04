package com.kate.app.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.LineListener;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.ZhiYeDao;
import com.kate.app.model.MailSenderInfo;
import com.kate.app.model.NewsBoke;
import com.kate.app.model.SearchList;
import com.kate.app.model.ZhiYeZhiDao;

@Controller
public class DetailInfoController {
	@Autowired
	private ZhiYeDao zhiYeDao;
	
	private static final int PAGE_SIZE = 6;
	//置业指导详情和新闻详情的action
	@RequestMapping({"/Detail"})
	public String ZhiYeInfo(HttpServletRequest req, HttpServletResponse resp){
		String id = req.getParameter("id");
		String type = req.getParameter("type");   //0缃笟  1鏂伴椈鍗氬
		int idInfo = 0;
		ZhiYeZhiDao zhiYeDetail = null;
		NewsBoke newsBokeDetail = null;
		List<String> new_fenleiList = new ArrayList<String>();
		List<String> zhiye_fenleiList = new ArrayList<String>();
		
		if(id!=null && !"".equals(id)){
			idInfo = Integer.parseInt(id);
		}
		if(type.equals("0")){
			zhiYeDetail = zhiYeDao.selectZhiYeById(idInfo);
			zhiye_fenleiList = zhiYeDao.zhiYeFenlei();
		}
		else{
			newsBokeDetail = zhiYeDao.selectNewsBokeById(idInfo);
			new_fenleiList = zhiYeDao.newsBokeFenlei();
		}
		List<ZhiYeZhiDao> zhiYeList=zhiYeDao.selectZhiYe();   //寰楀埌鎵�湁鐨勪俊鎭紝鎸夋椂闂存帓搴�
		List<NewsBoke> newsList = zhiYeDao.selectNewsBoke();
		List<ZhiYeZhiDao> lastestList = new ArrayList<ZhiYeZhiDao>();
		/*if(zhiYeList!=null){
			
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
		
		req.setAttribute("type",type);
		req.setAttribute("zhiye_fenleiList",zhiye_fenleiList);
		req.setAttribute("new_fenleiList",new_fenleiList);
		req.setAttribute("zhiYeDetail",zhiYeDetail);
		req.setAttribute("newsBokeDetail",newsBokeDetail);
		req.setAttribute("lastestList",lastestList);
		req.setAttribute("newsList",newsList);
		return "/news_blog.jsp";
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
