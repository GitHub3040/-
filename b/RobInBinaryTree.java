import config.TreeNode;

import java.util.Map;
import java.util.Timer;

public class RobInBinaryTree {
    private static int YES;
    private static int NO;
    public void rob1(TreeNode root){
        if(root==null){
            YES=0;
            NO=0;
            return ;
        }
        rob1(root.left);
        int lrob=YES,lnorob=NO;
        rob1(root.right);
        int rrob=YES,rnorob=NO;
        YES=root.val+lnorob+rnorob;
        NO=Math.max(lrob,lnorob)+Math.max(rrob,rnorob);
        return ;
    }
    public int rob(TreeNode root){
        rob1(root);
        return Math.max(YES,NO);
    }
}
