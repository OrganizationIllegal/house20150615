package com.kate.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.Area;
import com.kate.app.model.City;

@Repository 
public class AreaDao extends BaseDao2{
	//delete区域
	public boolean deleteArea(int id){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean flag=true;
		try {con = dataSource.getConnection();
			String sql = "delete from area where id=?";
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
	public JSONArray selectAreaList(){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		JSONArray jsonArray=new JSONArray();
		try {con = dataSource.getConnection();
			String sql = " select * from area";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("area_num", rs.getString("area_num"));
				obj.put("area_name", rs.getString("area_name"));
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

	public boolean SaveAddArea(String area_name,String area_num,String center_gps,String pre_num){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean flag=true;
		try {con = dataSource.getConnection();
			String sql = "insert into area(area_name,area_num,center_gps,pre_num) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, area_name);
			pstmt.setString(2, area_num);
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
	public boolean SaveUpdateArea(int id,String area_name,String area_num,String center_gps,String pre_num){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;	
		boolean flag=true;
		try {con = dataSource.getConnection();

			String sql = "update area set area_name=?,area_num=?,center_gps=?,pre_num=? where id=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, area_name);
			pstmt.setString(2, area_num);
			pstmt.setString(3, center_gps);
			pstmt.setString(4, pre_num);
			pstmt.setInt(5, id);
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
	public Area selectAreaInfo(int id){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Area area=new Area();
		try {con = dataSource.getConnection();
			String sql = " select * from area where id="+id;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				area.setId(rs.getInt("id"));
				area.setArea_name(rs.getString("area_name"));
				area.setArea_num(rs.getString("area_num"));
				area.setCenter_gps(rs.getString("center_gps"));
				area.setPre_num(rs.getString("pre_num"));
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
		return area;
	} 
}
