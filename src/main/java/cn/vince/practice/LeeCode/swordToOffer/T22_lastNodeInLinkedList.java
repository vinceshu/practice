package cn.vince.practice.LeeCode.swordToOffer;

/**
 * @ClassName 链表中倒数第k个节点
 * @Description TODO
 * @Author vince.shu
 * @Date 2022/7/16 12:08
 */
public class T22_lastNodeInLinkedList {
    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     *
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     */


    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        //fast先走到k位置节点
        for (int i = 0; i <= k - 1; i++) {
            fast = fast.next;
        }
        //快慢指针一起走，直到fast走到尾节点，得到 slow ~ fast的节点，返回slow即可
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
