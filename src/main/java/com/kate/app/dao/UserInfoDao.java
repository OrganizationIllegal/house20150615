package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.User;

@Repository 
public class UserInfoDao extends BaseDao {
	
	//鍒ゆ柇鐢ㄦ埛
		public List<User> judge(String username) throws SQLException{
			List<User> list = new ArrayList<User>();
			try{
				String sql = "select * from user where email=? or tel=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, username);
				ResultSet rs = pstmt.executeQuery();
				int id=0;
				String pwd=null;
				String email=null;
				String tel=null;
				int role=0;
				while(rs.next()){
					id = rs.getInt("id");
					pwd = rs.getString("pwd");
					email = rs.getString("email");
					tel = rs.getString("tel");
					role = rs.getInt("role");
					User data = new User(username, pwd, email, tel, role);
					list.add(data);
				}
				
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
	        
		}
		
		public List<User> judgeEmail(String userEmail) throws SQLException{
			List<User> list = new ArrayList<User>();
			try{
				String sql = "select * from user where email=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userEmail);
				ResultSet rs = pstmt.executeQuery();
				int id=0;
				String pwd=null;
				String email=null;
				String tel=null;
				int role=0;
				while(rs.next()){
					id = rs.getInt("id");
					pwd = rs.getString("pwd");
					email = rs.getString("email");
					tel = rs.getString("tel");
					role = rs.getInt("role");
					User data = new User(username, pwd, email, tel, role);
					list.add(data);
				}
				
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
	        
		}
		
		
		//鐢ㄦ埛淇敼瀵嗙爜
				public boolean changePass(String username,String passNew) throws SQLException{
					boolean flag = true;
					try{
						String sql = "update user set pwd=? where nick_name=?" ;
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, passNew);
						pstmt.setString(2, username);
						int result = pstmt.executeUpdate();
						if(result == 0){
							flag = false;
						}
						
					}catch (Exception e) {
			            e.printStackTrace();
			        }
					return flag;
			        
				}
				
	
	
	
	//寮�珛璐︽埛
	public int addAccount(String nick_name,String pwd,String tel,String email,String account,String msg) throws SQLException{
		int exeResult=0;
		try{
			String sql = " insert into user(nick_name, pwd, tel, email, account, msg) values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nick_name);
			pstmt.setString(2, pwd);
			pstmt.setString(3, tel);
			pstmt.setString(4, email);
			pstmt.setString(5, account);
			pstmt.setString(6, msg);
			exeResult = pstmt.executeUpdate();
		}catch (Exception e) {
            e.printStackTrace();
        }
		return exeResult;
        
	}
	//绱㈠彇瀹屾暣浠锋牸
		public int addAllPrice(String nick_name,String pwd,String tel,String email,String allprice,String msg) throws SQLException{
			int exeResult=0;
			try{
				String sql = " insert into user(nick_name, pwd, tel, email, account, msg) values(?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, nick_name);
				pstmt.setString(2, pwd);
				pstmt.setString(3, tel);
				pstmt.setString(4, email);
				pstmt.setString(5, allprice);
				pstmt.setString(6, msg);
				exeResult = pstmt.executeUpdate();
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return exeResult;
	        
		}
		
		//闇�眰
				public int addNeed(String nick_name,String tel,String email,String need,String msg) throws SQLException{
					int exeResult=0;
					try{
						String sql = " insert into user(nick_name,tel, email, need, msg) values(?,?,?,?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, nick_name);
						pstmt.setString(2, tel);
						pstmt.setString(3, email);
						pstmt.setString(4, need);
						pstmt.setString(5, msg);
						exeResult = pstmt.executeUpdate();
					}catch (Exception e) {
			            e.printStackTrace();
			        }
					return exeResult;
			        
				}

				//璇︽儏鍜ㄨ
				public int addAsk(String nick_name,String pwd,String tel,String email,String ask,String msg) throws SQLException{
					int exeResult=0;
					try{
						String sql = " insert into user(nick_name, pwd, tel, email, ask, msg) values(?,?,?,?,?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, nick_name);
						pstmt.setString(2, pwd);
						pstmt.setString(3, tel);
						pstmt.setString(4, email);
						pstmt.setString(5, ask);
						pstmt.setString(6, msg);
						exeResult = pstmt.executeUpdate();
					}catch (Exception e) {
			            e.printStackTrace();
			        }
					return exeResult;
			        
				}
				
				//鏈�柊浠锋牸
				public int addNewestPrice(String nick_name,String pwd,String tel,String email,String newestprice,String msg) throws SQLException{
					int exeResult=0;
					try{
						String sql = " insert into user(nick_name, pwd, tel, email, newestprice, msg) values(?,?,?,?,?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, nick_name);
						pstmt.setString(2, pwd);
						pstmt.setString(3, tel);
						pstmt.setString(4, email);
						pstmt.setString(5, newestprice);
						pstmt.setString(6, msg);
						exeResult = pstmt.executeUpdate();
					}catch (Exception e) {
			            e.printStackTrace();
			        }
					return exeResult;
			        
				}
				//瀹屾暣浠锋牸
				public int addHouseType(String nick_name,String pwd,String tel,String email,String housetype,String msg) throws SQLException{
					int exeResult=0;
					try{
						String sql = " insert into user(nick_name, pwd, tel, email, housetype, msg) values(?,?,?,?,?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, nick_name);
						pstmt.setString(2, pwd);
						pstmt.setString(3, tel);
						pstmt.setString(4, email);
						pstmt.setString(5, housetype);
						pstmt.setString(6, msg);
						exeResult = pstmt.executeUpdate();
					}catch (Exception e) {
			            e.printStackTrace();
			        }
					return exeResult;
			        
				}
				//娉ㄥ唽璐︽埛
				public int register(String nick_name,String pwd,String repwd,String tel,String email) throws SQLException{
					int exeResult=0;
					try{
						String sql = " insert into user(nick_name, pwd, repwd, tel, email,role) values(?,?,?,?,?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, nick_name);
						pstmt.setString(2, pwd);
						pstmt.setString(3, repwd);
						pstmt.setString(4, tel);
						pstmt.setString(5, email);
						pstmt.setInt(6, 1);
						exeResult = pstmt.executeUpdate();
					}catch (Exception e) {
			            e.printStackTrace();
			        }
					return exeResult;
			        
				}
				
				//鎵嬫満娉ㄥ唽
				public int register1(String tel,String pwd) throws SQLException{
					int exeResult=0;
					try{
						String sql = " insert into user(tel,pwd,role) values(?,?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, tel);
						pstmt.setString(2, pwd);
						pstmt.setInt(3, 1);
						exeResult = pstmt.executeUpdate();
					}catch (Exception e) {
			            e.printStackTrace();
			        }
					return exeResult;
			        
				}
				
				//閭娉ㄥ唽
				public int register2(String email,String pwd) throws SQLException{
					int exeResult=0;
					try{
						String sql = " insert into user(email,pwd,role) values(?,?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, email);
						pstmt.setString(2, pwd);
						pstmt.setInt(3, 1);
						exeResult = pstmt.executeUpdate();
					}catch (Exception e) {
			            e.printStackTrace();
			        }
					return exeResult;
			        
				}
	
}
