package com.kate.app.model;

import java.sql.Timestamp;

public class AreaZhikong {
	private int id;
	private String heng;
	private float zong;
	private String project_type;
	private String area_code;
	private int house_pro_id;
	private int area_id;
	private int view_shunxu;
	private String zujin_huibao_datasource;
	private Timestamp zujin_huibao_date;
	
	
	
	public String getZujin_huibao_datasource() {
		return zujin_huibao_datasource;
	}
	public void setZujin_huibao_datasource(String zujin_huibao_datasource) {
		this.zujin_huibao_datasource = zujin_huibao_datasource;
	}
	public Timestamp getZujin_huibao_date() {
		return zujin_huibao_date;
	}
	public void setZujin_huibao_date(Timestamp zujin_huibao_date) {
		this.zujin_huibao_date = zujin_huibao_date;
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
	public int getHouse_pro_id() {
		return house_pro_id;
	}
	public void setHouse_pro_id(int house_pro_id) {
		this.house_pro_id = house_pro_id;
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
	public float getZong() {
		return zong;
	}
	public void setZong(float zong) {
		this.zong = zong;
	}
	
	

}
