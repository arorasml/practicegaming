package com.resourcepool;

import java.util.concurrent.BlockingQueue;

public class ResourceCreatorThread implements Runnable
{
	
	private BlockingQueue<ReusableDelayedResource> queue;
	private int limit;
	private static long delay = 10;
	

	public ResourceCreatorThread(BlockingQueue<ReusableDelayedResource> queue, int limit) {
		super();
		this.queue = queue;
		this.limit = limit;
	}



	@Override
	public void run() {
		
		while(queue.size() < limit)
		{
			ReusableDelayedResource res = new ReusableDelayedResource(delay);
			queue.add(res);
		}
		// TODO Auto-generated method stub
		
	}

}
