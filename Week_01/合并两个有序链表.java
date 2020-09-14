
/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 
 * 输出：1->1->2->3->4->4
 */
public class 合并两个有序链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归思路：内部维护了一个栈。每次都把最小值压入栈，最后出栈的时候，将所有数连在一起。
     * 执行顺序：l1:1-2-5 l2:0-3-4
     * l2.next = merge((1-2-5),(3-4))
     * -> l1.next = merge((2-5),(3-4))
     * -> l1.next = merge((5),(3-4))
     * -> l2.next = merge((5),(4))
     * -> l2.next = merge((5), null)
     * <p>
     * 出栈
     * return l1(5) -> return l2(4-5) -> return l2(3-4-5) -> return l1(2-3-4-5) -> return l1(1-2-3-4-5) -> return l2(0-1-2-3-4-5-)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}