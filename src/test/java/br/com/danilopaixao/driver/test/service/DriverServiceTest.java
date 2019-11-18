package br.com.danilopaixao.driver.test.service;


import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DriverServiceTest {
/*
	@InjectMocks
	private VehicleService vehicleService;
	
	@Mock
	private DriverService driverService;
	
	@Mock
	private VehicleSocketService vehicleSocketService;
	
	@Mock
	private VehicleMongoRepository vehicleMongoRepository;
	
	private VehicleTestBuilder vehicleBuilder;
	
	@Before
    public void init() {
		vehicleBuilder = new VehicleTestBuilder();
    }
	
	@Test
	public void testUpdateVehicleON() throws Exception{
		Vehicle vehicleGet = vehicleBuilder.buildRandom(StatusEnum.OFF);
		Optional<Vehicle> vOptional = Optional.of(vehicleGet);
		when(vehicleMongoRepository.findById(vehicleGet.getVin())).thenReturn(vOptional);
		Vehicle vReturned = vehicleService.updateStatus(vehicleGet.getVin(), StatusEnum.ON);
		assertSame(StatusEnum.ON, vReturned.getStatus());
	}
	
//	@Test(expected = RestClientException.class)
//	public void testUpdateVehicleONWebSocketError() throws Exception{
//		Vehicle vehicleGet = vehicleBuilder.buildRandom(StatusEnum.OFF);
//		Optional<Vehicle> vOptional = Optional.of(vehicleGet);
//		when(vehicleSocketService.updateStatusWebSocket(vehicleGet.getVin(), StatusEnum.ON))
//										.thenThrow(RestClientException.class);
//		when(vehicleMongoRepository.findById(vehicleGet.getVin())).thenReturn(vOptional);
//		Vehicle vReturned = vehicleService.updateStatus(vehicleGet.getVin(), StatusEnum.ON);
//	}
	
	@Test
	public void testUpdateVehicleOFF() throws Exception{
		Vehicle vehicleGet = vehicleBuilder.buildRandom(StatusEnum.ON);
		Optional<Vehicle> vOptional = Optional.of(vehicleGet);
		when(vehicleMongoRepository.findById(vehicleGet.getVin())).thenReturn(vOptional);
		Vehicle vReturned = vehicleService.updateStatus(vehicleGet.getVin(), StatusEnum.OFF);
		assertSame(StatusEnum.OFF, vReturned.getStatus());
	}
		
	@SuppressWarnings("static-access")
	@Test
	public void testUpdateVehicleNotFound() throws Exception{
		Vehicle vehicleGet = vehicleBuilder.buildRandom(StatusEnum.ON);
		when(vehicleMongoRepository.findById(vehicleGet.getVin()))
						.thenReturn(Optional.ofNullable(null).empty());
		Vehicle vReturned = vehicleService.updateStatus(vehicleGet.getVin(), StatusEnum.OFF);
		assertSame(null, vReturned);
	}*/
	
}