import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

     public class ListNode {
         int val;
         ListNode next = null;
         public ListNode(int val) {
                this.val = val;
         }
     }
    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        PriorityQueue<ListNode> priorityQueue=new PriorityQueue<>((a,b)-> a.val-b.val);
        for (ListNode h : lists) {
            if (h == null) {
                priorityQueue.add(h);
            }
        }
        if(priorityQueue.isEmpty()){
            return null ;
        }
        ListNode head=priorityQueue.poll();
        ListNode cur=head;
        if (head.next != null) {
            priorityQueue.add(head.next);
        }
        while (!priorityQueue.isEmpty()){
            head.next=priorityQueue.poll();
            head=head.next;
            if(head.next!=null){
                priorityQueue.add(head.next);
            }
        }
        return cur;

    }

}
