package com.kate.app.controller;

import java.io.PrintWriter;
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
import com.kate.app.dao.AdDao;
import com.kate.app.dao.BrokerInfoDao;
import com.kate.app.dao.ProjectInputDao;
import com.kate.app.dao.UserDao;
import com.kate.app.model.AreaInfo;
import com.kate.app.model.Broker;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.BrokerServiceArea;
import com.kate.app.model.BrokerType;
import com.kate.app.model.ServiceArea;
import com.kate.app.model.User;

@Controller
public class BrokerInfoController {
	@Autowired
	private BrokerInfoDao brokerInfoDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ProjectInputDao projectInputDao;
	@Autowired
	private AdDao addao;
	//服务团队action
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
		req.setAttribute("ad", addao.getad4());
		return "/serviceTeam.jsp";
	}
	//服务团队分页
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
		
	//接收服务团队页面提交的留言
	@RequestMapping({"/MessageSubmit"})
	public void messageSubmit(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		String username = (String)req.getSession().getAttribute("username");
		//if(user==null)
		
		String message_content=req.getParameter("message_content");
		
		
		String message_time = new java.sql.Timestamp(System.currentTimeMillis()).toString();
		
		//String message_time=req.getParameter("message_time");
		//String message_time=Timestamp.parse(System.currentTimeMillis());
		int project_id=0;
		int viewed=0;
		int type=6;
		int result = 0;
		int userid=userDao.findUserByEmailAndTel(username);
		if(userid!=0){
			result=brokerInfoDao.InsertMessage(message_content, message_time, project_id, viewed, type, userid);
		}
		req.setAttribute("result", result);
		List<BrokerInfo> brokerInfoList=brokerInfoDao.listBrokerInfo();
		List<User> userList=userDao.listUser(username);
		req.setAttribute("brokerInfoList", brokerInfoList);
		req.setAttribute("userList", userList);
		
		json.put("flag", result);
		try{
			 PrintWriter out = resp.getWriter();
			 out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		}
		//return "/serviceTeam.jsp";
	}
	

/**
 *经纪人录入
 * @param req
 * @param resp
 */
		@RequestMapping({ "/AddBrokerInfo" })
		public void AddBrokerInfo(HttpServletRequest req, HttpServletResponse resp){
			JSONObject json=new JSONObject();
			String brokerlist=req.getParameter("brokerinfo");
			String arealist=req.getParameter("arealist");
			String intelist=req.getParameter("typelist");
			//经纪人信息
			JSONObject jsonobject = JSONObject.parseObject(brokerlist);
			Broker broker = (Broker) JSONToObj(jsonobject.toString(), Broker.class);
			//接收服务区域参数
			JSONArray areaArray = JSONArray.parseArray(arealist);
			List<ServiceArea> BrokerServicelist=new ArrayList<ServiceArea>();
			for (int i=0;i<areaArray.size();i++){
				 JSONObject object = (JSONObject)areaArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 ServiceArea e = (ServiceArea) JSONToObj(object.toString(), ServiceArea.class);
				 BrokerServicelist.add(e);
			}
			//接收擅长类型参数
			JSONArray inteArray = JSONArray.parseArray(intelist);
			List<BrokerType> BrokerTypelist=new ArrayList<BrokerType>();
			for (int i=0;i<inteArray.size();i++){
				 JSONObject object = (JSONObject)inteArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
				 BrokerType e = (BrokerType) JSONToObj(object.toString(), BrokerType.class);
				 BrokerTypelist.add(e);
			}
			int isDuplicate=brokerInfoDao.isDuplicate(broker.getBroker_num());
			if (isDuplicate==1) {
				json.put("isDuplicate", "1");
			}
			else{
				try {
					int result=projectInputDao.InsertBroker(broker,BrokerServicelist,BrokerTypelist);
					if(result==1){
						json.put("flag", "1");
					}
					else{
						json.put("flag", "0");
					}
					System.out.println("result::"+result);
			    } catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
