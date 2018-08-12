/**
 * @author FJianC
 */
/**
 * 66. 加一
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 *      输入: [1,2,3]
 *      输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *      输入: [4,3,2,1]
 *      输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * */
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
