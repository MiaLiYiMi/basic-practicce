package com.lym.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
	public static void main(String[] args) {
		ExecutorService fixedThreadPool=Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
		    final int index = i;
		    //submit
//		    fixedThreadPool.submit(new Callable<Integer>() {
//
//				@Override
//				public Integer call() throws Exception {
//					// TODO Auto-generated method stub
//					return null;
//				}
//			});
		    
		    //execute
		    fixedThreadPool.execute(new Runnable() {
		        @Override
		        public void run() {
		            try {
		                System.out.println(index);
		                Thread.sleep(2000);
		            } catch (InterruptedException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		        }
		    });
		}
	}
}
