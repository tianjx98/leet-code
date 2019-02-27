import java.util.Scanner;

public class 小计算器 {
    /**运算指令*/
    private static String INSTRUCTION;
    /**
     * 当前进制
     */
    private static int K = 10;
    /**
     * 当前数值
     */
    private static long VAL = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String cmd = scanner.nextLine();
            if ("CLEAR".equals(cmd)) {
                VAL=-1;
            } else if (cmd.startsWith("CHANGE")) {
                CHANGE(cmd);
            } else if (cmd.startsWith("NUM")) {
                if (VAL<0){// val小于零代表初始状态
                    VAL=NUM(cmd);
                } else {
                    calc(NUM(cmd));
                }
            } else if ("EQUAL".equals(cmd)) {
                EQUAL();
            } else {
                INSTRUCTION=cmd;
            }
        }
    }

    private static void calc(long num){
        if ("ADD".equals(INSTRUCTION)){
            VAL+=num;
        } else if ("SUB".equals(INSTRUCTION)){
            VAL-=num;
        } else if ("MUL".equals(INSTRUCTION)){
            VAL*=num;
        } else if ("DIV".equals(INSTRUCTION)){
            VAL/=num;
        } else if ("MOD".equals(INSTRUCTION)){
            VAL%=num;
        }
    }

    private static long NUM(String cmd) {
        String num=cmd.split(" ")[1];
        return Long.parseLong(num,K);
    }

    /**
     * 改变当前进制为K进制(2≤K≤36)
     */
    private static void CHANGE(String cmd) {
        K=Integer.parseInt(cmd.split(" ")[1]);
    }

    /**
     * 以当前进制输出结果
     */
    private static void EQUAL() {
        System.out.println(Long.toString(VAL,K).toUpperCase());
    }
}
