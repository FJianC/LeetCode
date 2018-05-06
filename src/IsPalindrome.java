/**
 * @author FJianC
 */
public class IsPalindrome {

    public static void main(String[] args) {
        int x = 121;
        System.out.println(new IsPalindrome().isPalindrome10(x));
    }

    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        int result = 0;
        int temp = x;
        while (x > 0) {
            result = 10 * result + x % 10;
            x /= 10;
        }
        return result == temp;
    }

    public boolean isPalindrome2(int x) {
        String string = String.valueOf(x);
        StringBuilder newString = new StringBuilder(string);
        if (string.equals(newString.reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPalindrome10(int x) {
        if (x < 0) {
            return false;
        } else {
            String str = String.valueOf(x);
            int i = 0;
            int j = str.length() - 1;
            while (i < j) {
                if (str.charAt(i) != str.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
}
