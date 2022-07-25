package cn.vince.practice.LeeCode.swordToOffer;

import cn.vince.practice.LeeCode.interviewGold.T11_RemoveDuplicateNodeLCCI;

/**
 * @ClassName 删除链表的节点
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/17 12:17
 */
public class T18_DeleteTheNodeOfTheLinked {

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     *
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode curNode = head;
        if (head.val == val) {
            return head.next;
        }
        while (curNode != null && curNode.next.val != val) {
            curNode = curNode.next;
        }
        if (curNode.next != null) {
            curNode.next = curNode.next.next;
        }
        return head;
    }

}
