package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.kate.app.model.RecoProject;
@Repository 
public class RecoProjectDao extends BaseDao{
<<<<<<< HEAD
	public RecoProject getRecoProjectDao(String project_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
=======
	public RecoProject getRecoProjectDao(String area_num){
>>>>>>> 2b3dfb75b56f63409e28a3d39d60b75d9113fa86
		RecoProject data = new RecoProject();
		PreparedStatement pstmt =null;
		try{
<<<<<<< HEAD
			String sql = "select * from recommend_project where project_num=?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project_num);
			  rs = pstmt.executeQuery();
=======
			String sql = "select * from recommend_project where area_code=?";
		    pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_num);

			ResultSet rs = pstmt.executeQuery();
>>>>>>> 2b3dfb75b56f63409e28a3d39d60b75d9113fa86
			
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
		return data;
		
	}

}