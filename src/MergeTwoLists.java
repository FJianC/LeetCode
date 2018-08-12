/**
 * @author FJianC
 */
/**
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 *      输入：1->2->4, 1->3->4
 *      输出：1->1->2->3->4->4
 * */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * */
public class MergeTwoLists {

    public static void main(String[] args) {
        String line = "[1,2,4]";
        ListNode l1 = stringToListNode(line);
        line = "[]";
        ListNode l2 = stringToListNode(line);
        System.out.println(listNodeToString(new MergeTwoLists().mergeTwoLists10(l1, l2)));
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head;
        ListNode current;
        if (l1.val < l2.val) {
            head = current = l1;
            l1 = l1.next;
        } else {
            head = current = l2;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return head;
    }

    private ListNode mergeTwoLists10(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode ptr = result;
        while (l1 != null || l2 != null) {
            while (l1 != null && l2 != null && l1.val <= l2.val) {
                ptr.next = new ListNode(l1.val);
                ptr = ptr.next;
                l1 = l1.next;
            }
            if (l1 == null) {
                while (l2 != null) {
                    ptr.next = new ListNode(l2.val);
                    ptr = ptr.next;
                    l2 = l2.next;
                }
            }
            while (l1 != null && l2 != null && l1.val >= l2.val) {
                ptr.next = new ListNode(l2.val);
                ptr = ptr.next;
                l2 = l2.next;
            }
            if (l2 == null) {
                while (l1 != null) {
                    ptr.next = new ListNode(l1.val);
                    ptr = ptr.next;
                    l1 = l1.next;
                }
            }
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
