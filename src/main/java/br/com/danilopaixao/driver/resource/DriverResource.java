package br.com.danilopaixao.driver.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.danilopaixao.driver.model.Driver;
import br.com.danilopaixao.driver.model.DriverList;
import br.com.danilopaixao.driver.service.DriverService;


@RestController
@RequestMapping("/api/v1/drivers")
public class DriverResource {
	
	@Autowired
	private DriverService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/init", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public DriverList insertDriver() {
		return service.init();
	}
	
	
	@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public DriverList getAllDriver() {
		return service.getAllDriver();
	}
	
	@RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Driver getDriver(@PathVariable("id") final String id) {
		return service.getDriver(id); 
	}
	
	@HystrixCommand(fallbackMethod ="getFallback")
	@RequestMapping(value = "/callbackteste/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Driver getTesteFallback(@PathVariable("id") final String id) {
		Driver driver = restTemplate.getForObject("http://driver/teste/"+id, Driver.class);
		return driver;
	}
	
	public Driver getFallback(@PathVariable("id") final String id) {
		return new Driver("NOT FOUND", "", "", "");
	}

}
