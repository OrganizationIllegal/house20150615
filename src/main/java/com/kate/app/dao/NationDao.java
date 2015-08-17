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
import com.kate.app.model.Nation;

@Repository 
public class NationDao extends BaseDao2{
	//delete国家
	public boolean deleteNation(int id){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean flag=true;
		try {con = dataSource.getConnection();
			String sql = "delete from nation where id=?";
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
	//国家select列表
	public List<String> NationList(){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> nationlist=new ArrayList<String>();
		try {con = dataSource.getConnection();
			String sql = " select * from nation";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				nationlist.add(rs.getString("nation_name"));
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
		return nationlist;
	} 
	//国家列表
	public JSONArray selectNationList(){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		JSONArray jsonArray=new JSONArray();
		try {con = dataSource.getConnection();
			String sql = " select * from nation";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("nation_num", rs.getString("nation_num"));
				obj.put("nation_name", rs.getString("nation_name"));
				obj.put("center_gps", rs.getString("center_gps"));
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

	public boolean SaveAddNation(String nation_name,String nation_num,String center_gps){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean flag=true;
		try {con = dataSource.getConnection();
			String sql = "insert into nation(nation_name,nation_num,center_gps) values(?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, nation_name);
			pstmt.setString(2, nation_num);
			pstmt.setString(3, center_gps);
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
	public boolean SaveUpdateNation(int id,String nation_name,String nation_num,String center_gps){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;	
		boolean flag=true;
		try {con = dataSource.getConnection();

			String sql = "update nation set nation_name=?,nation_num=?,center_gps=? where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, nation_name);
			pstmt.setString(2, nation_num);
			pstmt.setString(3, center_gps);
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
	public Nation selectNationInfo(int id){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Nation nation=new Nation();
		try {con = dataSource.getConnection();
			String sql = " select * from nation where id="+id;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				nation.setId(rs.getInt("id"));
				nation.setNation_name(rs.getString("nation_name"));
				nation.setNation_num(rs.getString("nation_num"));
				nation.setCenter_gps(rs.getString("center_gps"));
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
		return nation;
	} 
}
