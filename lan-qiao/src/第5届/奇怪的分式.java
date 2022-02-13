package 第5届;

import java.util.ArrayList;

public class 奇怪的分式 {
    public static void main(String[] args) {
        boolean[] flag = new boolean[10];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        dfs(flag, arr, 1);
        System.out.println(count);
        System.out.println(c2);
    }

    private static void dfs(boolean[] flag, ArrayList<Integer> arr, int index) {
        if (arr.size() == 4) {
            check(arr);
            return;
        }
        for (int i = 1; i < 10; i++) {
            arr.add(i);
            dfs(flag, arr, index + 1);
            arr.remove(arr.size() - 1);
        }
    }

    private static int count = 0, c2 = 0;

    private static void check(ArrayList<Integer> arr) {
        int a = arr.get(0);
        int b = arr.get(1);
        int c = arr.get(2);
        int d = arr.get(3);
        c2++;
        if (a == b || c == d) return;
        if (a * c * (b * 10 + d) == (a * 10 + c) * b * d) {
            count++;
        }
    }
}
