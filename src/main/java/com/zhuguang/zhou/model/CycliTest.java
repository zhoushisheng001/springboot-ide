package com.zhuguang.zhou.model;

import sun.awt.geom.AreaOp;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author  ex-zhoushisheng001
 * 达到指定的线程数量再一起执行里面的方法
 * CyclicBarrier
 */
public class CycliTest {

    /**
     * 写法一
     * @param
     */
     /*  public static void main(String[] args) {
           final CyclicBarrier cyc = new CyclicBarrier(9);
           for (int i = 0;i<10;i++) {
               final int user = i;
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       try{
                           System.out.println("员工suer到了：" + user);
                           cyc.await();
                           Thread.sleep(3000);
                           System.out.println("到期了了开始吃饭..." + user);
                       }catch (Exception e){
                           e.printStackTrace();
                       }
                   }
               }).start();
           }
       }*/


    class myCycTask implements Runnable {
        private CyclicBarrier cyc;
        private int sum;
        public myCycTask(CyclicBarrier cyc, int sum) {
            this.cyc = cyc;
            this.sum = sum;
        }
        @Override
        public void run() {
            try{
                System.out.println("员工来了User:" +sum );
                Thread.sleep(5000*sum);
                System.out.println("员工User:准备好了" +sum );
                cyc.await();
                System.out.println("开始吃饭了哈哈。。。" + sum);
            }catch (Exception e) {
               e.printStackTrace();
            }
        }
    }

    public void runTask() {
        ExecutorService executorPool =  Executors.newCachedThreadPool();
        CyclicBarrier cyc = new CyclicBarrier(3);
        for (int i= 0;i<3;i++){
            myCycTask task = new myCycTask(cyc,i);
            executorPool.execute(task);
        }
        executorPool.shutdown();
    }

    public static void main(String[] args) {
        CycliTest cycliTest = new CycliTest();
        cycliTest.runTask();
    }
}
