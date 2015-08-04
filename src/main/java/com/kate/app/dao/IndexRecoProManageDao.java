package com.kate.app.dao;

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
public class IndexRecoProManageDao extends BaseDao{
	//根据项目编号查找推荐项目
	 public List<String> getRecos(){
		 List<String> recos=new ArrayList<String>();
		 Statement stmt = null;
			ResultSet rs = null;
			try {
				String sql = "select recommend_num_1, recommend_num_2, recommend_num_3,recommend_num_4,recommend_num_5,recommend_num_6 from index_recommend_project where id=1";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				  if(rs.next()){
					  recos.add(rs.getString(1));
					  recos.add(rs.getString(2));
					  recos.add(rs.getString(3));
					  recos.add(rs.getString(4));
					  recos.add(rs.getString(5));
					  recos.add(rs.getString(6));
				  }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				if(rs != null){   // 关闭记录集   
			        try{   
			            rs.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			          }   
			      if(stmt != null){   // 关闭声明   
			        try{   
			            stmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 
	        }
			return recos;
		} 
	 //更新首页推荐项目编号
	 public int setRecos(List<String> recos){
		 int result=0;
		 PreparedStatement stmt = null;
			ResultSet rs = null;
			try {//update coordinates set longitude=?,latitude=?,place=?,house_project_id=? where id=?
				String sql = "update index_recommend_project set  recommend_num_1=?, recommend_num_2=?, recommend_num_3=?,recommend_num_4=?,recommend_num_5=?,recommend_num_6=? where id=?";
				  stmt = con.prepareStatement(sql);
				  stmt.setString(1,recos.get(0));
				  stmt.setString(2,recos.get(1));
				  stmt.setString(3,recos.get(2));
				  stmt.setString(4,recos.get(3));
				  stmt.setString(5,recos.get(4));
				  stmt.setString(6,recos.get(5));
				  stmt.setInt(7, 1);
				  result = stmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				if(rs != null){   // 关闭记录集   
			        try{   
			            rs.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			          }   
			      if(stmt != null){   // 关闭声明   
			        try{   
			            stmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 
	        }
			return result;
		}
}
