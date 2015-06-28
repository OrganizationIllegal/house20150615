package com.kate.app.model;

public class HoldCost {
	private int id;
	private String holdcosttype;
	private String  holdcostprice;
	private String  holdcostdesc;
	private String  holdcost_housename;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoldcosttype() {
		return holdcosttype;
	}
	public void setHoldcosttype(String holdcosttype) {
		this.holdcosttype = holdcosttype;
	}
	public String getHoldcostprice() {
		return holdcostprice;
	}
	public void setHoldcostprice(String holdcostprice) {
		this.holdcostprice = holdcostprice;
	}
	public String getHoldcostdesc() {
		return holdcostdesc;
	}
	public void setHoldcostdesc(String holdcostdesc) {
		this.holdcostdesc = holdcostdesc;
	}
	public String getHoldcost_housename() {
		return holdcost_housename;
	}
	public void setHoldcost_housename(String holdcost_housename) {
		this.holdcost_housename = holdcost_housename;
	}
	   
}
