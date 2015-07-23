package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.User;

@Repository 
public class UserInfoDao extends BaseDao {
	
	//鍒ゆ柇鐢ㄦ埛
		public List<User> judge(String username1) throws SQLException{
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			List<User> list = new ArrayList<User>();
			try{
				String sql = "select * from user where email=? or tel=?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, username1);
				pstmt.setString(2, username1);
				  rs = pstmt.executeQuery();
				int id=0;
				String pwd=null;
				String email=null;
				String tel=null;
				int role=0;
				int flag = 0;
				while(rs.next()){
					id = rs.getInt("id");
					pwd = rs.getString("pwd");
					email = rs.getString("email");
					tel = rs.getString("tel");
					role = rs.getInt("role");
					flag= rs.getInt("flag");
					User data = new User(username1, pwd, email, tel, role, flag);
					list.add(data);
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
			return list;
	        
		}
		
		public List<User> judgeEmail(String userEmail) throws SQLException{
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			List<User> list = new ArrayList<User>();
			try{
				String sql = "select * from user where email=?";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userEmail);
				  rs = pstmt.executeQuery();
				int id=0;
				String pwd=null;
				String email=null;
				String tel=null;
				String nick_name = null;
				int role=0;
				int flag = 0;
				while(rs.next()){
					id = rs.getInt("id");
					pwd = rs.getString("pwd");
					email = rs.getString("email");
					tel = rs.getString("tel");
					role = rs.getInt("role");
					flag = rs.getInt("flag");
					nick_name = rs.getString("nick_name");
					User data = new User(nick_name, pwd, email, tel, role,flag);
					list.add(data);
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
			return list;
	        
		}
		
		
		//鐢ㄦ埛淇敼瀵嗙爜
				public boolean changePass(String username1,String passNew) throws SQLException{
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;

					boolean flag = true;
					try{
						String sql = "update user set pwd=? where nick_name=?" ;
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1, passNew);
						pstmt.setString(2, username1);
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
				
	
				//鍖哄煙鍒楄〃
				public JSONArray selectUserList(){
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					JSONArray jsonArray=new JSONArray();
					try {
						String sql = " select * from user";
						  stmt = con.createStatement();
						  rs = stmt.executeQuery(sql);
						while(rs.next()){
							int role = rs.getInt("role");
							int flag = rs.getInt("flag");
							JSONObject obj = new JSONObject();
							obj.put("id", rs.getInt("id"));
							obj.put("nick_name", rs.getString("nick_name"));
							//obj.put("pwd", rs.getString("pwd"));
							obj.put("email", rs.getString("email"));
							obj.put("tel", rs.getString("tel"));
							Timestamp registerTime = rs.getTimestamp("time");
							String registerTime_str="";
							String tsStr = "";  
							DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
					        try {   
					        	registerTime_str = sdf.format(registerTime);
					        	
					            System.out.println(registerTime_str);   
					        } catch (Exception e) {   
					            e.printStackTrace();   
					        }
							if(role==0 && flag==1){
								obj.put("role", "普通管理员");
							}
							else if(role==0 && flag==2){
								obj.put("role", "超级管理员");
							}
							else{
								obj.put("role", "普通用户");
							}
							obj.put("account", rs.getString("account"));
							obj.put("msg", rs.getString("msg"));
							obj.put("allprice", rs.getString("allprice"));
							obj.put("need", rs.getString("need"));
							//obj.put("ask", rs.getString("ask"));
							obj.put("newestprice", rs.getString("newestprice"));
							obj.put("housetype", rs.getString("housetype"));
							obj.put("registerTime", registerTime_str);
							//obj.put("repwd", rs.getString("repwd"));
							obj.put("flag", rs.getInt("flag"));
							
							jsonArray.add(obj);
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
					return jsonArray;
				} 
	
	//寮�珛璐︽埛
	public int addAccount(String nick_name,String pwd,String tel,String email,String account,String msg) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int exeResult=0;
		try{
			String sql = " insert into user(nick_name, pwd, tel, email, account, msg) values(?,?,?,?,?,?)";
			 pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nick_name);
			pstmt.setString(2, pwd);
			pstmt.setString(3, tel);
			pstmt.setString(4, email);
			pstmt.setString(5, account);
			pstmt.setString(6, msg);
			exeResult = pstmt.executeUpdate();
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
		return exeResult;
        
	}
	//绱㈠彇瀹屾暣浠锋牸
		public int addAllPrice(String nick_name,String pwd,String tel,String email,String allprice,String msg) throws SQLException{
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			int exeResult=0;
			try{
				String sql = " insert into user(nick_name, pwd, tel, email, account, msg) values(?,?,?,?,?,?)";
				 pstmt = con.prepareStatement(sql);
				pstmt.setString(1, nick_name);
				pstmt.setString(2, pwd);
				pstmt.setString(3, tel);
				pstmt.setString(4, email);
				pstmt.setString(5, allprice);
				pstmt.setString(6, msg);
				exeResult = pstmt.executeUpdate();
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
			return exeResult;
	        
		}
		
		//闇�眰
				public int addNeed(String nick_name,String tel,String email,String need,String msg) throws SQLException{
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					int exeResult=0;
					try{
						String sql = " insert into user(nick_name,tel, email, need, msg) values(?,?,?,?,?)";
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1, nick_name);
						pstmt.setString(2, tel);
						pstmt.setString(3, email);
						pstmt.setString(4, need);
						pstmt.setString(5, msg);
						exeResult = pstmt.executeUpdate();
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
					return exeResult;
			        
				}

				//璇︽儏鍜ㄨ
				public int addAsk(String nick_name,String pwd,String tel,String email,String ask,String msg) throws SQLException{
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					int exeResult=0;
					try{
						String sql = " insert into user(nick_name, pwd, tel, email, ask, msg) values(?,?,?,?,?,?)";
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1, nick_name);
						pstmt.setString(2, pwd);
						pstmt.setString(3, tel);
						pstmt.setString(4, email);
						pstmt.setString(5, ask);
						pstmt.setString(6, msg);
						exeResult = pstmt.executeUpdate();
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
					return exeResult;
			        
				}
				
				//鏈�柊浠锋牸
				public int addNewestPrice(String nick_name,String pwd,String tel,String email,String newestprice,String msg) throws SQLException{
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;

					int exeResult=0;
					try{
						String sql = " insert into user(nick_name, pwd, tel, email, newestprice, msg) values(?,?,?,?,?,?)";
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1, nick_name);
						pstmt.setString(2, pwd);
						pstmt.setString(3, tel);
						pstmt.setString(4, email);
						pstmt.setString(5, newestprice);
						pstmt.setString(6, msg);
						exeResult = pstmt.executeUpdate();
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
					return exeResult;
			        
				}
				//瀹屾暣浠锋牸
				public int addHouseType(String nick_name,String pwd,String tel,String email,String housetype,String msg) throws SQLException{
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					int exeResult=0;
					try{
						String sql = " insert into user(nick_name, pwd, tel, email, housetype, msg) values(?,?,?,?,?,?)";
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1, nick_name);
						pstmt.setString(2, pwd);
						pstmt.setString(3, tel);
						pstmt.setString(4, email);
						pstmt.setString(5, housetype);
						pstmt.setString(6, msg);
						exeResult = pstmt.executeUpdate();
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
					return exeResult;
			        
				}
				//娉ㄥ唽璐︽埛
				public int register(String nick_name,String pwd,String repwd,String tel,String email) throws SQLException{
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					int exeResult=0;
					String registerTime_str="";
					long currentTime = System.currentTimeMillis();
					
					Timestamp registerTime = new Timestamp(System.currentTimeMillis()); 
					DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			        try {   
			        	registerTime_str = sdf.format(registerTime);
			        	
			            System.out.println(registerTime_str);   
			        } catch (Exception e) {   
			            e.printStackTrace();   
			        }
					try{
						String sql = " insert into user(nick_name, pwd, repwd, tel, email,role,time) values(?,?,?,?,?,?,?)";
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1, nick_name);
						pstmt.setString(2, pwd);
						pstmt.setString(3, repwd);
						pstmt.setString(4, tel);
						pstmt.setString(5, email);
						pstmt.setInt(6, 1);
						pstmt.setString(5, registerTime_str);
						exeResult = pstmt.executeUpdate();
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
					return exeResult;
			        
				}
				
				//鎵嬫満娉ㄥ唽
				public int register1(String tel,String pwd) throws SQLException{
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					int exeResult=0;
					String registerTime_str="";
					long currentTime = System.currentTimeMillis();
					
					Timestamp registerTime = new Timestamp(System.currentTimeMillis()); 
					DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			        try {   
			        	registerTime_str = sdf.format(registerTime);
			        	
			            System.out.println(registerTime_str);   
			        } catch (Exception e) {   
			            e.printStackTrace();   
			        }
					try{
						String sql = " insert into user(tel,pwd,role,time) values(?,?,?,?)";
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1, tel);
						pstmt.setString(2, pwd);
						pstmt.setInt(3, 1);
						pstmt.setString(4, registerTime_str);
						exeResult = pstmt.executeUpdate();
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
					return exeResult;
			        
				}
				
				//閭娉ㄥ唽
				public int register2(String email,String pwd) throws SQLException{
					Statement stmt = null;
					ResultSet rs = null;
					PreparedStatement pstmt = null;
					int exeResult=0;
					String registerTime_str="";
					long currentTime = System.currentTimeMillis();
					
					Timestamp registerTime = new Timestamp(System.currentTimeMillis()); 
					DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			        try {   
			        	registerTime_str = sdf.format(registerTime);
			        	
			            System.out.println(registerTime_str);   
			        } catch (Exception e) {   
			            e.printStackTrace();   
			        }
					try{
						String sql = " insert into user(email,pwd,role,time) values(?,?,?,?)";
						 pstmt = con.prepareStatement(sql);
						pstmt.setString(1, email);
						pstmt.setString(2, pwd);
						pstmt.setInt(3, 1);
						pstmt.setString(4, registerTime_str);
						exeResult = pstmt.executeUpdate();
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
					return exeResult;
			        
				}
	
}
