package com.kate.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.kate.app.model.MiddlePrice;
@Repository 
public class MiddlePriceDao extends BaseDao2 {
	public MiddlePrice getMiddlePrice(String project_type, String areaNum){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		MiddlePrice middlePrice = new MiddlePrice() ;
		try {con = dataSource.getConnection();

			String sql = " SELECT * from area_middle_price where project_type='"+project_type+"' and area_quyu='"+areaNum+"'";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);

			while(rs.next()){
				middlePrice.setArea_quyu(rs.getString("area_quyu"));
				middlePrice.setBuy_price(rs.getInt("buy_price"));
				middlePrice.setZu_price(rs.getInt("zu_price"));
				middlePrice.setBuy_one_name(rs.getString("buy_one_name"));
				middlePrice.setBuy_one_price(rs.getInt("buy_one_price"));
				middlePrice.setBuy_two_name(rs.getString("buy_two_name"));
				middlePrice.setBuy_two_price(rs.getInt("buy_two_price"));
				middlePrice.setBuy_three_name(rs.getString("buy_three_name"));
				middlePrice.setBuy_three_price(rs.getInt("buy_three_price"));
				middlePrice.setZu_one_name(rs.getString("zu_one_name"));
				middlePrice.setZu_one_price(rs.getInt("zu_one_price"));
				middlePrice.setZu_two_name(rs.getString("zu_two_name"));
				middlePrice.setZu_two_price(rs.getInt("zu_two_price"));
				middlePrice.setZu_three_name(rs.getString("zu_three_name"));
				middlePrice.setZu_three_price(rs.getInt("zu_three_price"));
				middlePrice.setHouse_pro_id(rs.getInt("house_pro_id"));
				middlePrice.setMiddle_datasource(rs.getString("middle_datasource"));
				middlePrice.setMiddle_date(rs.getTimestamp("middle_date"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { } 

        }
		return middlePrice;
	}
	public int getyoungfamilyrate(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;

		int houseProId=1;
		int youngfamilyrate=0;
		try {con = dataSource.getConnection();
			String sql = " SELECT rate from area_family t where binary t.family_type='�����ͥ'  AND t.house_pro_id="+houseProId;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				youngfamilyrate=rs.getInt("rate");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return youngfamilyrate;
	}
	public int getoldfamilyrate(){	
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int houseProId=1;
		int oldfamilyrate=0;
		try {con = dataSource.getConnection();
			String sql = " SELECT rate from area_family t where binary t.family_type='�����ͥ'  AND t.house_pro_id="+houseProId;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				oldfamilyrate=rs.getInt("rate");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return oldfamilyrate;
	}
	//��
	public int InsertAreaFamily(String family_type,int rate,int house_pro_id){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {con = dataSource.getConnection();
			String sql = "insert into area_family(family_type,rate,house_pro_id) values("+"'"+family_type+"'"+","+rate+","+house_pro_id+") ";
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
	//ɾ
	public int delAreaFamily(int id){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {con = dataSource.getConnection();
			String sql = "delete from area_family where id="+id;
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
	//��
	public JSONArray listAreaFamily(){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		JSONArray jsonArray=new JSONArray();
		try {con = dataSource.getConnection();
			String sql = " select t.id,t.family_type,t.rate,t.house_pro_id,h.project_name from area_family t LEFT JOIN house_project h on  t.house_pro_id=h.id";
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
	//��
	public int updateAreaFamily(int id,String family_type,int rate,int house_pro_id){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {con = dataSource.getConnection();
			String sql = "update area_family set family_type=?,rate=? where id=? and house_pro_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, family_type);
			pstmt.setInt(2, rate);
			pstmt.setInt(3, id);
			pstmt.setInt(4, house_pro_id);
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
	//�����Ŀ��Ʋ�����Ŀid
	public int findProjectIdByName(String project_name){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int project_id=0;Connection con = null;
		try {con = dataSource.getConnection();
			String sql = "select t.id from house_project t where t.project_name="+"'"+project_name+"'";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				project_id=rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return project_id;
	}
	public int findLatestId(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;


		int id=0;
		try {con = dataSource.getConnection();
			String sql = "SELECT LAST_INSERT_ID();";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				id=rs.getInt(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return id;
	}
}
