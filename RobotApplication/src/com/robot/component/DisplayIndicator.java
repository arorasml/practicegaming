package com.robot.component;

public enum DisplayIndicator {
	
	RED("RED"),
	GREEN("GREEN"),
	OVERWEIGHT("OVERWEIGHT");
	
	private String color;
	
	DisplayIndicator(String color)
	{
		this.color = color;
	}
	
	public String getIndicatorColor()
	{
		return color;
	}

}
