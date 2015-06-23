package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Repository 
public class AreaInputDao extends BaseDao {
	//得到经纪人的编号及姓名
	public List<String> getBrokerName(){
		List<String> brokerNameSet=new ArrayList<String>();
		try {
			String sql ="select * from broker_info";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String brokerName=rs.getString("broker_name");
				brokerNameSet.add(brokerName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brokerNameSet;
	}
	
	//得到项目的编号及名称
		public List<String> getProjectName(){
			List<String> projectNameSet=new ArrayList<String>();
			try {
				String sql ="select * from house_project";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					String projectName=rs.getString("project_name");
					projectNameSet.add(projectName);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return projectNameSet;
		}
	//区域列表
	public JSONArray selectAreaList(){
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = " select * from area_info";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("area_num", rs.getString("area_num"));
				obj.put("area_name", rs.getString("area_name"));
				obj.put("area_city", rs.getString("area_city"));
				obj.put("area_zhou", rs.getString("area_zhou"));
				obj.put("area_nation", rs.getString("area_nation"));
				obj.put("area_postcode", rs.getString("area_postcode"));
				jsonArray.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonArray;
	} 
	
}
