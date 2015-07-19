package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;

@Repository 
public class AreaPeopleDao extends BaseDao{
	//区域人口分布 List
	  public JSONArray listAreapeople(){
		  try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			JSONArray jsonArray=new JSONArray();
			try {
				String sql = "select * from area_people t;";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				jsonArray=ResultSetConverter.convert(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
	            if(con != null){  
	                try {  
	                    con.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }
			return jsonArray;
		} 
	//区域人口分布Add
	 public int InsertAreaPeople(String column1, String column2, String column3,int view_shunxu,String area_code){
		 try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
		 int exeResult=0;
			try {
				String sql = "insert into area_people(column1,column2,column3,view_shunxu,area_code) values(?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, column1);
				pstmt.setString(2, column2);
				pstmt.setString(3, column3);
				pstmt.setInt(4, view_shunxu);
				pstmt.setString(5, area_code);
				exeResult = pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{  
	            if(pstmt != null){  
	                try {  
	                	pstmt.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if(con != null){  
	                try {  
	                    con.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }
			return exeResult;
		}  
	//中位数房价走势 update
	 public int updateAreaPeople(int id,String column1, String column2, String column3,int view_shunxu,String area_code){
		 try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
		 int exeResult=0;
			try {
				String sql = "update area_people set column1=?,column2=?,column3=?,view_shunxu=?,area_code=? where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, column1);
				pstmt.setString(2, column2);
				pstmt.setString(3, column3);
				pstmt.setInt(4, view_shunxu);
				pstmt.setString(5, area_code);
				pstmt.setInt(6, id);
				exeResult = pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{  
	            if(pstmt != null){  
	                try {  
	                	pstmt.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if(con != null){  
	                try {  
	                    con.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }
			return exeResult;
		}
	//中位数房价走势 delete
	 public int delAreaPeople(int id){
		 try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			int exeResult=0;
			try {
				String sql = "delete from area_people where id="+id;
				Statement stmt = con.createStatement();
				exeResult = stmt.executeUpdate(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{  
	            if(pstmt != null){  
	                try {  
	                	pstmt.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if(con != null){  
	                try {  
	                    con.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }
			return exeResult;
		}
}
