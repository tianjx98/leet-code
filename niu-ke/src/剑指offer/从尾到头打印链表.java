package 剑指offer;

import java.util.ArrayList;

/**
 * 1.翻转链表
 * 2.递归
 */
public class 从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode==null) return new ArrayList<Integer>();
        int count = 0;
        ListNode node = listNode;
        while (node != null) {
            count++;
            node = node.next;
        }
        node = listNode;
        ArrayList<Integer> result = new ArrayList<>(count);
        int[] res = new int[count];
        while (--count >= 0) {
            res[count]=node.val;
            node = node.next;
        }
        for (int i = 0; i < res.length; i++) {
            result.add(res[i]);
        }
        return result;
    }

    public static ArrayList<Integer> reverse(ListNode listNode){
        if (listNode==null) return new ArrayList<Integer>();
        ListNode pre=listNode,next=listNode.next,n;
        pre.next=null;
        while (next!=null) {
            n=next.next;
            next.next=pre;
            pre=next;
            next=n;
        }
        listNode=pre;
        ArrayList<Integer> result = new ArrayList<>();
        n=listNode;
        while (n != null) {
            result.add(n.val);
            n=n.next;
        }
        return result;
    }

    private static ArrayList<Integer> integers=new ArrayList<>();
    public static ArrayList<Integer> recursion(ListNode listNode){
        if (listNode==null) return integers;
        recursion(listNode.next);
        integers.add(listNode.val);
        return integers;
    }

    public static void main(String[] args) {
        ListNode listNode = ListUtil.makeList(new int[]{58, 24, 0, 67});
        ArrayList<Integer> integers = new 从尾到头打印链表().recursion(listNode);
        System.out.println("当前类:从尾到头打印链表.main() 第26行:integers值=" + integers);

    }
}
