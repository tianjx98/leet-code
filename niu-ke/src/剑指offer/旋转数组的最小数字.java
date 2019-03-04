package 剑指offer;

import java.util.ArrayList;
public class 旋转数组的最小数字 {
    public int minNumberInRotateArray(int [] array) {
        if (array==null||array.length==0) return 0;
        if (array.length==1) return array[0];
        int i=1;
        for (;i<array.length;i++){
            if (array[i-1]>array[i]) break;
        }
        return array[i];
    }
}