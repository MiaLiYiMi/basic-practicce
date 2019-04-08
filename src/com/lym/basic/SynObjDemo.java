package com.lym.basic;

/**
 * @author liym
 * 线程同步问题大都使用synchronized解决,有同步代码块和同步方法的两种方式
 * 同步方法直接在方法上加synchronized实现加锁，同步代码块则在方法内部加锁，
 * 很明显，同步方法锁的范围比较大，而同步代码块范围要小点，一般同步的范围越大，性能就越差，一般需要加锁进行同步的时候，肯定是范围越小越好，这样性能更好
 * 
 * 
 * 一、当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。
 * 二、当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。 
 * 三、当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。
 */
public class SynObjDemo{
    public synchronized void showA(){
        System.out.println("showA..");
        try {
        	//休眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void showB(){
        synchronized (this) {
            System.out.println("showB..");
        }
    }
    
    public void showC(){
        String s="1";
        synchronized (s) {
            System.out.println("showC..");
        }
    }
}