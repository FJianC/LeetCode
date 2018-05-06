/**
 * @author FJianC
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"","b"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix10(strs));
    }

    public String longestCommonPrefix1(String[] strs){
        if(null == strs || strs.length < 1){
            return "";
        } else if(strs.length == 1){
            return strs[0];
        }

        /*数组此时最少一个元素*/
        int i=1;
        /*取第一个元素作为比较体*/
        String pre = strs[0];
        /*当数组个数大于1的时候才需要比较*/
        while(i < strs.length)
        {
            /* 返回pre字符串在strs[i]的位置，不存在则返回-1 */
            while (strs[i].indexOf(pre)!=0) {
                /*除去pre最后一个字符 如果一直不是，就是截取到""空串，空串一定是开头，跳出*/
                pre = pre.substring(0, pre.length() - 1);
            }
            i++; /*下一个对象比较*/
        }
        return pre;
    }

    public String longestCommonPrefix10(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = "";
        int len = strs[0].length();
        for (String str : strs) {
            if (str.length() < len) {
                len = str.length();
            }
        }
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            char s = strs[0].charAt(count);
            for (String str : strs) {
                if (s != str.charAt(count)) {
                    flag = true;
                }
            }
            if (flag) {
                break;
            }
            count++;
        }
        if (count > 0) {
            result = strs[0].substring(0, count);
        }
        return result;
    }

}
