package com.kate.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.kate.app.model.BrokerInfoQuyu;
import com.kate.app.model.HouseProject;
import com.kate.app.model.LeiXing;
import com.kate.app.model.ProjectDescImage;
import com.kate.app.model.ProjectKey;
import com.kate.app.model.SearchList;

@Repository 
public class SearchListDao extends BaseDao2 {
	public List<SearchList> listSearchList(){
		NumberFormat nf = new DecimalFormat("#,###,###");
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<SearchList> searchInfoList=new ArrayList<SearchList>();
		try {
			con = dataSource.getConnection();
			String sql = "select t.id,t.project_type,t.gps,t.project_price,t.project_zhou,t.project_nation,t.project_city,t.project_num,t.project_desc,t.project_price_int_qi,t.project_name,t.project_address,t.project_img,t.project_lan_cn,t.project_lan_en,t.project_high_price as maxPrice,t.project_min_price as minprice,t.max_area as maxarea,t.min_area as minarea,t.mianji,t.project_sales_remain,t.return_money,t.project_logo,t.developer_id_name,p.xinkaipan,p.huaren,p.remen,p.xuequ,p.baozu,p.daxue,p.center,p.traffic,p.xianfang,p.maidi from house_project t left join project_key p on t.project_num=p.project_num  where t.isSeen=1";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_img=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    String maxPrice=null;
		    String  minprice=null;
		    int maxarea=0;
		    int minarea=0;
		    String return_money=null;
		    String project_num = "";
		    String project_lan_cn=null;
		    String project_lan_en=null;
		    String mianji=null;
		    String project_address=null;
		    String project_logo=null;
		    String developer_id_name=null;
		    String project_desc=null;
		    
		    String xinkaipan=null;
		    String huaren=null;
		    String remen=null;
		    String xuequ=null;
		    String baozu=null;
		    String daxue=null;
		    String center=null;
		    String traffic=null;
		    String xianfang=null;
		    String maidi=null;
		    String gps = null;
		    String project_zhou = null;
		    String project_city = null;
		    String project_price = null;
		    String project_nation = null;
		    int project_price_int_qi=0;
		    String project_area = null;
		    String project_type = null;
		    
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	//project_img=rs.getString("image_name");
		    	project_name=rs.getString("project_name");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	
		    	maxPrice=rs.getString("maxprice")==null||"".equals(rs.getString("maxprice"))?"N/A":nf.format(Integer.parseInt(rs.getString("maxprice")));
		    	/*minprice=rs.getString("minprice");*/
		    	minprice=rs.getString("minprice")==null||"".equals(rs.getString("minprice"))?"N/A":nf.format(Integer.parseInt(rs.getString("minprice")));
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	return_money=rs.getString("return_money");
		    	project_num = rs.getString("project_num");
		    	gps = rs.getString("gps");
		    	project_nation = rs.getString("project_nation");
		    	project_city = rs.getString("project_city");
		    	project_price = rs.getString("project_price");
		    	project_zhou = rs.getString("project_zhou");
		    	project_lan_cn=rs.getString("project_lan_cn");
		    	project_lan_en=rs.getString("project_lan_en");
		    	mianji=rs.getString("mianji");
		    	project_address=rs.getString("project_address");
		    	project_logo=rs.getString("project_logo");
		    	developer_id_name=rs.getString("developer_id_name");
		    	project_desc=rs.getString("project_desc");
		    	//project_area=rs.getString("project_area");
		    	project_type=rs.getString("project_type");
		    	
		    	xinkaipan=rs.getString("xinkaipan");
		    	huaren=rs.getString("huaren");
		    	remen=rs.getString("remen");
		    	xuequ=rs.getString("xuequ");
		    	baozu=rs.getString("baozu");
		    	daxue=rs.getString("daxue");
		    	
		    	center=rs.getString("center");
		    	traffic=rs.getString("traffic");
		    	xianfang=rs.getString("xianfang");
		    	maidi=rs.getString("maidi");
		    	if(rs.getString("project_price_int_qi")!=null)
		    	{
		    		project_price_int_qi=Integer.parseInt(rs.getString("project_price_int_qi"));
		    	}
		    	else{
		    		project_price_int_qi=0;
		    	}
		    	/*project_price_int_qi=nf.format(Integer.parseInt(rs.getString("project_price_int_qi")));*/
		    	/*project_price_int_qi=rs.getString("project_price_int_qi")==null||"".equals(rs.getString("minprice"))?"N/A":nf.format(Integer.parseInt(rs.getString("minprice")));*/
		    	SearchList  searchList=new SearchList(id,project_area,project_type,gps,project_city,project_nation,project_zhou,project_price,project_num,project_img,project_name,maxPrice,minprice,maxarea,minarea,project_sales_remain,return_money,project_lan_cn,project_lan_en,mianji,project_address,project_logo,developer_id_name,xinkaipan,huaren,remen,xuequ,baozu,daxue,center,traffic,xianfang,maidi,project_price_int_qi,project_desc);		    	
		    	searchInfoList.add(searchList);
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return searchInfoList;
	} 
	//项目列表页搜索
	public List<SearchList> filterSearchList(String projecttype,int zongjiamin,int zongjiamax,int danjiamin,int danjiamax,String xinaipan1,String remen1,String youxiu1,String center1,String baozu1,String huaren1,String zuixin1,String daxue1,String xianfang1,String traffic1,int woshimin,int woshimax,String nation,String city,String area){
		Statement stmt = null;
		Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		//找出項目编号所对应的户型及价格中卧室数量的最大值和最小值
		List<SearchList> searchInfoList=new ArrayList<SearchList>();
		try {con = dataSource.getConnection();
			/*String sql = "select t.id,t.gps,t.project_nation,t.project_area,t.project_type,t.project_city,t.project_price,t.project_zhou,t.project_num,t.project_desc,t.project_price_int_qi,t.project_name,t.project_address,t.project_img,t.project_lan_cn,t.project_lan_en,t.project_high_price as maxPrice,t.project_min_price as minprice,t.max_area as maxarea,t.min_area as minarea,t.mianji,t.project_sales_remain,t.return_money,t.project_logo,t.developer_id_name,p.xinkaipan,p.huaren,p.remen,p.xuequ,p.baozu,p.daxue,p.center,p.traffic,p.xianfang,p.maidi,i.image_name from house_project t  join project_key p on t.project_num=p.project_num join project_desc_image i on i.project_num=t.project_num join house_info h on h.project_num=t.project_num where i.view_shunxu=1 and t.isSeen=1 and";*/
		String sql="select t.id,t.gps,t.project_nation,t.project_area,t.project_type,t.project_city,t.project_price,t.project_zhou,t.project_num,t.project_desc,t.project_price_int_qi,t.project_name,t.project_address,t.project_img,t.project_lan_cn,t.project_lan_en,t.project_high_price as maxPrice,t.project_min_price as minprice,t.max_area as maxarea,t.min_area as minarea,t.mianji,t.project_sales_remain,t.return_money,t.project_logo,t.developer_id_name,p.xinkaipan,p.huaren,p.remen,p.xuequ,p.baozu,p.daxue,p.center,p.traffic,p.xianfang,p.maidi from house_project t  join project_key p on t.project_num=p.project_num  join house_info h on h.project_num=t.project_num where t.isSeen=1 and"; 	
		if(projecttype!=null && !"".equals(projecttype)){
				sql+="  t.project_type like ";
				sql+=" '"+projecttype+"'";
				sql+=" and ABS(`project_high_price`)<="+zongjiamax;
			}
			else{
				sql+=" ABS(`project_high_price`)<="+zongjiamax;
			}
			sql+=" and ABS(`project_min_price`)>="+zongjiamin;
			sql+=" and project_price_int_qi >="+danjiamin;
			sql+=" and project_price_int_qi <="+danjiamax;
			sql+=" and project_price_int_qi >="+danjiamin;
			
			sql+=" and project_nation like '%"+nation+"%'";
			sql+=" and project_city like '%"+city+"%'";
			sql+=" and project_area like '%"+area+"%'";
			
			
			if(xinaipan1.equals("1")){
				sql+=" and p.xinkaipan='1'";//新开盘
			}
			if(remen1.equals("1")){
				sql+=" and p.remen='1'";//热门项目
			}
			if(youxiu1.equals("1")){
				sql+=" and p.xuequ='1'";//优秀学区
			}
			if(center1.equals("1")){
				sql+=" and p.center='1'";//城市中心
			}
			if(baozu1.equals("1")){
				sql+=" and p.baozu='1'";//包租项目
			}
			if(huaren1.equals("1")){
				sql+=" and p.huaren='1'";//华人区
			}
			if(zuixin1.equals("1")){
				sql+=" and p.maidi='1'";//最新项目
			}
			if(daxue1.equals("1")){
				sql+=" and p.daxue='1'";//大学附近
			}
			if(xianfang1.equals("1")){
				sql+=" and p.xianfang='1'";//现房项目
			}
			if(traffic1.equals("1")){
				sql+=" and p.traffic='1'";//轨道交通
			}
			sql+=" GROUP BY h.project_num";
			sql+=" HAVING (MIN(h.house_room_num) >="+woshimin;
			sql+=" and MAX(h.house_room_num) <="+woshimax+")";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_img=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    String maxPrice=null;
		    String  minprice=null;
		    int maxarea=0;
		    int minarea=0;
		    String return_money=null;
		    String project_num = "";
		    String project_lan_cn=null;
		    String project_lan_en=null;
		    String mianji=null;
		    String project_address=null;
		    String project_logo=null;
		    String developer_id_name=null;
		    String project_desc=null;
		    String project_nation = null;
		    String gps = null;
		    String project_zhou = null;
		    String project_city = null;
		    String project_price = null;
		    String project_area = null;
		    String project_type = null;
		    
		    
		    String xinkaipan=null;
		    String huaren=null;
		    String remen=null;
		    String xuequ=null;
		    String baozu=null;
		    String daxue=null;
		    String center=null;
		    String traffic=null;
		    String xianfang=null;
		    String maidi=null;
		    
		    int project_price_int_qi=0;
		    
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	/*project_img=rs.getString("image_name");*/
		    	project_img=null;
		    	project_name=rs.getString("project_name");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	maxPrice=rs.getString("maxprice");
		    	minprice=rs.getString("minprice");
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	return_money=rs.getString("return_money");
		    	project_num = rs.getString("project_num");
		    	project_lan_cn=rs.getString("project_lan_cn");
		    	project_lan_en=rs.getString("project_lan_en");
		    	mianji=rs.getString("mianji");
		    	project_address=rs.getString("project_address");
		    	project_logo=rs.getString("project_logo");
		    	developer_id_name=rs.getString("developer_id_name");
		    	project_desc=rs.getString("project_desc");
		    	gps = rs.getString("gps");
		    	project_nation = rs.getString("project_nation");
		    	project_city = rs.getString("project_city");
		    	project_price = rs.getString("project_price");
		    	project_zhou = rs.getString("project_zhou");
		    	project_area=rs.getString("project_area");
		    	project_type=rs.getString("project_type");
		    	xinkaipan=rs.getString("xinkaipan");
		    	huaren=rs.getString("huaren");
		    	remen=rs.getString("remen");
		    	xuequ=rs.getString("xuequ");
		    	baozu=rs.getString("baozu");
		    	daxue=rs.getString("daxue");
		    	
		    	center=rs.getString("center");
		    	traffic=rs.getString("traffic");
		    	xianfang=rs.getString("xianfang");
		    	maidi=rs.getString("maidi");
		    	if(rs.getString("project_price_int_qi")!=null)
		    	{
		    		project_price_int_qi=Integer.parseInt(rs.getString("project_price_int_qi"));
		    	}
		    	else{
		    		project_price_int_qi=0;
		    	}
		    	SearchList  searchList=new SearchList(id,project_area,project_type,gps,project_city,project_nation,project_zhou,project_price,project_num,project_img,project_name,maxPrice,minprice,maxarea,minarea,project_sales_remain,return_money,project_lan_cn,project_lan_en,mianji,project_address,project_logo,developer_id_name,xinkaipan,huaren,remen,xuequ,baozu,daxue,center,traffic,xianfang,maidi,project_price_int_qi,project_desc);
		    	searchInfoList.add(searchList);
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { } 

        }
		return searchInfoList;
		
	}
	//找出項目编号所对应的户型及价格中卧室数量的最大值和最小值
	public int findMaxNumByPro(String project_num){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
        int max=0;
		try {con = dataSource.getConnection();
			String sql = "select MAX(t.house_room_num) as max  from house_info t where t.project_num='"+project_num+"'";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
		    
		    while(rs.next()){
		    	max=rs.getInt("max");
		    } 
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return max;
	} 
	//找出項目编号所对应的户型及价格中卧室数量的最小值
	public int findMinNumByPro(String project_num){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
        int min=0;
		try {con = dataSource.getConnection();
			String sql = "select MIN(t.house_room_num) as min  from house_info t where t.project_num='"+project_num+"'";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
		    
		    while(rs.next()){
		    	min=rs.getInt("min");
		    } 
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return min;
	} 
	//鎸夋帹鑽愬害鎺掑簭
	public List<SearchList> OrderlistSearchList(){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<SearchList> searchInfoList=new ArrayList<SearchList>();
		try {con = dataSource.getConnection();
			String sql = "select t.id,t.project_num,t.project_desc,t.project_price_int_qi,t.project_name,t.project_address,t.project_img,t.project_lan_cn,t.project_lan_en,t.project_high_price as maxPrice,t.project_min_price as minprice,t.max_area as maxarea,t.min_area as minarea,t.mianji,t.project_sales_remain,t.return_money,t.project_logo,t.developer_id_name,p.xinkaipan,p.huaren,p.remen,p.xuequ,p.baozu,p.daxue,p.center,p.traffic,p.xianfang,p.maidi from house_project t left join project_key p on t.project_num=p.project_num   where  t.isSeen=1  ORDER BY t.tuijiandu DESC";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_img=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    String maxPrice=null;
		    String  minprice=null;
		    int maxarea=0;
		    int minarea=0;
		    String return_money=null;
		    String project_num = "";
		    String project_lan_cn=null;
		    String project_lan_en=null;
		    String mianji=null;
		    String project_address=null;
		    String project_logo=null;
		    String developer_id_name=null;
		    String project_desc=null;
		    String gps = null;
		    String project_zhou = null;
		    String project_city = null;
		    String project_price = null;
		    String project_nation = null;
		    String xinkaipan=null;
		    String huaren=null;
		    String remen=null;
		    String xuequ=null;
		    String baozu=null;
		    String daxue=null;
		    String center=null;
		    String traffic=null;
		    String xianfang=null;
		    String maidi=null;
		    String project_area=null;
		    String project_type=null;
		    
		    int project_price_int_qi=0;
		    
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	/*project_img=rs.getString("image_name");*/
		    	project_img=null;
		    	project_name=rs.getString("project_name");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	maxPrice=rs.getString("maxprice");
		    	minprice=rs.getString("minprice");
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	return_money=rs.getString("return_money");
		    	project_num = rs.getString("project_num");
		    	project_lan_cn=rs.getString("project_lan_cn");
		    	project_lan_en=rs.getString("project_lan_en");
		    	mianji=rs.getString("mianji");
		    	project_address=rs.getString("project_address");
		    	project_logo=rs.getString("project_logo");
		    	developer_id_name=rs.getString("developer_id_name");
		    	project_desc=rs.getString("project_desc");
		    	/*gps = rs.getString("gps");*/
		    	/*project_nation = rs.getString("project_nation");*/
		    /*	project_city = rs.getString("project_city");
		    	project_price = rs.getString("project_price");
		    	project_zhou = rs.getString("project_zhou");*/
		    	xinkaipan=rs.getString("xinkaipan");
		    	huaren=rs.getString("huaren");
		    	remen=rs.getString("remen");
		    	xuequ=rs.getString("xuequ");
		    	baozu=rs.getString("baozu");
		    	daxue=rs.getString("daxue");
		    	/*project_area=rs.getString("project_area");
		    	project_type=rs.getString("project_type");*/
		    	
		    	center=rs.getString("center");
		    	traffic=rs.getString("traffic");
		    	xianfang=rs.getString("xianfang");
		    	maidi=rs.getString("maidi");
		    	if(rs.getString("project_price_int_qi")!=null)
		    	{
		    		project_price_int_qi=Integer.parseInt(rs.getString("project_price_int_qi"));
		    	}
		    	else{
		    		project_price_int_qi=0;
		    	}
		    	SearchList  searchList=new SearchList(id,project_area,project_type,gps,project_city,project_nation,project_zhou,project_price,project_num,project_img,project_name,maxPrice,minprice,maxarea,minarea,project_sales_remain,return_money,project_lan_cn,project_lan_en,mianji,project_address,project_logo,developer_id_name,xinkaipan,huaren,remen,xuequ,baozu,daxue,center,traffic,xianfang,maidi,project_price_int_qi,project_desc);		    	searchInfoList.add(searchList);
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return searchInfoList;
	} 
	
	/*
	 * 根据用户id查找项目编号
	 */
	public Set<String> proNumList(int userid){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Set<String>  proNums=new HashSet<String>();
		try{con = dataSource.getConnection();

			String sql ="select proNum from shoucang where userId="+userid;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
				proNums.add(rs.getString("proNum"));
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return proNums;
	}
	//根据用户id查找收藏项目
	public List<SearchList> listCollectList(int userid){
		
		Set<String> proNums=proNumList(userid);
		List<SearchList> searchInfoListResult=new ArrayList<SearchList>();
		for(String proNum : proNums)
		{
			SearchList searchList=findInfoByProNum(proNum);
			searchInfoListResult.add(searchList);
		}
		return searchInfoListResult;
	} 
	//根据项目编号查找项目信息
	public SearchList findInfoByProNum(String ProNum){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		SearchList  searchList=new SearchList();
		try {con = dataSource.getConnection();
			String sql = "select t.id,t.project_area,t.project_type,t.project_lan_cn,t.project_desc,t.project_num,t.project_price_int_qi,t.project_name,t.project_address,t.project_img,t.project_lan_cn,t.project_lan_en,t.project_high_price as maxPrice,t.project_min_price as minprice,t.max_area as maxarea,t.min_area as minarea,t.mianji,t.project_sales_remain,t.return_money,t.project_logo,t.developer_id_name,p.xinkaipan,p.huaren,p.remen,p.xuequ,p.baozu,p.daxue,p.center,p.traffic,p.xianfang,p.maidi,i.image_name from house_project t left join project_key p on t.project_num=p.project_num join project_desc_image i on t.project_num=i.project_num where i.view_shunxu=1 and t.project_num='"+ProNum+"'";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_img=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    String maxPrice=null;
		    String  minprice=null;
		    int maxarea=0;
		    int minarea=0;
		    String return_money=null;
		    String project_num = "";
		    String project_lan_cn=null;
		    String project_lan_en=null;
		    String mianji=null;
		    String project_address=null;
		    String project_logo=null;
		    String developer_id_name=null;
		    String project_desc=null;
		    String xinkaipan=null;
		    String huaren=null;
		    String remen=null;
		    String xuequ=null;
		    String baozu=null;
		    String daxue=null;
		    String center=null;
		    String traffic=null;
		    String xianfang=null;
		    String maidi=null;
		    String gps = null;
		    String project_zhou = null;
		    String project_city = null;
		    String project_price = null;
		    String project_nation = null;
		    int project_price_int_qi=0;
		    String project_area=null;
		    String project_type=null;
		    
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	project_img=rs.getString("image_name");
		    	project_name=rs.getString("project_name");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	maxPrice=rs.getString("maxprice");
		    	minprice=rs.getString("minprice");
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	return_money=rs.getString("return_money");
		    	project_num = rs.getString("project_num");
		    	project_lan_cn=rs.getString("project_lan_cn");
		    	project_lan_en=rs.getString("project_lan_en");
		    	mianji=rs.getString("mianji");
		    	project_address=rs.getString("project_address");
		    	project_logo=rs.getString("project_logo");
		    	developer_id_name=rs.getString("developer_id_name");
		    	project_desc=rs.getString("project_desc");
		    	xinkaipan=rs.getString("xinkaipan");
		    	huaren=rs.getString("huaren");
		    	remen=rs.getString("remen");
		    	xuequ=rs.getString("xuequ");
		    	baozu=rs.getString("baozu");
		    	daxue=rs.getString("daxue");
/*		    	gps = rs.getString("gps");*/
		    	/*project_nation = rs.getString("project_nation");
		    	project_city = rs.getString("project_city");
		    	project_price = rs.getString("project_price");*/
		    	center=rs.getString("center");
		    	traffic=rs.getString("traffic");
		    	xianfang=rs.getString("xianfang");
		    	maidi=rs.getString("maidi");
		    	if(rs.getString("project_price_int_qi")!=null)
		    	{
		    		project_price_int_qi=Integer.parseInt(rs.getString("project_price_int_qi"));
		    	}
		    	else{
		    		project_price_int_qi=0;
		    	}
		    	searchList=new SearchList(id,project_area,project_type,gps,project_city,project_nation,project_zhou,project_price,project_num,project_img,project_name,maxPrice,minprice,maxarea,minarea,project_sales_remain,return_money,project_lan_cn,project_lan_en,mianji,project_address,project_logo,developer_id_name,xinkaipan,huaren,remen,xuequ,baozu,daxue,center,traffic,xianfang,maidi,project_price_int_qi,project_desc);		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }

		return searchList;
	}
	
	//添加收藏
	public int AddCollect(int userid,String proNum ){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {con = dataSource.getConnection();
			String sql = "insert into shoucang(userId,proNum) values(?,?) ";
			 pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userid);
			pstmt.setString(2, proNum);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return exeResult;
	}
	//取消收藏
	public int DelCollect(int userid,String proNum ){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;

		int exeResult=0;
		try {con = dataSource.getConnection();
			String sql = "delete  from  shoucang where userId=? and proNum=?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userid);
			pstmt.setString(2, proNum);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return exeResult;
	}
	
	public List<String> searchSericeList(String name, String type, String suozaiarea, String area_code, String lang){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> brokerInfoList=new ArrayList<String>();
		
			try {con = dataSource.getConnection();
				String sql = "select distinct a.broker_num from broker_info a left join broker_service_area b on a.broker_num = b.broker_num where ";
				int i=0;
				if(name!=null && !"".equals(name)){
					sql+="a.broker_name like '%"+name+"%'";
					i=1;
				}
				if(type!=null &&!"".equals(type)){
					if(i==1){
						sql+="and a.broker_type like '%"+type+"%'";
					}
					else{
						sql+="a.broker_type like '%"+type+"%'";
						i=1;
					}
				}
				if(suozaiarea!=null &&!"".equals(suozaiarea)){
					if(i==1){
						sql+="and a.broker_region like '%"+suozaiarea+"%'";
					}
					else{
						sql+="a.broker_region like '%"+suozaiarea+"%'";
						i=1;
					}
				}
				if(area_code!=null &&!"".equals(area_code)){
					if(i==1){
						sql+="and b.area_code like '%"+area_code+"%'";
					}
					else{
						sql+="b.area_code like '%"+area_code+"%'";
						i=1;
					}
				}
				if(lang!=null && !"".equals(lang)){
					if(i==1){
						sql+="and a.broker_language like '%"+lang+"%'";
					}
					else{
						sql+="a.broker_language like '%"+lang+"%'";
						i=1;
					}
				}
				if(i == 0){
					sql = "select distinct a.broker_num from broker_info a left join broker_service_area b on a.broker_num = b.broker_num";
				}
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
			    int id=0;
			    String broker_img=null;
			    String broker_language=null;
			    String broker_name=null;
			    String broker_region=null;
			    String office=null;
			    String introduction=null;
			    
			    int broker_experience=0;
			    String broker_type=null;
			    String broker_zizhi=null;
			    while(rs.next()){
			    	String broker_num=null;
			    	/*id=rs.getInt("id");
			    	broker_img=rs.getString("broker_img");
			    	broker_language=rs.getString("broker_language");
			    	if(broker_language!=null && !"".equals(broker_language)){
			    		broker_language = broker_language.replace("+", " ");
			    	}
			    	
			    	broker_name=rs.getString("broker_name");
			    	broker_region=rs.getString("broker_region");
			    	office=rs.getString("office");
			    	introduction=rs.getString("introduction");*/
			    	broker_num=rs.getString("broker_num");
			    	/*broker_experience=rs.getInt("broker_experience");
			    	broker_type=rs.getString("broker_type");
			    	broker_zizhi=rs.getString("broker_zizhi");
			    	BrokerInfo brokerInfo=new BrokerInfo(id,broker_name,broker_language,broker_region, broker_img, office,introduction,broker_num,broker_experience,broker_type,broker_zizhi);
			    	brokerInfoList.add(brokerInfo);*/

//			    	BrokerInfo brokerInfo=new BrokerInfo(id,broker_name,broker_language,broker_region, broker_img, office,introduction);
//			    	brokerInfoList.add(brokerInfo);
			    	brokerInfoList.add(broker_num);
			    }
			    
			  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 try { if (rs != null) rs.close(); } catch(Exception e) { }
				 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
				 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
				 try { if (con != null) con.close(); } catch(Exception e) { }

	        }
			return brokerInfoList;
		} 
	
	
	
	
	public List<LeiXing> searchSericeListBroker(String broker_num){
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		BrokerInfoQuyu data = null;
		List<LeiXing> leixingList = new ArrayList<LeiXing>();
		LeiXing temp = null;
			try {con = dataSource.getConnection();
				String sql = "select  type_image from broker_interested_type a, interest_type b where a.interested_num = b.type_num and a.broker_num=? ";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, broker_num);
				rs = pstmt.executeQuery();
			   
			    while(rs.next()){
			    	
			    	//String leixing = rs.getString("type_name");
			    	String leixingImg = rs.getString("type_image");
			    	if((leixingImg!=null && !"".equals(leixingImg))){
			    		temp = new LeiXing();
				    	//temp.setLeixing(leixing);
				    	temp.setLeixingImg(leixingImg);
				    	leixingList.add(temp);
			    	}
			    	
			    	
			    }
			    
			  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 try { if (rs != null) rs.close(); } catch(Exception e) { }
				 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
				 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
				 try { if (con != null) con.close(); } catch(Exception e) { }

	        }
			return leixingList;
		} 
	
	//根据经纪人编号得到经纪人的服务区域
	public List<String> findFuwuAreaByNum(String broker_num){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> fuquAreaList = new ArrayList<String>();
			try {con = dataSource.getConnection();

				String sql = "select distinct a.area_name from area_info a join broker_service_area b  on a.area_num=b.area_code  join  broker_info c on b.broker_num=c.broker_num where c.broker_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, broker_num);
				rs = pstmt.executeQuery();
			    while(rs.next()){
			    	String area_name = rs.getString("area_name");
			    	if((area_name!=null && !"".equals(area_name))){
			    		fuquAreaList.add(area_name);
			    	}
			    }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 try { if (rs != null) rs.close(); } catch(Exception e) { }
				 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
				 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
				 try { if (con != null) con.close(); } catch(Exception e) { }

	        }
			return fuquAreaList;
		} 
	
	
	/*
	 * 通过前台传来的数据，查找项目信息
	 */
	public List<HouseProject> searchIndexList(String city1){
		NumberFormat df = new DecimalFormat("#,###,###");
		Statement stmt = null;Connection con = null;

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<HouseProject> houseProjectList=new ArrayList<HouseProject>();
		try {con = dataSource.getConnection();
			String sql = "select * from house_project where isSeen=1 and gps!='' and gps like '%,%' and project_name ='" +city1+ "' or project_city like '%" +city1+ "%'";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
		    while(rs.next()){
		    	HouseProject projectInfo = new HouseProject();
		    	String project_name = rs.getString("project_name");
		    	String project_name_short = "";
		    	if(project_name!=null && !"".equals(project_name)){
		    		project_name_short = project_name.length()>20?project_name.substring(0,20):project_name;
		    	}
		    			
				projectInfo.setProject_name(project_name);
				projectInfo.setProject_name_short(project_name_short);
				
				
				//projectInfo.setProject_img(rs.getString("image_name"));
				projectInfo.setProject_logo(rs.getString("project_logo"));
				projectInfo.setProject_nation(rs.getString("project_nation"));
				
				String project_address = rs.getString("project_address");
				String project_addresse_short = "";
		    	if(project_address!=null && !"".equals(project_address)){
		    		project_addresse_short = project_address.length()>40?project_address.substring(0,40):project_address;
		    	}		
		    	projectInfo.setProject_address(project_address);
		    	projectInfo.setProject_address_short(project_addresse_short);
		    	projectInfo.setProject_num(rs.getString("project_num"));
		    	String project_num = rs.getString("project_num");
		    	String project_img = "";
		    	if(project_num!=null && !"".equals(project_num)){
		    		List<ProjectDescImage> imageList = HouseProjectImageList(project_num);
					if(imageList!=null && imageList.size()>0){
						project_img = imageList.get(0).getName();
					}
					else{
						project_img = "";
					}
		    	}
		    	
		    	projectInfo.setProject_img(project_img);
		    	
				projectInfo.setProject_area(rs.getString("project_area"));
				//projectInfo.setProject_price_qi(rs.getString("project_price_qi"));
				//projectInfo.setProject_price_int_qi(rs.getInt("project_price_int_qi"));
				
				 if(rs.getString("project_price_int_qi")!=null){
					 projectInfo.setProject_price_qi(df.format(Integer.parseInt(rs.getString("project_price_int_qi"))));
			    	}
			    	else{
			    		projectInfo.setProject_price_qi("N/A");
			    	}
				 String price = rs.getString("project_price_int_qi")==null?"0":rs.getString("project_price_int_qi").trim();
				 
					projectInfo.setBijiao(price);
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
				
				projectInfo.setProject_vedio(rs.getString("project_vedio"));
				projectInfo.setProject_zhou(rs.getString("project_zhou"));
				projectInfo.setArea_qujian(rs.getString("area_qujian"));
				projectInfo.setGps(rs.getString("gps"));
				projectInfo.setReturn_money(rs.getString("return_money"));
				projectInfo.setDeveloper_id(rs.getInt("developer_id"));
				projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
				projectInfo.setProject_high_price(rs.getString("project_high_price")==null?"":df.format(Integer.parseInt(rs.getString("project_high_price"))));
				projectInfo.setProject_min_price(rs.getString("project_min_price")==null?"":df.format(Integer.parseInt(rs.getString("project_min_price"))));
				projectInfo.setMax_area(rs.getInt("max_area"));
				projectInfo.setMin_area(rs.getInt("min_area"));
				projectInfo.setArea_id(rs.getInt("area_id"));
				projectInfo.setMianji(rs.getString("mianji"));
				projectInfo.setRecommend_id_1(rs.getString("recommend_id_1"));
				projectInfo.setRecommend_id_2(rs.getString("recommend_id_2"));
				projectInfo.setRecommend_id_3(rs.getString("recommend_id_3"));
				projectInfo.setWuyefei(rs.getString("wuyefei"));
				projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
				houseProjectList.add(projectInfo);


				}
		  
			}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }


        }
		return houseProjectList;
	} 
	
	/*
	 * 通过关键字段，查找区域编号
	 */
	public String searchIndexList1(String city1){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String area_num = null;
		Map<String, String> resultMap= new HashMap<String, String>();
		
		try {con = dataSource.getConnection();

			String sql = "select * from area_info where area_name like '%" +city1+ "%' or area_zhou like '%" +city1+ "%' or area_city like '%" +city1+ "%'";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
		    while(rs.next()){
		    	area_num = rs.getString("area_num");


				}
		  
			}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return area_num;
	}
	
	
	/*
	 * 通过城市，类型等，进一步高级搜索，在数据库中查找项目信息
	 */
	public List<HouseProject> indexSericeList(String country, String city, String type, String minimumprice, String maximumprice, String xinkaipan,String huaren,String remen,String xuequ,String baozu,String daxue,String center,String traffic,String xianfang,String maidi){		NumberFormat df = new DecimalFormat("#,###,###");
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<HouseProject> houseProjectList=new ArrayList<HouseProject>();
		try {con = dataSource.getConnection();
			/*String sql = "select *,i.image_name from house_project t join project_desc_image i on t.project_num=i.project_num  where t.isSeen=1";
			String sql1 = "select project_num from project_key where ";*/
			String sql = "select * from house_project where isSeen=1 and gps!='' and gps like '%,%' ";
			String sql1 = "select project_num from project_key where ";
			int i=0;
			int j=0;
			if(xinkaipan!=null && !"".equals(xinkaipan)){
				xinkaipan = "1";
				sql1+="xinkaipan="+xinkaipan;
				//sql+= "and project_num in (" +sql1+ ") ";
				i=1;
			}
			if(huaren!=null &&!"".equals(huaren)){
				huaren = "1";
				if(i==1){
					sql1+=" or huaren="+huaren;
				}
				else{
					sql1+=" huaren="+huaren;
					i=1;
				}
			}
			if(remen!=null &&!"".equals(remen)){
				remen = "1";
				if(i==1){
					sql1+=" or remen="+remen;
				}
				else{
					sql1+=" remen="+remen;
					i=1;
				}
			}
			if(xuequ!=null &&!"".equals(xuequ)){
				xuequ = "1";
				if(i==1){
					sql1+=" or xuequ="+xuequ;
					
				}
				else{
					sql1+=" xuequ="+xuequ;
					
					i=1;
				}
			}
			if(baozu!=null &&!"".equals(baozu)){
				baozu = "1";
				if(i==1){
					sql1 +=" or baozu="+baozu;
					
				}
				else{
					sql1+=" baozu="+baozu;
					
					i=1;
				}
			}
			if(daxue!=null &&!"".equals(daxue)){
				daxue = "1";
				if(i==1){
					sql1+=" or daxue="+daxue;
					
				}
				else{
					sql1 += " daxue="+daxue;
					
					i=1;
				}
			}
			if(center!=null &&!"".equals(center)){
				center = "1";
				if(i==1){
					sql1+=" or center="+center;
					
				}
				else{
					sql1 += " center="+center;
					
					i=1;
				}
			}
			if(traffic!=null &&!"".equals(traffic)){
				traffic = "1";
				if(i==1){
					sql1+=" or traffic="+traffic;
					
				}
				else{
					sql1+=" traffic="+traffic;
					
					i=1;
				}
			}
			if(xianfang!=null &&!"".equals(xianfang)){
				xianfang = "1";
				if(i==1){
					sql1+=" or xianfang="+xianfang;
					
				}
				else{
					sql1+=" xianfang="+xianfang;
					
					i=1;
				}
			}
			if(maidi!=null &&!"".equals(maidi)){
				maidi = "1";
				if(i==1){
					sql1+=" or maidi="+maidi;
					
				}
				else{
					sql1+=" maidi="+maidi;
					
					i=1;
				}
			}
			if(i==0){
				sql1 = "select project_num from project_key";
			}
			
			sql+= "and project_num in (" +sql1+ ") ";

				if(city!=null && !"".equals(city)){
					sql+="and project_city like '%"+city+"%'";
					j=1;
				}
				if(type!=null && !"".equals(type)){
					if(j==1){
						sql+="and project_type like '%"+type+"%'";
					}
					else{
						sql+="and project_type like '%"+type+"%'";
						j=1;
					}
				}
				if(minimumprice!=null && !"".equals(minimumprice)){
					if(j==1){
						sql+="and project_min_price like '%"+minimumprice+"%'";
					}
					else{
						sql+="and project_min_price like '%"+minimumprice+"%'";
						j=1;
					}
				}
				if(maximumprice!=null && !"".equals(maximumprice)){
					if(j==1){
						sql+="and project_high_price like '%"+maximumprice+"%'";
					}
					else{
						sql+="and project_high_price like '%"+maximumprice+"%'";
						j=1;
					}
				}
				if(country!=null && !"".equals(country)){
					if(j==1){
						sql+="and project_nation like '%"+country+"%'";
					}
					else{
						sql+="and project_nation like '%"+country+"%'";
						j=1;
					}
				}
				if(j==0){
					sql = "select * from house_project where isSeen=1 and gps!='' and gps like '%,%' and project_num in (" +sql1+ ")";
				}
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
			
			  
		    while(rs.next()){
		    	HouseProject projectInfo = new HouseProject();
		    	String project_name = rs.getString("project_name");
		    	String project_name_short = "";
		    	if(project_name!=null && !"".equals(project_name)){
		    		project_name_short = project_name.length()>20?project_name.substring(0,20):project_name;
		    	}
		    			
				projectInfo.setProject_name(project_name);
				projectInfo.setProject_name_short(project_name_short);
				
				
				//projectInfo.setProject_img(rs.getString("image_name"));
				projectInfo.setProject_logo(rs.getString("project_logo"));
				projectInfo.setProject_nation(rs.getString("project_nation"));
				
				String project_address = rs.getString("project_address");
				String project_addresse_short = "";
		    	if(project_address!=null && !"".equals(project_address)){
		    		project_addresse_short = project_address.length()>40?project_address.substring(0,40):project_address;
		    	}		
		    	projectInfo.setProject_address(project_address);
		    	projectInfo.setProject_address_short(project_addresse_short);
		    	projectInfo.setBijiao(rs.getString("project_price_int_qi"));   // 比较
		    	
				projectInfo.setProject_area(rs.getString("project_area"));
				projectInfo.setProject_num(rs.getString("project_num"));

				String project_num = rs.getString("project_num");
		    	String project_img = "";
		    	if(project_num!=null && !"".equals(project_num)){
		    		List<ProjectDescImage> imageList = HouseProjectImageList(project_num);
					if(imageList!=null && imageList.size()>0){
						project_img = imageList.get(0).getName();
					}
					else{
						project_img = "";
					}
		    	}
		    	
		    	projectInfo.setProject_img(project_img);
				
				
				
				
				 if(rs.getString("project_price_int_qi")!=null){
					 projectInfo.setProject_price_qi(df.format(Integer.parseInt(rs.getString("project_price_int_qi"))));
			    	}
			    	else{
			    		projectInfo.setProject_price_qi("N/A");
			    	}
				 String price = rs.getString("project_price_int_qi")==null?"0":rs.getString("project_price_int_qi").trim();
				 
					projectInfo.setBijiao(price);
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
				
				projectInfo.setProject_vedio(rs.getString("project_vedio"));
				projectInfo.setProject_zhou(rs.getString("project_zhou"));
				projectInfo.setArea_qujian(rs.getString("area_qujian"));
				projectInfo.setGps(rs.getString("gps"));
				projectInfo.setReturn_money(rs.getString("return_money"));
				projectInfo.setDeveloper_id(rs.getInt("developer_id"));
				projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
				projectInfo.setProject_high_price(rs.getString("project_high_price")==null?"":df.format(Integer.parseInt(rs.getString("project_high_price"))));
				projectInfo.setProject_min_price(rs.getString("project_min_price")==null?"":df.format(Integer.parseInt(rs.getString("project_min_price"))));
				projectInfo.setMax_area(rs.getInt("max_area"));
				projectInfo.setMin_area(rs.getInt("min_area"));
				projectInfo.setArea_id(rs.getInt("area_id"));
				projectInfo.setMianji(rs.getString("mianji"));
				projectInfo.setRecommend_id_1(rs.getString("recommend_id_1"));
				projectInfo.setRecommend_id_2(rs.getString("recommend_id_2"));
				projectInfo.setRecommend_id_3(rs.getString("recommend_id_3"));
				projectInfo.setWuyefei(rs.getString("wuyefei"));
				projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
				houseProjectList.add(projectInfo);

				}
		  
			}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return houseProjectList;
	}
	
	
	/*
	 * 通过区域编号在数据库中查找项目信息
	 */
	public List<HouseProject> searchIndexProject(String areaNum){
		NumberFormat df = new DecimalFormat("#,###,###");
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		List<HouseProject> houseProjectList=new ArrayList<HouseProject>();
		try {con = dataSource.getConnection();

			String sql = "select *,i.image_name from house_project t join project_desc_image i on t.project_num=i.project_num  where t.isSeen=1 and t.gps!='' and t.gps like '%,%' and t.area_num=?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, areaNum);
			  rs = pstmt.executeQuery();
		    while(rs.next()){
		    	HouseProject projectInfo = new HouseProject();
		    	String project_name = rs.getString("project_name");
		    	String project_name_short = "";
		    	if(project_name!=null && !"".equals(project_name)){
		    		project_name_short = project_name.length()>20?project_name.substring(0,20):project_name;
		    	}
		    			
				projectInfo.setProject_name(project_name);
				projectInfo.setProject_name_short(project_name_short);
				
				projectInfo.setProject_img(rs.getString("image_name"));
				projectInfo.setProject_logo(rs.getString("project_logo"));
				projectInfo.setProject_nation(rs.getString("project_nation"));
				
				String project_address = rs.getString("project_address");
				String project_addresse_short = "";
		    	if(project_address!=null && !"".equals(project_address)){
		    		project_addresse_short = project_address.length()>40?project_address.substring(0,40):project_address;
		    	}		
		    	projectInfo.setProject_address(project_address);
		    	projectInfo.setProject_address_short(project_addresse_short);
		    	
		    	
				projectInfo.setProject_area(rs.getString("project_area"));

				
				 if(rs.getString("project_price_int_qi")!=null){
					 projectInfo.setProject_price_qi(df.format(Integer.parseInt(rs.getString("project_price_int_qi"))));
			    	}
			    	else{
			    		projectInfo.setProject_price_qi("N/A");
			    	}
				 
				 String price = rs.getString("project_price_int_qi")==null?"0":rs.getString("project_price_int_qi").trim();
				 
				projectInfo.setBijiao(price);
				
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
				projectInfo.setProject_high_price(rs.getString("project_high_price")==null?"":df.format(Integer.parseInt(rs.getString("project_high_price"))));
				projectInfo.setProject_min_price(rs.getString("project_min_price")==null?"":df.format(Integer.parseInt(rs.getString("project_min_price"))));
				projectInfo.setMax_area(rs.getInt("max_area"));
				projectInfo.setMin_area(rs.getInt("min_area"));
				projectInfo.setArea_id(rs.getInt("area_id"));
				projectInfo.setMianji(rs.getString("mianji"));
				projectInfo.setRecommend_id_1(rs.getString("recommend_id_1"));
				projectInfo.setRecommend_id_2(rs.getString("recommend_id_2"));
				projectInfo.setRecommend_id_3(rs.getString("recommend_id_3"));
				projectInfo.setWuyefei(rs.getString("wuyefei"));
				projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
				houseProjectList.add(projectInfo);

				}
		  
			}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return houseProjectList;
	} 
	
	
	
	/*
	 * 通过区域编号在数据库中查找项目信息
	 */
	public List<HouseProject> searchIndexProjectByCity(String areaNum, String searchCity){
		NumberFormat df = new DecimalFormat("#,###,###");
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		List<HouseProject> houseProjectList=new ArrayList<HouseProject>();
		try {con = dataSource.getConnection();

			String sql = "SELECT * FROM house_project a, area_info b WHERE a.area_num=b.area_num  AND a.isSeen=1 AND a.gps!='' AND a.gps LIKE '%,%' AND b.area_city LIKE '%"+areaNum+"%' or a.project_name ='"+searchCity+"'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		    while(rs.next()){
		    	HouseProject projectInfo = new HouseProject();
		    	String project_name = rs.getString("project_name");
		    	String project_name_short = "";
		    	if(project_name!=null && !"".equals(project_name)){
		    		project_name_short = project_name.length()>20?project_name.substring(0,20):project_name;
		    	}
		    			
				projectInfo.setProject_name(project_name);
				projectInfo.setProject_name_short(project_name_short);
				
				
				projectInfo.setProject_logo(rs.getString("project_logo"));
				projectInfo.setProject_nation(rs.getString("project_nation"));
				
				String project_address = rs.getString("project_address");
				String project_addresse_short = "";
		    	if(project_address!=null && !"".equals(project_address)){
		    		project_addresse_short = project_address.length()>40?project_address.substring(0,40):project_address;
		    	}		
		    	projectInfo.setProject_address(project_address);
		    	projectInfo.setProject_address_short(project_addresse_short);
		    	
		    	
				projectInfo.setProject_area(rs.getString("project_area"));
				
				String project_num = rs.getString("project_num");
		    	String project_img = "";
		    	if(project_num!=null && !"".equals(project_num)){
		    		List<ProjectDescImage> imageList = HouseProjectImageList(project_num);
					if(imageList!=null && imageList.size()>0){
						project_img = imageList.get(0).getName();
					}
					else{
						project_img = "";
					}
		    	}
		    	
		    	projectInfo.setProject_img(project_img);
				
				 if(rs.getString("project_price_int_qi")!=null){
					 projectInfo.setProject_price_qi(df.format(Integer.parseInt(rs.getString("project_price_int_qi"))));
			    	}
			    	else{
			    		projectInfo.setProject_price_qi("N/A");
			    	}
				 
				 String price = rs.getString("project_price_int_qi")==null?"0":rs.getString("project_price_int_qi").trim();
				 
				projectInfo.setBijiao(price);
				
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
				projectInfo.setProject_high_price(rs.getString("project_high_price")==null?"":df.format(Integer.parseInt(rs.getString("project_high_price"))));
				projectInfo.setProject_min_price(rs.getString("project_min_price")==null?"":df.format(Integer.parseInt(rs.getString("project_min_price"))));
				projectInfo.setMax_area(rs.getInt("max_area"));
				projectInfo.setMin_area(rs.getInt("min_area"));
				projectInfo.setArea_id(rs.getInt("area_id"));
				projectInfo.setMianji(rs.getString("mianji"));
				projectInfo.setRecommend_id_1(rs.getString("recommend_id_1"));
				projectInfo.setRecommend_id_2(rs.getString("recommend_id_2"));
				projectInfo.setRecommend_id_3(rs.getString("recommend_id_3"));
				projectInfo.setWuyefei(rs.getString("wuyefei"));
				projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
				houseProjectList.add(projectInfo);

				}
		  
			}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return houseProjectList;
	} 
	
	
	/*
	 * 通过区域编号在数据库中查找项目信息
	 */
	public List<HouseProject> searchIndexProjectNew(String areaNum){
		NumberFormat df = new DecimalFormat("#,###,###");
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		List<HouseProject> houseProjectList=new ArrayList<HouseProject>();
		try {con = dataSource.getConnection();

			String sql = "SELECT * FROM house_project a, area_info b WHERE a.area_num=b.area_num  AND a.isSeen=1 AND a.gps!='' AND a.gps LIKE '%,%' AND  b.area_name LIKE '%"+areaNum +"%' AND b.area_city LIKE '%"+ areaNum + "%' OR b.area_zhou LIKE '%"+ areaNum + "%'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		    while(rs.next()){
		    	HouseProject projectInfo = new HouseProject();
		    	String project_name = rs.getString("project_name");
		    	String project_name_short = "";
		    	if(project_name!=null && !"".equals(project_name)){
		    		project_name_short = project_name.length()>20?project_name.substring(0,20):project_name;
		    	}
		    			
				projectInfo.setProject_name(project_name);
				projectInfo.setProject_name_short(project_name_short);
				
				
				projectInfo.setProject_logo(rs.getString("project_logo"));
				projectInfo.setProject_nation(rs.getString("project_nation"));
				
				String project_address = rs.getString("project_address");
				String project_addresse_short = "";
		    	if(project_address!=null && !"".equals(project_address)){
		    		project_addresse_short = project_address.length()>40?project_address.substring(0,40):project_address;
		    	}		
		    	projectInfo.setProject_address(project_address);
		    	projectInfo.setProject_address_short(project_addresse_short);
		    	
		    	
				projectInfo.setProject_area(rs.getString("project_area"));
				
				String project_num = rs.getString("project_num");
		    	String project_img = "";
		    	if(project_num!=null && !"".equals(project_num)){
		    		List<ProjectDescImage> imageList = HouseProjectImageList(project_num);
					if(imageList!=null && imageList.size()>0){
						project_img = imageList.get(0).getName();
					}
					else{
						project_img = "";
					}
		    	}
		    	
		    	projectInfo.setProject_img(project_img);
				
				 if(rs.getString("project_price_int_qi")!=null){
					 projectInfo.setProject_price_qi(df.format(Integer.parseInt(rs.getString("project_price_int_qi"))));
			    	}
			    	else{
			    		projectInfo.setProject_price_qi("N/A");
			    	}
				 
				 String price = rs.getString("project_price_int_qi")==null?"0":rs.getString("project_price_int_qi").trim();
				 
				projectInfo.setBijiao(price);
				
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
				projectInfo.setProject_high_price(rs.getString("project_high_price")==null?"":df.format(Integer.parseInt(rs.getString("project_high_price"))));
				projectInfo.setProject_min_price(rs.getString("project_min_price")==null?"":df.format(Integer.parseInt(rs.getString("project_min_price"))));
				projectInfo.setMax_area(rs.getInt("max_area"));
				projectInfo.setMin_area(rs.getInt("min_area"));
				projectInfo.setArea_id(rs.getInt("area_id"));
				projectInfo.setMianji(rs.getString("mianji"));
				projectInfo.setRecommend_id_1(rs.getString("recommend_id_1"));
				projectInfo.setRecommend_id_2(rs.getString("recommend_id_2"));
				projectInfo.setRecommend_id_3(rs.getString("recommend_id_3"));
				projectInfo.setWuyefei(rs.getString("wuyefei"));
				projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
				houseProjectList.add(projectInfo);

				}
		  
			}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return houseProjectList;
	} 
	
	
	/*
	 * 通过前台传来的信息，在数据库中查找项目信息
	 */
	public List<HouseProject> searchIndexProjectByPro(String proName){
		NumberFormat df = new DecimalFormat("#,###,###");
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;

		List<HouseProject> houseProjectList=new ArrayList<HouseProject>();
		try {con = dataSource.getConnection();
			String sql = "select *,i.image_name from house_project t join project_desc_image i on t.project_num=i.project_num  where t.isSeen=1 and t.gps!='' and t.gps like '%,%' and i.view_shunxu=1 and t.project_name=?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, proName);
			  rs = pstmt.executeQuery();
		    while(rs.next()){
		    	HouseProject projectInfo = new HouseProject();
		    	String project_name = rs.getString("project_name");
		    	String project_name_short = "";
		    	if(project_name!=null && !"".equals(project_name)){
		    		project_name_short = project_name.length()>20?project_name.substring(0,20):project_name;
		    	}
		    			
				projectInfo.setProject_name(project_name);
				projectInfo.setProject_name_short(project_name_short);
				projectInfo.setBijiao(rs.getString("project_price_int_qi"));   // 比较
				
				projectInfo.setProject_img(rs.getString("image_name"));
				projectInfo.setProject_logo(rs.getString("project_logo"));
				projectInfo.setProject_nation(rs.getString("project_nation"));
				
				 String price = rs.getString("project_price_int_qi")==null?"0":rs.getString("project_price_int_qi").trim();
				 
					projectInfo.setBijiao(price);
				
				String project_address = rs.getString("project_address");
				String project_addresse_short = "";
		    	if(project_address!=null && !"".equals(project_address)){
		    		project_addresse_short = project_address.length()>40?project_address.substring(0,40):project_address;
		    	}		
		    	projectInfo.setProject_address(project_address);
		    	projectInfo.setProject_address_short(project_addresse_short);
		    	
		    	
				projectInfo.setProject_area(rs.getString("project_area"));
				//projectInfo.setProject_price_qi(rs.getString("project_price_qi"));
				//projectInfo.setProject_price_int_qi(rs.getInt("project_price_int_qi"));
				
				 if(rs.getString("project_price_int_qi")!=null){
					 projectInfo.setProject_price_qi(df.format(Integer.parseInt(rs.getString("project_price_int_qi"))));
			    	}
			    	else{
			    		projectInfo.setProject_price_qi("N/A");
			    	}
				
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
				projectInfo.setProject_high_price(rs.getString("project_high_price")==null?"":df.format(Integer.parseInt(rs.getString("project_high_price"))));
				projectInfo.setProject_min_price(rs.getString("project_min_price")==null?"":df.format(Integer.parseInt(rs.getString("project_min_price"))));
				projectInfo.setMax_area(rs.getInt("max_area"));
				projectInfo.setMin_area(rs.getInt("min_area"));
				projectInfo.setArea_id(rs.getInt("area_id"));
				projectInfo.setMianji(rs.getString("mianji"));
				projectInfo.setRecommend_id_1(rs.getString("recommend_id_1"));
				projectInfo.setRecommend_id_2(rs.getString("recommend_id_2"));
				projectInfo.setRecommend_id_3(rs.getString("recommend_id_3"));
				projectInfo.setWuyefei(rs.getString("wuyefei"));
				projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
				houseProjectList.add(projectInfo);

				}
		  
			}
			catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return houseProjectList;
	} 
	
	public ProjectKey searchProjectKey(String proNum){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ProjectKey projectKey=new ProjectKey();
		try {con = dataSource.getConnection();

			String sql = "select * from project_key where project_num=?";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, proNum);
			  rs = pstmt.executeQuery();
		    while(rs.next()){
		    	projectKey.setBaozu(rs.getString("baozu"));
		    	projectKey.setCenter(rs.getString("center"));
		    	projectKey.setDaxue(rs.getString("daxue"));
		    	projectKey.setHuaren(rs.getString("huaren"));
		    	projectKey.setId(rs.getInt("id"));
		    	projectKey.setMaidi(rs.getString("maidi"));
		    	projectKey.setRemen(rs.getString("remen"));
		    	projectKey.setTraffic(rs.getString("traffic"));
		    	projectKey.setXianfang(rs.getString("xianfang"));
		    	projectKey.setXuequ(rs.getString("xuequ"));
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }


        }
		return projectKey;
	} 

