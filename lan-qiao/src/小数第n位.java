import java.util.Scanner;

public class 小数第n位 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "";
        long a = scanner.nextInt();
        long b = scanner.nextInt();
        long c = scanner.nextInt();
        a %= b;
        for (int i = 1; i < c; i++) {
            long t=a;
            a=(a*10)%b;
            if (a==0||t==a) break;
        }
        a *= 10;
        result += a / b;
        a = a % b;
        a *= 10;
        result += a / b;
        a = a % b;
        a *= 10;
        result += a / b;
        a = a % b;
        System.out.println(result);
    }
}
