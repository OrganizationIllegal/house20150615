package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.NewsBoke;
@Repository 
public class NewsBokeDao extends BaseDao{
	 public JSONArray listNewsBoke(){
		 try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			JSONArray jsonArray=new JSONArray();
			try {
				String sql = "select * from news_boke t;";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					JSONObject obj = new JSONObject();
					obj.put("id", rs.getInt("id"));
					obj.put("news_num", rs.getString("news_num"));
					obj.put("news_title", rs.getString("news_title"));
					obj.put("news_people", rs.getString("news_people"));
					obj.put("news_fenlei", rs.getString("news_fenlei"));
					obj.put("news_abstract", rs.getString("news_abstract"));
					obj.put("news_detail", rs.getString("news_detail"));
					obj.put("news_image", rs.getString("news_image"));
					
					String update_time = null;
					Timestamp time=rs.getTimestamp("news_time");
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					if(time ==null){
						time= new Timestamp(System.currentTimeMillis());
					}
				    update_time=df.format(time);
					obj.put("news_time",update_time );
					jsonArray.add(obj);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{  
	            if(pstmt != null){  
	                try {  
	                	pstmt.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if(con != null){  
	                try {  
	                    con.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }
			return jsonArray;
		} 
	 public int InsertNewsBoke(String  news_num,String news_title,String news_people,String news_time,String news_fenlei,String news_abstract,String news_detail,String news_image){
		 try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
		 int exeResult=0;
			try {
				String sql = "insert into news_boke(news_num,news_title,news_people,news_time,news_fenlei,news_abstract,news_detail,news_image) values(?,?,?,?,?,?,?,?)";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, news_num);
				pstmt.setString(2, news_title);
				pstmt.setString(3, news_people);
				pstmt.setString(4, news_time);
				pstmt.setString(5, news_fenlei);
				pstmt.setString(6, news_abstract);
				pstmt.setString(7, news_detail);
				pstmt.setString(8, news_image);
				exeResult = pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{  
	            if(pstmt != null){  
	                try {  
	                	pstmt.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if(con != null){  
	                try {  
	                    con.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }
			return exeResult;
		}  
	 public int updateNewsBoke(int id,String  news_num,String news_title,String news_people,String news_time,String news_fenlei,String news_abstract,String news_detail,String news_image){
		 try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
		 int exeResult=0;
			try {
				String sql = "update news_boke set news_num=?,news_title=?,news_people=?,news_time=?,news_fenlei=?,news_abstract=?,news_detail=?,news_image=? where id=?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, news_num);
				pstmt.setString(2, news_title);
				pstmt.setString(3, news_people);
				pstmt.setString(4, news_time);
				pstmt.setString(5, news_fenlei);
				pstmt.setString(6, news_abstract);
				pstmt.setString(7, news_detail);
				pstmt.setString(8, news_image);
				pstmt.setInt(9, id);
				exeResult = pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{  
	            if(pstmt != null){  
	                try {  
	                	pstmt.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if(con != null){  
	                try {  
	                    con.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }
			return exeResult;
		}
	 public int delNewsBoke(int id){
		 try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			int exeResult=0;
			try {
				String sql = "delete from news_boke where id="+id;
				Statement stmt = con.createStatement();
				exeResult = stmt.executeUpdate(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{  
	            if(pstmt != null){  
	                try {  
	                	pstmt.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if(con != null){  
	                try {  
	                    con.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }
			return exeResult;
		}
	 
	 public List<NewsBoke> getNewsBoke(int  id){
		 try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			List<NewsBoke> list=new ArrayList<NewsBoke>();
			try {
				String sql = " select * from news_boke where id = ?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					NewsBoke obj = new NewsBoke();
					obj.setId(rs.getInt("id"));
					obj.setNews_abstract(rs.getString("news_abstract"));
					obj.setNews_detail(rs.getString("news_detail"));
					obj.setNews_fenlei(rs.getString("news_fenlei"));
					obj.setNews_image(rs.getString("news_image"));
					obj.setNews_num(rs.getString("news_num"));
					obj.setNews_people(rs.getString("news_people"));
//					String time_str=rs.getTimestamp("news_time").toString().length()<10?rs.getTimestamp("news_time").toString():rs.getTimestamp("news_time").toString().substring(0, 10);
					obj.setNews_time(rs.getTimestamp("news_time"));
					//obj.setNews_time(time_str);
					obj.setNews_title(rs.getString("news_title"));
					list.add(obj);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{  
	            if(pstmt != null){  
	                try {  
	                	pstmt.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if(con != null){  
	                try {  
	                    con.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }
			return list;
		}
	 
	 
	 public NewsBoke getNewsBokeByNum(String blogNum){
		 try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			NewsBoke data=new NewsBoke();
			try {
				String sql = " select * from news_boke where news_num = ?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, blogNum);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					data.setId(rs.getInt("id"));
					data.setNews_abstract(rs.getString("news_abstract"));
					data.setNews_detail(rs.getString("news_detail"));
					data.setNews_fenlei(rs.getString("news_fenlei"));
					data.setNews_image(rs.getString("news_image"));
					data.setNews_num(rs.getString("news_num"));
					data.setNews_people(rs.getString("news_people"));
					data.setNews_time(rs.getTimestamp("news_time"));
					data.setNews_title(rs.getString("news_title"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{  
	            if(pstmt != null){  
	                try {  
	                	pstmt.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if(con != null){  
	                try {  
	                    con.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }

			return data;
		}
	 
	 public List<String> getRecoByAreaNum(String areaNum){
		 try{
				con = DriverManager.getConnection(url, username, password);
			}catch(Exception e){
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			List<String> list = new ArrayList<String>();
			String reco1 = null;
			String reco2 = null;
			String reco3 = null;
			try {
				String sql = " select * from recommend_news where area_code = ?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, areaNum);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					reco1 = rs.getString("reco_news_num_1");
					reco2 = rs.getString("reco_news_num_2");
					reco3 = rs.getString("reco_news_num_3");
				}
				list.add(reco1);
				list.add(reco2);
				list.add(reco3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{  
	            if(pstmt != null){  
	                try {  
	                	pstmt.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if(con != null){  
	                try {  
	                    con.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }
			return list;
		}
	 
}
