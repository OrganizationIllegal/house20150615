package com.kate.app.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.UserInfoDao;
import com.kate.app.model.User;
import com.kate.app.service.SendMailService;

@Controller
public class EmailController {
	@Autowired
	private SendMailService sendMailService;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	//放松忘记密码的邮件
	@RequestMapping({"/sendEmail"})
	public void sendEmail(HttpServletRequest req, HttpServletResponse resp){
		String userEmail = req.getParameter("userEmail");
		List<User> list = new ArrayList<User>();
		JSONObject json = new JSONObject();
		if(userEmail.equals("") || userEmail == null){
			json.put("flag", -1);
		}
		else if(isEmail(userEmail)){
			try{
				list = userInfoDao.judgeEmail(userEmail);
				if(list.size() > 0){     //邮箱存在
					String password = list.get(0).getPwd();
					json.put("flag", 1);
					sendMailService.sendMail(password, userEmail);
				}
				else{
					json.put("flag", -1);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else{
			json.put("flag", -1);
		}
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
	
	public boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
		} 
}