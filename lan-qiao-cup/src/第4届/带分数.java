package 第4届;

import java.util.Scanner;

public class 带分数 {
    private static int count = 0;

    private static int generateNum(int[] arr, int start, int end) {
        int num = 0;
        for (int i = start; i < end; i++) {
            num = num * 10 + arr[i + 1];
        }
        return num;
    }

    private static void check(int[] arr, int n) {
        for (int i = 1; i < 10; i++) {
            int n1 = generateNum(arr, 0, i);
            if (n1 >= n) return;
            for (int j = i + (10 - i) / 2; j < 9; j++) {
                int n2 = generateNum(arr, i, j);
                int n3 = generateNum(arr, j, 9);
                if (n2 > n3 && n2 % n3 == 0 && n == n1 + n2 / n3) {
                    //System.out.printf("%d + %d / %d = %d (%d)", n1, n2, n3, n1 + n2 / n3, n2 % n3);
                    //System.out.println();
                    count++;
                }
            }
        }
    }

    private static void dfs(int[] arr, boolean[] flag, int start, int n) {
        if (start == 10) {
            check(arr, n);
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[10];
        boolean[] flag = new boolean[10];
        dfs(arr, flag, 1, n);
        System.out.println(count);
    }
}
