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
public class Index01Dao extends BaseDao {
	
	
	
	public List<Integer> getTuijian(){
		try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		List<Integer> list = new ArrayList<Integer>();
		try {
			String sql = " select * from index_recommend_project";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Integer temp1 = rs.getInt("recommend_1");
				Integer temp2 = rs.getInt("recommend_2");
				Integer temp3 = rs.getInt("recommend_3");
				list.add(temp1);
				list.add(temp2);
				list.add(temp3);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
            if(con != null){  
                try {  
                    con.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
		return list;
	}
	public List<Integer> getTuijian2(){
		try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		List<Integer> list = new ArrayList<Integer>();
		try {
			String sql = " select * from index_recommend_project";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Integer temp1 = rs.getInt("recommend_3");
				Integer temp2 = rs.getInt("recommend_4");
				Integer temp3 = rs.getInt("recommend_5");
				list.add(temp1);
				list.add(temp2);
				list.add(temp3);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
            if(con != null){  
                try {  
                    con.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        } 
		return list;
	}
	
	
}
