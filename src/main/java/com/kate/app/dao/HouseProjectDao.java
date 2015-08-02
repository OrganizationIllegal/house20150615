package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.BrokerInfo;
import com.kate.app.model.DeveloperInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.Project;
import com.kate.app.model.ProjectDescImage;
import com.kate.app.model.ProjectImage;
@Repository 
public class HouseProjectDao extends BaseDao{
	public HouseProject HouseProjectDao(int id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		HouseProject projectInfo = new HouseProject();
		BrokerInfo brokerInfo = new BrokerInfo();
		
		try{
			String sql = "select * from house_project where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				projectInfo.setProject_name(rs.getString("project_name"));
				projectInfo.setArea_num(rs.getString("area_num"));
				projectInfo.setProject_img(rs.getString("project_img"));
				projectInfo.setProject_logo(rs.getString("project_logo"));
				projectInfo.setProject_nation(rs.getString("project_nation"));
				projectInfo.setProject_address(rs.getString("project_address"));
				projectInfo.setProject_area(rs.getString("project_area"));
				projectInfo.setProject_price_qi(rs.getString("project_price_qi"));
				projectInfo.setProject_price_int_qi(rs.getInt("project_price_int_qi"));
				projectInfo.setProject_type(rs.getString("project_type"));
				projectInfo.setProject_sales_remain(rs.getInt("project_sales_remain"));
				//projectInfo.setProject_finish_time(rs.getTimestamp("project_finish_time"));
				projectInfo.setProject_finish_time(rs.getString("project_finish_time"));
				projectInfo.setProject_desc(rs.getString("project_desc"));
				projectInfo.setProject_city(rs.getString("project_city"));
				projectInfo.setProject_house_type(rs.getString("project_house_type"));
				projectInfo.setProject_high(rs.getString("project_high"));
				projectInfo.setProject_price(rs.getString("project_price"));
				projectInfo.setProject_lan_cn(rs.getString("project_lan_cn"));
				projectInfo.setProject_lan_en(rs.getString("project_lan_en"));
				projectInfo.setProject_num(rs.getString("project_num"));
				projectInfo.setProject_vedio(rs.getString("project_vedio"));
				projectInfo.setProject_zhou(rs.getString("project_zhou"));
				projectInfo.setArea_qujian(rs.getString("area_qujian"));
				projectInfo.setGps(rs.getString("gps"));
				projectInfo.setReturn_money(rs.getString("return_money"));
				projectInfo.setDeveloper_id(rs.getInt("developer_id"));
				projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
				projectInfo.setProject_high_price(rs.getString("project_high_price"));
				projectInfo.setProject_min_price(rs.getString("project_min_price"));
				projectInfo.setMax_area(rs.getInt("max_area"));
				projectInfo.setMin_area(rs.getInt("min_area"));
				projectInfo.setArea_id(rs.getInt("area_id"));
				projectInfo.setMianji(rs.getString("mianji"));
				projectInfo.setRecommend_id_1(rs.getString("recommend_id_1"));
				projectInfo.setRecommend_id_2(rs.getString("recommend_id_2"));
				projectInfo.setRecommend_id_3(rs.getString("recommend_id_3"));
				projectInfo.setWuyefei(rs.getString("wuyefei"));
				

			}
			
		}catch (Exception e) {
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
		return projectInfo;
	}
	
