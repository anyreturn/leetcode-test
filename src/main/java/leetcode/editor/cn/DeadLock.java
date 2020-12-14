package leetcode.editor.cn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：xinze
 * @date ：Created by 2020/12/1 09:48
 * @description：
 * @modified By：
 * @version:
 */

public class DeadLock {

    Lock lockA = new ReentrantLock();
    Lock lockB = new ReentrantLock();

    public void methodA(){

        long threadNo = Thread.currentThread().getId();

        lockA.lock();
        try {
            lockB.lock();
            try {
                int a=0;
                while (a++<1000) {
                    System.out.println("test methodA threadNo ="+threadNo+" a= "+a);
                }

            }finally {
                lockB.unlock();
            }
        }finally {
            lockA.unlock();
        }
    }

    public void methodB(){
        long threadNo = Thread.currentThread().getId();

        lockB.lock();
        try {
            lockA.lock();
            try {
                int b=0;
                while (b++<1000) {
                    System.out.println("test methodB threadNo= "+threadNo+" b= "+b);
                }

            }finally {
                lockA.unlock();
            }
        }finally {
            lockB.unlock();
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor
            = new ThreadPoolExecutor(20,20,500, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(50));
        DeadLock deadLock = new DeadLock();
        for(int i=0; i<10;i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    deadLock.methodA();
                }
            });
        }
        for(int j=0; j<10;j++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    deadLock.methodB();
                }
            });
        }

        System.out.println("test main");
    }
}
