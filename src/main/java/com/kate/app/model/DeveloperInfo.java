package com.kate.app.model;

public class DeveloperInfo {
	private int id;
	private String developer_name;
	private String developer_logo;
	private String developer_desc;
	private String developer_num;
	private String nation;
	
	public String getDeveloper_num() {
		return developer_num;
	}
	public void setDeveloper_num(String developer_num) {
		this.developer_num = developer_num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeveloper_name() {
		return developer_name;
	}
	public void setDeveloper_name(String developer_name) {
		this.developer_name = developer_name;
	}
	public String getDeveloper_logo() {
		return developer_logo;
	}
	public void setDeveloper_logo(String developer_logo) {
		this.developer_logo = developer_logo;
	}
	public String getDeveloper_desc() {
		return developer_desc;
	}
	public void setDeveloper_desc(String developer_desc) {
		this.developer_desc = developer_desc;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
}
