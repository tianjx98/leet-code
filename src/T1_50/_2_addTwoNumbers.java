package T1_50;

public class _2_addTwoNumbers {
    /**
     * https://leetcode-cn.com/problems/add-two-numbers/
     *
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num = 0; // 存储两数相加后的结果
        int add = 0; // 存储进位
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode result = null;
        result = new ListNode(0);// 头
        ListNode tmp = result;
        num = t1.val + t2.val;
        while (true) {
            int val = num + add;
            add = val / 10;// 给下一位的进位
            tmp.next = new ListNode(val % 10);
            tmp = tmp.next;

            if (t1.next != null) {
                t1 = t1.next;
                num = t1.val;
            } else {
                num = 0;
            }
            if (t2.next != null) {
                t2 = t2.next;
                num += t2.val;
            }
            if (num == 0 && add == 0 && t1.next == null && t2.next == null) {
                break;
            }
        }
        return result.next;
    }

    public ListNode offical_addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    private static void print(ListNode node) {
        do {
            System.out.print(node.val);
            node = node.next;
        } while (node != null);
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(3);
        print(l1);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(1);
        print(l2);

        ListNode result = new _2_addTwoNumbers().addTwoNumbers(l1, l2);
        print(result);
    }
}