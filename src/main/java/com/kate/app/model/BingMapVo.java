package com.kate.app.model;

import java.util.List;

public class BingMapVo {
	private int project_id;
	private String project_img;
	private String project_num;
	private String project_address;
	private String project_type;
	
	public String getProject_type() {
		return project_type;
	}

	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}
	//国家 城市   区域  州
	private String  project_nation;
	private String project_city;
	private String project_area;
	private String zhou;
	
	public String getProject_nation() {
		return project_nation;
	}

	public void setProject_nation(String project_nation) {
		this.project_nation = project_nation;
	}

	public String getProject_city() {
		return project_city;
	}

	public void setProject_city(String project_city) {
		this.project_city = project_city;
	}

	public String getProject_area() {
		return project_area;
	}

	public void setProject_area(String project_area) {
		this.project_area = project_area;
	}

	public String getZhou() {
		return zhou;
	}

	public void setZhou(String zhou) {
		this.zhou = zhou;
	}
	private String project_address_short;
	
	
	private String project_name;
	private String project_price;
	private int minArea;
	private int maxArea;
	private int keshou;
	private String average_price;
    private String house_type;
    private String project_min_price;
    private String project_high_price;
    private String mianji;
    private String return_money; 
  /*  private int project_price_int_qi;*/
    private String project_price_int_qi;
    private List<String> project_key;
    private String project_name_full;
    private String bijiao;
    private String gps;
    
    
	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public String getBijiao() {
		return bijiao;
	}

	public void setBijiao(String bijiao) {
		this.bijiao = bijiao;
	}

	public String getProject_name_full() {
		return project_name_full;
	}

	public void setProject_name_full(String project_name_full) {
		this.project_name_full = project_name_full;
	}
     public BingMapVo(){
    	 
     }
	public BingMapVo(int project_id, String gps, String project_nation, String project_city, String project_area, String zhou,String project_type,String bijiao,String project_name_full,String project_img,String project_num,String project_address, String project_name,String project_price,int minArea,int maxArea,int keshou,String average_price,String house_type,String project_min_price,String project_high_price,String mianji,String return_money,String project_price_int_qi,List<String> project_key,String project_address_short){
		this.project_id=project_id;
		this.project_img=project_img;
		this.project_num=project_num;
		this.project_address=project_address;
		this.project_name=project_name;
		this.project_price=project_price;
		this.minArea=minArea;
		this.maxArea=maxArea;
		this.keshou=keshou;
		this.average_price=average_price;
		this.house_type=house_type;
		this.project_min_price=project_min_price;
		this.project_high_price=project_high_price;
		this.mianji=mianji;
		this.return_money=return_money;
		this.project_price_int_qi=project_price_int_qi;
		this.project_key=project_key;
		this.project_address_short=project_address_short;
		this.project_name_full = project_name_full;
		this.bijiao = bijiao;
		this.project_type = project_type;
		this.project_nation = project_nation;
		this.project_city = project_city;
		this.project_area = project_area;
		this.zhou = zhou;
		this.gps = gps;
		
		
		
		
	}
	
	
	
	public BingMapVo(int project_id,String project_type,String bijiao,String project_name_full,String project_img,String project_num,String project_address, String project_name,String project_price,int minArea,int maxArea,int keshou,String average_price,String house_type,String project_min_price,String project_high_price,String mianji,String return_money,String project_price_int_qi,List<String> project_key,String project_address_short){
		this.project_id=project_id;
		this.project_img=project_img;
		this.project_num=project_num;
		this.project_address=project_address;
		this.project_name=project_name;
		this.project_price=project_price;
		this.minArea=minArea;
		this.maxArea=maxArea;
		this.keshou=keshou;
		this.average_price=average_price;
		this.house_type=house_type;
		this.project_min_price=project_min_price;
		this.project_high_price=project_high_price;
		this.mianji=mianji;
		this.return_money=return_money;
		this.project_price_int_qi=project_price_int_qi;
		this.project_key=project_key;
		this.project_address_short=project_address_short;
		this.project_name_full = project_name_full;
		this.bijiao = bijiao;
		this.project_type = project_type;

		
		
		
	}
	
	
	public BingMapVo(int project_id,String project_img,String project_num,String project_address, String project_name,String project_price,int minArea,int maxArea,int keshou,String average_price,String house_type,String project_min_price,String project_high_price,String mianji,String return_money,String project_price_int_qi,List<String> project_key){
		this.project_id=project_id;
		this.project_img=project_img;
		this.project_num=project_num;
		this.project_address=project_address;
		this.project_name=project_name;
		this.project_price=project_price;
		this.minArea=minArea;
		this.maxArea=maxArea;
		this.keshou=keshou;
		this.average_price=average_price;
		this.house_type=house_type;
		this.project_min_price=project_min_price;
		this.project_high_price=project_high_price;
		this.mianji=mianji;
		this.return_money=return_money;
		this.project_price_int_qi=project_price_int_qi;
		this.project_key=project_key;
	}
	

	public String getProject_address_short() {
		return project_address_short;
	}



	public void setProject_address_short(String project_address_short) {
		this.project_address_short = project_address_short;
	}



	


	public List<String> getProject_key() {
		return project_key;
	}

	public void setProject_key(List<String> project_key) {
		this.project_key = project_key;
	}

	public String getProject_price_int_qi() {
		return project_price_int_qi;
	}



	public void setProject_price_int_qi(String project_price_int_qi) {
		this.project_price_int_qi = project_price_int_qi;
	}



	public String getReturn_money() {
		return return_money;
	}

	public void setReturn_money(String return_money) {
		this.return_money = return_money;
	}

	public String getProject_min_price() {
		return project_min_price;
	}

	public void setProject_min_price(String project_min_price) {
		this.project_min_price = project_min_price;
	}

	public String getProject_high_price() {
		return project_high_price;
	}

	public void setProject_high_price(String project_high_price) {
		this.project_high_price = project_high_price;
	}

	public String getMianji() {
		return mianji;
	}

	public void setMianji(String mianji) {
		this.mianji = mianji;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_img() {
		return project_img;
	}

	public void setProject_img(String project_img) {
		this.project_img = project_img;
	}

	public String getProject_num() {
		return project_num;
	}

	public void setProject_num(String project_num) {
		this.project_num = project_num;
	}

	public String getProject_address() {
		return project_address;
	}
	public void setProject_address(String project_address) {
		this.project_address = project_address;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	
	

	public int getMinArea() {
		return minArea;
	}
	public void setMinArea(int minArea) {
		this.minArea = minArea;
	}
	public int getMaxArea() {
		return maxArea;
	}
	public void setMaxArea(int maxArea) {
		this.maxArea = maxArea;
	}
	public int getKeshou() {
		return keshou;
	}
	public void setKeshou(int keshou) {
		this.keshou = keshou;
	}
	
	public String getProject_price() {
		return project_price;
	}

	public void setProject_price(String project_price) {
		this.project_price = project_price;
	}

	public String getAverage_price() {
		return average_price;
	}

	public void setAverage_price(String average_price) {
		this.average_price = average_price;
	}

	public String getHouse_type() {
		return house_type;
	}
	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}
	

}
