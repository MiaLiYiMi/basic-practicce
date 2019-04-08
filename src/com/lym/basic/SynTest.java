package com.lym.basic;

public class SynTest {
    public static void main(String[] args) {
        final SynObjDemo sy=new SynObjDemo();
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                sy.showA();
            }
        }).start();
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                sy.showB();
            }
        }).start();
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                sy.showC();
            }
        }).start();
    }
}