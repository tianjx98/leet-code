package T401_450;

class _415_addStrings {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        StringBuilder result = new StringBuilder(Math.max(l1, l2) + 1);
        int flag = 0;
        l1--;
        l2--;
        int i = 0;
        for (; l1 >= 0 && l2 >= 0; l1--, l2--, i++) {
            int sum = num1.charAt(l1) - '0' + num2.charAt(l2) - '0' + flag;
            result.append(sum % 10);
            flag = sum / 10;
        }
        while (l1 >= 0) {
            int sum = num1.charAt(l1) - '0' + flag;
            result.append(sum % 10);
            flag = sum / 10;
            l1--;
        }
        while (l2 >= 0) {
            int sum = num2.charAt(l2) - '0' + flag;
            result.append(sum % 10);
            flag = sum / 10;
            l2--;
        }
        if (flag != 0) {
            result.append(flag);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s = new _415_addStrings().addStrings("0", "9133");
        System.out.println(s);
    }
}