package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.AreaFamilyBackEnd;
import com.kate.app.model.AreaInfo;
import com.kate.app.model.AreaMiddle;
import com.kate.app.model.AreaMiddle2;
import com.kate.app.model.AreaPeopleInfo2;
import com.kate.app.model.AreaTeDian2;
import com.kate.app.model.AreaZhikong2;
import com.kate.app.model.AreaZujin2;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.InvestmentDataBackEnd;
import com.kate.app.model.MiddlePrice2;
import com.kate.app.model.MiddlePriceBackEnd;
@Repository 
public class AreaInfoDao extends BaseDao {
	//通过区域id获取区域房价中位数走势信息
	public List<AreaMiddle> getAreaMiddleList(String area_num){
		List<AreaMiddle> areaInfolist = new ArrayList<AreaMiddle>();
		try {
			String sql = " SELECT * from area_middle where area_num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,area_num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				AreaMiddle areaInfo = new AreaMiddle();
				areaInfo.setId(rs.getInt("id"));
				areaInfo.setHeng(rs.getString("heng"));
				areaInfo.setZong(rs.getInt("zong"));
				areaInfo.setView_shunxu(rs.getInt("view_shunxu"));
				areaInfo.setProject_type(rs.getString("project_type"));
				areaInfo.setArea_code(rs.getString("area_code"));
				areaInfo.setMiddle_zoushi_datasource(rs.getString("middle_zoushi_datasource"));
				areaInfo.setMiddle_zoushi_date(rs.getTimestamp("middle_zoushi_date"));
				areaInfolist.add(areaInfo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areaInfolist;
	}
	//通过区域id获取区域中位数房价信息
			public List<MiddlePriceBackEnd> getMiddlePrice(String area_num){
				List<MiddlePriceBackEnd> areaInfolist = new ArrayList<MiddlePriceBackEnd>();
				try {
					String sql = " SELECT * from middleprice where area_num=?";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1,area_num);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()){
						MiddlePriceBackEnd areaInfo = new MiddlePriceBackEnd();
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
						areaInfo.setArea_quyu(rs.getString("area_quyu"));
						areaInfo.setProject_type(rs.getString("project_type"));
						areaInfo.setMiddle_datasource(rs.getString("middle_datasource"));
						areaInfo.setUpdate_time(rs.getTimestamp("update_time"));
						areaInfolist.add(areaInfo);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return areaInfolist;
			}

	//通过区域id获取投资家庭信息
		public AreaFamilyBackEnd getFamilyBackEnd(String area_num){
			AreaFamilyBackEnd areaInfo = new AreaFamilyBackEnd();
			try {
				String sql = " SELECT * from areafamily where area_num=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,area_num);
				ResultSet rs = pstmt.executeQuery();
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
			return areaInfo;
		}
	//通过区域id获取投资数据信息
	public InvestmentDataBackEnd getInvestInfo(String area_num){
		InvestmentDataBackEnd areaInfo = new InvestmentDataBackEnd();
		try {
			String sql = " SELECT * from investment_data where area_num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,area_num);
			ResultSet rs = pstmt.executeQuery();
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
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areaInfo;
	}
	//区域录入
	public int AddArea(String area_num,String area_name,String area_city,String area_zhou,String area_nation,String area_postcode,String touzi_datasource,String touzi_date,String middle_price,String middle_zu_price,String price_review,String year_increment_rate,String zu_house_rate,String zu_xuqiu,String data_exam,String family_one,String family_one_rate,String family_two,String family_two_rate,String family_three,String family_three_rate,String family_datasource,String family_date,List<MiddlePrice2> middlepriceList,List<AreaMiddle2> middletrendList,List<AreaZujin2> zujintrendlistList,List<AreaZhikong2> huibaotrendlistList,List<AreaTeDian2> tedianlistList,List<AreaPeopleInfo2> peoplelistList,List<BrokerInfo> brokerlistList,List<String> projectlistList,List<String> newslistList,List<String> list) throws SQLException{
		PreparedStatement pstmt=null;
		try {
			con.setAutoCommit(false);
			//区域信息
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
			
			//投资数据
			boolean flagtouzi = true;
			String time_strtouzi = "";
			Timestamp tstouzi = new Timestamp(System.currentTimeMillis()); 
			if(touzi_date==null||"".equals(touzi_date)){
				touzi_date = "2015-05-09";
				//(new SimpleDateFormat("yyyy-MM-dd"))。format(new Date())
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
	        //区域中位数房价
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
				Timestamp middle_date = item.getMiddle_date();
				String time_str = "";
				if(middle_date != null){
					time_str = middle_date.toString(); 
				}
				
		        
				
					String sqlmiddleprice = " insert into area_middle_price(buy_price, zu_price, " +
							"buy_one_name, buy_one_price, buy_two_name, buy_two_price, " +
							"buy_three_name, buy_three_price, zu_one_name, zu_one_price, " +
							"zu_two_name, zu_two_price, zu_three_name, zu_three_price, area_quyu, " +
							"middle_datasource, middle_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
					
					
					
					int resultmiddleprice = pstmt.executeUpdate();
					if(resultmiddleprice == 0){
						flagmiddleprice = false;
					}
				
			}
			//区域房价中位数走势
			for(AreaMiddle2 item : middletrendList){
				/*boolean resultMiddle = areaInfoDao.addMiddleTrend(item, area_num);*/
				boolean flag = true;
				int heng = item.getHeng2();
				int zong = item.getZong2();
				int view_shunxu =item.getView_shunxu2();
				String project_type = item.getProject_type2();
				
				String middle_zoushi_datasource = item.getMiddle_zoushi_datasource();
				Timestamp middle_zoushi_date = item.getMiddle_zoushi_date();
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
			//区域租金走势
			for(AreaZujin2 item : zujintrendlistList){
				/*boolean resultZujin = areaInfoDao.addMiddleZujin(item, area_num);*/
				boolean flag = true;
				int heng = item.getHeng3();
				int zong = item.getZong3();
				int view_shunxu =item.getView_shunxu3();
				String project_type = item.getProject_type3();
				
				String zujin_datasource = item.getZujin_datasource();
				Timestamp zujin_dates = item.getZujin_date();
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
			//区域租金回报率
			for(AreaZhikong2 item : huibaotrendlistList){
				/*boolean resultZujin = areaInfoDao.addAreaZhikong(item, area_num);*/
				boolean flag = true;
				int heng = item.getHeng4();
				int zong = item.getZong4();
				int view_shunxu =item.getView_shunxu4();
				String project_type = item.getProject_type4();
				
				String zujin_huibao_datasource = item.getZujin_huibao_datasource();
				Timestamp zujin_huibao_date = item.getZujin_huibao_date();
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
			//区域特点
			for(AreaTeDian2 item : tedianlistList){
				/*boolean resultZujin = areaInfoDao.addAreaTeDian(item, area_num);*/
				boolean flag = true;
				String area_character = item.getArea_character();
				int view_shunxu = item.getView_shunxu();
				
				
				String data_source = item.getData_source();
				Timestamp update_time = item.getUpdate_time();
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
			//区域人口分布
			for(AreaPeopleInfo2 item : peoplelistList){
				/*boolean resultZujin = areaInfoDao.addAreaPeople(item, area_num);*/
				boolean flag = true;
				String column1 = item.getColumn1();
				String column2 = item.getColumn2();
				String column3 = item.getColumn3();
				int view_shunxu = item.getView_shunxu_people();
				String people_datasource = item.getPeople_datasource();
				Timestamp people_date = item.getPeople_date();
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
			//推荐经纪人
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
			
			//推荐项目
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
			
			//新闻报道
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
			
			
			
			
			//提交事物
			con.commit();
			//恢复JDBC事务
			con.setAutoCommit(true);
			return 1;
		}catch (Exception e) {
			//回滚JDBC事务
			con.rollback();
            e.printStackTrace();
            return -1;
        }
	}
	
	//Area编辑模块的查询AreaInfo信息
	public AreaInfo getAreaInfoBackEnd(int id){
		AreaInfo areaInfo = new AreaInfo();
		try {
			String sql = " SELECT * from area_info where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				areaInfo.setArea_city(rs.getString("area_city"));
				areaInfo.setArea_name(rs.getString("area_name"));
				areaInfo.setArea_nation(rs.getString("area_nation"));
				areaInfo.setArea_num(rs.getString("area_num"));
				areaInfo.setArea_zhou(rs.getString("area_zhou"));
				areaInfo.setHouse_pro_id(rs.getInt("area_postcode"));
				areaInfo.setId(id);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areaInfo;
	}
	
	
	public AreaInfo getAreaInfo(int id){
		AreaInfo areaInfo = new AreaInfo();
		try {
			String sql = " SELECT * from area_info where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
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
		return areaInfo;
	}
	
	public AreaInfo getAreaInfoByNum(String area_num){
		AreaInfo areaInfo = new AreaInfo();
		try {
			String sql = " SELECT * from area_info where area_num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_num);
			ResultSet rs = pstmt.executeQuery();
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
		return areaInfo;
	}
	
	public AreaInfo getAreaInfo(String area_name){
		AreaInfo areaInfo = new AreaInfo();
		try {
			String sql = " SELECT * from area_info where area_name=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_name);
			ResultSet rs = pstmt.executeQuery();
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
		return areaInfo;
	}
	
	public boolean addAreaInfo(String area_num,String area_name,String area_city,String area_zhou,String area_nation,String area_postcode){
		boolean flag = true;
		try{
			String sql = " insert into area_info(area_num, area_name, area_city, area_zhou, area_nation, area_postcode) values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
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
		return flag;
	}
	
	public boolean addTouziData(String touzi_datasource, String touzi_date, String middle_price, String middle_zu_price, String price_review, String year_increment_rate, String zu_house_rate, String zu_xuqiu,String data_exam, String area_num, String area_name){
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
			PreparedStatement pstmt = con.prepareStatement(sql);
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
        }/*finally{
        	con.close();
        }*/
		return flag;
        
	}

	
	public boolean addAreaFamily(String area_code, String family_one, String family_one_rate, String family_two, String family_two_rate, String family_three, String family_three_rate, String family_datasource, String family_date){
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
			PreparedStatement pstmt = con.prepareStatement(sql);
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
		return flag;
	}
	
	public boolean addMiddlePrice(MiddlePrice2 obj, String area_quyu){
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
		Timestamp middle_date = obj.getMiddle_date();
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
		return flag;
	}
	
	
	public boolean addMiddleTrend(AreaMiddle2 obj, String area_code){
		boolean flag = true;
		int heng = obj.getHeng2();
		int zong = obj.getZong2();
		int view_shunxu =obj.getView_shunxu2();
		String project_type = obj.getProject_type2();
		
		String middle_zoushi_datasource = obj.getMiddle_zoushi_datasource();
		Timestamp middle_zoushi_date = obj.getMiddle_zoushi_date();
		String time_str = "";
		if(middle_zoushi_date != null){
			time_str = middle_zoushi_date.toString(); 
		}
		
        
		try{
			String sql = " insert into area_middle(heng, zong, " +
					"view_shunxu, project_type, area_code, middle_zoushi_datasource, " +
					"middle_zoushi_date) values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
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
		return flag;
	}
	
	public boolean addMiddleZujin(AreaZujin2 obj, String area_code){
		boolean flag = true;
		int heng = obj.getHeng3();
		int zong = obj.getZong3();
		int view_shunxu =obj.getView_shunxu3();
		String project_type = obj.getProject_type3();
		
		String zujin_datasource = obj.getZujin_datasource();
		Timestamp zujin_dates = obj.getZujin_date();
		String time_str = "";
		if(zujin_dates != null){
			time_str = zujin_dates.toString(); 
		}
		
        
		try{
			String sql = " insert into area_zujin(heng, zong, " +
					"view_shunxu, project_type, area_code, zujin_datasource, " +
					"zujin_date) values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
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
		return flag;
	}
	
	public boolean addAreaZhikong(AreaZhikong2 obj, String area_code){
		boolean flag = true;
		int heng = obj.getHeng4();
		int zong = obj.getZong4();
		int view_shunxu =obj.getView_shunxu4();
		String project_type = obj.getProject_type4();
		
		String zujin_huibao_datasource = obj.getZujin_huibao_datasource();
		Timestamp zujin_huibao_date = obj.getZujin_huibao_date();
		String time_str = "";
		if(zujin_huibao_date != null){
			time_str = zujin_huibao_date.toString(); 
		}
		
        
		try{
			String sql = " insert into area_kongzhi(heng, zong, " +
					"view_shunxu, project_type, area_code, zujin_huibao_datasource, " +
					"zujin_huibao_date) values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
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
		return flag;
	}
	
	
	public boolean addAreaTeDian(AreaTeDian2 obj, String area_code){
		boolean flag = true;
		String area_character = obj.getArea_character();
		int view_shunxu = obj.getView_shunxu();
		
		
		String data_source = obj.getData_source();
		Timestamp update_time = obj.getUpdate_time();
		String time_str = "";
		if(update_time != null){
			time_str = update_time.toString(); 
		}
		
        
		try{
			String sql = " insert into area_features(area_character, view_shunxu, " +
					"area_code, data_source, update_time ) values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
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
		return flag;
	}
	
	
	public boolean addAreaPeople(AreaPeopleInfo2 obj, String area_code){
		boolean flag = true;
		String column1 = obj.getColumn1();
		String column2 = obj.getColumn2();
		String column3 = obj.getColumn3();
		int view_shunxu = obj.getView_shunxu_people();
		String people_datasource = obj.getPeople_datasource();
		Timestamp people_date = obj.getPeople_date();
		String time_str = "";
		if(people_date != null){
			time_str = people_date.toString(); 
		}
		
        
		try{
			String sql = " insert into area_people(column1, column2, " +
					"column3, view_shunxu, area_code, people_datasource, people_date) values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
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
		return flag;
	}
	
	public boolean addAreaTuijianBroker(List<BrokerInfo> brokerlistList, String area_code){
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
			PreparedStatement pstmt = con.prepareStatement(sql);
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
		return flag;
	}
	
	
	public boolean addAreaTuijianPro(List<String> projectlistList, String area_code){
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
			PreparedStatement pstmt = con.prepareStatement(sql);
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
		return flag;
	}
	
	public boolean addAreaTuijianBoke(List<String> newslistList, List<String> list, String area_code){
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
			PreparedStatement pstmt = con.prepareStatement(sql);
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
		return flag;
	}
	
	public String findBrokerbyName(String broker_name){
		String brokerNum=null;
		try {
			String sql = "select * from broker_info where broker_name = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, broker_name);
			ResultSet rs = pstmt.executeQuery();
			
		    while(rs.next()){
		    	brokerNum = rs.getString("broker_num");
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brokerNum;
		
	}
	
	
	public String findProByName(String Name){
		String num = null;
		try{
			String sql = "select * from house_project where project_name=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				num = rs.getString("project_num");
			}
			
		}catch (Exception e) {
			 e.printStackTrace();
        }
		return num;
	}
	
	public String findBokeByName(String Name){
		String num = null;
		try{
			String sql = "select * from news_boke where news_title=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				num = rs.getString("news_num");
			}
			
		}catch (Exception e) {
			 e.printStackTrace();
        }
		return num;
	}
	
	public String findZhiYeByName(String Name){
		String num = null;
		try{
			String sql = "select * from zhiye_zhidao where title=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				num = rs.getString("zhiye_num");
			}
			
		}catch (Exception e) {
			 e.printStackTrace();
        }
		return num;
	}
	
}
