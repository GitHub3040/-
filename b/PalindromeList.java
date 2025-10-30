import config.ListNode;

import java.util.Timer;
import java.util.TreeMap;

public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        if (head.next==null && head==null){
            return true;
        }
        ListNode fast=head,slow=head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;
        ListNode last=slow,nxt=null;
        slow=slow.next;
        last.next=null;
        while (slow!=null){
            nxt=slow.next;
            slow.next=last;
            last=slow;
            slow=nxt;
        }
        boolean ans= true;
        ListNode left=head;
        ListNode right=last;
        while (left != null && right != null) {
            if (left.val != right.val) {
                ans = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        slow=last.next;
        while (slow!=mid){
            nxt=slow.next;
            slow.next=last;
            last=slow;
            slow=nxt;
        }
        System.out.println(head);
        return ans;
    }
}