	public HouseProject HouseProjectByNumDao(String pro_num){
		DecimalFormat df = new DecimalFormat("#,###,###");
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		HouseProject projectInfo = null;
		BrokerInfo brokerInfo = null;
		try{
			String sql = "select * from house_project where project_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pro_num);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				projectInfo = new HouseProject();
				brokerInfo = new BrokerInfo();
				projectInfo.setProject_name(rs.getString("project_name"));
				projectInfo.setArea_num(rs.getString("area_num"));
				projectInfo.setProject_img(rs.getString("project_img"));
				projectInfo.setProject_logo(rs.getString("project_logo"));
				projectInfo.setProject_nation(rs.getString("project_nation"));
				projectInfo.setProject_address(rs.getString("project_address"));
				projectInfo.setProject_area(rs.getString("project_area"));
				projectInfo.setProject_price_qi(rs.getString("project_price_qi"));
				projectInfo.setProject_price_int_qi(rs.getInt("project_price_int_qi"));
				projectInfo.setProject_price_int_qi_str(rs.getString("project_price_int_qi")==null?"N/A":df.format(Integer.parseInt(rs.getString("project_price_int_qi"))));
				
				projectInfo.setProject_type(rs.getString("project_type"));
				projectInfo.setProject_sales_remain(rs.getInt("project_sales_remain"));
				//projectInfo.setProject_finish_time(rs.getTimestamp("project_finish_time"));
				projectInfo.setProject_finish_time(rs.getString("project_finish_time"));
				projectInfo.setProject_desc(rs.getString("project_desc"));
				projectInfo.setProject_city(rs.getString("project_city"));
				projectInfo.setProject_house_type(rs.getString("project_house_type"));
				projectInfo.setProject_high(rs.getString("project_high"));
				projectInfo.setProject_price(rs.getString("project_price"));
				projectInfo.setProject_lan_cn(rs.getString("project_lan_cn"));
				projectInfo.setProject_lan_en(rs.getString("project_lan_en"));
				projectInfo.setProject_num(rs.getString("project_num"));
				projectInfo.setProject_vedio(rs.getString("project_vedio"));
				projectInfo.setProject_zhou(rs.getString("project_zhou"));
				projectInfo.setArea_qujian(rs.getString("area_qujian"));
				projectInfo.setGps(rs.getString("gps"));
				projectInfo.setReturn_money(rs.getString("return_money"));
				projectInfo.setDeveloper_id(rs.getInt("developer_id"));
				projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
				projectInfo.setProject_min_price(rs.getString("project_min_price")==null?"N/A":df.format(Integer.parseInt(rs.getString("project_min_price"))));
				projectInfo.setProject_high_price(rs.getString("project_high_price")==null?"N/A":df.format(Integer.parseInt(rs.getString("project_high_price"))));
				projectInfo.setMax_area(rs.getInt("max_area"));
				projectInfo.setMin_area(rs.getInt("min_area"));
				projectInfo.setArea_id(rs.getInt("area_id"));
				projectInfo.setMianji(rs.getString("mianji"));
				projectInfo.setRecommend_id_1(rs.getString("recommend_id_1"));
				projectInfo.setRecommend_id_2(rs.getString("recommend_id_2"));
				projectInfo.setRecommend_id_3(rs.getString("recommend_id_3"));
				projectInfo.setWuyefei(rs.getString("wuyefei"));
				projectInfo.setWalk_num(rs.getInt("walk_num"));

			}
			
		}catch (Exception e) {
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
		return projectInfo;
	}
	
	
	
	public List<ProjectDescImage> HouseProjectImageList(String pro_num){
		DecimalFormat df = new DecimalFormat("#,###,###");
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		List<ProjectDescImage> imageList = new ArrayList<ProjectDescImage>();
		
		try{
			String sql = "select * from project_desc_image where project_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pro_num);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				ProjectDescImage image = new ProjectDescImage();
				image.setName(rs.getString("image_name"));
				imageList.add(image);
			}
			
		}catch (Exception e) {
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
		return imageList;
	}
	
	
	
	/*
	 * �鿴�����˵���Ϣ
	 */
	public BrokerInfo BrokerInfoDao(int id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		BrokerInfo brokerInfo = new BrokerInfo();
		try{
			String sql = "select * from broker_info where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				brokerInfo.setBroker_num(rs.getString("broker_num"));
				brokerInfo.setBroker_name(rs.getString("broker_name"));
				brokerInfo.setBroker_img(rs.getString("broker_img"));
				brokerInfo.setBroker_experience(rs.getInt("broker_experience"));
				brokerInfo.setBroker_language(rs.getString("broker_language"));
				brokerInfo.setBroker_region(rs.getString("broker_region"));
				brokerInfo.setBroker_type(rs.getString("broker_type"));
				brokerInfo.setBroker_zizhi(rs.getString("broker_zizhi"));
				brokerInfo.setIntroduction(rs.getString("introduction"));
			}
			
		}catch (Exception e) {
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
	

	
	
	/*
	 * �鿴�����̵���Ϣ
	 */
	public DeveloperInfo DeveloperInfoDao(String developer_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		DeveloperInfo developerInfo = new DeveloperInfo();
		try{
			String sql = "select * from developer_info where developer_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, developer_num);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				developerInfo.setDeveloper_name(rs.getString("developer_name"));
				developerInfo.setDeveloper_desc(rs.getString("developer_desc"));
				developerInfo.setDeveloper_logo(rs.getString("developer_logo"));
			}
			
		}catch (Exception e) {
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
		return developerInfo;
	}
	
	
	

	/*
	 * Project Images
	 */
	public List<ProjectImage> HouseProjectImageDao(String proNum){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<ProjectImage> list = new ArrayList<ProjectImage>();
		try{
			String sql = "select * from project_desc_image where project_num=? order by view_shunxu";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, proNum);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				ProjectImage projectImage = new ProjectImage();
				projectImage.setId(rs.getInt("id"));
				projectImage.setImage_name(rs.getString("image_name"));
				projectImage.setImage_type(rs.getString("image_type"));
				projectImage.setView_shunxu(rs.getInt("view_shunxu"));
				
				list.add(projectImage);
			}
			
		}catch (Exception e) {
            
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
		return list;
	}
	
