package com.kate.app.dao;

import java.sql.Connection;
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
public class SuggestionDao extends BaseDao2 {
	
	/*
	 * 数据库查找项目名称和所在的州
	 */
	public List<SuggestionProject> getProjectSearch(){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<SuggestionProject> proNameList = new ArrayList<SuggestionProject>();
		try{con = dataSource.getConnection();
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
        	 try { if (rs != null) rs.close(); } catch(Exception e) { }
        	 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
        	 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
        	 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return proNameList;
	}
	
	
	/*
	 * 查询项目所在的州
	 */
	public List<String> getProjectZhou(){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> zhouList = new ArrayList<String>();
		try{con = dataSource.getConnection();
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
        	 try { if (rs != null) rs.close(); } catch(Exception e) { }
        	 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
        	 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
        	 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return zhouList;
	}
	
	
	/*
	 * 得到经纪人的所在区域
	 */
	public List<String> getSuozaiQuyu(){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> zhouList = new ArrayList<String>();
		try{con = dataSource.getConnection();
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
        	 try { if (rs != null) rs.close(); } catch(Exception e) { }
        	 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
        	 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
        	 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return zhouList;
	}
	
	/*
	 * 数据库表的查询得到区域的名称
	 */
	public List<String> getFuwuQuyu(){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> zhouList = new ArrayList<String>();
		try{con = dataSource.getConnection();
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
        	 try { if (rs != null) rs.close(); } catch(Exception e) { }
        	 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
        	 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
        	 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return zhouList;
	}
	
	
	/*
	 * 在项目表中查出项目的地址
	 */
	public List<String> getProjectAdd(){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> addList = new ArrayList<String>();
		try{con = dataSource.getConnection();
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
        	 try { if (rs != null) rs.close(); } catch(Exception e) { }
        	 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
        	 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
        	 try { if (con != null) con.close(); } catch(Exception e) { }
        }
		return addList;
	}
	
	
	/*
	 * 查询项目所在的城市
	 */
	public List<String> getProjectCityAndZhou(){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> cityList = new ArrayList<String>();
		try{con = dataSource.getConnection();

			String sql = "SELECT area_city, area_zhou  FROM area_info GROUP BY area_city";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				String data = new String();
				String city = rs.getString("area_city");
				String zhou = rs.getString("area_zhou");
				if(city!=null && !"".equals(city) && zhou!=null && !"".equals(zhou)){
					data = city+";"+zhou;
				}
				
				
				cityList.add(data);
			}
			
		}catch (Exception e) {
			 e.printStackTrace();
        }finally{
        	 try { if (rs != null) rs.close(); } catch(Exception e) { }
        	 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
        	 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
        	 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return cityList;
	}
	
	/*
	 * 查询项目所在的城市
	 */
	public List<String> getProjectCity(){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> cityList = new ArrayList<String>();
		try{con = dataSource.getConnection();

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
        	 try { if (rs != null) rs.close(); } catch(Exception e) { }
        	 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
        	 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
        	 try { if (con != null) con.close(); } catch(Exception e) { }

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
		Connection con = null;
		List<AreaInfo> areaList = new ArrayList<AreaInfo>();
		try {con = dataSource.getConnection();
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
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return areaList;
	}
}
