class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * @author FJianC
 */
public class AddTwoNumbers {

    private static void main(String[] args) {
        String line = "[9]";
        ListNode l1 = stringToListNode(line);
        line = "[1,9,9,9,9,9,9,9,9,9]";
        ListNode l2 = stringToListNode(line);

        ListNode ret1 = addTwoNumbers1(l1, l2);
        String out1 = listNodeToString(ret1);
        System.out.print(out1);

        ListNode ret2 = addTwoNumbers2(l1, l2);
        String out2 = listNodeToString(ret2);
        System.out.print(out2);
    }
    private static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode ptr = result;
        int add = 0;
        int sum;
        while (l1 != null || l2 != null || add > 0) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
            ptr.next = new ListNode(sum > 9 ? sum - 10 : sum);
            add = sum > 9 ? 1 : 0;
            ptr = ptr.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return result.next;
    }

    private static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        int flag = 0;
        while (l1 != null && l2 != null) {
            curr.next = new ListNode((l1.val + l2.val + flag) % 10);
            flag = (l1.val + l2.val + flag) / 10;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remaining = (l1 == null) ? l2 : l1;
        curr.next = remaining;
        while (flag != 0) {
            if (curr.next == null) {
                curr.next = new ListNode(flag);
                break;
            }
            int tmp = (curr.next.val + flag);
            curr.next.val = tmp % 10;
            flag = tmp / 10;
            curr = curr.next;
        }
        return result.next;
    }


    
    
    
    private static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    private static ListNode stringToListNode(String input) {
        int[] nodeValues = stringToIntegerArray(input);
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    private static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
}