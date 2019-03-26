package 第7届;

public class 方格填数 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        dfs(arr, 0);
        System.out.println(count);
    }

    private static void dfs(int[] arr, int start) {
        if (start == 10) {
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
        if (adjoin(arr[0], arr[1]) || adjoin(arr[0], arr[3]) || adjoin(arr[0], arr[4]) || adjoin(arr[0], arr[5])) return;
        if (adjoin(arr[1], arr[2]) || adjoin(arr[1], arr[4]) || adjoin(arr[1], arr[5]) || adjoin(arr[1], arr[6])) return;
        if (adjoin(arr[2], arr[5]) || adjoin(arr[2], arr[6])) return;
        if (adjoin(arr[3], arr[4]) || adjoin(arr[3], arr[7]) || adjoin(arr[3], arr[8])) return;
        if (adjoin(arr[4], arr[5]) || adjoin(arr[4], arr[7]) || adjoin(arr[4], arr[8]) || adjoin(arr[4], arr[9])) return;
        if (adjoin(arr[5], arr[6]) || adjoin(arr[5], arr[8]) || adjoin(arr[5], arr[9])) return;
        if (adjoin(arr[6], arr[9])) return;
        if (adjoin(arr[7], arr[8])) return;
        if (adjoin(arr[8], arr[9])) return;
        count++;
    }

    private static boolean adjoin(int a, int b) {
        return (a > b ? a - b : b - a) == 1;
    }
}
