package com.kate.app.dao;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.User;

@Repository 
public class BusinessDao extends BaseDao {
	//
	public int InsertMessage(String hezuo,String message_content,String time,int project_id,int viewed,int type,int userid){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {
			String sql = "insert into message(message_content,message_time,project_id,viewed,type,userid,hezuo) values (?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, message_content);
			pstmt.setString(2, time);
			pstmt.setInt(3, project_id);
			pstmt.setInt(4, viewed);
			pstmt.setInt(5, type);
			pstmt.setInt(6, userid);
			pstmt.setString(7, hezuo);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs != null){   // 关闭记录集   
		        try{   
		            rs.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		          }   
		      if(stmt != null){   // 关闭声明   
		        try{   
		            stmt.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		     } 
		      if(pstmt != null){   // 关闭声明   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return exeResult;
		
	}
	
	
	/*@RequestMapping({"/MessageSubmit"})
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
	*/

	

}
