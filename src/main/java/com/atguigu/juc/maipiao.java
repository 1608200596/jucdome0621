package com.atguigu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shkstart
 * @create 2020-11-20 20:27:27
 */

//先创建资源类
class mai {
    //假设有30张票
    private Integer a = 30;

    //创建可重入锁
    Lock lock = new ReentrantLock();

    //编写方法
    public void ss(){
        //上锁
        lock.lock();

        try {
            //判断
            if (a>0){
                //干活
                System.out.println(Thread.currentThread().getName()+"卖出票号:"+(a--)+"剩余票数"+a);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
            lock.unlock();
        }
    }

}
public class maipiao {
    public static void main(String[] args) {
        //先创建一个资源类
        mai mai = new mai();
        //创建三个线程,通过new thread里面的方法，匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <40; i++) {
                    mai.ss();

                }
            }
        },"AA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <40; i++) {
                    mai.ss();

                }
            }
        },"BB").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <40; i++) {
                    mai.ss();

                }
            }
        },"CC").start();
        //lamd表达式写法
        new Thread(()->{
            for (int i = 1; i <40; i++) {
                mai.ss();

            }
        },"DD").start();

    }

}
