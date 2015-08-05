package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.AreaInfo;
import com.kate.app.model.SuggestionProject;
@Repository 
public class SuggestionDao extends BaseDao {
	
	/*
	 * 数据库查找项目名称和所在的州
	 */
	public List<SuggestionProject> getProjectSearch(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<SuggestionProject> proNameList = new ArrayList<SuggestionProject>();
		try{
			String sql = "select * from house_project where isSeen=1";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				SuggestionProject data = new SuggestionProject();
				data.setProject_name(rs.getString("project_name"));
				data.setProject_zhou(rs.getString("project_zhou"));
				proNameList.add(data);
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
		return proNameList;
	}
	
	
	/*
	 * 查询项目所在的州
	 */
	public List<String> getProjectZhou(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> zhouList = new ArrayList<String>();
		try{
			String sql = "select distinct  project_zhou from house_project";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				String data = new String();
				data = rs.getString("project_zhou");
				zhouList.add(data);
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
		return zhouList;
	}
	
	
	/*
	 * 得到经纪人的所在区域
	 */
	public List<String> getSuozaiQuyu(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> zhouList = new ArrayList<String>();
		try{
			String sql = "select distinct  broker_region from broker_info";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				String data = new String();
				data = rs.getString("broker_region");
				zhouList.add(data);
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
		return zhouList;
	}
	
	/*
	 * 数据库表的查询得到区域的名称
	 */
	public List<String> getFuwuQuyu(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> zhouList = new ArrayList<String>();
		try{
			String sql = "select distinct  a.area_name from area_info a, broker_service_area b where a.area_num = b.area_code";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				String data = new String();
				data = rs.getString("area_name");
				zhouList.add(data);
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
		return zhouList;
	}
	
	
	/*
	 * 在项目表中查出项目的地址
	 */
	public List<String> getProjectAdd(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> addList = new ArrayList<String>();
		try{
			String sql = "select distinct  project_address from house_project";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				String data = new String();
				data = rs.getString("project_address");
				addList.add(data);
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
		return addList;
	}
	
	
	/*
	 * 查询项目所在的城市
	 */
	public List<String> getProjectCity(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> cityList = new ArrayList<String>();
		try{
			String sql = "select distinct  project_city from house_project";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				String data = new String();
				data = rs.getString("project_city");
				cityList.add(data);
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
		return cityList;
	}
	
	
	
	
	
	/*
	 * 得到区域的信息
	 */
	public List<AreaInfo> getAreaInfo(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		List<AreaInfo> areaList = new ArrayList<AreaInfo>();
		try {
			String sql = " SELECT * from area_info";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				AreaInfo areaInfo = new AreaInfo();
				areaInfo.setArea_city(rs.getString("area_city"));
				areaInfo.setArea_name(rs.getString("area_name"));
				areaInfo.setArea_nation(rs.getString("area_nation"));
				areaInfo.setArea_zhou(rs.getString("area_zhou"));
				areaInfo.setArea_postcode(rs.getString("area_postcode"));
				areaInfo.setArea_num(rs.getString("area_num"));
				areaList.add(areaInfo);
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
		return areaList;
	}
}
