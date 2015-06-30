package com.kate.app.model;

import java.sql.Timestamp;

public class InvestmentDataBackEnd {
	private int id;
	private String year_increment_rate;
	private String middle_price;
	private String middle_zu_price;
	private String zu_house_rate;
	private String zu_xuqiu;
	private String price_review;
	private int house_pro_id;
	private String data_exam;
	private int area_id;
	private String area_num;
	private String area_name;
	private String zuijin_review;
	private Timestamp update_time;
	private String touzi_datasource;
	private Timestamp touzi_date;
	private String aera_type;
	
	
	public String getZuijin_review() {
		return zuijin_review;
	}
	public void setZuijin_review(String zuijin_review) {
		this.zuijin_review = zuijin_review;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	public String getTouzi_datasource() {
		return touzi_datasource;
	}
	public void setTouzi_datasource(String touzi_datasource) {
		this.touzi_datasource = touzi_datasource;
	}
	public Timestamp getTouzi_date() {
		return touzi_date;
	}
	public void setTouzi_date(Timestamp touzi_date) {
		this.touzi_date = touzi_date;
	}
	public String getAera_type() {
		return aera_type;
	}
	public void setAera_type(String aera_type) {
		this.aera_type = aera_type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYear_increment_rate() {
		return year_increment_rate;
	}
	public void setYear_increment_rate(String year_increment_rate) {
		this.year_increment_rate = year_increment_rate;
	}
	public String getMiddle_price() {
		return middle_price;
	}
	public void setMiddle_price(String middle_price) {
		this.middle_price = middle_price;
	}
	public String getMiddle_zu_price() {
		return middle_zu_price;
	}
	public void setMiddle_zu_price(String middle_zu_price) {
		this.middle_zu_price = middle_zu_price;
	}
	public String getZu_house_rate() {
		return zu_house_rate;
	}
	public void setZu_house_rate(String zu_house_rate) {
		this.zu_house_rate = zu_house_rate;
	}
	public String getZu_xuqiu() {
		return zu_xuqiu;
	}
	public void setZu_xuqiu(String zu_xuqiu) {
		this.zu_xuqiu = zu_xuqiu;
	}
	public String getPrice_review() {
		return price_review;
	}
	public void setPrice_review(String price_review) {
		this.price_review = price_review;
	}
	public String getData_exam() {
		return data_exam;
	}
	public void setData_exam(String data_exam) {
		this.data_exam = data_exam;
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
	public String getArea_num() {
		return area_num;
	}
	public void setArea_num(String area_num) {
		this.area_num = area_num;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	
	
	
}
