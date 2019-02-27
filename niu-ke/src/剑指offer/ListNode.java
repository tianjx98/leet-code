package 剑指offer;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode node=this;
        while (node != null) {
            sb.append(node.val);
            sb.append("->");
            node=node.next;
        }
        return sb.toString();
    }
}

class ListUtil {
    public static ListNode makeList(int[] arr){
        if (arr==null||arr.length==0) return null;
        ListNode listNode = new ListNode(arr[0]);
        ListNode node = listNode;
        for (int i = 1; i < arr.length; i++) {
            node.next=new ListNode(arr[i]);
            node=node.next;
        }
        return listNode;
    }
}