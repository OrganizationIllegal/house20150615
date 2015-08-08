package com.kate.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.kate.app.model.RecoProject;
@Repository 
public class RecoProjectDao extends BaseDao2{

	public RecoProject getRecoProjectDao(String area_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;

		RecoProject data = null;
		try{
			con = dataSource.getConnection();

			String sql = "select * from recommend_project where area_code = ? ";
		    pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_num);

			 rs = pstmt.executeQuery();

			
			while(rs.next()){
				data = new RecoProject();
				data.setId(rs.getInt("id"));
				data.setRecommend_num_1(rs.getString("recommend_num_1"));
				data.setRecommend_num_2(rs.getString("recommend_num_2"));
				data.setRecommend_num_3(rs.getString("recommend_num_3"));
			}
			
		}catch (Exception e) {
            
        }finally{
        	 try { if (rs != null) rs.close(); } catch(Exception e) { }
        	 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
        	 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
        	 try { if (con != null) con.close(); } catch(Exception e) { }
        }
		return data;
		
	}

}