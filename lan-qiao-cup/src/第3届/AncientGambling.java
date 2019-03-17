package 第3届;

import java.util.Random;

public class AncientGambling {
    private static Random random=new Random();
    public static void main(String[] args) {
        double profit=0;//庄家盈利
        int count=500000;
        for (int i = 0; i < count; i++) {
            int select = random.nextInt(6)+1;
            int r1 = random.nextInt(6)+1;
            int r2 = random.nextInt(6)+1;
            int r3 = random.nextInt(6)+1;

            if (r1 == select && r2 == select && r3 == select) {
                profit-=6;
            } else if (r1 == select && r2 == select || r1 == select && r3 == select || r2 == select && r3 == select) {
                profit-=2;
            } else if (r1 == select || r2 == select || r3 == select) {
                profit-=1;
            } else if (select * r1 == r2 * r3 || select * r2 == r1 * r3 || select * r3 == r1 * r2) {
            } else {
                profit++;
            }
        }
        System.out.printf("%.3f", profit/count);
    }
}
