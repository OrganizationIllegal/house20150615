package com.kate.app.dao;

import java.sql.Connection;
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
import com.kate.app.model.ZhiYeZhiDao;
@Repository 
public class NewsBokeDao extends BaseDao2{
	
	public int isDuplicate(String news_num){
		Statement stmt = null;Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int isexist=0;
		try {con = dataSource.getConnection();
			String sql = " SELECT count(*) num from news_boke where news_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, news_num);
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
			 try { if (rs != null) rs.close(); } catch(Exception e) { }
			 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
			 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
			 try { if (con != null) con.close(); } catch(Exception e) { }

        }
		return 0;
	}
	
	 public JSONArray listNewsBoke(){
		 Statement stmt = null;Connection con = null;

			ResultSet rs = null;
			PreparedStatement pstmt = null;
			JSONArray jsonArray=new JSONArray();
			try {con = dataSource.getConnection();

				String sql = "select * from news_boke t;";
				  stmt = con.createStatement();
				  rs = stmt.executeQuery(sql);
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
				 try { if (rs != null) rs.close(); } catch(Exception e) { }
				 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
				 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
				 try { if (con != null) con.close(); } catch(Exception e) { }

	        }
			return jsonArray;
		} 
	 public int InsertNewsBoke(String  news_num,String news_title,String news_people,String news_time,String news_fenlei,String news_abstract,String news_detail,String news_image){
		 Statement stmt = null;Connection con = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
		 int exeResult=0;
			try {con = dataSource.getConnection();
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
				 try { if (rs != null) rs.close(); } catch(Exception e) { }
				 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
				 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
				 try { if (con != null) con.close(); } catch(Exception e) { }

	        }
			return exeResult;
		}  
	 public int updateNewsBoke(int id,String  news_num,String news_title,String news_people,String news_time,String news_fenlei,String news_abstract,String news_detail,String news_image){
		 Statement stmt = null;Connection con = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
		 int exeResult=0;
			try {con = dataSource.getConnection();
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
				 try { if (rs != null) rs.close(); } catch(Exception e) { }
				 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
				 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
				 try { if (con != null) con.close(); } catch(Exception e) { }

	        }
			return exeResult;
		}
	 public int delNewsBoke(int id){
		 Statement stmt = null;Connection con = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			int exeResult=0;
			try {con = dataSource.getConnection();
				String sql = "delete from news_boke where id="+id;
				  stmt = con.createStatement();
				exeResult = stmt.executeUpdate(sql);
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
	 
	 public List<NewsBoke> getNewsBoke(int  id){
		 Statement stmt = null;
		 Connection con = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			List<NewsBoke> list=new ArrayList<NewsBoke>();
			try {
				con = dataSource.getConnection();
				String sql = " select * from news_boke where id = ?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				  rs = pstmt.executeQuery();
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
				 try { if (rs != null) rs.close(); } catch(Exception e) { }
				 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
				 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
				 try { if (con != null) con.close(); } catch(Exception e) { } 

	        }
			return list;
		}
	 
	 
	 public NewsBoke getNewsBokeByNum(String blogNum){
		 Statement stmt = null;Connection con = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			NewsBoke data=new NewsBoke();
			try {
				con = dataSource.getConnection();
				String sql = " select * from news_boke where news_num = ?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, blogNum);
				  rs = pstmt.executeQuery();
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
				 try { if (rs != null) rs.close(); } catch(Exception e) { }
				 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
				 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
				 try { if (con != null) con.close(); } catch(Exception e) { }

	        }
			return data;
		}
	 public NewsBoke getZhiyeZhidaoByNum(String zhiyeNum){
		 NewsBoke data=new NewsBoke();
		 Connection con = null;
		 Statement stmt = null; 
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				String sql = " select * from zhiye_zhidao where zhiye_num = ?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, zhiyeNum);
				 rs = pstmt.executeQuery();
				while(rs.next()){
					data.setId(rs.getInt("id"));
					data.setNews_abstract(rs.getString("zhiye_abstract"));
					data.setNews_detail(rs.getString("detail"));
					data.setNews_fenlei(rs.getString("fenlei"));
					data.setNews_image(rs.getString("image"));
					data.setNews_num(rs.getString("zhiye_num"));
					data.setNews_people(rs.getString("fabu_people"));
					data.setNews_time(rs.getTimestamp("fabu_time"));
					data.setNews_title(rs.getString("title"));
					/*data.setId(rs.getInt("id"));
					data.setDetail(rs.getString("detail"));
					data.setFabu_people(rs.getString("fabu_people"));
					data.setFabu_time(rs.getTimestamp("fabu_time"));
					data.setFenlei(rs.getString("fenlei"));
					data.setImage(rs.getString("image"));
					data.setTitle(rs.getString("title"));
					data.setZhiye_abstract(rs.getString("zhiye_abstract"));
					data.setZhiye_num(rs.getString("zhiye_num"));*/
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
			return data;
		}
	 
	 public List<String> getRecoByAreaNum(String areaNum){
		 Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Connection con = null;
			List<String> list = new ArrayList<String>();
			String reco1 = null;
			String reco2 = null;
			String reco3 = null;
			try {
				con = dataSource.getConnection();
				String sql = " select * from recommend_news where area_code = ?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, areaNum);
				  rs = pstmt.executeQuery();
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
				 try { if (rs != null) rs.close(); } catch(Exception e) { }
				 try { if (stmt != null) stmt.close(); } catch(Exception e) { }
				 try { if (pstmt != null) pstmt.close(); } catch(Exception e) { }
				 try { if (con != null) con.close(); } catch(Exception e) { }

	        }
			return list;
		}
	 
}
