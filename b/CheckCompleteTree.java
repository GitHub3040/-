import config.TreeNode;
// 测试链接 : https://leetcode.cn/problems/check-completeness-of-a-binary-tree/


public class CheckCompleteTree {
    private static int MAX=1001;
    private static TreeNode[] queue=new TreeNode[MAX];
    private static int l,r;
    public boolean isCompleteTree(TreeNode root){
        boolean flag=false;
        l=r=0;
        queue[r++]=root;
        while (l<r){
            int size=r-l;
            for (int i = 0; i < size; i++) {
                TreeNode node=queue[l++];
                if ((flag&&(node.left!=null||node.right!=null)) || (node.left==null && node.right!=null)){
                    return false;
                }
                if (node.left!=null){
                    queue[r++]=node.left;
                }
                if (node.right!=null){
                    queue[r++]=node.right;
                }
                if (node.right!=null || node.left!=null){
                    flag=true;
                }
            }
        }
    return true;
    }
}
