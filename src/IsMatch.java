import java.util.Arrays;

/**
 * @author FJianC
 */
/**
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *      输入:
 *          s = "aa"
 *          p = "a"
 *      输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *      输入:
 *          s = "aa"
 *          p = "a*"
 *      输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 *      输入:
 *          s = "ab"
 *          p = ".*"
 *      输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 示例 4:
 *      输入:
 *          s = "aab"
 *          p = "c*a*b"
 *      输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *      输入:
 *          s = "mississippi"
 *          p = "mis*is*p*."
 *      输出: false
 * */
public class IsMatch {

    public boolean isMatch(String s, String p) {
        // 标记数数组
        boolean[] match = new boolean[s.length() + 1];
        // 初始化
        Arrays.fill(match, false);
        // 假定最后的结果是匹配的
        match[s.length()] = true;

        // 对模式串从后向前进行处理
        for (int i = p.length() - 1; i >= 0; i--) {

            // 如果当前是*
            if (p.charAt(i) == '*') {

                // 匹配串从最后一个开始处理
                for (int j = s.length() - 1; j >= 0; j--)  {
                    match[j] = match[j] || match[j + 1] && (p.charAt(i - 1) == '.' || s.charAt(j) == p.charAt(i - 1));
                }
                i--;
            }
            // 如果不是*
            else {
                for (int j = 0; j < s.length(); j++) {
                    match[j] = match[j + 1] && (p.charAt(i) == '.' || p.charAt(i) == s.charAt(j));
                }

                match[s.length()] = false;
            }
        }
        return match[0];
    }


    public boolean isMatch10(String s, String p) {
        String[] str = p.split("\\*");

        if (p.charAt(p.length() - 1) != '*') {
            int count = str[str.length - 1].length() - 1;
            for (int i = s.length() - 1; i >= s.length() - str[str.length - 1].length(); i--) {
                if (s.charAt(i) == '.') {
                    count--;
                    continue;
                }
                if (s.charAt(i) != str[str.length - 1].charAt(count)) {
                    return false;
                }
            }
        }


        return false;
    }
}
