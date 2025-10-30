import config.TreeNode;

public class LevelorderSerializeAndDeserialize {
    private static int l,r;
    private static int MAX=10001;
    private static TreeNode[] queue=new TreeNode[MAX];
    public String serialize(TreeNode root){
        StringBuilder builder=new StringBuilder();
        if(root!=null){
            f(root, builder);
        }
        return builder.toString();
    }
    public void f(TreeNode root,StringBuilder builder){
        l=r=0;
        queue[r++]=root;
        builder.append(root.val+"," );
        while (l<r){
            TreeNode node=queue[l++];
            if (node.left!=null){
                queue[r++]=node.left;
                builder.append(node.left.val+",");
            }else{
                builder.append("#,");
            }
            if (node.right!=null){
                builder.append(node.right.val+",");
                queue[r++]=node.right;
            }else {
                builder.append("#,");
            }
        }
    }
    public TreeNode deserialize(String data){
        if (data.equals("")){
            return null;
        }
        String [] vals=data.split(",");
        TreeNode head=g(vals);
        return head;
    }
    public TreeNode g(String[] c){
        l=r=0;
        int idx=0;
        TreeNode root=generate(c[idx++]);
        queue[r++]=root;
        while (l<r){
            TreeNode node=queue[l++];
            node.left = generate(c[idx++]);
            node.right = generate(c[idx++]);
            if (node.left!=null){
                queue[r++]=node.left;
            }
            if (node.right!=null){
                queue[r++]=node.right;
            }
        }
        return root;
    }
    public TreeNode generate(String x){
        return x.equals("#") ? null : new TreeNode(Integer.valueOf(x));

    }
}
