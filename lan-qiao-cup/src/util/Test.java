package util;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int M = 9;
        int N = 4;

        int[] arr = new int[5];
        ArrayList<Integer> integers = new ArrayList<Integer>();
        dfs(integers, 1);
        //dfs(M, N, arr, 0, 1);
        System.out.println(c);
    }

    private static void dfs(ArrayList<Integer> arr, int index) {
        if (arr.size() == 4) {
            //check(arr);
            c++;
            return;
        }
        for (int i = 1; i < 10; i++) {
            arr.add(i);
            dfs(arr, index + 1);
            arr.remove(arr.size() - 1);
        }
    }

    private static int count = 0;
    private static int result = 0;
    private static int c = 0;

    /**
     * m个数中选n个进行组合(1~m个数种选n个)
     *
     * @param m
     * @param n
     * @param arr   存放结果的数组
     * @param index 生成下一个结果存放的下标
     * @param start 下一个数的开始
     */
    private static void dfs(int m, int n, int[] arr, int index, int start) {
        if (index == n) {
            check(arr);
            return;
        }
        int x = n - index - 1;
        for (int i = start; i <= m - x; i++) {
            arr[index] = i;
            dfs(m, n, arr, index + 1, i + 1);
        }
    }

    private static void check(int[] arr) {
        c++;
        int[] flag = new int[13];
        for (int i = 0; i < arr.length; i++) {
            flag[arr[i]] = 1;
        }
        count = 0;
        check_dfs(flag, arr[0]);
        if (count == 5) result++;
    }

    private static void check_dfs(int[] flag, int index) {
        if (index < 1 || index > 12) return;
        if (flag[index] == 1) {
            flag[index] = 0;
            count++;
            check_dfs(flag, index + 4);
            check_dfs(flag, index - 4);
            if (index != 4 && index != 8 && index != 12) check_dfs(flag, index + 1);
            if (index != 1 && index != 5 && index != 9) check_dfs(flag, index - 1);
        }
    }
}
