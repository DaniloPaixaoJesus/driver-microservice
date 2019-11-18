package br.com.danilopaixao.driver.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Driver insertNewDriver(@RequestBody(required = true) Driver driver) {
		logger.info("##DriverResource#insertNewDriver({})", driver);
		return service.insertNew(driver); 
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Driver updateDriver(@RequestBody(required = true) Driver driver,
											 @PathVariable("id") final String id) {
		if(!driver.getId().equals(id)){
			logger.error("##DriverResource#updateDriver: {} -> {}", id, driver);
			throw new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, "driver id request body is diff of path variable ");
		}
		logger.info("##DriverResource#updateDriver({})", driver);
		return service.save(driver); 
	}
	
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public DriverList getAllDriver() {
		logger.info("##DriverResource#getAllDriver: no argument");
		return service.getAllDriver();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Driver getDriver(@PathVariable("id") final String id) {
		logger.info("##DriverResource#getDriver({})", id);
		Driver r = service.getDriver(id);
		if(r == null) {
			throw new ResponseStatusException(
			          HttpStatus.NOT_FOUND, "requested driver not found");
		}
		return r; 
	}
	
}
