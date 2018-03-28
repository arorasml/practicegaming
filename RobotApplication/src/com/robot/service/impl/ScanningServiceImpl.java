package com.robot.service.impl;

import com.robot.component.Barcode;
import com.robot.service.ScanningService;

public class ScanningServiceImpl implements ScanningService
{

	@Override
	public int scannedBarCode(Barcode obj) {
		// TODO Auto-generated method stub
		
		
		//processing to check bar code validation
		//if not valid
		obj.setValid(false)	;
		
		//else return barcode value
		
		return 0;
		
		
	}

}
