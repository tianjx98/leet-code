package 剑指offer;

public class 替换空格 {
    //14ms
    public String replaceSpace(StringBuffer str) {
        int length = str.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') count++;
        }
        int newlength = length + count * 2;
        str.setLength(newlength);
        for (int i = length - 1, j = newlength - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == ' ') {
                str.setCharAt(j--, '0');
                str.setCharAt(j--, '2');
                str.setCharAt(j--, '%');
            } else {
                str.setCharAt(j--, c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("h 2");
        String s = new 替换空格().replaceSpace(buffer);
        System.out.println("当前类:剑指offer.替换空格.main() 第26行:s值=" + s);

    }
}