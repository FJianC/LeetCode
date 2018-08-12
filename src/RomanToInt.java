/**
 * @author FJianC
 */
/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。
 * 但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *      I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 *      X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 *      C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *      给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * 示例 1:
 *      输入: "III"
 *      输出: 3
 * 示例 2:
 *      输入: "IV"
 *      输出: 4
 * 示例 3:
 *      输入: "IX"
 *      输出: 9
 * 示例 4:
 *      输入: "LVIII"
 *      输出: 58
 * 解释: C = 100, L = 50, XXX = 30, III = 3.
 * 示例 5:
 *      输入: "MCMXCIV"
 *      输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * */
public class RomanToInt {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new RomanToInt().romanToInt10(s));
    }

    public int romanToInt1(String s) {
        char []chr = s.toCharArray();
        int res=0;
        for(int i=0;i<chr.length;i++) {
            switch (chr[i]) {
                case 'C':
                    if(i+1<chr.length) {
                        if(chr[i+1]=='D'||chr[i+1]=='M') {
                            res-=100;
                            break;
                        }

                    }
                    res+=100;
                    break;
                case 'X':
                    if(i+1<chr.length) {
                        if(chr[i+1]=='L'||chr[i+1]=='C') {
                            res-=10;
                            break;
                        }

                    }
                    res+=10;
                    break;
                case 'I':
                    if(i+1<chr.length) {
                        if(chr[i+1]=='V'||chr[i+1]=='X') {
                            res-=1;
                            break;
                        }
                    }
                    res+=1;
                    break;
                case 'M':
                    res+=1000;
                    break;
                case 'D':
                    res+=500;
                    break;
                case 'L':
                    res+=50;
                    break;
                case 'V':
                    res+=5;
                    break;
                default:
                    break;
            }
        }

        return res;
    }

    public int romanToInt2(String s) {
        int tagVal[] = new int[256];
        tagVal['I'] = 1;
        tagVal['V'] = 5;
        tagVal['X'] = 10;
        tagVal['C'] = 100;
        tagVal['M'] = 1000;
        tagVal['L'] = 50;
        tagVal['D'] = 500;
        int val = 0;
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++){
            if(i+1 >= chs.length || tagVal[chs[i+1]] <= tagVal[chs[i]]) {
                val += tagVal[chs[i]];
            } else {
                val -= tagVal[chs[i]];
            }
        }
        return val;
    }

    public int romanToInt3(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'I' : count += 1;    break;
                case 'V' : count += 5;    break;
                case 'X' : count += 10;   break;
                case 'L' : count += 50;   break;
                case 'C' : count += 100;  break;
                case 'D' : count += 500;  break;
                case 'M' : count += 1000; break;
                default: break;
            }
        }

        if (s.contains("IV") || s.contains("IX")) {
            count -= 2;
        }
        if (s.contains("XL") || s.contains("XC")) {
            count -= 20;
        }
        if (s.contains("CD") || s.contains("CM")) {
            count -= 200;
        }

        return count;
    }

    public int romanToInt10(String s) {
        char[] nums = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] num = {1, 5, 10, 50, 100, 500, 1000};
        int[] re = new int[s.length()];
        int flag = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < nums.length; j++) {
                if (s.charAt(i) == nums[j]) {
                    re[i] = num[j];
                }
            }
        }
        max = re[re.length - 1];
        for (int i = re.length - 1; i > 0; i--) {
            if (re[i] > re[i - 1]) {
                max -= re[i - 1];
            } else {
                max += re[i - 1];
            }
        }
        return max;
    }

}
