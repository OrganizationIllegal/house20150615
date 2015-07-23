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
import com.kate.app.model.AreaPeopleInfo;
import com.kate.app.model.FamilyIncome;
import com.kate.app.model.PeopleForeign;
import com.kate.app.model.PeopleInfo;
import com.kate.app.model.PeopleNation;
@Repository 
public class RegionPeopleDao extends BaseDao {
	public List<AreaPeopleInfo> getAreaPeopleInfo(String area_code){   //通过区域id查找区域人口信息
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<AreaPeopleInfo> list = new ArrayList<AreaPeopleInfo>();
		try {
			String sql = "select * from area_people where area_code=?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_code);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				AreaPeopleInfo data = new AreaPeopleInfo();
				data.setColumn1(rs.getString("column1"));
				data.setColumn2(rs.getString("column2"));
				data.setColumn3(rs.getString("column3"));
				data.setArea_id(rs.getInt("area_id"));
				data.setHouse_pro_id(rs.getInt("house_pro_id"));
				data.setId(rs.getInt("id"));
				data.setView_shunxu(rs.getInt("view_shunxu"));
				data.setPeople_datasource(rs.getString("people_datasource"));
				data.setPeople_date(rs.getTimestamp("people_date"));
				list.add(data);
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

		return list;
	}
	
	
	
	
	public List<PeopleInfo> getPeopleInfo(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<PeopleInfo> peopleInfoList=new ArrayList<PeopleInfo>();
		int houseProId=1;
		try {
			String sql = "select people_count,area,city from people_info t where t.house_pro_id="+houseProId;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			String people_count=null;
			int area=0;
			int city=0;
			while(rs.next()){
				people_count=rs.getString("people_count");
				area=rs.getInt("area");
				city=rs.getInt("city");
				PeopleInfo peopleInfo=new PeopleInfo(people_count,area,city);
				peopleInfoList.add(peopleInfo);
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
		return peopleInfoList;
	}
	public List<PeopleNation> getPeopleNation(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		List<PeopleNation> peopleNationList=new ArrayList<PeopleNation>();
		int houseProId=1;
		try {
			String sql = "select born_city,area,city from born_nation t where t.house_pro_id="+houseProId;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			String born_city=null;
			float area=0;
			float city=0;
			while(rs.next()){
				born_city=rs.getString("born_city");
				area=rs.getInt("area")/100;
				city=rs.getInt("city")/100;
				PeopleNation peopleNation=new PeopleNation(born_city,area,city);
				peopleNationList.add(peopleNation);
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
		return peopleNationList;
	}
	public List<PeopleForeign> getPeopleForeign(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<PeopleForeign> peopleForeignList=new ArrayList<PeopleForeign>();
		int houseProId=1;
		try {
			String sql = "select t.born_foreign,t.area,t.city from born_foreigns t where t.house_pro_id="+houseProId;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			String born_foreign=null;
			float area=0;
			float city=0;
			while(rs.next()){

				born_foreign=rs.getString("born_foreign");
				area=rs.getInt("area")/100;
				city=rs.getInt("city")/100;
				PeopleForeign peopleForeign=new PeopleForeign(born_foreign,area,city);
				peopleForeignList.add(peopleForeign);
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
		return peopleForeignList;
	}
	public List<FamilyIncome> getFamilyIncome(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<FamilyIncome> familyIncomeList=new ArrayList<FamilyIncome>();
		int houseProId=1;
		try {
			String sql = "select t.family_income,t.area,t.city from family_income t where t.house_pro_id="+houseProId;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			String family_income=null;
			float area=0;
			float city=0;
			while(rs.next()){
				family_income=rs.getString("family_income");
				area=rs.getInt("area")/100;
				city=rs.getInt("city")/100;
				FamilyIncome familyIncome=new FamilyIncome(family_income,area,city);
				familyIncomeList.add(familyIncome);
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
		return familyIncomeList;
	}
	//锟剿匡拷锟斤拷锟斤拷  锟斤拷
	public int InsertPeople(String people_count,int area,int city,int house_pro_id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {
			String sql = "insert into people_info(people_count,area,city,house_pro_id) values("+"'"+people_count+"'"+","+area+","+city+","+house_pro_id+") ";
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
	//锟剿匡拷锟斤拷锟斤拷  删
	public int DelPeopleInfo(int id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		int exeResult=0;
		try {
			String sql = "delete from people_info where id="+id;
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
	//锟剿匡拷锟斤拷锟斤拷  锟斤拷
	public JSONArray listPeopleInfo(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = " select t.id,t.people_count,t.area,t.city,t.house_pro_id,h.project_name from people_info t LEFT JOIN house_project h on t.house_pro_id=h.id;";
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
	//锟剿匡拷锟斤拷锟斤拷  锟斤拷
	public int updateAreaFamily(int id,String people_count,int area,int city,int house_pro_id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {
			String sql = "update people_info set people_count=?,area=?,city=? where id=? and house_pro_id=?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, people_count);
			pstmt.setInt(2, area);
			pstmt.setInt(3, city);
			pstmt.setInt(4, id);
			pstmt.setInt(5, house_pro_id);
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
	//锟斤拷锟斤拷锟斤拷 锟斤拷
	public int InsertPeopleNation(String born_city,int area,int city,int house_pro_id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		int exeResult=0;
		try {
			String sql = "insert into born_nation(born_city,area,city,house_pro_id) values(?,?,?,?)";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, born_city);
			pstmt.setInt(2, area);
			pstmt.setInt(3, city);
			pstmt.setInt(4, house_pro_id);
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
	//锟斤拷锟斤拷锟斤拷 删
	public int DelPeopleNation(int id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;


		int exeResult=0;
		try {
			String sql = "delete from born_nation where id="+id;
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
	//锟斤拷锟斤拷锟斤拷 锟斤拷
	public JSONArray listPeopleNation(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = " select t.id,t.born_city,t.area,t.city,t.house_pro_id,h.project_name from born_nation t LEFT JOIN house_project h on t.house_pro_id=h.id;";
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
	//锟斤拷锟斤拷锟斤拷 锟斤拷
	public int updatePeopleNation(int id,String born_city,int area,int city,int house_pro_id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		int exeResult=0;
		try {
			String sql = "update born_nation set born_city=?,area=?,city=? where id=? and house_pro_id=?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, born_city);
			pstmt.setInt(2, area);
			pstmt.setInt(3, city);
			pstmt.setInt(4, id);
			pstmt.setInt(5, house_pro_id);
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
	//锟斤拷锟斤拷锟斤拷锟�锟斤拷
	public int InsertPeopleForeign(String born_foreign,int area,int city,int house_pro_id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		int exeResult=0;
		try {
			String sql = "insert into born_foreigns(born_foreign,area,city,house_pro_id) values(?,?,?,?)";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, born_foreign);
			pstmt.setInt(2, area);
			pstmt.setInt(3, city);
			pstmt.setInt(4, house_pro_id);
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
	//锟斤拷锟斤拷锟斤拷锟�删
	public int DelPeopleForeign(int id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {
			String sql = "delete from born_foreigns where id="+id;
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
	//锟斤拷锟斤拷锟斤拷锟�锟斤拷
		public JSONArray listPeopleForeign(){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;


			JSONArray jsonArray=new JSONArray();
			try {
				String sql = " select t.id,t.born_foreign,t.area,t.city,t.house_pro_id,h.project_name from born_foreigns t LEFT JOIN house_project h on t.house_pro_id=h.id;";
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
	//锟斤拷锟斤拷锟斤拷锟�锟斤拷
		public int updatePeopleForeign(int id,String born_foreign,int area,int city,int house_pro_id){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			int exeResult=0;
			try {
				String sql = "update born_foreigns set born_foreign=?,area=?,city=? where id=? and house_pro_id=?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, born_foreign);
				pstmt.setInt(2, area);
				pstmt.setInt(3, city);
				pstmt.setInt(4, id);
				pstmt.setInt(5, house_pro_id);
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
		//平锟斤拷锟酵ワ拷锟斤拷锟�锟斤拷
		public int InsertFamilyIncome(String family_income,int area,int city,int house_pro_id){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			int exeResult=0;
			try {
				String sql = "insert into family_income(family_income,area,city,house_pro_id) values(?,?,?,?)";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, family_income);
				pstmt.setInt(2, area);
				pstmt.setInt(3, city);
				pstmt.setInt(4, house_pro_id);
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
		//平锟斤拷锟酵ワ拷锟斤拷锟�删
		public int DelFamilyIncome(int id){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			int exeResult=0;
			try {
				String sql = "delete from family_income where id="+id;
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
		//平锟斤拷锟酵ワ拷锟斤拷锟�锟斤拷
		public JSONArray listFamilyIncome(){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			JSONArray jsonArray=new JSONArray();
			try {
				String sql = " select t.id,t.family_income,t.area,t.city,t.house_pro_id,h.project_name from family_income t LEFT JOIN house_project h on t.house_pro_id=h.id;";
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
		//平锟斤拷锟酵ワ拷锟斤拷锟�锟斤拷
		public int updateFamilyIncome(int id,String family_income,int area,int city,int house_pro_id){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			int exeResult=0;
			try {
				String sql = "update family_income set family_income=?,area=?,city=? where id=? and house_pro_id=?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, family_income);
				pstmt.setInt(2, area);
				pstmt.setInt(3, city);
				pstmt.setInt(4, id);
				pstmt.setInt(5, house_pro_id);
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
}
