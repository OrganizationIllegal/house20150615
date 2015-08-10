package com.kate.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Repository 
public class AreaFeatureDao extends BaseDao2{
	public List<String> getAreaFeature(String area_code){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		List<String> featureList=new ArrayList<String>();
		String afeature=null;
		try {
			con = dataSource.getConnection();
			String sql = " select area_character from area_features where area_code='"+area_code+"'";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				afeature=rs.getString("area_character");
				featureList.add(afeature);
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
		return featureList;
	}
	//�����ص�  List
	public JSONArray listAreaFeature(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		JSONArray jsonArray=new JSONArray();
		try {
			con = dataSource.getConnection();
			String sql = "select * from area_features";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("area_character", rs.getString("area_character"));
				obj.put("house_project_id", rs.getInt("house_project_id"));
				obj.put("view_shunxu", rs.getInt("view_shunxu"));
				obj.put("area_id", rs.getInt("area_id"));
				obj.put("data_source", rs.getString("data_source"));
				
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
			//jsonArray=ResultSetConverter.convert(rs);
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
	//�����ص�  Add
	public int InsertAreaFeature(String area_character,int view_shunxu,int area_id,String data_source,String update_time){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		int exeResult=0;
		try {
			con = dataSource.getConnection();
			String sql = "insert into area_features(area_character,view_shunxu,area_id,data_source,update_time) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_character);
			pstmt.setInt(2, view_shunxu);
			pstmt.setInt(3, area_id);
			pstmt.setString(4, data_source);
			pstmt.setString(5, update_time);
			exeResult = pstmt.executeUpdate();
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
		return exeResult;
	}
	//�����ص�  update
	public int updateAreaFeature(int id,String area_character,int view_shunxu,int area_id,String data_source,String update_time){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {
			con = dataSource.getConnection();
			String sql = "update area_features set area_character=?,view_shunxu=?,area_id=?,data_source=?,update_time=? where id="+id;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_character);
			pstmt.setInt(2, view_shunxu);
			pstmt.setInt(3, area_id);
			pstmt.setString(4, data_source);
			pstmt.setString(5, update_time);
			pstmt.setInt(6, id);
			exeResult = pstmt.executeUpdate();
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

		return exeResult;
	}
	//�����ص�  delete
	public int delAreaFeature(int id){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {
			con = dataSource.getConnection();
			String sql = "delete from area_features where id="+id;
			  stmt = con.createStatement();
			exeResult = stmt.executeUpdate(sql);
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

		return exeResult;
	}

}
