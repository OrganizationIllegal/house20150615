package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.kate.app.model.BuyInfo;
@Repository 
public class BuyInfoDao extends BaseDao{
	/*
	 * 查找返现
	 */
	public int BuyInfoDao(int houseProId){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		int returnMoney=0;
		try{
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
		return returnMoney;
		
	}

}
