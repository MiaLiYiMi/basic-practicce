package com.lym.threads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ 通过运行结果我们可以发现,每次执行输出的value值并非我们预期的那样输出1000
 * @ ConcurrentHashMap的线程安全指的是，它的每个方法单独调用（即原子操作）都是线程安全的
 * @ 而在下面的代码中我们可以发现map.put("key", map.get("key")+1)其实是3个操作，get,+1,put
 * @ map本身是一个共享变量,当线程A执行map.get的时候，其它线程可能正在执行map.put,这样一来当线程A执行到map.put的时候,线程A的值就已经是脏数据了
 * 
 * @ 如果我们在run方法上加上synchronized,对方法加锁，每次执行输出的value值同样不能得到预期的结果
 * @ 如果我们在run方法体内加上synchronized,对代码块加锁，对map对象加锁，输出的value值才符合我们的预期，
 * @ 那此时ConcurrentHashMap的作用就不大了，可以直接将代码中的map换成普通的HashMap，以减少由ConcurrentHashMap带来的锁开销
 * 
 * @不管synchronized是用来修饰方法，还是修饰代码块，其本质都是锁定某一个对象。
 * @修饰方法时，锁上的是调用这个方法的对象，即this；
 * @修饰代码块时，锁上的是括号里的那个对象
 * 
 */
public class ThreadSafeTest {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new ConcurrentHashMap<>();
		map.put("key1", 1);
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					map.put("key1", map.get("key1") + 1);
				}
			}).start();
		}
		System.out.println(map.get("key1"));

		//=======================同步方法==================================
		Map<String, Integer> map2 = new ConcurrentHashMap<>();
		map2.put("key2", 1);
		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {

				@Override
				public synchronized void run() {
					map2.put("key2", map2.get("key2") + 1);
				}
			}).start();
		}
		System.out.println(map2.get("key2"));

		//=======================同步代码块============================
		Map<String, Integer> map3 = new ConcurrentHashMap<>();
		map3.put("key3", 1);

		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					synchronized (map3) {
						System.out.println(map3.get("key3")+"----"+Thread.currentThread().hashCode());
						map3.put("key3", map3.get("key3") + 1);
					}
				}
			}).start();
		}
	}

}
