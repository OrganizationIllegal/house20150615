package com.kate.app.dao;


import java.sql.Connection;
import java.sql.DriverManager;




public class BaseDao {
	
	protected static String url = null;
	protected static String username = null;
	protected static String password = null;
	protected static Connection con = null;
	
	public BaseDao()
	{
		if(con == null){
			try {
	            url = "jdbc:mysql://101.200.174.253:3306/gethouse?autoReconnect=true";
	            username = "dboperator1";
	            password = "gethouse";
	            con = DriverManager.getConnection(url, username, password);
	        } catch (Exception e) {
	           System.out.print("DriverManager.getConnection faild");
	           System.out.println(e.toString());
	        }
		}else{
			
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
	}
	
	
}
