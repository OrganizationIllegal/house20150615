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
public class SchoolInfoDao extends BaseDao2{
	public int isDuplicate(String schoolname,String nationname,String cityname){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int isexist=0;
		try {con = dataSource.getConnection();
			String sql = " SELECT count(*) num from school_info where school_name=? and nation=? and city=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, schoolname);
			pstmt.setString(2, nationname);
			pstmt.setString(3, cityname);
			  rs = pstmt.executeQuery();
			if(rs.next()){
				isexist=rs.getInt(1);
			}
			if(isexist>0){
				return 1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }
        }
		return 0;
	}
	
	 public JSONArray listSchoolInfo(){
		 Statement stmt = null;Connection con = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			JSONArray jsonArray=new JSONArray();
			try {con = dataSource.getConnection();
				String sql = "select * from school_info t;";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				jsonArray=ResultSetConverter.convert(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 try { if (rs != null) rs.close(); } catch(Exception e) { }
				 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
				 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
				 try { if (con != null) con.close(); } catch(Exception e) { }

	        }
			return jsonArray;
		} 

	public int InsertSchoolinfo(String school_name,String school_ranking,String school_type,int student_total,int teacher_total,String school_position,String gps,String net_info,int not_en_stu_bili,String school_image,String school_desc,String nation,String city){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
	int exeResult=0;
			try {con = dataSource.getConnection();
				String sql = "insert into school_info(school_name,school_ranking,school_type,student_total,teacher_total,school_position,gps,net_info,not_en_stu_bili,school_image,school_desc,nation,city) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, school_name);
				pstmt.setString(2, school_ranking);
				pstmt.setString(3, school_type);
				pstmt.setInt(4, student_total);
				pstmt.setInt(5, teacher_total);
				pstmt.setString(6, school_position);
				pstmt.setString(7, gps);
				pstmt.setString(8, net_info);
				pstmt.setInt(9, not_en_stu_bili);
				pstmt.setString(10, school_image);
				pstmt.setString(11, school_desc);
				pstmt.setString(12, nation);
				pstmt.setString(13, city);
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
	public int updateSchoolInfo(int id,String school_name,String school_ranking,String school_type,int student_total,int teacher_total,String school_position,String gps,String net_info,int not_en_stu_bili,String school_image,String school_desc){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {con = dataSource.getConnection();
			String sql = "update school_info set school_name=?,school_ranking=?, school_type=?,student_total=?,teacher_total=?,school_position=?,gps=?,net_info=?,not_en_stu_bili=?,school_image=?,school_desc=? where id="+id;
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, school_name);
			pstmt.setString(2, school_ranking);
			pstmt.setString(3, school_type);
			pstmt.setInt(4, student_total);
			pstmt.setInt(5, teacher_total);
			pstmt.setString(6, school_position);
			pstmt.setString(7, gps);
			pstmt.setString(8, net_info);
			pstmt.setInt(9, not_en_stu_bili);
			pstmt.setString(10, school_image);
			pstmt.setString(11, school_desc);
			pstmt.setInt(12, id);
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
	 public int delSchoolInfo(int id){
		 Statement stmt = null;Connection con = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
		 int exeResult=0;
			try {con = dataSource.getConnection();
				String sql = "delete from school_info where id="+id;
				  stmt = con.createStatement();
				exeResult = stmt.executeUpdate(sql);
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
