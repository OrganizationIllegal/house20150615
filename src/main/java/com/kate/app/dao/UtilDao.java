package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;
@Repository 
public class UtilDao extends BaseDao {
	public int getHouseProId(String project_num){
		try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		int proId = 0;
		try {
			String sql = " SELECT * from house_project where project_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project_num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				proId = rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		return proId;
	}
	
	public int getAreaId(String area_num){
		try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		int areaId = 0;
		try {
			String sql = " SELECT * from area_info where area_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				areaId = rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		return areaId;
	}
	
}
