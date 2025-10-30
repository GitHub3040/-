public class DetectCycle {
    public ListNode detectCycle(ListNode head){
        if(head==null || head.next==null||head.next.next==null){
            return null;
        }
        ListNode fast=head.next.next,slow=head.next;
        while (slow!=fast){
            if(fast.next==null || fast.next.next==null){
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        fast=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
