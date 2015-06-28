package com.kate.app.controller;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.BrokerInfoDao;
import com.kate.app.dao.UserDao;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.BrokerIntegerType;
import com.kate.app.model.BrokerServiceArea;
import com.kate.app.model.User;

@Controller
public class BrokerInfoController {
	@Autowired
	private BrokerInfoDao brokerInfoDao;
	@Autowired
	private UserDao userDao;
	
	@RequestMapping({"/ServiceTeam"})
	public String listBingMap(HttpServletRequest req,HttpServletResponse resp){
		List<BrokerInfo> brokerInfoList=brokerInfoDao.listBrokerInfo();
		String username = (String)req.getSession().getAttribute("username");
		//if(user==null)
		/*if(username==null||"".equals(username) ){
			req.setAttribute("error", 1);
			return "/QuanxianError.jsp";
		}*/
		List<String> typeList=brokerInfoDao.getBrokerTypeList();
		List<String> regionList=brokerInfoDao.getBrokerRegionList();
		Set<String> languageList=brokerInfoDao.getBrokerLanguageList();
		req.setAttribute("typeList", typeList);
		req.setAttribute("regionList", regionList);
		req.setAttribute("languageList", languageList);
		List<User> userList=userDao.listUser(username);
		req.setAttribute("brokerInfoList", brokerInfoList);
		req.setAttribute("userList", userList);
		
		return "/serviceTeam.jsp";
	}
	//鏈嶅姟鍥㈤槦鍒嗛〉
		@RequestMapping({"/brokerinfoPage1"})
		public void BrokerListPage(HttpServletRequest req, HttpServletResponse resp){
			String pageIndex = req.getParameter("pageIndex");   //閿熸枻鎷峰墠椤甸敓鏂ゆ嫹
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //姣忛〉閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
			int pageSize  = pageSize_str==null? 4 :Integer.parseInt(pageSize_str);//榛樿姣忛〉4鏉¤褰�
			
			
			List<BrokerInfo> brokerList=brokerInfoDao.listBrokerInfo();
			
			int total = brokerList.size();
			int pageEnd = pageNum * pageSize;
			int end = pageEnd < total ? pageEnd : total;
			
			int start = (pageNum-1) * pageSize;
			int pageStart = start == pageEnd ? 0 : start;
			
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			if(pageStart <= end){
				List<BrokerInfo> resultList=brokerList.subList(start, end);
				for(BrokerInfo item : resultList){
					JSONObject obj = new JSONObject();
					obj.put("id", item.getId());
					obj.put("broker_img", item.getBroker_img());
					obj.put("broker_language", item.getBroker_language());
					obj.put("broker_name", item.getBroker_name());
					obj.put("broker_region", item.getBroker_region());
					obj.put("office", item.getOffice());
					obj.put("introduction", item.getIntroduction());
					obj.put("broker_num", item.getBroker_num());
					obj.put("broker_experience", item.getBroker_experience());
					obj.put("broker_type", item.getBroker_type());
					obj.put("broker_zizhi", item.getBroker_zizhi());
					array.add(obj);
				}
				json.put("List", array);
				json.put("total", pageEnd-1);
			}
			else{
				json.put("List", array);
				json.put("total", pageEnd-1);
			}
			
			
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	//鐐瑰嚮鎻愪氦锛屾彁浜ょ暀瑷�
	@RequestMapping({"/ServiceTeam/MessageSubmit"})
	public String messageSubmit(HttpServletRequest req,HttpServletResponse resp){
		String username = (String)req.getSession().getAttribute("username");
		//if(user==null)
		
		String message_content=req.getParameter("message_content");
		
		
		String message_time = new java.sql.Timestamp(System.currentTimeMillis()).toString();
		
		//String message_time=req.getParameter("message_time");
		//String message_time=Timestamp.parse(System.currentTimeMillis());
		int project_id=0;
		int viewed=0;
		int type=1;
		int result = 0;
		int userid=userDao.findUserByName(username);
		if(userid!=0){
			result=brokerInfoDao.InsertMessage(message_content, message_time, project_id, viewed, type, userid);
		}
		req.setAttribute("result", result);
		List<BrokerInfo> brokerInfoList=brokerInfoDao.listBrokerInfo();
		List<User> userList=userDao.listUser(username);
		req.setAttribute("brokerInfoList", brokerInfoList);
		req.setAttribute("userList", userList);
		return "/serviceTeam.jsp";
	}
	

	//娣诲姞椤圭洰
		@RequestMapping({ "/AddBrokerInfo" })
		public void AddBrokerInfo(HttpServletRequest req, HttpServletResponse resp){
			String brokerlist=req.getParameter("brokerinfo");
			String arealist=req.getParameter("arealist");
			String intelist=req.getParameter("typelist");
			
			JSONArray brokerArray = JSONArray.parseArray(brokerlist);
			List<BrokerInfo> brokersList=new ArrayList<BrokerInfo>();
			for (int i=0;i<brokerArray.size();i++){
				 JSONObject object = (JSONObject)brokerArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 BrokerInfo e = (BrokerInfo) JSONToObj(object.toString(), BrokerInfo.class);
				 brokersList.add(e);
			}
			System.out.println("brokersList.length():"+brokersList.size());
			
			
			JSONArray areaArray = JSONArray.parseArray(arealist);
			List<BrokerServiceArea> BrokerServicelist=new ArrayList<BrokerServiceArea>();
			for (int i=0;i<areaArray.size();i++){
				 JSONObject object = (JSONObject)areaArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 BrokerServiceArea e = (BrokerServiceArea) JSONToObj(object.toString(), BrokerServiceArea.class);
				 BrokerServicelist.add(e);
			}
			System.out.println("BrokerServicelist.length():"+BrokerServicelist.size());
			
			JSONArray inteArray = JSONArray.parseArray(intelist);
			List<BrokerIntegerType> BrokerTypelist=new ArrayList<BrokerIntegerType>();
			for (int i=0;i<inteArray.size();i++){
				 JSONObject object = (JSONObject)inteArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 BrokerIntegerType e = (BrokerIntegerType) JSONToObj(object.toString(), BrokerIntegerType.class);
				 BrokerTypelist.add(e);
			}
			System.out.println("BrokerTypelist.length():"+BrokerTypelist.size());
			
			
		    /*try {
				//int result=projectInputDao.AddProject(projectlist);
				//System.out.println("result::"+result);
		    } catch (SQLException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}*/
		    
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
	//灏唈sons
		 public static<T> Object JSONToObj(String jsonStr,Class<T> obj) {
		        T t = null;
		        try {
		            ObjectMapper objectMapper = new ObjectMapper();
		            t = objectMapper.readValue(jsonStr,
		                    obj);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return t;
		    }
}
