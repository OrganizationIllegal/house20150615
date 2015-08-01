package com.kate.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kate.app.dao.HouseProjectDao;
import com.kate.app.dao.Index01Dao;
import com.kate.app.dao.ZhiYeDao;
import com.kate.app.model.HouseProject;
import com.kate.app.model.NewsBoke;
import com.kate.app.model.ProjectDescImage;

@Controller
public class Index01Controller {
	@Autowired
	private Index01Dao index01Dao;
	@Autowired
	private HouseProjectDao houseProjectDao;
	@Autowired
	private ZhiYeDao zhiYeDao;
	
	@RequestMapping({"/","/index01" })
	public String index01(HttpServletRequest req,HttpServletResponse resp){
		List<String> list = index01Dao.getTuijian();
		List<String> list2 = index01Dao.getTuijian2();
		List<NewsBoke> newsList = zhiYeDao.selectNewsBoke();
		List<HouseProject> projectList = new ArrayList<HouseProject>();
		List<HouseProject> projectList2 = new ArrayList<HouseProject>();
		List<ProjectDescImage> imageList1 = new ArrayList<ProjectDescImage>();
		List<ProjectDescImage> imageList2 = new ArrayList<ProjectDescImage>();
		
		for(String i : list){
			HouseProject pro = new HouseProject();
			String image = "";
			pro = houseProjectDao.HouseProjectByNumDao(i);
			imageList1 = houseProjectDao.HouseProjectImageList(i);
			if(imageList1!=null && imageList1.size()>0){
				image = imageList1.get(0).getName();
			}
			pro.setProject_img(image);
			if(pro!=null){
				projectList.add(pro);
			}
		}
		for(String j : list2){
			HouseProject pro2 = new HouseProject();
			String image1 = "";
			pro2 = houseProjectDao.HouseProjectByNumDao(j);
			imageList2 = houseProjectDao.HouseProjectImageList(j);
			if(imageList2!=null && imageList2.size()>0){
				image1 = imageList2.get(0).getName();
			}
			pro2.setProject_img(image1);
			if(pro2!=null){
				projectList2.add(pro2);
			}
		}
		if(newsList.size() > 3){
			newsList = newsList.subList(0, 3);
		}
		req.setAttribute("projectList", projectList);
		req.setAttribute("projectList2", projectList2);
		req.setAttribute("newsList",newsList);
		return "/Index.jsp";
	}
    
			
}
  	