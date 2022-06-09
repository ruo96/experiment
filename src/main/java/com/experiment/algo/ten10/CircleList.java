package com.experiment.algo.ten10;

import com.experiment.algo.ten10.domain.ListNode;
import org.junit.Test;

/**
 * @author wuruohong
 * @date 2022-05-27 22:31
 * 这个就是用来判断有没有环，和起始位置
 */
public class CircleList {
    
    @Test
    public void Test11() {
        ListNode head = ListNode.getNodeList();
        System.out.println("isCircleList(head) = " + isCircleList(head));
        head = ListNode.getCircleNodeList();
        System.out.println("isCircleList(head) = " + isCircleList(head));

    }

    @Test
    public void Test23() {
        ListNode head = ListNode.getCircleNodeList();
        System.out.println("getCircleBegin(head) = " + getCircleBegin(head));


    }

    private boolean isCircleList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private int getCircleBegin(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        slow = head;

        int count = 0;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
            count ++;
        }
        System.out.println("slow = " + slow.value);
        return count;

    }
}
