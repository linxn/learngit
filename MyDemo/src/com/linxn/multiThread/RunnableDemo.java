package com.linxn.multiThread;

/**
 * Created by Linxn on 2017/3/21.
 */
class RunnableThread implements Runnable{
    private Thread t;
    private String threadName;

    public RunnableThread(String name) {
        threadName = name;
    }

    @Override
    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start(){
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}




public class RunnableDemo {
    public static void main(String[] args) {
        RunnableThread r1 = new RunnableThread("thread1");
        r1.start();
        RunnableThread r2 = new RunnableThread("thread2");
        r2.start();
        RunnableThread r3 = new RunnableThread("thread3");
        r3.start();
    }

}
