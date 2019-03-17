package util;

import java.util.*;

public class Template {
    /**
     * 生成全排列,不可重复使用元素(排列元素中不含重复元素)
     * @param arr   用来存放排列的结果
     * @param flag  标记元素是否重复使用
     * @param start 下一个排列的元素下标
     * @param n
     */
    private static void dfs(int[] arr, boolean[] flag, int start, int n) {
        if (start == 10) {
            //check(arr, n);
        } else {
            for (int i = 1; i < 10; i++) {
                if (!flag[i]) {
                    arr[start] = i;
                    flag[i] = true;
                    dfs(arr, flag, start + 1, n);
                    flag[i] = false;
                }
            }
        }
    }
    /**
     * 生成排列,可重复使用元素
     * @param arr
     * @param index
     */
    private static void dfs(ArrayList<Integer> arr, int index) {
        if (arr.size() == 4) {
            //check(arr);
            return;
        }
        for (int i = 1; i < 10; i++) {
            arr.add(i);
            dfs(arr, index + 1);
            arr.remove(arr.size() - 1);
        }
    }

    /**
     * 生成全排列, 排列元素中可包含重复元素,但结果不会重复
     * @param strings
     * @param map
     * @param sb
     * @param length
     */
    private static void dfs2(ArrayList<String> strings, HashMap<Character, Integer> map, StringBuilder sb, int length) {
        if (sb.length() == length) {
            strings.add(sb.toString());
            return;
        }
        for (Character c : map.keySet()) {
            Integer val = map.get(c);
            if (val == 0) continue;
            map.put(c, val - 1);
            sb.append(c);
            dfs2(strings, map, sb, length);
            sb.deleteCharAt(sb.length() - 1);
            map.put(c, val);
        }
    }

    /**
     * 生成全排列, 排列元素种可包含重复元素
     * @param res   存放所有结果
     * @param nums  排列的元素
     * @param list  存储单次结果的集合
     * @param book  标记元素是否使用
     */
    private void dfs(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, boolean[] book)
    {
        if(list.size()==nums.length)
        {
            res.add(new ArrayList<Integer>(list));
        }
        Set<Integer> used=new HashSet<Integer>();
        for (int i=0;i<nums.length;i++)
        {
            if(book[i]||used.contains(nums[i])) continue;
            book[i]=true;
            used.add(nums[i]);
            list.add(nums[i]);
            dfs(res,nums,list,book);
            list.remove(list.size()-1);
            book[i]=false;
        }
    }

}
