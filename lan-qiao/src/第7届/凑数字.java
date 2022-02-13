package 第7届;

public class 凑数字 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        dfs(arr, 0);
        System.out.println(count);
    }

    private static void dfs(int[] arr, int start) {
        if (start == 9) {
            check(arr);
        }
        for (int i = start; i < arr.length; i++) {
            int t = arr[i];
            arr[i] = arr[start];
            arr[start] = t;
            dfs(arr, start + 1);
            t = arr[i];
            arr[i] = arr[start];
            arr[start] = t;
        }
    }

    private static int count = 0;

    private static void check(int[] arr) {
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int d = arr[3];
        int e = arr[4];
        int f = arr[5];
        int g = arr[6];
        int h = arr[7];
        int i = arr[8];

        int def = f + e * 10 + d * 100;
        int ghi = i + h * 10 + g * 100;
        long left = a * c * ghi + b * ghi + def * c;
        long right = 10 * c * ghi;
        if (left==right) count++;
    }
}