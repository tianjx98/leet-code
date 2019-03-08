import java.util.Scanner;

public class 翻硬币 {
    private static int calc(String s1, String s2) {
        int x = -1, count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (x < 0) x = i;
                else {
                    count += i - x;
                    x = -1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        System.out.println(calc(line1, line2));
    }
}