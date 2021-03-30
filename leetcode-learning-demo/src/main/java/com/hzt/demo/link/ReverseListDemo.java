package com.hzt.demo.link;

/**
 * @author hzt
 * @version 1.0.0
 * @ClassName Solution.java
 * @createTime 2021年03月30日 10:40:00
 */
public class ReverseListDemo {
    public ListNode ReverseList(ListNode head) {
        if(head==null)
        {
            return null;
        }
        ListNode two=head.next;
        head.next=null;
        ListNode there=null;
        while (two !=null){
            there=two.next;
            two.next=head;
            head=two;
            two=there;
        }
       return head;
    }
}
