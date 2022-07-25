package cn.vince.practice.LeeCode.interviewGold;

import java.util.HashSet;

/**
 * @author: vince.shu
 * @date: 2022/6/7 22:04
 * @description: 移除重复节点
 * @version: 1.0
 */
public class T11_RemoveDuplicateNodeLCCI {

    /**
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     *
     *  输入：[1, 2, 3, 3, 2, 1]
     *  输出：[1, 2, 3]
     * @param args
     */

    public static void main(String[] args) {

    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = head;
        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);
        while (head != null && head.next != null) {
            if (set.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                set.add(head.next.val);
                head = head.next;
            }
        }
        return res;
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(head.val);

        ListNode currentNode = new ListNode(head.val);

        do {
            if (currentNode.val > currentNode.next.val) {
                break;
            }
            if (currentNode.val == currentNode.next.val);
        } while (head.next != null);

        return result;
    }


}
