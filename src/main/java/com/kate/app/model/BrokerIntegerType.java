package com.kate.app.model;

import java.sql.Timestamp;

public class BrokerIntegerType {
	private int id;
	private int view_shunxu;
	private int interested_id;
	private int broker_id;
	private String interested_num;
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
	public int getInterested_id() {
		return interested_id;
	}
	public void setInterested_id(int interested_id) {
		this.interested_id = interested_id;
	}
	public int getBroker_id() {
		return broker_id;
	}
	public void setBroker_id(int broker_id) {
		this.broker_id = broker_id;
	}
	public String getInterested_num() {
		return interested_num;
	}
	public void setInterested_num(String interested_num) {
		this.interested_num = interested_num;
	}
	public String getBroker_num() {
		return broker_num;
	}
	public void setBroker_num(String broker_num) {
		this.broker_num = broker_num;
	}
	
}