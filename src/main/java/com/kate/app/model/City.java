package com.kate.app.model;

import java.sql.Timestamp;

public class City {
	private int id;
	private String city_name;
	private String city_num;
	private String center_gps;
	private String pre_num;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getCity_num() {
		return city_num;
	}
	public void setCity_num(String city_num) {
		this.city_num = city_num;
	}
	public String getCenter_gps() {
		return center_gps;
	}
	public void setCenter_gps(String center_gps) {
		this.center_gps = center_gps;
	}
	public String getPre_num() {
		return pre_num;
	}
	public void setPre_num(String pre_num) {
		this.pre_num = pre_num;
	}
	
}
