package cn.vince.practice.LeeCode.swordToOffer;


import cn.vince.practice.LeeCode.hot100.T2_AddTwoNumbers;
import cn.vince.practice.LeeCode.interviewGold.T11_RemoveDuplicateNodeLCCI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName 从尾到头打印链表
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/16 12:18
 */
public class T06_PrintTheLinked {



    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     */

    List<Integer> temp = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recursive(head);
        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

    public void recursive(ListNode head) {
        if (head == null) return;
        recursive(head.next);
        temp.add(head.val);
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
