import config.TreeNode;

public class CheckBinaryTreeIsBalance {
    private static boolean balance;
    public boolean isBalanced(TreeNode root){
        balance=true;
        depth(root);
        return balance;
    }
    public int depth(TreeNode root){
        if (root==null){
            return 0;
        }
        int ldepth=depth(root.left);
        int rdepth=depth(root.right);
        if (Math.abs(ldepth-rdepth)>1){
            balance=false;
        }
        return Math.max(ldepth,rdepth)+1;
    }
}
