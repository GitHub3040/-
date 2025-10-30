import config.TreeNode;

import java.util.Timer;

public class DepthOfBinaryTree {
    public int maxDepth(TreeNode root){
        return root!=null ? Math.max(maxDepth(root.left),maxDepth(root.right))+1 : 0;
    }
    public int minDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        if(root.right==null&&root.left==null){
            return 1;
        }
        int lDepth=Integer.MAX_VALUE;
        int rDepth=Integer.MAX_VALUE;
        if (root.left!=null){
            lDepth=Math.min(lDepth,minDepth(root.left));
        }
        if (root.right!=null){
            rDepth=Math.min(rDepth,minDepth(root.right));
        }
        return Math.min(lDepth,rDepth)+1;
    }
}
