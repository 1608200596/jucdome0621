package com.atguigu.juc;

import sun.security.krb5.internal.tools.Klist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shkstart
 * @create 2020-11-25 9:24:22
 */

class ss{
    private Object object1 =new Object();
    private Object object2 =new Object();

    public static void lockObject(Object o){
        System.out.println("o = " + o);
    }
    //创建可重入锁
    Lock lock = new ReentrantLock();
    //编写方法
    public void t1(){

        //上锁
        lock.lock();
        ss.lockObject(object1);
        try {

            System.out.println("1线程，等待二线城");
            TimeUnit.SECONDS.sleep(1);
            lock.notify();
            ss.lockObject(object2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
//            lock.unlock();
        }
    }

    //编写方法
    public void t2(){
        //上锁
        lock.lock();
        ss.lockObject(object2);
        try {
            System.out.println("2线程，等待二线城");
            TimeUnit.SECONDS.sleep(1);
//            lock.notifyAll();
            ss.lockObject(object1);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
//            lock.unlock();
        }
    }
}
public class siSuo {
    public static void main(String[] args) {
        ss ss = new ss();
        new Thread(()->{
            ss.t1();

        },"A").start();

        new Thread(()->{
            ss.t2();

        },"B").start();
    }
}
