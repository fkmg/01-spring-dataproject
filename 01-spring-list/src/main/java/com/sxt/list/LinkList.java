package com.sxt.list;


import com.sxt.bean.Node;

public class LinkList implements IList {
    //带头节点的链表
    public Node head;

    public LinkList(){
        head=new Node();
    }

    /**
     * 清空链表
     */
    public void clear() {
        head.data=null;
        head.next=null;
    }

    /**
     * 判断线性表是否为空
     * @return
     */
    public boolean isEmpty() {
        return head.next==null;
    }

    /**
     * 得到线性表的长度
     * @return
     */
    public int length() {
        int length=0;
        Node p=head.next;
        while(p!=null){
            length++;
            p=p.next;
        }
        return length;
    }

    /**
     * 获取链表第i个值
     * @param i
     * @return
     * @throws Exception
     */
    public Object get(int i) throws Exception {

        int j=0;
        Node p=head.next;
        while(p!=null&&j<i){
            j++;
            p=p.next;
        }
        if(i<0||p==null){
            throw new Exception("第"+i+"个元素不存在");
        }
        return p.data;
    }

    /**
     * 带头节点的插入算法
     * i的取值为0到n
     */
    public void insert(int i, Object x) throws Exception {
        Node p=this.head;
        int j=-1;
        while(p.next!=null&&j<i-1){//可以改成j=0,while(p!=null&&j<i-1)
            p=p.next;
            j++;
        }

        //当j>i-1时说明插入的位置是线性表前边超范围
        if(j>i-1||p==null){
            throw new Exception("插入位置不存在");
        }
        Node s=new Node(x);
        s.next=p.next;
        p.next=s;

    }

    /**
     * 带头节点的删除操作
     */
    public void remove(int i) throws Exception {//i的取值范围是1~线性表的长度
        int j=0;
        Node p=head;
        //Node q;不必要的
        while(p!=null&&j<i-1){
            p=p.next;
            j++;
        }
        if(j>=i||p==null){//j>i说明i<0
            throw new Exception("要删除的点不存在");
        }
        //q=p.next;//q=p.next;
        p.next=p.next.next;//p=q.next;
        //q=null;
    }

    /**
     * 查询节点 x在链表中的位置
     * @param x
     * @return
     */
    public int indexOf(Object x)  {
        Node p=head.next;
        int j=0;
        while(p!=null&&!p.data.equals(x)){
            p=p.next;
            j++;
        }
        if(p==null){
            return -1;
        }
        return j;
    }

    /**
     * 输出各个元素的值
     */
    public void display() {
        Node p=head.next;
        while(p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println();
    }





    /**
     * 不带头节点的插入算法
     * @param i
     * @param x
     */
    public void insertf(int i,Object x) throws Exception{
        Node p=head;
        int j=-1;
        while(p!=null&&j<i-1){
            p=p.next;
            j++;
        }
        if(j>=i||p==null){
            throw new Exception("要插入的位置不存在");
        }
        Node s=new Node(x);
        if(i==0){
            s.next=head;
            head=s;
        }else{
            s.next=p.next;
            p.next=s;
        }
    }
    /**
     * 不带头节点的删除操作
     */
    public void delete(int i,Object x) throws Exception{
        Node q,p=head;
		/*if(i<0&&head==null){
			throw new Exception("删除节点不存在");
		}*/
        int j=0;
        while(p!=null&&j<i-1){
            p=p.next;
            j++;
        }
        if(j>i||p==null){
            throw new Exception("删除节点不存在");
        }
        if(i==0){
            head=p.next;
            p=null;
        }else{
            q=p.next;
            p.next=p.next;
            q=null;
        }

    }
    /**
     * 在有序的线性表中插入一个节点值为x
     * @param x
     */
    public void insert1(int x){
        Node p=head;
        Node q=head.next;
        while(q!=null){
            int temp=((Integer)q.data).intValue();
            if(temp<x){
                p=q;
                q=q.next;
            }else{
                break;
            }
        }
        Node s=new Node(x);
        p.next=s;
        s.next=q;
    }
    /**
     * 方法2
     * @param x
     */
    public void insert2(int x){
        Node p=head;
        while(p.next!=null&&(Integer)p.next.data<x){
            p=p.next;
        }
        Node s=new Node(x);
        s.next=p.next;
        p.next=s;
    }
    /**
     * 将一个带头节点的
     * 链表的元素反转
     * @param L
     */
    public static void rervse(LinkList L){
        Node q=L.head.next;
        Node p;
        L.head.next=null;
        while(q!=null){
            p=q.next;
            q=L.head.next;
            L.head.next=q;
            q=p;
        }
    }
}
