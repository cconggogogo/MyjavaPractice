package cn.practice.Leetcode.Array;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

/**
 * 分析：String才可以转换为字符数组
 * 判断空格是' '，而不是''
 */
public class Test2 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("hello world java ni shi shui ya ");
        System.out.println(replaceSpace(sb));
    }

    public static String replaceSpace(StringBuffer str) {
        String string = str.toString();
        char[] chs = string.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int x=0;x<chs.length;x++){
            if (chs[x]==' '){
                sb.append("%20");
            } else {
                sb.append(chs[x]);
            }
        }
        return sb.toString();
    }
}
