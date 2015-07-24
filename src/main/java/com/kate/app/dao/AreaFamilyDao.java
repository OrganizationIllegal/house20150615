package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.AreaFamily;

@Repository 
public class AreaFamilyDao extends BaseDao {
	public AreaFamily getAreaFamily(String area_code){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		AreaFamily data = null;
		try {
			String sql = " SELECT * from area_family where area_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_code);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				data = new AreaFamily();
				data.setArea_id(rs.getInt("area_id"));
				data.setData_souce(rs.getString("data_souce"));
				data.setFamily_one(rs.getString("family_one"));
				data.setFamily_one_rate(rs.getString("family_one_rate"));
				data.setFamily_two(rs.getString("family_two"));
				data.setFamily_two_rate(rs.getString("family_two_rate"));
				data.setFamily_three(rs.getString("family_three"));
				data.setFamily_three_rate(rs.getString("family_three_rate"));
				data.setId(rs.getInt("id"));
				data.setUpdate_time(rs.getTimestamp("update_time"));
				data.setFamily_datasource(rs.getString("family_datasource"));
				data.setFamily_date(rs.getTimestamp("family_date"));
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
		      if(pstmt != null){   // 关闭声明   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return data;
	}
	
	public int getdulirate(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int houseProId=1;
		int dulirate=0;
		try {
			String sql = " SELECT rate from area_family t where binary t.family_type='������ʿ'  AND t.house_pro_id="+houseProId;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				dulirate=rs.getInt("rate");
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
		      if(pstmt != null){   // 关闭声明   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return dulirate;
	}
	public int getyoungfamilyrate(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int houseProId=1;
		int youngfamilyrate=0;
		try {
			String sql = " SELECT rate from area_family t where binary t.family_type='�����ͥ'  AND t.house_pro_id="+houseProId;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				youngfamilyrate=rs.getInt("rate");
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
			      if(pstmt != null){   // 关闭声明   
				        try{   
				            pstmt.close() ;   
				        }catch(SQLException e){   
				            e.printStackTrace() ;   
				        }   
				     } 

	        }
		return youngfamilyrate;
	}
	public int getoldfamilyrate(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int houseProId=1;
		int oldfamilyrate=0;
		try {
			String sql = " SELECT rate from area_family t where binary t.family_type='�����ͥ'  AND t.house_pro_id="+houseProId;
			 stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				oldfamilyrate=rs.getInt("rate");
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
		      if(pstmt != null){   // 关闭声明   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return oldfamilyrate;
	}
	//��
	public int InsertAreaFamily(String family_one,String family_one_rate,String family_two,String family_two_rate,String family_three,String family_three_rate,String data_source,String update_time,String area_code){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {
			String sql = "insert into area_family(family_one,family_one_rate,family_two,family_two_rate,family_three,family_three_rate,data_souce,update_time,area_code) values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, family_one);
			pstmt.setString(2, family_one_rate);
			pstmt.setString(3, family_two);
			pstmt.setString(4, family_two_rate);
			pstmt.setString(5, family_three);
			pstmt.setString(6, family_three_rate);
			pstmt.setString(7, data_source);
			pstmt.setString(8, update_time);
			pstmt.setString(9, area_code);
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
	//ɾ
	public int delAreaFamily(int id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		int exeResult=0;
		try {
			String sql = "delete from area_family where id="+id;
			  stmt = con.createStatement();
			exeResult = stmt.executeUpdate(sql);
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
	//��
	public JSONArray listAreaFamily(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		JSONArray jsonArray=new JSONArray();
		try {
			String sql = " select * from area_family";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("family_one", rs.getString("family_one"));
				obj.put("family_one_rate", rs.getString("family_one_rate"));
				obj.put("family_two", rs.getString("family_two"));
				obj.put("family_two_rate", rs.getString("family_two_rate"));
				obj.put("family_three", rs.getString("family_three"));
				obj.put("family_three_rate", rs.getString("family_three_rate"));
				obj.put("data_souce", rs.getString("data_souce"));
				obj.put("area_code", rs.getString("area_code"));
				
				String update_time = null;
				Timestamp time=rs.getTimestamp("update_time");
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				if(time ==null){
					time= new Timestamp(System.currentTimeMillis());
				}
			    update_time=df.format(time);
				obj.put("update_time", update_time);
				jsonArray.add(obj);
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
	//��
	public int updateAreaFamily(int id,String family_one,String family_one_rate,String family_two,String family_two_rate,String family_three,String family_three_rate,String data_source,String update_time,String area_code){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {
			String sql = "update area_family set family_one=?,family_one_rate=?,family_two=?,family_two_rate=?,family_three=?,family_three_rate=?, data_souce=?,update_time=?,area_code=? where id="+id;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, family_one);
			pstmt.setString(2, family_one_rate);
			pstmt.setString(3, family_two);
			pstmt.setString(4, family_two_rate);
			pstmt.setString(5, family_three);
			pstmt.setString(6, family_three_rate);
			pstmt.setString(7, data_source);
			pstmt.setString(8, update_time);
			pstmt.setString(9, area_code);
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
	//�����Ŀ��Ʋ�����Ŀid
	public int findProjectIdByName(String project_name){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int project_id=0;
		try {
			String sql = "select t.id from house_project t where t.project_name="+"'"+project_name+"'";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				project_id=rs.getInt("id");
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
		      if(pstmt != null){   // 关闭声明   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return project_id;
	}
	public int findLatestId(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		int id=0;
		try {
			String sql = "SELECT LAST_INSERT_ID();";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				id=rs.getInt(0);
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
		      if(pstmt != null){   // 关闭声明   
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
