package br.com.danilopaixao.driver.test.service;


import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.danilopaixao.driver.model.Driver;
import br.com.danilopaixao.driver.repository.DriverRepository;
import br.com.danilopaixao.driver.service.DriverService;
import br.com.danilopaixao.driver.test.builder.DriverTestBuilder;


@RunWith(MockitoJUnitRunner.class)
public class DriverServiceTest {

	@InjectMocks
	private DriverService driverService;
	
	@Mock
	private DriverRepository driverRepository;
	
	private DriverTestBuilder driverBuilder;
	
	@Before
    public void init() {
		driverBuilder = new DriverTestBuilder();
    }
	
	@Test
	public void testInsertNewDriver() throws Exception{
		Driver driverInserted = driverBuilder.buildRandom();
		
		when(driverRepository.insert(driverInserted)).thenReturn(driverInserted);
		
		Driver newDriver = driverService.insertNew(driverInserted);
		assertSame(newDriver, driverInserted);
	}
	
	@Test
	public void testSaveDriver() throws Exception{
		Driver driver = driverBuilder.buildRandom();
		
		when(driverRepository.save(driver)).thenReturn(driver);
		
		Driver driverUpdated = driverService.save(driver);
		assertSame(driverUpdated, driver);
	}
	
}
