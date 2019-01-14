package T1_50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class _22_permute {
    /**
     * https://leetcode-cn.com/problems/permutations/
     *
     * 参考
     * https://www.cnblogs.com/nowornever-L/p/6008954.html
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isUsed=new boolean[nums.length];
        backTrack(result,new LinkedList<Integer>(),nums,isUsed,0);
        return result;
    }
    private void backTrack(List result,LinkedList<Integer> item,int[] nums,boolean[] isUsed,int index){
        if (item.size()==nums.length) {
            result.add(item.clone());
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (isUsed[i]) continue;
            isUsed[i]=true;
            item.add(nums[i]);
            backTrack(result,item,nums,isUsed,0);
            item.removeLast();
            isUsed[i]=false;
        }
    }

    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<List<Integer>> permute = new _22_permute().permute(arr);
        System.out.println(permute.size());
        permute.forEach((x)->{
            System.out.println(x.toString());
        });
    }
}