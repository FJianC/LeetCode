/**
 * @author FJianC
 */
/**
 * 28. 实现strStr()
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * 示例 1:
 *      输入: haystack = "hello", needle = "ll"
 *      输出: 2
 * 示例 2:
 *      输入: haystack = "aaaaa", needle = "bba"
 *      输出: -1
 * 说明:
 *      当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *      对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * */
public class StrStr {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(new StrStr().strStr10(haystack, needle));
    }


    /**
     * 暴力求解
     *
     * */
    public int strStr10(String haystack, String needle) {
        // needle 为空时 返回0
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        /**
         * 暴力遍历 查找 needle 第一个字符在 haystack 出现的位置 i
         * 再遍历 needle 的字符是否在 haystack 第 i 位置起的字符想匹配
         * */
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j;
                for (j = 0; j < needle.length(); j++) {
                    // 当 needle 的字符长度超出 haystack 第 i 位到最后一位的长度
                    if (i + j >= haystack.length()) {
                        break;
                    }
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
