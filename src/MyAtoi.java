/**
 * @author FJianC
 */
/**
 * 8. 字符串转整数 (atoi)
 * 实现 atoi，将字符串转为整数。
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。
 * 如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。
 * 如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * 若函数不能执行有效的转换，返回 0。
 * 说明：
 *      假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
 *      如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * 示例 1:
 *      输入: "42"
 *      输出: 42
 * 示例 2:
 *      输入: "   -42"
 *      输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *      输入: "4193 with words"
 *      输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *      输入: "words and 987"
 *      输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *      输入: "-91283472332"
 *      输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * */
public class MyAtoi {
    public static void main(String[] args) {
        String str = "  a1-000000000000001";
        System.out.println(new MyAtoi().myAtoi10(str));

    }

    public static int myAtoi1(String str) {
        int result = 0;
        int current = 0;
        if (str==null||str.length()<=0){
            return 0;
        }
        int i = 0;
        int flag = 1;
        while (i<str.length()&&str.charAt(i)==' '){
            i++;
        }
        if (i<str.length()&&str.charAt(i)=='-'){
            flag = -1;
            i++;
        }else if (i<str.length()&&str.charAt(i)=='+'){
            i++;
        }
        if (i>=str.length()||!(str.charAt(i)>='0'&&str.charAt(i)<='9')){
            return 0;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            current = str.charAt(i) - '0';
            if (result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&current>=8)) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + current;
            i++;
        }
        return result*flag;
    }

    public int myAtoi2(String str) {
        if(null == str || 0 == str.length()) {
            return 0;
        }
        char[] strArray = str.toCharArray();
        int len = strArray.length;
        boolean isPos = true;
        int i = 0;
        //cut forward space
        while(i < len && ' ' == strArray[i]) {
            i++;
        }
        //deal sign + -
        if(i == len) {
            return 0;
        }
        if('-' == strArray[i]) {
            isPos = false;
            i++;
        } else if('+' == strArray[i]) {
            isPos = true;
            i++;
        }
        //check if valid
        if(i == len || strArray[i] < '0' || strArray[i] > '9') {
            return 0;
        }
        //start count
        int num = 0;
        boolean isOverflow = false;
        for(; i < len; i++) {
            char tmp = strArray[i];
            if(tmp >= '0' && tmp <= '9') {
                int checkNum = num;
                num = 10 * num + (tmp - '0');
                //consider overflow
                if(num / 10 != checkNum) {
                    isOverflow = true;
                    break;
                }
            } else {
                break;
            }
        }
        if(isOverflow) {
            return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return isPos ? num : -num;
    }

    public int myAtoi3(String str) {
        str = str.trim();
        if (str == null || str.length() < 1) {
            return 0;
        }
        int i = 0;          // index of str
        char flag = '+';    // default positive
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        }else if (str.charAt(0) == '+') {
            i++;
        }

        double res = 0;
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res = res * 10 + str.charAt(i) - '0';
            i++;
        }
        if (flag == '-') {
            res = -1 * res;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }

    public int myAtoi10(String str) {
        long re = 0;
        int flag = 1;
        String temp = "";
        char c;
        int i;
        for (i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c <= '9' && c >= '0') {
                break;
            } else if (c == '+') {
                i++;
                break;
            } else if (c == '-') {
                flag = -1;
                i++;
                break;
            } else {
                return 0;
            }
        }
        for (;i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                continue;
            } else {
                break;
            }
        }
        for (; i < str.length(); i++) {
            if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                temp += str.charAt(i) + "";
            } else {
                break;
            }
        }
        if (!"".equals(temp)) {
            if (temp.length() <= 11) {
                re = Long.parseLong(temp) * flag;
                if (re > Integer.MAX_VALUE) {
                    re = Integer.MAX_VALUE;
                }
                if (re < Integer.MIN_VALUE) {
                    re = Integer.MIN_VALUE;
                }
            } else {
                if (flag == 1) {
                    re = Integer.MAX_VALUE;
                }
                if (flag == -1) {
                    re = Integer.MIN_VALUE;
                }
            }
        }
        return (int) re;
    }
}
