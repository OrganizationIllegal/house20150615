package com.kate.app.dao;



import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

   
public class BaseDao3
 {
	        
	protected static String url = null;
	protected static String username = null;
	protected static String password = null;
	protected static DataSource dataSource = null;
	        BaseDao3(){
	        	System.out.println("Setting up data source.");
	        	 /*url = "jdbc:mysql://101.200.174.253:3306/gethouse?autoReconnect=true&failOverReadOnly=false&maxReconnects=10";
		         username = "dboperator1";
		         password = "gethouse";*/
	        	 BasicDataSource ds = new BasicDataSource();
	        	 url=ds.getUrl();
	        	 username=ds.getUsername();
	        	 password=ds.getPassword();
	        	 System.out.println("url"+url);
	        	 System.out.println("username"+username);
	        	 System.out.println("password"+password);
		         dataSource = setupDataSource(url,username,password);
		        
		        System.out.println("Done.");
/*
		       
		        Connection conn = null;
		        Statement stmt = null;
		        ResultSet rset = null;

		        try {
		            System.out.println("Creating connection.");
		            conn = dataSource.getConnection();
		            System.out.println("Creating statement.");
		            stmt = conn.createStatement();
		            System.out.println("Executing statement.");
		            rset = stmt.executeQuery(args[1]);
		            System.out.println("Results:");
		            int numcols = rset.getMetaData().getColumnCount();
		            while(rset.next()) {
		                for(int i=1;i<=numcols;i++) {
		                    System.out.print("\t" + rset.getString(i));
		                }
		                System.out.println("");
		            }
		        } catch(SQLException e) {
		            e.printStackTrace();
		        } finally {
		            try { if (rset != null) rset.close(); } catch(Exception e) { }
		            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
		            try { if (conn != null) conn.close(); } catch(Exception e) { }
		        }*/
		    }

	      
	
	        

	    public static DataSource setupDataSource(String connectURI, String username ,String password) {
	        BasicDataSource ds = new BasicDataSource();
	        ds.setDriverClassName("com.mysql.jdbc.Driver");
	        ds.setUrl(connectURI);
	        ds.setUsername(username);
	        ds.setPassword(password);
	        return ds;
	    }

	    public static void printDataSourceStats(DataSource ds) {
	        BasicDataSource bds = (BasicDataSource) ds;
	        System.out.println("NumActive: " + bds.getNumActive());
	        System.out.println("NumIdle: " + bds.getNumIdle());
	    }

	    public static void shutdownDataSource(DataSource ds) throws SQLException {
	        BasicDataSource bds = (BasicDataSource) ds;
	        bds.close();
	    }
	}
