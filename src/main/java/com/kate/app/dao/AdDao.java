package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
@Repository 
public class AdDao extends BaseDao{
	//根据id查找第一个广告图片
	 public List<String> getad1(){
		 List<String> rl=new ArrayList<String>();
		 Statement stmt = null;
			ResultSet rs = null;
			try {
				String sql = "select adimage,href from ad where id=1";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				  if(rs.next()){
					  rl.add(rs.getString(1));
					  rl.add(rs.getString(2));
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
			return rl;
		} 
	//根据id查找第二个广告图片
	 public List<String> getad2(){
		 List<String> rl=new ArrayList<String>();
		 Statement stmt = null;
			ResultSet rs = null;
			try {
				String sql = "select adimage,href from ad where id=2";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				  if(rs.next()){
					  rl.add(rs.getString(1));
					  rl.add(rs.getString(2));
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
			return rl;
		}
	//根据id查找第三个广告图片
	 public List<String> getad3(){
		 List<String> rl=new ArrayList<String>();
		 Statement stmt = null;
			ResultSet rs = null;
			try {
				String sql = "select adimage,href from ad where id=3";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				  if(rs.next()){
					  rl.add(rs.getString(1));
					  rl.add(rs.getString(2));
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
			return rl;
		}
	//根据id查找第四个个广告图片
	 public List<String> getad4(){
		 List<String> rl=new ArrayList<String>();
		 Statement stmt = null;
			ResultSet rs = null;
			try {
				String sql = "select adimage,href from ad where id=4";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				  if(rs.next()){
					  rl.add(rs.getString(1));
					  rl.add(rs.getString(2));
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
			return rl;
		}
	 //更新第一个广告位
	 public int setad1(String ad1,String href){
		 int result=0;
		 PreparedStatement stmt = null;
			ResultSet rs = null;
			try {//update coordinates set longitude=?,latitude=?,place=?,house_project_id=? where id=?
				String sql = "update ad set adimage=?,href=? where id=?";
				  stmt = con.prepareStatement(sql);
				  stmt.setString(1,ad1);
				  stmt.setString(2,href);
				  stmt.setInt(3, 1);
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
	 public int setad2(String ad2,String href){
		 int result=0;
		 PreparedStatement stmt = null;
			ResultSet rs = null;
			try {//update coordinates set longitude=?,latitude=?,place=?,house_project_id=? where id=?
				String sql = "update ad set adimage=?,href=? where id=?";
				  stmt = con.prepareStatement(sql);
				  stmt.setString(1,ad2);
				  stmt.setString(2,href);
				  stmt.setInt(3, 2);
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
	 public int setad3(String ad3,String href){
		 int result=0;
		 PreparedStatement stmt = null;
			ResultSet rs = null;
			try {//update coordinates set longitude=?,latitude=?,place=?,house_project_id=? where id=?
				String sql = "update ad set adimage=?,href=? where id=?";
				  stmt = con.prepareStatement(sql);
				  stmt.setString(1,ad3);
				  stmt.setString(2,href);
				  stmt.setInt(3, 3);
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
	 public int setad4(String ad4,String href){
		 int result=0;
		 PreparedStatement stmt = null;
			ResultSet rs = null;
			try {//update coordinates set longitude=?,latitude=?,place=?,house_project_id=? where id=?
				String sql = "update ad set adimage=?,href=? where id=?";
				  stmt = con.prepareStatement(sql);
				  stmt.setString(1,ad4);
				  stmt.setString(2,href);
				  stmt.setInt(3, 4);
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
