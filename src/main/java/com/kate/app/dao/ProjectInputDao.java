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
public class ProjectInputDao extends BaseDao {
	//得到开发商的编号及名称
	public List<String> getDeveloperCodeName(){
		List<String> codeAndNameSet=new ArrayList<String>();
		try {
			String sql ="select t.developer_num,t.developer_name from developer_info t ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String codeAndName_str=rs.getString("developer_num")+"$$"+rs.getString("developer_name");
				codeAndNameSet.add(codeAndName_str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codeAndNameSet;
	}
	//项目列表
	public JSONArray selectProjectList(){
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = " select t.id,t.project_num,t.project_name from house_project t";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("project_num", rs.getString("project_num"));
				obj.put("project_name", rs.getString("project_name"));
				jsonArray.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonArray;
	} 
	
}
