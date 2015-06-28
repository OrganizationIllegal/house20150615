package com.kate.app.model;

import java.sql.Timestamp;

public class TuiJianBroker {
	private int id;
	private String broker_code1;
	private String broker_code2;
	private String broker_code3;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBroker_code1() {
		return broker_code1;
	}
	public void setBroker_code1(String broker_code1) {
		this.broker_code1 = broker_code1;
	}
	public String getBroker_code2() {
		return broker_code2;
	}
	public void setBroker_code2(String broker_code2) {
		this.broker_code2 = broker_code2;
	}
	public String getBroker_code3() {
		return broker_code3;
	}
	public void setBroker_code3(String broker_code3) {
		this.broker_code3 = broker_code3;
	}
	public String getArea_code() {
		return area_code;
	}
	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}
	private String area_code;
	
}
