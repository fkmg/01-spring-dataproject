package com.sxt;

import com.sxt.bean.HashTable;
import org.apache.log4j.Logger;
import org.junit.Test;

public class TestHashTable {

    private Logger log = Logger.getLogger(TestHashTable.class);

    @Test
    public void testHashTableOperate() throws Exception {
        String [] name ={"Wang","Li","Zhang","Liu","Chen","Yang",
                "Huang","Zhao","Wu","Zhou","Du"};

        HashTable<String> ht = new HashTable<>(7);

        String elem1,elem2;

        //1、初始化hashtable
        //System.out.println("插入元素");
        log.debug("插入元素");
        for(int i = 0; i< name.length;i++){
            ht.insert(name[i]);
            log.debug("插入元素:"+name[i]);
        }

        System.out.println("原hash序列为:");
        ht.printHashTable();

        elem1 = name[2];

        log.debug("查找"+elem1+","+(ht.contain(elem1)?"sucessful":"false"));

        elem2 = "san";

        log.debug("查找"+elem2+","+(ht.contain(elem2)?"sucessful":"false"));

        log.debug("删除"+elem1+","+(ht.remove(elem1)?"sucessful":"false"));

        log.debug("删除"+elem2+","+(ht.remove(elem2)?"sucessful":"false"));

        System.out.println("新hash表为:");

        ht.printHashTable();
    }


}
