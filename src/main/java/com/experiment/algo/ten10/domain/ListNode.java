package com.experiment.algo.ten10.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuruohong
 * @date 2022-05-27 20:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {

    public Integer value;

    public ListNode next;


    public static void printList(ListNode node) {
        while (node != null) {
            System.out.println("value ====> " + node.value);
            node = node.next;
        }
    }

    public static ListNode getNodeList() {
        ListNode head = new ListNode();
        head.value = 0;

        ListNode b1 = new ListNode();
        b1.value = 1;

        ListNode b2 = new ListNode();
        b2.value = 2;

        ListNode b3 = new ListNode();
        b3.value = 3;

        ListNode b4 = new ListNode();
        b4.value = 4;

        head.next = b1;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = null;

        return head;

    }

    public static ListNode getCircleNodeList() {
        ListNode head = new ListNode();
        head.value = 0;

        ListNode b1 = new ListNode();
        b1.value = 1;

        ListNode b2 = new ListNode();
        b2.value = 2;

        ListNode b3 = new ListNode();
        b3.value = 3;

        ListNode b4 = new ListNode();
        b4.value = 4;

        ListNode b5 = new ListNode();
        b5.value = 5;

        ListNode b6 = new ListNode();
        b6.value = 6;

        head.next = b1;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;
        b6.next = b3;

        return head;

    }

    public static List<ListNode> getList() {
        ListNode head = new ListNode();
        head.value = 1;

        ListNode b1 = new ListNode();
        b1.value = 3;

        ListNode b2 = new ListNode();
        b2.value = 7;
        //
        ListNode b3 = new ListNode();
        b3.value = 9;
        //
        ListNode b4 = new ListNode();
        b4.value = 10;

        ListNode b5 = new ListNode();
        b5.value = 12;

        ListNode b6 = new ListNode();
        b6.value = 4;

        List<ListNode> list = new ArrayList<>();
        list.add(head);
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);
        list.add(b6);

        return list;

    }
}
