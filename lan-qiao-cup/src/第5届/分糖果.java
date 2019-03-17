package 第5届;

import java.util.Scanner;

public class 分糖果 {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        while (true) {
            //判断是否相同
            if (isSame(arr)) break;
            //分糖果
            int tmp = arr[arr.length - 1];
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i] / 2 + arr[i - 1] / 2;
            }
            arr[0] = arr[0] / 2 + tmp / 2;
            //补糖果
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] & 1) == 1) {
                    arr[i]++;
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isSame(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) return false;
        }
        return true;
    }
}
