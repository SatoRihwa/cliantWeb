package com.web.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.web.client.confrage.CliantWebConfrage;
import com.web.client.model.Project;
import com.web.client.model.ProjectDisp;

@Service
@Configuration
public class ProjectApiService{
	
	private RestTemplate restTemplate = new RestTemplate();
	@Autowired
	private CliantWebConfrage config;
	
	/**
	 * プロジェクト情報1件取得
	 * @param id プロジェクトID
	 * @return プロジェクト情報
	 */
	public ProjectDisp getProjectById(String id) {
		String url = config.getProject() + "/" + id;
	    
	    //APIからレスポンスが返ってくる
	    ResponseEntity<ProjectDisp> response = restTemplate
	        .exchange(url, HttpMethod.GET, null, ProjectDisp.class);
	    
	    return response.getBody();
	}
	
	/**
	 * プロジェクト情報全件取得
	 * @return プロジェクト情報リスト
	 */
	public List<ProjectDisp> getAllProject() {
		
	    ResponseEntity<List<ProjectDisp>> response = restTemplate.exchange(
	    		config.getProject(), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<ProjectDisp>>() {});
	    
	    return response.getBody();
	}
	
	/**
	 * プロジェクト情報追加
	 * @param proDisp
	 * @return
	 */
	public void addProject(ProjectDisp proDisp) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			Project p = new Project();
			p.setStartdate(proDisp.getStartdate());
			p.setName(proDisp.getName());
			List<Project> pl = new ArrayList<Project>();
			pl.add(p);
				
			HttpEntity<List<Project>> entity = new HttpEntity<>(pl, headers);
	
			RestTemplate restTemplate = new RestTemplate();
			entity.getBody();
			ResponseEntity<String> response = restTemplate.exchange(config.getProject(), 
					HttpMethod.POST, entity, String.class);
			response.getBody();
		}catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return;
	}
	
	/**
	 * プロジェクト情報削除
	 * @param id
	 * @return
	 */
	public List<Project> deleteEmployee(String id) {
		String url = config.getProject() + "?id={" + id + "}";
		
	    ResponseEntity<List<Project>> response = restTemplate.exchange(
	    		url, HttpMethod.DELETE,
                null, new ParameterizedTypeReference<List<Project>>() {});
	    
	    return response.getBody();
	}
}
