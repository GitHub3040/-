import config.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class PathSumBinaryTree {
    private static List<List<Integer>> ans;
    private static List<Integer> path1;
    public List<List<Integer>> pathSum(TreeNode root,int tarhetSum){
        ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        path1=new ArrayList<>();
        path(root,tarhetSum,0);
        return ans;
    }
    public void path(TreeNode root,int targetSum,int sum){
        if (root.left==null && root.right==null){
            if(root.val+sum==targetSum){
                path1.add(root.val);
                copy(path1);
                path1.remove(path1.size()-1);
            }
        }else {
            path1.add(root.val);
            if(root.left!=null){
                path(root.left,targetSum,sum+root.val);
            }if (root.right!=null){
                path(root.right,targetSum,sum+root.val);
            }
            path1.remove(path1.size()-1);
        }
    }
    public void copy(List<Integer> path){
        List<Integer> copy=new ArrayList<>();
        for (int c:path){
            copy.add(c);
        }
        ans.add(copy);
    }
}
