package com.atguigu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shkstart
 * @create 2020-11-20 21:03:51
 */
class test{
   Lock lock = new ReentrantLock();

   public void tt1(){

       for (int i =1; i <53; i=i+2) {
           lock.lock();
           System.out.println(i+(i++));
           lock.notifyAll();
       }
   }





}

public class lianxi {
    public static void main(String[] args) {
        test test = new test();

    }
}
