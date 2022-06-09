package com.experiment.algo.listop;

import com.experiment.algo.ten10.domain.ListNode;

/**
 * @author wuruohong
 * @date 2022-06-08 11:05
 */
public class ReverseN {
    ListNode successor = null; // 后驱节点
    public ListNode reverseFirstN(ListNode head, int n) {
        if (n == 1) {
            // 需要记录这个记录点，用于后续接入
            successor = head.next;
            return head;
        }
        ListNode last = reverseFirstN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
