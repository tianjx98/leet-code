package T101_150;

import util.ArrayUtil;

import java.util.List;
// TODO 未完成
class _120_minimumTotal {
    private int minTotal = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int first = triangle.get(0).get(0);
        if (triangle.size() > 1) {
            backTrack(triangle, 1, 0, first);
            backTrack(triangle, 1, 1, first);
        } else {
            return first;
        }
        return minTotal;
    }

    private void backTrack(List<List<Integer>> triangle, int depth, int index, int sum) {
        sum += triangle.get(depth).get(index);
        if (depth + 1 == triangle.size()) {
            if (sum < minTotal) minTotal = sum;
            return;
        }
        backTrack(triangle, depth + 1, index, sum);
        if (index + 1 < triangle.get(depth + 1).size()) backTrack(triangle, depth + 1, index + 1, sum);
    }

    public static void main(String[] args) {
        int[][] arr = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3},
        };
        List<List<Integer>> triangle = ArrayUtil.arrayToList(arr);
        int minimumTotal = new _120_minimumTotal().minimumTotal(triangle);
        System.out.println("当前类:_120_minimumTotal.main() 第40行:minimumTotal值=" + minimumTotal);

    }
}