import config.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class WidthOfBinaryTree {
    private static int MAX=2001;
    private static TreeNode[] queue=new TreeNode[MAX];
    private static int l,r;
    private static int ans=0;
    public static int widthOfBinaryTree (TreeNode root){
        if(root==null){
            return ans;
        }
        l=r=0;
        queue[r++]=root;
        while (l<r){
            List<Integer> arr=new ArrayList<>();
            int n=r-l;
            ans=Math.max(ans,n);
            for (int i = 0; i < n; i++) {
                TreeNode node=queue[l++];
                arr.add(node.val);
                if (node.left!=null){
                    queue[r++]=node.left;
                }
                if (node.right!=null){
                    queue[r++]=node.right;
                }
            }
        }
        return ans;
    }
}
