
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root,res);
        return res;
        
    }
    public void preorder(TreeNode root,List<Integer>res){
    if (root == null){
        return;
    }
     res.add(root.val);//先访问根节点
     preorder(root.left,res); // 遍历左子树
     preorder(root.right,res); // 遍历右子树
    }
}
