import config.TreeNode;

import java.util.*;

public class Levelprint {
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int n=queue.size();
            List<Integer> arr=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node= queue.poll();
                arr.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            ans.add(arr);
        }
        return ans;
    }
    private static int MAX=2001;
    private static TreeNode[] queue=new TreeNode[MAX];
    private static int l,r;
    public List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        l=r=0;
        queue[r++]=root;
        while (l<r){
            List<Integer> arr=new ArrayList<>();
            int n=r-l;
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
         ans.add(arr);
        }
        return ans;
    }
}
