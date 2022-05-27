package com.experiment.algo.tencent10;

import com.experiment.algo.tencent10.domain.ListNode;
import org.junit.Test;

/**
 * @author wuruohong
 * @date 2022-05-27 22:54
 * 这道题就是最简单的反转链表
 */
public class ReverseList {

    @Test
    public void Test10() {
        ListNode head = ListNode.getNodeList();
        ListNode.printList(head);
        System.out.println("===============分隔符===============");
        head = reverseList(head);
        ListNode.printList(head);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = head;
        ListNode curr = head;
        while (curr != null) {
            /** next只是用来暂时保存*/
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }









    private ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        while (curr != null) {
            /** 先保住要断掉的*/
            next = curr.next;
            /** 然后调转方向*/
            curr.next = prev;
            /** 重新定向*/
            prev = curr;
            /** 重新移动*/
            curr = next;

        }
        return prev;


    }


}
