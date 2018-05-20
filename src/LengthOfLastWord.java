/**
 * @author FJianC
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = " a";
        System.out.println(new LengthOfLastWord().lengthOfLastWord11(s));
    }

    public int lengthOfLastWord11(String s) {
        int count = 0;
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                break;
            }
        }
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }
}
