package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.kate.app.model.BuyInfo;
@Repository 
public class BuyInfoDao extends BaseDao{
	public int BuyInfoDao(int houseProId){
		try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		int returnMoney=0;
		try{
			String sql = " select return_money from buy_info where house_pro_id=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, houseProId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				BuyInfo buyInfo = new BuyInfo();
				buyInfo.setReturn_money(rs.getInt("return_money"));
				returnMoney=buyInfo.getReturn_money();
			}
		}catch (Exception e) {
            
        }
		finally{  
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
		return returnMoney;
		
	}

}
