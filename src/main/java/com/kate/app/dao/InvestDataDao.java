package com.kate.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.kate.app.model.InvestmentData;


	@Repository 
	public class InvestDataDao extends BaseDao2{
		public InvestmentData getInvestmentDate(String areaName){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Connection con = null;

			InvestmentData invest = new InvestmentData();
			try{con = dataSource.getConnection();
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
				 try { if (rs != null) rs.close(); } catch(Exception e) { }
				 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
				 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
				 try { if (con != null) con.close(); } catch(Exception e) { }

	        }
			return invest;
	        
		}
		
		public InvestmentData getInvestmentDateNum(String area_num,String type){
			Statement stmt = null;Connection con = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			InvestmentData invest = new InvestmentData();
			try{con = dataSource.getConnection();
				String sql = " select * from investment_data where area_num=? and area_type=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, area_num);
				pstmt.setString(2, type);
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
					invest.setArea_type(rs.getString("area_type"));
					invest.setTouzi_datasource(rs.getString("touzi_datasource"));
					invest.setTouzi_date(rs.getTimestamp("touzi_date"));
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	        	 try { if (rs != null) rs.close(); } catch(Exception e) { }
	        	 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
	        	 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
	        	 try { if (con != null) con.close(); } catch(Exception e) { }

	        }
			return invest;
	        
		}
		
}
