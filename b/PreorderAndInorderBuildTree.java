import config.TreeNode;

import javax.swing.plaf.PanelUI;
import java.time.Year;
import java.util.HashMap;

public class PreorderAndInorderBuildTree {
    public TreeNode buildTree(int[] preorder,int[] inorder){
        if (preorder==null||inorder==null||preorder.length!=inorder.length){
            return null;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return f(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    public TreeNode f(int[] pre,int l1,int r1,int[] in,int l2,int r2,HashMap<Integer,Integer> map){
        if (l1>r1){
            return null;
        }
        TreeNode root=new TreeNode(pre[l1]);
        if (l1==r1){
            return root;
        }
        int idx=map.get(pre[l1]);
        root.left=f(pre,l1+1,l1+idx-l2,in,l2,idx-1,map);
        root.right=f(pre,l1+idx-l2+1,r1,in,idx+1,r2,map);
        return root;
    }

}
