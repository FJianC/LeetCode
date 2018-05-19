/**
 * @author FJianC
 */
public class CountAndSay {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new CountAndSay().countAndSay10(n));
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
