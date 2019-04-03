package util;

import java.util.Arrays;

public class Timer {
    private static long time;

//    public static void start() {
//        time=System.currentTimeMillis();
//    }
//    public static void end() {
//        time=System.currentTimeMillis()-time;
//        System.out.println("执行用时: "+time+" 毫秒");
//    }

    public static void start() {
        time = System.nanoTime();
    }

    public static void end() {
        time = System.nanoTime() - time;
        System.out.println("执行用时: " + time / 1000 + " μs, " + time / 1000000 + " ms");
    }

    public static void test(TestBlock block) {
        start();
        block.run();
        end();
    }
}
