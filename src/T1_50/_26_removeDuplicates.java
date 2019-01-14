package T1_50;

import java.util.Arrays;

public class _26_removeDuplicates {

    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int index=1;
        int tmp=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != tmp) {
                tmp=nums[i];
                nums[index++]=tmp;
            }
        }
        return index;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int index=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[index]){
                nums[++index]=nums[i];
            }
        }
        return index+1;
    }

    public static void main(String[] args) {
        int[] arr={0,0,1,1,1,2,2,3,3,4};
        int duplicates = new _26_removeDuplicates().removeDuplicates2(arr);
        for (int i = 0; i < duplicates; i++) {
            System.out.print(arr[i]+",");
        }
    }
}