package br.com.danilopaixao.driver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danilopaixao.driver.model.Driver;
import br.com.danilopaixao.driver.model.DriverList;
import br.com.danilopaixao.driver.repository.DriverRepository;
import br.com.danilopaixao.driver.resource.DriverResource;

@Service
public class DriverService {
	
	private static final Logger logger = LoggerFactory.getLogger(DriverResource.class);

	@Autowired
	private DriverRepository driverRepository;
	
	public DriverList init() {
		// in case of duplicate key, ignore and go ahead
		try {insertNew(new Driver("93418DF0R09QSDF", "Kalles Grustransporter", "AB", "Cementvägen 8, 111 11 Södertälje"));}catch (Exception e) {}
		try {insertNew(new Driver("623480520FDF2", "Johans Bulk", "AB", "Balkvägen 12, 222 22 Stockholm"));}catch (Exception e) {}
		try {insertNew(new Driver("7428DFEC8137652", "Haralds Värdetransporter", "AB", "Budgetvägen 1, 333 33 Uppsala"));}catch (Exception e) {}
		return this.getAllDriver();
	}
	
	public Driver insertNew(Driver driver) {
		logger.info("##DriverService#insertNew: {}", driver);
		return driverRepository.insert(driver);
	}
	
	public DriverList getAllDriver() {
		logger.info("##DriverService#getAllDriver: nor arguments");
		return new DriverList(driverRepository.findAll());
	}
	
	public Driver getDriver(String id) {
		logger.info("##DriverService#getDriver({})", id);
		return driverRepository.findById(id).orElse(null);
	}
	
}
