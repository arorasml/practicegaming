package com.robot.service;

public interface WeightCarryingService {

	String canCarryWeight(double weight);
	float chargingUsedWithWeight(double weight);
	float chargingUsedWithOutWeight(double km);

			
	boolean walkWithoutWeight(double walkingDistance);
	float walkWithWeight(double walkingDistance, double weight);
}
