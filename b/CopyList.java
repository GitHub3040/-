import config.Node;
public class CopyList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur=head;
        Node nxt=null;
        while (cur!=null){
            nxt=cur.next;
            cur.next=new Node(cur.val);
            cur.next.next=nxt;
            cur=nxt;
        }
        cur=head;
        Node copy=null;
        while (cur!=null){
            nxt=cur.next.next;
            copy=cur.next;
            copy.random= cur.random!=null ? cur.random.next : null;
            cur=nxt;
        }
        cur=head;
        Node ans=head.next;
        while (cur!=null){
            nxt=cur.next.next;
            copy=cur.next;
            cur.next=nxt;
            copy.next= nxt!=null ? nxt.next :null;
            cur=nxt;
        }
        return ans;
    }
}
