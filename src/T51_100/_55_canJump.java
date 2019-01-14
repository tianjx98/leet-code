package T51_100;

class _55_canJump {
    public boolean canJump(int[] nums) {
        if (nums == null) return false;
        if (nums.length == 1) return true; //只有一个元素直接返回true
        if (nums[0] == 0) return false; //有多个元素,第一个为0直接返回false
        int jump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > jump || jump >= nums.length - 1) break;
            jump = Math.max(jump, i + nums[i]);
        }
        return jump >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] arr={1,0,1,1,4};
        boolean jump = new _55_canJump().canJump(arr);
        System.out.println(jump);
    }
}