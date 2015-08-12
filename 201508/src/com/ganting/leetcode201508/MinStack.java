/**
 * 项目名称: titilink-leetcode
 * 文件名称: MinStack.java
 * Date: 2015/8/11
 * Copyright: 2015 www.titilink.com Inc. All rights reserved.
 * 注意：本内容仅限于titilink公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.ganting.leetcode201508;

import java.util.EmptyStackException;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * <p>
 * 
 * author by ganting
 * date 2015-08-12
 * since v1.0.0
 */
public class MinStack {

    private Entry<Integer> header;

    private int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int x) {
        Entry<Integer> newEntry = new Entry<>(x, header);
        header = newEntry;
        if ( x < min ) min = x;
    }

    public void pop() {
        if ( null == header )
            throw new EmptyStackException();
        if ( header.k == min ) {
            //重新寻找min
            int newMin = Integer.MAX_VALUE;
            Entry<Integer> minEntry = header.next;
            while (null != minEntry) {
                if ( minEntry.k < newMin ) newMin = minEntry.k;
                minEntry = minEntry.next;
            }
            min = newMin;
        }
        header = header.next;
    }

    public int top() {
        if ( null == header )
            throw new EmptyStackException();
        return header.k;
    }

    public int getMin() {
        return min;
    }

    private class Entry<K> {
        public K k;
        public Entry<K> next;
        public Entry(K k, Entry<K> next) {
            this.k = k;
            this.next = next;
        }
        public String toString() {
            return this.k.toString();
        }
    }
}
