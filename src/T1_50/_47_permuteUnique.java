package T1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class _47_permuteUnique {
    static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums == null || nums.length == 0) return result;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer> tmp = new ArrayList<>();
        dfs(nums, result, map, tmp);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, HashMap<Integer, Integer> map, ArrayList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            result.add((List<Integer>) tmp.clone());
            return;
        }
        for (Integer key : map.keySet()) {
            Integer val = map.get(key);
            if (val == 0) continue;
            map.put(key, val - 1);
            tmp.add(key);
            dfs(nums, result, map, tmp);
            tmp.remove(tmp.size() - 1);
            map.put(key, val);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[52];
        int k=0;
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                arr[k++]=i;
            }
        }
        //System.out.println(Arrays.toString(arr));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(2000);
                        System.out.println(result.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        List<List<Integer>> lists = new _47_permuteUnique().permuteUnique(arr);
        System.out.println(lists.size());
        //System.out.println(lists);
    }
}