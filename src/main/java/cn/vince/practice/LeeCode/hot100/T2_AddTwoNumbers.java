package cn.vince.practice.LeeCode.hot100;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author: vince.shu
 * @description: 两数相加
 * @date: 2022/4/30 11:50
 * @version: 1.0
 */
@Slf4j
public class T2_AddTwoNumbers {

    /**
     * @author vinceshu
     * @description 定义链表
     * @date  10:28
     */
    @Data
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode node = addTwoNumbers(l1, l2);
        log.info("result:{}", node.toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }



    /**
     * @author vinceshu
     * @date 2022/5/1 10:39
     * @description 思路一：将链表转换为原整数，相加后转为链表
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int l1Num = getNumFromNode(l1);
        int l2Num = getNumFromNode(l2);
        Integer resultNum = l1Num + l2Num;
        StringBuilder reverse = new StringBuilder(resultNum).reverse();
        String[] split = reverse.toString().split(",");
        for (int i = 0; i < split.length; i++) {
            ListNode node = new ListNode();
            node.setVal(Integer.parseInt(split[i]));
                                                                                                                                                                                                                                                                                                                                                                                                      }

        return result;
    }

    public int getNumFromNode(ListNode listNode) {
        StringBuilder resultStr = new StringBuilder();
        for (ListNode node = listNode;node != null;node = listNode.next) {
            int val = node.val;
            resultStr.insert(0, val);
        }
        return Integer.parseInt(resultStr.toString());
    }

}
