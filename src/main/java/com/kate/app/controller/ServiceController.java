package com.kate.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kate.app.dao.BrokerInfoDao;
import com.kate.app.dao.HouseProjectDao;
import com.kate.app.dao.UserDao;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.BrokerInfoQuyu;
import com.kate.app.model.User;

@Controller
public class ServiceController {
	@Autowired
	private HouseProjectDao houseProjectDao;
	@Autowired
	private BrokerInfoDao brokerInfoDao;
	@Autowired
	private UserDao userDao;
	
	
	@RequestMapping({"/Service"})
	public String Service(HttpServletRequest req,HttpServletResponse resp){
		//String projectId = req.getParameter("projectId");
		String brokerId_str = req.getParameter("brokerId");
		BrokerInfo brokerInfo = new BrokerInfo();
		int proId = 0;
		int brokerId = 0;
		
		if(brokerId_str!=null && !"".equals(brokerId_str)){
			brokerId = Integer.parseInt(brokerId_str);
		}
		BrokerInfoQuyu data = brokerInfoDao.getBrokerInfo(brokerId);
		String broker_num = brokerInfoDao.findBrokerInfo(brokerId);
		
		List<String> areaList = data.getAreaList();
		if(broker_num!=null && !"".equals(broker_num)){
			areaList = brokerInfoDao.fuwuArea(broker_num);
		}
//		List<String> areaList = data.getAreaList();
//		String result = "";
//		if(areaList!=null && areaList.size()>0){
//			for(String item : areaList){
//				
//			}
//		}
		String username = (String)req.getSession().getAttribute("username");
		List<User> userList=userDao.listUser(username);
	    req.setAttribute("userList", userList);

		req.setAttribute("brokerInfo", data);
		req.setAttribute("areaList", areaList);
		
		return "/Service.jsp";
	}
	
	
}
