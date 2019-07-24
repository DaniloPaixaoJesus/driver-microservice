package br.com.danilopaixao.driver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danilopaixao.driver.model.Driver;
import br.com.danilopaixao.driver.model.DriverList;
import br.com.danilopaixao.driver.repository.DriverRepository;

@Service
public class DriverService {

//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private DriverRepository driverRepository;
	
	public DriverList init() {
		// in case of duplicate key, ignore and go ahead
		try {
			insertDriver(new Driver("93418DF0R09QSDF", "Kalles Grustransporter", "AB", "Cementvägen 8, 111 11 Södertälje"));
		}catch (Exception e) {}
		try {
			insertDriver(new Driver("623480520FDF2", "Johans Bulk", "AB", "Balkvägen 12, 222 22 Stockholm"));
		}catch (Exception e) {}
		try {
			insertDriver(new Driver("93418DF0R09QSDF", "Kalles Grustransporter", "AB", "Cementvägen 8, 111 11 Södertälje"));
		}catch (Exception e) {}
		
		return this.getAllDriver();
	}
	
	public Driver insertDriver(Driver driver) {
		return driverRepository.insert(driver);
	}
	
	public DriverList getAllDriver() {
		return new DriverList(driverRepository.findAll());
	}
	
	public Driver getDriver(String id) {
		return driverRepository.findById(id).orElse(null);
	}
	
}
