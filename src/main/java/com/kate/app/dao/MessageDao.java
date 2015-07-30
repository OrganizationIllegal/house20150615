package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.MessageVo;


@Repository 
public class MessageDao extends BaseDao {
	@Autowired
	private HouseProjectDao houseProjectDao;
	public JSONArray getMessage(int type){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		JSONArray jsonArray=new JSONArray();
		List<MessageVo> messageList=new ArrayList<MessageVo>();
		try {
			String sql = "select t.id,t.hezuo,t.message_content,t.message_time,t.project_id,t.type,t.viewed ,u.nick_name,u.email,u.tel from message t join user u on t.userid=u.id  where t.type="+type;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			int id=0;
			String message_content=null;
			String message_content_short=null;
			/*Date message_time=null;*/
			String message_time=null;
			int project_id=0;
			/*int type=0;*/
			int viewed=0;
			String viewed_str=null;
			String nick_name=null;
			String email=null;
			String tel=null;
			String hezuo=null;
			
			while(rs.next()){
				JSONObject obj = new JSONObject();
				id=rs.getInt("id");
				message_content=rs.getString("message_content");
				message_content_short=message_content.length()>20?(message_content.substring(0, 20)+"..."):message_content;
				message_time=rs.getDate("message_time").toString();
				project_id=rs.getInt("project_id");
				String project_num=houseProjectDao.findProjectNumById(project_id);
				type=rs.getInt("type");
				viewed=rs.getInt("viewed");
				if(viewed==1){
					viewed_str="已看";
				}else{
					viewed_str="未看";
				}
				nick_name=rs.getString("nick_name");
				email=rs.getString("email");
				tel=rs.getString("tel");
				hezuo=rs.getString("hezuo");
				/*MessageVo messageVo=new MessageVo(id,message_content,message_time,project_id,project_num,viewed,type,nick_name,email,tel);
				messageList.add(messageVo);*/
				obj.put("id", id);
				obj.put("message_content", message_content);
				obj.put("message_content_short", message_content_short);
				obj.put("message_time", message_time);
				obj.put("project_id", project_id);
				obj.put("project_num", project_num);
				obj.put("viewed", viewed_str);
				obj.put("nick_name", nick_name);
				obj.put("email", email);
				obj.put("tel", tel);
				obj.put("hezuo", hezuo);
				jsonArray.add(obj);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
		return jsonArray;
	}
	public List<MessageVo> getMessagePrice(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<MessageVo> messageList=new ArrayList<MessageVo>();
		try {
			String sql = "select t.id,t.message_content,t.message_time,t.project_id,t.type,t.viewed ,u.nick_name,u.email,u.tel from message t join user u on t.userid=u.id  where t.type=1";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			int id=0;
			String message_content=null;
			Date message_time=null;
			int project_id=0;
			int type=0;
			int viewed=0;
			String nick_name=null;
			String email=null;
			String tel=null;
			while(rs.next()){
				id=rs.getInt("id");
				message_content=rs.getString("message_content");
				message_time=rs.getDate("message_time");
				project_id=rs.getInt("project_id");
				String project_num=houseProjectDao.findProjectNumById(project_id);
				type=rs.getInt("type");
				viewed=rs.getInt("viewed");
				nick_name=rs.getString("nick_name");
				email=rs.getString("email");
				tel=rs.getString("tel");
				MessageVo messageVo=new MessageVo(id,message_content,message_time,project_id,project_num,viewed,type,nick_name,email,tel);
				messageList.add(messageVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
		return messageList;
	}
	public List<MessageVo> getMessagLatestPrice(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<MessageVo> messageList=new ArrayList<MessageVo>();
		try {
			String sql = "select t.id,t.message_content,t.message_time,t.project_id,t.type,t.viewed ,u.nick_name,u.email,u.tel from message t join user u on t.userid=u.id  where t.type=3";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			int id=0;
			String message_content=null;
			Date message_time=null;
			int project_id=0;
			int type=0;
			int viewed=0;
			String nick_name=null;
			String email=null;
			String tel=null;
			while(rs.next()){
				id=rs.getInt("id");
				message_content=rs.getString("message_content");
				message_time=rs.getDate("message_time");
				project_id=rs.getInt("project_id");
				String project_num=houseProjectDao.findProjectNumById(project_id);
				type=rs.getInt("type");
				viewed=rs.getInt("viewed");
				nick_name=rs.getString("nick_name");
				email=rs.getString("email");
				tel=rs.getString("tel");
				MessageVo messageVo=new MessageVo(id,message_content,message_time,project_id,project_num,viewed,type,nick_name,email,tel);
				messageList.add(messageVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
		return messageList;
	}
	public boolean saveView(int id){   //0是未查看，1是已经查看
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		boolean flag = false;
		try{
			String sql = " update message set viewed=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, id);
			int result = pstmt.executeUpdate();
			if(result == 0){
				flag = false;
			}
		}catch (Exception e) {
            e.printStackTrace();
        }finally{
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
		return flag;
	}

}
