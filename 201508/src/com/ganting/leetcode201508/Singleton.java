/**
 * 项目名称: titilink-leetcode
 * 文件名称: Singleton.java
 * Date: 2015/8/11
 * Copyright: 2015 www.titilink.com Inc. All rights reserved.
 * 注意：本内容仅限于titilink公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.ganting.leetcode201508;

import java.util.BitSet;

/**
 * 单例类的实现方式
 * <p>
 * author by ganting
 * date 2015-08-11
 * since v1.0.0
 */
public class Singleton {

    /**
     * 多线程安全无法保证
     */
    private static class Singleton1 {

        private static Singleton1 instance = null;

        private Singleton1(){}

        public static Singleton1 getInstance() {
            if ( null == instance ) {
                instance = new Singleton1();
            }
            return instance;
        }

    }

    /**
     * 每次获取实例都要加锁
     */
    private static class Singleton2 {

        private static Singleton2 instance = null;

        private Singleton2(){}

        public static synchronized Singleton2 getInstance() {
            if ( null == instance ) {
                instance = new Singleton2();
            }
            return instance;
        }

    }

    /**
     * 双重检测加锁，但是instance = new Singleton3()非原子操作，存在重排序情况
     */
    private static class Singleton3 {

        private static Singleton3 instance = null;

        private Singleton3(){}

        public static Singleton3 getInstance() {
            if ( null == instance ) {
                synchronized (Singleton3.class) {
                    instance = new Singleton3();
                }
            }
            return instance;
        }

    }

    /**
     * 通过类加载保证单例，但是没有延迟初始化特性
     * 如果不是立即用到该对象会造成内存浪费
     */
    private static class Singleton4 {

        private static Singleton4 instance = new Singleton4();

        private Singleton4(){}

        public static Singleton4 getInstance() {
            return instance;
        }

    }

    /**
     * 通过volatile来禁止重排序，然后在通过双重检测锁保证单例
     */
    private static class Singleton5 {

        private static volatile Singleton5 instance = null;

        private Singleton5(){}

        public static Singleton5 getInstance() {
            if ( null == instance ) {
                synchronized (Singleton5.class) {
                    instance = new Singleton5();
                }
            }
            return instance;
        }

    }

    /**
     * 通过内部类的延迟加载来实现延迟初始化
     * 并通过内部类的加载保证单例
     */
    private static class Singleton6 {

        private static class Singleton6Holder {
            public static final Singleton6 instance = new Singleton6();
        }

        private Singleton6(){}

        public static Singleton6 getInstance() {
            return Singleton6Holder.instance;
        }

    }

    /**
     * 通过enum的内部初始化保证单例
     */
    private enum  Singleton7 {

        INTANCE;

        Singleton7(){}

    }


}
