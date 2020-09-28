package com.sxt;

import com.sxt.bean.BiTree;
import com.sxt.bean.ElementType;
import com.sxt.bean.KeyType;
import org.junit.Before;
import org.junit.Test;

public class testReflect {
    
    private BiTree biTree;

    @Test
    public void testGetClass(){
        System.out.println(Double.class.getName());
        
        System.out.println(Float.class.getName());
        
        System.out.println(Integer.class.getName());
        
        System.out.println(String.class.getName());
        
        Object mm = Double.valueOf("123.0");
        
        System.out.println(mm.getClass().getName());
    }

    @Before
    public void initBitree(){
        biTree = new BiTree();
        
        Integer [] k = {50,13,63,8,36,90,5,10,18,70};
        
        String[] item = {"HL","YM","MG","JX","Chen","Yang","Huang","FK","ZYJ","BJQS"};

        KeyType [] key = new KeyType[k.length];

        ElementType [] elem = new ElementType[item.length];
        
        System.out.println("中序列为:");
        
        for(int i = 0; i< k.length;i++){
            key[i] = new KeyType(k[i]);
            
            elem[i] = new ElementType(item[i]);

            biTree.insertBST(key[i],elem[i]);

            /*if (biTree.insertBST(key[i],elem[i])){
                System.out.println("["+key[i]+","+elem[i]+"]");
            }*/
        }

        biTree.inOrderTraverse(biTree.root);
    }

    @Test
    public void testInOrderTraverse(){
        System.out.println("中序排序为:");
        if(biTree != null && biTree.root != null){
            biTree.inOrderTraverse(biTree.root);
        }
    }

    /**
     * 测试查询
     */
    @Test
    public void testSearch(){
        KeyType key = new KeyType();
        key.setKey(63);
        Object found = biTree.searchBST(key);
        if(found != null){
            System.out.println("查找成功!");
            System.out.println(found);
        }
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete(){
        KeyType key = new KeyType();
        key.setKey(8);
        Object found = biTree.removeBST(key);
        if(found != null){
            System.out.println("删除成功!");
            System.out.println(found);
        }

        System.out.println("中序遍历序列");
        biTree.inOrderTraverse(biTree.root);
    }
}
