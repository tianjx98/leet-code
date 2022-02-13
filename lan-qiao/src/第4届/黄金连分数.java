package 第4届;

import java.math.BigDecimal;

public class 黄金连分数 {
    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal(1);
        for (int i = 0; i < 1000; i++) {
            bd = bd.add(BigDecimal.ONE);
            bd = BigDecimal.ONE.divide(bd, 101, BigDecimal.ROUND_HALF_DOWN);
        }
        System.out.println(bd.toString());
    }
}
