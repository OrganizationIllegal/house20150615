package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.kate.app.model.InvestmentData;


	@Repository 
	public class InvestDataDao extends BaseDao{
		public InvestmentData getInvestmentDate(String areaName){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;


			InvestmentData invest = new InvestmentData();
			try{
				String sql = " select * from investment_data where area_name=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, areaName);
				  rs = pstmt.executeQuery();
				
				while(rs.next()){
					invest.setArea_id(rs.getInt("area_id"));
					invest.setId(rs.getInt("id"));
					invest.setData_exam(rs.getString("data_exam"));
					invest.setMiddle_price(rs.getString("middle_price"));
					invest.setMiddle_zu_price(rs.getString("middle_zu_price"));
					invest.setPrice_review(rs.getString("price_review"));
					invest.setYear_increment_rate(rs.getString("year_increment_rate"));
					invest.setZu_house_rate(rs.getString("zu_house_rate"));
					invest.setZu_xuqiu(rs.getString("zu_xuqiu"));
					invest.setArea_num(rs.getString("area_num"));
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			finally{
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
			return invest;
	        
		}
		
		public InvestmentData getInvestmentDateNum(String area_num){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			InvestmentData invest = new InvestmentData();
			try{
				String sql = " select * from investment_data where area_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, area_num);
				  rs = pstmt.executeQuery();
				
				while(rs.next()){
					invest.setArea_id(rs.getInt("area_id"));
					invest.setId(rs.getInt("id"));
					invest.setData_exam(rs.getString("data_exam"));
					invest.setMiddle_price(rs.getString("middle_price"));
					invest.setMiddle_zu_price(rs.getString("middle_zu_price"));
					invest.setPrice_review(rs.getString("price_review"));
					invest.setYear_increment_rate(rs.getString("year_increment_rate"));
					invest.setZu_house_rate(rs.getString("zu_house_rate"));
					invest.setZu_xuqiu(rs.getString("zu_xuqiu"));
					invest.setArea_num(rs.getString("area_name"));
				}
			}catch (Exception e) {
	            e.printStackTrace();
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
			return invest;
	        
		}
		
}
