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
import com.kate.app.model.LatestSaleInfoVo;

@Repository 
public class LatestSaleInfoListDao extends BaseDao {
	public List<LatestSaleInfoVo> getLatestSaleInfo(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		List<LatestSaleInfoVo> latestSaleList=new ArrayList<LatestSaleInfoVo>();
		int houseProId=1;
		try {
			String sql = " select address,price,sales_type,sales_time,house_type from sucess_info t where  t.house_pro_id="+houseProId;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			String address=null;
			int price=0;
			String sales_type=null;
			String sales_time=null;
			int house_type=0;
			while(rs.next()){
				address=rs.getString("address");
				price=rs.getInt("price");
				sales_type=rs.getString("sales_type");
				sales_time=rs.getString("sales_time").substring(0, 10);
				house_type=rs.getInt("house_type");
				LatestSaleInfoVo latestSaleInfoVo=new LatestSaleInfoVo(address,price,house_type,sales_type,sales_time);
				latestSaleList.add(latestSaleInfoVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
		      if(pstmt != null){   // 关闭声明   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return latestSaleList;
	}
	//��������ɽ���� List
	public JSONArray listSuccessInfo(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = "select t.id,t.address,t.price,t.sales_type, t.sales_time,t.house_type,t.house_pro_id,h.project_name from sucess_info t LEFT JOIN house_project h on t.house_pro_id=h.id";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			jsonArray=ResultSetConverter.convert(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
		      if(pstmt != null){   // 关闭声明   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return jsonArray;
	} 
	//��������ɽ���� Add
	public int InsertSuccessInfo(String address,int price,String sales_type,java.util.Date sales_time,int house_type,int house_pro_id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		int exeResult=0;
		try {
			String sql = "insert into sucess_info(address,price,sales_type,sales_time,house_type,house_pro_id) values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
			pstmt.setInt(2, price);
			pstmt.setString(3, sales_type);
			pstmt.setDate(4, (java.sql.Date) sales_time);
			pstmt.setInt(5, house_type);
			pstmt.setInt(6, house_pro_id);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
		      if(pstmt != null){   // 关闭声明   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return exeResult;
	}
	//��������ɽ���� update
	public int updateSuccessInfo(int id,String address,int price,String sales_type,java.util.Date sales_time,int house_type,int house_pro_id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {
			String sql = "update sucess_info set address=?,price=?,sales_type=?,sales_time=?,house_type=? where id=? and house_pro_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
			pstmt.setInt(2, price);
			pstmt.setString(3, sales_type);
			pstmt.setDate(4, (java.sql.Date) sales_time);
			pstmt.setInt(5, house_type);
			pstmt.setInt(6, id);
			pstmt.setInt(7, house_pro_id);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
		      if(pstmt != null){   // 关闭声明   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return exeResult;
	}
	//��������ɽ���� delete
	public int delSuccessInfo(int id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		int exeResult=0;
		try {
			String sql = "delete from sucess_info where id="+id;
			  stmt = con.createStatement();
			exeResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
		      if(pstmt != null){   // 关闭声明   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return exeResult;
	}
}
