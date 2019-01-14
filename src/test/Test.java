package test;

import T1_50.ListNode;

import java.util.*;

public class Test {
    public boolean hasCycle(ListNode head) {
        ListNode p=head;
        if (p==null) return false;
        p=p.next;
        while (p != null) {
            if (head==p) return true;
            p=p.next;
        }
        return false;
    }

    public static void main(String[] args) {
    }
}