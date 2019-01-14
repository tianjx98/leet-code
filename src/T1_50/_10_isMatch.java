package T1_50;

class _10_isMatch {
    public boolean isMatch(String s, String p) {
        return s.matches(p);
        // TODO 自己实现匹配 .*
    }

    public static void main(String[] args) {
        boolean match = new _10_isMatch().isMatch("mississippi", "mis*is*p*.");
        System.out.println(match);
    }
}