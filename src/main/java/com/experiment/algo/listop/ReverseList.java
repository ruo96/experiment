package com.experiment.algo.listop;

import com.experiment.algo.ten10.domain.ListNode;

/**
 * @author wuruohong
 * @date 2022-06-08 10:52
 */
public class ReverseList {

    public ListNode reverseAllList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseAllList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
