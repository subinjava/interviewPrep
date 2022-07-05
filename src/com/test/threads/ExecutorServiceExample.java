package com.test.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
	
	   public static void main(String[] args) {  
		 //Creates //a ExecutorService object having a single thread.  
		   ExecutorService executorService = Executors.newSingleThreadExecutor();  
	       // ExecutorService executorService = Executors.newFixedThreadPool(10);  
	        
	        //Creates a scheduled thread pool executor with 10 threads. In scheduled thread //pool, 
	        //we can schedule tasks of the threads.
	        //ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
	        executorService.execute(new Runnable() {  
	              
	            @Override  
	            public void run() {  
	                System.out.println("ExecutorService");  
	                  
	            }  
	        });  
	        executorService.shutdown();  
	    } 

}
