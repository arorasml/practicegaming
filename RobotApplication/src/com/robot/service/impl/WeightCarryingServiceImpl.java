package com.robot.service.impl;

import com.robot.component.DisplayIndicator;
import com.robot.service.WeightCarryingService;

public class WeightCarryingServiceImpl implements WeightCarryingService {

	@Override
	public String canCarryWeight(double weight) {
		// TODO Auto-generated method stub
		if(weight > 10)
		{
			System.out.println("OVER WEIGHT");
			return DisplayIndicator.OVERWEIGHT.getIndicatorColor();
		}
		
		return null;
	}

	@Override
	public float chargingUsedWithWeight(double weight) {
		return (float) (weight * 2);
	}
	
	@Override
	public float chargingUsedWithOutWeight(double km) {
		float chargingUsed = (float) ((100/5)*km);
		
		return chargingUsed;
	}

	@Override
	public boolean walkWithoutWeight(double walkingDistance) {
		// TODO Auto-generated method stub
		if(walkingDistance > 5)
		{
			System.out.println("can't walk more than 5 kms");
			return false;
		}
		return true;
	}

	@Override
	public float walkWithWeight(double walkingDistance, double weight) {
		// TODO Auto-generated method stub
		
		float chargingUsedWithWalkOnly = chargingUsedWithOutWeight(walkingDistance);
		float chargingUsedWithWeight = chargingUsedWithWeight(weight);
		
		return (chargingUsedWithWalkOnly + chargingUsedWithWeight);
	}

	
	

}
