package com.kate.app.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.AjaxDao;
import com.kate.app.dao.BrokerInfoDao;
import com.kate.app.dao.ImageDao;
import com.kate.app.dao.InvestDataDao;
import com.kate.app.dao.MiddlePriceDao;
import com.kate.app.dao.NewsBokeDao;
import com.kate.app.dao.RecoProjectDao;
import com.kate.app.dao.UserDao;
import com.kate.app.dao.UtilDao;
import com.kate.app.service.AreaFamilyService;
import com.kate.app.service.AreaFeatureService;
import com.kate.app.service.AreaInfoService;
import com.kate.app.service.AreaTrendService;
import com.kate.app.service.BuyInfoService;
import com.kate.app.service.HouseInfoService;
import com.kate.app.service.HouseProjectService;
import com.kate.app.service.HouseTaxService;
import com.kate.app.service.LatestSaleInfoListService;
import com.kate.app.service.MyService;
import com.kate.app.service.NewsInfoService;
import com.kate.app.service.PeopleInfoService;
import com.kate.app.service.RecoProjectSerivice;
import com.kate.app.service.SchoolNearService;

@Controller
public class ProjectInputController {
	@Autowired
	private MyService myService;
	@Autowired
	private MiddlePriceDao middlePriceDao;
	@Autowired
	private InvestDataDao investDataDao;
	@Autowired
	private RecoProjectDao recoProjectDao;
	@Autowired
	private AjaxDao ajaxDao;
	@Autowired
	private UtilDao utilDao;
	@Autowired
	private NewsInfoService newsInfoService;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BrokerInfoDao brokerInfoDao;
	
	@Autowired
	private HouseProjectService houseProjectService;
	@Autowired
	private AreaFamilyService areaFamilyService;
	@Autowired
	private AreaFeatureService areaFeatureService;
	@Autowired
	private AreaTrendService  areaTrendService;
	@Autowired
	private AreaInfoService  areaInfoService;
	@Autowired
	private LatestSaleInfoListService  latestSaleInfoListService;
	@Autowired
	private SchoolNearService  schoolNearService;
	@Autowired
	private HouseTaxService  houseTaxService;
	@Autowired
	private PeopleInfoService peopleInfoService;
	@Autowired
	private HouseInfoService houseInfoService;
	@Autowired
	private BuyInfoService buyInfoService;
	@Autowired
	private RecoProjectSerivice recoprojectserivice;
	@Autowired
	private NewsBokeDao newsBokeDao;
	
	
	
	@RequestMapping({ "/pinput" })
	public String Index(HttpServletRequest req, HttpServletResponse resp){
		MultipartHttpServletRequest mRequest=(MultipartHttpServletRequest)req;
		String username = (String)req.getSession().getAttribute("username");
		/*String  = req.getParameter("projectimage");*/
			
		 return "/ProjectIndex.jsp";
	}
	
	@RequestMapping(value = "/projectinput")
    public void handleFormUpload(
            @RequestParam("file") MultipartFile file, HttpServletResponse resp) {
		JSONObject json = new JSONObject();
		json.put("total", 1);
		json.put("rows", 1);
		
        if (!file.isEmpty()) {
//            byte[] bytes = file.getBytes();
            // store the bytes somewhere
//        	file.
        	try{
        		/*for(int i=0;i<file.length;i++){*/
        			ImageDao.CopyImage(file,new String(file.getOriginalFilename().getBytes("ISO8859_1"),"utf-8"));
        		/*}*/
        		
        		/*System.out.println(new String(file.getOriginalFilename().getBytes("utf-8"),"utf-8"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("utf-8"),"GBK"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("utf-8"),"gb2312"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("utf-8"),"iso-8859-1"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("GBK"),"utf-8"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("GBK"),"GBK"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("GBK"),"gb2312"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("GBK"),"iso-8859-1"));
        		System.out.println(new String(file.getOriginalFilename().getBytes(),"utf-8"));
        		System.out.println(new String(file.getOriginalFilename().getBytes(),"GBK"));
        		System.out.println(new String(file.getOriginalFilename().getBytes(),"gb2312"));
        		System.out.println(new String(file.getOriginalFilename().getBytes(),"iso-8859-1"));
        		System.out.println(new String(file.getOriginalFilename().getBytes("GBK"),"iso-8859-1"));
        		System.out.println(new String(file.getOriginalFilename().getBytes()));
        		System.out.println(new String(file.getOriginalFilename().getBytes()));
        		System.out.println(new String(file.getOriginalFilename().getBytes()));*/
//        		System.out.println(new String(file.getOriginalFilename().getBytes("ISO8859_1"),"utf-8"));
        		/*System.out.println("中文");

                System.out.println("中文".getBytes());

                System.out.println("中文".getBytes("GB2312"));

                System.out.println("中文".getBytes("ISO8859_1"));

                System.out.println(new String("中文".getBytes()));

                System.out.println(new String("中文".getBytes(), "GB2312"));

                System.out.println(new String("中文".getBytes(), "ISO8859_1"));

                System.out.println(new String("中文".getBytes("GB2312")));

                System.out.println(new String("中文".getBytes("GB2312"), "GB2312"));

                System.out.println(new String("中文".getBytes("GB2312"), "ISO8859_1"));

                System.out.println(new String("中文".getBytes("ISO8859_1")));

                System.out.println(new String("中文".getBytes("ISO8859_1"), "GB2312"));

                System.out.println(new String("中文".getBytes("ISO8859_1"), "ISO8859_1"));*/
        	}
        	catch(Exception e){
        		e.printStackTrace();
        	}
        	try{
    			writeJson(json.toJSONString(),resp);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
            //return "redirect:uploadSuccess";
        }
        
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
        //return "redirect:uploadFailure";
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
