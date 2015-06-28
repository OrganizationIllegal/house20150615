package com.kate.app.model;

import java.sql.Timestamp;

public class BrokerServiceArea {
	private int id;
	private int view_shunxu;
	private int area_id;
	private int broker_id;
	private String area_code;
	private String broker_num;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getView_shunxu() {
		return view_shunxu;
	}
	public void setView_shunxu(int view_shunxu) {
		this.view_shunxu = view_shunxu;
	}
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}
	public int getBroker_id() {
		return broker_id;
	}
	public void setBroker_id(int broker_id) {
		this.broker_id = broker_id;
	}
	public String getArea_code() {
		return area_code;
	}
	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}
	public String getBroker_num() {
		return broker_num;
	}
	public void setBroker_num(String broker_num) {
		this.broker_num = broker_num;
	}
}