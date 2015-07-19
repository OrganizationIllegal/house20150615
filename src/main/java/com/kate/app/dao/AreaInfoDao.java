package com.kate.app.dao;

import java.sql.DriverManager;
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

import com.kate.app.model.AreaFamilyBackEnd;
import com.kate.app.model.AreaInfo;
import com.kate.app.model.AreaMiddle2;
import com.kate.app.model.AreaPeopleInfo2;
import com.kate.app.model.AreaTeDian2;
import com.kate.app.model.AreaTuijianBroker;
import com.kate.app.model.AreaTuijianNews;
import com.kate.app.model.AreaTuijianProject;
import com.kate.app.model.AreaZhikong2;
import com.kate.app.model.AreaZujin2;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.InvestmentDataBackEnd;
import com.kate.app.model.MiddlePrice2;
import com.kate.app.model.NewsZhiye;
@Repository 
public class AreaInfoDao extends BaseDao {
	//閫氳繃id鍒犻櫎鍖哄煙鎺ㄨ崘鏂伴椈
			public int deleteNewsBoke(String area_num){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				int exeResult=0;
				try{
						String sql = " delete from recommend_news where area_code= ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, area_num);
						exeResult = pstmt.executeUpdate();
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
				    return exeResult;
			}
	//閫氳繃id鍒犻櫎鍖哄煙鎺ㄨ崘椤圭洰
		public int deleteProject(String area_num){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			int exeResult=0;
			try{
					String sql = " delete from recommend_project where area_code= ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, area_num);
					exeResult = pstmt.executeUpdate();
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
			    return exeResult;
		}	
	//閫氳繃id鍒犻櫎鍖哄煙缁忕邯浜�
	public int deleteBroker(String area_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try{
				String sql = " delete from area_recommend_broker where area_code= ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, area_num);
				exeResult = pstmt.executeUpdate();
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
		    return exeResult;
	}	
	//閫氳繃id鍒犻櫎鍖哄煙浜哄彛鍒嗗竷璧板娍
			public int deletePeople(String area_num){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				int exeResult=0;
				try{
						String sql = " delete from area_people where area_code= ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, area_num);
						exeResult = pstmt.executeUpdate();
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
				    return exeResult;
			}	
	//閫氳繃id鍒犻櫎鍖哄煙鐗圭偣璧板娍
		public int deleteTedian(String area_num){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			int exeResult=0;
			try{
					String sql = " delete from area_features where area_code= ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, area_num);
					exeResult = pstmt.executeUpdate();
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
			    return exeResult;
		}	
	//閫氳繃id鍒犻櫎鍖哄煙绉熷洖鎶ヨ蛋鍔�
	public int deleteHuibao(String area_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try{
				String sql = " delete from area_kongzhi where area_code= ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, area_num);
				exeResult = pstmt.executeUpdate();
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
		    return exeResult;
	}	
	//閫氳繃id鍒犻櫎鍖哄煙绉熼噾璧板娍
			public int deleteZujin(String area_num){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				int exeResult=0;
				try{
						String sql = " delete from area_zujin where area_code= ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, area_num);
						exeResult = pstmt.executeUpdate();
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
				    return exeResult;
			}	
	//閫氳繃id鍒犻櫎鍖哄煙鎴夸环涓綅鏁拌蛋鍔�
		public int deleteMiddleTrend(String area_num){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			int exeResult=0;
			try{
					String sql = " delete from area_middle where area_code= ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, area_num);
					exeResult = pstmt.executeUpdate();
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
			    return exeResult;
		}	
	//閫氳繃id鍒犻櫎鍖哄煙涓綅鏁版埧浠�
	public int deleteMiddlePrice(String area_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		int exeResult=0;
		try{
				String sql = " delete from area_middle_price where area_quyu= ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, area_num);
				exeResult = pstmt.executeUpdate();
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
		    return exeResult;
	}	
	//閫氳繃id鍒犻櫎鍖哄煙瀹跺涵鏋勬垚
			public int deleteFamily(String area_num){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;

				int exeResult=0;
				try{
						String sql = " delete from area_family where area_code= ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, area_num);
						exeResult = pstmt.executeUpdate();
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
				    return exeResult;
			}
	//閫氳繃id鍒犻櫎鎶曡祫鏁版嵁
		public int deleteInvest(String area_num){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			int exeResult=0;
			try{
					String sql = " delete from investment_data where area_num= ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, area_num);
					exeResult = pstmt.executeUpdate();
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
			    return exeResult;
		}
	//閫氳繃id鍒犻櫎鍖哄煙淇℃伅
	public int deleteAreaInfo(int id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try{
				String sql = " delete from area_info where id= ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				exeResult = pstmt.executeUpdate();
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
		    return exeResult;
	}
	//閫氳繃鍖哄煙id鑾峰彇鏂伴椈鎶ラ亾淇℃伅
		public List<NewsZhiye> getAreaNewsBokeList(String area_num){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			List<NewsZhiye> areaInfolist = new ArrayList<NewsZhiye>();
			AreaTuijianNews areaInfo=new AreaTuijianNews();
			NewsZhiye newsZhiyeInfo = new NewsZhiye();
			try {
				String sql = " SELECT * from recommend_news where area_code=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,area_num);
				  rs = pstmt.executeQuery();
				while(rs.next()){
					areaInfo.setId(rs.getInt("id"));
					areaInfo.setReco_news_num_1(rs.getString("reco_news_num_1"));
					areaInfo.setReco_news_num_2(rs.getString("reco_news_num_2"));
					areaInfo.setReco_news_num_3(rs.getString("reco_news_num_3"));
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
			String news1=areaInfo.getReco_news_num_1();
			String news2=areaInfo.getReco_news_num_2();
			String news3=areaInfo.getReco_news_num_3();
			if(news1!=null && !"".equals(news1)){
			if(news1.startsWith("blog")){
				newsZhiyeInfo=getNewsBokeList(news1);
				areaInfolist.add(newsZhiyeInfo);
			}else{
				newsZhiyeInfo=getZhiYeZhiDaoList(news1);
				areaInfolist.add(newsZhiyeInfo);
			}}
			if(news2!=null && !"".equals(news2)){
			if(news2.startsWith("blog")){
				newsZhiyeInfo=getNewsBokeList(news2);
				areaInfolist.add(newsZhiyeInfo);
			}else{
				newsZhiyeInfo=getZhiYeZhiDaoList(news2);
				areaInfolist.add(newsZhiyeInfo);
			}}
			if(news3!=null && !"".equals(news3)){
			if(news3.startsWith("blog")){
				newsZhiyeInfo=getNewsBokeList(news3);
				areaInfolist.add(newsZhiyeInfo);
			}else{
				newsZhiyeInfo=getZhiYeZhiDaoList(news3);
				areaInfolist.add(newsZhiyeInfo);
			}}
			return areaInfolist;
		}
		
		public NewsZhiye getNewsBokeList(String news_num){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			NewsZhiye newsBokeInfo = new NewsZhiye();
			try {
				String sql = " SELECT * from news_boke where news_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,news_num);
				  rs = pstmt.executeQuery();
				while(rs.next()){
					newsBokeInfo.setId(rs.getInt("id"));
					newsBokeInfo.setTitle(rs.getString("news_title"));
					newsBokeInfo.setPeople(rs.getString("news_people"));
					newsBokeInfo.setFenlei(rs.getString("news_fenlei"));
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
			return newsBokeInfo;
		}
		
		public NewsZhiye getZhiYeZhiDaoList(String zhiye_num){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			NewsZhiye zhiyeInfo = new NewsZhiye();
			try {
				String sql = " SELECT * from zhiye_zhidao where zhiye_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,zhiye_num);
				  rs = pstmt.executeQuery();
				while(rs.next()){
					zhiyeInfo.setId(rs.getInt("id"));
					zhiyeInfo.setTitle(rs.getString("title"));
					zhiyeInfo.setPeople(rs.getString("fabu_people"));
					zhiyeInfo.setFenlei(rs.getString("fenlei"));
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

			return zhiyeInfo;
		}
	//閫氳繃鍖哄煙id鑾峰彇鎺ㄨ崘椤圭洰淇℃伅
	public List<HouseProject> getAreaProjectList(String area_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<HouseProject> areaInfolist = new ArrayList<HouseProject>();
		AreaTuijianProject areaInfo=new AreaTuijianProject();
		HouseProject projectInfo = new HouseProject();
		try {
			String sql = " SELECT * from recommend_project where area_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,area_num);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				areaInfo.setId(rs.getInt("id"));
				areaInfo.setRecommend_num_1(rs.getString("recommend_num_1"));
				areaInfo.setRecommend_num_2(rs.getString("recommend_num_2"));
				areaInfo.setRecommend_num_3(rs.getString("recommend_num_3"));
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
		String pro1=areaInfo.getRecommend_num_1();
		String pro2=areaInfo.getRecommend_num_2();
		String pro3=areaInfo.getRecommend_num_3();
		projectInfo=getProjectList(pro1);
		areaInfolist.add(projectInfo);
		projectInfo=getProjectList(pro2);
		areaInfolist.add(projectInfo);
		projectInfo=getProjectList(pro3);
		areaInfolist.add(projectInfo);
		return areaInfolist;
	}
	
	public HouseProject getProjectList(String project_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		HouseProject projectInfo = new HouseProject();
		try {
			String sql = " SELECT * from house_project where project_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,project_num);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				projectInfo.setId(rs.getInt("id"));
				projectInfo.setProject_name(rs.getString("project_name"));
				projectInfo.setProject_area(rs.getString("project_area"));
				projectInfo.setProject_price_qi(rs.getString("project_price_qi"));
				projectInfo.setProject_type(rs.getString("project_type"));
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
		return projectInfo;
	}
	//閫氳繃鍖哄煙id鑾峰彇鎺ㄨ崘缁忕邯浜轰俊鎭�
			public List<BrokerInfo> getAreaBrokerList(String area_num){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;

				List<BrokerInfo> areaInfolist = new ArrayList<BrokerInfo>();
				AreaTuijianBroker areaInfo = new AreaTuijianBroker();
				BrokerInfo brokerInfo=new BrokerInfo();
				try {
					String sql = " SELECT * from area_recommend_broker where area_code=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,area_num);
					  rs = pstmt.executeQuery();
					while(rs.next()){
						areaInfo.setId(rs.getInt("id"));
						areaInfo.setBroker_code1(rs.getString("broker_code1"));
						areaInfo.setBroker_code2(rs.getString("broker_code2"));
						areaInfo.setBroker_code3(rs.getString("broker_code3"));
						
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
				String broker1=areaInfo.getBroker_code1();
				String broker2=areaInfo.getBroker_code2();
				String broker3=areaInfo.getBroker_code3();
				brokerInfo=getBrokerList(broker1);
				areaInfolist.add(brokerInfo);
				brokerInfo=getBrokerList(broker2);
				areaInfolist.add(brokerInfo);
				brokerInfo=getBrokerList(broker3);
				areaInfolist.add(brokerInfo);
				return areaInfolist;
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
	//閫氳繃鍖哄煙id鑾峰彇鍖哄煙浜哄彛鍒嗗竷淇℃伅
		public List<AreaPeopleInfo2> getAreaPeopleList(String area_num){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			List<AreaPeopleInfo2> areaInfolist = new ArrayList<AreaPeopleInfo2>();
			try {
				String sql = " SELECT * from area_people where area_code=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,area_num);
				  rs = pstmt.executeQuery();
				while(rs.next()){
					AreaPeopleInfo2 areaInfo = new AreaPeopleInfo2();
					areaInfo.setId(rs.getInt("id"));
					//areaInfo.setView_shunxu(rs.getInt("view_shunxu"));
					areaInfo.setView_shunxu_people(rs.getInt("view_shunxu"));
					//areaInfo.setArea_code(rs.getString("area_code"));
					areaInfo.setColumn1(rs.getString("column1"));
					areaInfo.setColumn2(rs.getString("column2"));
					areaInfo.setColumn3(rs.getString("column3"));
					areaInfo.setPeople_datasource(rs.getString("people_datasource"));
					areaInfo.setPeople_date(rs.getString("people_date"));
					areaInfolist.add(areaInfo);
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
			return areaInfolist;
		}
	//閫氳繃鍖哄煙id鑾峰彇鍖哄煙鐗圭偣淇℃伅
	public List<AreaTeDian2> getAreaTedianList(String area_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		List<AreaTeDian2> areaInfolist = new ArrayList<AreaTeDian2>();
		try {
			String sql = " SELECT * from area_features where area_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,area_num);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				AreaTeDian2 areaInfo = new AreaTeDian2();
				areaInfo.setId(rs.getInt("id"));
				areaInfo.setArea_character(rs.getString("area_character"));
				areaInfo.setView_shunxu(rs.getInt("view_shunxu"));
				//areaInfo.setArea_code(rs.getString("area_code"));
				areaInfo.setData_source(rs.getString("data_source"));
				areaInfo.setUpdate_time(rs.getString("update_time"));
				areaInfolist.add(areaInfo);
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
		return areaInfolist;
	}
	//閫氳繃鍖哄煙id鑾峰彇鍖哄煙绉熼噾鍥炴姤璧板娍淇℃伅
			public List<AreaZhikong2> getAreaKongzhiList(String area_num){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;
				List<AreaZhikong2> areaInfolist = new ArrayList<AreaZhikong2>();
				try {
					String sql = " SELECT * from area_kongzhi where area_code=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,area_num);
					  rs = pstmt.executeQuery();
					while(rs.next()){
						AreaZhikong2 areaInfo = new AreaZhikong2();
						areaInfo.setId(rs.getInt("id"));
						areaInfo.setHeng4(rs.getInt("heng"));
						areaInfo.setZong4(rs.getInt("zong"));
						areaInfo.setView_shunxu4(rs.getInt("view_shunxu"));
						areaInfo.setProject_type4(rs.getString("project_type"));
						//areaInfo.setArea_code(rs.getString("area_code"));
						areaInfo.setZujin_huibao_datasource(rs.getString("zujin_huibao_datasource"));
						areaInfo.setZujin_huibao_date(rs.getString("zujin_huibao_date"));
						areaInfolist.add(areaInfo);
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
				return areaInfolist;
			}
			
	//閫氳繃鍖哄煙id鑾峰彇鍖哄煙绉熼噾璧板娍淇℃伅
		public List<AreaZujin2> getAreaZujinList(String area_num){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			List<AreaZujin2> areaInfolist = new ArrayList<AreaZujin2>();
			try {
				String sql = " SELECT * from area_zujin where area_code=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,area_num);
				  rs = pstmt.executeQuery();
				while(rs.next()){
					AreaZujin2 areaInfo = new AreaZujin2();
					areaInfo.setId(rs.getInt("id"));
					areaInfo.setHeng3(Integer.parseInt(rs.getString("heng")));
					areaInfo.setZong3(rs.getInt("zong"));
					areaInfo.setView_shunxu3(rs.getInt("view_shunxu"));
					areaInfo.setProject_type3(rs.getString("project_type"));
					//areaInfo.setArea_code(rs.getString("area_code"));
					areaInfo.setZujin_datasource(rs.getString("zujin_datasource"));
					areaInfo.setZujin_date(rs.getString("zujin_date"));
					areaInfolist.add(areaInfo);
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
			return areaInfolist;
		}
		
	//閫氳繃鍖哄煙id鑾峰彇鍖哄煙鎴夸环涓綅鏁拌蛋鍔夸俊鎭�
	public List<AreaMiddle2> getAreaMiddleList(String area_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		List<AreaMiddle2> areaInfolist = new ArrayList<AreaMiddle2>();
		try {
			String sql = " SELECT * from area_middle where area_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,area_num);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				AreaMiddle2 areaInfo = new AreaMiddle2();
				areaInfo.setId(rs.getInt("id"));
				areaInfo.setHeng2(Integer.parseInt(rs.getString("heng")));
				areaInfo.setZong2(rs.getInt("zong"));
				areaInfo.setView_shunxu2(rs.getInt("view_shunxu"));
				areaInfo.setProject_type2(rs.getString("project_type"));
				//areaInfo.setArea_code2(rs.getString("area_code"));
				areaInfo.setMiddle_zoushi_datasource(rs.getString("middle_zoushi_datasource"));
				areaInfo.setMiddle_zoushi_date(rs.getString("middle_zoushi_date"));
				areaInfolist.add(areaInfo);
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
		return areaInfolist;
	}
	//閫氳繃鍖哄煙id鑾峰彇鍖哄煙涓綅鏁版埧浠蜂俊鎭�
			public List<MiddlePrice2> getMiddlePrice(String area_num){
				Statement stmt = null;
				ResultSet rs = null;
				PreparedStatement pstmt = null;

				List<MiddlePrice2> areaInfolist = new ArrayList<MiddlePrice2>();
				try {
					String sql = " SELECT * from area_middle_price where area_quyu=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,area_num);
					  rs = pstmt.executeQuery();
					while(rs.next()){
						MiddlePrice2 areaInfo = new MiddlePrice2();
						areaInfo.setId(rs.getInt("id"));
						areaInfo.setBuy_price(rs.getInt("buy_price"));
						areaInfo.setZu_price(rs.getInt("zu_price"));
						areaInfo.setBuy_one_name(rs.getString("buy_one_name"));
						areaInfo.setBuy_one_price(rs.getInt("buy_one_price"));
						areaInfo.setBuy_two_name(rs.getString("buy_two_name"));
						areaInfo.setBuy_two_price(rs.getInt("buy_two_price"));
						areaInfo.setBuy_three_name(rs.getString("buy_three_name"));
						areaInfo.setBuy_three_price(rs.getInt("buy_three_price"));
						areaInfo.setZu_one_name(rs.getString("zu_one_name"));
						areaInfo.setZu_one_price(rs.getInt("zu_one_price"));
						areaInfo.setZu_two_name(rs.getString("zu_two_name"));
						areaInfo.setZu_two_price(rs.getInt("zu_two_price"));
						areaInfo.setZu_three_name(rs.getString("zu_three_name"));
						areaInfo.setZu_three_price(rs.getInt("zu_three_price"));
						//areaInfo.setArea_quyu(rs.getString("area_quyu"));
						areaInfo.setProject_type(rs.getString("project_type"));
						areaInfo.setMiddle_datasource(rs.getString("middle_datasource"));
						//areaInfo.setUpdate_time(rs.getTimestamp("update_time"));
					    areaInfo.setMiddle_date(rs.getString("middle_date"));
						areaInfolist.add(areaInfo);
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
				return areaInfolist;
			}

	//閫氳繃鍖哄煙id鑾峰彇鎶曡祫瀹跺涵淇℃伅
		public AreaFamilyBackEnd getFamilyBackEnd(String area_num){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			AreaFamilyBackEnd areaInfo = new AreaFamilyBackEnd();
			try {
				String sql = " SELECT * from area_family where area_code=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,area_num);
				  rs = pstmt.executeQuery();
				while(rs.next()){
					areaInfo.setId(rs.getInt("id"));
					areaInfo.setFamily_one(rs.getString("family_one"));
					areaInfo.setFamily_one_rate(rs.getString("family_one_rate"));
					areaInfo.setFamily_two(rs.getString("family_two"));
					areaInfo.setFamily_three(rs.getString("family_three"));
					areaInfo.setFamily_two_rate(rs.getString("family_two_rate"));
					areaInfo.setFamily_three_rate(rs.getString("family_three_rate"));
					areaInfo.setFamily_datasource(rs.getString("family_datasource"));
					areaInfo.setFamily_date(rs.getTimestamp("family_date"));
					areaInfo.setArea_code(rs.getString("area_code"));
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
			return areaInfo;
		}
	//閫氳繃鍖哄煙id鑾峰彇鎶曡祫鏁版嵁淇℃伅
	public InvestmentDataBackEnd getInvestInfo(String area_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		InvestmentDataBackEnd areaInfo = new InvestmentDataBackEnd();
		try {
			String sql = " SELECT * from investment_data where area_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,area_num);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				areaInfo.setId(rs.getInt("id"));
				areaInfo.setYear_increment_rate(rs.getString("year_increment_rate"));
				areaInfo.setMiddle_price(rs.getString("middle_price"));
				areaInfo.setMiddle_zu_price(rs.getString("middle_zu_price"));
				areaInfo.setZu_house_rate(rs.getString("zu_house_rate"));
				areaInfo.setZu_xuqiu(rs.getString("zu_xuqiu"));
				areaInfo.setPrice_review(rs.getString("price_review"));
				areaInfo.setArea_name(rs.getString("area_name"));
				areaInfo.setArea_num(rs.getString("area_num"));
				
				areaInfo.setTouzi_datasource(rs.getString("touzi_datasource"));
				areaInfo.setTouzi_date(rs.getTimestamp("touzi_date"));
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
		return areaInfo;
	}
	//鍒ゆ柇鍖哄煙缂栧彿鏄惁閲嶅
	public int isDuplicate(String area_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		HashSet<String> areaNumSet=new HashSet<String>();
		try {
			String sql = " SELECT area_num from area_info";
			pstmt = con.prepareStatement(sql);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				String anum=rs.getString("area_num");
				areaNumSet.add(anum);
			}
			if(areaNumSet.contains(area_num)){//濡傛灉鍖呮嫭area_num鏃讹紝杩斿洖1
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
	//鍖哄煙褰曞叆
	public int AddArea(String area_num,String area_name,String area_city,String area_zhou,String area_nation,String area_postcode,String touzi_datasource,String touzi_date,String middle_price,String middle_zu_price,String price_review,String year_increment_rate,String zu_house_rate,String zu_xuqiu,String data_exam,String family_one,String family_one_rate,String family_two,String family_two_rate,String family_three,String family_three_rate,String family_datasource,String family_date,List<MiddlePrice2> middlepriceList,List<AreaMiddle2> middletrendList,List<AreaZujin2> zujintrendlistList,List<AreaZhikong2> huibaotrendlistList,List<AreaTeDian2> tedianlistList,List<AreaPeopleInfo2> peoplelistList,List<BrokerInfo> brokerlistList,List<String> projectlistList,List<String> newslistList,List<String> list) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			con.setAutoCommit(false);
			//鍖哄煙淇℃伅
			boolean flagquyu;
			String sql = " insert into area_info(area_num, area_name, area_city, area_zhou, area_nation, area_postcode) values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_num);
			pstmt.setString(2, area_name);
			pstmt.setString(3, area_city);
			pstmt.setString(4, area_zhou);
			pstmt.setString(5, area_nation);
			pstmt.setString(6, area_postcode);
			
			int resultquyu = pstmt.executeUpdate();
			if(resultquyu == 0){
				flagquyu = false;
			}
			
			//鎶曡祫鏁版嵁
			boolean flagtouzi = true;
			String time_strtouzi = "";
			Timestamp tstouzi = new Timestamp(System.currentTimeMillis()); 
			if(touzi_date==null||"".equals(touzi_date)){
				touzi_date = "2015-05-09";
				//(new SimpleDateFormat("yyyy-MM-dd"))銆俧ormat(new Date())
			}
	        try {   
	        	time_strtouzi = touzi_date+" "+"00:00:00";
	        	tstouzi = Timestamp.valueOf(time_strtouzi);   
	            System.out.println(tstouzi);   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }
	        String sqltouzi = " insert into investment_data(year_increment_rate, middle_price, middle_zu_price, zu_house_rate, zu_xuqiu, price_review, data_exam, area_num, area_name, touzi_datasource, touzi_date) values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sqltouzi);
			pstmt.setString(1, year_increment_rate);
			pstmt.setString(2, middle_price);
			pstmt.setString(3, middle_zu_price);
			pstmt.setString(4, zu_house_rate);
			pstmt.setString(5, zu_xuqiu);
			pstmt.setString(6, price_review);
			pstmt.setString(7, data_exam);
			pstmt.setString(8, area_num);
			pstmt.setString(9, area_name);
			pstmt.setString(10, touzi_datasource);
			pstmt.setString(11, time_strtouzi);
			int resulttouzi = pstmt.executeUpdate();
			if(resulttouzi == 0){
				flagtouzi = false;
			}
	        //areafamily
			boolean flagfamily = true;
			String time_strfamily = "";
			Timestamp tsfamily = new Timestamp(System.currentTimeMillis()); 
			if(family_date==null||"".equals(family_date)){
				family_date = "2015-05-09";
			}
	        try {   
	        	time_strfamily = family_date+" "+"00:00:00";
	        	tsfamily = Timestamp.valueOf(time_strfamily);   
	            System.out.println(tsfamily);   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }  
	        String sqlfamily = " insert into area_family(family_one, family_one_rate, family_two, family_two_rate, family_three, family_three_rate, area_code, family_datasource, family_date) values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sqlfamily);
			pstmt.setString(1, family_one);
			pstmt.setString(2, family_one_rate);
			pstmt.setString(3, family_two);
			pstmt.setString(4, family_two_rate);
			pstmt.setString(5, family_three);
			pstmt.setString(6, family_three_rate);
			pstmt.setString(7, area_num);
			pstmt.setString(8, family_datasource);
			pstmt.setString(9, family_date);
			
			
			int result = pstmt.executeUpdate();
			if(result == 0){
				flagfamily = false;
			}
	        //鍖哄煙涓綅鏁版埧浠�
			for(MiddlePrice2 item : middlepriceList){
				boolean flagmiddleprice = true;
				int buy_price = item.getBuy_price();
				int zu_price = item.getZu_price();
				String buy_one_name =item.getBuy_one_name();
				int buy_one_price = item.getBuy_one_price();
				String buy_two_name =item.getBuy_two_name();
				int buy_two_price = item.getBuy_two_price();
				String buy_three_name =item.getBuy_three_name();
				int buy_three_price = item.getBuy_three_price();
				String zu_one_name =item.getZu_one_name();
				int zu_one_price = item.getZu_one_price();
				String zu_two_name =item.getZu_two_name();
				int zu_two_price = item.getZu_two_price();
				String zu_three_name =item.getZu_three_name();
				int zu_three_price = item.getZu_three_price();
				String middle_datasource = item.getMiddle_datasource();
				String project_type=item.getProject_type();
				
				
				String middle_date = item.getMiddle_date();
				String time_str = "";
				if(middle_date != null){
					time_str = middle_date.toString(); 
				}
				
		        
				
					String sqlmiddleprice = " insert into area_middle_price(buy_price, zu_price, " +
							"buy_one_name, buy_one_price, buy_two_name, buy_two_price, " +
							"buy_three_name, buy_three_price, zu_one_name, zu_one_price, " +
							"zu_two_name, zu_two_price, zu_three_name, zu_three_price, area_quyu, " +
							"middle_datasource, middle_date,project_type) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = con.prepareStatement(sqlmiddleprice);
					pstmt.setInt(1, buy_price);
					pstmt.setInt(2, zu_price);
					pstmt.setString(3, buy_one_name);
					pstmt.setInt(4, buy_one_price);
					pstmt.setString(5, buy_two_name);
					pstmt.setInt(6, buy_two_price);
					pstmt.setString(7, buy_three_name);
					pstmt.setInt(8, buy_three_price);
					pstmt.setString(9, zu_one_name);
					pstmt.setInt(10, zu_one_price);
					pstmt.setString(11, zu_two_name);
					pstmt.setInt(12, zu_two_price);
					pstmt.setString(13, zu_three_name);
					pstmt.setInt(14, zu_three_price);
					pstmt.setString(15, area_num);
					pstmt.setString(16, middle_datasource);
					pstmt.setString(17, time_str);
					pstmt.setString(18, project_type);
					
					
					
					int resultmiddleprice = pstmt.executeUpdate();
					if(resultmiddleprice == 0){
						flagmiddleprice = false;
					}
				    
			}
			//鍖哄煙鎴夸环涓綅鏁拌蛋鍔�
			for(AreaMiddle2 item : middletrendList){
				/*boolean resultMiddle = areaInfoDao.addMiddleTrend(item, area_num);*/
				boolean flag = true;
				int heng = item.getHeng2();
				int zong = item.getZong2();
				int view_shunxu =item.getView_shunxu2();
				String project_type = item.getProject_type2();
				
				String middle_zoushi_datasource = item.getMiddle_zoushi_datasource();
				String middle_zoushi_date = item.getMiddle_zoushi_date();
				String time_str = "";
				if(middle_zoushi_date != null){
					time_str = middle_zoushi_date.toString(); 
				}
				
		        
				
					String sqlareamiddle = " insert into area_middle(heng, zong, " +
							"view_shunxu, project_type, area_code, middle_zoushi_datasource, " +
							"middle_zoushi_date) values(?,?,?,?,?,?,?)";
					pstmt = con.prepareStatement(sqlareamiddle);
					pstmt.setInt(1, heng);
					pstmt.setInt(2, zong);
					pstmt.setInt(3, view_shunxu);
					pstmt.setString(4, project_type);
					pstmt.setString(5, area_num);
					pstmt.setString(6, middle_zoushi_datasource);
					pstmt.setString(7, time_str);
					
					
					
					int resultareamiddle = pstmt.executeUpdate();
					if(resultareamiddle == 0){
						flag = false;
					}
				
			}
			//鍖哄煙绉熼噾璧板娍
			for(AreaZujin2 item : zujintrendlistList){
				/*boolean resultZujin = areaInfoDao.addMiddleZujin(item, area_num);*/
				boolean flag = true;
				int heng = item.getHeng3();
				int zong = item.getZong3();
				int view_shunxu =item.getView_shunxu3();
				String project_type = item.getProject_type3();
				
				String zujin_datasource = item.getZujin_datasource();
				String zujin_dates = item.getZujin_date();
				String time_str = "";
				if(zujin_dates != null){
					time_str = zujin_dates.toString(); 
				}
				
		        
				
					String sqlzuijin = " insert into area_zujin(heng, zong, " +
							"view_shunxu, project_type, area_code, zujin_datasource, " +
							"zujin_date) values(?,?,?,?,?,?,?)";
					pstmt = con.prepareStatement(sqlzuijin);
					pstmt.setInt(1, heng);
					pstmt.setInt(2, zong);
					pstmt.setInt(3, view_shunxu);
					pstmt.setString(4, project_type);
					pstmt.setString(5, area_num);
					pstmt.setString(6, zujin_datasource);
					pstmt.setString(7, time_str);
					
					
					
					int resultzuijin = pstmt.executeUpdate();
					if(resultzuijin == 0){
						flag = false;
					}
				
			}
			//鍖哄煙绉熼噾鍥炴姤鐜�
			for(AreaZhikong2 item : huibaotrendlistList){
				/*boolean resultZujin = areaInfoDao.addAreaZhikong(item, area_num);*/
				boolean flag = true;
				int heng = item.getHeng4();
				int zong = item.getZong4();
				int view_shunxu =item.getView_shunxu4();
				String project_type = item.getProject_type4();
				
				String zujin_huibao_datasource = item.getZujin_huibao_datasource();
				String zujin_huibao_date = item.getZujin_huibao_date();
				String time_str = "";
				if(zujin_huibao_date != null){
					time_str = zujin_huibao_date.toString(); 
				}
				
		        
				
					String sqlhuibao = " insert into area_kongzhi(heng, zong, " +
							"view_shunxu, project_type, area_code, zujin_huibao_datasource, " +
							"zujin_huibao_date) values(?,?,?,?,?,?,?)";
					pstmt = con.prepareStatement(sqlhuibao);
					pstmt.setInt(1, heng);
					pstmt.setInt(2, zong);
					pstmt.setInt(3, view_shunxu);
					pstmt.setString(4, project_type);
					pstmt.setString(5, area_num);
					pstmt.setString(6, zujin_huibao_datasource);
					pstmt.setString(7, time_str);
					
					
					
					int resulthuibao = pstmt.executeUpdate();
					if(resulthuibao == 0){
						flag = false;
					}
				
			}
			//鍖哄煙鐗圭偣
			for(AreaTeDian2 item : tedianlistList){
				/*boolean resultZujin = areaInfoDao.addAreaTeDian(item, area_num);*/
				boolean flag = true;
				String area_character = item.getArea_character();
				int view_shunxu = item.getView_shunxu();
				
				
				String data_source = item.getData_source();
				String update_time = item.getUpdate_time();
				String time_str = "";
				if(update_time != null){
					time_str = update_time.toString(); 
				}
				
		        
				
					String sqltedian = " insert into area_features(area_character, view_shunxu, " +
							"area_code, data_source, update_time ) values(?,?,?,?,?)";
					pstmt = con.prepareStatement(sqltedian);
					pstmt.setString(1, area_character);
					pstmt.setInt(2, view_shunxu);
					
					pstmt.setString(3, area_num);
					
					pstmt.setString(4, data_source);
					pstmt.setString(5, time_str);
					
					
					
					int resulttedian = pstmt.executeUpdate();
					if(resulttedian == 0){
						flag = false;
					}
				
			}
			//鍖哄煙浜哄彛鍒嗗竷
			for(AreaPeopleInfo2 item : peoplelistList){
				/*boolean resultZujin = areaInfoDao.addAreaPeople(item, area_num);*/
				boolean flag = true;
				String column1 = item.getColumn1();
				String column2 = item.getColumn2();
				String column3 = item.getColumn3();
				int view_shunxu = item.getView_shunxu_people();
				String people_datasource = item.getPeople_datasource();
				String people_date = item.getPeople_date();
				String time_str = "";
				if(people_date != null){
					time_str = people_date.toString(); 
				}
				
		        
				
					String sqlpeople = " insert into area_people(column1, column2, " +
							"column3, view_shunxu, area_code, people_datasource, people_date) values(?,?,?,?,?,?,?)";
					pstmt = con.prepareStatement(sqlpeople);
					pstmt.setString(1, column1);
					pstmt.setString(2, column2);
					pstmt.setString(3, column3);
					pstmt.setInt(4, view_shunxu);
		            pstmt.setString(5, area_num);
					pstmt.setString(6, people_datasource);
					pstmt.setString(7, time_str);
					int resultpeople = pstmt.executeUpdate();
					if(resultpeople == 0){
						flag = false;
					}
				
			}
			//鎺ㄨ崘缁忕邯浜�
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
			
				String sqlbroker = " insert into area_recommend_broker(broker_code1, broker_code2, " +
						"broker_code3, area_code) values(?,?,?,?)";
				pstmt = con.prepareStatement(sqlbroker);
				pstmt.setString(1, broker_code1);
				pstmt.setString(2, broker_code2);
				pstmt.setString(3, broker_code3);
				pstmt.setString(4, area_num);
				
				int resultbroker = pstmt.executeUpdate();
				if(resultbroker == 0){
					flagbroker = false;
				}
			
			//鎺ㄨ崘椤圭洰
			boolean flagproject = true;
			
			String recommend_num_1 = "";
			String recommend_num_2 = "";
			String recommend_num_3 = "";
			
			if(projectlistList.size()==1){
				String name = projectlistList.get(0);
				recommend_num_1 = findProByName(name);
			}
			else if(projectlistList.size()==2){
				String name1 = projectlistList.get(0);
				String name2 = projectlistList.get(1);
				recommend_num_1 = findProByName(name1);
				recommend_num_2 = findProByName(name2);
				
			}
			else if(projectlistList.size()>=3){
				String name1 = projectlistList.get(0);
				String name2 = projectlistList.get(1);
				String name3 = projectlistList.get(2);
				recommend_num_1 = findProByName(name1);
				recommend_num_2 = findProByName(name2);
				recommend_num_3 = findProByName(name3);
			}
			
				String sqlproject = " insert into recommend_project(recommend_num_1, recommend_num_2, " +
						"recommend_num_3, area_code) values(?,?,?,?)";
				pstmt = con.prepareStatement(sqlproject);
				pstmt.setString(1, recommend_num_1);
				pstmt.setString(2, recommend_num_2);
				pstmt.setString(3, recommend_num_3);
				pstmt.setString(4, area_num);
				
				int resultproject = pstmt.executeUpdate();
				if(resultproject == 0){
					flagproject = false;
				}
			
			//鏂伴椈鎶ラ亾
			boolean flagnews = true;
			String reco_news_num_1 = "";
			String reco_news_num_2 = "";
			String reco_news_num_3 = "";
			List<String> resultList = new ArrayList<String>();
			for(String name : newslistList){
				String num = findBokeByName(name);
				resultList.add(num);
			}
			for(String name1 : list){
				String num1 = findZhiYeByName(name1);
				resultList.add(num1);
			}
			
			if(resultList.size()==1){
				reco_news_num_1 = resultList.get(0);
			}
			else if(resultList.size()==2){
				reco_news_num_1 = resultList.get(0);
				reco_news_num_2 = resultList.get(1);
				
				
			}
			else if(resultList.size()>=3){
				reco_news_num_1 = resultList.get(0);
				reco_news_num_2 = resultList.get(1);
				reco_news_num_3 = resultList.get(2);
			}
			
				String sqlnews = " insert into recommend_news(reco_news_num_1, reco_news_num_2, " +
						"reco_news_num_3, area_code) values(?,?,?,?)";
				pstmt = con.prepareStatement(sqlnews);
				pstmt.setString(1, reco_news_num_1);
				pstmt.setString(2, reco_news_num_2);
				pstmt.setString(3, reco_news_num_3);
				pstmt.setString(4, area_num);
				
				int resultnews = pstmt.executeUpdate();
				if(resultnews == 0){
					flagnews = false;
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

	//区域编辑

		public int EditArea(int Id,int Id2,int Id3,String area_num,String area_name,String area_city,String area_zhou,String area_nation,String area_postcode,String touzi_datasource,String touzi_date,String middle_price,String middle_zu_price,String price_review,String year_increment_rate,String zu_house_rate,String zu_xuqiu,String data_exam,String family_one,String family_one_rate,String family_two,String family_two_rate,String family_three,String family_three_rate,String family_datasource,String family_date,List<MiddlePrice2> middlepriceList,List<MiddlePrice2> middlepriceList2,List<AreaMiddle2> middletrendList,List<AreaMiddle2> middletrendList2,List<AreaZujin2> zujintrendlistList,List<AreaZujin2> zujintrendlistList2,List<AreaZhikong2> huibaotrendlistList,List<AreaZhikong2> huibaotrendlistList2,List<AreaTeDian2> tedianlistList,List<AreaTeDian2> tedianlistList2,List<AreaPeopleInfo2> peoplelistList,List<AreaPeopleInfo2> peoplelistList2,List<BrokerInfo> brokerlistList,List<String> projectlistList,List<String> newslistList,List<String> list
				,List<MiddlePrice2> middlepriceListdelete,List<AreaMiddle2> middletrendListdelete,List<AreaZujin2> zujintrendlistListdelete
				,List<AreaZhikong2> huibaotrendlistListdelete,List<AreaTeDian2> tedianlistListdelete,List<AreaPeopleInfo2> peoplelistListdelete) throws SQLException{

			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				con.setAutoCommit(false);
				//鍖哄煙淇℃伅
				boolean flagquyu;
				String sql = " update  area_info set area_num=?, area_name=?, area_city=?, area_zhou=?, area_nation=?, area_postcode=? where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, area_num);
				pstmt.setString(2, area_name);
				pstmt.setString(3, area_city);
				pstmt.setString(4, area_zhou);
				pstmt.setString(5, area_nation);
				pstmt.setString(6, area_postcode);
				pstmt.setInt(7, Id);
				
				int resultquyu = pstmt.executeUpdate();
				if(resultquyu == 0){
					flagquyu = false;
				}
				
				//鎶曡祫鏁版嵁
				boolean flagtouzi = true;
				String time_strtouzi = "";
				if("".equals(touzi_date)){
					touzi_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//
				}
				/*Timestamp tstouzi = new Timestamp(System.currentTimeMillis()); 
				if(touzi_date==null||"".equals(touzi_date)){
					touzi_date = "2015-05-09";
					//(new SimpleDateFormat("yyyy-MM-dd"))銆俧ormat(new Date())
				 	time_strtouzi = touzi_date+" "+"00:00:00";
				}
		        try {   
		       
		        	tstouzi = Timestamp.valueOf(time_strtouzi);   
		            System.out.println(tstouzi);   
		        } catch (Exception e) {   
		            e.printStackTrace();   
		        }*/
		        String sqltouzi = " update investment_data set year_increment_rate=?, middle_price=?, middle_zu_price=?, zu_house_rate=?, zu_xuqiu=?, price_review=?, data_exam=?, area_num=?, area_name=?, touzi_datasource=?, touzi_date=? where id=?";
				pstmt = con.prepareStatement(sqltouzi);
				pstmt.setString(1, year_increment_rate);
				pstmt.setString(2, middle_price);
				pstmt.setString(3, middle_zu_price);
				pstmt.setString(4, zu_house_rate);
				pstmt.setString(5, zu_xuqiu);
				pstmt.setString(6, price_review);
				pstmt.setString(7, data_exam);
				pstmt.setString(8, area_num);
				pstmt.setString(9, area_name);
				pstmt.setString(10, touzi_datasource);
				pstmt.setString(11, touzi_date);
				pstmt.setInt(12, Id2);
				int resulttouzi = pstmt.executeUpdate();
				if(resulttouzi == 0){
					flagtouzi = false;
				}
		        //areafamily鍖哄煙瀹跺涵鏋勬垚
				boolean flagfamily = true;
				/*String time_strfamily = "";
				Timestamp tsfamily = new Timestamp(System.currentTimeMillis()); 
				if(family_date==null||"".equals(family_date)){
					family_date = "2015-05-09";
					time_strfamily = family_date+" "+"00:00:00";
				}
		        try {   
		        
		        	tsfamily = Timestamp.valueOf(time_strfamily);   
		            System.out.println(tsfamily);   
		        } catch (Exception e) {   
		            e.printStackTrace();   
		        }  */
				if("".equals(family_date)){
					family_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//
				}
		        String sqlfamily = " update area_family set family_one=?, family_one_rate=?, family_two=?, family_two_rate=?, family_three=?, family_three_rate=?, area_code=?, family_datasource=?, family_date=? where id=?";
				pstmt = con.prepareStatement(sqlfamily);
				pstmt.setString(1, family_one);
				pstmt.setString(2, family_one_rate);
				pstmt.setString(3, family_two);
				pstmt.setString(4, family_two_rate);
				pstmt.setString(5, family_three);
				pstmt.setString(6, family_three_rate);
				pstmt.setString(7, area_num);
				pstmt.setString(8, family_datasource);
				pstmt.setString(9, family_date);
				pstmt.setInt(10, Id3);
				
				
				int result = pstmt.executeUpdate();
				if(result == 0){
					flagfamily = false;
				}
		        //鍖哄煙涓綅鏁版埧浠风紪杈�
				for(MiddlePrice2 item : middlepriceList){
					boolean flagmiddleprice = true;
					int id=item.getId();
					String project_type=item.getProject_type();
					int buy_price = item.getBuy_price();
					int zu_price = item.getZu_price();
					String buy_one_name =item.getBuy_one_name();
					int buy_one_price = item.getBuy_one_price();
					String buy_two_name =item.getBuy_two_name();
					int buy_two_price = item.getBuy_two_price();
					String buy_three_name =item.getBuy_three_name();
					int buy_three_price = item.getBuy_three_price();
					String zu_one_name =item.getZu_one_name();
					int zu_one_price = item.getZu_one_price();
					String zu_two_name =item.getZu_two_name();
					int zu_two_price = item.getZu_two_price();
					String zu_three_name =item.getZu_three_name();
					int zu_three_price = item.getZu_three_price();
					String middle_datasource = item.getMiddle_datasource();
					String  middle_date = item.getMiddle_date();
				/*	String time_str = "";
					if(middle_date != null){
						time_str = middle_date.toString(); 
					}*/
					if("".equals(middle_date)){
						//middle_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//
						middle_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//"2015-05-09 "+"00:00:00";
					}
					String sqlmiddleprice = " update area_middle_price set buy_price=?, zu_price=?, " +
								"buy_one_name=?, buy_one_price=?, buy_two_name=?, buy_two_price=?, " +
								"buy_three_name=?, buy_three_price=?, zu_one_name=?, zu_one_price=?, " +
								"zu_two_name=?, zu_two_price=?, zu_three_name=?, zu_three_price=?, area_quyu=?, " +
								"middle_datasource=?, middle_date=?,project_type=? where id=?";
						pstmt = con.prepareStatement(sqlmiddleprice);
						pstmt.setInt(1, buy_price);
						pstmt.setInt(2, zu_price);
						pstmt.setString(3, buy_one_name);
						pstmt.setInt(4, buy_one_price);
						pstmt.setString(5, buy_two_name);
						pstmt.setInt(6, buy_two_price);
						pstmt.setString(7, buy_three_name);
						pstmt.setInt(8, buy_three_price);
						pstmt.setString(9, zu_one_name);
						pstmt.setInt(10, zu_one_price);
						pstmt.setString(11, zu_two_name);
						pstmt.setInt(12, zu_two_price);
						pstmt.setString(13, zu_three_name);
						pstmt.setInt(14, zu_three_price);
						pstmt.setString(15, area_num);
						pstmt.setString(16, middle_datasource);
						pstmt.setString(17, middle_date);
						pstmt.setString(18, project_type);
						pstmt.setInt(19, id);
						int resultmiddleprice = pstmt.executeUpdate();
						if(resultmiddleprice == 0){
							flagmiddleprice = false;
						}
					
				}
				  //鍖哄煙涓綅鏁版埧浠锋坊鍔�
				for(MiddlePrice2 item : middlepriceList2){
					boolean flagmiddleprice = true;
					int buy_price = item.getBuy_price();
					int zu_price = item.getZu_price();
					String buy_one_name =item.getBuy_one_name();
					int buy_one_price = item.getBuy_one_price();
					String buy_two_name =item.getBuy_two_name();
					int buy_two_price = item.getBuy_two_price();
					String buy_three_name =item.getBuy_three_name();
					int buy_three_price = item.getBuy_three_price();
					String zu_one_name =item.getZu_one_name();
					int zu_one_price = item.getZu_one_price();
					String zu_two_name =item.getZu_two_name();
					int zu_two_price = item.getZu_two_price();
					String zu_three_name =item.getZu_three_name();
					int zu_three_price = item.getZu_three_price();
					String middle_datasource = item.getMiddle_datasource();
					String middle_date = item.getMiddle_date();
					String project_type=item.getProject_type();
					/*String time_str = "";
					if(middle_date != null){
						time_str = middle_date.toString(); 
					}*/
					if("".equals(middle_date)){
						middle_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//
					}
					String sqlmiddleprice = " insert into area_middle_price(buy_price, zu_price, " +
								"buy_one_name, buy_one_price, buy_two_name, buy_two_price, " +
								"buy_three_name, buy_three_price, zu_one_name, zu_one_price, " +
								"zu_two_name, zu_two_price, zu_three_name, zu_three_price, area_quyu, " +
								"middle_datasource, middle_date,project_type) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						pstmt = con.prepareStatement(sqlmiddleprice);
						pstmt.setInt(1, buy_price);
						pstmt.setInt(2, zu_price);
						pstmt.setString(3, buy_one_name);
						pstmt.setInt(4, buy_one_price);
						pstmt.setString(5, buy_two_name);
						pstmt.setInt(6, buy_two_price);
						pstmt.setString(7, buy_three_name);
						pstmt.setInt(8, buy_three_price);
						pstmt.setString(9, zu_one_name);
						pstmt.setInt(10, zu_one_price);
						pstmt.setString(11, zu_two_name);
						pstmt.setInt(12, zu_two_price);
						pstmt.setString(13, zu_three_name);
						pstmt.setInt(14, zu_three_price);
						pstmt.setString(15, area_num);
						pstmt.setString(16, middle_datasource);
						pstmt.setString(17, middle_date);
						pstmt.setString(18, project_type);
						int resultmiddleprice = pstmt.executeUpdate();
						if(resultmiddleprice == 0){
							flagmiddleprice = false;
						}
					
				}
				//鍖哄煙鎴夸环涓綅鏁拌蛋鍔跨紪杈�
				for(AreaMiddle2 item : middletrendList){
					/*boolean resultMiddle = areaInfoDao.addMiddleTrend(item, area_num);*/
					boolean flag = true;
					int id=item.getId();
					int heng = item.getHeng2();
					int zong = item.getZong2();
					int view_shunxu =item.getView_shunxu2();
					String project_type = item.getProject_type2();
					
					String middle_zoushi_datasource = item.getMiddle_zoushi_datasource();
					String middle_zoushi_date = item.getMiddle_zoushi_date();
					/*String time_str = "";
					if(middle_zoushi_date != null){
						time_str = middle_zoushi_date.toString(); 
					}*/
					if("".equals(middle_zoushi_date)){
						middle_zoushi_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//
					}
					
			        
					
						String sqlareamiddle = " update area_middle set heng=?, zong=?, " +
								"view_shunxu=?, project_type=?, area_code=?, middle_zoushi_datasource=?, " +
								"middle_zoushi_date=? where id=?";
						pstmt = con.prepareStatement(sqlareamiddle);
						pstmt.setInt(1, heng);
						pstmt.setInt(2, zong);
						pstmt.setInt(3, view_shunxu);
						pstmt.setString(4, project_type);
						pstmt.setString(5, area_num);
						pstmt.setString(6, middle_zoushi_datasource);
						pstmt.setString(7, middle_zoushi_date);
						pstmt.setInt(8, id);
						
						
						
						int resultareamiddle = pstmt.executeUpdate();
						if(resultareamiddle == 0){
							flag = false;
						}
					
				}
				//鍖哄煙鎴夸环涓綅鏁拌蛋鍔挎坊鍔�
				for(AreaMiddle2 item : middletrendList2){
					/*boolean resultMiddle = areaInfoDao.addMiddleTrend(item, area_num);*/
					boolean flag = true;
					int heng = item.getHeng2();
					int zong = item.getZong2();
					int view_shunxu =item.getView_shunxu2();
					String project_type = item.getProject_type2();
					
					String middle_zoushi_datasource = item.getMiddle_zoushi_datasource();
					String middle_zoushi_date = item.getMiddle_zoushi_date();
					/*String time_str = "";
					if(middle_zoushi_date != null){
						time_str = middle_zoushi_date.toString(); 
					}*/
					if("".equals(middle_zoushi_date)){
						middle_zoushi_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//
					}
					
					
			        
					
						String sqlareamiddle = " insert into area_middle(heng, zong, " +
								"view_shunxu, project_type, area_code, middle_zoushi_datasource, " +
								"middle_zoushi_date) values(?,?,?,?,?,?,?)";
						pstmt = con.prepareStatement(sqlareamiddle);
						pstmt.setInt(1, heng);
						pstmt.setInt(2, zong);
						pstmt.setInt(3, view_shunxu);
						pstmt.setString(4, project_type);
						pstmt.setString(5, area_num);
						pstmt.setString(6, middle_zoushi_datasource);
						pstmt.setString(7, middle_zoushi_date);
						
						
						
						int resultareamiddle = pstmt.executeUpdate();
						if(resultareamiddle == 0){
							flag = false;
						}
					
				}
				//鍖哄煙绉熼噾璧板娍缂栬緫
				for(AreaZujin2 item : zujintrendlistList){
					/*boolean resultZujin = areaInfoDao.addMiddleZujin(item, area_num);*/
					boolean flag = true;
					int id=item.getId();
					int heng = item.getHeng3();
					int zong = item.getZong3();
					int view_shunxu =item.getView_shunxu3();
					String project_type = item.getProject_type3();
					
					String zujin_datasource = item.getZujin_datasource();
					String zujin_dates = item.getZujin_date();
					/*String time_str = "";
					if(zujin_dates != null){
						time_str = zujin_dates.toString(); 
					}*/
					if("".equals(zujin_dates)){
						zujin_dates=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//
					}
					
					
			        
					
						String sqlzuijin = " update  area_zujin set heng=?, zong=?, " +
								"view_shunxu=?, project_type=?, area_code=?, zujin_datasource=?, " +
								"zujin_date=? where id=?";
						pstmt = con.prepareStatement(sqlzuijin);
						pstmt.setInt(1, heng);
						pstmt.setInt(2, zong);
						pstmt.setInt(3, view_shunxu);
						pstmt.setString(4, project_type);
						pstmt.setString(5, area_num);
						pstmt.setString(6, zujin_datasource);
						pstmt.setString(7, zujin_dates);
						pstmt.setInt(8, id);
						
						
						
						int resultzuijin = pstmt.executeUpdate();
						if(resultzuijin == 0){
							flag = false;
						}
					
				}
				//鍖哄煙绉熼噾璧板娍娣诲姞
				for(AreaZujin2 item : zujintrendlistList2){
					/*boolean resultZujin = areaInfoDao.addMiddleZujin(item, area_num);*/
					boolean flag = true;
					int heng = item.getHeng3();
					int zong = item.getZong3();
					int view_shunxu =item.getView_shunxu3();
					String project_type = item.getProject_type3();
					
					String zujin_datasource = item.getZujin_datasource();
					String zujin_dates = item.getZujin_date();
					/*String time_str = "";
					if(zujin_dates != null){
						time_str = zujin_dates.toString(); 
					}*/
					if("".equals(zujin_dates)){
						zujin_dates=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//
					}
					
			        
					
						String sqlzuijin = " insert into area_zujin(heng, zong, " +
								"view_shunxu, project_type, area_code, zujin_datasource, " +
								"zujin_date) values(?,?,?,?,?,?,?)";
						pstmt = con.prepareStatement(sqlzuijin);
						pstmt.setInt(1, heng);
						pstmt.setInt(2, zong);
						pstmt.setInt(3, view_shunxu);
						pstmt.setString(4, project_type);
						pstmt.setString(5, area_num);
						pstmt.setString(6, zujin_datasource);
						pstmt.setString(7, zujin_dates);
						
						
						
						int resultzuijin = pstmt.executeUpdate();
						if(resultzuijin == 0){
							flag = false;
						}
					
				}
				//鍖哄煙绉熼噾鍥炴姤鐜囩紪杈�
				for(AreaZhikong2 item : huibaotrendlistList){
					/*boolean resultZujin = areaInfoDao.addAreaZhikong(item, area_num);*/
					boolean flag = true;
					int id=item.getId();
					int heng = item.getHeng4();
					int zong = item.getZong4();
					int view_shunxu =item.getView_shunxu4();
					String project_type = item.getProject_type4();
					
					String zujin_huibao_datasource = item.getZujin_huibao_datasource();
					String zujin_huibao_date = item.getZujin_huibao_date();
					/*String time_str = "";
					if(zujin_huibao_date != null){
						time_str = zujin_huibao_date.toString(); 
					}*/
					if("".equals(zujin_huibao_date)){
						zujin_huibao_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//
					}
					
					
			        
					
						String sqlhuibao = " update area_kongzhi set heng=?, zong=?, " +
								"view_shunxu=?, project_type=?, area_code=?, zujin_huibao_datasource=?, " +
								"zujin_huibao_date=? where id=?";
						pstmt = con.prepareStatement(sqlhuibao);
						pstmt.setInt(1, heng);
						pstmt.setInt(2, zong);
						pstmt.setInt(3, view_shunxu);
						pstmt.setString(4, project_type);
						pstmt.setString(5, area_num);
						pstmt.setString(6, zujin_huibao_datasource);
						pstmt.setString(7, zujin_huibao_date);
						pstmt.setInt(8, id);
						
						
						
						int resulthuibao = pstmt.executeUpdate();
						if(resulthuibao == 0){
							flag = false;
						}
					
				}
				//鍖哄煙绉熼噾鍥炴姤鐜囨坊鍔�
				for(AreaZhikong2 item : huibaotrendlistList2){
					/*boolean resultZujin = areaInfoDao.addAreaZhikong(item, area_num);*/
					boolean flag = true;
					int heng = item.getHeng4();
					int zong = item.getZong4();
					int view_shunxu =item.getView_shunxu4();
					String project_type = item.getProject_type4();
					
					String zujin_huibao_datasource = item.getZujin_huibao_datasource();
					String zujin_huibao_date = item.getZujin_huibao_date();
					/*String time_str = "";
					if(zujin_huibao_date != null){
						time_str = zujin_huibao_date.toString(); 
					}*/
					if("".equals(zujin_huibao_date)){
						zujin_huibao_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//
					}
					
			        
					
						String sqlhuibao = " insert into area_kongzhi(heng, zong, " +
								"view_shunxu, project_type, area_code, zujin_huibao_datasource, " +
								"zujin_huibao_date) values(?,?,?,?,?,?,?)";
						pstmt = con.prepareStatement(sqlhuibao);
						pstmt.setInt(1, heng);
						pstmt.setInt(2, zong);
						pstmt.setInt(3, view_shunxu);
						pstmt.setString(4, project_type);
						pstmt.setString(5, area_num);
						pstmt.setString(6, zujin_huibao_datasource);
						pstmt.setString(7, zujin_huibao_date);
						
						
						
						int resulthuibao = pstmt.executeUpdate();
						if(resulthuibao == 0){
							flag = false;
						}
					
				}
				//鍖哄煙鐗圭偣缂栬緫
				for(AreaTeDian2 item : tedianlistList){
					/*boolean resultZujin = areaInfoDao.addAreaTeDian(item, area_num);*/
					boolean flag = true;
					int id=item.getId();
					String area_character = item.getArea_character();
					int view_shunxu = item.getView_shunxu();
					
					
					String data_source = item.getData_source();
					String update_time = item.getUpdate_time();
					/*String time_str = "";
					if(update_time != null){
						time_str = update_time.toString(); 
					}*/
					if("".equals(update_time)){
						update_time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//
					}
					
			        
					
						String sqltedian = " update area_features set area_character=?, view_shunxu=?, " +
								"area_code=?, data_source=?, update_time=? where id=?";
						pstmt = con.prepareStatement(sqltedian);
						pstmt.setString(1, area_character);
						pstmt.setInt(2, view_shunxu);
						
						pstmt.setString(3, area_num);
						
						pstmt.setString(4, data_source);
						pstmt.setString(5, update_time);
						pstmt.setInt(6, id);
						
						
						
						int resulttedian = pstmt.executeUpdate();
						if(resulttedian == 0){
							flag = false;
						}
					
				}
				//鍖哄煙鐗圭偣娣诲姞
				for(AreaTeDian2 item : tedianlistList2){
					/*boolean resultZujin = areaInfoDao.addAreaTeDian(item, area_num);*/
					boolean flag = true;
					String area_character = item.getArea_character();
					int view_shunxu = item.getView_shunxu();
					
					
					String data_source = item.getData_source();
					String update_time = item.getUpdate_time();
					/*String time_str = "";
					if(update_time != null){
						time_str = update_time.toString(); 
					}*/
					if("".equals(update_time)){
						update_time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//
					}
					
			        
					
						String sqltedian = " insert into area_features(area_character, view_shunxu, " +
								"area_code, data_source, update_time ) values(?,?,?,?,?)";
						pstmt = con.prepareStatement(sqltedian);
						pstmt.setString(1, area_character);
						pstmt.setInt(2, view_shunxu);
						
						pstmt.setString(3, area_num);
						
						pstmt.setString(4, data_source);
						pstmt.setString(5, update_time);
						
						
						
						int resulttedian = pstmt.executeUpdate();
						if(resulttedian == 0){
							flag = false;
						}
					
				}
				//鍖哄煙浜哄彛鍒嗗竷
				for(AreaPeopleInfo2 item : peoplelistList){
					/*boolean resultZujin = areaInfoDao.addAreaPeople(item, area_num);*/
					boolean flag = true;
					int id=item.getId();
					String column1 = item.getColumn1();
					String column2 = item.getColumn2();
					String column3 = item.getColumn3();
					int view_shunxu = item.getView_shunxu_people();
					String people_datasource = item.getPeople_datasource();
					String people_date = item.getPeople_date();
					/*String time_str = "";
					if(people_date != null){
						time_str = people_date.toString(); 
					}*/
					if("".equals(people_date)){
						people_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//
					}
						String sqlpeople = " update area_people set column1=?, column2=?, " +
								"column3=?, view_shunxu=?, area_code=?, people_datasource=?, people_date=? where id=?";
						pstmt = con.prepareStatement(sqlpeople);
						pstmt.setString(1, column1);
						pstmt.setString(2, column2);
						pstmt.setString(3, column3);
						pstmt.setInt(4, view_shunxu);
			            pstmt.setString(5, area_num);
						pstmt.setString(6, people_datasource);
						pstmt.setString(7, people_date);
						pstmt.setInt(8, id);
						int resultpeople = pstmt.executeUpdate();
						if(resultpeople == 0){
							flag = false;
						}
					
				}
				//鍖哄煙浜哄彛鍒嗗竷娣诲姞
				for(AreaPeopleInfo2 item : peoplelistList2){
					/*boolean resultZujin = areaInfoDao.addAreaPeople(item, area_num);*/
					boolean flag = true;
					String column1 = item.getColumn1();
					String column2 = item.getColumn2();
					String column3 = item.getColumn3();
					int view_shunxu = item.getView_shunxu_people();
					String people_datasource = item.getPeople_datasource();
					String people_date = item.getPeople_date();
					/*String time_str = "";
					if(people_date != null){
						time_str = people_date.toString(); 
					}*/
					if("".equals(people_date)){
						people_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//
					}
						String sqlpeople = " insert into area_people(column1, column2, " +
								"column3, view_shunxu, area_code, people_datasource, people_date) values(?,?,?,?,?,?,?)";
						pstmt = con.prepareStatement(sqlpeople);
						pstmt.setString(1, column1);
						pstmt.setString(2, column2);
						pstmt.setString(3, column3);
						pstmt.setInt(4, view_shunxu);
			            pstmt.setString(5, area_num);
						pstmt.setString(6, people_datasource);
						pstmt.setString(7, people_date);
						int resultpeople = pstmt.executeUpdate();
						if(resultpeople == 0){
							flag = false;
						}
					
				}
				//鎺ㄨ崘缁忕邯浜�
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
					String sqlbroker = " update area_recommend_broker set broker_code1=?, broker_code2=?, recommend_num_3=? where area_code=?";
					pstmt = con.prepareStatement(sqlbroker);
					pstmt.setString(1, broker_code1);
					pstmt.setString(2, broker_code2);
					pstmt.setString(3, broker_code3);
					pstmt.setString(4, area_num);
					
					int resultbroker = pstmt.executeUpdate();
					if(resultbroker == 0){
						flagbroker = false;
					}
				
				//鎺ㄨ崘椤圭洰
				boolean flagproject = true;
				
				String recommend_num_1 = "";
				String recommend_num_2 = "";
				String recommend_num_3 = "";
				
				if(projectlistList.size()==1){
					String name = projectlistList.get(0);
					recommend_num_1 = findProByName(name);
				}
				else if(projectlistList.size()==2){
					String name1 = projectlistList.get(0);
					String name2 = projectlistList.get(1);
					recommend_num_1 = findProByName(name1);
					recommend_num_2 = findProByName(name2);
					
				}
				else if(projectlistList.size()>=3){
					String name1 = projectlistList.get(0);
					String name2 = projectlistList.get(1);
					String name3 = projectlistList.get(2);
					recommend_num_1 = findProByName(name1);
					recommend_num_2 = findProByName(name2);
					recommend_num_3 = findProByName(name3);
				}
				
					/*String sqlproject = " insert into recommend_project(recommend_num_1, recommend_num_2, " +
							"recommend_num_3, area_code) values(?,?,?,?)";*/
					String sqlproject = " update recommend_project set recommend_num_1=?, recommend_num_2=?, recommend_num_3=? where area_code=?";
					pstmt = con.prepareStatement(sqlproject);
					pstmt.setString(1, recommend_num_1);
					pstmt.setString(2, recommend_num_2);
					pstmt.setString(3, recommend_num_3);
					pstmt.setString(4, area_num);
					
					int resultproject = pstmt.executeUpdate();
					if(resultproject == 0){
						flagproject = false;
					}
				
				//鏂伴椈鎶ラ亾
				boolean flagnews = true;
				String reco_news_num_1 = "";
				String reco_news_num_2 = "";
				String reco_news_num_3 = "";
				List<String> resultList = new ArrayList<String>();
				for(String name : newslistList){
					String num = findBokeByName(name);
					resultList.add(num);
				}
				for(String name1 : list){
					String num1 = findZhiYeByName(name1);
					resultList.add(num1);
				}
				
				if(resultList.size()==1){
					reco_news_num_1 = resultList.get(0);
				}
				else if(resultList.size()==2){
					reco_news_num_1 = resultList.get(0);
					reco_news_num_2 = resultList.get(1);
					
					
				}
				else if(resultList.size()>=3){
					reco_news_num_1 = resultList.get(0);
					reco_news_num_2 = resultList.get(1);
					reco_news_num_3 = resultList.get(2);
				}
				
					/*String sqlnews = " insert into recommend_news(reco_news_num_1, reco_news_num_2, " +
							"reco_news_num_3, area_code) values(?,?,?,?)";*/
					String sqlnews = " update recommend_news set reco_news_num_1=?, reco_news_num_2=?, reco_news_num_3=? where area_code=?";
					pstmt = con.prepareStatement(sqlnews);
					pstmt.setString(1, reco_news_num_1);
					pstmt.setString(2, reco_news_num_2);
					pstmt.setString(3, reco_news_num_3);
					pstmt.setString(4, area_num);
					
					int resultnews = pstmt.executeUpdate();
					if(resultnews == 0){
						flagnews = false;
					}
					//middlepriceListdelete,middletrendListdelete,zujintrendlistListdelete
					//,huibaotrendlistListdelete,tedianlistListdelete,peoplelistListdelete
					//delete from project_desc_image
					String sqldeletemiddleprice = "delete from area_middle_price where id= ?";
					pstmt = con.prepareStatement(sqldeletemiddleprice);
					for(int i=0;i<middlepriceListdelete.size();i++){
						pstmt.setInt(1, middlepriceListdelete.get(i).getId());
						pstmt.addBatch();
					}
					int[] resultmiddlepricedelete=pstmt.executeBatch();
					System.out.println("resultmiddlepricedelete.length:"+resultmiddlepricedelete.length);
					for(int i=0;i<resultmiddlepricedelete.length;i++){
						System.out.println("resultmiddlepricedelete"+i+":"+resultmiddlepricedelete[i]);
					}
					
					String sqldeletemiddletrend = "delete from area_middle where id= ?";
					pstmt = con.prepareStatement(sqldeletemiddletrend);
					for(int i=0;i<middletrendListdelete.size();i++){
						pstmt.setInt(1, middletrendListdelete.get(i).getId());
						pstmt.addBatch();
					}
					int[] resultmiddletrenddelete=pstmt.executeBatch();
					System.out.println("resultmiddletrenddelete.length:"+resultmiddletrenddelete.length);
					for(int i=0;i<resultmiddletrenddelete.length;i++){
						System.out.println("resultmiddletrenddelete"+i+":"+resultmiddletrenddelete[i]);
					}
				
					
					String sqldeletezujin = "delete from area_zujin where id= ?";
					pstmt = con.prepareStatement(sqldeletezujin);
					for(int i=0;i<zujintrendlistListdelete.size();i++){
						pstmt.setInt(1, zujintrendlistListdelete.get(i).getId());
						pstmt.addBatch();
					}
					int[] resultzujindelete=pstmt.executeBatch();
					System.out.println("resultzujindelete.length:"+resultzujindelete.length);
					for(int i=0;i<resultzujindelete.length;i++){
						System.out.println("resultzujindelete"+i+":"+resultzujindelete[i]);
					}
					

					String sqldeletehuibao = "delete from area_kongzhi where id= ?";
					pstmt = con.prepareStatement(sqldeletehuibao);
					for(int i=0;i<huibaotrendlistListdelete.size();i++){
						pstmt.setInt(1, huibaotrendlistListdelete.get(i).getId());
						pstmt.addBatch();
					}
					int[] resulthuibaodelete=pstmt.executeBatch();
					System.out.println("resulthuibaodelete.length:"+resulthuibaodelete.length);
					for(int i=0;i<resulthuibaodelete.length;i++){
						System.out.println("resulthuibaodelete"+i+":"+resulthuibaodelete[i]);
					}
					
					String sqldeletetedian = "delete from area_features where id= ?";
					pstmt = con.prepareStatement(sqldeletetedian);
					for(int i=0;i<tedianlistListdelete.size();i++){
						pstmt.setInt(1, tedianlistListdelete.get(i).getId());
						pstmt.addBatch();
					}
					int[] resulttediandelete=pstmt.executeBatch();
					System.out.println("resulttediandelete.length:"+resulttediandelete.length);
					for(int i=0;i<resulttediandelete.length;i++){
						System.out.println("resulttediandelete"+i+":"+resulttediandelete[i]);
					}
					

					String sqldeletepeople = "delete from area_people where id= ?";
					pstmt = con.prepareStatement(sqldeletepeople);
					for(int i=0;i<peoplelistListdelete.size();i++){
						pstmt.setInt(1, peoplelistListdelete.get(i).getId());
						pstmt.addBatch();
					}
					int[] resultpeopledelete=pstmt.executeBatch();
					System.out.println("resultpeopledelete.length:"+resultpeopledelete.length);
					for(int i=0;i<resultpeopledelete.length;i++){
						System.out.println("resultpeopledelete"+i+":"+resultpeopledelete[i]);
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
	//Area缂栬緫妯″潡鐨勬煡璇reaInfo淇℃伅
	public AreaInfo getAreaInfoBackEnd(int id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		AreaInfo areaInfo = new AreaInfo();
		try {
			String sql = " SELECT * from area_info where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				areaInfo.setArea_city(rs.getString("area_city"));
				areaInfo.setArea_name(rs.getString("area_name"));
				areaInfo.setArea_nation(rs.getString("area_nation"));
				areaInfo.setArea_num(rs.getString("area_num"));
				areaInfo.setArea_zhou(rs.getString("area_zhou"));
				//areaInfo.setHouse_pro_id(rs.getInt("area_postcode"));
				areaInfo.setArea_postcode(rs.getString("area_postcode"));
				areaInfo.setId(id);
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

		return areaInfo;
	}
	
	
	public AreaInfo getAreaInfo(int id){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		AreaInfo areaInfo = new AreaInfo();
		try {
			String sql = " SELECT * from area_info where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				areaInfo.setArea_city(rs.getString("area_city"));
				areaInfo.setArea_name(rs.getString("area_name"));
				areaInfo.setArea_nation(rs.getString("area_nation"));
				areaInfo.setArea_num(rs.getString("area_num"));
				areaInfo.setArea_zhou(rs.getString("area_zhou"));
				areaInfo.setHouse_pro_id(rs.getInt("house_pro_id"));
				areaInfo.setArea_type(rs.getString("area_type"));
				
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
		return areaInfo;
	}
	
	public AreaInfo getAreaInfoByNum(String area_num){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		AreaInfo areaInfo = new AreaInfo();
		try {
			String sql = " SELECT * from area_info where area_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_num);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				areaInfo.setArea_city(rs.getString("area_city"));
				areaInfo.setArea_name(rs.getString("area_name"));
				areaInfo.setArea_nation(rs.getString("area_nation"));
				areaInfo.setId(rs.getInt("id"));
				areaInfo.setArea_zhou(rs.getString("area_zhou"));
				areaInfo.setHouse_pro_id(rs.getInt("house_pro_id"));
				areaInfo.setArea_type(rs.getString("area_type"));
				
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
		return areaInfo;
	}
	
	public AreaInfo getAreaInfo(String area_name){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		AreaInfo areaInfo = new AreaInfo();
		try {
			String sql = " SELECT * from area_info where area_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_name);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				areaInfo.setArea_city(rs.getString("area_city"));
				areaInfo.setArea_num(rs.getString("area_num"));
				areaInfo.setArea_nation(rs.getString("area_nation"));
				areaInfo.setId(rs.getInt("id"));
				areaInfo.setArea_zhou(rs.getString("area_zhou"));
				areaInfo.setHouse_pro_id(rs.getInt("house_pro_id"));
				areaInfo.setArea_type(rs.getString("area_type"));
				
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
			            stmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return areaInfo;
	}
	
	public boolean addAreaInfo(String area_num,String area_name,String area_city,String area_zhou,String area_nation,String area_postcode){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		boolean flag = true;
		try{
			String sql = " insert into area_info(area_num, area_name, area_city, area_zhou, area_nation, area_postcode) values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_num);
			pstmt.setString(2, area_name);
			pstmt.setString(3, area_city);
			pstmt.setString(4, area_zhou);
			pstmt.setString(5, area_nation);
			pstmt.setString(6, area_postcode);
			
			int result = pstmt.executeUpdate();
			if(result == 0){
				flag = false;
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
		return flag;
	}
	
	public boolean addTouziData(String touzi_datasource, String touzi_date, String middle_price, String middle_zu_price, String price_review, String year_increment_rate, String zu_house_rate, String zu_xuqiu,String data_exam, String area_num, String area_name){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		boolean flag = true;
		String time_str = "";
		Timestamp ts = new Timestamp(System.currentTimeMillis()); 
		if(touzi_date==null||"".equals(touzi_date)){
			touzi_date = "2015-05-09";
		}
        try {   
        	time_str = touzi_date+" "+"00:00:00";
            ts = Timestamp.valueOf(time_str);   
            System.out.println(ts);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
		
		try{
			String sql = " insert into investment_data(year_increment_rate, middle_price, middle_zu_price, zu_house_rate, zu_xuqiu, price_review, data_exam, area_num, area_name, touzi_datasource, touzi_date) values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, year_increment_rate);
			pstmt.setString(2, middle_price);
			pstmt.setString(3, middle_zu_price);
			pstmt.setString(4, zu_house_rate);
			pstmt.setString(5, zu_xuqiu);
			pstmt.setString(6, price_review);
			pstmt.setString(7, data_exam);
			pstmt.setString(8, area_num);
			pstmt.setString(9, area_name);
			pstmt.setString(10, touzi_datasource);
			pstmt.setString(11, time_str);
			int result = pstmt.executeUpdate();
			if(result == 0){
				flag = false;
			}
		}catch (Exception e) {
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

	
	public boolean addAreaFamily(String area_code, String family_one, String family_one_rate, String family_two, String family_two_rate, String family_three, String family_three_rate, String family_datasource, String family_date){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		boolean flag = true;
		String time_str = "";
		Timestamp ts = new Timestamp(System.currentTimeMillis()); 
		if(family_date==null||"".equals(family_date)){
			family_date = "2015-05-09";
		}
        try {   
        	time_str = family_date+" "+"00:00:00";
            ts = Timestamp.valueOf(time_str);   
            System.out.println(ts);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
        
		try{
			String sql = " insert into area_family(family_one, family_one_rate, family_two, family_two_rate, family_three, family_three_rate, area_code, family_datasource, family_date) values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, family_one);
			pstmt.setString(2, family_one_rate);
			pstmt.setString(3, family_two);
			pstmt.setString(4, family_two_rate);
			pstmt.setString(5, family_three);
			pstmt.setString(6, family_three_rate);
			pstmt.setString(7, area_code);
			pstmt.setString(8, family_datasource);
			pstmt.setString(9, family_date);
			
			
			int result = pstmt.executeUpdate();
			if(result == 0){
				flag = false;
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
		return flag;
	}
	
	public boolean addMiddlePrice(MiddlePrice2 obj, String area_quyu){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		boolean flag = true;
		int buy_price = obj.getBuy_price();
		int zu_price = obj.getZu_price();
		String buy_one_name =obj.getBuy_one_name();
		int buy_one_price = obj.getBuy_one_price();
		String buy_two_name =obj.getBuy_two_name();
		int buy_two_price = obj.getBuy_two_price();
		String buy_three_name =obj.getBuy_three_name();
		int buy_three_price = obj.getBuy_three_price();
		String zu_one_name =obj.getZu_one_name();
		int zu_one_price = obj.getZu_one_price();
		String zu_two_name =obj.getZu_two_name();
		int zu_two_price = obj.getZu_two_price();
		String zu_three_name =obj.getZu_three_name();
		int zu_three_price = obj.getZu_three_price();
		String middle_datasource = obj.getMiddle_datasource();
		String middle_date = obj.getMiddle_date();
		String time_str = "";
		if(middle_date != null){
			time_str = middle_date.toString(); 
		}
		
        
		try{
			String sql = " insert into area_middle_price(buy_price, zu_price, " +
					"buy_one_name, buy_one_price, buy_two_name, buy_two_price, " +
					"buy_three_name, buy_three_price, zu_one_name, zu_one_price, " +
					"zu_two_name, zu_two_price, zu_three_name, zu_three_price, area_quyu, " +
					"middle_datasource, middle_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, buy_price);
			pstmt.setInt(2, zu_price);
			pstmt.setString(3, buy_one_name);
			pstmt.setInt(4, buy_one_price);
			pstmt.setString(5, buy_two_name);
			pstmt.setInt(6, buy_two_price);
			pstmt.setString(7, buy_three_name);
			pstmt.setInt(8, buy_three_price);
			pstmt.setString(9, zu_one_name);
			pstmt.setInt(10, zu_one_price);
			pstmt.setString(11, zu_two_name);
			pstmt.setInt(12, zu_two_price);
			pstmt.setString(13, zu_three_name);
			pstmt.setInt(14, zu_three_price);
			pstmt.setString(15, area_quyu);
			pstmt.setString(16, middle_datasource);
			pstmt.setString(17, time_str);
			
			
			
			int result = pstmt.executeUpdate();
			if(result == 0){
				flag = false;
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
		return flag;
	}
	
	
	public boolean addMiddleTrend(AreaMiddle2 obj, String area_code){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean flag = true;
		int heng = obj.getHeng2();
		int zong = obj.getZong2();
		int view_shunxu =obj.getView_shunxu2();
		String project_type = obj.getProject_type2();
		
		String middle_zoushi_datasource = obj.getMiddle_zoushi_datasource();
		String middle_zoushi_date = obj.getMiddle_zoushi_date();
		String time_str = "";
		if(middle_zoushi_date != null){
			time_str = middle_zoushi_date.toString(); 
		}
		
        
		try{
			String sql = " insert into area_middle(heng, zong, " +
					"view_shunxu, project_type, area_code, middle_zoushi_datasource, " +
					"middle_zoushi_date) values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, project_type);
			pstmt.setString(5, area_code);
			pstmt.setString(6, middle_zoushi_datasource);
			pstmt.setString(7, time_str);
			int result = pstmt.executeUpdate();
			if(result == 0){
				flag = false;
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
		return flag;
	}
	
	public boolean addMiddleZujin(AreaZujin2 obj, String area_code){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean flag = true;
		int heng = obj.getHeng3();
		int zong = obj.getZong3();
		int view_shunxu =obj.getView_shunxu3();
		String project_type = obj.getProject_type3();
		
		String zujin_datasource = obj.getZujin_datasource();
		String zujin_dates = obj.getZujin_date();
		String time_str = "";
		if(zujin_dates != null){
			time_str = zujin_dates.toString(); 
		}
		
        
		try{
			String sql = " insert into area_zujin(heng, zong, " +
					"view_shunxu, project_type, area_code, zujin_datasource, " +
					"zujin_date) values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, project_type);
			pstmt.setString(5, area_code);
			pstmt.setString(6, zujin_datasource);
			pstmt.setString(7, time_str);
			int result = pstmt.executeUpdate();
			if(result == 0){
				flag = false;
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
		return flag;
	}
	
	public boolean addAreaZhikong(AreaZhikong2 obj, String area_code){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean flag = true;
		int heng = obj.getHeng4();
		int zong = obj.getZong4();
		int view_shunxu =obj.getView_shunxu4();
		String project_type = obj.getProject_type4();
		
		String zujin_huibao_datasource = obj.getZujin_huibao_datasource();
		String zujin_huibao_date = obj.getZujin_huibao_date();
		String time_str = "";
		if(zujin_huibao_date != null){
			time_str = zujin_huibao_date.toString(); 
		}
		
        
		try{
			String sql = " insert into area_kongzhi(heng, zong, " +
					"view_shunxu, project_type, area_code, zujin_huibao_datasource, " +
					"zujin_huibao_date) values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, project_type);
			pstmt.setString(5, area_code);
			pstmt.setString(6, zujin_huibao_datasource);
			pstmt.setString(7, time_str);
			int result = pstmt.executeUpdate();
			if(result == 0){
				flag = false;
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
		return flag;
	}
	
	
	public boolean addAreaTeDian(AreaTeDian2 obj, String area_code){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean flag = true;
		String area_character = obj.getArea_character();
		int view_shunxu = obj.getView_shunxu();
		String data_source = obj.getData_source();
		String update_time = obj.getUpdate_time();
		String time_str = "";
		if(update_time != null){
			time_str = update_time.toString(); 
		}
		
        
		try{
			String sql = " insert into area_features(area_character, view_shunxu, " +
					"area_code, data_source, update_time ) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_character);
			pstmt.setInt(2, view_shunxu);
			
			pstmt.setString(3, area_code);
			pstmt.setString(4, data_source);
			pstmt.setString(5, time_str);
			int result = pstmt.executeUpdate();
			if(result == 0){
				flag = false;
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
		return flag;
	}
	
	
	public boolean addAreaPeople(AreaPeopleInfo2 obj, String area_code){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean flag = true;
		String column1 = obj.getColumn1();
		String column2 = obj.getColumn2();
		String column3 = obj.getColumn3();
		int view_shunxu = obj.getView_shunxu_people();
		String people_datasource = obj.getPeople_datasource();
		String people_date = obj.getPeople_date();
		String time_str = "";
		if(people_date != null){
			time_str = people_date.toString(); 
		}
		
        
		try{
			String sql = " insert into area_people(column1, column2, " +
					"column3, view_shunxu, area_code, people_datasource, people_date) values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, column1);
			pstmt.setString(2, column2);
			pstmt.setString(3, column3);
			pstmt.setInt(4, view_shunxu);
            pstmt.setString(5, area_code);
			pstmt.setString(6, people_datasource);
			pstmt.setString(7, time_str);
			int result = pstmt.executeUpdate();
			if(result == 0){
				flag = false;
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
		return flag;
	}
	
	public boolean addAreaTuijianBroker(List<BrokerInfo> brokerlistList, String area_code){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean flag = true;
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
		try{
			String sql = " insert into area_recommend_broker(broker_code1, broker_code2, " +
					"broker_code3, area_code) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, broker_code1);
			pstmt.setString(2, broker_code2);
			pstmt.setString(3, broker_code3);
			pstmt.setString(4, area_code);
			
			int result = pstmt.executeUpdate();
			if(result == 0){
				flag = false;
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
		return flag;
	}
	
	
	public boolean addAreaTuijianPro(List<String> projectlistList, String area_code){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		boolean flag = true;
		
		String recommend_num_1 = "";
		String recommend_num_2 = "";
		String recommend_num_3 = "";
		
		if(projectlistList.size()==1){
			String name = projectlistList.get(0);
			recommend_num_1 = findProByName(name);
		}
		else if(projectlistList.size()==2){
			String name1 = projectlistList.get(0);
			String name2 = projectlistList.get(1);
			recommend_num_1 = findProByName(name1);
			recommend_num_2 = findProByName(name2);
			
		}
		else if(projectlistList.size()>=3){
			String name1 = projectlistList.get(0);
			String name2 = projectlistList.get(1);
			String name3 = projectlistList.get(2);
			recommend_num_1 = findProByName(name1);
			recommend_num_2 = findProByName(name2);
			recommend_num_3 = findProByName(name3);
		}
		try{
			String sql = " insert into recommend_project(recommend_num_1, recommend_num_2, " +
					"recommend_num_3, area_code) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, recommend_num_1);
			pstmt.setString(2, recommend_num_2);
			pstmt.setString(3, recommend_num_3);
			pstmt.setString(4, area_code);
			
			int result = pstmt.executeUpdate();
			if(result == 0){
				flag = false;
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

		return flag;
	}
	
	public boolean addAreaTuijianBoke(List<String> newslistList, List<String> list, String area_code){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		boolean flag = true;
		String reco_news_num_1 = "";
		String reco_news_num_2 = "";
		String reco_news_num_3 = "";
		List<String> resultList = new ArrayList<String>();
		for(String name : newslistList){
			String num = findBokeByName(name);
			resultList.add(num);
		}
		for(String name1 : list){
			String num1 = findZhiYeByName(name1);
			resultList.add(num1);
		}
		
		if(resultList.size()==1){
			reco_news_num_1 = resultList.get(0);
		}
		else if(resultList.size()==2){
			reco_news_num_1 = resultList.get(0);
			reco_news_num_2 = resultList.get(1);
			
			
		}
		else if(resultList.size()>=3){
			reco_news_num_1 = resultList.get(0);
			reco_news_num_2 = resultList.get(1);
			reco_news_num_3 = resultList.get(2);
		}
		try{
			String sql = " insert into recommend_news(reco_news_num_1, reco_news_num_2, " +
					"reco_news_num_3, area_code) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reco_news_num_1);
			pstmt.setString(2, reco_news_num_2);
			pstmt.setString(3, reco_news_num_3);
			pstmt.setString(4, area_code);
			
			int result = pstmt.executeUpdate();
			if(result == 0){
				flag = false;
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
		return flag;
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
	
	
	public String findProByName(String Name){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String num = null;
		try{
			String sql = "select * from house_project where project_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Name);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				num = rs.getString("project_num");
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
		return num;
	}
	
	public String findBokeByName(String Name){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String num = null;
		try{
			String sql = "select * from news_boke where news_title=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Name);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				num = rs.getString("news_num");
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
		return num;
	}
	
	public String findZhiYeByName(String Name){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String num = null;
		try{
			String sql = "select * from zhiye_zhidao where title=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Name);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				num = rs.getString("zhiye_num");
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
		return num;
	}
	
}
