package 剑指offer;

public class 变态跳台阶 {
    public int JumpFloorII(int target) {
        if (target==1) return 1;
        else return 2 * JumpFloorII(target - 1);
        //return 1<<(target-1);
    }
}