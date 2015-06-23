package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

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
	
	
}
