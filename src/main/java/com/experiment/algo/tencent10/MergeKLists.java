package com.experiment.algo.tencent10;

import com.experiment.algo.tencent10.domain.ListNode;
import org.junit.Test;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wuruohong
 * @date 2022-05-28 14:09
 */
public class MergeKLists {

    public ListNode mergeLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode head = new ListNode();
        ListNode tail = head;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.value - b.value));

        // 先将K个链表头合并最小堆
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }

        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            // 每次都移动成为新的尾巴
            tail = tail.next;
        }

        return head.next;

    }
    @Test
    public void Test45() {
        List<ListNode> list = ListNode.getList();
        PriorityQueue<ListNode> queue = new PriorityQueue<>(list.size(), (a, b) -> (a.value - b.value));
        for (ListNode node : list) {
            System.out.println("node.value = " + node.value);
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            System.out.println("poll.value = " + poll.value);
        }

    }

    @Test
    public void Test62() {
        int k = 8;
        int x = (k-1) >>> 1;
        System.out.println("x = " + x);

    }
}
