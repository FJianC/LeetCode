import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author FJianC
 */
/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例：
 *      给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 *      给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 *      给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 * */
public class LengthofLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabccbaaaaqwer";
        int ret;
        ret = lengthOfLongestSubstring1(s);
        System.out.println(ret);
        ret = lengthOfLongestSubstring2(s);
        System.out.println(ret);
        ret = lengthOfLongestSubstring3(s);
        System.out.println(ret);
        ret = lengthOfLongestSubstring4(s);
        System.out.println(ret);
        ret = lengthOfLongestSubstring5(s);
        System.out.println(ret);
        ret = lengthOfLongestSubstring6(s);
        System.out.println(ret);
    }

    private static int lengthOfLongestSubstring1(String s) {
        int[] list = new int[256];
        int previous = -1, right = 0, max_len = 0;
        for(int i=0;i<list.length;i++){
            list[i]=-1;
        }
        while(right<s.length()){
            char c = s.charAt(right);
            if (list[(int)c] > previous) {
                previous = list[(int) c];
            }
            max_len = Math.max(max_len, right - previous);
            list[(int)c] = right++;
        }
        return max_len;
    }

    private static int lengthOfLongestSubstring2(String s) {
        int sl = s.length();
        if(sl <= 1) {
            return sl;
        }
        else {
            int ml = 1,d = 0,i,l = 1,j,b;
            for(i = 1;i<sl;i++) {
                b = 0;
                for(j = d;j<i;j++) {
                    if(s.charAt(i) == s.charAt(j)) {
                        d = j+1;
                        l = i-j;
                        b = 1;
                    }
                }
                if (b == 0) {
                    l++;
                }
                if (ml < l) {
                    ml = l;
                }
            }
            return ml;
        }
    }

    private static int lengthOfLongestSubstring3(String s) {
        int result = 0;
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int index = sb.indexOf(String.valueOf(charArray[i]));
            if(index != -1) {
                int length = sb.length();
                result = result < length ? length : result;
                sb.delete(0,index + 1);
            }
            sb.append(charArray[i]);
        }
        result = result < sb.length() ? sb.length() : result;
        return result;
    }

    private static int lengthOfLongestSubstring4(String s) {
        int[] arr = new int[128];
        char[] letter = s.toCharArray();
        int res =0;
        int start=1;
        for(int i=0;i<letter.length;i++){
            if(arr[letter[i]]!=0&&arr[letter[i]]>=start){
                start = arr[letter[i]]+1;
                arr[letter[i]]=i+1;
                res = Math.max(i-start+2,res);
            }
            else{
                arr[letter[i]]=i+1;
                res = Math.max(i-start+2,res);
            }
        }
        return res;
    }

    private static int lengthOfLongestSubstring5(String s) {
        // 判断字符串是否为空
        if (s == null || s.length() == 0) {
            return 0;
        }

        int ans = 0, p = 0;
        // 建立一个键值对容器
        Map<Character, Integer> map = new HashMap<>(s.length());
        // 滑动窗口法
        for (int q = 0; q < s.length(); q++) {
            p = Math.max(p, map.keySet().contains(s.charAt(q)) ? map.get(s.charAt(q)) + 1: 0);
            ans = Math.max(ans, q - p + 1);
            map.put(s.charAt(q), q);
        }

        // 返回结果
        return ans;
    }

    private static int lengthOfLongestSubstring6(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
