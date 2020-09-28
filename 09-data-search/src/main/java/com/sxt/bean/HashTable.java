package com.sxt.bean;

import com.sxt.list.LinkList;

public class HashTable<E> {

    private LinkList[] table;

    public HashTable(int size) {
        this.table = new LinkList[size];

        for(int i = 0; i< size;i++){
            table[i] = new LinkList();
        }
    }

    public LinkList[] getTable() {
        return table;
    }

    public void setTable(LinkList[] table) {
        this.table = table;
    }

    /**
     * 获取地址
     * @param key
     * @return
     */
    public int hash(int key){
        return key % table.length;
    }

    /**
     * 向hash表中插入数据
     * @param element
     */
    public void insert(E element) throws Exception {
        //1、计算地址
        int key = element.hashCode();
        int index = hash(key);
        this.table[index].insert(0,element);
    }

    /**
     * 打印hash表中的数据
     */
    public void printHashTable(){
        for(int i = 0; i< table.length;i++){
            System.out.print("table["+i+"]=");
            this.table[i].display();
        }
    }

    /**
     * 在hash表中查找指定对象，若查找成功,成功返回节点;否则返回null
     * @param element
     * @return
     */
    public Node search(E element) throws Exception {
        int key = element.hashCode();
        int i = hash(key);
        int index = table[i].indexOf(element);

        Node node = null;

        if(index >=0){
            node =(Node) table[i].get(index);
        }

        return node;
    }

    /**
     * 判断节点是否存在
     * @param element
     * @return
     */
    public boolean contain(E element){
        Boolean falg = false;
        int key = element.hashCode();

        int i = hash(key);

        int index = this.table[i].indexOf(element);

        return index >= 0;
    }

    /**
     * 移除元素
     * @param element
     */
    public boolean remove(E element) throws Exception {

        boolean flag = false;

        int key = element.hashCode();

        int i = hash(key);

        int index = this.table[i].indexOf(element);

        if(index >= 0){
            this.table[i].remove(index);
            flag = true;
        }

        return flag;
    }
}
