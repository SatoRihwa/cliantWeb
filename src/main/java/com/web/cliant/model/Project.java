package com.web.cliant.model;

import java.io.Serializable;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Component
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project  implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private Date startdate;
	
	// 引数なしのコンストラクタを定義しないとデシリアライズ（JSON -> Javaオブジェクトへの変換）時にエラーが起きる
	public Project() {
		
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
}