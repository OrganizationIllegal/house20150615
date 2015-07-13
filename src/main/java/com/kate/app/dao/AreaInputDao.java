package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.NewsBoke;
import com.kate.app.model.ZhiYeZhiDao;

@Repository 
public class AreaInputDao extends BaseDao {
	//得到经纪人的编号及姓名
	public List<String> getBrokerName(){
		List<String> brokerNameSet=new ArrayList<String>();
		try {
			String sql ="select * from broker_info";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String brokerName=rs.getString("broker_name");
				brokerNameSet.add(brokerName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brokerNameSet;
	}
	//获取所有经纪人的信息列表
	public List<BrokerInfo> getBrokers(){
		List<BrokerInfo> brokerSet=new ArrayList<BrokerInfo>();
		try {
			String sql ="select * from broker_info order by broker_name asc";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				BrokerInfo bf=new BrokerInfo();
				bf.setId(rs.getInt("id"));
				bf.setBroker_name(rs.getString("broker_name"));
				brokerSet.add(bf);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brokerSet;
	}
	//获取全部经纪人的信息
	public BrokerInfo getBrokerInfo(String id){
		BrokerInfo broker=new BrokerInfo();
		try {
			String sql ="select * from broker_info where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				broker.setId(rs.getInt("id"));
				broker.setBroker_name(rs.getString("broker_name"));
				broker.setBroker_type(rs.getString("broker_type"));
				broker.setBroker_language(rs.getString("broker_language"));
				broker.setBroker_region(rs.getString("broker_region"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return broker;
	}
	//获取项目的编号和名字列表
	public List<HouseProject> getProjectInfos(){
		List<HouseProject> projectSet=new ArrayList<HouseProject>();
		try {
			String sql ="select * from house_project order by project_name asc";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				HouseProject hp=new HouseProject();
				hp.setId(rs.getInt("id"));
				hp.setProject_name(rs.getString("project_name"));
				hp.setProject_area(rs.getString("project_area"));
				hp.setProject_price_qi(rs.getString("project_price_qi"));
				hp.setProject_type(rs.getString("project_type"));
				projectSet.add(hp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projectSet;
	}
	//获取职业指导所有的信息list
	public List<ZhiYeZhiDao> getZhiyezhidaos(){
		List<ZhiYeZhiDao> projectSet=new ArrayList<ZhiYeZhiDao>();
		try {
			String sql ="select * from zhiye_zhidao";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				ZhiYeZhiDao hp=new ZhiYeZhiDao();
				hp.setId(rs.getInt("id"));
				hp.setTitle(rs.getString("title"));
				hp.setFabu_people(rs.getString("fabu_people"));
				projectSet.add(hp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projectSet;
	}
	//获取指定id的NewsBoke的信息
	public NewsBoke getNewsBokeInfo(String id){
		NewsBoke hp=new NewsBoke();
		try {
			String sql ="select * from news_boke where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				hp.setId(rs.getInt("id"));
				hp.setNews_title(rs.getString("news_title"));
				hp.setNews_people(rs.getString("news_people"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hp;
	}
	//获取指定id的置业指导的信息
	public ZhiYeZhiDao getZhiYeInfo(String id){
		ZhiYeZhiDao hp=new ZhiYeZhiDao();
		try {
			String sql ="select * from zhiye_zhidao where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				hp.setId(rs.getInt("id"));
				hp.setTitle(rs.getString("title"));
				hp.setFabu_people(rs.getString("fabu_people"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hp;
	}
	//获取新闻博客所有的信息list
		public List<NewsBoke> getNewsbokes(){
			List<NewsBoke> projectSet=new ArrayList<NewsBoke>();
			try {
				String sql ="select * from news_boke";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					NewsBoke hp=new NewsBoke();
					hp.setId(rs.getInt("id"));
					hp.setNews_title(rs.getString("news_title"));
					hp.setNews_people(rs.getString("news_people"));
					projectSet.add(hp);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return projectSet;
		}
	//获取指定id项目的的信息
	public HouseProject getProjectInfo(String id){
		HouseProject hp=new HouseProject();
		try {
			String sql ="select * from house_project where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				hp.setId(rs.getInt("id"));
				hp.setProject_name(rs.getString("project_name"));
				hp.setProject_area(rs.getString("project_area"));
				hp.setProject_price_qi(rs.getString("project_price_qi"));
				hp.setProject_type(rs.getString("project_type"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hp;
	}
	//得到项目的编号及名称
		public List<String> getProjectName(){
			List<String> projectNameSet=new ArrayList<String>();
			try {
				String sql ="select * from house_project";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					String projectName=rs.getString("project_name");
					projectNameSet.add(projectName);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return projectNameSet;
		}
	//区域列表
	public JSONArray selectAreaList(){
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = " select * from area_info";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("area_num", rs.getString("area_num"));
				obj.put("area_name", rs.getString("area_name"));
				obj.put("area_city", rs.getString("area_city"));
				obj.put("area_zhou", rs.getString("area_zhou"));
				obj.put("area_nation", rs.getString("area_nation"));
				obj.put("area_postcode", rs.getString("area_postcode"));
				jsonArray.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonArray;
	} 
	//添加经纪人服务区域
	public int InsertServiceArea(String  broker_num,String area_code,int view_shunxu){
		int exeResult=0;
		try {
			String sql = "insert into broker_service_area(broker_num,area_code,view_shunxu) values(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, broker_num);
			pstmt.setString(2, area_code);
			pstmt.setInt(3, view_shunxu);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
	}  
	
	//添加经纪人擅长类型
		public int InsertInteType(String  broker_num,String interested_num,int view_shunxu){
			int exeResult=0;
			try {
				String sql = "insert into broker_interested_type(broker_num,interested_num,view_shunxu) values(?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, broker_num);
				pstmt.setString(2, interested_num);
				pstmt.setInt(3, view_shunxu);
				exeResult = pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return exeResult;
		}  
		//添加擅长类型
				public int InsertInteType2(String  type_num,String type_name,String type_image){
					int exeResult=0;
					try {
						String sql = "insert into interest_type(type_num,type_name,type_image) values(?,?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, type_num);
						pstmt.setString(2, type_name);
						pstmt.setString(3, type_image);
						exeResult = pstmt.executeUpdate();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return exeResult;
				}  
		 //添加经纪人信息	
				public int insertBrokerInfo(String broker_name, String broker_language, String broker_region, String broker_img,int broker_experience, String broker_num, String broker_type, String broker_zizhi, String introduction) throws SQLException{
					int exeResult=0;
					try{
						String sql = " insert into broker_info(broker_name, broker_language, broker_region, broker_img, broker_experience, broker_num, broker_type, broker_zizhi, introduction) values(?,?,?,?,?,?,?,?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, broker_name);
						pstmt.setString(2, broker_language);
						pstmt.setString(3, broker_region);
						pstmt.setString(4, broker_img);
						pstmt.setInt(5, broker_experience);
						pstmt.setString(6, broker_num);
						pstmt.setString(7, broker_type);
						pstmt.setString(8, broker_zizhi);
						pstmt.setString(9, introduction);
						exeResult = pstmt.executeUpdate();
					}catch (Exception e) {
			            e.printStackTrace();
			        }
					return exeResult;
			        
				}
				
				//添加区域中位数房价	
				public int insertMiddlePrice(int buy_price,int zu_price,String buy_one_name,int buy_one_price,String buy_two_name,int buy_two_price,String buy_three_name,int buy_three_price,String zu_one_name,int zu_one_price,String zu_two_name,int zu_two_price,String zu_three_name,int zu_three_price,String project_type,String area_quyu) throws SQLException{
					int exeResult=0;
					try{
						String sql = " insert into area_middle_price(buy_price, zu_price, buy_one_name, buy_one_price, buy_two_name, buy_two_price, buy_three_name, buy_three_price, zu_one_name,zu_one_price,zu_two_name,zu_two_price,zu_three_name,zu_three_price,project_type,area_quyu) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql);
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
						pstmt.setString(15, project_type);
						pstmt.setString(16, area_quyu);
						exeResult = pstmt.executeUpdate();
					}catch (Exception e) {
			            e.printStackTrace();
			        }
					return exeResult;
			        
				}
				
				//添加房价中位数走势
				public int insertMidTrend(String  heng,int zong,int view_shunxu,String project_type,String area_code){
					int exeResult=0;
					try {
						String sql = "insert into area_middle(heng,zong,view_shunxu,project_type,area_code) values(?,?,?,?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, heng);
						pstmt.setInt(2, zong);
						pstmt.setInt(3, view_shunxu);
						pstmt.setString(4, project_type);
						pstmt.setString(5, area_code);
						exeResult = pstmt.executeUpdate();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return exeResult;
				}  
				
				//添加区域租金走势
				public int insertZuJinTrend(String  heng,int zong,int view_shunxu,String project_type,String area_code){
					int exeResult=0;
					try {
						String sql = "insert into area_zujin(heng,zong,view_shunxu,project_type,area_code) values(?,?,?,?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, heng);
						pstmt.setInt(2, zong);
						pstmt.setInt(3, view_shunxu);
						pstmt.setString(4, project_type);
						pstmt.setString(5, area_code);
						exeResult = pstmt.executeUpdate();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return exeResult;
				}  
				
				//添加区域租金回报走势
				public int insertHuibaoTrend(String  heng,int zong,int view_shunxu,String project_type,String area_code){
					int exeResult=0;
					try {
						String sql = "insert into area_kongzhi(heng,zong,view_shunxu,project_type,area_code) values(?,?,?,?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, heng);
						pstmt.setInt(2, zong);
						pstmt.setInt(3, view_shunxu);
						pstmt.setString(4, project_type);
						pstmt.setString(5, area_code);
						exeResult = pstmt.executeUpdate();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return exeResult;
				}  
				
				
}
