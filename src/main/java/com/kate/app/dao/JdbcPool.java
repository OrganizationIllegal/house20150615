package com.kate.app.dao;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.kate.app.model.JdbcUtil;




public class JdbcPool{
	
private static DataSource ds = null;
	
	static{
        try{
            //加载dbcpconfig.properties配置文件
           InputStream in = JdbcPool.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
           Properties prop = new Properties();
          prop.load(in);
            //创建数据源
            ds = BasicDataSourceFactory.createDataSource(prop);
        }catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
	
	public static Connection getConnection() throws SQLException{
		         //从数据源中获取数据库连接
		         return ds.getConnection();
	}
	
	public  static  void release(Connection conn, Statement st, PreparedStatement pstmt, ResultSet rs){
        if(rs!=null){
            try{
                //关闭存储查询结果的ResultSet对象
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //关闭负责执行SQL命令的Statement对象
                st.close();
            }catch (Exception e) {
              e.printStackTrace();
            }
       }
        if(pstmt!=null){
       	 try{
                //关闭负责执行SQL命令的PreparedStatement对象
       		 pstmt.close();
            }catch (Exception e) {
              e.printStackTrace();
            }
        }
        
        if(conn!=null){
            try{
               //将Connection连接对象还给数据库连接池
                conn.close();
          }catch (Exception e) {
              e.printStackTrace();
            }
        }
	}
	
}
