package com.robot.component;

public class Barcode {
	
	private int barCodeId;
	private String barCodeVal;
	private boolean isValid;
	
	
	public int getBarCodeId() {
		return barCodeId;
	}
	public void setBarCodeId(int barCodeId) {
		this.barCodeId = barCodeId;
	}
	public String getBarCodeVal() {
		return barCodeVal;
	}
	public void setBarCodeVal(String barCodeVal) {
		this.barCodeVal = barCodeVal;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

}
