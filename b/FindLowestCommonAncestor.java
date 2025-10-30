import config.TreeNode;

public class FindLowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if (root==null || root==p || root==q){
            return root;
        }
        TreeNode lnode=lowestCommonAncestor(root.left,p,q);
        TreeNode rnode=lowestCommonAncestor(root.right,p,q);
        if (lnode!=null&&rnode!=null){
            return root;
        }
        if (lnode==null&&rnode==null){
            return null;
        }
        return lnode!=null ? lnode : rnode;
    }
    public TreeNode lowestCommonAncestorBinarySearch(TreeNode root,TreeNode p,TreeNode q){
        while (root.val!=p.val && root.val!=p.val){
            if (Math.min(p.val, q.val) < root.val && root.val < Math.max(p.val, q.val)) {
                break;
            }
            root = root.val < Math.min(p.val, q.val) ? root.right : root.left;
        }
        return root;
    }
}
