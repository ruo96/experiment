package com.experiment.algo.ten10;

import com.experiment.algo.ten10.domain.ListNode;
import org.junit.Test;

/**
 * @author wuruohong
 * @date 2022-05-28 22:39
 */
public class RemoveNthFromEnd {
    public ListNode removeNth(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            System.out.println("i = " + i);
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
    @Test
    public void Test27() {
        ListNode head = ListNode.getNodeList();
        ListNode.printList(head);
System.out.println("===============分隔符===============");
        head = removeNth(head, 2);
        ListNode.printList(head);



    }


}
