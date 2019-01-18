package test;

import T1_50.ListNode;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        double xnext,x=0.5,r=2.5;
        int count=300;
        double[] nums=new double[count];
        for (int i=0;i<count;i++){
            xnext=x*(1-x)*r;
            x=xnext;
            nums[i]=xnext;
        }
        Arrays.sort(nums);
        for (int i = 0; i < count; i++) {
            System.out.println(String.format("%.3f",nums[i]));
        }
    }
}