package com.sxt.bean;

/**
 * 链表节点
 */
public class Node {
	public Object data;
	public Node next;
	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
	public Node(Object data) {
		this(data,null);
	}
	public Node(){
		this(null,null);
	}
	
}
