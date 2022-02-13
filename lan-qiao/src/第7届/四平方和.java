package 第7届;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class 四平方和 {
    public static int[] result = new int[4];
    public static ArrayList<String> res = new ArrayList<String>();

    public static void main(String[] args) {
        int n = 773535;
        calc(n, 3);
        Collections.sort(res);
        System.out.println(res.get(0));
        //System.out.println(Arrays.toString(result));
    }

    public static boolean calc(int n, int layer) {
        if (layer < 0) return false;
        int sqrt = (int) Math.sqrt(n);
        if (layer < 3 && sqrt > result[layer + 1]) return false;
        for (int i = sqrt; i >= 0; i--) {
            result[layer] = i;
            if (i * i == n) {
                res.add(join(layer));
                return true;
            }
            calc(n - i * i, layer - 1);
        }
        return true;
    }

    private static String join(int layer) {
        StringBuilder stringBuilder = new StringBuilder(7);
        stringBuilder.append(result[0]);
        stringBuilder.append(' ');
        stringBuilder.append(result[1]);
        stringBuilder.append(' ');
        stringBuilder.append(result[2]);
        stringBuilder.append(' ');
        stringBuilder.append(result[3]);
        for (int i = 0; i <= layer; i++) {
            result[i] = 0;
        }
        return stringBuilder.toString();
    }
}
