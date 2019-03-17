package 周赛;

import java.util.Arrays;
import java.util.LinkedList;

public class T128 {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int flag = 1, k = 0;
        int[] ints = new int[64];
        while (N != 0) {
            ints[k++] = (N & flag) == 1 ? 0 : 1;
            N >>= 1;
        }
        int sum = 0, x = 1;
        for (int i = 0; i < k; i++) {
            sum += ints[i] * x;
            x *= 2;
        }
        return sum;
    }

    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < time.length - 1; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) count++;
            }
        }
        return count;
    }

    public int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length == 0) return 0;
        int max = weights[0], total = weights[0];
        for (int i = 1; i < weights.length; i++) {
            if (weights[i] > max) max = weights[i];
            total += weights[i];
        }
        int avg = total / D;
        int start = Math.max(max, avg);
        int sum, k;
        for (int i = start; ; i++) {
            k = 0;
            for (int j = 0; j < D; j++) {
                sum = 0;
                while (k < weights.length) {
                    if (sum + weights[k] <= i) sum += weights[k++];
                    else break;
                    if (j < D && k == weights.length) return i;
                }
            }
        }
    }
    public int numDupDigitsAtMostN(int N) {
        int count=0;
        
        return count;
    }
    public static void main(String[] args) {
        //1
        //int i = new T128().bitwiseComplement(0);
        //System.out.println(i);

        //2
        //int i = new T128().numPairsDivisibleBy60(new int[]{60, 60, 60});
        //System.out.println(i);

        //3
        //int i = new T128().shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4);
        //System.out.println(i);
    }
}
