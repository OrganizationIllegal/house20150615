package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
@Repository 
public class CoordinatesDao extends BaseDao{
	 public JSONArray listCoordinates(){
		 try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			JSONArray jsonArray=new JSONArray();
			try {
				String sql = "select t.id,t.longitude,t.latitude,t.place,t.house_project_id,h.project_name from coordinates t join house_project h on t.house_project_id=h.id";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				jsonArray=ResultSetConverter.convert(rs);
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
			return jsonArray;
		} 
	 public int InsertCoordinates(float longitude,float latitude,String place,int house_pro_id){
		 try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
		 int exeResult=0;
			try {
				String sql = "insert into coordinates(longitude,latitude,place,house_project_id) values(?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setFloat(1, longitude);
				pstmt.setFloat(2, latitude);
				pstmt.setString(3, place);
				pstmt.setInt(4, house_pro_id);
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
	 public int updateCoordinates(int id,float longitude,float latitude,String place,int house_pro_id){
		 try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;

		 int exeResult=0;
			try {
				String sql = "update coordinates set longitude=?,latitude=?,place=?,house_project_id=? where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setFloat(1, longitude);
				pstmt.setFloat(2, latitude);
				pstmt.setString(3, place);
				pstmt.setInt(4, house_pro_id);
				pstmt.setInt(5, id);
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
	 public int delCoordinates(int id){
		 try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			int exeResult=0;
			try {
				String sql = "delete from coordinates where id="+id;
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
