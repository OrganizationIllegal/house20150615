package com.kate.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.WriteAbortedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.AreaFamilyDao;
import com.kate.app.dao.AreaFeatureDao;
import com.kate.app.dao.AreaPeopleDao;
import com.kate.app.dao.AreaTrendDao;
import com.kate.app.dao.CoordinatesDao;
import com.kate.app.dao.HouseTaxDao;
import com.kate.app.dao.LatestSaleInfoListDao;
import com.kate.app.dao.NewsBokeDao;
import com.kate.app.dao.RegionPeopleDao;
import com.kate.app.dao.SchoolInfoDao;
import com.kate.app.dao.SchoolNearDao;
import com.kate.app.model.MyTimerTask;
import com.kate.app.service.AreaFamilyService;
import com.kate.app.service.SuggestionService;

@Controller
public class SuggestionController {
	@Autowired
	private AreaFamilyDao areaFamilyDao;
	@Autowired
	private AreaFamilyService areaFamilyService;
	@Autowired
	private RegionPeopleDao regionPeopleDao;
	@Autowired
	private AreaFeatureDao areaFeatureDao;
	@Autowired
	private LatestSaleInfoListDao latestSaleInfoListDao;
	@Autowired
	private AreaTrendDao areaTrendDao;
	@Autowired
	private HouseTaxDao houseTaxDao;
	@Autowired
	private SchoolNearDao schoolNearDao;
	@Autowired
	private CoordinatesDao coordinatesDao;
	@Autowired
	private AreaPeopleDao areaPeopleDao;
	@Autowired
	private SchoolInfoDao schoolInfoDao;
	@Autowired
	private NewsBokeDao newsBokeDao;
	@Autowired
	private SuggestionService suggestionService;
	//����Ա   �����ͥ�������  �б�
	@RequestMapping({"/getSuggestion"})
	public void  getSuggestion(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String query = req.getParameter("query");
		JSONObject json = new JSONObject();
		List <String> array = new ArrayList<String>();
		Timer timer=new Timer();
	      //五秒后调用RunTest()这个类，并执行run()方法
	      timer.schedule(new MyTimerTask(),86400000);
		
		array = suggestionService.getSuggestion(query);
		
		json.put("list", array);
		json.put("success", true);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping({"/getSuggestionRecommend"})
	public void  getSuggestionRecommend(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String query = req.getParameter("query");
		JSONObject json = new JSONObject();
		List <String> array = new ArrayList<String>();
		array = suggestionService.getSuggestionReco();
		if(array.size()<=0 || array==null){
			array = null;
		}else if(array.size()>10){
			array = array.subList(0, 10);
		}
		json.put("list", array);
		json.put("success", true);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({"/getSuggestionMap"})
	public void  getSuggestionMap(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String query = req.getParameter("query");
		JSONObject json = new JSONObject();
		List <String> array = new ArrayList<String>();
		suggestionService.writeFileByMap();
		array = suggestionService.getSuggestionMap(query);
		if(array.size()<=0 || array==null){
			array = null;
		}else if(array.size()>10){
			array = array.subList(0, 10);
		}
		json.put("list", array);
		json.put("success", true);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({"/getSuggestionFuwu"})
	public void  getSuggestionFuwu(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String query = req.getParameter("query");
		JSONObject json = new JSONObject();
		List <String> array = new ArrayList<String>();
		suggestionService.writeFileByFuwu();
		array = suggestionService.getSuggestionFuwu(query);
		if(array.size()<=0 || array==null){
			array = null;
		}else if(array.size()>10){
			array = array.subList(0, 10);
		}
		json.put("list", array);
		json.put("success", true);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({"/getSuggestionSuozai"})
	public void  getSuggestionSuozai(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String query = req.getParameter("query");
		JSONObject json = new JSONObject();
		List <String> array = new ArrayList<String>();
		suggestionService.writeFileBySuozai();
		array = suggestionService.getSuggestionSuozai(query);
		if(array.size()<=0 || array==null){
			array = null;
		}else if(array.size()>10){
			array = array.subList(0, 10);
		}
		json.put("list", array);
		json.put("success", true);
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

	/*class Task　extends TimerTask{
		public void　run(){
			suggestionService.writeFileByName();
		}
	}*/
}
