package com.resourcepool;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class ReusableDelayedResource implements Delayed
{

	private long expiryDelay;
	
	
	
	public ReusableDelayedResource(long expiryDelay) {
		super();
		this.expiryDelay = expiryDelay;
	}

	@Override
	public int compareTo(Delayed o) {
		// TODO Auto-generated method stub
		return (int) (this.expiryDelay - ((ReusableDelayedResource)o).getExpiryDelay());
	}

	@Override
	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		
		long diff = expiryDelay - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	public long getExpiryDelay() {
		return expiryDelay;
	}

	
	public void printVal()
	{
		System.out.println("in process");
	}
}
