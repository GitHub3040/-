public class ReverseKGroups {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur=head,tail=head,pre=new ListNode();
        ListNode dummy=pre;
        int cnt=1;
        while (tail!=null){
            if (cnt==k){
                ListNode tmp=tail.next;
                tail.next=null;
                ListNode nxt =reverse(cur);
                pre.next=nxt;
                pre=cur;
                cur=tail=tmp;
                cnt=1;
            }
            else {
                cnt++;
                tail = tail.next;
            }
        }
        return dummy.next;
    }
    public static ListNode reverse(ListNode head){
        ListNode pre=null,cur=head;
        while(cur!=null){
            ListNode tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        int [] arr={1,2,3,4,5};
        int n=arr.length;
        ListNode head=new ListNode(arr[0]);
        ListNode cur=head;
        for (int i = 1; i < n; i++) {
            ListNode nxt=new ListNode(arr[i]);
            cur.next=nxt;
            cur=nxt;
        }
        reverseKGroup(head,2);
    }
}
