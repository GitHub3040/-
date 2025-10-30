import config.TreeNode;

public class PreorderSerializeAndDeserialize {
    private static int cnt;
    public String serialize(TreeNode root){
        StringBuilder builder = new StringBuilder();
        f(root,builder);
        return builder.toString();
    }
    public void f(TreeNode root,StringBuilder builder){
        if (root==null) {
            builder.append("#,");
        }else{
            builder.append(root.val+",");
            f(root.left,builder);
            f(root.right,builder);
        }
    }
    public TreeNode deserialize(String data){
        String[] val=data.split(",");
        cnt=0;
        TreeNode head=g(val);
        return head;
    }
    public TreeNode g(String[] c){
        String cur=c[cnt++];
        if(cur.equals("#")){
            return null;
        }else{
            TreeNode head=new TreeNode(Integer.valueOf(cur));
            head.left=new TreeNode(g(c).val);
            head.right=new TreeNode(g(c).val);
            return head;
        }
    }
}