	public List<ProjectDescImage> HouseProjectImageList(String pro_num){
		DecimalFormat df = new DecimalFormat("#,###,###");
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		List<ProjectDescImage> imageList = new ArrayList<ProjectDescImage>();
		
		try{con = dataSource.getConnection();
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
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return imageList;
	}
	/**
	 * 得到所有的国家名字
	 * @param nation
	 * @return
	 */
		public List<String> findAllNation(){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Connection con = null;
			List<String> nations=new ArrayList<String>();
			try{
			con = dataSource.getConnection();
			String sql = "select * from nation ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String nation_name=rs.getString("nation_name");
				nations.add(nation_name);
			}
			
		}catch (Exception e) {
			 e.printStackTrace();
	    }
		finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }
	    }
	  return nations;
	}
		
/**
 * 根据国家查找城市
 * @param nation
 * @return
 */
	public List<String> findCityByNation(String nation){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		List<String> citys=new ArrayList<String>();
		try{
		con = dataSource.getConnection();
		String sql = "select * from city where pre_num=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, nation);
		rs = pstmt.executeQuery();
		while(rs.next()){
			String city=rs.getString("city_name");
			citys.add(city);
		}
		
	}catch (Exception e) {
		 e.printStackTrace();
    }
	finally{
		 try { if (rs != null) rs.close(); } catch(Exception e) { }
		 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
		 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
		 try { if (con != null) con.close(); } catch(Exception e) { }
    }
  return citys;
}
	/**
	 * 根据城市查找区域
	 * @param city
	 * @return
	 */
		public List<String> findAreaByCity(String city){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Connection con = null;
			List<String> areas=new ArrayList<String>();
			try{
			con = dataSource.getConnection();
			String sql = "select * from area where pre_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, city);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String area_name=rs.getString("area_name");
				areas.add(area_name);
			}
			
		}catch (Exception e) {
			 e.printStackTrace();
	    }
		finally{
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }
	    }
	  return areas;
	}
	
	
	
}
