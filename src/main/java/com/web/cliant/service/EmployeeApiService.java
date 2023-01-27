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
import com.web.client.model.Employee;
import com.web.client.model.EmployeeDisp;

@Service
@Configuration
public class EmployeeApiService{
	
	private RestTemplate restTemplate = new RestTemplate();
	@Autowired
	private CliantWebConfrage config;
	
	/**
	 * 社員情報1件取得
	 * @param id 社員ID
	 * @return 社員情報
	 */
	public Employee getEmployeeById(String id) {
		String url = config.getEmployee() + "/" + id;
	    
	    //APIからレスポンスが返ってくる
	    ResponseEntity<Employee> response = restTemplate
	        .exchange(url, HttpMethod.GET, null, Employee.class);
	    
	    return response.getBody();
	}
	
	/**
	 * 社員情報全件取得
	 * @return 社員情報リスト
	 */
	public List<EmployeeDisp> getAllEmployee() {
		
	    ResponseEntity<List<EmployeeDisp>> response = restTemplate.exchange(
	    		config.getEmployee(), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<EmployeeDisp>>() {});
	    
	    return response.getBody();
	}
	
	/**
	 * 社員情報追加
	 * @param empDisp
	 * @return
	 */
	public void addEmployee(EmployeeDisp empDisp) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			Employee e = new Employee();
			e.setEntrancedate(empDisp.getEntrancedate());
			e.setName(empDisp.getName());
			List<Employee> el = new ArrayList<Employee>();
			el.add(e);
				
			HttpEntity<List<Employee>> entity = new HttpEntity<>(el, headers);
	
			RestTemplate restTemplate = new RestTemplate();
			entity.getBody();
			ResponseEntity<String> response = restTemplate.exchange(config.getEmployee(), 
					HttpMethod.POST, entity, String.class);
			response.getBody();
		}catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return;
	}
	
	/**
	 * 社員情報削除
	 * @param id
	 * @return
	 */
	public void deleteEmployee(String id) {
		String url = config.getEmployee() + "/" + id;
	    
	    //APIからレスポンスが返ってくる
		ResponseEntity<String> response = restTemplate
	        .exchange(url, HttpMethod.DELETE, null, String.class);
		response.getBody();
	    
	    return;
	}
}
