package com.beyond.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 使用数组实现队列
 */
public class ArrayQueue {

    /**
     * 队列大小
     */
    private int maxSize;
    /**
     * 头指针
     */
    private int head;
    /**
     * 尾指针
     */
    private int tail;
    /**
     * 存储数据
     */
    private Object[] array;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new Object[maxSize];
        // 指向队列头，即队列头的前一个位置
        head = -1;
        // 指向队列尾，即指向队列最后一个数据
        tail = -1;
    }

    public boolean isFull() {
        return tail == maxSize - 1;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void push(Object element) {
        if (isFull()) {
            throw new RuntimeException("queue is full !");
        }
        // 尾指针后移，存入数据到队列末尾
        array[++tail] = element;
    }

    public Object pull() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty !");
        }
        // 头指针前移，返回队列第一个元素
        return array[++head];
    }


}
