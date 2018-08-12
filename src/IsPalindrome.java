/**
 * @author FJianC
 */
/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 *      输入: 121
 *      输出: true
 * 示例 2:
 *      输入: -121
 *      输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *      输入: 10
 *      输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *      你能不将整数转为字符串来解决这个问题吗？
 * */
public class IsPalindrome {

    public static void main(String[] args) {
        int x = 121;
        System.out.println(new IsPalindrome().isPalindrome10(x));
    }

    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        int result = 0;
        int temp = x;
        while (x > 0) {
            result = 10 * result + x % 10;
            x /= 10;
        }
        return result == temp;
    }

    public boolean isPalindrome2(int x) {
        String string = String.valueOf(x);
        StringBuilder newString = new StringBuilder(string);
        if (string.equals(newString.reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPalindrome10(int x) {
        if (x < 0) {
            return false;
        } else {
            String str = String.valueOf(x);
            int i = 0;
            int j = str.length() - 1;
            while (i < j) {
                if (str.charAt(i) != str.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
}
