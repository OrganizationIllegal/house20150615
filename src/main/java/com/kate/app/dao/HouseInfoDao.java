package com.kate.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.BrokerInfo;
import com.kate.app.model.HouseInfo;
import com.kate.app.model.HouseProject;
@Repository 
public class HouseInfoDao extends BaseDao2{
	public List<HouseInfo> HouseInfoDao(String proNum){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<HouseInfo> list=new ArrayList<HouseInfo>();
		String item = HouseTypeByNumDao(proNum);
		try{con = dataSource.getConnection();
			String sql = " select * from house_info where project_num=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, proNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				HouseInfo houseInfo = new HouseInfo();
				//houseInfo.setHouse_type("house_type");
				if(item!=null && !"".equals(item)){
					houseInfo.setHouse_type(item);
				}
				houseInfo.setHouse_name(rs.getString("house_name"));
				houseInfo.setHouse_room_num(rs.getInt("house_room_num"));
				houseInfo.setHouse_toilet_num(rs.getInt("house_toilet_num"));
				houseInfo.setHouse_size_in(rs.getString("house_size_in"));
				houseInfo.setHouse_size_out(rs.getString("house_size_out"));
				houseInfo.setTudi_area(rs.getString("tudi_area"));
				houseInfo.setJianzhu_area(rs.getString("jianzhu_area"));
				houseInfo.setHouse_price(rs.getString("house_price"));
				houseInfo.setHouse_img(rs.getString("house_img"));
				String a = rs.getString("update_time");
				
				houseInfo.setUpdate_time(a);
				list.add(houseInfo);
			}
			
		}catch (Exception e) {
            
        }
		finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return list;
	}
	public String HouseTypeByNumDao(String pro_num){
		DecimalFormat df = new DecimalFormat("#,###,###");
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String project_type = "";
		try{con = dataSource.getConnection();
			String sql = "select * from house_project where project_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pro_num);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				
				project_type = rs.getString("project_type");
				

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
		return project_type;
	}
}
