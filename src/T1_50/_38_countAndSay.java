package T1_50;

class _38_countAndSay {
    private String[] arr = new String[30];
    {
        arr[0] = "1";
    }
    public String countAndSay(int n) {
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String str = arr[i - 1];
            int count = 1;
            char ch = str.charAt(0);
            for (int j = 1; j < str.length(); j++) {
                char charAt = str.charAt(j);
                if (charAt != ch) {
                    sb.append((char) (count + '0'));
                    sb.append(ch);
                    ch = charAt;
                    count = 1;
                } else {
                    count++;
                }
            }
            sb.append((char) (count + '0'));
            sb.append(ch);
            arr[i] = sb.toString();
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
        String s = new _38_countAndSay().countAndSay(5);
        System.out.println(s);
    }

}