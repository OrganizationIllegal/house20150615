package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.FujinPeiTao;
import com.kate.app.model.FujinSchool;
import com.kate.app.model.HoldCost;
import com.kate.app.model.HouseInfo1;
import com.kate.app.model.HouseProject;
import com.kate.app.model.HouseTax;
import com.kate.app.model.Project;
import com.kate.app.model.ProjectPeiTao;

@Repository 
public class ProjectInputDao extends BaseDao {
	//得到开发商的编号及名称
	public List<String> getDeveloperCodeName(){
		List<String> codeAndNameSet=new ArrayList<String>();
		try {
			String sql ="select t.developer_num,t.developer_name from developer_info t ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				//String codeAndName_str=rs.getString("developer_num")+","+rs.getString("developer_name");
				String codeAndName_str=rs.getString("developer_num");
				codeAndNameSet.add(codeAndName_str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codeAndNameSet;
	}
	//得到所有学校的名字
	public List<String> getAllSchoolName(){
		List<String> schoolList=new ArrayList<String>();
		try {
			String sql ="select school_name from school_info ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String school_name=rs.getString("school_name");
				schoolList.add(school_name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schoolList;
	}
	//项目列表
	public JSONArray selectProjectList(){
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = " select t.id,t.project_num,t.project_name from house_project t";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("project_num", rs.getString("project_num"));
				obj.put("project_name", rs.getString("project_name"));
				jsonArray.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonArray;
	} 
	//根据id找项目信息
	public HouseProject selectProjectInfo(int id){
		JSONArray jsonArray=new JSONArray();
		HouseProject houseProject=new HouseProject();
		try {
			String sql = " select * from house_project  where id="+id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				houseProject.setId(Integer.parseInt(rs.getString("id")));
				houseProject.setProject_name(rs.getString("project_name"));
				houseProject.setProject_img(rs.getString("project_img"));
				houseProject.setProject_nation(rs.getString("project_nation"));
				houseProject.setProject_address(rs.getString("project_address"));
				houseProject.setProject_area(rs.getString("project_area"));
				houseProject.setProject_price_qi(rs.getString("project_price_qi"));
				houseProject.setProject_type(rs.getString("project_type"));
				houseProject.setProject_sales_remain(rs.getInt("project_sales_remain"));
				houseProject.setProject_finish_time(rs.getTimestamp("project_finish_time"));
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
		}
		return houseProject;
	} 
	
	//学校信息Add
	public boolean InsertSchoolInfo(String school_name,String school_ranking,String school_type,int school_total,int teacher_total,String school_position,String gps,String net_info,int not_en_stu_bili,String school_image,String school_desc){
		boolean flag=true;
		try {
			String sql = "insert into school_info(school_name,school_ranking,school_type,student_total,teacher_total, school_position,gps,net_info,not_en_stu_bili,school_image,school_desc) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
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
			int exeResult = pstmt.executeUpdate();
			if(exeResult == 0){
				flag = false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	//开发商信息Add
		public boolean InsertDeveloperInfo(String developer_name,String developer_logo,String developer_desc,String developer_num){
			boolean flag=true;
			try {
				String sql = "insert into developer_info(developer_name,developer_logo,developer_desc,developer_num) values(?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, developer_name);
				pstmt.setString(2, developer_logo);
				pstmt.setString(3, developer_desc);
				pstmt.setString(4, developer_num);
				int exeResult = pstmt.executeUpdate();
				if(exeResult == 0){
					flag = false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}
		public int AddProject(List<Project> projectList,List<HouseInfo1>houseInfolist,List<ProjectPeiTao>projectPeitaolist,List<FujinPeiTao> fujinList,List<FujinSchool>fujinSchoolList,List<HoldCost>holdCostList,List<HouseTax>houseTaxList) throws SQLException{
			//项目信息参数接收
			Project project=projectList.get(0);
			String project_name=project.getProject_name();
			String project_nation=project.getProject_nation();
			String project_address=project.getProject_address();
			String project_area=project.getProject_area();
			String project_price_qi=project.getProject_price_qi();
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
			String buytaxInfo=project.getBuytaxInfo();
			String holdInfo=project.getHoldInfo();
			int  min_area=project.getMin_area();
			int  max_area=project.getMax_area();
			String developer_num=project.getDeveloper_id_name();
			
			
			String time = "";
			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(project_finish_time==null||"".equals(project_finish_time)){
				project_finish_time = "2015-05-09";
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
				housePrice_update_time = "2015-05-09";
			}
			 
	        try {  
	        	time1 = housePrice_update_time+" "+"00:00:00";
	            ts1 = Timestamp.valueOf(time1);   
	            
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        } 
	        PreparedStatement pstmt=null;
			try{
				con.setAutoCommit(false);
				//项目添加
				String sql1= " insert into house_project(project_name, project_nation, project_address, project_price_qi, project_type, project_sales_remain,  project_finish_time, project_desc, project_city, project_house_type, project_high, project_lan_cn, project_lan_en, project_num, project_vedio, project_zhou, gps, return_money, walk_num, mianji, project_min_price, project_high_price, tuijiandu, housePrice_update_time, buytaxInfo, holdInfo, min_area, max_area,  developer_id_name) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			    pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, project_name);
				pstmt.setString(2, project_nation);
				pstmt.setString(3, project_address);
				pstmt.setString(4, project_price_qi);
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
				pstmt.setString(25, buytaxInfo);
				pstmt.setString(26, holdInfo);
				pstmt.setInt(27, min_area);
				pstmt.setInt(28, max_area);
				pstmt.setString(29, developer_num);
				int result1 = pstmt.executeUpdate();
				System.out.println("result1:"+result1);
			     //户型及价格
				 String sql2="insert into house_info(house_name,house_img,house_price,house_room_num,tudi_area,jianzhu_area,house_size_in,house_size_out,house_toilet_size,project_num) values(?,?,?,?,?,?,?,?,?,?) ";
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
				//项目配套
				 String sql3="insert into project_peitao_image(image_name,image_type,view_shunxu,project_num,project_name) values(?,?,?,?,?) ";
		         pstmt = con.prepareStatement(sql3);
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
				
				//附近配套
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
				//附近学校
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
				//持有成本
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
				
				//购房税费
				 String sql7="insert into house_tax(type,price,description,project_num,house_name) values(?,?,?,?,?) ";
		         pstmt = con.prepareStatement(sql7);
		        for(int i=0;i<houseTaxList.size();i++){
		        	HouseTax housetax=houseTaxList.get(i);
		            String type=housetax.getHouseTaxtype();
		            String price=housetax.getHouseTaxprice();
		            String description=housetax.getHouseTaxdesc();
		            String housename=housetax.getHouseTax_housename();
		            pstmt.setString(1, type);
		            pstmt.setString(2, price);
		            pstmt.setString(3,description);
		            pstmt.setString(4,project_num);
		            pstmt.setString(5,housename);
		            pstmt.addBatch();
		        }
				int[] result7list=pstmt.executeBatch();
				System.out.println("result7list.length:"+result7list.length);
				for(int i=0;i<result7list.length;i++){
					System.out.println("result7list"+i+":"+result7list[i]);
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
		//添加项目
		public int addPro(String project_name, String project_img, String project_nation, String project_address, String project_area, String project_price_qi, String project_type, int project_sales_remain, String project_finish_time, String project_desc, String project_city, String project_house_type, String project_high, String project_price, String project_lan_cn, String project_lan_en, String project_num, String project_vedio, String project_zhou, String area_qujian, String gps, String return_money, int walk_num, String mianji, String project_min_price, String project_high_price, int tuijiandu, String housePrice_update_time, String buytaxInfo, String holdInfo, int min_area, int max_area, String area_num, String developer_num,
				 String peitao_type,String peitao_name,String peitao_distance,
				 String house_name,String house_img,String house_price,int house_room_num,String tudi_area,String jianzhu_area,String house_size_in,String house_size_out,int house_toilet_size,
				 String image_name,
				 String school_name,String school_distance,
				 String hold_type,int hold_price,String hold_description,String hold_housename,
				 String tax_type,int tax_price,String tax_description,String tax_housename) throws SQLException{
			boolean flag = true;
			String time = "";
			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(project_finish_time==null||"".equals(project_finish_time)){
				project_finish_time = "2015-05-09";
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
				housePrice_update_time = "2015-05-09";
			}
			 
	        try {  
	        	time1 = housePrice_update_time+" "+"00:00:00";
	            ts1 = Timestamp.valueOf(time1);   
	            
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        } 
			
			try{
				con.setAutoCommit(false);
				//项目添加
				String sql1= " insert into house_project(project_name, project_img, project_nation, project_address, project_area, project_price_qi, project_type, project_sales_remain,  project_finish_time, project_desc, project_city, project_house_type, project_high, project_price, project_lan_cn, project_lan_en, project_num, project_vedio, project_zhou, area_qujian, gps, return_money, walk_num, mianji, project_min_price, project_high_price, tuijiandu, housePrice_update_time, buytaxInfo, holdInfo, min_area, max_area, area_num, developer_id_name) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql1);
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
				//户型及价格添加
				String sql2="insert into house_info(house_name,house_img,house_price,house_room_num,tudi_area,jianzhu_area,house_size_in,house_size_out,house_toilet_size,project_num) values (?,?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, house_name);
				pstmt.setString(2, house_img);
				pstmt.setString(3, house_price);
				pstmt.setInt(4, house_room_num);
				pstmt.setString(5, tudi_area);
				pstmt.setString(6, jianzhu_area);
				pstmt.setString(7, house_size_in);
				pstmt.setString(8, house_size_out);
				pstmt.setInt(9, house_toilet_size);
				pstmt.setString(10, project_num);
				int result2 = pstmt.executeUpdate();
				System.out.println("result2:"+result2);
				//项目配套添加
				String sql3="insert into project_peitao_image(image_name,image_type,view_shunxu,project_num,project_name) values(?,?,?,?,?) ";
				pstmt = con.prepareStatement(sql3);
				pstmt.setString(1, image_name);
				pstmt.setString(2, "图片");
				pstmt.setString(3, "1");
				pstmt.setString(4, project_num);
				pstmt.setString(5, project_name);
				int result3 = pstmt.executeUpdate();
				System.out.println("result3:"+result3);
				//附近配套添加
				String sql4= " insert into near_peitao(market_type,market_name,market_distance,project_num) values(?,?,?,?)";
				pstmt = con.prepareStatement(sql4);
				pstmt.setString(1, peitao_type);
				pstmt.setString(2,  peitao_name);
				pstmt.setString(3, peitao_distance);
				pstmt.setString(4, project_num);
				int result4 = pstmt.executeUpdate();
				System.out.println("result4:"+result4);
				//附近学校添加
				String sql5= " insert into near_school(school_name,school_distance,project_num) values(?,?,?)";
				pstmt = con.prepareStatement(sql5);
				pstmt.setString(1, school_name);
				pstmt.setString(2, school_distance);
				pstmt.setString(3, project_num);
				int result5 = pstmt.executeUpdate();
				System.out.println("result5:"+result5);
				//持有成本添加
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
				//购房税费添加
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
		
	
}
