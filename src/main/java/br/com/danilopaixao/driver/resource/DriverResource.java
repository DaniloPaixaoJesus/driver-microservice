package br.com.danilopaixao.driver.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.danilopaixao.driver.model.Driver;
import br.com.danilopaixao.driver.model.DriverList;
import br.com.danilopaixao.driver.service.DriverService;


@RestController
@RequestMapping("/api/v1/drivers")
public class DriverResource {
	
	private static final Logger logger = LoggerFactory.getLogger(DriverResource.class);
	
	@Autowired
	private DriverService service;
	
	@GetMapping(value = "/init", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public DriverList insertDriver() {
		return service.init();
	}
	
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public DriverList getAllDriver() {
		logger.info("##DriverResource#getAllDriver: no argument");
		return service.getAllDriver();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Driver getDriver(@PathVariable("id") final String id) {
		logger.info("##DriverResource#getDriver({})", id);
		return service.getDriver(id); 
	}
	
}
