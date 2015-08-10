package com.kate.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;
@Repository 
public class UtilDao extends BaseDao2 {
	public int getHouseProId(String project_num){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		int proId = 0;
		try {con = dataSource.getConnection();
			String sql = " SELECT * from house_project where project_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project_num);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				proId = rs.getInt("id");
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
		return proId;
	}
	
	public int getAreaId(String area_num){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int areaId = 0;
		try {con = dataSource.getConnection();
			String sql = " SELECT * from area_info where area_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_num);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				areaId = rs.getInt("id");
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
		return areaId;
	}
	
}
