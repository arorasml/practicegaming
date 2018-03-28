package com.resourcepool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class ResourcePool 
{
	
	int limit;
	BlockingQueue<ReusableDelayedResource> poolObjs = new DelayQueue<ReusableDelayedResource>();
    ResourceCreatorThread creatorThread;
    Thread workerThread;
    
    public ResourcePool(int limit) {
    	
    	this.limit = limit;
    	creatorThread = new ResourceCreatorThread(poolObjs, limit);
    	workerThread = new Thread(creatorThread);
    	workerThread.start();
		// TODO Auto-generated constructor stub
	}
    
    
    public ReusableDelayedResource getResource() throws InterruptedException
    {
    	return poolObjs.take();
    }
	
    
    private void shutdown()
    {
    	poolObjs = null;
    	if(workerThread != null)
    	{
    		workerThread.interrupt();
    	}
    }
}
