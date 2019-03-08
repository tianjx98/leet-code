import java.util.Scanner;

public class 连号区间数 {
    private static int find(int[] arr) {
        int count = 0;
        //从第i个元素开始
        for (int i = 0; i <= arr.length; i++) {
            int min = arr.length + 1, max = -1;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > max) max = arr[j];
                if (arr[j] < min) min = arr[j];
                if (max - min == j - i) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(find(arr));
    }
}
