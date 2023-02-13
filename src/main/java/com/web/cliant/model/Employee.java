package com.web.client.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Component
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entrancedate;
	
	// 引数なしのコンストラクタを定義しないとデシリアライズ（JSON -> Javaオブジェクトへの変換）時にエラーが起きる
	public Employee() {
		
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
				"name=" + getName() + 
				"entrancedata=" + getEntrancedate();
	}
}
