package com.service.main;

import com.robot.component.Barcode;
import com.robot.component.Battery;
import com.robot.service.CharginService;
import com.robot.service.ScanningService;
import com.robot.service.WeightCarryingService;

public class Robot {
	
	private Battery batteryOb;
	private CharginService chargingService;
	private ScanningService scanningService;
	private WeightCarryingService weightCarryingService;
	
	
	public Robot(Battery batteryOb, CharginService chargingService, ScanningService scanningService,
			WeightCarryingService weightCarryingService) {
		super();
		this.batteryOb = batteryOb;
		this.chargingService = chargingService;
		this.scanningService = scanningService;
		this.weightCarryingService = weightCarryingService;
	}
	
	//method using charging service
	
	public String checkBatteryStatus(Battery obj)
	
	{
		return chargingService.checkBatteryStatus(obj);
	}
	
	
	//method using scanning service
	public int scannedBarCode(Barcode obj) {
		return scanningService.scannedBarCode(obj);
	}
	
	
	// methods using weight carrying service
	
	public String canCarryWeight(int weight)
	{
		return weightCarryingService.canCarryWeight(weight);
	}
	
	public float carryWeight(int weight) {
		
		String checkCapacity = weightCarryingService.canCarryWeight(weight);
		float chargingUsed = 0;
		
		if(("OVERWEIGHT").equals(checkCapacity))
		{
			System.out.print("% battery left is : 100 % ");
			return chargingUsed;
		}
		
		else
		{
			chargingUsed = weightCarryingService.chargingUsedWithWeight(weight);
		}
	
		float leftOverCharging = 100 - chargingUsed;	
		System.out.print("% battery left is : " + leftOverCharging);
		return leftOverCharging;
	
	}
	
	public float walkWithWeight(int walkingDistance, int weight) {

		float chargingUsed = weightCarryingService.walkWithWeight(walkingDistance, weight);
		float leftOverCharging = 100 - chargingUsed;		
		
		System.out.print("% battery left is : " + leftOverCharging);
		return leftOverCharging;
		
	}

	public float walkWithoutWeight(double km) {
		
		float chargingUsed =weightCarryingService.chargingUsedWithOutWeight(km);
     	float leftOverCharging = 100 - chargingUsed;	
		System.out.print("% battery left is : "+ leftOverCharging);
		return leftOverCharging;
	}
	
	
	
	
//	public static void main(String[] args) {
//		
//		Battery battery = new Battery();
//		CharginService chargingService = new CharginServiceImpl();
//		WeightCarryingService weightCarryingService = new WeightCarryingServiceImpl();
//	    Robot robot = new Robot(battery,chargingService,null,weightCarryingService);
//		
//	    robot.carryWeight(12);
//		
////	    System.out.println(robot.walkWithoutWeight(3.5));
////	    
////	    System.out.println(robot.walkWithWeight(2, 3));

		
		
	//}
	
	
	

}
