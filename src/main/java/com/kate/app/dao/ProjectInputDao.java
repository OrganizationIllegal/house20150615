package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.AreaTuijianBroker;
import com.kate.app.model.Broker;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.BrokerType;
import com.kate.app.model.DeveloperInfo;
import com.kate.app.model.FujinPeiTao;
import com.kate.app.model.FujinSchool;
import com.kate.app.model.HoldCost;
import com.kate.app.model.HouseInfo1;
import com.kate.app.model.HouseProject;
import com.kate.app.model.HouseTax;
import com.kate.app.model.NewsBoke;
import com.kate.app.model.Project;
import com.kate.app.model.ProjectDescImage;
import com.kate.app.model.ProjectKey;
import com.kate.app.model.ProjectPeiTao;
import com.kate.app.model.SchoolInfo;
import com.kate.app.model.ServiceArea;
import com.kate.app.model.ZhiYeZhiDao;

@Repository 
public class ProjectInputDao extends BaseDao {
	public int isDeveloperDuplicate(String developername,String nationname){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int isexist=0;
		try {
			String sql = " SELECT count(*) num from developer_info where developername=? and nation=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, developername);
			pstmt.setString(2, nationname);
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
	//寰楀埌寮�鍙戝晢鐨勭紪鍙峰強鍚嶇О
	public List<String> getDeveloperCodeName(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> codeAndNameSet=new ArrayList<String>();
		try {
			String sql ="select t.developer_num,t.developer_name from developer_info t order by developer_name asc ";
			 pstmt = con.prepareStatement(sql);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				//String codeAndName_str=rs.getString("developer_num")+","+rs.getString("developer_name");
				String codeAndName_str=rs.getString("developer_num");
				codeAndNameSet.add(codeAndName_str);
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
		return codeAndNameSet;
	}
	//寰楀埌鎵�鏈夊鏍＄殑鍚嶅瓧
	public List<String> getAllSchoolName(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> schoolList=new ArrayList<String>();
		try {
			String sql ="select school_name from school_info  order by school_name asc";
			 pstmt = con.prepareStatement(sql);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				String school_name=rs.getString("school_name");
				schoolList.add(school_name);
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
		return schoolList;
	}
        //根据项目编号拿到项目关键字
		public ProjectKey getKeyByNum(String proNum){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			ProjectKey key=new ProjectKey();
			try {
				String sql ="select * from project_key where project_num=?";
				 pstmt = con.prepareStatement(sql);
				 pstmt.setString(1,proNum );
				  rs = pstmt.executeQuery();
				while(rs.next()){
					key.setXinkaipan(rs.getString("xinkaipan"));
					key.setHuaren(rs.getString("huaren"));
					key.setRemen(rs.getString("remen"));
					key.setXuequ(rs.getString("xuequ"));
					key.setBaozu(rs.getString("baozu"));
					key.setDaxue(rs.getString("daxue"));
					key.setCenter(rs.getString("center"));
					key.setTraffic(rs.getString("traffic"));
					key.setXianfang(rs.getString("xianfang"));
					key.setMaidi(rs.getString("maidi"));
					key.setId(rs.getInt("id"));
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
			return key;
		}
	//鏍规嵁椤圭洰id寰楀埌椤圭洰缂栧彿
	public String getProNumById(int id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String pronum=null;
		try {
			String sql =" select t.project_num  from house_project t WHERE id ="+id;
			 pstmt = con.prepareStatement(sql);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				pronum=rs.getString("project_num");
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
		return pronum;
	}
	//鏍规嵁椤圭洰椤圭洰缂栧彿鑾峰彇鎴峰瀷鍙婁俊鎭�
	public List<HouseInfo1> getHouseInfoByProNum(String proNum){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<HouseInfo1> houseinfoList=new ArrayList<HouseInfo1>();
		try {
			String sql ="select * from house_info where project_num =?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1,proNum );
			  rs = pstmt.executeQuery();
			while(rs.next()){
				HouseInfo1 houseInfo1=new HouseInfo1();
				houseInfo1.setId(Integer.parseInt(rs.getString("id")));
				houseInfo1.setHousename(rs.getString("house_name"));
				houseInfo1.setHouseimg(rs.getString("house_img"));
				houseInfo1.setHouseprice(rs.getString("house_price"));
				houseInfo1.setJianzhu_mianji(rs.getString("jianzhu_area"));
				houseInfo1.setTudi_mianji(rs.getString("tudi_area"));
				houseInfo1.setRoom_num(rs.getInt("house_room_num"));
				houseInfo1.setShinei_mianji(rs.getString("house_size_in"));
				houseInfo1.setShiwai_mianji(rs.getString("house_size_out"));
				houseInfo1.setWc_num(rs.getInt("house_toilet_num"));
				houseinfoList.add(houseInfo1);
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
		return houseinfoList;
	}
	
	//鏍规嵁椤圭洰椤圭洰缂栧彿鑾峰彇椤圭洰閰嶅
		public List<ProjectPeiTao> getProjectpeiTaoByProNum(String proNum){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;			List<ProjectPeiTao> projectPeiTaoList=new ArrayList<ProjectPeiTao>();
			try {
				String sql ="select * from project_peitao_image  where project_num =?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1,proNum );
				  rs = pstmt.executeQuery();
				while(rs.next()){
					ProjectPeiTao projectPeiTao=new ProjectPeiTao();
					projectPeiTao.setId(rs.getInt("id"));
					projectPeiTao.setName(rs.getString("image_name"));
					projectPeiTao.setShunxu(rs.getInt("view_shunxu"));
					projectPeiTaoList.add(projectPeiTao);
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
			return projectPeiTaoList;
		}
		//鏍规嵁椤圭洰椤圭洰缂栧彿鑾峰彇椤圭洰鍥剧墖
				public List<ProjectDescImage> getProjectImageByProNum(String proNum){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					List<ProjectDescImage> projectImageList=new ArrayList<ProjectDescImage>();
					try {
						String sql ="select * from project_desc_image  where project_num =?";
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1,proNum );
						  rs = pstmt.executeQuery();
						while(rs.next()){
							ProjectDescImage projectImage=new ProjectDescImage();
							projectImage.setId(rs.getInt("id"));
							projectImage.setName(rs.getString("image_name"));
							projectImage.setShunxu(rs.getInt("view_shunxu"));
							projectImageList.add(projectImage);
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
					return projectImageList;
				}
		//鏍规嵁椤圭洰椤圭洰缂栧彿鑾峰彇闄勮繎閰嶅
				public List<FujinPeiTao> getFujinPeiTaoByProNum(String proNum){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;

					List<FujinPeiTao> fujinPeiTaoList=new ArrayList<FujinPeiTao>();
					try {
						String sql ="select * from near_peitao  where project_num =?";
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1,proNum );
						  rs = pstmt.executeQuery();
						while(rs.next()){
							FujinPeiTao fujinPeiTao=new FujinPeiTao();
							fujinPeiTao.setId(rs.getInt("id"));
							fujinPeiTao.setPeitao_type(rs.getString("market_type"));
							fujinPeiTao.setPeitao_name(rs.getString("market_name"));
							fujinPeiTao.setPeitao_distance(rs.getString("market_distance"));
							fujinPeiTaoList.add(fujinPeiTao);
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
					return fujinPeiTaoList;
				}
		
				//鏍规嵁椤圭洰椤圭洰缂栧彿鑾峰彇闄勮繎瀛︽牎
				public List<FujinSchool> getFujinSchoolByProNum(String proNum){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;

					List<FujinSchool> fujinSchoolList=new ArrayList<FujinSchool>();
					try {
						String sql ="select * from near_school  where project_num =?";
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1,proNum );
						  rs = pstmt.executeQuery();
						while(rs.next()){
							FujinSchool fujinSchool=new FujinSchool();
							fujinSchool.setId(rs.getInt("id"));
							fujinSchool.setSchool_distance(rs.getString("school_distance"));
							fujinSchool.setSchool_name(rs.getString("school_name"));
							fujinSchoolList.add(fujinSchool);
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
					return fujinSchoolList;
				}
				//鏍规嵁椤圭洰椤圭洰缂栧彿鑾峰彇闄勮繎瀛︽牎
				public List<HoldCost> getHoldCostByProNum(String proNum){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					List<HoldCost> holdCostlList=new ArrayList<HoldCost>();
					try {
						String sql ="select * from holding_finace  where project_num =?";
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1,proNum );
						  rs = pstmt.executeQuery();
						while(rs.next()){
							HoldCost holdCost=new HoldCost();
							holdCost.setId(rs.getInt("id"));
							holdCost.setHoldcosttype(rs.getString("type"));
							holdCost.setHoldcostprice(rs.getString("price"));
							holdCost.setHoldcostdesc(rs.getString("description"));
							holdCostlList.add(holdCost);
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
					return holdCostlList;
				}
				//鏍规嵁椤圭洰椤圭洰缂栧彿鑾峰彇闄勮繎瀛︽牎
				public List<HouseTax> getHouseTaxByProNum(String proNum){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					List<HouseTax> houseTaxlList=new ArrayList<HouseTax>();
					try {
						String sql ="select * from house_tax  where project_num =?";
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1,proNum );
						  rs = pstmt.executeQuery();
						while(rs.next()){
							HouseTax houseTax=new HouseTax();
							houseTax.setId(rs.getInt("id"));
							houseTax.setHouseTaxtype(rs.getString("type"));
							houseTax.setHouseTaxprice(rs.getString("price"));
							houseTax.setHouseTaxdesc(rs.getString("description"));
							/*houseTax.setHouseTax_housename(rs.getString("house_name"));*/
							houseTaxlList.add(houseTax);
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
					return houseTaxlList;
				}
				//按项目推荐经纪人
		public List<BrokerInfo> getBrokerInfoByProNum(String proNum){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				List<BrokerInfo> brokerList=new ArrayList<BrokerInfo>();
				AreaTuijianBroker areaInfo = new AreaTuijianBroker();
				try {
					String sql ="select * from area_recommend_broker  where project_num =?";
					 pstmt = con.prepareStatement(sql);
					pstmt.setString(1,proNum );
					  rs = pstmt.executeQuery();
					/*while(rs.next()){
						BrokerInfo brokerInfo=new BrokerInfo();
						brokerInfo.setId(rs.getInt("id"));
						brokerInfo.setBroker_experience(rs.getInt("broker_experience"));
						brokerInfo.setBroker_img(rs.getString("broker_img"));
						brokerInfo.setBroker_language(rs.getString("broker_language"));
						brokerInfo.setBroker_num(rs.getString("broker_num"));
						brokerInfo.setBroker_region(rs.getString("broker_region"));
						brokerInfo.setBroker_type(rs.getString("broker_type"));
						brokerInfo.setBroker_zizhi(rs.getString("broker_zizhi"));
						brokerList.add(brokerInfo);
					}*/
					  while(rs.next()){
							areaInfo.setId(rs.getInt("id"));
							areaInfo.setBroker_code1(rs.getString("broker_code1"));
							areaInfo.setBroker_code2(rs.getString("broker_code2"));
							areaInfo.setBroker_code3(rs.getString("broker_code3"));
							
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
				String broker1=areaInfo.getBroker_code1();
				String broker2=areaInfo.getBroker_code2();
				String broker3=areaInfo.getBroker_code3();
				BrokerInfo brokerInfo1=new BrokerInfo();
				brokerInfo1=getBrokerList(broker1);
				brokerList.add(brokerInfo1);
				BrokerInfo brokerInfo2=new BrokerInfo();
				brokerInfo2=getBrokerList(broker2);
				brokerList.add(brokerInfo2);
				BrokerInfo brokerInfo3=new BrokerInfo();
				brokerInfo3=getBrokerList(broker3);
				brokerList.add(brokerInfo3);
				return brokerList;
			}

		public BrokerInfo getBrokerList(String broker_num){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			BrokerInfo brokerInfo = new BrokerInfo();
			try {
				String sql = " SELECT * from broker_info where broker_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,broker_num);
				  rs = pstmt.executeQuery();
				while(rs.next()){
					brokerInfo.setId(rs.getInt("id"));
					brokerInfo.setBroker_name(rs.getString("broker_name"));
					brokerInfo.setBroker_type(rs.getString("broker_type"));
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
	//椤圭洰鍒楄〃
	public JSONArray selectProjectList(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = " select t.id,t.project_num,t.project_name,t.isSeen from house_project t";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("project_num", rs.getString("project_num"));
				obj.put("project_name", rs.getString("project_name"));
				obj.put("isSeen", rs.getInt("isSeen"));
				jsonArray.add(obj);
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
		return jsonArray;
	} 
	//椤圭洰鍒犻櫎
			public int deleteProjectById(int id,String proNum){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				boolean flag=true;
				
				try {
					con.setAutoCommit(false);
					//鍒犻櫎椤圭洰
					String sql1 = "delete from house_project where id=?";
					pstmt = con.prepareStatement(sql1);
					pstmt.setInt(1, id);
					int result1=pstmt.executeUpdate();
					//鍒犻櫎鎴峰瀷鍙婁环鏍�
					String sql2="delete from house_info where project_num=?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(1, proNum);
					int result2=pstmt.executeUpdate();
					//鍒犻櫎椤圭洰閰嶅
					String sql3="delete from project_peitao_image where project_num=?";
					pstmt = con.prepareStatement(sql3);
					pstmt.setString(1, proNum);
					int result3=pstmt.executeUpdate();
					//鍒犻櫎闄勮繎閰嶅
					String sql4="delete from near_peitao where project_num=?";
					pstmt = con.prepareStatement(sql4);
					pstmt.setString(1, proNum);
					int result4=pstmt.executeUpdate();
					//鍒犻櫎闄勮繎瀛︽牎
					String sql5="delete from near_school where project_num=?";
					pstmt = con.prepareStatement(sql5);
					pstmt.setString(1, proNum);
					int result5=pstmt.executeUpdate();
					//鍒犻櫎鎸佹湁鎴愭湰
					String sql6="delete from holding_finace where project_num=?";
					pstmt = con.prepareStatement(sql6);
					pstmt.setString(1, proNum);
					int result6=pstmt.executeUpdate();
					//鍒犻櫎璐埧绋庤垂
					String sql7="delete from house_tax where project_num=?";
					pstmt = con.prepareStatement(sql7);
					pstmt.setString(1, proNum);
					int result7=pstmt.executeUpdate();
					con.commit();
					con.setAutoCommit(true);
					return 1;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return -1;
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
			}
			//瀛︽牎淇℃伅鍒犻櫎
			public int deleteSchool(int id){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				boolean flag=true;
				 
				try {
					con.setAutoCommit(false);
					//鍒犻櫎椤圭洰
					String sql1 = "delete from school_info where id=?";
					pstmt = con.prepareStatement(sql1);
					pstmt.setInt(1, id);
					int result1=pstmt.executeUpdate();
					con.commit();
					con.setAutoCommit(true);
					return 1;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return -1;
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
			}
			//寮�鍙戝晢淇℃伅鍒犻櫎
			public int deleteDeveloper(int id){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;

				boolean flag=true;
				 
				try {
					con.setAutoCommit(false);
					//鍒犻櫎椤圭洰
					String sql1 = "delete from developer_info where id=?";
					pstmt = con.prepareStatement(sql1);
					pstmt.setInt(1, id);
					int result1=pstmt.executeUpdate();
					con.commit();
					con.setAutoCommit(true);
					return 1;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return -1;
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
			}
			//鏂伴椈鍗氬鍒犻櫎
			public int deleteNewsBoke(int id){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				boolean flag=true;
				 
				try {
					con.setAutoCommit(false);
					String sql1 = "delete from news_boke where id=?";
					pstmt = con.prepareStatement(sql1);
					pstmt.setInt(1, id);
					int result1=pstmt.executeUpdate();
					con.commit();
					con.setAutoCommit(true);
					return 1;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return -1;
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
			}
			//缃笟鎸囧鍒犻櫎
			public int deleteZhiye(int id){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				boolean flag=true;
				 
				try {
					con.setAutoCommit(false);
					String sql1 = "delete from zhiye_zhidao where id=?";
					pstmt = con.prepareStatement(sql1);
					pstmt.setInt(1, id);
					int result1=pstmt.executeUpdate();
					con.commit();
					con.setAutoCommit(true);
					return 1;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return -1;
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

			}
			//缁忕邯浜哄垹闄�
			public int deleteBroker(int id,String brokerNum){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				boolean flag=true;
				 
				try {
					con.setAutoCommit(false);
					//鍒犻櫎缁忕邯浜轰俊鎭�
					String sql1 = "delete from broker_info where id=?";
					pstmt = con.prepareStatement(sql1);
					pstmt.setInt(1, id);
					int result1=pstmt.executeUpdate();
					//鍒犻櫎缁忕邯浜烘湇鍔″尯鍩�
					String sql2 = "delete from broker_service_area where broker_num=?";
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(1, brokerNum);
					int result2=pstmt.executeUpdate();
					//鍒犻櫎缁忕邯浜烘搮闀跨被鍨�
					String sql3 = "delete from broker_interested_type where broker_num=?";
					pstmt = con.prepareStatement(sql3);
					pstmt.setString(1, brokerNum);
					int result3=pstmt.executeUpdate();
					
					con.commit();
					con.setAutoCommit(true);
					return 1;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return -1;
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
			}
			
	//瀛︽牎鍒楄〃
		public JSONArray selectSchoolList(){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			JSONArray jsonArray=new JSONArray();
			try {
				String sql = " select * from school_info";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				while(rs.next()){
					JSONObject obj = new JSONObject();
					obj.put("id", rs.getInt("id"));
					obj.put("school_name", rs.getString("school_name"));
					jsonArray.add(obj);
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
			return jsonArray;
		} 
		//寮�鍙戝晢鍒楄〃
				public JSONArray selectDeveloperList(){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;

					JSONArray jsonArray=new JSONArray();
					try {
						String sql = " select * from developer_info";
						  stmt = con.createStatement();
						  rs = stmt.executeQuery(sql);
						while(rs.next()){
							JSONObject obj = new JSONObject();
							obj.put("id", rs.getInt("id"));
							obj.put("developer_num", rs.getString("developer_num"));
							obj.put("developer_name", rs.getString("developer_name"));
							jsonArray.add(obj);
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

					return jsonArray;
				} 
				//鏂伴椈鍗氬鍒楄〃
				public JSONArray selectnewsList(){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;

					JSONArray jsonArray=new JSONArray();
					try {
						String sql = " select * from news_boke";
						  stmt = con.createStatement();
						  rs = stmt.executeQuery(sql);
						while(rs.next()){
							JSONObject obj = new JSONObject();
							obj.put("id", rs.getInt("id"));
							obj.put("news_num", rs.getString("news_num"));
							obj.put("news_title", rs.getString("news_title"));
							jsonArray.add(obj);
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
					return jsonArray;
				} 
				//缃笟鎸囧鍒楄〃
				public JSONArray selectzhiyeList(){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					JSONArray jsonArray=new JSONArray();
					try {
						String sql = " select * from zhiye_zhidao";
						  stmt = con.createStatement();
						  rs = stmt.executeQuery(sql);
						while(rs.next()){
							JSONObject obj = new JSONObject();
							obj.put("id", rs.getInt("id"));
							obj.put("zhiye_num", rs.getString("zhiye_num"));
							obj.put("title", rs.getString("title"));
							jsonArray.add(obj);
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
					return jsonArray;
				} 
				//缁忕邯浜哄垪琛�
				public JSONArray selectBrokerList(){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;


					JSONArray jsonArray=new JSONArray();
					try {
						String sql = " select * from broker_info";
						  stmt = con.createStatement();
						  rs = stmt.executeQuery(sql);
						while(rs.next()){
							JSONObject obj = new JSONObject();
							obj.put("id", rs.getInt("id"));
							obj.put("broker_num", rs.getString("broker_num"));
							obj.put("broker_name", rs.getString("broker_name"));
							jsonArray.add(obj);
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
					return jsonArray;
				} 
	//鏍规嵁id鎵鹃」鐩俊鎭�
	public HouseProject selectProjectInfo(int id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		JSONArray jsonArray=new JSONArray();
		HouseProject houseProject=new HouseProject();
		try {
			String sql = " select * from house_project  where id="+id;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				houseProject.setId(Integer.parseInt(rs.getString("id")));
				houseProject.setProject_name(rs.getString("project_name"));
				houseProject.setProject_img(rs.getString("project_img"));
				houseProject.setProject_nation(rs.getString("project_nation"));
				houseProject.setProject_address(rs.getString("project_address"));
				houseProject.setProject_area(rs.getString("project_area"));
				/*houseProject.setProject_price_qi(rs.getString("project_price_qi"));*/
				houseProject.setProject_price_int_qi(rs.getInt("project_price_int_qi"));
				houseProject.setProject_type(rs.getString("project_type"));
				houseProject.setProject_sales_remain(rs.getInt("project_sales_remain"));
				/*houseProject.setProject_finish_time(rs.getTimestamp("project_finish_time"));*/
				houseProject.setProject_finish_time(rs.getString("project_finish_time"));
				houseProject.setProject_desc(rs.getString("project_desc"));
				houseProject.setDeveloper_id(rs.getInt("developer_id"));
				houseProject.setProject_house_type(rs.getString("project_house_type"));
				houseProject.setProject_high(rs.getString("project_high"));
				houseProject.setProject_price(rs.getString("project_price"));
				houseProject.setProject_lan_en(rs.getString("project_lan_en"));
				houseProject.setProject_lan_cn(rs.getString("project_lan_cn"));
				houseProject.setProject_num(rs.getString("project_num"));
				houseProject.setProject_vedio(rs.getString("project_vedio"));
				houseProject.setProject_zhou(rs.getString("project_zhou"));
				houseProject.setProject_city(rs.getString("project_city"));
				houseProject.setArea_qujian(rs.getString("area_qujian"));
				houseProject.setGps(rs.getString("gps"));
				houseProject.setReturn_money(rs.getString("return_money"));
				houseProject.setWalk_num(rs.getShort("walk_num"));
				houseProject.setArea_id(rs.getInt("area_id"));
				houseProject.setMianji(rs.getString("mianji"));
				houseProject.setProject_min_price(rs.getString("project_min_price"));
				houseProject.setProject_high_price(rs.getString("project_high_price"));
				houseProject.setTuijiandu(rs.getInt("tuijiandu"));
				houseProject.setHousePrice_update_time(rs.getTimestamp("housePrice_update_time"));
				houseProject.setBuytaxInfo(rs.getString("buytaxInfo"));
				houseProject.setHoldInfo(rs.getString("holdInfo"));
				houseProject.setDeveloper_id_name(rs.getString("developer_id_name"));
				houseProject.setMin_area(rs.getInt("min_area"));
				houseProject.setMax_area(rs.getInt("max_area"));
				houseProject.setArea_num(rs.getString("area_num"));
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
		
		return houseProject;
	} 
	//上架项目
			public int ShowProject(int id){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;

				int exeResult =0;
				try {
					String sql = "update house_project set isSeen=1 where id="+id;
					 pstmt = con.prepareStatement(sql);
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
	//下架项目
			public int UnShowProject(int id){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;

				int exeResult =0;
				try {
					String sql = "update house_project set isSeen=0 where id="+id;
					 pstmt = con.prepareStatement(sql);
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
	//根据id找学校信息
		public SchoolInfo selectSchoolInfo(int id){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			JSONArray jsonArray=new JSONArray();
			SchoolInfo schoolInfo=new SchoolInfo();
			try {
				String sql = " select * from school_info  where id="+id;
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				while(rs.next()){
					schoolInfo.setId(rs.getInt("id"));
					schoolInfo.setSchool_name(rs.getString("school_name"));
					schoolInfo.setSchool_ranking(rs.getString("school_ranking"));
					schoolInfo.setSchool_type(rs.getString("school_type"));
					schoolInfo.setStudent_total(rs.getInt("student_total"));
					schoolInfo.setTeacher_total(rs.getInt("teacher_total"));
					schoolInfo.setSchool_position(rs.getString("school_position"));
					schoolInfo.setGps(rs.getString("gps"));
					schoolInfo.setNet_info(rs.getString("net_info"));
					schoolInfo.setNot_en_stu_bili(rs.getInt("not_en_stu_bili"));
					schoolInfo.setSchool_image(rs.getString("school_image"));
					schoolInfo.setSchool_desc(rs.getString("school_desc"));
					schoolInfo.setNation(rs.getString("nation"));
					schoolInfo.setCity(rs.getString("city"));
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
			return schoolInfo;
		} 
		//鏍规嵁id鎵惧紑鍙戝晢
				public DeveloperInfo selectDeveloperInfo(int id){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					JSONArray jsonArray=new JSONArray();
					DeveloperInfo developerInfo=new DeveloperInfo();
					try {
						String sql = " select * from developer_info  where id="+id;
						  stmt = con.createStatement();
						  rs = stmt.executeQuery(sql);
						while(rs.next()){
							developerInfo.setId(rs.getInt("id"));
							developerInfo.setDeveloper_num(rs.getString("developer_num"));
							developerInfo.setDeveloper_name(rs.getString("developer_name"));
							developerInfo.setDeveloper_logo(rs.getString("developer_logo"));
							developerInfo.setDeveloper_desc(rs.getString("developer_desc"));
							developerInfo.setNation(rs.getString("nation"));
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
					return developerInfo;
				} 
				//鏍规嵁id鎵炬柊闂诲崥瀹�
				public NewsBoke selectNewsBokeInfo(int id){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					JSONArray jsonArray=new JSONArray();
					NewsBoke newsBoke=new NewsBoke();
					try {
						String sql = " select * from news_boke  where id="+id;
						  stmt = con.createStatement();
						  rs = stmt.executeQuery(sql);
						while(rs.next()){
							newsBoke.setId(rs.getInt("id"));
							newsBoke.setNews_num(rs.getString("news_num"));
							newsBoke.setNews_title(rs.getString("news_title"));
							newsBoke.setNews_people(rs.getString("news_people"));
							newsBoke.setNews_time(rs.getTimestamp("news_time"));
							newsBoke.setNews_fenlei(rs.getString("news_fenlei"));
							newsBoke.setNews_abstract(rs.getString("news_abstract"));
							newsBoke.setNews_detail(rs.getString("news_detail"));
							newsBoke.setNews_image(rs.getString("news_image"));
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
					return newsBoke;
				} 	
				//鏍规嵁id鎵剧疆涓氭寚瀵�
				public ZhiYeZhiDao selectZhiyeInfo(int id){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					JSONArray jsonArray=new JSONArray();
					ZhiYeZhiDao zhiYeZhiDao=new ZhiYeZhiDao();
					try {
						String sql = " select * from zhiye_zhidao  where id="+id;
						  stmt = con.createStatement();
						  rs = stmt.executeQuery(sql);
						while(rs.next()){
							zhiYeZhiDao.setId(rs.getInt("id"));
							zhiYeZhiDao.setZhiye_num(rs.getString("zhiye_num"));
							zhiYeZhiDao.setFabu_people(rs.getString("fabu_people"));
							zhiYeZhiDao.setFabu_time(rs.getTimestamp("fabu_time"));
							zhiYeZhiDao.setFenlei(rs.getString("fenlei"));
							zhiYeZhiDao.setZhiye_abstract(rs.getString("zhiye_abstract"));
							zhiYeZhiDao.setDetail(rs.getString("detail"));
							zhiYeZhiDao.setImage(rs.getString("image"));
							zhiYeZhiDao.setTitle(rs.getString("title"));
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
					return zhiYeZhiDao;
				} 	
				//鏍规嵁id鎵剧粡绾汉淇℃伅
				public Broker selectBroker(int id){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;

					JSONArray jsonArray=new JSONArray();
					Broker broker=new Broker();
					try {
						String sql = " select * from broker_info  where id="+id;
						  stmt = con.createStatement();
						  rs = stmt.executeQuery(sql);
						while(rs.next()){
							broker.setId(rs.getInt("id"));
							broker.setBroker_num(rs.getString("broker_num"));
							broker.setBroker_name(rs.getString("broker_name"));
							broker.setBroker_language(rs.getString("broker_language"));
							broker.setBroker_region(rs.getString("broker_region"));
							broker.setBroker_type(rs.getString("broker_type"));
							broker.setBroker_zizhi(rs.getString("broker_zizhi"));
							broker.setBroker_experience(rs.getInt("broker_experience"));
							broker.setBroker_img(rs.getString("broker_img"));
							broker.setIntroduction(rs.getString("introduction"));
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
					return broker;
				} 	
				//鏍规嵁id鏌ユ壘缁忕邯浜虹紪鍙�
				public String findBrokerNumById(int id){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					JSONArray jsonArray=new JSONArray();
					String broker_num=null;
					try {
						String sql = " select * from broker_info  where id="+id;
						  stmt = con.createStatement();
						  rs = stmt.executeQuery(sql);
						while(rs.next()){
							broker_num=rs.getString("broker_num");
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
					return broker_num;
				} 	
				//鏍规嵁缁忕邯浜虹紪鍙锋煡鎵剧粡绾汉鏈嶅姟鍖哄煙鍒楄〃
				public List<ServiceArea> findBrokerAreaList(String broker_num){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					List<ServiceArea> brokerServiceAreaList=new ArrayList<ServiceArea>();
					try {
						String sql ="select * from broker_service_area  where broker_num =?";
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1,broker_num);
						  rs = pstmt.executeQuery();
						while(rs.next()){
							ServiceArea brokerServiceArea=new ServiceArea();
							brokerServiceArea.setArea_code(rs.getString("area_code"));
							brokerServiceArea.setView_shunxu(rs.getInt("view_shunxu"));
							brokerServiceArea.setId(rs.getInt("id"));
							brokerServiceAreaList.add(brokerServiceArea);
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
					return brokerServiceAreaList;
				} 
				//鏍规嵁缁忕邯浜虹紪鍙锋煡鎵剧粡绾汉鎿呴暱绫诲瀷
				public List<BrokerType> findBrokerTypeList(String broker_num){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					List<BrokerType> brokerIntegerTypeList=new ArrayList<BrokerType>();
					try {
						String sql ="select * from broker_interested_type  where broker_num =?";
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1,broker_num);
						  rs = pstmt.executeQuery();
						while(rs.next()){
							BrokerType brokerIntegerType=new BrokerType();
							brokerIntegerType.setInterested_num(rs.getString("interested_num"));
							brokerIntegerType.setView_shunxu2(rs.getInt("view_shunxu"));
							brokerIntegerType.setId(rs.getInt("id"));
							brokerIntegerTypeList.add(brokerIntegerType);
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
					return brokerIntegerTypeList;
				} 	
		
		
	
	//瀛︽牎淇℃伅Add
	public boolean InsertSchoolInfo(String school_name,String school_ranking,String school_type,int school_total,int teacher_total,String school_position,String gps,String net_info,int not_en_stu_bili,String school_image,String school_desc,String nation,String city){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean flag=true;
		try {
			String sql = "insert into school_info(school_name,school_ranking,school_type,student_total,teacher_total, school_position,gps,net_info,not_en_stu_bili,school_image,school_desc,nation,city) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

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
			pstmt.setString(12, nation);
			pstmt.setString(13, city);
			int exeResult = pstmt.executeUpdate();
			if(exeResult == 0){
				flag = false;
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
		return flag;
		
	}
	//瀛︽牎淇℃伅Update

		public boolean UpdateSchoolInfo(int id,String school_name,String school_ranking,String school_type,int school_total,int teacher_total,String school_position,String gps,String net_info,int not_en_stu_bili,String school_image,String school_desc,String nation,String city){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			boolean flag=true;
			try {
				String sql = "update school_info set school_name=?,school_ranking=?,school_type=?,student_total=?,teacher_total=?, school_position=?,gps=?,net_info=?,not_en_stu_bili=?,school_image=?,school_desc=?,nation=?,city=? where id=?";
				pstmt = con.prepareStatement(sql);

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
				pstmt.setString(12, nation);
				pstmt.setString(13, city);
				pstmt.setInt(14, id);
				int exeResult = pstmt.executeUpdate();
				if(exeResult == 0){
					flag = false;
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
			return flag;
			
		}
	//寮�鍙戝晢淇℃伅Add

		public boolean InsertDeveloperInfo(String developer_name,String developer_logo,String developer_desc,String developer_num,String nation){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
	boolean flag=true;
			try {
				String sql = "insert into developer_info(developer_name,developer_logo,developer_desc,developer_num,nation) values(?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, developer_name);
				pstmt.setString(2, developer_logo);
				pstmt.setString(3, developer_desc);
				pstmt.setString(4, developer_num);
				pstmt.setString(5, nation);
				int exeResult = pstmt.executeUpdate();
				if(exeResult == 0){
					flag = false;
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
			return flag;
		}
		//寮�鍙戝晢淇℃伅update

				public boolean UpdateDeveloperInfo(int id,String developer_name,String developer_logo,String developer_desc,String developer_num,String nation){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;	
	boolean flag=true;
					try {
						String sql = "update  developer_info  set developer_name=?,developer_logo=?,developer_desc=?,developer_num=?,nation=? where id=?";
						pstmt = con.prepareStatement(sql);

						pstmt.setString(1, developer_name);
						pstmt.setString(2, developer_logo);
						pstmt.setString(3, developer_desc);
						pstmt.setString(4, developer_num);
						pstmt.setString(5, nation);
						pstmt.setInt(6, id);
						int exeResult = pstmt.executeUpdate();
						if(exeResult == 0){
							flag = false;
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
					return flag;
				}
		//缁忕邯浜篈dd
		public int InsertBroker(Broker broker,List<ServiceArea> serviceAreaList,List<BrokerType> brokerTypeList){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			String broker_num=broker.getBroker_num();
			String broker_name=broker.getBroker_name();
			String broker_language=broker.getBroker_language();
			String broker_region=broker.getBroker_region();
			String broker_type=broker.getBroker_type();
			String broker_zizhi=broker.getBroker_zizhi();
			int broker_experience=broker.getBroker_experience();
			String broker_img=broker.getBroker_img();
			String introduction=broker.getIntroduction();
			 
			boolean flag=true;
			
			try {
				con.setAutoCommit(false);
				String sql1 = "insert into broker_info(broker_num,broker_name,broker_language,broker_region,broker_img,introduction,broker_experience,broker_type,broker_zizhi) values(?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, broker_num);
				pstmt.setString(2, broker_name);
				pstmt.setString(3, broker_language);
				pstmt.setString(4, broker_region);
				pstmt.setString(5, broker_img);
				pstmt.setString(6, introduction);
				pstmt.setInt(7, broker_experience);
				pstmt.setString(8, broker_type);
				pstmt.setString(9, broker_zizhi);
				int exeResult = pstmt.executeUpdate();
				//鏈嶅姟鍖哄煙
				String sql2 = "insert into broker_service_area(broker_num,area_code,view_shunxu) values(?,?,?)";
		        pstmt = con.prepareStatement(sql2);
		        for(int i=0;i<serviceAreaList.size();i++){
		        	ServiceArea serviceArea=serviceAreaList.get(i);
		        	String area_code=serviceArea.getArea_code();
		        	int  view_shunxu=serviceArea.getView_shunxu();
		            pstmt.setString(1, broker_num);
		            pstmt.setString(2, area_code);
		            pstmt.setInt(3, view_shunxu);
		            pstmt.addBatch();
		        }
				int[] result2list=pstmt.executeBatch();
				//鎿呴暱绫诲瀷
				String sql3 = "insert into broker_interested_type(broker_num,interested_num,view_shunxu) values(?,?,?)";
		        pstmt = con.prepareStatement(sql3);
		        for(int i=0;i<brokerTypeList.size();i++){
		        	BrokerType brokertype=brokerTypeList.get(i);
		        	String interested_num=brokertype.getInterested_num();
		        	int  view_shunxu=brokertype.getView_shunxu2();
		            pstmt.setString(1, broker_num);
		            pstmt.setString(2, interested_num);
		            pstmt.setInt(3, view_shunxu);
		            pstmt.addBatch();
		        }
				int[] result3list=pstmt.executeBatch();
				//鎻愪氦浜嬬墿
				con.commit();
				//鎭㈠JDBC浜嬪姟
				con.setAutoCommit(true);
				return 1;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
				return -1;
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
		}
		//缁忕邯浜簎pdate
	public int UpdateBroker(int id,Broker broker,List<ServiceArea> serviceAreaList,List<ServiceArea> serviceAreaList2,List<BrokerType> brokerTypeList,List<BrokerType> brokerTypeList2
						,List<ServiceArea> serviceArealistdelete,
				List<BrokerType> brokerTypelistdelete){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
					String broker_num=broker.getBroker_num();
					String broker_name=broker.getBroker_name();
					String broker_language=broker.getBroker_language();
					String broker_region=broker.getBroker_region();
					String broker_type=broker.getBroker_type();
					String broker_zizhi=broker.getBroker_zizhi();
					int broker_experience=broker.getBroker_experience();
					String broker_img=broker.getBroker_img();
					String introduction=broker.getIntroduction();
					 
					boolean flag=true;
					
					try {
						con.setAutoCommit(false);
						//缁忕邯浜轰俊鎭洿鏂�
						String sql1 = "update broker_info set broker_num=?,broker_name=?,broker_language=?,broker_region=?,broker_img=?,introduction=?,broker_experience=?,broker_type=?,broker_zizhi=? where id=?";
						pstmt = con.prepareStatement(sql1);
						pstmt.setString(1, broker_num);
						pstmt.setString(2, broker_name);
						pstmt.setString(3, broker_language);
						pstmt.setString(4, broker_region);
						pstmt.setString(5, broker_img);
						pstmt.setString(6, introduction);
						pstmt.setInt(7, broker_experience);
						pstmt.setString(8, broker_type);
						pstmt.setString(9, broker_zizhi);
						pstmt.setInt(10, id);
						int exeResult = pstmt.executeUpdate();
						
						//鏈嶅姟鍖哄煙鏇存柊
						String sql2 = "update  broker_service_area set area_code=?,view_shunxu=? where id=? ";
				        pstmt = con.prepareStatement(sql2);
				        for(int i=0;i<serviceAreaList.size();i++){
				        	ServiceArea serviceArea=serviceAreaList.get(i);
				        	String area_code=serviceArea.getArea_code();
				        	int areaid=serviceArea.getId();
				        	int  view_shunxu=serviceArea.getView_shunxu(); 
				            pstmt.setString(1, area_code);
				            pstmt.setInt(2, view_shunxu);
				            pstmt.setInt(3, areaid);
				            pstmt.addBatch();
				        }
						int[] result2list=pstmt.executeBatch();
						//鏈嶅姟鍖哄煙娣诲姞
						String sql22 = "insert into broker_service_area(broker_num,area_code,view_shunxu) values(?,?,?)";
				        pstmt = con.prepareStatement(sql22);
				        for(int i=0;i<serviceAreaList2.size();i++){
				        	ServiceArea serviceArea=serviceAreaList2.get(i);
				        	String area_code=serviceArea.getArea_code();
				        	int  view_shunxu=serviceArea.getView_shunxu();
				            pstmt.setString(1, broker_num);
				            pstmt.setString(2, area_code);
				            pstmt.setInt(3, view_shunxu);
				            pstmt.addBatch();
				        }
						int[] result22list=pstmt.executeBatch();
						//鎿呴暱绫诲瀷鏇存柊
						String sql3 = "update broker_interested_type set interested_num=?,view_shunxu=? where id=?";
				        pstmt = con.prepareStatement(sql3);
				        for(int i=0;i<brokerTypeList.size();i++){
				        	BrokerType brokertype=brokerTypeList.get(i);
				        	String interested_num=brokertype.getInterested_num();
				        	int  view_shunxu=brokertype.getView_shunxu2();
				        	int  interid=brokertype.getId();
				            pstmt.setString(1, interested_num);
				            pstmt.setInt(2, view_shunxu);
				            pstmt.setInt(3, interid);
				            pstmt.addBatch();
				        }
						int[] result3list=pstmt.executeBatch();
						//鎿呴暱绫诲瀷娣诲姞
						String sql33 = "insert into broker_interested_type(broker_num,interested_num,view_shunxu) values(?,?,?)";
				        pstmt = con.prepareStatement(sql33);
				        for(int i=0;i<brokerTypeList2.size();i++){
				        	BrokerType brokertype=brokerTypeList2.get(i);
				        	String interested_num=brokertype.getInterested_num();
				        	int  view_shunxu=brokertype.getView_shunxu2();
				            pstmt.setString(1, broker_num);
				            pstmt.setString(2, interested_num);
				            pstmt.setInt(3, view_shunxu);
				            pstmt.addBatch();
				        }
						int[] result33list=pstmt.executeBatch();
						
						String sqldeleteservice = "delete from broker_service_area where id= ?";
						pstmt = con.prepareStatement(sqldeleteservice);
						for(int i=0;i<serviceArealistdelete.size();i++){
							pstmt.setInt(1, serviceArealistdelete.get(i).getId());
							pstmt.addBatch();
						}
						int[] resultservicedelete=pstmt.executeBatch();
						System.out.println("resultservicedelete.length:"+resultservicedelete.length);
						for(int i=0;i<resultservicedelete.length;i++){
							System.out.println("resultservicedelete"+i+":"+resultservicedelete[i]);
						}
						
						String sqldeleteinterest = "delete from broker_interested_type where id= ?";
						pstmt = con.prepareStatement(sqldeleteinterest);
						for(int i=0;i<brokerTypelistdelete.size();i++){
							pstmt.setInt(1, brokerTypelistdelete.get(i).getId());
							pstmt.addBatch();
						}
						int[] resultinterestdelete=pstmt.executeBatch();
						System.out.println("resultinterestdelete.length:"+resultinterestdelete.length);
						for(int i=0;i<resultinterestdelete.length;i++){
							System.out.println("resultinterestdelete"+i+":"+resultinterestdelete[i]);
						}
						
						//鎻愪氦浜嬬墿
						con.commit();
						//鎭㈠JDBC浜嬪姟
						con.setAutoCommit(true);
						return 1;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						try {
							con.rollback();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						e.printStackTrace();
						return -1;
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
				}
		
				//鍒ゆ柇鎵�缁欓」鐩紪鍙锋槸鍚﹂噸澶�
				public int isDuplicateNum(String project_num){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					HashSet<String> project_numSet=new HashSet<String>();
					try {
						String sql = " select project_num from house_project";
						  stmt = con.createStatement();
						  rs = stmt.executeQuery(sql);
						while(rs.next()){
							String num=rs.getString("project_num");
							project_numSet.add(num);
						}
						if(project_numSet.contains(project_num)){
							return 1;//1琛ㄧず姝ょ紪鍙峰凡瀛樺湪
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
					return 0;
				}
		//添加项目   经纪人按区域进行推荐
		public int AddProject(List<Project> projectList,List<HouseInfo1>houseInfolist,List<ProjectDescImage>projectimagelist,List<ProjectPeiTao>projectPeitaolist,List<FujinPeiTao> fujinList,List<FujinSchool>fujinSchoolList,List<HoldCost>holdCostList,List<HouseTax>houseTaxList,List<ProjectKey> keylist) throws SQLException{
			//椤圭洰淇℃伅鍙傛暟鎺ユ敹
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Project project=projectList.get(0);
			String project_name=project.getProject_name();
			String project_nation=project.getProject_nation();
			String project_address=project.getProject_address();
			String project_area=project.getProject_area();
			int project_price_int_qi=project.getProject_price_int_qi();
			String project_type=project.getProject_type();
		    int project_sales_remain=project.getProject_sales_remain();
			String project_finish_time=project.getProject_finish_time().toString();
			String project_desc=project.getProject_desc();
			String project_city=project.getProject_city();
			String project_house_type=project.getProject_house_type();
			String project_high=project.getProject_high();
			String project_lan_cn=project.getProject_lan_cn();
			String project_lan_en=project.getProject_lan_en();
			String project_num=project.getProject_num();
			String project_vedio=project.getProject_vedio();
			String project_zhou=project.getProject_zhou();
			String gps=project.getGps();
			String return_money=project.getReturn_money();
			int walk_num=project.getWalk_num();
			String mianji=project.getMianji();
			String project_min_price=project.getProject_min_price();
			String project_high_price=project.getProject_high_price();
			int tuijiandu=project.getTuijiandu();
			String housePrice_update_time=project.getHousePrice_update_time();
			/*String buytaxInfo=project.getBuytaxInfo();
			String holdInfo=project.getHoldInfo();*/
			String area_num=project.getArea_num();
			int  min_area=project.getMin_area();
			int  max_area=project.getMax_area();
			String developer_num=project.getDeveloper_id_name();
			
			
			String time = "";
			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(project_finish_time==null||"".equals(project_finish_time)){
				project_finish_time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//"2015-05-09";
			}
			 
	        try {  
	        	time = project_finish_time+" "+"00:00:00";
	            ts = Timestamp.valueOf(time);   
	            
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        } 
			/*String time=project.getProject_finish_time();
	        String time1 = "";
			Timestamp ts1 = new Timestamp(System.currentTimeMillis()); 
			if(housePrice_update_time==null||"".equals(housePrice_update_time)){
				housePrice_update_time =new SimpleDateFormat("yyyy-MM-dd").format(new Date());// "2015-05-09";
			}
			 
	        try {  
	        	time1 = housePrice_update_time+" "+"00:00:00";
	            ts1 = Timestamp.valueOf(time1);   
	            
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        } */
			 String time1=null;
		     if(housePrice_update_time==null || "".equals(housePrice_update_time)){
		    	 time1=null;
		     }else{
		    	 time1=housePrice_update_time.toString();
		     }
			try{
				con.setAutoCommit(false);
				//项目添加
				String sql1= " insert into house_project(project_name, project_nation, project_address, project_price_int_qi, project_type, project_sales_remain,  project_finish_time, project_desc, project_city, project_house_type, project_high, project_lan_cn, project_lan_en, project_num, project_vedio, project_zhou, gps, return_money, walk_num, mianji, project_min_price, project_high_price, tuijiandu, housePrice_update_time,area_num, min_area, max_area,  developer_id_name,isSeen,project_area) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			    pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, project_name);
				pstmt.setString(2, project_nation);
				pstmt.setString(3, project_address);
				pstmt.setInt(4, project_price_int_qi);
				pstmt.setString(5, project_type);
				pstmt.setInt(6, project_sales_remain);
				pstmt.setString(7,time);
				pstmt.setString(8,project_desc);
				pstmt.setString(9, project_city);
				pstmt.setString(10, project_house_type);
				pstmt.setString(11, project_high);
				pstmt.setString(12, project_lan_cn);
				pstmt.setString(13, project_lan_en);
				pstmt.setString(14, project_num);
				pstmt.setString(15, project_vedio);
				pstmt.setString(16, project_zhou);
				pstmt.setString(17, gps);
				pstmt.setString(18, return_money);
				pstmt.setInt(19, walk_num);
				pstmt.setString(20, mianji);
				pstmt.setString(21, project_min_price);
				pstmt.setString(22, project_high_price);
				pstmt.setInt(23, tuijiandu);
				pstmt.setString(24, time1);
				pstmt.setString(25, area_num);
				/*pstmt.setString(25, buytaxInfo);
				pstmt.setString(26, holdInfo);*/
				pstmt.setInt(26, min_area);
				pstmt.setInt(27, max_area);
				pstmt.setString(28, developer_num);
				pstmt.setInt(29, 0);//0表示下架，1表示上架，默认是不显示
				pstmt.setString(30, project_area);
				int result1 = pstmt.executeUpdate();
				System.out.println("result1:"+result1);
			     //鎴峰瀷鍙婁环鏍�
				 String sql2="insert into house_info(house_name,house_img,house_price,house_room_num,tudi_area,jianzhu_area,house_size_in,house_size_out,house_toilet_num,project_num) values(?,?,?,?,?,?,?,?,?,?) ";
		         pstmt = con.prepareStatement(sql2);
		        for(int i=0;i<houseInfolist.size();i++){
		        	HouseInfo1 houseinfo=houseInfolist.get(i);
		        	String housename=houseinfo.getHousename();
		        	String houseprice=houseinfo.getHouseprice();
		        	String houseimg=houseinfo.getHouseimg();
		        	int room_num=houseinfo.getRoom_num();
		        	String tudi_mianji=houseinfo.getTudi_mianji();
		        	String jianzhu_mianji=houseinfo.getJianzhu_mianji();
		        	String shinei_mianji=houseinfo.getShinei_mianji();
		        	String shiwai_mianji=houseinfo.getShiwai_mianji();
		            int wc_num=houseinfo.getWc_num();
		            pstmt.setString(1, housename);
		            pstmt.setString(2, houseimg);
		            pstmt.setString(3, houseprice);
		            pstmt.setInt(4, room_num);
		            pstmt.setString(5, tudi_mianji);
		            pstmt.setString(6, jianzhu_mianji);
		            pstmt.setString(7, shinei_mianji);
		            pstmt.setString(8, shiwai_mianji);
		            pstmt.setInt(9, wc_num);
		            pstmt.setString(10, project_num);
		            pstmt.addBatch();
		        }
				int[] result2list=pstmt.executeBatch();
				System.out.println("result2list.length:"+result2list.length);
				for(int i=0;i<result2list.length;i++){
					System.out.println("result2list"+i+":"+result2list[i]);
				}
				//椤圭洰鍥剧墖
				 String sql8="insert into project_peitao_image(image_name,image_type,view_shunxu,project_num,project_name) values(?,?,?,?,?) ";
		         pstmt = con.prepareStatement(sql8);
		        for(int i=0;i<projectPeitaolist.size();i++){
		        	ProjectPeiTao projectPeiTao=projectPeitaolist.get(i);
		            String image_name=projectPeiTao.getName();
		            int shunxu=projectPeiTao.getShunxu();
		            pstmt.setString(1, image_name);
		            pstmt.setString(2, "图片");
		            pstmt.setInt(3, shunxu);
		            pstmt.setString(4,project_num);
		            pstmt.setString(5, project_name);
		            pstmt.addBatch();
		        }
				int[] result3list=pstmt.executeBatch();
				System.out.println("result3list.length:"+result3list.length);
				for(int i=0;i<result3list.length;i++){
					System.out.println("result3list"+i+":"+result3list[i]);
				}
				
				//椤圭洰閰嶅
				 String sql3="insert into project_desc_image(image_name,image_type,view_shunxu,project_num,project_name) values(?,?,?,?,?) ";
		         pstmt = con.prepareStatement(sql3);
		        for(int i=0;i<projectimagelist.size();i++){
		        	ProjectDescImage projectImage=projectimagelist.get(i);
		            String image_name=projectImage.getName();
		            int shunxu=projectImage.getShunxu();
		            pstmt.setString(1, image_name);
		            pstmt.setString(2, "图片");
		            pstmt.setInt(3, shunxu);
		            pstmt.setString(4,project_num);
		            pstmt.setString(5, project_name);
		            pstmt.addBatch();
		        }
				int[] result8list=pstmt.executeBatch();
				System.out.println("result8list.length:"+result8list.length);
				for(int i=0;i<result8list.length;i++){
					System.out.println("result8list"+i+":"+result8list[i]);
				}
				
				//闄勮繎閰嶅
				 String sql4="insert into near_peitao(market_type,market_name,market_distance,project_num) values(?,?,?,?) ";
		         pstmt = con.prepareStatement(sql4);
		        for(int i=0;i<fujinList.size();i++){
		        	FujinPeiTao fujinPeiTao=fujinList.get(i);
		            String market_type=fujinPeiTao.getPeitao_type();
		            String market_name=fujinPeiTao.getPeitao_name();
		            String market_distance=fujinPeiTao.getPeitao_distance();
		            pstmt.setString(1, market_type);
		            pstmt.setString(2, market_name);
		            pstmt.setString(3, market_distance);
		            pstmt.setString(4,project_num);
		            pstmt.addBatch();
		        }
				int[] result4list=pstmt.executeBatch();
				System.out.println("result4list.length:"+result4list.length);
				for(int i=0;i<result4list.length;i++){
					System.out.println("result4list"+i+":"+result4list[i]);
				}
				//闄勮繎瀛︽牎
				 String sql5="insert into near_school(school_name,school_distance,project_num) values(?,?,?) ";
		         pstmt = con.prepareStatement(sql5);
		        for(int i=0;i<fujinSchoolList.size();i++){
		        	FujinSchool fujinSchool=fujinSchoolList.get(i);
		            String school_name=fujinSchool.getSchool_name();
		            String school_distance=fujinSchool.getSchool_distance();
		            pstmt.setString(1, school_name);
		            pstmt.setString(2, school_distance);
		            pstmt.setString(3,project_num);
		            pstmt.addBatch();
		        }
				int[] result5list=pstmt.executeBatch();
				System.out.println("result5list.length:"+result5list.length);
				for(int i=0;i<result5list.length;i++){
					System.out.println("result5list"+i+":"+result5list[i]);
				}
				//鎸佹湁鎴愭湰
				 String sql6="insert into holding_finace(type,price,description,project_num,house_name) values(?,?,?,?,?) ";
		         pstmt = con.prepareStatement(sql6);
		        for(int i=0;i<holdCostList.size();i++){
		        	HoldCost holdcost=holdCostList.get(i);
		            String type=holdcost.getHoldcosttype();
		            String price=holdcost.getHoldcostprice();
		            String description=holdcost.getHoldcostdesc();
		            String housename=holdcost.getHoldcost_housename();
		            pstmt.setString(1, type);
		            pstmt.setString(2, price);
		            pstmt.setString(3,description);
		            pstmt.setString(4,project_num);
		            pstmt.setString(5,housename);
		            pstmt.addBatch();
		        }
				int[] result6list=pstmt.executeBatch();
				System.out.println("result6list.length:"+result6list.length);
				for(int i=0;i<result6list.length;i++){
					System.out.println("result6list"+i+":"+result6list[i]);
				}
				
				//璐埧绋庤垂
				 String sql7="insert into house_tax(type,price,description,project_num) values(?,?,?,?) ";
		         pstmt = con.prepareStatement(sql7);
		        for(int i=0;i<houseTaxList.size();i++){
		        	HouseTax housetax=houseTaxList.get(i);
		            String type=housetax.getHouseTaxtype();
		            String price=housetax.getHouseTaxprice();
		            String description=housetax.getHouseTaxdesc();
		          /*  String housename=housetax.getHouseTax_housename();*/
		            pstmt.setString(1, type);
		            pstmt.setString(2, price);
		            pstmt.setString(3,description);
		            pstmt.setString(4,project_num);
		           /* pstmt.setString(5,housename);*/
		            pstmt.addBatch();
		        }
				int[] result7list=pstmt.executeBatch();
				System.out.println("result7list.length:"+result7list.length);
				for(int i=0;i<result7list.length;i++){
					System.out.println("result7list"+i+":"+result7list[i]);
				}
				//项目关键字
				
				 String sql9="insert into project_key(xinkaipan,huaren,remen,xuequ,baozu,daxue,center,traffic,xianfang,maidi,project_num) values(?,?,?,?,?,?,?,?,?,?,?) ";
		         pstmt = con.prepareStatement(sql9);
		        for(int i=0;i<keylist.size();i++){
		        	ProjectKey key=keylist.get(i);
		            String xinkaipan=key.getXinkaipan();
		            String huaren=key.getHuaren();
		            String remen=key.getRemen();
		            String xuequ=key.getXuequ();
		            String baozu=key.getBaozu();
		            String daxue=key.getDaxue();
		            String center=key.getDaxue();
		            String traffic=key.getTraffic();
		            String xianfang=key.getXianfang();
		            String maidi=key.getMaidi();		    
		            pstmt.setString(1, xinkaipan);
		            pstmt.setString(2, huaren);
		            pstmt.setString(3,remen);
		            pstmt.setString(4,xuequ);
		            pstmt.setString(5,baozu);
		            pstmt.setString(6,daxue);
		            pstmt.setString(7,center);
		            pstmt.setString(8,traffic);
		            pstmt.setString(9,xianfang);
		            pstmt.setString(10,maidi);
		            pstmt.setString(11,project_num);
		            pstmt.addBatch();
		        }
				int[] result9list=pstmt.executeBatch();
				System.out.println("result9list.length:"+result9list.length);
				for(int i=0;i<result9list.length;i++){
					System.out.println("result9list"+i+":"+result9list[i]);
				}
				
				//鎻愪氦浜嬬墿
				con.commit();
				//鎭㈠JDBC浜嬪姟
				con.setAutoCommit(true);
				return 1;
			}catch (Exception e) {
				//鍥炴粴JDBC浜嬪姟
				con.rollback();
	            e.printStackTrace();
	            return -1;
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
		}
		//添加项目   经纪人按项目进行推荐
		public int AddProject2(List<Project> projectList,List<HouseInfo1>houseInfolist,List<ProjectDescImage>projectimagelist,List<ProjectPeiTao>projectPeitaolist,List<FujinPeiTao> fujinList,List<FujinSchool>fujinSchoolList,List<HoldCost>holdCostList,List<HouseTax>houseTaxList,List<ProjectKey> keylist,List<BrokerInfo>brokerList) throws SQLException{
			//椤圭洰淇℃伅鍙傛暟鎺ユ敹
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Project project=projectList.get(0);
			String project_name=project.getProject_name();
			String project_nation=project.getProject_nation();
			String project_address=project.getProject_address();
			String project_area=project.getProject_area();
			int project_price_int_qi=project.getProject_price_int_qi();
			String project_type=project.getProject_type();
		    int project_sales_remain=project.getProject_sales_remain();
			String project_finish_time=project.getProject_finish_time().toString();
			String project_desc=project.getProject_desc();
			String project_city=project.getProject_city();
			String project_house_type=project.getProject_house_type();
			String project_high=project.getProject_high();
			String project_lan_cn=project.getProject_lan_cn();
			String project_lan_en=project.getProject_lan_en();
			String project_num=project.getProject_num();
			String project_vedio=project.getProject_vedio();
			String project_zhou=project.getProject_zhou();
			String gps=project.getGps();
			String return_money=project.getReturn_money();
			int walk_num=project.getWalk_num();
			String mianji=project.getMianji();
			String project_min_price=project.getProject_min_price();
			String project_high_price=project.getProject_high_price();
			int tuijiandu=project.getTuijiandu();
			String housePrice_update_time=project.getHousePrice_update_time().toString();
			/*String buytaxInfo=project.getBuytaxInfo();
			String holdInfo=project.getHoldInfo();*/
			String area_num=project.getArea_num();
			int  min_area=project.getMin_area();
			int  max_area=project.getMax_area();
			String developer_num=project.getDeveloper_id_name();
			
			
			/*String time = "";
			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(project_finish_time==null||"".equals(project_finish_time)){
				project_finish_time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//"2015-05-09";
			}
			 
	        try {  
	        	time = project_finish_time+" "+"00:00:00";
	            ts = Timestamp.valueOf(time);   
	            
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }  */
			String time=project.getProject_finish_time();
	       /* String time1 = "";
			Timestamp ts1 = new Timestamp(System.currentTimeMillis()); 
			if(housePrice_update_time==null||"".equals(housePrice_update_time)){
				housePrice_update_time =new SimpleDateFormat("yyyy-MM-dd").format(new Date());// "2015-05-09";
			}
			 
	        try {  
	        	time1 = housePrice_update_time+" "+"00:00:00";
	            ts1 = Timestamp.valueOf(time1);   
	            
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        } */
			 String time1 = null;
			 if(time==null || "".equals(time)){
				 time1=null;
			 }else{
				 time1=time.toString();
			 }
	       
			try{
				con.setAutoCommit(false);
				//项目添加
				String sql1= " insert into house_project(project_name, project_nation, project_address, project_price_int_qi, project_type, project_sales_remain,  project_finish_time, project_desc, project_city, project_house_type, project_high, project_lan_cn, project_lan_en, project_num, project_vedio, project_zhou, gps, return_money, walk_num, mianji, project_min_price, project_high_price, tuijiandu, housePrice_update_time,area_num, min_area, max_area,  developer_id_name,isSeen,project_area) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			    pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, project_name);
				pstmt.setString(2, project_nation);
				pstmt.setString(3, project_address);
				pstmt.setInt(4, project_price_int_qi);
				pstmt.setString(5, project_type);
				pstmt.setInt(6, project_sales_remain);
				pstmt.setString(7,time);
				pstmt.setString(8,project_desc);
				pstmt.setString(9, project_city);
				pstmt.setString(10, project_house_type);
				pstmt.setString(11, project_high);
				pstmt.setString(12, project_lan_cn);
				pstmt.setString(13, project_lan_en);
				pstmt.setString(14, project_num);
				pstmt.setString(15, project_vedio);
				pstmt.setString(16, project_zhou);
				pstmt.setString(17, gps);
				pstmt.setString(18, return_money);
				pstmt.setInt(19, walk_num);
				pstmt.setString(20, mianji);
				pstmt.setString(21, project_min_price);
				pstmt.setString(22, project_high_price);
				pstmt.setInt(23, tuijiandu);
				pstmt.setString(24, time1);
				pstmt.setString(25, area_num);
				/*pstmt.setString(25, buytaxInfo);
				pstmt.setString(26, holdInfo);*/
				pstmt.setInt(26, min_area);
				pstmt.setInt(27, max_area);
				pstmt.setString(28, developer_num);
				pstmt.setInt(29, 0);//0表示下架，1表示上架，默认是不显示
				pstmt.setString(30, project_area);
				int result1 = pstmt.executeUpdate();
				System.out.println("result1:"+result1);
			     //鎴峰瀷鍙婁环鏍�
				 String sql2="insert into house_info(house_name,house_img,house_price,house_room_num,tudi_area,jianzhu_area,house_size_in,house_size_out,house_toilet_num,project_num) values(?,?,?,?,?,?,?,?,?,?) ";
		         pstmt = con.prepareStatement(sql2);
		        for(int i=0;i<houseInfolist.size();i++){
		        	HouseInfo1 houseinfo=houseInfolist.get(i);
		        	String housename=houseinfo.getHousename();
		        	String houseprice=houseinfo.getHouseprice();
		        	String houseimg=houseinfo.getHouseimg();
		        	int room_num=houseinfo.getRoom_num();
		        	String tudi_mianji=houseinfo.getTudi_mianji();
		        	String jianzhu_mianji=houseinfo.getJianzhu_mianji();
		        	String shinei_mianji=houseinfo.getShinei_mianji();
		        	String shiwai_mianji=houseinfo.getShiwai_mianji();
		            int wc_num=houseinfo.getWc_num();
		            pstmt.setString(1, housename);
		            pstmt.setString(2, houseimg);
		            pstmt.setString(3, houseprice);
		            pstmt.setInt(4, room_num);
		            pstmt.setString(5, tudi_mianji);
		            pstmt.setString(6, jianzhu_mianji);
		            pstmt.setString(7, shinei_mianji);
		            pstmt.setString(8, shiwai_mianji);
		            pstmt.setInt(9, wc_num);
		            pstmt.setString(10, project_num);
		            pstmt.addBatch();
		        }
				int[] result2list=pstmt.executeBatch();
				System.out.println("result2list.length:"+result2list.length);
				for(int i=0;i<result2list.length;i++){
					System.out.println("result2list"+i+":"+result2list[i]);
				}
				//椤圭洰鍥剧墖
				 String sql8="insert into project_peitao_image(image_name,image_type,view_shunxu,project_num,project_name) values(?,?,?,?,?) ";
		         pstmt = con.prepareStatement(sql8);
		        for(int i=0;i<projectPeitaolist.size();i++){
		        	ProjectPeiTao projectPeiTao=projectPeitaolist.get(i);
		            String image_name=projectPeiTao.getName();
		            int shunxu=projectPeiTao.getShunxu();
		            pstmt.setString(1, image_name);
		            pstmt.setString(2, "图片");
		            pstmt.setInt(3, shunxu);
		            pstmt.setString(4,project_num);
		            pstmt.setString(5, project_name);
		            pstmt.addBatch();
		        }
				int[] result3list=pstmt.executeBatch();
				System.out.println("result3list.length:"+result3list.length);
				for(int i=0;i<result3list.length;i++){
					System.out.println("result3list"+i+":"+result3list[i]);
				}
				
				//椤圭洰閰嶅
				 String sql3="insert into project_desc_image(image_name,image_type,view_shunxu,project_num,project_name) values(?,?,?,?,?) ";
		         pstmt = con.prepareStatement(sql3);
		        for(int i=0;i<projectimagelist.size();i++){
		        	ProjectDescImage projectImage=projectimagelist.get(i);
		            String image_name=projectImage.getName();
		            int shunxu=projectImage.getShunxu();
		            pstmt.setString(1, image_name);
		            pstmt.setString(2, "图片");
		            pstmt.setInt(3, shunxu);
		            pstmt.setString(4,project_num);
		            pstmt.setString(5, project_name);
		            pstmt.addBatch();
		        }
				int[] result8list=pstmt.executeBatch();
				System.out.println("result8list.length:"+result8list.length);
				for(int i=0;i<result8list.length;i++){
					System.out.println("result8list"+i+":"+result8list[i]);
				}
				
				//闄勮繎閰嶅
				 String sql4="insert into near_peitao(market_type,market_name,market_distance,project_num) values(?,?,?,?) ";
		         pstmt = con.prepareStatement(sql4);
		        for(int i=0;i<fujinList.size();i++){
		        	FujinPeiTao fujinPeiTao=fujinList.get(i);
		            String market_type=fujinPeiTao.getPeitao_type();
		            String market_name=fujinPeiTao.getPeitao_name();
		            String market_distance=fujinPeiTao.getPeitao_distance();
		            pstmt.setString(1, market_type);
		            pstmt.setString(2, market_name);
		            pstmt.setString(3, market_distance);
		            pstmt.setString(4,project_num);
		            pstmt.addBatch();
		        }
				int[] result4list=pstmt.executeBatch();
				System.out.println("result4list.length:"+result4list.length);
				for(int i=0;i<result4list.length;i++){
					System.out.println("result4list"+i+":"+result4list[i]);
				}
				//闄勮繎瀛︽牎
				 String sql5="insert into near_school(school_name,school_distance,project_num) values(?,?,?) ";
		         pstmt = con.prepareStatement(sql5);
		        for(int i=0;i<fujinSchoolList.size();i++){
		        	FujinSchool fujinSchool=fujinSchoolList.get(i);
		            String school_name=fujinSchool.getSchool_name();
		            String school_distance=fujinSchool.getSchool_distance();
		            pstmt.setString(1, school_name);
		            pstmt.setString(2, school_distance);
		            pstmt.setString(3,project_num);
		            pstmt.addBatch();
		        }
				int[] result5list=pstmt.executeBatch();
				System.out.println("result5list.length:"+result5list.length);
				for(int i=0;i<result5list.length;i++){
					System.out.println("result5list"+i+":"+result5list[i]);
				}
				//鎸佹湁鎴愭湰
				 String sql6="insert into holding_finace(type,price,description,project_num,house_name) values(?,?,?,?,?) ";
		         pstmt = con.prepareStatement(sql6);
		        for(int i=0;i<holdCostList.size();i++){
		        	HoldCost holdcost=holdCostList.get(i);
		            String type=holdcost.getHoldcosttype();
		            String price=holdcost.getHoldcostprice();
		            String description=holdcost.getHoldcostdesc();
		            String housename=holdcost.getHoldcost_housename();
		            pstmt.setString(1, type);
		            pstmt.setString(2, price);
		            pstmt.setString(3,description);
		            pstmt.setString(4,project_num);
		            pstmt.setString(5,housename);
		            pstmt.addBatch();
		        }
				int[] result6list=pstmt.executeBatch();
				System.out.println("result6list.length:"+result6list.length);
				for(int i=0;i<result6list.length;i++){
					System.out.println("result6list"+i+":"+result6list[i]);
				}
				
				//璐埧绋庤垂
				 String sql7="insert into house_tax(type,price,description,project_num) values(?,?,?,?) ";
		         pstmt = con.prepareStatement(sql7);
		        for(int i=0;i<houseTaxList.size();i++){
		        	HouseTax housetax=houseTaxList.get(i);
		            String type=housetax.getHouseTaxtype();
		            String price=housetax.getHouseTaxprice();
		            String description=housetax.getHouseTaxdesc();
		          /*  String housename=housetax.getHouseTax_housename();*/
		            pstmt.setString(1, type);
		            pstmt.setString(2, price);
		            pstmt.setString(3,description);
		            pstmt.setString(4,project_num);
		           /* pstmt.setString(5,housename);*/
		            pstmt.addBatch();
		        }
				int[] result7list=pstmt.executeBatch();
				System.out.println("result7list.length:"+result7list.length);
				for(int i=0;i<result7list.length;i++){
					System.out.println("result7list"+i+":"+result7list[i]);
				}
				//项目关键字
				
				 String sql9="insert into project_key(xinkaipan,huaren,remen,xuequ,baozu,daxue,center,traffic,xianfang,maidi,project_num) values(?,?,?,?,?,?,?,?,?,?,?) ";
		         pstmt = con.prepareStatement(sql9);
		        for(int i=0;i<keylist.size();i++){
		        	ProjectKey key=keylist.get(i);
		            String xinkaipan=key.getXinkaipan();
		            String huaren=key.getHuaren();
		            String remen=key.getRemen();
		            String xuequ=key.getXuequ();
		            String baozu=key.getBaozu();
		            String daxue=key.getDaxue();
		            String center=key.getDaxue();
		            String traffic=key.getTraffic();
		            String xianfang=key.getXianfang();
		            String maidi=key.getMaidi();		    
		            pstmt.setString(1, xinkaipan);
		            pstmt.setString(2, huaren);
		            pstmt.setString(3,remen);
		            pstmt.setString(4,xuequ);
		            pstmt.setString(5,baozu);
		            pstmt.setString(6,daxue);
		            pstmt.setString(7,center);
		            pstmt.setString(8,traffic);
		            pstmt.setString(9,xianfang);
		            pstmt.setString(10,maidi);
		            pstmt.setString(11,project_num);
		            pstmt.addBatch();
		        }
				int[] result9list=pstmt.executeBatch();
				System.out.println("result9list.length:"+result9list.length);
				for(int i=0;i<result9list.length;i++){
					System.out.println("result9list"+i+":"+result9list[i]);
				}
				//推荐经纪人  按项目进行推荐
				boolean flagbroker = true;
				List<String> numList = new ArrayList<String>();
				String broker_code1 = "";
				String broker_code2 = "";
				String broker_code3 = "";
				if(brokerList.size()==1){
					String name = brokerList.get(0).getBroker_name();
					broker_code1 = findBrokerbyName(name);
				}
				else if(brokerList.size()==2){
					String name1 = brokerList.get(0).getBroker_name();
					String name2 = brokerList.get(1).getBroker_name();
					broker_code1 = findBrokerbyName(name1);
					broker_code2 = findBrokerbyName(name2);
					
				}
				else if(brokerList.size()==3){
					String name1 = brokerList.get(0).getBroker_name();
					String name2 = brokerList.get(1).getBroker_name();
					String name3 = brokerList.get(2).getBroker_name();
					broker_code1 = findBrokerbyName(name1);
					broker_code2 = findBrokerbyName(name2);
					broker_code3 = findBrokerbyName(name3);
				}
				
					String sqlbroker = " insert into area_recommend_broker(broker_code1, broker_code2, " +
							"broker_code3, project_num) values(?,?,?,?)";
					pstmt = con.prepareStatement(sqlbroker);
					pstmt.setString(1, broker_code1);
					pstmt.setString(2, broker_code2);
					pstmt.setString(3, broker_code3);
					pstmt.setString(4, project_num);
					
					int resultbroker = pstmt.executeUpdate();
					if(resultbroker == 0){
						flagbroker = false;
					}
				//鎻愪氦浜嬬墿
				con.commit();
				//鎭㈠JDBC浜嬪姟
				con.setAutoCommit(true);
				return 1;
			}catch (Exception e) {
				//鍥炴粴JDBC浜嬪姟
				con.rollback();
	            e.printStackTrace();
	            return -1;
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
		}
		public int EditProject(int id,List<Project> projectList,List<HouseInfo1> houseInfolist,List<HouseInfo1>houseInfolist2,List<ProjectPeiTao>peitaolist,List<ProjectPeiTao>peitaolist2,List<ProjectDescImage>imagelist,List<ProjectDescImage>imagelist2,List<FujinPeiTao>fujinpeitaoList,List<FujinPeiTao>fujinpeitaoList2,List<FujinSchool>fujinSchoolList,List<FujinSchool>fujinSchoolList2,List<HoldCost> holdCostList,List<HoldCost>holdCostList2,List<HouseTax>houseTaxList,List<HouseTax>houseTaxList2,List<ProjectDescImage> imagelistdelete,List<ProjectPeiTao> peitaolistdelete,List<FujinPeiTao> fujinpeitaoListdelete,List<FujinSchool>  fujinSchoolListdelete,List<HoldCost> holdCostListdelete,List<HouseTax> houseTaxListdelete,List<ProjectKey>keylist) throws SQLException{
			//椤圭洰淇℃伅鍙傛暟鎺ユ敹
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Project project=projectList.get(0);
			String project_name=project.getProject_name();
			String project_nation=project.getProject_nation();
			String project_address=project.getProject_address();
			String project_area=project.getProject_area();
			int project_price_int_qi=project.getProject_price_int_qi();
			String project_type=project.getProject_type();
		    int project_sales_remain=project.getProject_sales_remain();
			String project_finish_time=project.getProject_finish_time().toString();
			String project_desc=project.getProject_desc();
			String project_city=project.getProject_city();
			String project_house_type=project.getProject_house_type();
			String project_high=project.getProject_high();
			String project_lan_cn=project.getProject_lan_cn();
			String project_lan_en=project.getProject_lan_en();
			String project_num=project.getProject_num();
			String project_vedio=project.getProject_vedio();
			String project_zhou=project.getProject_zhou();
			String gps=project.getGps();
			String return_money=project.getReturn_money();
			int walk_num=project.getWalk_num();
			String mianji=project.getMianji();
			String project_min_price=project.getProject_min_price();
			String project_high_price=project.getProject_high_price();
			int tuijiandu=project.getTuijiandu();
			String housePrice_update_time=project.getHousePrice_update_time().toString();
			/*String buytaxInfo=project.getBuytaxInfo();
			String holdInfo=project.getHoldInfo();*/
			String area_num=project.getArea_num();
			int  min_area=project.getMin_area();
			int  max_area=project.getMax_area();
			String developer_num=project.getDeveloper_id_name();
			
			
//			String time = "";
//			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
//			if(project_finish_time==null||"".equals(project_finish_time)){
//				project_finish_time = "2015-05-09";
//			}
//			 
//	        try {  
//	        	time = project_finish_time+" "+"00:00:00";
//	            ts = Timestamp.valueOf(time);   
//	            
//	        } catch (Exception e) {   
//	            e.printStackTrace();   
//	        }  
//	        String time1 = "";
//			Timestamp ts1 = new Timestamp(System.currentTimeMillis()); 
//			if(housePrice_update_time==null||"".equals(housePrice_update_time)){
//				housePrice_update_time = "2015-05-09";
//			}
//			 
//	        try {  
//	        	time1 = housePrice_update_time+" "+"00:00:00";
//	            ts1 = Timestamp.valueOf(time1);   
//	            
//	        } catch (Exception e) {   
//	            e.printStackTrace();   
//	        } 
	       
			try{
				con.setAutoCommit(false);
				//椤圭洰鏇存柊
				String sql1= "update house_project set project_name=?, project_nation=?, project_address=?, project_price_int_qi=?, project_type=?, project_sales_remain=?,  project_finish_time=?, project_desc=?, project_city=?, project_house_type=?, project_high=?, project_lan_cn=?, project_lan_en=?, project_num=?, project_vedio=?, project_zhou=?, gps=?, return_money=?, walk_num=?, mianji=?, project_min_price=?, project_high_price=?, tuijiandu=?, housePrice_update_time=?,area_num=?, min_area=?, max_area=?,  developer_id_name=? where id="+id;
			    pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, project_name);
				pstmt.setString(2, project_nation);
				pstmt.setString(3, project_address);
				pstmt.setInt(4, project_price_int_qi);
				pstmt.setString(5, project_type);
				pstmt.setInt(6, project_sales_remain);
				//pstmt.setString(7,time);
				pstmt.setString(7,project_finish_time);
				pstmt.setString(8,project_desc);
				pstmt.setString(9, project_city);
				pstmt.setString(10, project_house_type);
				pstmt.setString(11, project_high);
				pstmt.setString(12, project_lan_cn);
				pstmt.setString(13, project_lan_en);
				pstmt.setString(14, project_num);
				pstmt.setString(15, project_vedio);
				pstmt.setString(16, project_zhou);
				pstmt.setString(17, gps);
				pstmt.setString(18, return_money);
				pstmt.setInt(19, walk_num);
				pstmt.setString(20, mianji);
				pstmt.setString(21, project_min_price);
				pstmt.setString(22, project_high_price);
				pstmt.setInt(23, tuijiandu);
				//pstmt.setString(24, time1);
				pstmt.setString(24, housePrice_update_time);
				/*pstmt.setString(25, buytaxInfo);
				pstmt.setString(26, holdInfo);*/
				pstmt.setString(25, area_num);
				pstmt.setInt(26, min_area);
				pstmt.setInt(27, max_area);
				pstmt.setString(28, developer_num);
				int result1 = pstmt.executeUpdate();
				System.out.println("result1:"+result1);
				//鎴峰瀷鍙婁环鏍兼洿鏂�
				String sql2="update house_info set house_name=?,house_img=?,house_price=?,house_room_num=?,tudi_area=?,jianzhu_area=?,house_size_in=?,house_size_out=?,house_toilet_num=? ,project_num=? where id=?";
		        pstmt = con.prepareStatement(sql2);
		        for(int i=0;i<houseInfolist.size();i++){
		        	HouseInfo1 houseinfo=houseInfolist.get(i);
		        	String housename=houseinfo.getHousename();
		        	String houseprice=houseinfo.getHouseprice();
		        	String houseimg=houseinfo.getHouseimg();
		        	int room_num=houseinfo.getRoom_num();
		        	String tudi_mianji=houseinfo.getTudi_mianji();
		        	String jianzhu_mianji=houseinfo.getJianzhu_mianji();
		        	String shinei_mianji=houseinfo.getShinei_mianji();
		        	String shiwai_mianji=houseinfo.getShiwai_mianji();
		        	int Id=houseinfo.getId();
		            int wc_num=houseinfo.getWc_num();
		            pstmt.setString(1, housename);
		            pstmt.setString(2, houseimg);
		            pstmt.setString(3, houseprice);
		            pstmt.setInt(4, room_num);
		            pstmt.setString(5, tudi_mianji);
		            pstmt.setString(6, jianzhu_mianji);
		            pstmt.setString(7, shinei_mianji);
		            pstmt.setString(8, shiwai_mianji);
		            pstmt.setInt(9, wc_num);
		            pstmt.setString(10, project_num);
		            pstmt.setInt(11, Id);
		            pstmt.addBatch();
		        }
				int[] result2list=pstmt.executeBatch();
				System.out.println("result2list.length:"+result2list.length);
				for(int i=0;i<result2list.length;i++){
					System.out.println("result2list"+i+":"+result2list[i]);
				}
				//鎴峰瀷鍙婁环鏍兼坊鍔�
				String sql22="insert into house_info(house_name,house_img,house_price,house_room_num,tudi_area,jianzhu_area,house_size_in,house_size_out,house_toilet_num,project_num) values(?,?,?,?,?,?,?,?,?,?) ";
		        pstmt = con.prepareStatement(sql22);
		        for(int i=0;i<houseInfolist2.size();i++){
		        	HouseInfo1 houseinfo=houseInfolist2.get(i);
		        	String housename=houseinfo.getHousename();
		        	String houseprice=houseinfo.getHouseprice();
		        	String houseimg=houseinfo.getHouseimg();
		        	int room_num=houseinfo.getRoom_num();
		        	String tudi_mianji=houseinfo.getTudi_mianji();
		        	String jianzhu_mianji=houseinfo.getJianzhu_mianji();
		        	String shinei_mianji=houseinfo.getShinei_mianji();
		        	String shiwai_mianji=houseinfo.getShiwai_mianji();
		            int wc_num=houseinfo.getWc_num();
		            pstmt.setString(1, housename);
		            pstmt.setString(2, houseimg);
		            pstmt.setString(3, houseprice);
		            pstmt.setInt(4, room_num);
		            pstmt.setString(5, tudi_mianji);
		            pstmt.setString(6, jianzhu_mianji);
		            pstmt.setString(7, shinei_mianji);
		            pstmt.setString(8, shiwai_mianji);
		            pstmt.setInt(9, wc_num);
		            pstmt.setString(10, project_num);
		            pstmt.addBatch();
		        }
				int[] result22list=pstmt.executeBatch();
				System.out.println("result22list.length:"+result22list.length);
				for(int i=0;i<result22list.length;i++){
					System.out.println("result22list"+i+":"+result22list[i]);
				}
				//椤圭洰閰嶅缂栬緫
				 String sql8="update project_peitao_image set image_name=?,project_num=? where id=? ";
		         pstmt = con.prepareStatement(sql8);
		        for(int i=0;i<peitaolist.size();i++){
		        	ProjectPeiTao projectPeiTao=peitaolist.get(i);
		            String name=projectPeiTao.getName();
		            int Id=projectPeiTao.getId();
		            pstmt.setString(1, name);
		            pstmt.setString(2, project_num);
		            pstmt.setInt(3, Id);
		            pstmt.addBatch();
		        }
				int[] result8list=pstmt.executeBatch();
				System.out.println("result8list.length:"+result8list.length);
				for(int i=0;i<result8list.length;i++){
					System.out.println("result8list"+i+":"+result8list[i]);
				}
				//椤圭洰閰嶅娣诲姞
				 String sql88="insert into project_peitao_image(image_name,image_type,project_num)values(?,?,?) ";
		         pstmt = con.prepareStatement(sql88);
		        for(int i=0;i<peitaolist2.size();i++){
		        	ProjectPeiTao projectPeiTao=peitaolist2.get(i);
		            String name=projectPeiTao.getName();
		            int Id=projectPeiTao.getId();
		            pstmt.setString(1, name);
		            pstmt.setString(2, "图片");
		            pstmt.setString(3, project_num);
		            pstmt.addBatch();
		        }
				int[] result88list=pstmt.executeBatch();
				System.out.println("result88list.length:"+result88list.length);
				for(int i=0;i<result88list.length;i++){
					System.out.println("result88list"+i+":"+result88list[i]);
				}
				//椤圭洰鍥剧墖缂栬緫
				 String sql9="update project_desc_image set image_name=?,project_num=? where id=? ";
		         pstmt = con.prepareStatement(sql9);
		        for(int i=0;i<imagelist.size();i++){
		        	ProjectDescImage projectImage=imagelist.get(i);
		            String name=projectImage.getName();
		            int Id=projectImage.getId();
		            pstmt.setString(1, name);
		            pstmt.setString(2, project_num);
		            pstmt.setInt(3, Id);
		            pstmt.addBatch();
		        }
				int[] result9list=pstmt.executeBatch();
				System.out.println("result9list.length:"+result9list.length);
				for(int i=0;i<result9list.length;i++){
					System.out.println("result9list"+i+":"+result9list[i]);
				}
				//椤圭洰鍥剧墖娣诲姞
				 String sql99="insert into project_desc_image (image_name,image_type,project_num) values(?,?,?) ";
		         pstmt = con.prepareStatement(sql99);
		        for(int i=0;i<imagelist2.size();i++){
		        	ProjectDescImage projectImage=imagelist2.get(i);
		            String name=projectImage.getName();
		            int Id=projectImage.getId();
		            pstmt.setString(1, name);
		            pstmt.setString(2, "图片");
		            pstmt.setString(3, project_num);
		            pstmt.addBatch();
		        }
				int[] result99list=pstmt.executeBatch();
				System.out.println("result99list.length:"+result99list.length);
				for(int i=0;i<result99list.length;i++){
					System.out.println("result99list"+i+":"+result99list[i]);
				}
				//闄勮繎閰嶅缂栬緫
				 String sql4="update near_peitao set market_type=?,market_name=?,market_distance=?,project_num=? where id=? ";
		         pstmt = con.prepareStatement(sql4);
		        for(int i=0;i<fujinpeitaoList.size();i++){
		        	FujinPeiTao fujinPeiTao=fujinpeitaoList.get(i);
		            String market_type=fujinPeiTao.getPeitao_type();
		            String market_name=fujinPeiTao.getPeitao_name();
		            String market_distance=fujinPeiTao.getPeitao_distance();
		            int Id=fujinPeiTao.getId();
		            pstmt.setString(1, market_type);
		            pstmt.setString(2, market_name);
		            pstmt.setString(3, market_distance);
		            pstmt.setString(4,project_num);
		            pstmt.setInt(5, Id);
		            pstmt.addBatch();
		        }
				int[] result4list=pstmt.executeBatch();
				System.out.println("result4list.length:"+result4list.length);
				for(int i=0;i<result4list.length;i++){
					System.out.println("result4list"+i+":"+result4list[i]);
				}
				//闄勮繎閰嶅娣诲姞
				 String sql44="insert into near_peitao(market_type,market_name,market_distance,project_num) values(?,?,?,?) ";
		         pstmt = con.prepareStatement(sql44);
		        for(int i=0;i<fujinpeitaoList2.size();i++){
		        	FujinPeiTao fujinPeiTao=fujinpeitaoList2.get(i);
		            String market_type=fujinPeiTao.getPeitao_type();
		            String market_name=fujinPeiTao.getPeitao_name();
		            String market_distance=fujinPeiTao.getPeitao_distance();
		            pstmt.setString(1, market_type);
		            pstmt.setString(2, market_name);
		            pstmt.setString(3, market_distance);
		            pstmt.setString(4,project_num);
		            pstmt.addBatch();
		        }
				int[] result44list=pstmt.executeBatch();
				System.out.println("result44list.length:"+result44list.length);
				for(int i=0;i<result44list.length;i++){
					System.out.println("result44list"+i+":"+result44list[i]);
				}
				//闄勮繎瀛︽牎缂栬緫
				 String sql5="update near_school set school_name=?,school_distance=?,project_num=? where id=?";
		         pstmt = con.prepareStatement(sql5);
		        for(int i=0;i<fujinSchoolList.size();i++){
		        	FujinSchool fujinSchool=fujinSchoolList.get(i);
		            String school_name=fujinSchool.getSchool_name();
		            String school_distance=fujinSchool.getSchool_distance();
		            int Id=fujinSchool.getId();
		            pstmt.setString(1, school_name);
		            pstmt.setString(2, school_distance);
		            pstmt.setString(3,project_num);
		            pstmt.setInt(4,Id );
		            pstmt.addBatch();
		        }
				int[] result5list=pstmt.executeBatch();
				System.out.println("result5list.length:"+result5list.length);
				for(int i=0;i<result5list.length;i++){
					System.out.println("result5list"+i+":"+result5list[i]);
				}
				//闄勮繎瀛︽牎娣诲姞
				 String sql55="insert into near_school(school_name,school_distance,project_num) values(?,?,?) ";
		         pstmt = con.prepareStatement(sql55);
		        for(int i=0;i<fujinSchoolList2.size();i++){
		        	FujinSchool fujinSchool=fujinSchoolList2.get(i);
		            String school_name=fujinSchool.getSchool_name();
		            String school_distance=fujinSchool.getSchool_distance();
		            pstmt.setString(1, school_name);
		            pstmt.setString(2, school_distance);
		            pstmt.setString(3,project_num);
		            pstmt.addBatch();
		        }
				int[] result55list=pstmt.executeBatch();
				System.out.println("result55list.length:"+result55list.length);
				for(int i=0;i<result55list.length;i++){
					System.out.println("result55list"+i+":"+result55list[i]);
				}
				//鎸佹湁鎴愭湰缂栬緫
				 String sql6="update holding_finace set type=?,price=?,description=?,project_num=?,house_name=? where id=? ";
		         pstmt = con.prepareStatement(sql6);
		        for(int i=0;i<holdCostList.size();i++){
		        	HoldCost holdcost=holdCostList.get(i);
		            String type=holdcost.getHoldcosttype();
		            String price=holdcost.getHoldcostprice();
		            String description=holdcost.getHoldcostdesc();
		            String housename=holdcost.getHoldcost_housename();
		            int Id=holdcost.getId();
		            pstmt.setString(1, type);
		            pstmt.setString(2, price);
		            pstmt.setString(3,description);
		            pstmt.setString(4,project_num);
		            pstmt.setString(5,housename);
		            pstmt.setInt(6, Id);
		            pstmt.addBatch();
		        }
				int[] result6list=pstmt.executeBatch();
				System.out.println("result6list.length:"+result6list.length);
				for(int i=0;i<result6list.length;i++){
					System.out.println("result6list"+i+":"+result6list[i]);
				}
				
				//鎸佹湁鎴愭湰娣诲姞
				 String sql66="insert into holding_finace(type,price,description,project_num,house_name) values(?,?,?,?,?) ";
		         pstmt = con.prepareStatement(sql66);
		        for(int i=0;i<holdCostList2.size();i++){
		        	HoldCost holdcost=holdCostList2.get(i);
		            String type=holdcost.getHoldcosttype();
		            String price=holdcost.getHoldcostprice();
		            String description=holdcost.getHoldcostdesc();
		            String housename=holdcost.getHoldcost_housename();
		            pstmt.setString(1, type);
		            pstmt.setString(2, price);
		            pstmt.setString(3,description);
		            pstmt.setString(4,project_num);
		            pstmt.setString(5,housename);
		            pstmt.addBatch();
		        }
				int[] result66list=pstmt.executeBatch();
				System.out.println("result66list.length:"+result66list.length);
				for(int i=0;i<result66list.length;i++){
					System.out.println("result66list"+i+":"+result66list[i]);
				}
				//璐埧绋庤垂缂栬緫
				 String sql7="update  house_tax set type=?,price=?,description=?,project_num=? where id=?";
		         pstmt = con.prepareStatement(sql7);
		        for(int i=0;i<houseTaxList.size();i++){
		        	HouseTax housetax=houseTaxList.get(i);
		            String type=housetax.getHouseTaxtype();
		            String price=housetax.getHouseTaxprice();
		            String description=housetax.getHouseTaxdesc();
		          /*  String housename=housetax.getHouseTax_housename();*/
		            int Id=housetax.getId();
		            pstmt.setString(1, type);
		            pstmt.setString(2, price);
		            pstmt.setString(3,description);
		            pstmt.setString(4,project_num);
		         /*   pstmt.setString(5,housename);*/
		            pstmt.setInt(5, Id);
		            pstmt.addBatch();
		        }
				int[] result7list=pstmt.executeBatch();
				System.out.println("result7list.length:"+result7list.length);
				for(int i=0;i<result7list.length;i++){
					System.out.println("result7list"+i+":"+result7list[i]);
				}
				//璐埧绋庤垂娣诲姞
				 String sql77="insert into house_tax(type,price,description,project_num) values(?,?,?,?) ";
		         pstmt = con.prepareStatement(sql77);
		        for(int i=0;i<houseTaxList2.size();i++){
		        	HouseTax housetax=houseTaxList2.get(i);
		            String type=housetax.getHouseTaxtype();
		            String price=housetax.getHouseTaxprice();
		            String description=housetax.getHouseTaxdesc();
		          /*  String housename=housetax.getHouseTax_housename();*/
		            pstmt.setString(1, type);
		            pstmt.setString(2, price);
		            pstmt.setString(3,description);
		            pstmt.setString(4,project_num);
		           /* pstmt.setString(5,housename);*/
		            pstmt.addBatch();
		        }
				int[] result77list=pstmt.executeBatch();
				//更新项目关键字
				 String sql00="update project_key set xinkaipan=?,huaren=?,remen=?,xuequ=?,baozu=?,daxue=?,center=?,traffic=?,xianfang=?,maidi=?,project_num=? where id=? ";
		         pstmt = con.prepareStatement(sql00);
		        for(int i=0;i<keylist.size();i++){
		        	ProjectKey key=keylist.get(i);
		            String xinkaipan=key.getXinkaipan();
		            String huaren=key.getHuaren();
		            String remen=key.getRemen();
		            String xuequ=key.getXuequ();
		            String baozu=key.getBaozu();
		            String daxue=key.getDaxue();
		            String center=key.getCenter();
		            String traffic=key.getTraffic();
		            String xianfang=key.getXianfang();
		            String maidi=key.getMaidi();
		            int Id=key.getId();
		            pstmt.setString(1, xinkaipan);
		            pstmt.setString(2, huaren);
		            pstmt.setString(3, remen);
		            pstmt.setString(4, xuequ);
		            pstmt.setString(5, baozu);
		            pstmt.setString(6, daxue);
		            pstmt.setString(7, center);
		            pstmt.setString(8, traffic);
		            pstmt.setString(9, xianfang);
		            pstmt.setString(10, maidi);
		            pstmt.setString(11,project_num);
		            pstmt.setInt(12, Id);
		            pstmt.addBatch();
		        }
				int[] result00list=pstmt.executeBatch();
				/*System.out.println("result4list.length:"+result4list.length);
				for(int i=0;i<result4list.length;i++){
					System.out.println("result4list"+i+":"+result4list[i]);
				}*/
				/*System.out.println("result77list.length:"+result77list.length);
				for(int i=0;i<result7list.length;i++){
					System.out.println("result77list"+i+":"+result77list[i]);
				}*/
				//,,,,,
				//delete from project_desc_image
				String sqldeleteimage = "delete from project_desc_image where id= ?";
				pstmt = con.prepareStatement(sqldeleteimage);
				for(int i=0;i<imagelistdelete.size();i++){
					pstmt.setInt(1, imagelistdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resultimagedelete=pstmt.executeBatch();
				System.out.println("resultimagedelete.length:"+resultimagedelete.length);
				for(int i=0;i<resultimagedelete.length;i++){
					System.out.println("resultimagedelete"+i+":"+resultimagedelete[i]);
				}
				
				//delete from project_desc_image
				String sqldeletepeitaolist = "delete from project_peitao_image where id= ?";
				pstmt = con.prepareStatement(sqldeletepeitaolist);
				for(int i=0;i<peitaolistdelete.size();i++){
					pstmt.setInt(1, peitaolistdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resultpeitaolistdelete=pstmt.executeBatch();
				System.out.println("resultpeitaolistdelete.length:"+resultpeitaolistdelete.length);
				for(int i=0;i<resultpeitaolistdelete.length;i++){
					System.out.println("resultpeitaolistdelete"+i+":"+resultpeitaolistdelete[i]);
				}
				
				//delete from project_desc_image
				/*String sqldeleteprojectimage = "delete from project_desc_image where id= ?";
				for(int i=0;i<imagelistdelete.size();i++){
					pstmt = con.prepareStatement(sqldeleteprojectimage);
					pstmt.setInt(1, imagelistdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resultprojectimagedelete=pstmt.executeBatch();
				System.out.println("resultprojectimagedelete.length:"+resultprojectimagedelete.length);
				for(int i=0;i<resultprojectimagedelete.length;i++){
					System.out.println("resultprojectimagedelete"+i+":"+resultprojectimagedelete[i]);
				}*/
				
				//delete from project_desc_image
				String sqldeletefujinpeitao = "delete from near_peitao where id= ?";
				pstmt = con.prepareStatement(sqldeletefujinpeitao);
				for(int i=0;i<fujinpeitaoListdelete.size();i++){
					pstmt.setInt(1, fujinpeitaoListdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resultfujinpeitaodelete=pstmt.executeBatch();
				System.out.println("resultfujinpeitaodelete.length:"+resultfujinpeitaodelete.length);
				for(int i=0;i<resultfujinpeitaodelete.length;i++){
					System.out.println("resultfujinpeitaodelete"+i+":"+resultfujinpeitaodelete[i]);
				}
				
				//delete from project_desc_image
				String sqldeletefujinschool = "delete from near_school where id= ?";
				pstmt = con.prepareStatement(sqldeletefujinschool);
				for(int i=0;i<fujinSchoolListdelete.size();i++){
					pstmt.setInt(1, fujinSchoolListdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resultfujinschooldelete=pstmt.executeBatch();
			System.out.println("resultfujinschooldelete.length:"+resultfujinschooldelete.length);
				for(int i=0;i<resultfujinschooldelete.length;i++){
					System.out.println("resultfujinschooldelete"+i+":"+resultfujinschooldelete[i]);
				}
				
				//delete from project_desc_image
				String sqldeletehousecost = "delete from holding_finace where id= ?";
				pstmt = con.prepareStatement(sqldeletehousecost);
				for(int i=0;i<holdCostListdelete.size();i++){
					pstmt.setInt(1, holdCostListdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resulthousecostdelete=pstmt.executeBatch();
				System.out.println("resulthousecostdelete.length:"+resulthousecostdelete.length);
				for(int i=0;i<resulthousecostdelete.length;i++){
					System.out.println("resulthousecostdelete"+i+":"+resulthousecostdelete[i]);
				}
				
				//delete from project_desc_image
				String sqldeletehousetax = "delete from house_tax where id= ?";
				pstmt = con.prepareStatement(sqldeletehousetax);
				for(int i=0;i<houseTaxListdelete.size();i++){
					pstmt.setInt(1, houseTaxListdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resulthousetaxdelete=pstmt.executeBatch();
				System.out.println("resulthousetaxdelete.length:"+resulthousetaxdelete.length);
				for(int i=0;i<resulthousetaxdelete.length;i++){
					System.out.println("resulthousetaxdelete"+i+":"+resulthousetaxdelete[i]);
				}
				//鎻愪氦浜嬬墿
				con.commit();
				//鎭㈠JDBC浜嬪姟
				con.setAutoCommit(true);
				return 1;
			}catch (Exception e) {
				//鍥炴粴JDBC浜嬪姟
				con.rollback();
	            e.printStackTrace();
	            return -1;
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
			
		}
		//
		public int EditProject(int id,List<Project> projectList,List<HouseInfo1> houseInfolist,List<HouseInfo1>houseInfolist2,List<ProjectPeiTao>peitaolist,List<ProjectPeiTao>peitaolist2,List<ProjectDescImage>imagelist,List<ProjectDescImage>imagelist2,List<FujinPeiTao>fujinpeitaoList,List<FujinPeiTao>fujinpeitaoList2,List<FujinSchool>fujinSchoolList,List<FujinSchool>fujinSchoolList2,List<HoldCost> holdCostList,List<HoldCost>holdCostList2,List<HouseTax>houseTaxList,List<HouseTax>houseTaxList2,List<HouseInfo1> houseInfolistdelete,List<ProjectDescImage> imagelistdelete,List<ProjectPeiTao> peitaolistdelete,List<FujinPeiTao> fujinpeitaoListdelete,List<FujinSchool>  fujinSchoolListdelete,List<HoldCost> holdCostListdelete,List<HouseTax> houseTaxListdelete,List<ProjectKey>keylist,List<BrokerInfo>brokerlistList2,List<BrokerInfo>brokerlistList) throws SQLException{
			//椤圭洰淇℃伅鍙傛暟鎺ユ敹
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Project project=projectList.get(0);
			String project_name=project.getProject_name();
			String project_nation=project.getProject_nation();
			String project_address=project.getProject_address();
			String project_area=project.getProject_area();
			int project_price_int_qi=project.getProject_price_int_qi();
			String project_type=project.getProject_type();
		    int project_sales_remain=project.getProject_sales_remain();
			String project_finish_time=project.getProject_finish_time().toString();
			String project_desc=project.getProject_desc();
			String project_city=project.getProject_city();
			String project_house_type=project.getProject_house_type();
			String project_high=project.getProject_high();
			String project_lan_cn=project.getProject_lan_cn();
			String project_lan_en=project.getProject_lan_en();
			String project_num=project.getProject_num();
			String project_vedio=project.getProject_vedio();
			String project_zhou=project.getProject_zhou();
			String gps=project.getGps();
			String return_money=project.getReturn_money();
			int walk_num=project.getWalk_num();
			String mianji=project.getMianji();
			String project_min_price=project.getProject_min_price();
			String project_high_price=project.getProject_high_price();
			int tuijiandu=project.getTuijiandu();
			String housePrice_update_time=project.getHousePrice_update_time();
			/*String buytaxInfo=project.getBuytaxInfo();
			String holdInfo=project.getHoldInfo();*/
			String area_num=project.getArea_num();
			int  min_area=project.getMin_area();
			int  max_area=project.getMax_area();
			String developer_num=project.getDeveloper_id_name();
			
			
//			String time = "";
//			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
//			if(project_finish_time==null||"".equals(project_finish_time)){
//				project_finish_time = "2015-05-09";
//			}
//			 
//	        try {  
//	        	time = project_finish_time+" "+"00:00:00";
//	            ts = Timestamp.valueOf(time);   
//	            
//	        } catch (Exception e) {   
//	            e.printStackTrace();   
//	        }  
//	        String time1 = "";
//			Timestamp ts1 = new Timestamp(System.currentTimeMillis()); 
//			if(housePrice_update_time==null||"".equals(housePrice_update_time)){
//				housePrice_update_time = "2015-05-09";
//			}
//			 
//	        try {  
//	        	time1 = housePrice_update_time+" "+"00:00:00";
//	            ts1 = Timestamp.valueOf(time1);   
//	            
//	        } catch (Exception e) {   
//	            e.printStackTrace();   
//	        } 
			 String time1 = null;
			 if(housePrice_update_time==null||"".equals(housePrice_update_time)){
				    time1 = null;
				}else{
					time1=housePrice_update_time.toString();
				}
	       
			try{
				con.setAutoCommit(false);
				//椤圭洰鏇存柊
				String sql1= "update house_project set project_name=?, project_nation=?, project_address=?, project_price_int_qi=?, project_type=?, project_sales_remain=?,  project_finish_time=?, project_desc=?, project_city=?, project_house_type=?, project_high=?, project_lan_cn=?, project_lan_en=?, project_num=?, project_vedio=?, project_zhou=?, gps=?, return_money=?, walk_num=?, mianji=?, project_min_price=?, project_high_price=?, tuijiandu=?, housePrice_update_time=?,area_num=?, min_area=?, max_area=?,  developer_id_name=?,project_area=? where id="+id;
			    pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, project_name);
				pstmt.setString(2, project_nation);
				pstmt.setString(3, project_address);
				pstmt.setInt(4, project_price_int_qi);
				pstmt.setString(5, project_type);
				pstmt.setInt(6, project_sales_remain);
				//pstmt.setString(7,time);
				pstmt.setString(7,project_finish_time);
				pstmt.setString(8,project_desc);
				pstmt.setString(9, project_city);
				pstmt.setString(10, project_house_type);
				pstmt.setString(11, project_high);
				pstmt.setString(12, project_lan_cn);
				pstmt.setString(13, project_lan_en);
				pstmt.setString(14, project_num);
				pstmt.setString(15, project_vedio);
				pstmt.setString(16, project_zhou);
				pstmt.setString(17, gps);
				pstmt.setString(18, return_money);
				pstmt.setInt(19, walk_num);
				pstmt.setString(20, mianji);
				pstmt.setString(21, project_min_price);
				pstmt.setString(22, project_high_price);
				pstmt.setInt(23, tuijiandu);
				//pstmt.setString(24, time1);
				pstmt.setString(24, time1);
				/*pstmt.setString(25, buytaxInfo);
				pstmt.setString(26, holdInfo);*/
				pstmt.setString(25, area_num);
				pstmt.setInt(26, min_area);
				pstmt.setInt(27, max_area);
				pstmt.setString(28, developer_num);
				pstmt.setString(29, project_area);
				int result1 = pstmt.executeUpdate();
				System.out.println("result1:"+result1);
				//鎴峰瀷鍙婁环鏍兼洿鏂�
				String sql2="update house_info set house_name=?,house_img=?,house_price=?,house_room_num=?,tudi_area=?,jianzhu_area=?,house_size_in=?,house_size_out=?,house_toilet_num=? ,project_num=? where id=?";
		        pstmt = con.prepareStatement(sql2);
		        for(int i=0;i<houseInfolist.size();i++){
		        	HouseInfo1 houseinfo=houseInfolist.get(i);
		        	String housename=houseinfo.getHousename();
		        	String houseprice=houseinfo.getHouseprice();
		        	String houseimg=houseinfo.getHouseimg();
		        	int room_num=houseinfo.getRoom_num();
		        	String tudi_mianji=houseinfo.getTudi_mianji();
		        	String jianzhu_mianji=houseinfo.getJianzhu_mianji();
		        	String shinei_mianji=houseinfo.getShinei_mianji();
		        	String shiwai_mianji=houseinfo.getShiwai_mianji();
		        	int Id=houseinfo.getId();
		            int wc_num=houseinfo.getWc_num();
		            pstmt.setString(1, housename);
		            pstmt.setString(2, houseimg);
		            pstmt.setString(3, houseprice);
		            pstmt.setInt(4, room_num);
		            pstmt.setString(5, tudi_mianji);
		            pstmt.setString(6, jianzhu_mianji);
		            pstmt.setString(7, shinei_mianji);
		            pstmt.setString(8, shiwai_mianji);
		            pstmt.setInt(9, wc_num);
		            pstmt.setString(10, project_num);
		            pstmt.setInt(11, Id);
		            pstmt.addBatch();
		        }
				int[] result2list=pstmt.executeBatch();
				System.out.println("result2list.length:"+result2list.length);
				for(int i=0;i<result2list.length;i++){
					System.out.println("result2list"+i+":"+result2list[i]);
				}
				//鎴峰瀷鍙婁环鏍兼坊鍔�
				String sql22="insert into house_info(house_name,house_img,house_price,house_room_num,tudi_area,jianzhu_area,house_size_in,house_size_out,house_toilet_num,project_num) values(?,?,?,?,?,?,?,?,?,?) ";
		        pstmt = con.prepareStatement(sql22);
		        for(int i=0;i<houseInfolist2.size();i++){
		        	HouseInfo1 houseinfo=houseInfolist2.get(i);
		        	String housename=houseinfo.getHousename();
		        	String houseprice=houseinfo.getHouseprice();
		        	String houseimg=houseinfo.getHouseimg();
		        	int room_num=houseinfo.getRoom_num();
		        	String tudi_mianji=houseinfo.getTudi_mianji();
		        	String jianzhu_mianji=houseinfo.getJianzhu_mianji();
		        	String shinei_mianji=houseinfo.getShinei_mianji();
		        	String shiwai_mianji=houseinfo.getShiwai_mianji();
		            int wc_num=houseinfo.getWc_num();
		            pstmt.setString(1, housename);
		            pstmt.setString(2, houseimg);
		            pstmt.setString(3, houseprice);
		            pstmt.setInt(4, room_num);
		            pstmt.setString(5, tudi_mianji);
		            pstmt.setString(6, jianzhu_mianji);
		            pstmt.setString(7, shinei_mianji);
		            pstmt.setString(8, shiwai_mianji);
		            pstmt.setInt(9, wc_num);
		            pstmt.setString(10, project_num);
		            pstmt.addBatch();
		        }
				int[] result22list=pstmt.executeBatch();
				System.out.println("result22list.length:"+result22list.length);
				for(int i=0;i<result22list.length;i++){
					System.out.println("result22list"+i+":"+result22list[i]);
				}
				//椤圭洰閰嶅缂栬緫
				 String sql8="update project_peitao_image set image_name=?,project_num=? where id=? ";
		         pstmt = con.prepareStatement(sql8);
		        for(int i=0;i<peitaolist.size();i++){
		        	ProjectPeiTao projectPeiTao=peitaolist.get(i);
		            String name=projectPeiTao.getName();
		            int Id=projectPeiTao.getId();
		            pstmt.setString(1, name);
		            pstmt.setString(2, project_num);
		            pstmt.setInt(3, Id);
		            pstmt.addBatch();
		        }
				int[] result8list=pstmt.executeBatch();
				System.out.println("result8list.length:"+result8list.length);
				for(int i=0;i<result8list.length;i++){
					System.out.println("result8list"+i+":"+result8list[i]);
				}
				//椤圭洰閰嶅娣诲姞
				 String sql88="insert into project_peitao_image(image_name,image_type,project_num)values(?,?,?) ";
		         pstmt = con.prepareStatement(sql88);
		        for(int i=0;i<peitaolist2.size();i++){
		        	ProjectPeiTao projectPeiTao=peitaolist2.get(i);
		            String name=projectPeiTao.getName();
		            int Id=projectPeiTao.getId();
		            pstmt.setString(1, name);
		            pstmt.setString(2, "图片");
		            pstmt.setString(3, project_num);
		            pstmt.addBatch();
		        }
				int[] result88list=pstmt.executeBatch();
				System.out.println("result88list.length:"+result88list.length);
				for(int i=0;i<result88list.length;i++){
					System.out.println("result88list"+i+":"+result88list[i]);
				}
				//椤圭洰鍥剧墖缂栬緫
				 String sql9="update project_desc_image set image_name=?,project_num=? where id=? ";
		         pstmt = con.prepareStatement(sql9);
		        for(int i=0;i<imagelist.size();i++){
		        	ProjectDescImage projectImage=imagelist.get(i);
		            String name=projectImage.getName();
		            int Id=projectImage.getId();
		            pstmt.setString(1, name);
		            pstmt.setString(2, project_num);
		            pstmt.setInt(3, Id);
		            pstmt.addBatch();
		        }
				int[] result9list=pstmt.executeBatch();
				System.out.println("result9list.length:"+result9list.length);
				for(int i=0;i<result9list.length;i++){
					System.out.println("result9list"+i+":"+result9list[i]);
				}
				//椤圭洰鍥剧墖娣诲姞
				 String sql99="insert into project_desc_image (image_name,image_type,project_num) values(?,?,?) ";
		         pstmt = con.prepareStatement(sql99);
		        for(int i=0;i<imagelist2.size();i++){
		        	ProjectDescImage projectImage=imagelist2.get(i);
		            String name=projectImage.getName();
		            int Id=projectImage.getId();
		            pstmt.setString(1, name);
		            pstmt.setString(2, "图片");
		            pstmt.setString(3, project_num);
		            pstmt.addBatch();
		        }
				int[] result99list=pstmt.executeBatch();
				System.out.println("result99list.length:"+result99list.length);
				for(int i=0;i<result99list.length;i++){
					System.out.println("result99list"+i+":"+result99list[i]);
				}
				//闄勮繎閰嶅缂栬緫
				 String sql4="update near_peitao set market_type=?,market_name=?,market_distance=?,project_num=? where id=? ";
		         pstmt = con.prepareStatement(sql4);
		        for(int i=0;i<fujinpeitaoList.size();i++){
		        	FujinPeiTao fujinPeiTao=fujinpeitaoList.get(i);
		            String market_type=fujinPeiTao.getPeitao_type();
		            String market_name=fujinPeiTao.getPeitao_name();
		            String market_distance=fujinPeiTao.getPeitao_distance();
		            int Id=fujinPeiTao.getId();
		            pstmt.setString(1, market_type);
		            pstmt.setString(2, market_name);
		            pstmt.setString(3, market_distance);
		            pstmt.setString(4,project_num);
		            pstmt.setInt(5, Id);
		            pstmt.addBatch();
		        }
				int[] result4list=pstmt.executeBatch();
				System.out.println("result4list.length:"+result4list.length);
				for(int i=0;i<result4list.length;i++){
					System.out.println("result4list"+i+":"+result4list[i]);
				}
				//闄勮繎閰嶅娣诲姞
				 String sql44="insert into near_peitao(market_type,market_name,market_distance,project_num) values(?,?,?,?) ";
		         pstmt = con.prepareStatement(sql44);
		        for(int i=0;i<fujinpeitaoList2.size();i++){
		        	FujinPeiTao fujinPeiTao=fujinpeitaoList2.get(i);
		            String market_type=fujinPeiTao.getPeitao_type();
		            String market_name=fujinPeiTao.getPeitao_name();
		            String market_distance=fujinPeiTao.getPeitao_distance();
		            pstmt.setString(1, market_type);
		            pstmt.setString(2, market_name);
		            pstmt.setString(3, market_distance);
		            pstmt.setString(4,project_num);
		            pstmt.addBatch();
		        }
				int[] result44list=pstmt.executeBatch();
				System.out.println("result44list.length:"+result44list.length);
				for(int i=0;i<result44list.length;i++){
					System.out.println("result44list"+i+":"+result44list[i]);
				}
				//闄勮繎瀛︽牎缂栬緫
				 String sql5="update near_school set school_name=?,school_distance=?,project_num=? where id=?";
		         pstmt = con.prepareStatement(sql5);
		        for(int i=0;i<fujinSchoolList.size();i++){
		        	FujinSchool fujinSchool=fujinSchoolList.get(i);
		            String school_name=fujinSchool.getSchool_name();
		            String school_distance=fujinSchool.getSchool_distance();
		            int Id=fujinSchool.getId();
		            pstmt.setString(1, school_name);
		            pstmt.setString(2, school_distance);
		            pstmt.setString(3,project_num);
		            pstmt.setInt(4,Id );
		            pstmt.addBatch();
		        }
				int[] result5list=pstmt.executeBatch();
				System.out.println("result5list.length:"+result5list.length);
				for(int i=0;i<result5list.length;i++){
					System.out.println("result5list"+i+":"+result5list[i]);
				}
				//闄勮繎瀛︽牎娣诲姞
				 String sql55="insert into near_school(school_name,school_distance,project_num) values(?,?,?) ";
		         pstmt = con.prepareStatement(sql55);
		        for(int i=0;i<fujinSchoolList2.size();i++){
		        	FujinSchool fujinSchool=fujinSchoolList2.get(i);
		            String school_name=fujinSchool.getSchool_name();
		            String school_distance=fujinSchool.getSchool_distance();
		            pstmt.setString(1, school_name);
		            pstmt.setString(2, school_distance);
		            pstmt.setString(3,project_num);
		            pstmt.addBatch();
		        }
				int[] result55list=pstmt.executeBatch();
				System.out.println("result55list.length:"+result55list.length);
				for(int i=0;i<result55list.length;i++){
					System.out.println("result55list"+i+":"+result55list[i]);
				}
				//鎸佹湁鎴愭湰缂栬緫
				 String sql6="update holding_finace set type=?,price=?,description=?,project_num=?,house_name=? where id=? ";
		         pstmt = con.prepareStatement(sql6);
		        for(int i=0;i<holdCostList.size();i++){
		        	HoldCost holdcost=holdCostList.get(i);
		            String type=holdcost.getHoldcosttype();
		            String price=holdcost.getHoldcostprice();
		            String description=holdcost.getHoldcostdesc();
		            String housename=holdcost.getHoldcost_housename();
		            int Id=holdcost.getId();
		            pstmt.setString(1, type);
		            pstmt.setString(2, price);
		            pstmt.setString(3,description);
		            pstmt.setString(4,project_num);
		            pstmt.setString(5,housename);
		            pstmt.setInt(6, Id);
		            pstmt.addBatch();
		        }
				int[] result6list=pstmt.executeBatch();
				System.out.println("result6list.length:"+result6list.length);
				for(int i=0;i<result6list.length;i++){
					System.out.println("result6list"+i+":"+result6list[i]);
				}
				
				//鎸佹湁鎴愭湰娣诲姞
				 String sql66="insert into holding_finace(type,price,description,project_num,house_name) values(?,?,?,?,?) ";
		         pstmt = con.prepareStatement(sql66);
		        for(int i=0;i<holdCostList2.size();i++){
		        	HoldCost holdcost=holdCostList2.get(i);
		            String type=holdcost.getHoldcosttype();
		            String price=holdcost.getHoldcostprice();
		            String description=holdcost.getHoldcostdesc();
		            String housename=holdcost.getHoldcost_housename();
		            pstmt.setString(1, type);
		            pstmt.setString(2, price);
		            pstmt.setString(3,description);
		            pstmt.setString(4,project_num);
		            pstmt.setString(5,housename);
		            pstmt.addBatch();
		        }
				int[] result66list=pstmt.executeBatch();
				System.out.println("result66list.length:"+result66list.length);
				for(int i=0;i<result66list.length;i++){
					System.out.println("result66list"+i+":"+result66list[i]);
				}
				//璐埧绋庤垂缂栬緫
				 String sql7="update  house_tax set type=?,price=?,description=?,project_num=? where id=?";
		         pstmt = con.prepareStatement(sql7);
		        for(int i=0;i<houseTaxList.size();i++){
		        	HouseTax housetax=houseTaxList.get(i);
		            String type=housetax.getHouseTaxtype();
		            String price=housetax.getHouseTaxprice();
		            String description=housetax.getHouseTaxdesc();
		          /*  String housename=housetax.getHouseTax_housename();*/
		            int Id=housetax.getId();
		            pstmt.setString(1, type);
		            pstmt.setString(2, price);
		            pstmt.setString(3,description);
		            pstmt.setString(4,project_num);
		         /*   pstmt.setString(5,housename);*/
		            pstmt.setInt(5, Id);
		            pstmt.addBatch();
		        }
				int[] result7list=pstmt.executeBatch();
				System.out.println("result7list.length:"+result7list.length);
				for(int i=0;i<result7list.length;i++){
					System.out.println("result7list"+i+":"+result7list[i]);
				}
				//璐埧绋庤垂娣诲姞
				 String sql77="insert into house_tax(type,price,description,project_num) values(?,?,?,?) ";
		         pstmt = con.prepareStatement(sql77);
		        for(int i=0;i<houseTaxList2.size();i++){
		        	HouseTax housetax=houseTaxList2.get(i);
		            String type=housetax.getHouseTaxtype();
		            String price=housetax.getHouseTaxprice();
		            String description=housetax.getHouseTaxdesc();
		          /*  String housename=housetax.getHouseTax_housename();*/
		            pstmt.setString(1, type);
		            pstmt.setString(2, price);
		            pstmt.setString(3,description);
		            pstmt.setString(4,project_num);
		           /* pstmt.setString(5,housename);*/
		            pstmt.addBatch();
		        }
				int[] result77list=pstmt.executeBatch();
				//更新项目关键字
				 String sql00="update project_key set xinkaipan=?,huaren=?,remen=?,xuequ=?,baozu=?,daxue=?,center=?,traffic=?,xianfang=?,maidi=?,project_num=? where id=? ";
		         pstmt = con.prepareStatement(sql00);
		        for(int i=0;i<keylist.size();i++){
		        	ProjectKey key=keylist.get(i);
		            String xinkaipan=key.getXinkaipan();
		            String huaren=key.getHuaren();
		            String remen=key.getRemen();
		            String xuequ=key.getXuequ();
		            String baozu=key.getBaozu();
		            String daxue=key.getDaxue();
		            String center=key.getCenter();
		            String traffic=key.getTraffic();
		            String xianfang=key.getXianfang();
		            String maidi=key.getMaidi();
		            int Id=key.getId();
		            pstmt.setString(1, xinkaipan);
		            pstmt.setString(2, huaren);
		            pstmt.setString(3, remen);
		            pstmt.setString(4, xuequ);
		            pstmt.setString(5, baozu);
		            pstmt.setString(6, daxue);
		            pstmt.setString(7, center);
		            pstmt.setString(8, traffic);
		            pstmt.setString(9, xianfang);
		            pstmt.setString(10, maidi);
		            pstmt.setString(11,project_num);
		            pstmt.setInt(12, Id);
		            pstmt.addBatch();
		        }
				int[] result00list=pstmt.executeBatch();
				//更新推荐经纪人   按项目进行推荐
				boolean flagbroker = true;
				List<String> numList = new ArrayList<String>();
				String broker_code1 = "";
				String broker_code2 = "";
				String broker_code3 = "";
				if(brokerlistList.size()==1){
					String name = brokerlistList.get(0).getBroker_name();
					broker_code1 = findBrokerbyName(name);
				}
				else if(brokerlistList.size()==2){
					String name1 = brokerlistList.get(0).getBroker_name();
					String name2 = brokerlistList.get(1).getBroker_name();
					broker_code1 = findBrokerbyName(name1);
					broker_code2 = findBrokerbyName(name2);
					
				}
				else if(brokerlistList.size()==3){
					String name1 = brokerlistList.get(0).getBroker_name();
					String name2 = brokerlistList.get(1).getBroker_name();
					String name3 = brokerlistList.get(2).getBroker_name();
					broker_code1 = findBrokerbyName(name1);
					broker_code2 = findBrokerbyName(name2);
					broker_code3 = findBrokerbyName(name3);
				}
				
					/*String sqlbroker = " insert into area_recommend_broker(broker_code1, broker_code2, " +
							" , area_code) values(?,?,?,?)";*/
					String sqlbroker = " update area_recommend_broker set broker_code1=?, broker_code2=?, broker_code3=? where project_num=?";
					pstmt = con.prepareStatement(sqlbroker);
					pstmt.setString(1, broker_code1);
					pstmt.setString(2, broker_code2);
					pstmt.setString(3, broker_code3);
					pstmt.setString(4, project_num);
					
					int resultbroker = pstmt.executeUpdate();
					if(resultbroker == 0){
						flagbroker = false;
					}
				
				/*System.out.println("result4list.length:"+result4list.length);
				for(int i=0;i<result4list.length;i++){
					System.out.println("result4list"+i+":"+result4list[i]);
				}*/
				/*System.out.println("result77list.length:"+result77list.length);
				for(int i=0;i<result7list.length;i++){
					System.out.println("result77list"+i+":"+result77list[i]);
				}*/
				//delete from 户型及价格 
				String sqldeletehouseinfo = "delete from house_info where id= ?";
				pstmt = con.prepareStatement(sqldeletehouseinfo);
				for(int i=0;i<houseInfolistdelete.size();i++){
					pstmt.setInt(1, houseInfolistdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resulthouseinfodelete=pstmt.executeBatch();
				System.out.println("resulthouseinfodelete.length:"+resulthouseinfodelete.length);
				for(int i=0;i<resulthouseinfodelete.length;i++){
					System.out.println("resulthouseinfodelete"+i+":"+resulthouseinfodelete[i]);
				}
				//delete from project_desc_image
				String sqldeleteimage = "delete from project_desc_image where id= ?";
				pstmt = con.prepareStatement(sqldeleteimage);
				for(int i=0;i<imagelistdelete.size();i++){
					pstmt.setInt(1, imagelistdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resultimagedelete=pstmt.executeBatch();
				System.out.println("resultimagedelete.length:"+resultimagedelete.length);
				for(int i=0;i<resultimagedelete.length;i++){
					System.out.println("resultimagedelete"+i+":"+resultimagedelete[i]);
				}
				
				//delete from project_desc_image
				String sqldeletepeitaolist = "delete from project_peitao_image where id= ?";
				pstmt = con.prepareStatement(sqldeletepeitaolist);
				for(int i=0;i<peitaolistdelete.size();i++){
					pstmt.setInt(1, peitaolistdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resultpeitaolistdelete=pstmt.executeBatch();
				System.out.println("resultpeitaolistdelete.length:"+resultpeitaolistdelete.length);
				for(int i=0;i<resultpeitaolistdelete.length;i++){
					System.out.println("resultpeitaolistdelete"+i+":"+resultpeitaolistdelete[i]);
				}
				
				//delete from project_desc_image
				/*String sqldeleteprojectimage = "delete from project_desc_image where id= ?";
				for(int i=0;i<imagelistdelete.size();i++){
					pstmt = con.prepareStatement(sqldeleteprojectimage);
					pstmt.setInt(1, imagelistdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resultprojectimagedelete=pstmt.executeBatch();
				System.out.println("resultprojectimagedelete.length:"+resultprojectimagedelete.length);
				for(int i=0;i<resultprojectimagedelete.length;i++){
					System.out.println("resultprojectimagedelete"+i+":"+resultprojectimagedelete[i]);
				}*/
				
				//delete from project_desc_image
				String sqldeletefujinpeitao = "delete from near_peitao where id= ?";
				pstmt = con.prepareStatement(sqldeletefujinpeitao);
				for(int i=0;i<fujinpeitaoListdelete.size();i++){
					pstmt.setInt(1, fujinpeitaoListdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resultfujinpeitaodelete=pstmt.executeBatch();
				System.out.println("resultfujinpeitaodelete.length:"+resultfujinpeitaodelete.length);
				for(int i=0;i<resultfujinpeitaodelete.length;i++){
					System.out.println("resultfujinpeitaodelete"+i+":"+resultfujinpeitaodelete[i]);
				}
				
				//delete from project_desc_image
				String sqldeletefujinschool = "delete from near_school where id= ?";
				pstmt = con.prepareStatement(sqldeletefujinschool);
				for(int i=0;i<fujinSchoolListdelete.size();i++){
					pstmt.setInt(1, fujinSchoolListdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resultfujinschooldelete=pstmt.executeBatch();
			System.out.println("resultfujinschooldelete.length:"+resultfujinschooldelete.length);
				for(int i=0;i<resultfujinschooldelete.length;i++){
					System.out.println("resultfujinschooldelete"+i+":"+resultfujinschooldelete[i]);
				}
				
				//delete from project_desc_image
				String sqldeletehousecost = "delete from holding_finace where id= ?";
				pstmt = con.prepareStatement(sqldeletehousecost);
				for(int i=0;i<holdCostListdelete.size();i++){
					pstmt.setInt(1, holdCostListdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resulthousecostdelete=pstmt.executeBatch();
				System.out.println("resulthousecostdelete.length:"+resulthousecostdelete.length);
				for(int i=0;i<resulthousecostdelete.length;i++){
					System.out.println("resulthousecostdelete"+i+":"+resulthousecostdelete[i]);
				}
				
				//delete from project_desc_image
				String sqldeletehousetax = "delete from house_tax where id= ?";
				pstmt = con.prepareStatement(sqldeletehousetax);
				for(int i=0;i<houseTaxListdelete.size();i++){
					pstmt.setInt(1, houseTaxListdelete.get(i).getId());
					pstmt.addBatch();
				}
				int[] resulthousetaxdelete=pstmt.executeBatch();
				System.out.println("resulthousetaxdelete.length:"+resulthousetaxdelete.length);
				for(int i=0;i<resulthousetaxdelete.length;i++){
					System.out.println("resulthousetaxdelete"+i+":"+resulthousetaxdelete[i]);
				}
				//鎻愪氦浜嬬墿
				con.commit();
				//鎭㈠JDBC浜嬪姟
				con.setAutoCommit(true);
				return 1;
			}catch (Exception e) {
				//鍥炴粴JDBC浜嬪姟
				con.rollback();
	            e.printStackTrace();
	            return -1;
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
		
		//娣诲姞椤圭洰
		public int addPro(String project_name, String project_img, String project_nation, String project_address, String project_area, String project_price_qi, String project_type, int project_sales_remain, String project_finish_time, String project_desc, String project_city, String project_house_type, String project_high, String project_price, String project_lan_cn, String project_lan_en, String project_num, String project_vedio, String project_zhou, String area_qujian, String gps, String return_money, int walk_num, String mianji, String project_min_price, String project_high_price, int tuijiandu, String housePrice_update_time, String buytaxInfo, String holdInfo, int min_area, int max_area, String area_num, String developer_num,
				
				String peitao_type,String peitao_name,String peitao_distance,
				 String house_name,String house_img,String house_price,int house_room_num,String tudi_area,String jianzhu_area,String house_size_in,String house_size_out,int house_toilet_num,
				 String image_name,
				 String school_name,String school_distance,
				 String hold_type,int hold_price,String hold_description,String hold_housename,
				 String tax_type,int tax_price,String tax_description,String tax_housename) throws SQLException{
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			boolean flag = true;
			String time = "";
			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(project_finish_time==null||"".equals(project_finish_time)){
				project_finish_time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//"2015-05-09";
			}
			 
	        try {  
	        	time = project_finish_time+" "+"00:00:00";
	            ts = Timestamp.valueOf(time);   
	            
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }  
	        String time1 = "";
			Timestamp ts1 = new Timestamp(System.currentTimeMillis()); 
			if(housePrice_update_time==null||"".equals(housePrice_update_time)){
				housePrice_update_time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//"2015-05-09";
			}
			 
	        try {  
	        	time1 = housePrice_update_time+" "+"00:00:00";
	            ts1 = Timestamp.valueOf(time1);   
	            
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        } 
			
			try{
				con.setAutoCommit(false);
				//椤圭洰娣诲姞
				String sql1= " insert into house_project(project_name, project_img, project_nation, project_address, project_area, project_price_qi, project_type, project_sales_remain,  project_finish_time, project_desc, project_city, project_house_type, project_high, project_price, project_lan_cn, project_lan_en, project_num, project_vedio, project_zhou, area_qujian, gps, return_money, walk_num, mianji, project_min_price, project_high_price, tuijiandu, housePrice_update_time, buytaxInfo, holdInfo, min_area, max_area, area_num, developer_id_name) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				 pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, project_name);
				pstmt.setString(2, project_img);
				pstmt.setString(3, project_nation);
				pstmt.setString(4, project_address);
				pstmt.setString(5, project_area);
				pstmt.setString(6, project_price_qi);
				pstmt.setString(7, project_type);
				pstmt.setInt(8, project_sales_remain);
				pstmt.setString(9,time);
				pstmt.setString(10,project_desc);
				pstmt.setString(11, project_city);
				pstmt.setString(12, project_house_type);
				pstmt.setString(13, project_high);
				pstmt.setString(14, project_price);
				pstmt.setString(15, project_lan_cn);
				pstmt.setString(16, project_lan_en);
				pstmt.setString(17, project_num);
				pstmt.setString(18, project_vedio);
				pstmt.setString(19, project_zhou);
				pstmt.setString(20, area_qujian);
				pstmt.setString(21, gps);
				pstmt.setString(22, return_money);
				pstmt.setInt(23, walk_num);
				pstmt.setString(24, mianji);
				pstmt.setString(25, project_min_price);
				pstmt.setString(26, project_high_price);
				pstmt.setInt(27, tuijiandu);
				pstmt.setString(28, time1);
				pstmt.setString(29, buytaxInfo);
				pstmt.setString(30, holdInfo);
				pstmt.setInt(31, min_area);
				pstmt.setInt(32, max_area);
				pstmt.setString(33, area_num);
				pstmt.setString(34, developer_num);
				int result1 = pstmt.executeUpdate();
				System.out.println("result1:"+result1);
				//鎴峰瀷鍙婁环鏍兼坊鍔�
				String sql2="insert into house_info(house_name,house_img,house_price,house_room_num,tudi_area,jianzhu_area,house_size_in,house_size_out,house_toilet_num,project_num) values (?,?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, house_name);
				pstmt.setString(2, house_img);
				pstmt.setString(3, house_price);
				pstmt.setInt(4, house_room_num);
				pstmt.setString(5, tudi_area);
				pstmt.setString(6, jianzhu_area);
				pstmt.setString(7, house_size_in);
				pstmt.setString(8, house_size_out);
				pstmt.setInt(9, house_toilet_num);
				pstmt.setString(10, project_num);
				int result2 = pstmt.executeUpdate();
				System.out.println("result2:"+result2);
				//椤圭洰閰嶅娣诲姞
				String sql3="insert into project_peitao_image(image_name,image_type,view_shunxu,project_num,project_name) values(?,?,?,?,?) ";
				pstmt = con.prepareStatement(sql3);
				pstmt.setString(1, image_name);
				pstmt.setString(2, "鍥剧墖");
				pstmt.setString(3, "1");
				pstmt.setString(4, project_num);
				pstmt.setString(5, project_name);
				int result3 = pstmt.executeUpdate();
				System.out.println("result3:"+result3);
				//闄勮繎閰嶅娣诲姞
				String sql4= " insert into near_peitao(market_type,market_name,market_distance,project_num) values(?,?,?,?)";
				pstmt = con.prepareStatement(sql4);
				pstmt.setString(1, peitao_type);
				pstmt.setString(2,  peitao_name);
				pstmt.setString(3, peitao_distance);
				pstmt.setString(4, project_num);
				int result4 = pstmt.executeUpdate();
				System.out.println("result4:"+result4);
				//闄勮繎瀛︽牎娣诲姞
				String sql5= " insert into near_school(school_name,school_distance,project_num) values(?,?,?)";
				pstmt = con.prepareStatement(sql5);
				pstmt.setString(1, school_name);
				pstmt.setString(2, school_distance);
				pstmt.setString(3, project_num);
				int result5 = pstmt.executeUpdate();
				System.out.println("result5:"+result5);
				//鎸佹湁鎴愭湰娣诲姞
				String sql6= " insert into holding_finace(type,price,description,view_shunxu,project_num,house_name) values(?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql6);
				pstmt.setString(1, hold_type);
				pstmt.setInt(2, hold_price);
				pstmt.setString(3, hold_description);
				pstmt.setString(4, "1");
				pstmt.setString(5, project_num);
				pstmt.setString(6, hold_housename);
				int result6 = pstmt.executeUpdate();
				System.out.println("result6:"+result6);
				//璐埧绋庤垂娣诲姞
				String sql7= " insert into house_tax(type,price,description,view_shunxu,project_num,house_name) values(?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql6);
				pstmt.setString(1, tax_type);
				pstmt.setInt(2, tax_price);
				pstmt.setString(3, tax_description);
				pstmt.setString(4, "1");
				pstmt.setString(5, project_num);
				pstmt.setString(6, tax_housename);
				int result7 = pstmt.executeUpdate();
				System.out.println("result7:"+result7);
				//鎻愪氦浜嬬墿
				con.commit();
				//鎭㈠JDBC浜嬪姟
				con.setAutoCommit(true);
				return 1;
			}catch (Exception e) {
				//鍥炴粴JDBC浜嬪姟
				con.rollback();
	            e.printStackTrace();
	            return -1;
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

		}
		
	
}
