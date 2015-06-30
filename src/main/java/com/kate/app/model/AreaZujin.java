package com.kate.app.model;

import java.sql.Timestamp;

public class AreaZujin {
	private int id;
	private String heng;
	private int zong;
	private String project_type;
	private String area_code;
	private int house_project_id;
	private String zujin_datasource;
	private Timestamp zujin_date;
	private int area_id;
	private int view_shunxu;
	
	
	public String getZujin_datasource() {
		return zujin_datasource;
	}
	public void setZujin_datasource(String zujin_datasource) {
		this.zujin_datasource = zujin_datasource;
	}
	public Timestamp getZujin_date() {
		return zujin_date;
	}
	public void setZujin_date(Timestamp zujin_date) {
		this.zujin_date = zujin_date;
	}
	public int getHouse_project_id() {
		return house_project_id;
	}
	public void setHouse_project_id(int house_project_id) {
		this.house_project_id = house_project_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeng() {
		return heng;
	}
	public void setHeng(String heng) {
		this.heng = heng;
	}
	public int getZong() {
		return zong;
	}
	public void setZong(int zong) {
		this.zong = zong;
	}
	public String getProject_type() {
		return project_type;
	}
	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}
	public String getArea_code() {
		return area_code;
	}
	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}
	public int getView_shunxu() {
		return view_shunxu;
	}
	public void setView_shunxu(int view_shunxu) {
		this.view_shunxu = view_shunxu;
	}
	
}
