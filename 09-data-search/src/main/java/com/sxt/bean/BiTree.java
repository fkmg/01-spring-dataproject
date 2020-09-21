package com.sxt.bean;

public class BiTree {

    public BiTreeNode root; //树根节点

    public BiTree() {
        this.root = null;
    }

    /**
     * 中序遍历树结构
     * @param p
     */
    public void inOrderTraverse(BiTreeNode p){
        if(p != null){
            inOrderTraverse(p.getLchild());
            System.out.println(p.getData());
            inOrderTraverse(p.getRchild());
        }
    }

    /**
     * 二叉树查找方法
     * @param key
     * @return
     */
    public Object searchBST(Comparable key){
        Object result = null;

        //查询节点
        if(key != null && (key instanceof Comparable)){
            result =  searchBST(root,key);
        }

        return result;

    }

    /**
     * 二叉树查询方法
     * @param p
     * @param key
     * @return
     */
    private Object searchBST(BiTreeNode p,Comparable key){
        Object result = null;
        //1、判断节点是否为空
        if(p != null){
            //判断节点的key值是否等于key
            int count = key.compareTo(((RecordNode) p.getData()).getKey());
            //节点关键
            if(count == 0){
                result = p.getData();
            }else if(count < 0){
                result = searchBST(p.getLchild(),key);
            }else {
                result = searchBST(p.getRchild(),key);
            }
        }
        return result;
    }

    /**
     * 插入节点
     * @param key
     * @param element
     * @return
     */
    public boolean insertBST(Comparable key,Object element){
        boolean flag = false;

        //判断key的有效性
        if(key != null && key instanceof Comparable){
            //判断树是否为null
            if (root == null){
                this.root = new BiTreeNode(new RecordNode(key,element));
                flag = true;
            }else {
                flag = insertBST(root,key,element);
            }
        }

        return flag;
    }

    private boolean insertBST(BiTreeNode p,Comparable key,Object element){

        boolean flag = false;
        //判断关键字key与p节点的大小
        int count = key.compareTo(((RecordNode) p.getData()).getKey());
        //说明该节点关键字小于根节点
        if(count < 0){
            if(p.getLchild() == null){
                p.setLchild(new BiTreeNode(new RecordNode(key,element)));
                flag = true;
            }else {
               flag = insertBST(p.getLchild(),key,element);
            }
        }else if(count>0){
            if(p.getRchild() == null){
                p.setRchild(new BiTreeNode(new RecordNode(key,element)));
                flag = true;
            }else {
                flag = insertBST(p.getRchild(),key,element);
            }
        }

        return flag;
    }


}
