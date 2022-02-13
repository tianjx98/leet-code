import java.util.Scanner;

public class 观光铁路 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int j = scanner.nextInt() * 2;
        int[] count = new int[n + 1];
        for (int i = 0; i < j; i++) {
            count[scanner.nextInt()]++;
        }
        for (int i = 1; i <= n; i++) {
            if (count[i]!=0){
                System.out.printf("%.12f",j*1.0/count[i]);
                System.out.println();
            }
        }
    }
}
