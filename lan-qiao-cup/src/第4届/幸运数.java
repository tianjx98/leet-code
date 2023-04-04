package 第4届;

import java.util.ArrayList;
import java.util.Scanner;

public class 幸运数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int calc = calc(m, n);
        System.out.println(calc);
    }

    private static int calc(int m, int n) {
        int count = 0;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i * 2 + 1 < n; i++) {
            nums.add(i * 2 + 1);
        }
        for (int i = 1; i < nums.size(); i++) {
            int c = nums.get(i);
            if (c > m && c < n) count++;
            for (int j = (nums.size()/c)*c; j > 0; j -= c) {
                nums.remove(j-1);
            }
        }
        return count;
    }
}
