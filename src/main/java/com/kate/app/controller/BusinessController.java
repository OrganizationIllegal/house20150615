package com.kate.app.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.BusinessDao;
import com.kate.app.dao.UserDao;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.User;

@Controller
public class BusinessController {
	@Autowired
	private BusinessDao businessDao;
	@Autowired
	private UserDao userDao;
	//商务合作页面的action
	@RequestMapping("/Business")
	public String Business(HttpServletRequest req,HttpServletResponse resp){
		String username = (String)req.getSession().getAttribute("username");
		List<User> userList=userDao.listUser(username);
		req.setAttribute("userList", userList);
		return "business.jsp";
	}
	//接收商务合作页面提交的表单数据的action
	@RequestMapping("/hezuoMessageSubmit")
	public void hezuoSubmit(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		String username = (String)req.getSession().getAttribute("username");
		String message_content=req.getParameter("message_content");
		String message_time = new java.sql.Timestamp(System.currentTimeMillis()).toString();
		String hezuo=req.getParameter("hezuo");
		
		int project_id=0;
		int viewed=0;
		int type=7;
		int result = 0;
		int userid=userDao.findUserByEmailAndTel(username);
		if(userid!=0){
			result=businessDao.InsertMessage(hezuo, message_content, message_time, project_id, viewed, type, userid);
		}
		req.setAttribute("result", result);
		/*List<BrokerInfo> brokerInfoList=brokerInfoDao.listBrokerInfo();
		List<User> userList=userDao.listUser(username);
		req.setAttribute("brokerInfoList", brokerInfoList);
		req.setAttribute("userList", userList);*/
		
		json.put("flag", result);
		try{
			 PrintWriter out = resp.getWriter();
			 out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		}
	}
	

}
