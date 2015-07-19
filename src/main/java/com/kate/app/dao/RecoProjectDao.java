package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.kate.app.model.RecoProject;
@Repository 
public class RecoProjectDao extends BaseDao{
	public RecoProject getRecoProjectDao(String area_num){
		RecoProject data = new RecoProject();
		PreparedStatement pstmt =null;
		try{
			String sql = "select * from recommend_project where area_code=?";
		    pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_num);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				data.setId(rs.getInt("id"));
				data.setRecommend_id_1(rs.getInt("recommend_id_1"));
				data.setRecommend_id_2(rs.getInt("recommend_id_2"));
				data.setRecommend_id_3(rs.getInt("recommend_id_3"));
				data.setRecommend_num_1(rs.getString("recommend_num_1"));
				data.setRecommend_num_2(rs.getString("recommend_num_2"));
				data.setRecommend_num_3(rs.getString("recommend_num_3"));
			}
			
		}catch (Exception e) {
            
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
		return data;
		
	}

}