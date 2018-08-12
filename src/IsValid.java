import java.util.Stack;

/**
 * @author FJianC
 */
/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 *      输入: "()"
 *      输出: true
 * 示例 2:
 *      输入: "()[]{}"
 *      输出: true
 * 示例 3:
 *      输入: "(]"
 *      输出: false
 * 示例 4:
 *      输入: "([)]"
 *      输出: false
 * 示例 5:
 *      输入: "{[]}"
 *      输出: true
 * */
public class IsValid {

    public static void main(String[] args) {
        String strs = "}";
        System.out.println(new IsValid().isValid10(strs));
    }

    public boolean isValid1(String s) {
        char[] stack = new char[s.length()];
        int head = 0;
        for(char c : s.toCharArray()) {
            switch(c) {
                case '{':
                case '[':
                case '(':
                    stack[head++] = c;
                    break;
                case '}':
                    if(head == 0 || stack[--head] != '{') {return false;}
                    break;
                case ')':
                    if(head == 0 || stack[--head] != '(') {return false;}
                    break;
                case ']':
                    if(head == 0 || stack[--head] != '[') {return false;}
                    break;
                default: break;
            }
        }
        return head == 0;
    }

    public boolean isValid2(String s) {
        int len = s.length();
        if(len % 2 != 0) {return false;}
        //遇到左括号就放入数组，右括号就删除元素，数组长度不能减半，会出现全部左括号的情况
        char[] arr = new char[len];
        int cIndex = 0;
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                //左括号压入数组
                arr[cIndex] = c;
                cIndex++;
            }else{
                cIndex -= 1;
                if(cIndex < 0) {
                    return false;
                }
                boolean flag = check(arr[cIndex],c);
                if(!flag) {
                    return false;
                }
            }
        }
        return cIndex == 0;
    }
    /**
    * 判断两个字符符号是否一对
    */
    private boolean check(char a,char b){
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }


    public boolean isValid10(String s) {
        String left = "([{";
        String right = ")]}";
        Stack<Character> temp = new Stack<Character>();
        for (int i = 0, flag; i < s.length(); i++) {
            flag = left.indexOf(s.charAt(i));
            if (flag != -1) {
                temp.push(s.charAt(i));
            } else {
                if (!temp.empty() && left.indexOf(temp.peek()) == right.indexOf(s.charAt(i))) {
                    temp.pop();
                } else {
                    return false;
                }
            }
        }
        if (!temp.empty()) {
            return false;
        }
        return true;
    }
}
