package com.kate.app.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.AjaxDao;
import com.kate.app.dao.AreaInfoDao;
import com.kate.app.model.AreaInfo;
import com.kate.app.model.AreaTeDian;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.DeveloperInfo;
import com.kate.app.model.HoldingTaxVo;
import com.kate.app.model.HouseInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.HouseTaxVo;
import com.kate.app.model.InvestmentData;
import com.kate.app.model.MailInfo;
import com.kate.app.model.NewsInfo;
import com.kate.app.model.RecoProject;
import com.kate.app.model.SendMail;

@Service
public class SendMailService {
	public void  sendMail(String password, String userEmail){
		MailInfo mailinfo=new MailInfo();  
	    //--设置邮件服务器开始  
	    mailinfo.setMailServerHost("smtp.126.com");  
	    mailinfo.setMailServerPort("25");  
	    mailinfo.setValidate(true);  
	    mailinfo.setUserName("yu_jie_lei");  
	    mailinfo.setPassword("59021566");  
	    //--设置邮件服务器结束  
	    mailinfo.setFromAddress("yu_jie_lei@126.com");    //邮件发送者的地址  
	    //设置接受用户  
	    String []ToAddress={userEmail};  
	    mailinfo.setToAddress(ToAddress);  
	    //设置附件  
	    //String []attach={"F:\\login.properties"};  
	    //mailinfo.setAttachFileNames(attach);  
	    mailinfo.setSubject("-----邮件测试----");  
	    mailinfo.setContent("您的密码是：<a href='#'>"+password+"</a> 请您记住！");//网页内容  
	    SendMail sm=new SendMail();  
	    if(sm.sendAttach(mailinfo))  
	        System.out.println("邮件发送成功");  
	    else  
	        System.out.println("邮件发送失败");  
	 } 
}

