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
	
	//学校信息Add
	public boolean InsertSchoolInfo(String school_name,String school_ranking,String school_type,int school_total,int teacher_total,String school_position,String gps,String net_info,int not_en_stu_bili,String school_image,String school_desc){
		boolean flag=true;
		try {
			String sql = "insert into school_info(school_name,school_ranking,school_type,student_total,teacher_total, school_position,gps,net_info,not_en_stu_bili,school_image,school_desc) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, school_name);
			pstmt.setString(2, school_ranking);
			pstmt.setString(3, school_type);
			pstmt.setInt(4, school_total);
			pstmt.setInt(5, teacher_total);
			pstmt.setString(6, school_position);
			pstmt.setString(7, gps);
			pstmt.setString(8, net_info);
			pstmt.setInt(9, not_en_stu_bili);
			pstmt.setString(10, school_image);
			pstmt.setString(11, school_desc);
			int exeResult = pstmt.executeUpdate();
			if(exeResult == 0){
				flag = false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	//学校信息Add
		public boolean InsertDeveloperInfo(String developer_name,String developer_logo,String developer_desc,String developer_num){
			boolean flag=true;
			try {
				String sql = "insert into developer_info(developer_name,developer_logo,developer_desc,developer_num) values(?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, developer_name);
				pstmt.setString(2, developer_logo);
				pstmt.setString(3, developer_desc);
				pstmt.setString(4, developer_num);
				int exeResult = pstmt.executeUpdate();
				if(exeResult == 0){
					flag = false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
			
		}
	
}
