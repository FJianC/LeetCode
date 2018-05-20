/**
 * @author FJianC
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {};
        int[] temp = new PlusOne().plusOne10(digits);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }

    public int[] plusOne10(int[] digits) {
        int len = digits.length - 1;
        while (len >= 0) {
            if (digits[len] == 9) {
                if (len == 0) {
                    int[] temp = new int[digits.length + 1];
                    temp[0] = 1;
                    temp[1] = 0;
                    for (int i = 2, j = 1; j < digits.length; i++, j++) {
                        temp[i] = digits[j];
                    }
                    return temp;
                }
                digits[len--] = 0;
            } else {
                digits[len] += 1;
                break;
            }
        }
        return digits;
    }
}
