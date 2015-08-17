package com.kate.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.City;

@Repository 
public class CityDao extends BaseDao2{
	//delete城市
	public boolean deleteCity(int id){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean flag=true;
		try {con = dataSource.getConnection();
			String sql = "delete from city where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, id);
			int exeResult = pstmt.executeUpdate();
			if(exeResult == 0){
				flag = false;
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
		return flag;
	}
	//国家列表
	public List<String> CityList(){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> citylist=new ArrayList<String>();
		try {con = dataSource.getConnection();
			String sql = " select * from city";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				citylist.add(rs.getString("city_name"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return citylist;
	} 
	//国家列表
	public JSONArray selectCityList(){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		JSONArray jsonArray=new JSONArray();
		try {con = dataSource.getConnection();
			String sql = " select * from city";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("city_num", rs.getString("city_num"));
				obj.put("city_name", rs.getString("city_name"));
				obj.put("center_gps", rs.getString("center_gps"));
				obj.put("pre_num", rs.getString("pre_num"));
				jsonArray.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return jsonArray;
	} 
	
	//添加开发商信息

	public boolean SaveAddCity(String city_name,String city_num,String center_gps,String pre_num){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean flag=true;
		try {con = dataSource.getConnection();
			String sql = "insert into city(city_name,city_num,center_gps,pre_num) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, city_name);
			pstmt.setString(2, city_num);
			pstmt.setString(3, center_gps);
			pstmt.setString(4, pre_num);
			int exeResult = pstmt.executeUpdate();
			if(exeResult == 0){
				flag = false;
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
		return flag;
	}
	//保存修改的国家
	public boolean SaveUpdateCity(int id,String city_name,String city_num,String center_gps,String pre_num){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;	
		boolean flag=true;
		try {con = dataSource.getConnection();

			String sql = "update city set city_name=?,center_gps=?,pre_num=? where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, city_name);
			pstmt.setString(2, center_gps);
			pstmt.setString(3, pre_num);
			pstmt.setInt(4, id);
			int exeResult = pstmt.executeUpdate();
			if(exeResult == 0){
				flag = false;
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
		return flag;
	}
	
	//根据id查找国家信息
	public City selectCityInfo(int id){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		City city=new City();
		try {con = dataSource.getConnection();
			String sql = " select * from city where id="+id;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				city.setId(rs.getInt("id"));
				city.setCity_name(rs.getString("city_name"));
				city.setCity_num(rs.getString("city_num"));
				city.setCenter_gps(rs.getString("center_gps"));
				city.setPre_num(rs.getString("pre_num"));
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
		return city;
	} 
}
