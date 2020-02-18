package com.joah.everyday.N2020.N202002.N20200218.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 *  1、为什么用线程池，优势？
 *      线程池做的工作主要是控制运行的线程的数量，处理过程中将任务放入队列，然后在线程创建后启动这些任务，
 *      如果线程超过了最大数量的线程排队等候，等其他现车鞥只想完毕，再从队列中取出任务来执行
 *
 *      主要特点：
 *          线程复用    控制最大并发数量    管理线程
 *
 *      第一：
 *          降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗
 *      第二：
 *          提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行
 *      第三：
 *          提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一分配，调优和监控
 *
 *
 *  2、线程池如何使用？
 *      2.1、线程池：共有五种
 *          2.1.1、Executors.newScheduledThreadPool()
 *          2.1.2、Executors.newWorkStealingPool(int)    Java8新增，使用目前机器上可用的处理器作为它的并行级别
 *       ** 2.1.3、Executors.newFixedThreadPool(int)
 *                 一池固定线程
 *                 创建一个定长线程池，可控制线程最大并发数，超过的线程会在队列中等待
 *                 newFixedThreadPool 创建的线程池 corePoolSize 和 maximumPoolSize 值是相等的，它使用 LinkedBlockingQueue
 *
 *       ** 2.1.4、Executors.newSingleThreadExecutor()
 *                 一池一线程
 *                 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序执行
 *                 newSingleThreadExecutor 将 corPoolSize 和 maximumPoolSize 都设置为 1，它使用 LinkedBlockingQueue
 *
 *       ** 2.1.5、Executors.newCachedThreadPool()
 *                 一池多线程
 *                 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则建新线程
 *                 newCachedThreadPool 将 corePoolSize 设置为 0,将 maximumPoolSize 设置为 Integer.MAX_VALUE,使用的
 *                 SynchronousQueue,也就是说来了任务就创建线程运行，当线程空闲超过60秒，就销毁线程
 *
 *  3、线程池几个重要参数？
 *
 *  4、线程池地城工作原理？
 *
 *
 * @author Joah
 * @time 2020/2/18 18:01
 *
 * 第 4 种 使用java多线程类的方式  线程池
 *      （第 1 种：继承 Thread 类）
 *      （第 2 种：实现 Runnable 接口，无返回，不抛异常）
 *      （第 3 种：实现 Callable 接口，有返回）
 *
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

        /**
         * 一池 5 线程
         *
         *     public static ExecutorService newFixedThreadPool(int nThreads) {
         *         return new ThreadPoolExecutor(nThreads, nThreads,
         *                                       0L, TimeUnit.MILLISECONDS,
         *                                       new LinkedBlockingQueue<Runnable>());
         *     }
         */
        ExecutorService threadPool5 = Executors.newFixedThreadPool(5);

        /**
         * 一池 1 线程
         *
         *     public static ExecutorService newSingleThreadExecutor() {
         *         return new FinalizableDelegatedExecutorService
         *             (new ThreadPoolExecutor(1, 1,
         *                                     0L, TimeUnit.MILLISECONDS,
         *                                     new LinkedBlockingQueue<Runnable>()));
         *     }
         */
        ExecutorService threadPool1 = Executors.newSingleThreadExecutor();

        /**
         * 一池 多 线程
         *
         *     public static ExecutorService newCachedThreadPool() {
         *         return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
         *                                       60L, TimeUnit.SECONDS,
         *                                       new SynchronousQueue<Runnable>());
         *     }
         *
         */
        ExecutorService threadPool = Executors.newCachedThreadPool();

        /**
         * 模拟 10 个用户来办理业务，每个用户就是一个来自外部的请求线程
         */
        try {

            for (int i = 0; i < 10; i++) {

                threadPool.execute(() ->{
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
                TimeUnit.MILLISECONDS.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
}
