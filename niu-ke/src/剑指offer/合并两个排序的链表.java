package 剑指offer;

public class 合并两个排序的链表 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode l1 = list1, l2 = list2;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListUtil.makeList(new int[]{1, 3, 5});
        ListNode l2 = ListUtil.makeList(new int[]{});
        ListNode merge = new 合并两个排序的链表().Merge(l1, l2);
        System.out.println(merge);
    }
}