/**
 * @author FJianC
 */
public class LongestPalindrome {
    public static void main(String[] arges) {
        String s = "csooo";
        System.out.println(longestPalindrome1(s));
    }

    private static String longestPalindrome1(String s){
        if(s.length()<=1){
            return s;
        }
        int[] range=new int[]{0,1};
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++){
            i=helper(c,i,range);
        }
        return s.substring(range[0],range[1]);
    }
    private static int helper(char[] c,int index,int[] range){
        int low=index,hi=index;
        while(hi<c.length-1&&c[hi]==c[hi+1]) {
            hi++;
        }
        int reset=hi;
        while(low-1>=0&&hi+1<c.length&&c[hi+1]==c[low-1]){
            hi++;
            low--;
        }
        if(hi-low+1>range[1]-range[0]){
            range[0]=low;
            range[1]=hi+1;
        }
        return reset;
    }

    public String longestPalindrome2(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        //step1 扩展
        int newLen = 2* len + 3;
        char[] newCharArray = new char[newLen];
        //'$'符号与后面的'@'符号都是为了省去33行暴力搜索时的边界判断
        newCharArray[0] = '$';
        //newCharArray[1] = '#';
        for(int i = 0; i < len; i++){
            newCharArray[2 * i + 1] = '#';
            newCharArray[2 * i + 2] = charArray[i];
        }
        newCharArray[newLen - 2] = '#';
        newCharArray[newLen - 1] = '@';
        //step2 寻找最大回文子串
        int[] index = new int[newLen];
        //当前最大回文子串对应下标
        int id = 1;
        //最大所涉右下标
        int right = 1;
        //循环遍历
        for(int j = 1; j < newLen - 1; j++){
            //if(j < s && j > id)
            if(j < right && j > id){
                //先得到初始大小
                index[j] = Math.min(index[2 * id - j], right - j);
            }

            //右边暴力搜索
            while(newCharArray[j + index[j]] == newCharArray[j - index[j]]) {
                index[j]++;
            }
            //更新id和right
            if(j + index[j] > right) {
                id = j;
                right = j + index[j];
            }
        }
        int maxId = 1;
        int maxLen = 1;
        //step3 从下标中寻找最大回文子串的左右边界
        for(int k = 1; k < newLen; k++) {
            if(index[k] > maxLen){
                maxId = k;
                maxLen = index[k];
            }
        }

        return s.substring((maxId - maxLen + 1) / 2, (maxId - 1 + maxLen - 1) / 2);
    }

    public String longestPalindrome4(String s) {
        int len=s.length();
        char [] charArray=new char[len*2+1];
        for(int i=0;i<len;i++){
            charArray[2*i]='#';
            charArray[2*i+1]=s.charAt(i);
        }

        charArray[2*len]='#';

        int []p=new int [len*2+1];

        int mid=0;
        int right=0;
        for(int i=0;i<len*2+1;i++){
            p[i]=right>i?Math.min(p[2*mid-i],right-i):1;

            while((i+p[i])<(2*len+1)&&((i-p[i]>=0))&&(charArray[i+p[i]]==charArray[i-p[i]])){
                p[i]++;
            }

            if((i+p[i])>right){
                right=i+p[i];
                mid=i;
            }
        }

        StringBuilder sb=new StringBuilder();
        int maxP=0;
        int maxPIndex=0;
        for (int i=0;i<len*2+1;i++){
            if(p[i]>maxP){
                maxP=p[i];
                maxPIndex=i;
            }
        }

        for(int i=maxPIndex-maxP+1;i<maxPIndex+maxP-1;i++){
            if(charArray[i]!='#'){
                sb.append(charArray[i]);
            }
        }
        return sb.toString();


    }

    int beginIndex, length;
    private String longestPalindrome6(String s) {
        for (int i = 0; i < s.length(); i++) {
            getLongestPalindrome(s, i, i);
            getLongestPalindrome(s, i, i + 1);
        }
        return s.substring(beginIndex, beginIndex + length);
    }
    private void getLongestPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > length) {
            beginIndex = i + 1;
            length = j - i - 1;
        }
    }

    public String longestPalindrome7(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expand(s, i, i), expand(s, i, i+1));
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private int expand(String s, int lo, int hi) {
        int L = lo;
        int R = hi;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L -1;
    }



    private static String longestPalindrome9(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        int len = s.length();
        boolean[][] flags = new boolean[1000][1000];
        int start = 0;
        int maxlen = 0;
        for (int i = 0; i < len; i++) {
            flags[i][i] = true;
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                flags[i][i + 1] = true;
                start = i;
                maxlen = 2;
            }
        }
        for (int m = 3; m <= len; m++) {
            for (int i = 0; i <= len - m; i++) {
                int j = i + m - 1;
                if (flags[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    flags[i][j] = true;
                    start = i;
                    maxlen = m;
                }
            }
        }
        if (maxlen >= 2) {
            return s.substring(start, start + maxlen);
        }
        return s.charAt(0) + "";
    }
}
