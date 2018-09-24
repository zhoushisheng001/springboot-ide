package com.zhuguang.zhou.semaplest;

import com.zhuguang.zhou.model.NumberInc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author  zhoushisheng
 * 限定访问资源
 */
public class SemapTest {

    /**
     * 成员内部类
     */
    class MyTask implements Runnable {
        private Semaphore se;
        private int num;

        public MyTask() {
        }

        public MyTask(Semaphore se) {
            this.se = se;
        }

        public MyTask(Semaphore se, int num) {
            this.se = se;
            this.num = num;
        }

        @Override
           public void run() {
               try{
                    se.acquire();//获得资源
                    System.out.println("准备开始买票..." + num);
                    Thread.sleep(2000);
                    System.out.println("买好了票准备离开..." + num);
                    Thread.sleep(2000);
                    System.out.println("离开了..." + num);
                    se.release();
               }catch (Exception e){
                   e.printStackTrace();
               }
           }
       }

       private void myRunnner () {
           ExecutorService executorPool = Executors.newCachedThreadPool();
           //NumberInc inc = new NumberInc();
           Semaphore se = new Semaphore(2);
           for (int i=0;i<10;i++) {
                MyTask task = new MyTask(se,i);
                executorPool.execute(task);
           }
           executorPool.shutdown();
       }

       public static void main(String[] args) {
           SemapTest test = new SemapTest();
           test.myRunnner();
       }

}
