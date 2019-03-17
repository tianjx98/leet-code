package T101_150;

import util.ArrayUtil;

import java.util.List;
class _120_minimumTotal {
    private int minTotal = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle==null||triangle.size()==0) return 0;
        int[] arr = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                arr[j] = Math.min(arr[j], arr[j + 1]) + row.get(j);
            }
        }
        return arr[0];
    }
    public static void main(String[] args) {
        //int[][] arr = {
        //        {2},
        //        {3, 4},
        //        {6, 5, 7},
        //        {4, 1, 8, 3},
        //};
        int[][] arr={{-10}};
        List<List<Integer>> triangle = ArrayUtil.arrayToList(arr);
        int minimumTotal = new _120_minimumTotal().minimumTotal(triangle);
        System.out.println("当前类:_120_minimumTotal.main() 第40行:minimumTotal值=" + minimumTotal);

    }
}