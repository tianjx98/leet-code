package util;

import java.util.Arrays;

public class Test {
    public static int cutRod(int[] p, int n) {
        if (n == 0) return 0;
        int max = -1;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, p[i] + cutRod(p, n - i));
        }
        return max;
    }

    public static int buttonUpCutRod(int[] p, int n) {
        int[] arr = new int[n + 1];
        int[] res = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            int max = -1;
            for (int j = 1; j <= i; j++) {
                if (max < p[j] + arr[i - j] - ((i - j) > 0 ? 2 : 0)) {
                    max = p[j] + arr[i - j] - ((i - j) > 0 ? 2 : 0);
                    res[i] = j;
                }
            }
            arr[i] = max;
        }
        int x = n;
        while (x > 1) {
            System.out.print(res[x]);
            x -= res[x];
        }
        System.out.println();
        return arr[n];
    }

    public static void main(String[] args) {
        int[] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int n = 6;
        int i = buttonUpCutRod(p, n);
        System.out.println(i);
    }
}
