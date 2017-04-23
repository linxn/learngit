package com.linxn.multiThread;

/**
 * Created by Linxn on 2017/3/21.
 */
class MyThread extends Thread{
    private Thread t;
    private String threadName;

    public MyThread(String name) {
        threadName = name;
    }

    public void run(){
        System.out.println("thread " + threadName + " running...");
        try{
            for (int i = 0; i < 4 ; i++) {
                System.out.println("thread " + threadName + " sleeping...");
                Thread.sleep(50);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("thread " + threadName + " interrupted...");
        }
        System.out.println("thread " + threadName + "exiting...");
    }
    public void start(){
        System.out.println("thread " + threadName + " starting...");
        if(t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}



public class threadDemo {
    public static void main(String[] args) {
        MyThread m1 = new MyThread("Thread-1");
        m1.start();
        MyThread m2 = new MyThread("Thread-2");
        m2.start();
    }
}
