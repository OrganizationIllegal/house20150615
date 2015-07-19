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
import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.HouseInfo;
import com.kate.app.model.HouseProject;


	@Repository 
	public class HouseTypeCRUDDao extends BaseDao{
		public JSONArray select(){
			try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			JSONArray jsonArray = new JSONArray();
			List<HouseInfo> list = new ArrayList<HouseInfo>();
			try{
				String sql = " select * from house_info";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					JSONObject json = new JSONObject();
					json.put("id", rs.getInt("id"));
					json.put("house_type", rs.getString("house_type"));
					json.put("house_room_num", rs.getInt("house_room_num"));
					json.put("house_toilet_num", rs.getInt("house_toilet_num"));
					json.put("house_size", rs.getInt("house_size"));
					json.put("house_price", rs.getInt("house_price"));
					json.put("house_img", rs.getString("house_img"));
					jsonArray.add(json);
				}
			}catch (Exception e) {
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
		
			public int count(){
				try{
					con = DriverManager.getConnection(url, username, password);
				}catch(Exception e){
					e.printStackTrace();
				}
				PreparedStatement pstmt = null;
				int count = 0;
				try{
					String sql = " select count(*) from house_info";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						count = rs.getInt(1);
					}
				}catch (Exception e) {
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
				return count;
			}
			
			
		public boolean addData(int proid,String type, int roomnum, int toiletnum, int size, int price, String img) throws SQLException{
			try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			boolean flag = true;
			
			try{
				String sql = " insert into house_info(house_type, house_room_num, house_toilet_num, house_size, house_price, house_img,house_project_id) values(?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, type);
				pstmt.setInt(2, roomnum);
				pstmt.setInt(3, toiletnum);
				pstmt.setInt(4, size);
				pstmt.setInt(5, price);
				pstmt.setString(6, img);
				pstmt.setInt(7, proid);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }finally{  
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
			return flag;
	        
		}
		
		public boolean editData(int id,String type, int roomnum, int toiletnum, int size, int price, String img) throws SQLException{
			try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			boolean flag = true;
			try{
				String sql = " update house_info house_type=?, house_room_num=?, house_toilet_num=?, house_size=?, house_price=?, house_img=? where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, type);
				pstmt.setInt(2, roomnum);
				pstmt.setInt(3, toiletnum);
				pstmt.setInt(4, size);
				pstmt.setInt(5, price);
				pstmt.setString(6, img);
				pstmt.setInt(7, id);
				
				
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }finally{  
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
			return flag;
	        
		}
		
		public boolean deleteData(int id){
			try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			boolean flag = true;
			try{
				String sql = " delete from house_info where id= ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }finally{  
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
			return flag;
	        
		}
		
		public boolean findById(int id){
			try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			boolean flag = false;
			try{
				String sql = " select count(*) from house_info where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()){
					flag = true;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }finally{  
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
			
			return flag;
	        
		}
		
		public int findProByName(String name) throws SQLException{   //�����Ŀ��Ʋ���
			try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			HouseProject projectInfo = new HouseProject();
			try{
				String sql = " select id from house_project where project_name= ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					projectInfo.setId(rs.getInt("id"));
				}
				
			}catch (Exception e) {
	            e.printStackTrace();
	        }finally{  
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
			return projectInfo.getId();
	        
		}
		
		
		
}
