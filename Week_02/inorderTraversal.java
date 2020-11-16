class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>(); // 创建集合
        inorder(root,res);// 递归调用
        return res; //返回遍历后的结果
    }
    public void inorder(TreeNode root,List<Integer>res){
        if (root == null){
            return;
        }
        inorder(root.left,res); // 遍历左子树
        res.add(root.val);// JAVA提供方便的库函数操作，直接将结果存储到List中
        inorder(root.right,res); // 遍历右子树
    }
}
