package 剑指offer;

public class 反转链表 {
    public ListNode ReverseList(ListNode head) {
        if (head==null) return null;
        ListNode pre=head,next=head.next,tmp;
        pre.next=null;
        while (next != null) {
            tmp=next.next;
            next.next=pre;
            pre=next;
            next=tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new 反转链表().ReverseList(ListUtil.makeList(new int[]{1, 2, 3}));
        System.out.println(listNode);
    }
}