package com.example.demoboot.dto;


public class OrdersDTO {

	private long orderid;
	private String type;
	private int param1;
	private char param2;
	private boolean param3;

	protected OrdersDTO() {
	}
	
	protected OrdersDTO(long orderid, String type, int param1, char param2, boolean param3) {
		this.orderid = orderid;
		this.type = type;
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
	}

	public long getOrderid() {
		return orderid;
	}
	
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getParam1() {
		return param1;
	}
	
	public void setParam1(int param1) {
		this.param1 = param1;
	}
	
	public char getParam2() {
		return param2;
	}
	
	public void setParam2(char param2) {
		this.param2 = param2;
	}
	
	public boolean isParam3() {
		return param3;
	}
	
	public void setParam3(boolean param3) {
		this.param3 = param3;
	}

}
