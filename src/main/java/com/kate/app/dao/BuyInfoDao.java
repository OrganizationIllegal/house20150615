package com.kate.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.kate.app.model.BuyInfo;
@Repository 
public class BuyInfoDao extends BaseDao2{
	/*
	 * 查找返现
	 */
	public int BuyInfoDao(int houseProId){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		int returnMoney=0;
		try{con = dataSource.getConnection();
			String sql = " select return_money from buy_info where house_pro_id=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, houseProId);
			  rs = pstmt.executeQuery();
			
			while(rs.next()){
				BuyInfo buyInfo = new BuyInfo();
				buyInfo.setReturn_money(rs.getInt("return_money"));
				returnMoney=buyInfo.getReturn_money();
			}
		}catch (Exception e) {
            
        }
		finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return returnMoney;
		
	}

}
