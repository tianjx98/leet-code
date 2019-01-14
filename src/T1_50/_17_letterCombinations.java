package T1_50;

import util.Timer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class _17_letterCombinations {
    /**
     * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
     *
     * 先将每个数字对应的字幕存储在hashMap中
     * 创建一个结果集里面最初只有一个空串
     * 遍历digits字符串,获取每一个数字对应的字母
     *      将结果集中的每一个字符串都分别加上当前数字对应的每一个字母,并存入到一个临时结果集中
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if("".equals(digits)) return new LinkedList<String>();
        List<String> result=new LinkedList<>();
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            char[] chars = map.get(digits.charAt(i));
            List<String> tmp=new LinkedList<>();
            for (String sb:result){
                for (char c:chars){
                    tmp.add(sb+c);
                }
            }
            result=tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        Timer.start();
        List<String> strings = new _17_letterCombinations().letterCombinations("2345648687");
        Timer.end();
        System.out.println(strings.toString());
    }
}