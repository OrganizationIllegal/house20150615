package com.kate.app.dao;


import java.sql.Connection;
import java.sql.DriverManager;




public class BaseDao {
	
	protected static String url = null;
	protected static String username = null;
	protected static String password = null;
	protected static Connection con = null;
	private static final ThreadLocal<Connection> conn = new ThreadLocal<Connection>();
	public BaseDao()
	{
		try {
				con = conn.get();//从线程缓冲区中取数据库连接对象
				if(con == null){
		            url = "jdbc:mysql://101.200.174.253:3306/gethouse?autoReconnect=true";
		            username = "dboperator1";
		            password = "gethouse";
		            con = DriverManager.getConnection(url, username, password);
		            conn.set(con);//把创建好的数据库连接对象放入线程缓冲区
				} 
		}catch (Exception e) {
	           System.out.print("DriverManager.getConnection faild");
	           System.out.println(e.toString());
	        }
		}/*else{
			
		}
		
	}
	static {
		try{   
		    //閿熸枻鎷烽敓鏂ゆ嫹MySql閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�  
		    Class.forName("com.mysql.jdbc.Driver") ;   
		}
		catch(ClassNotFoundException e){   
		    System.out.println("閿熸彮璇ф嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹澶遍敓鏉帮綇鎷�");   
		    e.printStackTrace() ;   
		}   
		try {
            url = "jdbc:mysql://101.200.174.253:3306/gethouse?autoReconnect=true";

            username = "dboperator1";
            password = "gethouse";
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
           System.out.print("DriverManager.getConnection faild");
           System.out.println(e.toString());
        }
	}*/
	
	
}
