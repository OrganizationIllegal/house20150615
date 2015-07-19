package com.kate.app.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.kate.app.model.AreaMiddle;
import com.kate.app.model.AreaZhikong;
import com.kate.app.model.AreaZujin;

@Repository 
public class AreaTrendDao extends BaseDao {
  public List<AreaMiddle> getAreaMiddleTrend(String project_type, String area_code){
	  try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
	  List<AreaMiddle> areaMiddleTrendList=new ArrayList<AreaMiddle>();
	
	  try {
			String sql = " select * from area_middle where project_type=? and area_code=? order by heng";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project_type);
			pstmt.setString(2, area_code);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				AreaMiddle data = new AreaMiddle();
				data.setArea_code(rs.getString("area_code"));
				data.setArea_id(rs.getInt("area_id"));
				data.setHeng(rs.getString("heng"));
				data.setId(rs.getInt("id"));
				
				data.setView_shunxu(rs.getInt("view_shunxu"));
				data.setZong(rs.getInt("zong"));
				areaMiddleTrendList.add(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  finally{  
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
		return areaMiddleTrendList;
  }
  
  public List<AreaZujin> getAreaZujinTrend(String project_type, String area_code){
	  try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		
	  List<AreaZujin> areaZujinTrendList=new ArrayList<AreaZujin>();
	 
	  try {
			String sql = " select * from area_zujin where project_type=? and area_code=? order by heng";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project_type);
			pstmt.setString(2, area_code);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				AreaZujin data = new AreaZujin();
				data.setArea_id(rs.getInt("area_id"));
				
				data.setHeng(rs.getString("heng"));
				data.setId(rs.getInt("id"));
				
				data.setView_shunxu(rs.getInt("view_shunxu"));
				data.setZong(rs.getInt("zong"));
				areaZujinTrendList.add(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  finally{  
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

		return areaZujinTrendList;
  }
  
  public List<AreaZhikong> getAreaZhikongTrend(String project_type, String area_code){
	  try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
	  List<AreaZhikong> areaZhikongeTrendList=new ArrayList<AreaZhikong>();
	  
	  try {
			String sql = " select * from area_kongzhi where project_type=? and area_code=? order by heng"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project_type);
			pstmt.setString(2, area_code);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				AreaZhikong data = new AreaZhikong();
				data.setArea_id(rs.getInt("area_id"));
				
				data.setHeng(rs.getString("heng"));
				data.setId(rs.getInt("id"));
				
				data.setView_shunxu(rs.getInt("view_shunxu"));
				data.setZong(rs.getInt("zong"));
				areaZhikongeTrendList.add(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  finally{  
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
		return areaZhikongeTrendList;
  }
  
  
  
  
  
  
//��λ������� List
  public JSONArray listAreaMiddle(){
	  try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = "select * from area_middle t;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			jsonArray=ResultSetConverter.convert(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{  
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
//��λ������� Add
 public int InsertAreaMiddle(int heng, int zong, int view_shunxu,String area_code,String project_type){
	 try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
	 int exeResult=0;
		try {
			String sql = "insert into area_middle(heng,zong,view_shunxu,area_code,project_type) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, area_code);
			pstmt.setString(5, project_type);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{  
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
 
//��λ������� update
 public int updateAreaMiddle(int id,int heng, int zong, int view_shunxu,String area_code,String project_type){ 	
	try{
		con = DriverManager.getConnection(url, username, password);
	}catch(Exception e){
		e.printStackTrace();
	}
PreparedStatement pstmt = null;
	 int exeResult=0;
		try {
			String sql = "update area_middle set heng=?,zong=?,view_shunxu=?,area_code=?,project_type=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, area_code);
			pstmt.setString(5, project_type);
			pstmt.setInt(6, id);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{  
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
//��λ������� delete
 public int delAreaMiddle(int id){
	 try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {
			String sql = "delete from area_middle where id="+id;
			Statement stmt = con.createStatement();
			exeResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{  
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
 //�����������List
 public JSONArray listAreaZujin(){
	 try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = "select * from area_zujin t;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			jsonArray=ResultSetConverter.convert(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{  
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
 //�����������Add
 public int InsertAreaZujin(int heng, int zong, int view_shunxu,String area_code,String project_type){
	 try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
	 int exeResult=0;
		try {
			String sql = "insert into area_zujin(heng,zong,view_shunxu,area_code,project_type) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, area_code);
			pstmt.setString(5, project_type);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{  
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
 //�����������update
 public int updateAreaZujin(int id,int heng, int zong, int view_shunxu,String area_code,String project_type){
	 try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
	 int exeResult=0;
		try {
			String sql = "update area_zujin set heng=?,zong=?,view_shunxu=?,area_code=?,project_type=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, area_code);
			pstmt.setString(5, project_type);
			pstmt.setInt(6, id);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{  
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
 //�����������delete
 public int delAreaZujin(int id){
	 try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;

		int exeResult=0;
		try {
			String sql = "delete from area_zujin where id="+id;
			Statement stmt = con.createStatement();
			exeResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{  
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
 //��������� List
 public JSONArray listAreaZhikong(){
	 try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = "select * from area_kongzhi t;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			jsonArray=ResultSetConverter.convert(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{  
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
 //��������� Add
 public int InsertAreaZhikong(int heng, int zong, int view_shunxu,String area_code,String project_type){
	 try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
	 int exeResult=0;
		try {
			String sql = "insert into area_kongzhi(heng,zong,view_shunxu,area_code,project_type) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, area_code);
			pstmt.setString(5, project_type);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{  
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
 //��������� update
 public int updateAreaZhikong(int id,int heng, int zong, int view_shunxu,String area_code,String project_type){
	 try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
	 int exeResult=0;
		try {
			String sql = "update area_kongzhi set heng=?,zong=?,view_shunxu=?,area_code=?,project_type=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, area_code);
			pstmt.setString(5, project_type);
			pstmt.setInt(6, id);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{  
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
 //��������� delete
 public int delAreaZhikong(int id){
	 try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		int exeResult=0;
		try {
			String sql = "delete from area_kongzhi where id="+id;
			Statement stmt = con.createStatement();
			exeResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{  
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
 //���area_id��area_info���в���area_id �Ƿ����
 public  int findAreaid(int areaid){
	 try{
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
	 int area_id=0;
		try {
			String sql = "select id from area_info  t  WHERE t.id="+areaid;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				area_id=rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{  
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
		return area_id;
 }
}
