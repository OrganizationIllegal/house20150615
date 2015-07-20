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
import com.kate.app.model.HoldingTaxVo;
import com.kate.app.model.HouseTaxData;
import com.kate.app.model.HouseTaxVo;
@Repository 
public class HouseTaxDao extends BaseDao {
	 public List<HouseTaxVo> getHouseTaxVo(String proNum){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

		  List<HouseTaxVo> houseTaxVoList=new ArrayList<HouseTaxVo>();
		  
		  try {
				String sql = "select id, type,price,description from house_tax t where t.project_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, proNum);
				  rs = pstmt.executeQuery();
				String type=null;
				int id=0;
				int price=0;
				String description=null;
				while(rs.next()){
					id = rs.getInt("id");
					type=rs.getString("type");
					price=rs.getInt("price");
					description=rs.getString("description");
					HouseTaxVo houseTaxVo=new HouseTaxVo(id,type,price,description) ;
					houseTaxVoList.add(houseTaxVo);
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
			      if(pstmt != null){   // 关闭声明   
				        try{   
				            pstmt.close() ;   
				        }catch(SQLException e){   
				            e.printStackTrace() ;   
				        }   
				     } 

	        }
			return houseTaxVoList;
	  }
	 public List<HoldingTaxVo> getHoldingTaxVo(String proNum){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
		  List<HoldingTaxVo> holdingTaxVoList=new ArrayList<HoldingTaxVo>();
		 
		  try {
				String sql = "select id,type,price,description from holding_finace t where t.project_num='"+proNum+"'";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				String type=null;
				int price=0;
				int id=0;
				String description=null;
				while(rs.next()){
					id=rs.getInt("id");
					type=rs.getString("type");
					price=rs.getInt("price");
					description=rs.getString("description");
					HoldingTaxVo holdingTaxVo=new HoldingTaxVo(id,type,price,description);
					holdingTaxVoList.add(holdingTaxVo);
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
			      if(pstmt != null){   // 关闭声明   
				        try{   
				            pstmt.close() ;   
				        }catch(SQLException e){   
				            e.printStackTrace() ;   
				        }   
				     } 

	        }
			return holdingTaxVoList;
	  }
	 public List<HouseTaxData> getHouseTaxData(String proNum){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
		  List<HouseTaxData> holdingTaxVoList=new ArrayList<HouseTaxData>();
		  
		  try {
				String sql = "select type,price,description from house_tax t where t.project_num='"+proNum+"'";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				String type=null;
				int price=0;
				String description=null;
				while(rs.next()){
					price=rs.getInt("price");
					type=rs.getString("type")+" 约"+price+"澳元"+"\n"+rs.getString("description");
					HouseTaxData holdingTaxVo=new HouseTaxData(type,price);
					holdingTaxVoList.add(holdingTaxVo);
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
			      if(pstmt != null){   // 关闭声明   
				        try{   
				            pstmt.close() ;   
				        }catch(SQLException e){   
				            e.printStackTrace() ;   
				        }   
				     } 

	        }
			return holdingTaxVoList;
	  }
	 public List<HouseTaxData> getHoldingData(String proNum){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
		 List<HouseTaxData> holdingTaxVoList=new ArrayList<HouseTaxData>();
		 
		  try {
				String sql = "select type,price,description from holding_finace t where t.project_num='"+proNum+"'";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				String type=null;
				int price=0;
				String description=null;
				while(rs.next()){
					price=rs.getInt("price");
					type=rs.getString("type")+" 约"+price+"澳元"+"\n"+rs.getString("description");
					HouseTaxData holdingTaxVo=new HouseTaxData(type,price);
					holdingTaxVoList.add(holdingTaxVo);
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
			      if(pstmt != null){   // 关闭声明   
				        try{   
				            pstmt.close() ;   
				        }catch(SQLException e){   
				            e.printStackTrace() ;   
				        }   
				     } 

	        }
			return holdingTaxVoList;
	 }

 
	 //锟斤拷锟斤拷税锟斤拷 List

	 //锟斤拷锟斤拷税锟斤拷 List

	 public JSONArray listHouseTax(){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			JSONArray jsonArray=new JSONArray();
			try {
				String sql = "select * from house_tax";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				jsonArray=ResultSetConverter.convert(rs);
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
	//锟斤拷锟斤拷税锟斤拷 Add
	 public int InsertHouseTax(String type,int price,String description,String project_num,int view_shunxu,String house_name){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

		 int exeResult=0;
			try {
				String sql = "insert into house_tax(type,price,description,project_num,view_shunxu,house_name) values(?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, type);
				pstmt.setInt(2, price);
				pstmt.setString(3, description);
				pstmt.setString(4, project_num);
				pstmt.setInt(5, view_shunxu);
				pstmt.setString(6, house_name);
				exeResult = pstmt.executeUpdate();
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
	//锟斤拷锟斤拷税锟斤拷 update
	 public int updateHouseTax(int id,String type,int price,String description,String project_num,int view_shunxu,String house_name){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
		 int exeResult=0;
			try {
				String sql = "update house_tax set type=?,price=?,description=? ,project_num=?,view_shunxu=?,house_name=? where id="+id;
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, type);
				pstmt.setInt(2, price);
				pstmt.setString(3, description);
				pstmt.setString(4, project_num);
				pstmt.setInt(5, view_shunxu);
				pstmt.setString(6, house_name);
				exeResult = pstmt.executeUpdate();
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
	//锟斤拷锟斤拷税锟斤拷 delete
	 public int delHouseTax(int id){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			int exeResult=0;
			try {
				String sql = "delete from house_tax where id="+id;
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
	//锟斤拷锟叫成憋拷 List
	 public JSONArray listHoldingCost(){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			JSONArray jsonArray=new JSONArray();
			try {
				String sql = "select * from holding_finace";
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
	//锟斤拷锟叫成憋拷 Add
	 public int InsertHoldingCost(String type,int price,String description,String  project_num,int view_shunxu,String house_name){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
		 int exeResult=0;
			try {
				String sql = "insert into holding_finace(type,price,description,project_num,view_shunxu,house_name) values(?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, type);
				pstmt.setInt(2, price);
				pstmt.setString(3, description);
				pstmt.setString(4, project_num);
				pstmt.setInt(5, view_shunxu);
				pstmt.setString(6, house_name);
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
	//锟斤拷锟叫成憋拷 update
	 public int updateHoldingCost(int id,String type,int price,String description,String project_num,int view_shunxu,String house_name){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

		 int exeResult=0;
			try {
				String sql = "update holding_finace set type=?,price=?,description=?,view_shunxu=? ,project_num=?,house_name=? where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, type);
				pstmt.setInt(2, price);
				pstmt.setString(3, description);
				pstmt.setInt(4, view_shunxu);
				pstmt.setString(5, project_num);
				pstmt.setString(6, house_name);
				pstmt.setInt(7, id);
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
	//锟斤拷锟叫成憋拷 delete
	 public int delHoldingCost(int id){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			int exeResult=0;
			try {
				String sql = "delete from holding_finace where id="+id;
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
