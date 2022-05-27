package com.experiment.algo.tencent10;

import com.experiment.algo.tencent10.domain.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuruohong
 * @date 2022-05-27 20:29
 * 给定一个单链表的头结点head， 重新排列
 * L0->L1->........->Ln-1->Ln   ========>    L0->Ln->L1->Ln-1->L2->Ln-2.......
 */
public class ReorderList {

    public void reorder(ListNode head){
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        /** 将原来的head里面的数据都填充到list中就可以根据下标来寻址*/
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        /**  最后收个口*/
        list.get(i).next = null;
        return;
    }

    @Test
    public void Test40() {
        ListNode head = ListNode.getNodeList();
        ListNode.printList(head);
        System.out.println("===============分隔符===============");
        reorder(head);
        ListNode.printList(head);

    }
}
