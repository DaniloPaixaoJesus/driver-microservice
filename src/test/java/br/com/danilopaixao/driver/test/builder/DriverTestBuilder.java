package br.com.danilopaixao.driver.test.builder;

import org.apache.commons.lang.RandomStringUtils;

import br.com.danilopaixao.driver.model.Driver;

public class DriverTestBuilder {
	private String id;
	private String name;
	private String licenseCategory;
	private String address;
	
	public Driver build() {
		return new Driver(id, name, licenseCategory, address);
	}
	
	public Driver buildRandom() {
		return new Driver(	"ID " + RandomStringUtils.random(10, true, true), 
				"NAME " + RandomStringUtils.random(10, true, true), 
				"LICENSE CATEGORY " + RandomStringUtils.random(10, true, true), 
				"ADDRESS " + RandomStringUtils.random(10, true, true));
	}
	
	public DriverTestBuilder setId(String id) {
		this.id = id;
		return this;
	}
	public DriverTestBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public DriverTestBuilder setLicenseCategory(String licenseCategory) {
		this.licenseCategory = licenseCategory;
		return this;
	}
	public DriverTestBuilder setAddress(String address) {
		this.address = address;
		return this;
	}
}
