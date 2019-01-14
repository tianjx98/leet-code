package T1_50;

import java.util.HashSet;

class _3_lengthOfLongestSubstring {
    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     *
     * 先创建一个hashSet
     * (i=j=0)i指向区间的头,j指向区间的尾
     * 如果j指向的字符hashSet中没有,就将其加入,j++,如果当前区间比之前区间大,记录下来
     * 如果j指向的字符hashSet中有,i++
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0, j = 0; i < n && j < n; ) {
            if (!set.contains(s.charAt(j))) { // 不在
                set.add(s.charAt(j++));
                if (result < j - i) result = j - i;
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int aaa = new _3_lengthOfLongestSubstring().lengthOfLongestSubstring("bb");
        System.out.println(aaa);
    }
}