	/*
	 * Project vedio
	 */
	public String HouseProjectVedioDao(String proNum){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String vedio=null;
		try{
			String sql = "select project_vedio from house_project where project_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, proNum);
			rs = pstmt.executeQuery();
			vedio=rs.getString("project_vedio");			
		}catch (Exception e) {
            
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
		return vedio;
	}
	
	/*
	 * Project Images
	 */
	public List<ProjectImage> HousePeitaoImageDao(String proNum){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<ProjectImage> list = new ArrayList<ProjectImage>();
		try{
			String sql = "select * from project_peitao_image where project_num=? order by view_shunxu";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, proNum);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				ProjectImage projectImage = new ProjectImage();
				projectImage.setId(rs.getInt("id"));
				projectImage.setImage_name(rs.getString("image_name"));
				projectImage.setImage_type(rs.getString("image_type"));
				projectImage.setView_shunxu(rs.getInt("view_shunxu"));
				projectImage.setHouse_pro_id(rs.getInt("house_pro_id"));
				list.add(projectImage);
			}
			
		}catch (Exception e) {
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
		return list;
	}
	
	
	public HouseProject HouseProjectByAreaNumDao(String areaNum){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		HouseProject projectInfo = new HouseProject();
		BrokerInfo brokerInfo = new BrokerInfo();
		try{
			String sql = "select * from house_project where area_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, areaNum);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				projectInfo.setProject_name(rs.getString("project_name"));
				projectInfo.setProject_img(rs.getString("project_img"));
				projectInfo.setProject_logo(rs.getString("project_logo"));
				projectInfo.setProject_nation(rs.getString("project_nation"));
				projectInfo.setProject_address(rs.getString("project_address"));
				projectInfo.setProject_area(rs.getString("project_area"));
				projectInfo.setProject_price_qi(rs.getString("project_price_qi"));
				projectInfo.setProject_price_int_qi(rs.getInt("project_price_int_qi"));
				projectInfo.setProject_type(rs.getString("project_type"));
				projectInfo.setProject_sales_remain(rs.getInt("project_sales_remain"));
				//projectInfo.setProject_finish_time(rs.getTimestamp("project_finish_time"));
				projectInfo.setProject_desc(rs.getString("project_desc"));
				projectInfo.setProject_city(rs.getString("project_city"));
				projectInfo.setProject_house_type(rs.getString("project_house_type"));
				projectInfo.setProject_high(rs.getString("project_high"));
				projectInfo.setProject_price(rs.getString("project_price"));
				projectInfo.setProject_lan_cn(rs.getString("project_lan_cn"));
				projectInfo.setProject_lan_en(rs.getString("project_lan_en"));
				projectInfo.setProject_num(rs.getString("project_num"));
				projectInfo.setProject_vedio(rs.getString("project_vedio"));
				projectInfo.setProject_zhou(rs.getString("project_zhou"));
				projectInfo.setArea_qujian(rs.getString("area_qujian"));
				projectInfo.setGps(rs.getString("gps"));
				projectInfo.setReturn_money(rs.getString("return_money"));
				projectInfo.setDeveloper_id(rs.getInt("developer_id"));
				projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
				projectInfo.setProject_high_price(rs.getString("project_high_price"));
				projectInfo.setProject_min_price(rs.getString("project_min_price"));
				projectInfo.setMax_area(rs.getInt("max_area"));
				projectInfo.setMin_area(rs.getInt("min_area"));
				projectInfo.setArea_id(rs.getInt("area_id"));
				projectInfo.setMianji(rs.getString("mianji"));
				projectInfo.setRecommend_id_1(rs.getString("recommend_id_1"));
				projectInfo.setRecommend_id_2(rs.getString("recommend_id_2"));
				projectInfo.setRecommend_id_3(rs.getString("recommend_id_3"));
				projectInfo.setWuyefei(rs.getString("wuyefei"));

			}
			
		}catch (Exception e) {
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
		return projectInfo;
	}
	//根据项目id查找项目编号
	public String findProjectNumById(int proid){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String project_num=null;
		try{
			String sql = "select project_num from house_project where id="+proid;
			pstmt = con.prepareStatement(sql);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				project_num=rs.getString("project_num");
			}
			
		}catch (Exception e) {
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
		return project_num;
	}
	
}
