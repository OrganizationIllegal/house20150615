package com.kate.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
@Repository 
public class Index01Dao extends BaseDao2 {
	
	
	/*
	 * 数据库查找首页的推荐项目列表信息
	 */
	public List<String> getTuijian(){
		Connection con = null;

		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		List<String> list = new ArrayList<String>();
		try {con = dataSource.getConnection();
			String sql = " select * from index_recommend_project";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				String temp1 = rs.getString("recommend_num_1");
				if(temp1!=null){
					list.add(temp1);
				}
				String temp2 = rs.getString("recommend_num_2");
				if(temp2!=null){
					list.add(temp2);
				}
				String temp3 = rs.getString("recommend_num_3");
				if(temp3!=null){
					list.add(temp3);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return list;
	}
	public List<String> getTuijian2(){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> list = new ArrayList<String>();
		try {con = dataSource.getConnection();
			String sql = " select * from index_recommend_project";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				String temp1 = rs.getString("recommend_num_4");
				if(temp1!=null){
					list.add(temp1);
				}
				String temp2 = rs.getString("recommend_num_5");
				if(temp2!=null){
					list.add(temp2);
				}
				String temp3 = rs.getString("recommend_num_6");
				if(temp3!=null){
					list.add(temp3);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return list;
	}
	
	
}
