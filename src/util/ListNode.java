package util;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] nums){
        if (nums.length==0) return;
        this.val=nums[0];
        ListNode node=this;
        for (int i = 1; i < nums.length; i++) {
            node.next=new ListNode(nums[i]);
            node=node.next;
        }
    }
    public  void show(){
        System.out.println(toString());
    }
    @Override
    public String toString() {
        ListNode node=this;
        StringBuffer sb=new StringBuffer();
        while (node != null) {
            sb.append(node.val);
            sb.append("->");
            node=node.next;
        }
        sb.delete(sb.length()-2,sb.length());
        return sb.toString();
    }
}