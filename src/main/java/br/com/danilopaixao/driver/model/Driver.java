package br.com.danilopaixao.driver.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "driver")
public class Driver implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7943900894009719758L;
	@Id
	private String id;
	//@Indexed(unique = true)
	private String name;
	private String licenseCategory;
	private String address;
	
	public Driver() {
	}
	
	
	public Driver(String id, String name, String licenseCategory, String address) {
		super();
		this.id = id;
		this.name = name;
		this.licenseCategory = licenseCategory;
		this.address = address;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getLicenseCategory() {
		return licenseCategory;
	}


	public void setLicenseCategory(String licenseCategory) {
		this.licenseCategory = licenseCategory;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
