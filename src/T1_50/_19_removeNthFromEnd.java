package T1_50;

import util.ListNode;

class _19_removeNthFromEnd {
    /**
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
       int count=0;
       ListNode p=head;
        while (p != null) {
            count++;
            p=p.next;
        }
        p=new ListNode(0);
        p.next=head;
        count=count-n;
        if (count==0) return head.next;
        for (int i = 0; i < count; i++) {
            p=p.next;
        }
        p.next=p.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
//        head.next=new ListNode(2);
//        head.next.next=new ListNode(3);
//        head.next.next.next=new ListNode(4);
//        head.next.next.next.next=new ListNode(5);

        ListNode listNode = new _19_removeNthFromEnd().removeNthFromEnd(head, 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}