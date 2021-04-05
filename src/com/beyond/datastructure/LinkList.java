package com.beyond.datastructure;

import org.omg.PortableInterceptor.USER_EXCEPTION;

/**
 * 单链表
 **/
public class LinkList<T> {

    /**
     * 头指针
     */
    private Node<T> head;
    /**
     * 尾指针
     */
    private Node<T> tail;


    /**
     *  链表节点类
     **/
    class Node<T>{
        /**
         * 节点-数据域
         */
        private T data;
        /**
         * 节点-指针域
         */
        private Node next;
    }
}
