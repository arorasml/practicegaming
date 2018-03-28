package com.robot.service;

import com.robot.component.Battery;

public interface CharginService {

	void chargeBattery(Battery obj);
	String checkBatteryStatus(Battery obj);
}
