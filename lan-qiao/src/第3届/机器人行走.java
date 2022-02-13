package 第3届;

import java.util.Scanner;

public class 机器人行走 {
    public static String Left = "ULDR";
    public static String Right = "URDL";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String cmd = scanner.nextLine();//当前命令
            walk(cmd);
            getResult(cmd);
        }
    }

    public static void getResult(String A) {
        double r = 0, x = 0, y = 0;
        char way = 'U';
        for(int i = 0;i < A.length();i++) {
            int start = i;
            if(A.charAt(start) >= '0' && A.charAt(start) <= '9') {
                while(start < A.length() && A.charAt(start) >= '0' && A.charAt(start) <= '9')
                    start++;
                int num = Integer.valueOf(A.substring(i, start));
                if(way == 'U')
                    y += num;
                else if(way == 'L')
                    x -= num;
                else if(way == 'D')
                    y -= num;
                else if(way == 'R')
                    x += num;
                i = start - 1;
            } else {
                char temp = A.charAt(i);
                if(temp == 'L') {
                    int p = Left.indexOf(way+"");
                    p = (p + 1) % 4;
                    way = Left.charAt(p);
                } else if(temp == 'R') {
                    int p = Right.indexOf(way+"");
                    p = (p + 1) % 4;
                    way = Right.charAt(p);
                }
            }
        }
        r = Math.sqrt(x*x + y*y);
        System.out.printf("%.2f", r);
        System.out.println();
    }

    private static void walk(String cmd) {
        int direction = 1;
        int x = 0, y = 0;
        for (int j = 0; j < cmd.length(); j++) {
            char c = cmd.charAt(j);
            if (Character.isDigit(c)) {//遇到数字
                int k = j + 1;
                while (k < cmd.length()) {
                    c = cmd.charAt(k);
                    if (Character.isLetter(c)) break;
                    k++;
                }
                String num = cmd.substring(j, k);
                int len = Integer.parseInt(num);
                if (direction == 1) y += len;
                else if (direction == 2) x += len;
                else if (direction == 3) y -= len;
                else x -= len;
                j = k;
            }
            //改变方向
            if (c == 'R') direction++;
            if (c == 'L') direction--;
            if (direction == 5) direction = 1;
            if (direction == 0) direction = 4;
        }
        System.out.printf("%.2f", Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
        System.out.println();
    }
}
