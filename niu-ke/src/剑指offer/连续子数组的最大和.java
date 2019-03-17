package 剑指offer;

public class 连续子数组的最大和 {
    /**
     * 如果数组元素都为负数,结果就为数组的最大值,所以需要记录数组的最大值
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int maxSum = 0, sum = 0, maxNum = array[0];//最大和,当前和,数组最大元素
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNum) maxNum = array[i];//当前元素大一最大元素时,更新最大元素为当前元素
            sum += array[i];
            if (sum < 0) sum = 0;//如果当前和小于0,就置零
            if (sum > maxSum) maxSum = sum;//如果当前和大于最大和,更新最大和
        }
        return maxNum < 0 ? maxNum : maxSum;
    }
}