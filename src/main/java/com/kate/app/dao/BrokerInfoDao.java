package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.kate.app.model.BrokerInfo;
import com.kate.app.model.LeiXing;

@Repository 
public class BrokerInfoDao extends BaseDao {
	
	public int isDuplicate(String broker_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int isexist=0;
		try {
			String sql = " SELECT count(*) num from broker_info where broker_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, broker_num);
			  rs = pstmt.executeQuery();
			if(rs.next()){
				isexist=rs.getInt(1);
			}
			if(isexist>0){
				return 1;
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
		return 0;
	}
	public List<BrokerInfo> listBrokerInfo(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<BrokerInfo> brokerInfoList=new ArrayList<BrokerInfo>();
		try {
			String sql = "select * from broker_info t";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
		    int id=0;
		    String broker_img=null;
		    String broker_language=null;
		    String broker_name=null;
		    String broker_region=null;
		    String office=null;
		    String introduction=null;
		    String broker_num=null;
		    int broker_experience=0;
		    String broker_type=null;
		    String broker_zizhi=null;
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	broker_img=rs.getString("broker_img");
		    	broker_language=rs.getString("broker_language");
		    	broker_name=rs.getString("broker_name");
		    	broker_region=rs.getString("broker_region");
		    	office=rs.getString("office");
		    	introduction=rs.getString("introduction");
		    	broker_num=rs.getString("broker_num");
		    	broker_experience=rs.getInt("broker_experience");
		    	broker_type=rs.getString("broker_type");
		    	broker_zizhi=rs.getString("broker_zizhi");
		    	BrokerInfo brokerInfo=new BrokerInfo(id,broker_name,broker_language,broker_region, broker_img, office,introduction,broker_num,broker_experience,broker_type,broker_zizhi);
		    	brokerInfoList.add(brokerInfo);

//		    	BrokerInfo brokerInfo=new BrokerInfo(id,broker_name,broker_language,broker_region, broker_img, office,introduction);
//		    	brokerInfoList.add(brokerInfo);

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
		return brokerInfoList;
	} 
	//閸欐垿锟介悾娆掆枅
	public int InsertMessage(String message_content,String time,int project_id,int viewed,int type,int userid){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {
			String sql = "insert into message(message_content,message_time,project_id,viewed,type,userid) values (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, message_content);
			pstmt.setString(2, time);
			pstmt.setInt(3, project_id);
			pstmt.setInt(4, viewed);
			pstmt.setInt(5, type);
			pstmt.setInt(6, userid);
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
	
	
	
	public List<BrokerInfo> BrokerInfoList(int proId){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		List<BrokerInfo> brokerInfoList=new ArrayList<BrokerInfo>();
		try {
			String sql = "select * from broker_info where house_pro_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, proId);
			  rs = pstmt.executeQuery();
			
		    while(rs.next()){
		    	BrokerInfo data = new BrokerInfo();
		    	data.setBroker_experience(rs.getInt("broker_experience"));
		    	data.setBroker_img(rs.getString("broker_img"));
		    	data.setBroker_language(rs.getString("broker_language"));
		    	data.setBroker_name(rs.getString("broker_name"));
		    	data.setBroker_num(rs.getString("broker_num"));
		    	data.setBroker_region(rs.getString("broker_region"));
		    	data.setBroker_type(rs.getString("broker_type"));
		    	data.setBroker_zizhi(rs.getString("broker_zizhi"));
		    	data.setId(rs.getInt("id"));
		    	data.setIntroduction(rs.getString("introduction"));
		    	data.setOffice(rs.getString("office"));
		    	brokerInfoList.add(data);
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
		return brokerInfoList;
	} 
	
	
	public BrokerInfo getBrokerInfo(int id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		BrokerInfo data = new BrokerInfo();
		List<LeiXing> leixingList = new ArrayList<LeiXing>();
		List<String> areaList = new ArrayList<String>();
		LeiXing temp = null;
		try {
			String sql = "select * from broker_info a, broker_interested_type b, interest_type c where a.id = "+id+" and a.broker_num=b.broker_num and b.interested_num=c.type_num";
			/*pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			  rs = pstmt.executeQuery();*/
			 stmt = con.createStatement();
			 rs = stmt.executeQuery(sql);
			 while(rs.next()){
		    	data.setBroker_experience(rs.getInt("broker_experience"));
		    	data.setBroker_img(rs.getString("broker_img"));
		    	data.setBroker_language(rs.getString("broker_language"));
		    	data.setBroker_name(rs.getString("broker_name"));
		    	data.setBroker_num(rs.getString("broker_num"));
		    	data.setBroker_region(rs.getString("broker_region"));
		    	data.setBroker_type(rs.getString("broker_type"));
		    	data.setBroker_zizhi(rs.getString("broker_zizhi"));
		    	data.setId(rs.getInt("id"));
		    	data.setIntroduction(rs.getString("introduction"));
		    	data.setOffice(rs.getString("office"));
		    	/*String area_num = rs.getString("area_code");
		    	if(area_num!=null && !"".equals(area_num)){
		    		String area_name = getAreaName(area_num);
		    		if(area_name!=null && !"".equals(area_name)){
		    			areaList.add(area_name);
		    		}
		    	}*/
		    	String leixing = rs.getString("type_name");
		    	String leixingImg = rs.getString("type_image");
		    	if((leixing!=null && !"".equals(leixing)) || (leixingImg!=null && !"".equals(leixingImg))){
		    		temp = new LeiXing();
			    	temp.setLeixing(leixing);
			    	temp.setLeixingImg(leixingImg);
			    	leixingList.add(temp);
		    	}
		    	data.setLeixingInfo(leixingList);
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
		return data;
	} 
	
	
	
	
	public String getAreaName(String area_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String area_code = "";
		try {
			String sql = " SELECT * from area_info where area_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_num);
			rs = pstmt.executeQuery();
			while(rs.next()){
			
				area_code =  rs.getString("area_name");
				
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
		return area_code;
	}
	
	
	
	
	
	
	//根据项目推荐经纪人
	public List<BrokerInfo> getRecommendBroker(String project_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<BrokerInfo> recommendbrokerList = new ArrayList<BrokerInfo>();
		try {
			String sql = "select * from area_recommend_broker where project_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project_num);
			  rs = pstmt.executeQuery();
		    while(rs.next()){
		    	String broker1=rs.getString("broker_code1");
		    	String broker2=rs.getString("broker_code2");
		    	String broker3=rs.getString("broker_code3");
		    	if(broker1!=null && !"".equals(broker1)){
		    		BrokerInfo brokerInfo1=findBrokerbyId(broker1);
		    		recommendbrokerList.add(brokerInfo1);
		    	}
		    	if(broker2!=null && !"".equals(broker2)){
		    		BrokerInfo brokerInfo2=findBrokerbyId(broker2);
		    		recommendbrokerList.add(brokerInfo2);
		    	}
		    	if(broker3!=null && !"".equals(broker3)){
		    		BrokerInfo brokerInfo3=findBrokerbyId(broker3);
		    		recommendbrokerList.add(brokerInfo3);
		    	}
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
		return recommendbrokerList;
		
	}
	
	//根据区域推荐经纪人
		public List<BrokerInfo> getRecommendBrokerByArea(String area_code){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			List<BrokerInfo> recommendbrokerList=new ArrayList<BrokerInfo>();
			try {
				String sql = "select * from area_recommend_broker where area_code = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, area_code);
				  rs = pstmt.executeQuery();
			    while(rs.next()){
			    	String broker1=rs.getString("broker_code1");
			    	String broker2=rs.getString("broker_code2");
			    	String broker3=rs.getString("broker_code3");
			    	if(broker1!=null){
			    		BrokerInfo brokerInfo1=findBrokerbyId(broker1);
			    		recommendbrokerList.add(brokerInfo1);
			    	}
			    	if(broker2!=null){
			    		BrokerInfo brokerInfo2=findBrokerbyId(broker2);
			    		recommendbrokerList.add(brokerInfo2);
			    	}
			    	if(broker3!=null){
			    		BrokerInfo brokerInfo3=findBrokerbyId(broker3);
			    		recommendbrokerList.add(brokerInfo3);
			    	}
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
			return recommendbrokerList;
			
		}
	public BrokerInfo findBrokerbyId(String broker_code){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		BrokerInfo brokerInfo=new BrokerInfo();
		try {
			String sql = "select * from broker_info where broker_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, broker_code);
			  rs = pstmt.executeQuery();
			
		    while(rs.next()){
		    	brokerInfo.setId(Integer.parseInt(rs.getString("id")));
		    	brokerInfo.setBroker_num(rs.getString("broker_num"));
		    	brokerInfo.setBroker_name(rs.getString("broker_name"));
		    	brokerInfo.setBroker_img(rs.getString("broker_img"));
		    	brokerInfo.setBroker_experience(Integer.parseInt(rs.getString("broker_experience")));
		    	brokerInfo.setBroker_language(rs.getString("broker_language"));
		    	brokerInfo.setBroker_region(rs.getString("broker_region"));
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
		return brokerInfo;
		
	}
	
	
	public List<String> fuwuArea(String broker_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> areaList = new ArrayList<String>();
		try {
			String sql = "select distinct area_code from broker_service_area where broker_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, broker_num);
			rs = pstmt.executeQuery();
			
		    while(rs.next()){
		    	
		    	String area_code = rs.getString("area_code");
		    	if(area_code!=null && !"".equals(area_code)){
		    		String area_name = getAreaName(area_code);
		    		if(area_name!=null && !"".equals(area_name)){
		    			areaList.add(area_name);
		    		}
		    	
		    }
		 } 
		}catch (Exception e) {
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
		return areaList;
		
	}
	public String findBrokerInfo(int id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String broker_num = "";
		BrokerInfo brokerInfo=new BrokerInfo();
		try {
			String sql = "select * from broker_info where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			  rs = pstmt.executeQuery();
			
		    while(rs.next()){
		    	
		    	broker_num = rs.getString("broker_num");
		    	
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
		return broker_num;
		
	}
	
	
	
	public String findBrokerbyName(String broker_name){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String brokerNum=null;
		try {
			String sql = "select * from broker_info where broker_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, broker_name);
			  rs = pstmt.executeQuery();
			
		    while(rs.next()){
		    	brokerNum = rs.getString("broker_num");
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
		return brokerNum;
		
	}
	//寰楀埌缁忕邯浜虹被鍨�
	public List<String> getBrokerTypeList(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> typeList=new ArrayList<String>();
		try{
			String sql="select distinct t.broker_type from broker_info t ";
			pstmt=con.prepareStatement(sql);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				typeList.add(rs.getString("broker_type"));
			}
			
		}catch(Exception e){
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
		return typeList;
	}
	//寰楀埌缁忕邯浜哄尯鍩�
	public List<String> getBrokerRegionList(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> regionList=new ArrayList<String>();
		try{
			String sql="select distinct t.broker_region from broker_info t ";
			pstmt=con.prepareStatement(sql);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				regionList.add(rs.getString("broker_region"));
			}
			
		}catch(Exception e){
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
		return regionList;
	}
	//寰楀埌缁忕邯浜鸿瑷�
	public Set<String> getBrokerLanguageList(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Set<String> languageList=new HashSet<String>();
		try{
			String sql="select distinct t.broker_language from broker_info t ";
			pstmt=con.prepareStatement(sql);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				//languageList.add(rs.getString("broker_language"));
				String language_str=rs.getString("broker_language");
				String language_trim=language_str.trim();
				String[] array=language_str.split(" ");
				for (String a:array){
					languageList.add(a);
				}
			}
			
		}catch(Exception e){
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
		return languageList;
	}
	
	
}
