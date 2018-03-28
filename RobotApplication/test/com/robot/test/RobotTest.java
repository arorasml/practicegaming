package com.robot.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.robot.component.Battery;
import com.robot.service.CharginService;
import com.robot.service.WeightCarryingService;
import com.robot.service.impl.CharginServiceImpl;
import com.robot.service.impl.WeightCarryingServiceImpl;
import com.service.main.Robot;
public class RobotTest {
	
	Battery battery;
	CharginService chargingService;
	WeightCarryingService weightCarryingService;
    Robot robot;;
	
	
	@Test
	public void testCarryWeight() {
		
		battery = new Battery();
		chargingService = new CharginServiceImpl();
		weightCarryingService = new WeightCarryingServiceImpl();
	    robot = new Robot(battery,chargingService,null,weightCarryingService);
		assertEquals("OVERWEIGHT",robot.canCarryWeight(12));
	
	}
	@Test()
	public void testWalkWithWeight() {
		battery = new Battery();
		chargingService = new CharginServiceImpl();
		weightCarryingService = new WeightCarryingServiceImpl();
	    robot = new Robot(battery,chargingService,null,weightCarryingService);
		assertEquals(54,robot.walkWithWeight(2, 3),0);
		
	}
    @Test
	public void testWalkWithoutWeight() {
		battery = new Battery();
		chargingService = new CharginServiceImpl();
		weightCarryingService = new WeightCarryingServiceImpl();
	    robot = new Robot(battery,chargingService,null,weightCarryingService);
		
		assertEquals(30,robot.walkWithoutWeight(3.5),0);
	}
	

}
