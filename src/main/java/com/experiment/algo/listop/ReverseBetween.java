package com.experiment.algo.listop;

import com.experiment.algo.ten10.domain.ListNode;
import org.junit.Test;

/**
 * @author wuruohong
 * @date 2022-06-08 11:20
 */
public class ReverseBetween {

    @Test
    public void Test12() {
        ListNode head = ListNode.getNodeList();
        head = reverseBetweenValue(head, 2,5);
        ListNode.printList(head);

    }
    public ListNode reverseBetweenValue(ListNode head, int m, int n) {
        if (m == 1) {
            // 相当于反转前N个元素
            return new ReverseN().reverseFirstN(head, n);
        }
        head.next = reverseBetweenValue(head.next, m - 1, n - 1);
        return head;
    }
}
