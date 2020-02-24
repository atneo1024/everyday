package com.joah.everyday.N2020.N202002.N20200223.JUC;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

/**
 *
 * 1、JUC是什么？
 *  Java.util.concurrent            在并发编程中使用的工具类
 *  java.util.concurrent.atomic     并发原子包
 *  java.util.concurrent.locks      并发锁
 *
 *
 * 2、什么是进程 / 线程？
 *
 *  2.1、进程
 *      进程是一个具有一定独立功能的程序关于某个数据集合的一次运行活动，它是操作系统动态执行的基本单元
 *      在传统的操作系统中，进程即是基本的分配单元，也是基本的执行单元
 *
 *      QQ.exe  newMusic.exe    winword.exe 所有运行的应用程序
 *
 *  2.2、线程
 *      通常在一个进程中可以包含若干哥线程，当然一个进程中至少有一个线程，不然没有存在的意义。
 *      线程可以利用进程所拥有的资源，在引入线程的操作系统中，通常都是把进程作为分配资源的基本单位
 *      而把线程作为独立运行和独立调度的基本单位，由于线程比进程更小，基本上不拥有系统资源，
 *      故对它的调度所付出的开销就会小得多，能更高效的提高系统多个程序间并发执行的程度
 *
 *      winword.exe 进程中的
 *          容灾备份线程
 *          语法检查线程
 *      QQ.exe  进程中的
 *          语音聊天线程
 *          文字聊天线程
 *
 * 3、什么是并发 / 并行？
 *
 *  3.1、并发
 *
 *
 *      同一时间，争取同一资源
 *
 *  3.2、并行
 *
 *      “泡方便面”就是并行
 *      同一时间，进行不一样的事情
 *
 *
 *
 *
 *
 * @author Joah
 * @time 2020/2/23 10:39
 */
public class JUCDemo {

}
