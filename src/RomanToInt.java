/**
 * @author FJianC
 */
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
