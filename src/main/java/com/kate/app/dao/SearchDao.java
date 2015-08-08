package com.kate.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.kate.app.model.HistorySearch;
@Repository 
public class SearchDao extends BaseDao2{
	
	public int InsertSearch(HistorySearch his_search){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {con = dataSource.getConnection();

			String sql = "insert into history_search(search_content,search_time,userid,housetype,minprice,maxprice,advance_option1,advance_option2,advance_option3,advance_option4,advance_option5,advance_option6,advance_option7,advance_option8,advance_option9,advance_option10,advance_option11) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, his_search.getSearch_content());
			pstmt.setTimestamp(2, his_search.getSearch_time());
			pstmt.setInt(3, his_search.getUser_id());
			pstmt.setString(4, his_search.getHouse_type());
			pstmt.setInt(5, his_search.getMinprice());
			pstmt.setInt(6, his_search.getMaxprice());
			pstmt.setString(7, his_search.getAdvance_option1());
			pstmt.setString(8, his_search.getAdvance_option2());
			pstmt.setString(9, his_search.getAdvance_option3());
			pstmt.setString(10, his_search.getAdvance_option4());
			pstmt.setString(11, his_search.getAdvance_option5());
			pstmt.setString(12, his_search.getAdvance_option6());
			pstmt.setString(13, his_search.getAdvance_option7());
			pstmt.setString(14, his_search.getAdvance_option8());
			pstmt.setString(15, his_search.getAdvance_option9());
			pstmt.setString(16, his_search.getAdvance_option10());
			pstmt.setString(17, his_search.getAdvance_option11());
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }


        }
		return exeResult;
	}
}
