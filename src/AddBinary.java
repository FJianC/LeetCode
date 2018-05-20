/**
 * @author FJianC
 */
public class AddBinary {

    public static void main(String[] args) {
        String a = "110010";
        String b = "10111";
        System.out.println(new AddBinary().addBinary11(a, b));
    }

    public String addBinary1(String a, String b) {
        int m = a.length();
        int n = b.length();
        int size = Math.max(m, n);
        char[] result = new char[size];
        char[] longArray = m > n ? a.toCharArray() : b.toCharArray();
        char[] shortArray = m > n ? b.toCharArray() : a.toCharArray();
        // important
        int diff = longArray.length - shortArray.length;
        int carry = 0;
        for (int i = size - 1; i >= 0; i--) {
            int sum = carry + (longArray[i] - '0');
            if (i - diff >= 0) {
                sum += (shortArray[i - diff] - '0');
            }
            carry = sum / 2;
            result[i] = (char)(sum % 2 + '0');
        }
        if (carry != 0) {
            return "1" + new String(result);
        }
        return new String(result);
    }

    public String addBinary2(String a, String b) {
        int[] ca=new int[a.length()];
        int[] cb=new int[b.length()];
        for(int i=0;i<a.length();i++){
            ca[i]=a.charAt(i)-'0';
        }
        for(int i=0;i<b.length();i++){
            cb[i]=b.charAt(i)-'0';
        }
        // 用tmp 保存一下   让ca 始终最长
        if (ca.length < cb.length) {
            int[] tmp = ca;
            ca = cb;
            cb = tmp;
        }
        // 字符数组ca最后一个索引下标
        int ai = ca.length - 1;
        // 字符数组cb最后一个索引下标
        int bi = cb.length - 1;
        // 下位的进位标识
        int carry = 0;
        // 加载的结果
        int result;
        // 计算比如：1010101101 + 10100
        while (ai >= 0 && bi >= 0) {
            result = ca[ai] + cb[bi] + carry;
            ca[ai] = result % 2;
            carry = result / 2;
            ai--;
            bi--;
        }
        // 处理余下的数字
        while (ai >= 0) {
            result = ca[ai] + carry;
            ca[ai] = result % 2;
            carry = result / 2;
            if (carry == 0) {
                break;
            }
            ai--;
        }
        // 将字符数组中的值转换了字符的0或者1
        for (int i = 0; i < ca.length; i++) {
            ca[i] += '0';
        }
        // 不需要扩展一位
        if (carry == 0) {
            char[] ch = new char[ca.length];
            for (int i = 0; i < ca.length; i++) {
                ch[i] = (char) (ca[i]);
            }
            return new String(ch);
        }
        // 需要扩展一位
        else {
            char[] ch = new char[ca.length + 1];
            ch[0] = '1';
            for (int i = 0; i < ca.length; i++) {
                ch[i + 1] = (char) (ca[i]);
            }
            return new String(ch);
        }
    }

    public String addBinary3(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len1 = a.length() - 1, len2 = b.length() - 1;
        int sum = 0, carry = 0;
        while (len1 >= 0 || len2 >= 0) {
            int first = len1 >= 0 ? (a.charAt(len1--) - '0') : 0;
            int second = len2 >= 0 ? (b.charAt(len2--) - '0') : 0;
            sum = first + second + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public String addBinary11(String a, String b) {
        String result = "";
        boolean flag = false;
        String temp = "";
        String newre;
        int sub = a.length() - b.length();
        sub = sub < 0 ? sub * -1 : sub;
        for (int i = sub; i > 0; i--) {
            temp += " ";
        }
        if (a.length() > b.length()) {
            newre = a;
            b = temp + b;
        } else {
            newre = b;
            a = temp + a;
        }
        for (int i = a.length() - 1; i >= sub; i--) {
            if ((flag && a.charAt(i) - b.charAt(i) == 0) || (!flag && a.charAt(i) - b.charAt(i) != 0)) {
                temp = "1";
            } else {
                temp = "0";
            }
            if (flag && a.charAt(i) - b.charAt(i) == 0 && a.charAt(i) == '0') {
                flag = false;
            }
            if (!flag && a.charAt(i) - b.charAt(i) == 0 && a.charAt(i) == '1') {
                flag = true;
            }
            result = temp + result;
        }
        while (sub > 0) {
            sub--;
            if (newre.charAt(sub) == '1') {
                if (flag) {
                    temp = "0";
                } else {
                    temp = "1";
                }
            } else {
                if (flag) {
                    temp = "1";
                } else {
                    temp = "0";
                }
            }
            if (newre.charAt(sub) == '0' && flag) {
                flag = false;
            }
            result = temp + result;
        }
        if (flag) {
            return "1" + result;
        }
        return result;
    }
}
