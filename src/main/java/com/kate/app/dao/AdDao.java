package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
@Repository 
public class AdDao extends BaseDao{
	//根据id查找第一个广告图片
	 public String getad1(){
		 String ad1="";
		 Statement stmt = null;
			ResultSet rs = null;
			try {
				String sql = "select adimage from ad where id=1";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				  if(rs.next()){
					  ad1=rs.getString(1);
				  }
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
	        }
			return ad1;
		} 
	//根据id查找第二个广告图片
	 public String getad2(){
		 String ad1="";
		 Statement stmt = null;
			ResultSet rs = null;
			try {
				String sql = "select adimage from ad where id=2";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				  if(rs.next()){
					  ad1=rs.getString(1);
				  }
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
	        }
			return ad1;
		}
	//根据id查找第三个广告图片
	 public String getad3(){
		 String ad1="";
		 Statement stmt = null;
			ResultSet rs = null;
			try {
				String sql = "select adimage from ad where id=3";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				  if(rs.next()){
					  ad1=rs.getString(1);
				  }
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
	        }
			return ad1;
		}
	//根据id查找第四个个广告图片
	 public String getad4(){
		 String ad1="";
		 Statement stmt = null;
			ResultSet rs = null;
			try {
				String sql = "select adimage from ad where id=4";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				  if(rs.next()){
					  ad1=rs.getString(1);
				  }
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
	        }
			return ad1;
		}
	 //更新第一个广告位
	 public int setad1(String ad1){
		 int result=0;
		 PreparedStatement stmt = null;
			ResultSet rs = null;
			try {//update coordinates set longitude=?,latitude=?,place=?,house_project_id=? where id=?
				String sql = "update ad set adimage=? where id=?";
				  stmt = con.prepareStatement(sql);
				  stmt.setString(1,ad1);
				  stmt.setInt(2, 1);
				  result = stmt.executeUpdate();
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
	        }
			return result;
		}
	//更新第二个广告位
	 public int setad2(String ad2){
		 int result=0;
		 PreparedStatement stmt = null;
			ResultSet rs = null;
			try {//update coordinates set longitude=?,latitude=?,place=?,house_project_id=? where id=?
				String sql = "update ad set adimage=? where id=?";
				  stmt = con.prepareStatement(sql);
				  stmt.setString(1,ad2);
				  stmt.setInt(2, 2);
				  result = stmt.executeUpdate();
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
	        }
			return result;
		}
	//更新第三个广告位
	 public int setad3(String ad3){
		 int result=0;
		 PreparedStatement stmt = null;
			ResultSet rs = null;
			try {//update coordinates set longitude=?,latitude=?,place=?,house_project_id=? where id=?
				String sql = "update ad set adimage=? where id=?";
				  stmt = con.prepareStatement(sql);
				  stmt.setString(1,ad3);
				  stmt.setInt(2, 3);
				  result = stmt.executeUpdate();
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
	        }
			return result;
		}
	//更新第四个广告位
	 public int setad4(String ad4){
		 int result=0;
		 PreparedStatement stmt = null;
			ResultSet rs = null;
			try {//update coordinates set longitude=?,latitude=?,place=?,house_project_id=? where id=?
				String sql = "update ad set adimage=? where id=?";
				  stmt = con.prepareStatement(sql);
				  stmt.setString(1,ad4);
				  stmt.setInt(2, 4);
				  result = stmt.executeUpdate();
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
	        }
			return result;
		}
}
