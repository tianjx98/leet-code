package 剑指offer;

public class 链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return null;
        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }
        node = head;
        n -= k;
        if (n < 0) return null;
        while (n-- > 0) {
            node = node.next;
        }
        return node;
    }

    public ListNode find(ListNode head, int k){
        if (head == null||k<=0) return null;
        ListNode n1=head,n2=head;
        k--;
        for (int i = 0; i < k; i++) {
            n2=n2.next;
            if (n2==null) return null;
        }
        while (n2.next != null) {
            n1=n1.next;
            n2=n2.next;
        }
        return n1;
    }

    public static void main(String[] args) {
        ListNode listNode = ListUtil.makeList(new int[]{1, 2, 3});
        ListNode listNode1 = new 链表中倒数第k个结点().find(listNode, 4);
        System.out.println(listNode1);
    }
}