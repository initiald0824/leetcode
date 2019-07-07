/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字0之外，这两个数都不会以0开头。
 * 示例：
 *  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  输出：7 -> 0 -> 8
 *  原因：342 + 465 = 807
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

/**
 * @author initiald0824
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(carry);
        ListNode p = head;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            int val = sum % 10;
            carry = sum / 10;
            p.next = new ListNode(val);
            p = p.next;
        }
        if (carry != 0) {
            p.next = new ListNode(carry);
            p = p.next;
        }
        p.next = null;
        return head.next;
    }

    public static ListNode create(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int num: nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return head.next;
    }

    public static void print(ListNode l) {
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {2, 4, 3};
        int[] b = new int[] {5, 6, 4};
        ListNode l1 = create(a);
        ListNode l2 = create(b);
        ListNode res = new AddTwoNumbers().addTwoNumbers(l1, l2);
        print(res);
    }
}
