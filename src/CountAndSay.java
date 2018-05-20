/**
 * @author FJianC
 */
public class CountAndSay {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new CountAndSay().countAndSay10(n));
    }

    public String countAndSay1(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = calc(result);
        }
        return result;
    }
    private String calc(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        char b = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != b) {
                if (b != 0) {
                    sb.append(count);
                    sb.append(b);
                }
                count = 1;
                b = chars[i];
            } else {
                count++;
            }
        }
        sb.append(count);
        sb.append(b);
        return sb.toString();
    }

    public String countAndSay3(int n) {
        if(n <= 0){
            return "";
        }
        if(n == 1){
            return "1";
        }
        else{
            String result = countAndSay3(n-1);
            StringBuilder stringBuilder = new StringBuilder("");
            int count = 0;
            char temp = result.charAt(0);
            for(int i = 0;i<result.length();i++){
                if(temp == result.charAt(i)){
                    count++;
                }
                if(temp != result.charAt(i)){
                    stringBuilder.append(count).append(temp);
                    temp = result.charAt(i);
                    count = 1;
                }
                if(i == result.length()-1){
                    stringBuilder.append(count).append(temp);
                }
            }
            return stringBuilder.toString();
        }
    }


    public String countAndSay10(int n) {
        if (n < 1) {
            return "";
        }
        String str = "1";
        String temp = "";
        int count;
        while (n > 1) {
            n--;
            for (int i = 0; i < str.length(); i++) {
                count = 0;
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(i) == str.charAt(j)) {
                        count++;
                    } else {
                        break;
                    }
                }
                i += count;
                count++;
                temp += count + "" + str.charAt(i) + "";
            }
            str = temp;
            temp = "";
        }
        return str;
    }
}
