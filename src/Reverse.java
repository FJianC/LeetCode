/**
 * @author FJianC
 */
/**
 * 7. 反转整数
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * 示例 1:
 *      输入: 123
 *      输出: 321
 *  示例 2:
 *      输入: -123
 *      输出: -321
 * 示例 3:
 *      输入: 120
 *      输出: 21
 * 注意:
 *      假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 * */
public class Reverse {
    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse1(x));
        System.out.println(reverse2(x));
        System.out.println(reverse3(x));
        System.out.println(reverse4(x));
    }

    private static int reverse1(int x) {
        boolean negative = x < 0;
        if (negative) {
            x = -x;
        }
        long r = 0;
        while (x>0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        if (negative) {
            r = -r;
        }
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)r;
    }

    private static int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int temp = res * 10 + x % 10;
            //不断取前几位
            x = x / 10;
            if (temp / 10 != res) {
                res = 0;
                break;
            }
            res = temp;
        }
        return res;
    }

    private static int reverse3(int x) {
        char[] digits = String.valueOf(x).toCharArray();
        int num = 0;
        int max = Integer.MAX_VALUE / 10;
        for (int i = digits.length - 1; i > 0; i--) {
            if (num <= max) {
                num *= 10;
                num += digits[i] - '0';
            } else {
                return 0;
            }
        }
        if (digits[0] == '-') {
            num = -num;
        } else {
            if (num <= max) {
                num *= 10;
                num += digits[0] - '0';
            } else {
                return 0;
            }
        }
        return num;
    }

    private static int reverse4(int x) {
        int flag = x < 0 ? -1 : 1;
        String s = Integer.toString(x);
        String p = "";
        int n = flag == -1 ? 1 : 0;
        for (int i = s.length() - 1; i >= n; i--) {
            p += s.charAt(i);
        }
        String maxStr = Integer.toString(Integer.MAX_VALUE);
        if (p.length() == maxStr.length() && maxStr.compareTo(p) < 0) {
            return 0;
        } else {
            return Integer.valueOf(p) * flag;
        }
    }
}
