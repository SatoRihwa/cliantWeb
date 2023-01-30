package com.web.client.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDisp implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date entrancedate;
	
	// 引数なしのコンストラクタを定義しないとデシリアライズ（JSON -> Javaオブジェクトへの変換）時にエラーが起きる
	public EmployeeDisp() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEntrancedate() {
		return entrancedate;
	}
	public void setEntrancedate(Date entrancedate) {
		this.entrancedate = entrancedate;
	}
	
	@Override
    public String toString() {
		return "Employee{" + 
				"id=" + getId() + 
				"name=" + getName() + 
				"entrancedata=" + getEntrancedate();
	}
}