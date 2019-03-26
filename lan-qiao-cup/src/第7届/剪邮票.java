package 第7届;

import java.util.Arrays;

public class 剪邮票 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        dfs(arr, 0, 1);
        System.out.println(result);
    }

    /**
     * 12个数中选5个数,又多少种选法
     * @param arr
     * @param index
     * @param start
     */
    private static void dfs(int[] arr, int index, int start) {
        if (index == 5) {
            check(arr);
            return;
        }
        int n = 5 - index - 1;
        for (int i = start; i <= 12 - n; i++) {
            arr[index] = i;
            dfs(arr, index + 1, i + 1);
        }
    }

    private static int count = 0;
    private static int result = 0;

    private static void check(int[] arr) {
        int[] g = new int[13];
        for (int i = 0; i < arr.length; i++) {
            g[arr[i]] = 1;
        }
        count = 0;
        check_dfs(g, arr[0]);
        if (count == 5) {
            result++;
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void check_dfs(int[] g, int index) {
        if (index < 1 || index > 12) return;
        if (g[index] == 1) {
            count++;
            g[index] = 0;
            if (index != 4 && index != 8 && index != 12)
                check_dfs(g, index + 1);
            if (index != 1 && index != 5 && index != 9)
                check_dfs(g, index - 1);
            check_dfs(g, index + 4);
            check_dfs(g, index - 4);
        }
    }
}
