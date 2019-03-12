package T101_150;

class _121_maxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[] arr = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            arr[i - 1] = prices[i] - prices[i - 1];
        }
        int sum = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) sum = 0;
            if (sum > max) max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int i = new _121_maxProfit().maxProfit(arr);
        System.out.println(i);
    }
}