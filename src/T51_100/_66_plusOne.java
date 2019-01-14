package T51_100;

import java.util.Arrays;

class _66_plusOne {
    public int[] plusOne(int[] digits) {
        if (digits==null||digits.length==0) return new int[]{};
        int index=digits.length-1;
        int add=1;
        do {
            digits[index]+=add;
            if (digits[index] >= 10) {
                digits[index]%=10;
            }else {
                return digits;
            }
            index--;
        }while (index>=0);
        int[] result=new int[digits.length+1];
        result[0]=1;
        //多余
//        for (int i = 0; i < digits.length; i++) {
//            result[i+1]=digits[i];
//        }
        return result;
    }

    public int[] plusOne_0ms(int[] digits) {
        int len=digits.length;
        for (int i = len-1; i>=0; i--) {
            if (digits[i]<9) {
                digits[i]=digits[i]+1;
                return digits;
            }
            digits[i]=0;
        }
        int[] arr=new int[len+1];
        arr[0]=1;
        return arr;
    }
    public static void main(String[] args) {
        int[] arr={9};
        int[] ints = new _66_plusOne().plusOne(arr);
        System.out.println(Arrays.toString(ints));
    }
}