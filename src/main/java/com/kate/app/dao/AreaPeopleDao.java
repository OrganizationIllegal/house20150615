package com.kate.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;

@Repository 
public class AreaPeopleDao extends BaseDao2{
	//区域人口分布 List
	  public JSONArray listAreapeople(){
		  Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Connection con = null;

			JSONArray jsonArray=new JSONArray();
			try {
				  con = dataSource.getConnection();
				  String sql = "select * from area_people t;";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				jsonArray=ResultSetConverter.convert(rs);
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
			return jsonArray;
		} 
	//区域人口分布Add
	 public int InsertAreaPeople(String column1, String column2, String column3,int view_shunxu,String area_code){
		 Statement stmt = null;Connection con = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
		 int exeResult=0;
			try {con = dataSource.getConnection();

				String sql = "insert into area_people(column1,column2,column3,view_shunxu,area_code) values(?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, column1);
				pstmt.setString(2, column2);
				pstmt.setString(3, column3);
				pstmt.setInt(4, view_shunxu);
				pstmt.setString(5, area_code);
				exeResult = pstmt.executeUpdate();
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
			return exeResult;
		}  
	//中位数房价走势 update
	 public int updateAreaPeople(int id,String column1, String column2, String column3,int view_shunxu,String area_code){
		 Statement stmt = null;Connection con = null;

			ResultSet rs = null;
			PreparedStatement pstmt = null;
		 int exeResult=0;
			try {con = dataSource.getConnection();
				String sql = "update area_people set column1=?,column2=?,column3=?,view_shunxu=?,area_code=? where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, column1);
				pstmt.setString(2, column2);
				pstmt.setString(3, column3);
				pstmt.setInt(4, view_shunxu);
				pstmt.setString(5, area_code);
				pstmt.setInt(6, id);
				exeResult = pstmt.executeUpdate();
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
			return exeResult;
		}
	//中位数房价走势 delete
	 public int delAreaPeople(int id){
		 Statement stmt = null;Connection con = null;

			ResultSet rs = null;
			PreparedStatement pstmt = null;
			int exeResult=0;
			try {con = dataSource.getConnection();

				String sql = "delete from area_people where id="+id;
				  stmt = con.createStatement();
				exeResult = stmt.executeUpdate(sql);
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
			return exeResult;
		}
}
