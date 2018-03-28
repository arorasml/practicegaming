package com.robot.service.impl;

import com.robot.component.Battery;
import com.robot.component.DisplayIndicator;
import com.robot.service.CharginService;

public class CharginServiceImpl implements CharginService{
	

	@Override
	public void chargeBattery(Battery obj) {
		
		
		obj.setChargeVal(100);
		
	}

	@Override
	public String checkBatteryStatus(Battery obj) {
		
		
		if(obj.getChargeVal() < 15)
		{
			return DisplayIndicator.RED.getIndicatorColor();
		}
		
		return DisplayIndicator.GREEN.getIndicatorColor();
		
	}

}
