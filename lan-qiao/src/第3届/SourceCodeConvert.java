package 第3届;


import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 常用的有：
 * HTML 需要转义的实体：
 * &     --->  &amp;
 * 空格  --->  &nbsp;
 * <     --->  &lt;
 * >     --->  &gt;
 * "     --->  &quot;
 * 此外，根据源码的特点，可以把 TAB 转为4个空格来显示。\t
 * TAB   --->  &nbsp;&nbsp;&nbsp;&nbsp;
 * <p>
 * 为了显示为换行，需要在行尾加<br/>标签。 \r\n
 * <p>
 * 为了显示美观，对关键字加粗显示，即在关键字左右加<b>标签。比如：
 *
 * <b>public</b>
 * <p>
 * 对单行注释文本用绿色显示，可以使用<font>标签，形如：
 *
 * <font color=green>//这是我的单行注释！</font>
 * <p>
 * 注意：如果“//”出现在字符串中，则注意区分，不要错误地变为绿色。
 * <p>
 * 不考虑多行注释的问题
 * 你的任务是：编写程序，把给定的源文件转化为相应的html表达。
 */
public class SourceCodeConvert {
    public static HashSet<String> KEYWORDS;

    static {
        String[] keywords = {"public", "private", "protected", "import", "class", "static", "if", "while", "new", "for", "else"};
        KEYWORDS = new HashSet<String>();
        KEYWORDS.addAll(Arrays.asList(keywords));
    }

    public static void convert(String path, String destPath) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            System.err.println("文件不存在: " + path);
            return;
        }
        File destFile = new File(destPath);
        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(destFile));
        writer.write("<html>\r\n<body>\r\n");
        String line = null;
        while ((line = reader.readLine()) != null) {
            //&     --->  &amp;
            line = line.replaceAll("&", "&amp;");

            //<     --->  &lt;
            line = line.replaceAll("<", "&lt;");

            //>     --->  &gt;
            line = line.replaceAll(">", "&gt;");
            //"     --->  &quot;
            line = line.replaceAll("\"", "&quot;");

            //TAB   --->  &nbsp;&nbsp;&nbsp;&nbsp;
            line = line.replaceAll("\r", "&nbsp;&nbsp;&nbsp;&nbsp;");

            //空格  --->  &nbsp;
            line = line.replaceAll(" ", "&nbsp;");

            //单行注释文本用绿色显示<font color=green>//这是我的单行注释！</font>
            if (line.trim().startsWith("//")) {
                line = "<font color=green>" + line + "</font>";
            } else {
                //将关键字加粗<b>
                for (String keyword : KEYWORDS) {
                    line = line.replaceAll(keyword, "<b>$0</b>");
                }
            }
            writer.write(line + "</br>\r\n");
        }
        writer.write("<body/><br/>\r\n<html/>");
        reader.close();
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        convert("F:\\eclipse-workspace\\leetCode\\src\\test\\Solution.java", "D:/test.html");
    }
}
