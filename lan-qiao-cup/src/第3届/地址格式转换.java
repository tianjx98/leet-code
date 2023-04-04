package 第3届;

import java.util.Scanner;

public class 地址格式转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String result = convert(scanner.nextLine());
            System.out.println(result);
        }
    }

    public static String convert(String original) {
        int index = original.indexOf('C');
        String row = original.substring(1, index);
        int col = Integer.parseInt(original.substring(index + 1));
        StringBuilder sb = new StringBuilder();
        //将列转化为常规格式列
        while (col != 0) {
            if (col % 26 == 0) {
                sb.append('Z');
                col--;
            } else {
                sb.append((char) (col % 26 + 64));
            }
            col /= 26;
        }
        return sb.reverse().append(row).toString();
    }
}
