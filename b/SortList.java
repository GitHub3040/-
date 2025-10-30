
public class SortList {
    private static ListNode start,end;
    public ListNode sortList(ListNode head){
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        ListNode l1,r1,l2,r2,nxt,last;
        for (int i = 1; i < n; i<<=1) {
            l1=head;
            r1=getlast(l1,i);
            l2 = r1.next;
            r2 = getlast(l2, i);
            nxt=r2.next;
            r1.next = null;
            r2.next = null;
            merge(l1,r1,l2,r2);
            head=start;
            last=end;
            while (nxt!=null){
                l1=nxt;
                r1=getlast(l1,i);
                l2=r1.next;
                if (l2==null){
                    last.next=l1;
                    break;
                }
                r2=getlast(l2,i);
                nxt=r2.next;
                r1.next = null;
                r2.next = null;
                merge(l1,r1,l2,r2);
                last.next=start;
                last=end;
            }
        }
        return head;
    }
    public void merge(ListNode l1,ListNode r1,ListNode l2,ListNode r2){
        ListNode pre;
        if (l1.val<l2.val){
            pre=l1;
            start=l1;
            l1=l1.next;
        }else {
            pre=l2;
            start=l2;
            l2=l2.next;
        }
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                pre.next=l1;
                pre=l1;
                l1=l1.next;
            }else {
                pre.next=l2;
                pre=l2;
                l2=l2.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
            end=r1;
        } else {
            pre.next = l2;
            end=r2;
        }

    }
    public ListNode getlast(ListNode head,int k){
        while (head.next!=null&&--k>0){
            head=head.next;
        }
        return  head;
    }
}
