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
import com.kate.app.model.NearPeiTao;
import com.kate.app.model.NearSchool;

@Repository 
public class SchoolNearDao extends BaseDao {
	public List<NearSchool> getNearSchoolInfo(String proNum){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<NearSchool> list=new ArrayList<NearSchool>();
		try {
			String sql = "select t.id,t.school_name,t.school_distance,s.school_type from near_school t INNER JOIN school_info s  on t.school_name=s.school_name  where project_num = ?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, proNum);
			  rs = pstmt.executeQuery();
			
			while(rs.next()){
				NearSchool data = new NearSchool();
				data.setId(rs.getInt("id"));
				data.setSchool_name(rs.getString("school_name"));
				data.setSchool_distance(rs.getInt("school_distance"));
				data.setSchool_type(rs.getString("school_type"));
				list.add(data);
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
		return list;
	}
	
	
	public List<NearSchool> getNearSchoolInfoNew(String proNum){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<NearSchool> list=new ArrayList<NearSchool>();
		try {
			String sql = "select * from near_school where project_num = ?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, proNum);
			  rs = pstmt.executeQuery();
			
			while(rs.next()){
				NearSchool data = new NearSchool();
				data.setId(rs.getInt("id"));
				data.setSchool_name(rs.getString("school_name"));
				data.setSchool_distance(rs.getInt("school_distance"));
				
				list.add(data);
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
		return list;
	}
	
	public String getNearSchoolInfoByType(String schoolName){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String schoolType="";
		try {
			String sql = "select school_type from school_info where school_name = ?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, schoolName);
			  rs = pstmt.executeQuery();
			
			while(rs.next()){
				schoolType = rs.getString("school_type");
				
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
		return schoolType;
	}
	public List<NearPeiTao> getNearSchoolFacilityInfo(String proNum){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;


		List<NearPeiTao> list=new ArrayList<NearPeiTao>();
		
		try {
			String sql = "select * from near_peitao where project_num = ?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, proNum);
			  rs = pstmt.executeQuery();
			
			while(rs.next()){
				NearPeiTao data = new NearPeiTao();
				data.setId(rs.getInt("id"));
				data.setMarket_distance(rs.getString("market_distance"));
				data.setMarket_name(rs.getString("market_name"));
				data.setMarket_type(rs.getString("market_type"));
				list.add(data);
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
		return list;
	}
	//ѧУ���ܱ�->����ѧУ  List
	 public JSONArray listNearSchool(){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;


			JSONArray jsonArray=new JSONArray();
			try {
				String sql = "select * from near_school";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				jsonArray=ResultSetConverter.convert(rs);
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
	//ѧУ���ܱ�->����ѧУ  Add
	 public int InsertNearSchool(String school_name,int school_distance,String project_num){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			int exeResult=0;
			try {
				String sql = "insert into near_school(school_name,school_distance,project_num) values(?,?,?)";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, school_name);
				pstmt.setInt(2, school_distance);
				pstmt.setString(3, project_num);
				exeResult = pstmt.executeUpdate();
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
			return exeResult;
		}  
	//ѧУ���ܱ�->����ѧУ  update
	 public int updateNearSchool(int id,String school_name,int school_distance,String  project_num){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
		 int exeResult=0;
			try {
				String sql = "update near_school set school_name=?,school_distance=?,project_num=?  where id=?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, school_name);
				pstmt.setInt(2, school_distance);
				pstmt.setString(3, project_num);
				pstmt.setInt(4, id);
				exeResult = pstmt.executeUpdate();
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
			return exeResult;
		}
	//ѧУ���ܱ�->����ѧУ  delete
	 public int delNearSchool(int id){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			int exeResult=0;
			try {
				String sql = "delete from near_school where id="+id;
				  stmt = con.createStatement();
				exeResult = stmt.executeUpdate(sql);
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
			return exeResult;
		}
	//ѧУ���ܱ�->��������  list
	 public JSONArray listNearFacility(){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			JSONArray jsonArray=new JSONArray();
			try {
				String sql = "select * from near_peitao";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				jsonArray=ResultSetConverter.convert(rs);
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
	//ѧУ���ܱ�->��������  add
	 public int InsertNearFacility(String market_type,String market_name,int market_distance,String project_num){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

		 int exeResult=0;
			try {
				String sql = "insert into near_peitao(market_type,market_name,market_distance,project_num) values(?,?,?,?)";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, market_type);
				pstmt.setString(2, market_name);
				pstmt.setInt(3, market_distance);
				pstmt.setString(4, project_num);
				exeResult = pstmt.executeUpdate();
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
			return exeResult;
		}  
	//ѧУ���ܱ�->��������  update
	 public int updateNearFacility(int id,String market_type,String market_name,int market_distance,String project_num){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
		 int exeResult=0;
			try {
				String sql = "update near_peitao set market_type=?,market_name=?,market_distance=?,project_num=? where id=?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, market_type);
				pstmt.setString(2, market_name);
				pstmt.setInt(3, market_distance);
				pstmt.setString(4, project_num);
				pstmt.setInt(5, id);
				exeResult = pstmt.executeUpdate();
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
			return exeResult;
		}
	//ѧУ���ܱ�->��������  delete
	 public int delNearFacility(int id){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			int exeResult=0;
			try {
				String sql = "delete from near_peitao where id="+id;
				  stmt = con.createStatement();
				exeResult = stmt.executeUpdate(sql);
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
			return exeResult;
		}
}
	
