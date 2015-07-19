package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.NewsInfo;


	@Repository 
	public class NewsInfoDao extends BaseDao{
		public List<NewsInfo> getNewsInfo(String project_num){
			try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			List <NewsInfo> newsList = new ArrayList<NewsInfo>();
			try{
				String sql = " select * from news_info where project_num=?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, project_num);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					NewsInfo newsInfo = new NewsInfo();
					newsInfo.setId(rs.getInt("id"));
					newsInfo.setTitle(rs.getString("title"));
					newsInfo.setSource(rs.getString("source"));
					newsInfo.setTime(rs.getTimestamp("time"));
					newsInfo.setDetail(rs.getString("detail"));
					newsInfo.setNews_img(rs.getString("news_img"));
					newsInfo.setNews_num(rs.getString("news_num"));
					newsInfo.setNews_abstract(rs.getString("news_abstract"));
					newsList.add(newsInfo);
				}
			}catch (Exception e) {
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
			return newsList;
	        
		}
}
