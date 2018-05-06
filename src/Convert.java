/**
 * @author FJianC
 */
public class Convert {
    public static void main(String[] args) {
        String s = "ABCD";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }

    private static String convert(String s, int numRows) {
        if (numRows < 2 || s.length() <= numRows) {
            return s;
        }
        String str = "";
        char[][] c = new char[numRows][2 * s.length() / numRows];
        int count = 0;
        boolean flag = true;
        if (numRows == 2) {
            for (int i = 0; i < s.length(); i += 2) {
                str += s.charAt(i);
            }
            for (int i = 1; i < s.length(); i += 2) {
                str += s.charAt(i);
            }
            return str;
        }
        for (int j = 0; j < c[0].length && count < s.length(); j++) {
            if (flag) {
                for (int i = 0; i < c.length && count < s.length(); i++) {
                    c[i][j] = s.charAt(count++);
                }
                flag = false;
            } else {
                for (int i = numRows - 2; i >= 1 && count < s.length(); i--) {
                    c[i][j] = s.charAt(count++);
                }
                flag = true;
            }
        }
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                if (c[i][j] != '\u0000') {
                    str += c[i][j];
                }
            }
        }
        return str;
    }

    private static String convert10(String s, int numRows) {
        if (numRows < 2 || s.length() <= numRows) {
            return s;
        }
        String str = "";
        char[] c = new char[s.length()];
        int count = 0;
        int i = 0;
        boolean flag = true;
        while (count < s.length()) {
            if (flag) {
                for (int a = 0; a < numRows; a++) {

                    if (a == 1) {
                        i = i + s.length() / numRows;
                    } else {
                        i = i + 2 * s.length() / numRows - 1;
                    }
                    c[i] = s.charAt(count++);
                }
                flag =  false;
            } else {
                count += numRows - 2;
                for (int a = 0; a < numRows - 2; a++) {

                    if (a == 1) {
                        i = i + s.length() / numRows;
                    } else {
                        i = i + 2 * s.length() / numRows - 1;
                    }
                    c[i] = s.charAt(count--);
                }
            }
        }
        return str;
    }
}
