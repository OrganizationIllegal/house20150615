package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.BingMapCenter;
import com.kate.app.model.BingMapVo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.ProjectDescImage;
@Repository 
public class BingMapDao extends BaseDao {
	public List<BingMapVo> listBingMap(){    //加载地图找房调用
		NumberFormat nf = new DecimalFormat("#,###,###");
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		try {
			String sql = "select t.id,t.project_num,t.project_name,t.project_address,t.project_type,t.project_price_qi,t.project_price,t.project_min_price,t.project_high_price,t.mianji,t.project_img,t.project_lan_cn,t.project_high_price as maxPrice,t.project_min_price as minprice,t.max_area as maxarea,t.min_area as minarea,t.mianji,t.project_sales_remain,t.return_money,t.project_price_int_qi from house_project t where t.isSeen=1 and t.gps!='' and t.gps like '%,%'";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_address=null;
		    //对项目地址进行截取
		    String project_address_short=null;
		    
		    String project_img=null;
		    String project_num=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    String project_price_qi=null;
		    int maxarea=0;
		    int minarea=0;
		    String project_min_price=null;
		    String project_high_price=null;
		    String mianji="骞崇背";
		    String house_type=null;
		    String project_price=null;
		    String return_money=null; 
		    /*int project_price_int_qi=0;*/
		    String project_price_int_qi=null;
		    List<String> project_key=null;
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	//project_img=rs.getString("project_img");
		    	project_num=rs.getString("project_num");
		    	
		    	if(project_num!=null && !"".equals(project_num)){
		    		List<ProjectDescImage> imageList = HouseProjectImageList(project_num);
					if(imageList!=null && imageList.size()>0){
						project_img = imageList.get(0).getName();
					}
					else{
						project_img = "";
					}
		    	}
		    	
		    	
		    	
		    	project_address=rs.getString("project_address");
		    	project_name=rs.getString("project_name");
		    	project_price=rs.getString("project_price");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	//project_price=rs.getInt("project_price_qi");//锟剿达拷锟斤拷目锟桔革拷目前锟斤拷锟斤拷锟斤拷锟侥科斤拷锟桔革拷
		    	project_price_qi=rs.getString("project_price_qi");
		    	project_min_price=rs.getString("project_min_price")==null?"N/A":nf.format(Integer.parseInt(rs.getString("project_min_price")));
		    	project_high_price=rs.getString("project_high_price")==null?"N/A":nf.format(Integer.parseInt(rs.getString("project_high_price")));
		    	mianji=rs.getString("mianji");
		    	house_type=rs.getString("project_type");
		    	return_money=rs.getString("return_money");
		    	if(rs.getString("project_price_int_qi")!=null){
		    	     project_price_int_qi=nf.format(Integer.parseInt(rs.getString("project_price_int_qi")));
		    	}
		    	else{
		    		project_price_int_qi="N/A";
		    	}
		    	//对项目地址进行截取
		    	project_address_short=project_address.length()>40?project_address.substring(0, 40):project_address;
		    	String project_name_short=project_name.length()>20?project_name.substring(0, 20):project_name;
		    	//第一个项目关键字
		    	project_key=findProjectKeyByNum(project_num);
		    	String bijiao = rs.getString("project_price_int_qi");
		        BingMapVo bingMapVo=new BingMapVo(id,bijiao,project_name,project_img,project_num,project_address, project_name_short, project_price,minarea, maxarea, project_sales_remain, project_price_qi,house_type,project_min_price,project_high_price,mianji,return_money,project_price_int_qi,project_key,project_address_short);
		    	bingMapList.add(bingMapVo);
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs != null){   // 鍏抽棴璁板綍闆�   
		        try{   
		            rs.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		          }   
		      if(stmt != null){   // 鍏抽棴澹版槑   
		        try{   
		            stmt.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		     } 
		      if(pstmt != null){   // 鍏抽棴澹版槑   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return bingMapList;
	} 
	//根据项目编号查找project_key
	public List<String> findProjectKeyByNum(String proNum){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		String project_key=null;
		 List<String> keyList=new ArrayList<String>();
		try {
			String sql = "select * from project_key where  project_num='"+proNum+"'";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			  String xinkaipan="";//新开盘
			  String remen="";//热门项目
			  String xuequ="";//优秀学区
			  String center="";//城市中心
			  String baozu="";//包租项目
			  String huaren="";//华人区
			  String maidi="";//最新项目
			  String daxue="";//大学附近
			  String xianfang="";//现房项目
			  String traffic="";//轨道交通
			 
		    while(rs.next()){
		    	xinkaipan=rs.getString("xinkaipan")==null?"":rs.getString("xinkaipan");
		    	remen=rs.getString("remen")==null?"":rs.getString("remen");
		    	xuequ=rs.getString("xuequ")==null?"":rs.getString("xuequ");
		    	center=rs.getString("center")==null?"":rs.getString("center");
		    	baozu=rs.getString("baozu")==null?"":rs.getString("baozu");
		    	huaren=rs.getString("huaren")==null?"":rs.getString("huaren");
		    	maidi=rs.getString("maidi")==null?"":rs.getString("maidi");
		    	daxue=rs.getString("daxue")==null?"":rs.getString("daxue");
		    	xianfang=rs.getString("xianfang")==null?"":rs.getString("xianfang");
		    	traffic=rs.getString("traffic")==null?"":rs.getString("traffic");
		    }
		    if(xinkaipan.equals("1")){
		    	project_key="新开盘";
		    	keyList.add(project_key);
		    }
		    else if(remen.equals("1")){
		    	project_key="热门项目";
		    	keyList.add(project_key);
		    }
		    else if(xuequ.equals("1")){
		    	project_key="优秀学区";
		    	keyList.add(project_key);
		    }
		    else if(center.equals("1")){
		    	project_key="城市中心";
		    	keyList.add(project_key);
		    }
		    else if(baozu.equals("1")){
		    	project_key="包租项目";
		    	keyList.add(project_key);
		    }
		    else if(huaren.equals("1")){
		    	project_key="华人区";
		    	keyList.add(project_key);
		    }
		    else if(maidi.equals("1")){
		    	project_key="最新项目";
		    	keyList.add(project_key);
		    }
		    else if(daxue.equals("1")){
		    	project_key="大学附近";
		    	keyList.add(project_key);
		    }
		    else if(xianfang.equals("1")){
		    	project_key="现房项目";
		    }
		    else if(traffic.equals("1")){
		    	project_key="轨道交通";
		    	keyList.add(project_key);
		    }
		    else{
		    	project_key="";
		    }
		   
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs != null){   // 鍏抽棴璁板綍闆�   
		        try{   
		            rs.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		          }   
		      if(stmt != null){   // 鍏抽棴澹版槑   
		        try{   
		            stmt.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		     } 
		      if(pstmt != null){   // 鍏抽棴澹版槑   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return  keyList.size()>2?keyList.subList(0, 2):keyList;
	}
	
	
	public List<BingMapVo> filterByHouseType(int type){
		NumberFormat nf = new DecimalFormat("#,###,###");
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String housetype=null;
		switch(type)
		{
		case 1:
			housetype="鍏瘬";
			break;
		case 2:
			housetype="鍒";
			break;
		case 3:
			housetype="鑱旀帓鍒";
			break;
		}
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		try {
			String sql = "select t.id,t.project_num,t.project_name,t.project_address,t.project_type,t.project_price_qi,t.project_price,t.project_min_price,t.project_high_price,t.mianji,t.project_img,t.project_lan_cn,t.project_high_price as maxPrice,t.project_min_price as minprice,t.max_area as maxarea,t.min_area as minarea,t.mianji,t.project_sales_remain,t.return_money,t.project_price_int_qi from house_project t where t.project_type= '"+housetype+"'";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_img=null;
		    String project_num=null;
		    String project_address=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    String project_price=null;//锟斤拷要锟侥讹拷
		    String project_price_qi=null;
		    String project_min_price=null;
		    String project_high_price=null;
		    String mianji="骞崇背";
		    int maxarea=0;
		    int minarea=0;
		    String house_type=null;
		    String return_money=null; 
		   /* int project_price_int_qi=0;*/
		    String project_price_int_qi=null;
		    List<String> project_key=null;
		    String project_address_short=null;
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	
		    	if(project_num!=null && !"".equals(project_num)){
		    		List<ProjectDescImage> imageList = HouseProjectImageList(project_num);
					if(imageList!=null && imageList.size()>0){
						project_img = imageList.get(0).getName();
					}
					else{
						project_img = "";
					}
		    	}
		    	
		    	
		    	
		    	project_address=rs.getString("project_address");
		    	project_name=rs.getString("project_name");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	project_price=rs.getString("project_price_qi");//锟剿达拷锟斤拷目锟桔革拷目前锟斤拷锟斤拷锟斤拷锟侥科斤拷锟桔革拷
		    	project_price_qi=rs.getString("project_price_qi");
		    	String bijiao = rs.getString("project_price_int_qi");
		    	house_type=rs.getString("project_type");
		    	project_min_price=rs.getString("project_min_price")==null?"":nf.format(Integer.parseInt(rs.getString("project_min_price")));
		    	project_high_price=rs.getString("project_high_price")==null?"":nf.format(Integer.parseInt(rs.getString("project_high_price")));
		    	mianji=rs.getString("mianji");
		    	return_money=rs.getString("return_money");
		    	if(rs.getString("project_price_int_qi")!=null){
		    		project_price_int_qi=nf.format(Integer.parseInt(rs.getString("project_price_int_qi")));
		    	}
		    	else{
		    		project_price_int_qi="N/A";
		    	}
		    	project_key=findProjectKeyByNum(project_num);
		    	//对项目地址进行截取
		    	project_address_short=project_address.length()>40?project_address.substring(0, 40):project_address;
		    	String project_name_short = project_name.length()>20?project_name.substring(0, 20):project_name;
		        BingMapVo  bingMapVo=new BingMapVo(id,bijiao,project_name,project_img,project_num,project_address, project_name_short, project_price,minarea, maxarea, project_sales_remain, project_price_qi,house_type,project_min_price,project_high_price,mianji,return_money,project_price_int_qi,project_key,project_address_short);
		    	bingMapList.add(bingMapVo);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs != null){   // 鍏抽棴璁板綍闆�   
		        try{   
		            rs.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		          }   
		      if(stmt != null){   // 鍏抽棴澹版槑   
		        try{   
		            stmt.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		     } 
		      if(pstmt != null){   // 鍏抽棴澹版槑   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return bingMapList;
	}
	public List<BingMapVo> orderByPrice(int order){
		NumberFormat nf = new DecimalFormat("#,###,###");
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
	    String orderstr=null;
		switch(order)
		{
		case 1:
			orderstr="asc";
			break;
		case 2:
			orderstr="desc";
			break;
		}
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		try {
			String sql = "select t.id,t.project_num,t.project_name,t.project_address,t.project_type,t.project_price_qi,t.project_price,t.project_min_price,t.project_high_price,t.mianji,t.project_img,t.project_lan_cn,t.project_high_price as maxPrice,t.project_min_price as minprice,t.max_area as maxarea,t.min_area as minarea,t.mianji,t.project_sales_remain,t.return_money,t.project_price_int_qi from house_project t order by t.project_price_int_qi "+orderstr;
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_img=null;
		    String project_num=null;
		    String project_address=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    String project_price=null;//锟斤拷要锟侥讹拷
		    String project_price_qi=null;
		    String project_min_price=null;
		    String project_high_price=null;
		    String mianji="骞崇背";
		    int maxarea=0;
		    int minarea=0;
		    String house_type=null;
		    String return_money=null; 
		   /* int project_price_int_qi=0;*/
		    String project_price_int_qi=null;
		    List<String> project_key=null;
		    String project_address_short=null;
		    while(rs.next()){
		    	id=rs.getInt("id");
		    
		    	project_num=rs.getString("project_num");
		    	
		    	if(project_num!=null && !"".equals(project_num)){
		    		List<ProjectDescImage> imageList = HouseProjectImageList(project_num);
					if(imageList!=null && imageList.size()>0){
						project_img = imageList.get(0).getName();
					}
					else{
						project_img = "";
					}
		    	}
		    	
		    	
		    	
		    	project_address=rs.getString("project_address");
		    	project_name=rs.getString("project_name");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	project_price=rs.getString("project_price_qi");//锟剿达拷锟斤拷目锟桔革拷目前锟斤拷锟斤拷锟斤拷锟侥科斤拷锟桔革拷
		    	project_price_qi=rs.getString("project_price_qi");
		    	house_type=rs.getString("project_type");
		    	project_min_price=rs.getString("project_min_price")==null?"N/A":nf.format(Integer.parseInt(rs.getString("project_min_price")));
		    	project_high_price=rs.getString("project_high_price")==null?"N/A":nf.format(Integer.parseInt(rs.getString("project_high_price")));
		    	mianji=rs.getString("mianji");
		        return_money=rs.getString("return_money"); 
		        String bijiao = rs.getString("project_price_int_qi");
		        if(rs.getString("project_price_int_qi")!=null){
		        	project_price_int_qi=nf.format(Integer.parseInt(rs.getString("project_price_int_qi")));
		    	}
		    	else{
		    		project_price_int_qi="N/A";
		    	}
		        project_key=findProjectKeyByNum(project_num);
		      //对项目地址进行截取
		    	project_address_short=project_address.length()>40?project_address.substring(0, 40):project_address;
		    	String project_name_short = project_name.length()>20?project_name.substring(0, 20):project_name;
		        BingMapVo  bingMapVo=new BingMapVo(id,bijiao,project_name,project_img,project_num,project_address, project_name_short, project_price,minarea, maxarea, project_sales_remain, project_price_qi,house_type,project_min_price,project_high_price,mianji,return_money,project_price_int_qi,project_key,project_address_short);
		    	bingMapList.add(bingMapVo);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs != null){   // 鍏抽棴璁板綍闆�   
		        try{   
		            rs.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		          }   
		      if(stmt != null){   // 鍏抽棴澹版槑   
		        try{   
		            stmt.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		     } 
		      if(pstmt != null){   // 鍏抽棴澹版槑   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return bingMapList;
	}
	
	
	
	public List<BingMapVo> orderByTypeLeft(String housetype){
		NumberFormat nf = new DecimalFormat("#,###,###");
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
	    String orderstr=null;
		
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		try {
			String sql = "select t.id,t.project_num,t.project_name,t.project_address,t.project_type,t.project_price_qi,t.project_price,t.project_min_price,t.project_high_price,t.mianji,t.project_img,t.project_lan_cn,t.project_high_price as maxPrice,t.project_min_price as minprice,t.max_area as maxarea,t.min_area as minarea,t.mianji,t.project_sales_remain,t.return_money,t.project_price_int_qi from house_project t ";
			if(!housetype.equals("") ){
				sql += "where project_type = '"+housetype+"'";
			}
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_img=null;
		    String project_num=null;
		    String project_address=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    String project_price=null;//锟斤拷要锟侥讹拷
		    String project_price_qi=null;
		    String project_min_price=null;
		    String project_high_price=null;
		    String mianji="骞崇背";
		    int maxarea=0;
		    int minarea=0;
		    String house_type=null;
		    String return_money=null; 
		   /* int project_price_int_qi=0;*/
		    String project_price_int_qi=null;
		    List<String> project_key=null;
		    String project_address_short=null;
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	project_img=rs.getString("project_img");
		    	project_num=rs.getString("project_num");
		    	
		    	if(project_num!=null && !"".equals(project_num)){
		    		List<ProjectDescImage> imageList = HouseProjectImageList(project_num);
					if(imageList!=null && imageList.size()>0){
						project_img = imageList.get(0).getName();
					}
					else{
						project_img = "";
					}
		    	}
		    	
		    	
		    	
		    	project_address=rs.getString("project_address");
		    	project_name=rs.getString("project_name");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	project_price=rs.getString("project_price_qi");//锟剿达拷锟斤拷目锟桔革拷目前锟斤拷锟斤拷锟斤拷锟侥科斤拷锟桔革拷
		    	project_price_qi=rs.getString("project_price_qi");
		    	house_type=rs.getString("project_type");
		    	project_min_price=rs.getString("project_min_price")==null?"":nf.format(Integer.parseInt(rs.getString("project_min_price")));
		    	project_high_price=rs.getString("project_high_price")==null?"":nf.format(Integer.parseInt(rs.getString("project_high_price")));
		    	mianji=rs.getString("mianji");
		        return_money=rs.getString("return_money"); 
		        if(rs.getString("project_price_int_qi")!=null){
		        	project_price_int_qi=nf.format(Integer.parseInt(rs.getString("project_price_int_qi")));
		    	}
		    	else{
		    		project_price_int_qi="0";
		    	}
		        project_key=findProjectKeyByNum(project_num);
		        String bijiao = rs.getString("project_price_int_qi");
		        //对项目地址进行截取
		    	project_address_short=project_address.length()>40?project_address.substring(0, 40):project_address;
		    	String project_name_short = project_name.length()>20?project_name.substring(0, 20):project_name;
		        BingMapVo  bingMapVo=new BingMapVo(id,bijiao,project_name,project_img,project_num,project_address, project_name_short, project_price,minarea, maxarea, project_sales_remain, project_price_qi,house_type,project_min_price,project_high_price,mianji,return_money,project_price_int_qi,project_key,project_address_short);
		    	bingMapList.add(bingMapVo);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs != null){   // 鍏抽棴璁板綍闆�   
		        try{   
		            rs.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		          }   
		      if(stmt != null){   // 鍏抽棴澹版槑   
		        try{   
		            stmt.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		     } 
		      if(pstmt != null){   // 鍏抽棴澹版槑   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return bingMapList;
	}
	
	
	//缁忕含搴﹀強鍏剁浉鍏充俊鎭�
	public List<HouseProject> listMap(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<HouseProject> coordinatesList=new ArrayList<HouseProject>();
		try {
			String sql = "SELECT * FROM `house_project` WHERE gps!='' and gps like '%,%' and isSeen=1";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
		    while(rs.next()){
		    	HouseProject coordinates=new HouseProject();
		    	coordinates.setId(rs.getInt("id"));
		    	coordinates.setGps(rs.getString("gps"));
		    	coordinates.setProject_name(rs.getString("project_name"));
		    	
		    	coordinates.setProject_num(rs.getString("project_num"));
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
		    	
		    	coordinates.setProject_img(project_img);
				
		    	coordinates.setProject_price(rs.getString("project_price"));
		    	
		    	coordinates.setProject_min_price(rs.getString("project_min_price"));
		    	coordinates.setProject_high_price(rs.getString("project_high_price"));
		    	coordinates.setProject_zhou(rs.getString("project_zhou"));
		    	coordinates.setProject_city(rs.getString("project_city"));
		    	coordinates.setProject_nation(rs.getString("project_nation"));
		    	coordinates.setProject_area(rs.getString("project_area"));
		    	coordinates.setProject_price_int_qi(rs.getInt("project_price_int_qi"));
		    	coordinates.setProject_type(rs.getString("project_type"));
		    	coordinatesList.add(coordinates);
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs != null){   // 鍏抽棴璁板綍闆�   
		        try{   
		            rs.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		          }   
		      if(stmt != null){   // 鍏抽棴澹版槑   
		        try{   
		            stmt.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		     } 
		      if(pstmt != null){   // 鍏抽棴澹版槑   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return coordinatesList;
	} 
	//查找地图中心点
	public List<BingMapCenter> listMapCenter(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<BingMapCenter> mapCenterList=new ArrayList<BingMapCenter>();
		try {
			String sql = "SELECT * FROM `bingmap_center` WHERE gps!='' and gps like '%,%'";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
		    while(rs.next()){
		    	BingMapCenter mapCenter=new BingMapCenter();
		    	mapCenter.setId(rs.getInt("id"));
		    	mapCenter.setGps(rs.getString("gps"));
		    	mapCenter.setName(rs.getString("name"));
		    	mapCenter.setType(rs.getString("type"));
		    	mapCenterList.add(mapCenter);
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs != null){   // 鍏抽棴璁板綍闆�   
		        try{   
		            rs.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		          }   
		      if(stmt != null){   // 鍏抽棴澹版槑   
		        try{   
		            stmt.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		     } 
		      if(pstmt != null){   // 鍏抽棴澹版槑   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return mapCenterList;
	} 
	
	public List<HouseProject> filterByHouseType2(int type, int order){    //根据类型查找
		NumberFormat nf = new DecimalFormat("#,###,###");
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<HouseProject> coordinatesList=new ArrayList<HouseProject>();
		try {
			String housetype=null;
			switch(type)
			{
			case 1:
				housetype="公寓";
				break;
			case 2:
				housetype="别墅";
				break;
			case 3:
				housetype="联排别墅";
				break;
			default:
				housetype="";
				break;
			}
			String sql = "SELECT * FROM `house_project` WHERE gps!='' and gps like '%,%' and isSeen=1 ";
			if(!housetype.equals("")){
				if(order==1){
					sql += "and project_type = '"+housetype+"' order by project_price_int_qi";
				}
				else if(order == 2){
					sql += "and project_type = '"+housetype+"' order by project_price_int_qi desc";
				}
				else{
					sql += "and project_type = '"+housetype+"'";
				}
			}
			else{
				if(order==1){
					sql += "order by project_price_int_qi";
				}
				else if(order == 2){
					sql += "order by project_price_int_qi desc";
				}
				
			}
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
		    	HouseProject coordinates=new HouseProject();
		    	String project_num=rs.getString("project_num");
		    	coordinates.setId(rs.getInt("id"));
		    	coordinates.setGps(rs.getString("gps"));
		    	coordinates.setProject_name(rs.getString("project_name"));
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

		    	coordinates.setProject_img(project_img);
		    	coordinates.setProject_price(rs.getString("project_price"));
		    	coordinates.setProject_num(rs.getString("project_num"));
		    	coordinates.setProject_min_price(rs.getString("project_min_price")==null?"N/A":nf.format(Integer.parseInt(rs.getString("project_min_price"))));
		    	coordinates.setProject_high_price(rs.getString("project_high_price")==null?"N/A":nf.format(Integer.parseInt(rs.getString("project_high_price"))));
		    	coordinates.setMinPrice(rs.getString("project_min_price")==null?"N/A":nf.format(Integer.parseInt(rs.getString("project_min_price"))));
		    	coordinates.setMaxPrice(rs.getString("project_high_price")==null?"N/A":nf.format(Integer.parseInt(rs.getString("project_high_price"))));
		    	coordinates.setProject_zhou(rs.getString("project_zhou"));
		    	coordinates.setProject_city(rs.getString("project_city"));
		    	coordinates.setProject_nation(rs.getString("project_nation"));	    	
		    	coordinates.setProject_address(rs.getString("project_address"));
		    	coordinates.setBijiao(rs.getString("project_price_int_qi"));
		    	
		    	String project_address = rs.getString("project_address")==null?"":rs.getString("project_address");
		    	String project_address_short = "";
		    	if(project_address!=null && !"".equals(project_address)){
		    		project_address_short = project_address.length()>40 ? project_address.substring(0,40):project_address;
		    	}
		    	coordinates.setProject_address_short(project_address_short);
		    	
		    	String project_name = rs.getString("project_name")==null?"":rs.getString("project_name");
		    	String project_name_short = "";
		    	if(project_name!=null && !"".equals(project_name)){
		    		project_name_short = project_name.length()>40 ? project_name.substring(0,40):project_name;
		    	}
		    	coordinates.setProject_name_short(project_name_short);
		    	
		    	coordinates.setProject_area(rs.getString("project_area"));
		    	coordinates.setProject_price_int_qi(rs.getInt("project_price_int_qi"));
		    	coordinates.setProject_type(rs.getString("project_type"));
		    	
		    	coordinates.setProject_sales_remain(rs.getInt("project_sales_remain"));
		    	coordinates.setMax_area(rs.getInt("max_area"));
		    	coordinates.setMin_area(rs.getInt("min_area"));
		    	coordinates.setMinArea(rs.getInt("min_area"));
		    	coordinates.setMaxArea(rs.getInt("max_area"));
		    	coordinates.setProject_price_qi(("project_price_qi"));//锟剿达拷锟斤拷目锟桔革拷目前锟斤拷锟斤拷锟斤拷锟侥科斤拷锟桔革拷
		    	coordinates.setProject_type(rs.getString("project_type"));
		    	coordinates.setMianji(rs.getString("mianji"));
		    	coordinates.setReturn_money(rs.getString("return_money"));
		    	if(rs.getString("project_price_int_qi")!=null){    //起价
		    		int temp = Integer.parseInt(rs.getString("project_price_int_qi"));
		        	coordinates.setProject_price_int_qi(temp);
		    	}
		    	else{
		    		coordinates.setProject_price_int_qi(0);
		    	}
		    	if(rs.getString("project_price_int_qi")!=null){
		    		String project_price_int_qi=nf.format(Integer.parseInt(rs.getString("project_price_int_qi")));
		    		coordinates.setProject_price_int_qi_str(project_price_int_qi);
		    	}
		    	else{
		    		coordinates.setProject_price_int_qi_str("N/A");
		    	}
		    	
		    	//获取项目关键字，根据项目编号查找项目关键字
		    	List<String> project_key=findProjectKeyByNum(project_num);
		    	coordinates.setProject_key(project_key);
		    	
		    	
		    	coordinatesList.add(coordinates);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs != null){   // 鍏抽棴璁板綍闆�   
		        try{   
		            rs.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		          }   
		      if(stmt != null){   // 鍏抽棴澹版槑   
		        try{   
		            stmt.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		     } 
		      if(pstmt != null){   // 鍏抽棴澹版槑   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return coordinatesList;
	}
	/*public List<HouseProject> filterByKeyWord(String key,int order){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql=null;
		List<HouseProject> coordinatesList=new ArrayList<HouseProject>();
		try {
			 if(key.contains(",")){
				 sql = "SELECT * FROM `house_project` WHERE gps!='' and gps like '%,%' and isSeen=1 and project_address=? ";
				 if(order==1){
					  sql+="order by project_price_int_qi";
				  }
				  else if(order==2){
					  sql+="order by project_price_int_qi desc";
				  }
			 }else if(key.contains("")){
				 sql = "SELECT * FROM `house_project` WHERE gps!='' and gps like '%,%' and isSeen=1 and project_city=? ";
				 if(order==1){
					  sql+="order by project_price_int_qi";
				  }
				  else if(order==2){
					  sql+="order by project_price_int_qi desc";
				  }
			 }else if("".equals(key)){
				 sql = "SELECT * FROM `house_project` WHERE gps!='' and gps like '%,%' and isSeen=1";
				 if(order==1){
					  sql+="order by project_price_int_qi";
				  }
				  else if(order==2){
					  sql+="order by project_price_int_qi desc";
				  }
			 }
			  pstmt = con.prepareStatement(sql);
			  pstmt.setString(1, key);
			  rs = pstmt.executeQuery();
			while(rs.next()){
		    	HouseProject coordinates=new HouseProject();
		    	coordinates.setId(rs.getInt("id"));
		    	coordinates.setGps(rs.getString("gps"));
		    	coordinates.setProject_name(rs.getString("project_name"));
		    	coordinates.setProject_img(rs.getString("project_img"));
		    	coordinates.setProject_price(rs.getString("project_price"));
		    	coordinates.setProject_num(rs.getString("project_num"));
		    	coordinates.setProject_min_price(rs.getString("project_min_price"));
		    	coordinates.setProject_high_price(rs.getString("project_high_price"));
		    	coordinates.setProject_zhou(rs.getString("project_zhou"));
		    	coordinates.setProject_city(rs.getString("project_city"));
		    	coordinates.setProject_nation(rs.getString("project_nation"));
		    	coordinates.setProject_area(rs.getString("project_area"));
		    	coordinates.setProject_price_int_qi(rs.getInt("project_price_int_qi"));
		    	
		    	coordinates.setMax_area(rs.getInt("max_area"));
		    	coordinates.setMin_area(rs.getInt("min_area"));
		    	coordinates.setProject_type(rs.getString("project_type"));
		    	coordinates.setProject_address(rs.getString("project_address"));
		    	coordinates.setMianji(rs.getString("mianji"));
		    	coordinates.setReturn_money(rs.getString("return_money"));
		    	coordinatesList.add(coordinates);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs != null){   // 鍏抽棴璁板綍闆�   
		        try{   
		            rs.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		          }   
		      if(stmt != null){   // 鍏抽棴澹版槑   
		        try{   
		            stmt.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		     } 
		      if(pstmt != null){   // 鍏抽棴澹版槑   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return coordinatesList;
	}*/
	public List<HouseProject> filterByKeyWord(String area,String city,String addr,int order){
		NumberFormat nf = new DecimalFormat("#,###,###");
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
        String sql=null;
		List<HouseProject> coordinatesList=new ArrayList<HouseProject>();
		try {
			  if(!"".equals(area)&&!"".equals(city)&&!"".equals(addr)){
				  sql = "SELECT * FROM `house_project` WHERE gps!='' and gps like '%,%' and isSeen=1 and project_area=? and project_city=? and project_address like ?";
				  if(order==1){
					  sql+="order by project_price_int_qi";
				  }
				  else if(order==2){
					  sql+="order by project_price_int_qi desc";
				  }
				  pstmt = con.prepareStatement(sql);
				  pstmt.setString(1, area);
				  pstmt.setString(2, city);
				  pstmt.setString(3, "%"+addr);
			  }
			  else if(!"".equals(area)&&"".equals(city)&&"".equals(addr)){
				  sql = "SELECT * FROM `house_project` WHERE gps!='' and gps like '%,%' and isSeen=1 and project_area=? ";
				  if(order==1){
					  sql+="order by project_price_int_qi";
				  }
				  else if(order==2){
					  sql+="order by project_price_int_qi desc";
				  }
				  pstmt = con.prepareStatement(sql);
				  pstmt.setString(1, area);
			  }
			  else if("".equals(area)&&!"".equals(city)&&"".equals(addr)){
					  sql = "SELECT * FROM `house_project` WHERE gps!='' and gps like '%,%' and isSeen=1 and project_city=? ";
					  if(order==1){
						  sql+="order by project_price_int_qi";
					  }
					  else if(order==2){
						  sql+="order by project_price_int_qi desc";
					  }
					  pstmt = con.prepareStatement(sql);
					  pstmt.setString(1, city);
			  }
			  else if("".equals(area)&&"".equals(city)&&!"".equals(addr)){
						  sql = "SELECT * FROM `house_project` WHERE gps!='' and gps like '%,%' and isSeen=1 and project_address like ?";
						  if(order==1){
							  sql+="order by project_price_int_qi";
						  }
						  else if(order==2){
							  sql+="order by project_price_int_qi desc";
						  }
						  pstmt = con.prepareStatement(sql);
						  pstmt.setString(1, "%"+addr);
						  }
			  else if(!"".equals(area)&&!"".equals(city)&&"".equals(addr)){
							  sql = "SELECT * FROM `house_project` WHERE gps!='' and gps like '%,%' and isSeen=1 and project_area=? and project_city=? ";
							  if(order==1){
								  sql+="order by project_price_int_qi";
							  }
							  else if(order==2){
								  sql+="order by project_price_int_qi desc";
							  }
							  pstmt = con.prepareStatement(sql);
							  pstmt.setString(1, area);
							  pstmt.setString(2, city);
							  }
			  else if(!"".equals(area)&&"".equals(city)&&!"".equals(addr)){
								  sql = "SELECT * FROM `house_project` WHERE gps!='' and gps like '%,%' and isSeen=1 and project_area=? and project_address like ?";
								  if(order==1){
									  sql+="order by project_price_int_qi";
								  }
								  else if(order==2){
									  sql+="order by project_price_int_qi desc";
								  }
								  pstmt = con.prepareStatement(sql);
								  pstmt.setString(1, area);
								  pstmt.setString(2, "%"+addr);
								  }
			  else if("".equals(area)&&!"".equals(city)&&!"".equals(addr)){
									  sql = "SELECT * FROM `house_project` WHERE gps!='' and gps like '%,%' and isSeen=1 and project_city=? and project_address like ?";
									  if(order==1){
										  sql+="order by project_price_int_qi";
									  }
									  else if(order==2){
										  sql+="order by project_price_int_qi desc";
									  }
									  pstmt = con.prepareStatement(sql);
									  pstmt.setString(1, city);
									  pstmt.setString(2, "%"+addr);
									  }
			  else{
						sql = "SELECT * FROM `house_project` WHERE gps!='' and gps like '%,%' and isSeen=1 ";
										  if(order==1){
											  sql+="order by project_price_int_qi";
										  }
										  else if(order==2){
											  sql+="order by project_price_int_qi desc";
										  }
										  pstmt = con.prepareStatement(sql);
									  }

			rs = pstmt.executeQuery();
			while(rs.next()){
				DecimalFormat df = new DecimalFormat("#,###,###");
		    	HouseProject coordinates=new HouseProject();
		    	coordinates.setId(rs.getInt("id"));
		    	coordinates.setGps(rs.getString("gps"));
		    	coordinates.setProject_name(rs.getString("project_name"));
		    	coordinates.setProject_img(rs.getString("project_img"));
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
		    	
		    	coordinates.setProject_img(project_img);
		    	coordinates.setProject_price(rs.getString("project_price"));
		    	coordinates.setProject_num(rs.getString("project_num"));
		    	coordinates.setProject_min_price(rs.getString("project_min_price")==null?"N/A":df.format(Integer.parseInt(rs.getString("project_min_price"))));
		    	coordinates.setProject_high_price(rs.getString("project_high_price")==null?"N/A":df.format(Integer.parseInt(rs.getString("project_high_price"))));
		    	coordinates.setMinPrice(rs.getString("project_min_price")==null?"N/A":df.format(Integer.parseInt(rs.getString("project_min_price"))));
		    	coordinates.setMaxPrice(rs.getString("project_high_price")==null?"N/A":df.format(Integer.parseInt(rs.getString("project_high_price"))));
		    	coordinates.setProject_zhou(rs.getString("project_zhou"));
		    	coordinates.setProject_city(rs.getString("project_city"));
		    	coordinates.setProject_nation(rs.getString("project_nation"));
		    	coordinates.setProject_area(rs.getString("project_area"));
		    	coordinates.setBijiao(rs.getString("project_price_int_qi"));
		    	
		    	coordinates.setMax_area(rs.getInt("max_area"));
		    	coordinates.setMin_area(rs.getInt("min_area"));
		    	coordinates.setMinArea(rs.getInt("min_area"));
		    	coordinates.setMaxArea(rs.getInt("max_area"));
		    	coordinates.setProject_type(rs.getString("project_type"));
		    	coordinates.setProject_address(rs.getString("project_address"));
		    	coordinates.setMianji(rs.getString("mianji"));
		    	coordinates.setReturn_money(rs.getString("return_money"));
		        if(rs.getString("project_price_int_qi")!=null){
		        	coordinates.setProject_price_qi(df.format(Integer.parseInt(rs.getString("project_price_int_qi"))));
		    	}
		    	else{
		    		coordinates.setProject_price_qi("N/A");
		    	}
		        if(rs.getString("project_price_int_qi")!=null){
		    		String project_price_int_qi=nf.format(Integer.parseInt(rs.getString("project_price_int_qi")));
		    		coordinates.setProject_price_int_qi_str(project_price_int_qi);
		    	}
		    	else{
		    		coordinates.setProject_price_int_qi_str("N/A");
		    	}
		        //String project_key=findProjectKeyByNum(project_num);
		        String project_address = rs.getString("project_address")==null?"":rs.getString("project_address");
		    	String project_address_short = "";
		    	if(project_address!=null && !"".equals(project_address)){
		    		project_address_short = project_address.length()>40 ? project_address.substring(0,40):project_address;
		    	}
		    	coordinates.setProject_address_short(project_address_short);
		    	
		    	String project_name = rs.getString("project_name")==null?"":rs.getString("project_name");
		    	String project_name_short = "";
		    	if(project_name!=null && !"".equals(project_name)){
		    		project_name_short = project_name.length()>20 ? project_name.substring(0,20):project_name;
		    	}
		    	coordinates.setProject_name_short(project_name_short);
		    	
		    	
		    	//获取项目关键字，根据项目编号查找项目关键字
		    	List<String> project_key=findProjectKeyByNum(project_num);
		    	coordinates.setProject_key(project_key);
		    	
		    	coordinatesList.add(coordinates);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs != null){   // 鍏抽棴璁板綍闆�   
		        try{   
		            rs.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		          }   
		      if(stmt != null){   // 鍏抽棴澹版槑   
		        try{   
		            stmt.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		     } 
		      if(pstmt != null){   // 鍏抽棴澹版槑   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return coordinatesList;
	}
	public List<HouseProject> filterByproNum(String pro){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		List<HouseProject> coordinatesList=new ArrayList<HouseProject>();
		try {
			String sql = "SELECT * FROM `house_project` WHERE gps!='' and project_num = '"+pro+"'";
			  stmt = con.createStatement();
			  rs = stmt.executeQuery(sql);
			while(rs.next()){
		    	HouseProject coordinates=new HouseProject();
		    	coordinates.setId(rs.getInt("id"));
		    	coordinates.setGps(rs.getString("gps"));
		    	coordinates.setProject_name(rs.getString("project_name"));
		    	
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
		    	coordinates.setProject_img(project_img);
		    	coordinates.setProject_price(rs.getString("project_price"));
		    	coordinates.setProject_num(rs.getString("project_num"));
		    	coordinates.setProject_min_price(rs.getString("project_min_price"));
		    	coordinates.setProject_high_price(rs.getString("project_high_price"));
		    	coordinates.setProject_zhou(rs.getString("project_zhou"));
		    	coordinates.setProject_city(rs.getString("project_city"));
		    	coordinates.setProject_nation(rs.getString("project_nation"));
		    	coordinates.setProject_area(rs.getString("project_area"));
		    	coordinates.setProject_price_int_qi(rs.getInt("project_price_int_qi"));
		    	coordinates.setProject_type(rs.getString("project_type"));
		    	coordinatesList.add(coordinates);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(rs != null){   // 鍏抽棴璁板綍闆�   
		        try{   
		            rs.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		          }   
		      if(stmt != null){   // 鍏抽棴澹版槑   
		        try{   
		            stmt.close() ;   
		        }catch(SQLException e){   
		            e.printStackTrace() ;   
		        }   
		     } 
		      if(pstmt != null){   // 鍏抽棴澹版槑   
			        try{   
			            pstmt.close() ;   
			        }catch(SQLException e){   
			            e.printStackTrace() ;   
			        }   
			     } 

        }
		return coordinatesList;
	}
	//得到区域、城市、邮编联合字段
	public List<String> getKeyWord(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> keyWordSet=new ArrayList<String>();
		try {
			String sql ="select distinct area_name,area_city,area_postcode from area_info order by area_name";
			 pstmt = con.prepareStatement(sql);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				String areaName=rs.getString("area_name");
				String cityName=rs.getString("area_city");
				String postCode=rs.getString("area_postcode");
				String keyWord;
				if("".equals(areaName)&&"".equals(cityName)&&"".equals(postCode)){
					keyWord="";
				}else{
				keyWord=areaName+","+cityName+","+postCode;
				}
				keyWordSet.add(keyWord);
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
		return keyWordSet;
	}
	//得到区域名称
	public List<String> getAreaName(){
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<String> areaNameSet=new ArrayList<String>();
		try {
			String sql ="select distinct area_name,area_city,area_postcode from area_info order by area_name";
			 pstmt = con.prepareStatement(sql);
			  rs = pstmt.executeQuery();
			while(rs.next()){
				String areaName=rs.getString("area_name");
				String cityName=rs.getString("area_city");
				String postCode=rs.getString("area_postcode");
				String keyWord;
				if("".equals(areaName)&&"".equals(cityName)&&"".equals(postCode)){
					keyWord="";
				}else{
				keyWord=areaName+","+cityName+","+postCode;
				}
				areaNameSet.add(keyWord);
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
		return areaNameSet;
	}
	//得到城市名称
		public List<String> getCityName(){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			List<String> cityNameSet=new ArrayList<String>();
			try {
				String sql ="select distinct area_name,area_city,area_postcode from area_info order by area_city";
				 pstmt = con.prepareStatement(sql);
				  rs = pstmt.executeQuery();
				while(rs.next()){
					String areaName=rs.getString("area_name");
					String cityName=rs.getString("area_city");
					String postCode=rs.getString("area_postcode");
					String keyWord;
					if("".equals(areaName)&&"".equals(cityName)&&"".equals(postCode)){
						keyWord="";
					}else{
					keyWord=cityName+","+areaName+","+postCode;
					}
					cityNameSet.add(keyWord);
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
			return cityNameSet;
		}
		//得到地址名称
		public List<String> getAddressName(){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			List<String> addressNameSet=new ArrayList<String>();
			try {
				String sql ="select distinct area_name,area_city,area_postcode from area_info order by area_postcode";
				 pstmt = con.prepareStatement(sql);
				  rs = pstmt.executeQuery();
				while(rs.next()){
					String areaName=rs.getString("area_name");
					String cityName=rs.getString("area_city");
					String postCode=rs.getString("area_postcode");
					String keyWord;
					if("".equals(areaName)&&"".equals(cityName)&&"".equals(postCode)){
						keyWord="";
					}else{
					keyWord=postCode+","+areaName+","+cityName;
					}
					addressNameSet.add(keyWord);
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
			return addressNameSet;
		}
		//地图中心点录入
		public boolean InsertMapCenter(String name,String gps,String type){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
	        boolean flag=true;
			try {
				String sql = "insert into bingmap_center(name,gps,type) values(?,?,?)";
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, name);
				pstmt.setString(2, gps);
				pstmt.setString(3, type);
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
		
		//地图中心点列表
		public JSONArray selectMapCenterList(){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			JSONArray jsonArray=new JSONArray();
			try {
				String sql = " select * from bingmap_center";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
				while(rs.next()){
					JSONObject obj = new JSONObject();
					obj.put("id", rs.getInt("id"));
					obj.put("name", rs.getString("name"));
					obj.put("type", rs.getString("type"));
					obj.put("gps", rs.getString("gps"));
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
		//地图中心点删除
		public boolean deleteMapCenter(int id){
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;	
			boolean flag=true;
			try {
				String sql = "delete from bingmap_center where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
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
}
