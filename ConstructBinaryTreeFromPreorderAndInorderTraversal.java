class Solution {
    HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
       return buildTreeHeleper(preorder,inorder,0,preorder.length,0,inorder.length);
    }
    public TreeNode buildTreeHeleper(int[] preorder,int[] inorder,int p_start,int p_end,int i_start,int i_end){
        if (p_end == p_start){
            return  null;
        }
        int root_val = preorder[p_start]; //根节点的值
        TreeNode root = new TreeNode(root_val); // 定义一个根节点
        int root_index_i = map.get(root_val);// 根节点在中序遍历结果的位置
        int left_num =  root_index_i - i_start; // 左子树节点数量
        root.left = buildTreeHeleper(preorder,inorder,p_start+1,p_start+left_num+1,i_start,root_index_i);
        root.right = buildTreeHeleper(preorder,inorder,p_start+left_num+1,p_end,root_index_i+1,i_end);
        return root;

    }
}
