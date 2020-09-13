
/**
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 * 
 *
 */
public class 反转链表 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 递归思路，把顺序写出来便于理解，顺序依次是：
     * 
     * 反转一个: 1-2-3-4
     * 
     * tmp: 2-3-4 head: 1-null
     *
     * tmp: 3-4-5 head: 2-1-null
     *
     * tmp: 4-5 head: 3-2-1-null
     * 
     * tmp: 5 head: 4-3-2-1-null
     * 
     * tmp: null head: 5-4-3-2-1-null
     * 
     */
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        // 临时变量，存下一次用于递归剩下的节点
        ListNode tmp = head.next;
        head.next = newHead;
        return reverseList(tmp, head);
    }

    /**
     * 迭代思路，顺序依次是： 反转一个：1-2-3-4
     * <p>
     * tmp: 2-3-4 head: 1-null newHead: 1-null head: 2-3-4
     * <p>
     * tmp: 3-4 head: 2-1-null newHead: 2-1-null head: 3-4
     * <p>
     * tmp: 4 head: 3-2-1-null newHead: 3-2-1-null head: 4
     * <p>
     * tmp: null head: 4-3-2-1-null newHead: 4-3-2-1-null head:null
     * <p>
     */
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            // 临时变量，存下一次用于迭代剩下的节点
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

}
