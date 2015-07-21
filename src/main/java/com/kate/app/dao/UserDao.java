package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.User;

@Repository 
public class UserDao extends BaseDao {
	public List<User> listUser(String username1){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<User> userList=new ArrayList<User>();
		try {
			String sql = "select t.pwd,t.email,t.tel,t.role,t.flag from user t where t.email=? or t.tel=?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username1);
			pstmt.setString(2, username1);
			  rs = pstmt.executeQuery();
		    String nick_name=null;
		    String pwd=null;
		    String email=null;
		    String tel=null;
		    int role=0;
		    int flag = 0;
		    while(rs.next()){
		    	nick_name=username1;
		    	pwd=rs.getString("pwd");
		    	email=rs.getString("email");
		    	tel=rs.getString("tel");
		    	role=Integer.parseInt(rs.getString("role"));
		    	flag=rs.getInt("flag");
		    	User user=new User(nick_name, pwd,email, tel, role,flag);
		    	userList.add(user);
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs != null){   // 鍏抽棴璁板綍闆�  
		        try{   
		            rs.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		          }   
		      if(stmt != null){   // 鍏抽棴澹版槑   
		        try{   
		            stmt.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		     } 
		      if(pstmt != null){   // 鍏抽棴澹版槑   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return userList;
	} 
	
	public int findUserByName(String username1){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int id = 0;
		try {
			//String sql = "select * from user  where nick_name=?";
			String sql = "select * from user  where email=?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username1);
			  rs = pstmt.executeQuery();
		    String nick_name=null;
		    String pwd=null;
		    String email=null;
		    String tel=null;
		    int role=0;
		    while(rs.next()){
		    	id = rs.getInt("id");
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs != null){   // 鍏抽棴璁板綍闆�  
		        try{   
		            rs.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		          }   
		      if(stmt != null){   // 鍏抽棴澹版槑   
		        try{   
		            stmt.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		     } 
		      if(pstmt != null){   // 鍏抽棴澹版槑   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }

		return id;
	} 

}
