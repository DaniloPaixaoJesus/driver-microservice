package br.com.danilopaixao.driver.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.danilopaixao.driver.model.Driver;


@RestController
@RequestMapping("/api/v1/drivers")
public class DriverResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{id}")
	public Driver getDriver(@PathVariable("id") String id) {
		return new Driver(id, "TRANSFORMERS");
	}
	
	@HystrixCommand(fallbackMethod ="getFallback")
	@RequestMapping("/callbackteste/{id}")
	public Driver getTesteFallback(@PathVariable("id") String id) {
		Driver driver = restTemplate.getForObject("http://driver/teste/"+id, Driver.class);
		return driver;
	}
	
	public Driver getFallback(@PathVariable("id") String id) {
		return new Driver(id, "NOT FOUND");
	}

}
