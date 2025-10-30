import config.ListNode;
import config.TreeNode;

import javax.swing.*;

public class CheckIsValidBST {
    public static int MAXN = 10001;
    public static TreeNode[] stack = new TreeNode[MAXN];
    public static int r;
    public boolean isvalidBST(TreeNode root){
        if (root==null){
            return true;
        }
        r=0;
        TreeNode pre=null;
        while (r>0||root!=null){
            if (root!=null){
                stack[r++]=root;
                root=root.left;
            }else {
                pre=stack[r-1];
                root=pre.right;
                if (pre!=null && root.val<=pre.val){
                    return false;
                }
            }
        }
        return true;
    }
    private static long MAX,MIN;
    public boolean isValidBST(TreeNode root){
        if (root==null){
            MAX=Long.MIN_VALUE;
            MIN=Long.MAX_VALUE;
            return true;
        }
        boolean lok=isvalidBST(root.left);
        long lmax=MAX,lmin=MIN;
        boolean rok=isvalidBST(root);
        long rmax=MAX,rmin=MIN;
        MAX=Math.max(Math.max(rmax,lmax),root.val);
        MIN=Math.min(Math.min(rmin,lmin),root.val);
        return lok&&rok&&root.val<MAX&&root.val>MIN;
    }
}
