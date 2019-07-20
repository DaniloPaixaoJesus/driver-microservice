package br.com.danilopaixao.driver.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import br.com.danilopaixao.driver.model.Driver;
import br.com.danilopaixao.driver.model.DriverList;

@Service
public class DriverService {

//	@Autowired
//	private RestTemplate restTemplate;
	
	private static List<Driver> mockDrivers = Arrays.asList(
			new Driver("93418DF0R09QSDF", "Kalles Grustransporter", "AB", "Cementvägen 8, 111 11 Södertälje"),
			new Driver("623480520FDF2", "Johans Bulk", "AB", "Balkvägen 12, 222 22 Stockholm"),
			new Driver("93418DF0R09QSDF", "Kalles Grustransporter", "AB", "Cementvägen 8, 111 11 Södertälje")
		);
	
	public DriverList getAllDriver() {
		DriverList driverList = new DriverList();
		driverList.setDriverList(mockDrivers);
		return driverList;
	}
	
	public Driver getDriver(String id) {
		List<Driver> result = mockDrivers.stream().filter(drive -> drive.getId().equalsIgnoreCase(id)).collect(Collectors.toList());
		if(result != null && result.size() > 0) {
			return result.get(0);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource Driver "+ id);
		//		//new Driver("93418DF0R09QSDF", "Kalles Grustransporter", "AB", "Cementvägen 8, 111 11 Södertälje");
	}
	
}
