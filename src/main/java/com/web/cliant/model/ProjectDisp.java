package com.web.client.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component
public class ProjectDisp  implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startdate;
	
	// 引数なしのコンストラクタを定義しないとデシリアライズ（JSON -> Javaオブジェクトへの変換）時にエラーが起きる
	public ProjectDisp() {
		
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
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	
	@Override
    public String toString() {
		return "Project{" + 
				"id=" + getId() + 
				"name=" + getName() + 
				"startdata=" + getStartdate();
	}
}