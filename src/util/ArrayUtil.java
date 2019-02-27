package util;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {

    public static List<List<Integer>> arrayToList(int[][] arr){
        List<List<Integer>> lists = new ArrayList<>();
        for (int[] nums:arr){
            ArrayList<Integer> list = new ArrayList<>(nums.length);
            for (int num:nums){
                list.add(num);
            }
            lists.add(list);
        }
        return lists;
    }

}
