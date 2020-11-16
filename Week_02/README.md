二叉树的中序遍历：

C：
// 考虑递归：思考最小的重复子单元、避免人肉递归。
void MyTraversal(struct TreeNode* root,int *res,int *returnSize)
{

  if (!root) // 递归结束条件
  {
      return;
  }
  MyTraversal(root->left,res,returnSize); // 遍历左子树

  res[(*returnSize)++] = root->val; // 左子树遍历完，添加节点到缓冲区中
  MyTraversal(root->right,res,returnSize); // 遍历右子树

}
int* inorderTraversal(struct TreeNode* root, int* returnSize){
  
  *returnSize = 0;
  int *Mynum = malloc(501*sizeof(int));  // 需要手动开辟一段地址空间
   MyTraversal(root,Mynum,returnSize);// 将待遍历树的根节点、存储遍历结果的空间首地址、节点数量传入函数中
   return Mynum;// 最终的结果。
}

JAVA：
递归：
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>(); // 创建集合
        inorder(root,res);// 递归调用
        return res; //返回遍历后的结果
    }
    public void inorder(TreeNode root,List<Integer>res){
        if (root == null){
            return;
        }
        inorder(root.left,res); // 遍历左子树
        res.add(root.val);// JAVA提供方便的库函数操作，直接将结果存储到List中
        inorder(root.right,res); // 遍历右子树
    }
}

栈
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>(); // 创建集合
        Deque<TreeNode> stk = new LinkedList<TreeNode>(); // 创建栈
        if (root == null){
            return res;
        }
        TreeNode node = root;
        while((!stk.isEmpty())||(node != null)){
            while(node != null){
             stk.push(node);// 入栈
             node = node.left;
            }
        
        node = stk.pop();// 出栈
        res.add(node.val);
        node = node.right;
    }
    return res;
 }
}

二叉树的前序遍历

JAVA

采用递归

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root,res);
        return res;
        
    }
    public void preorder(TreeNode root,List<Integer>res){
    if (root == null){
        return;
    }
     res.add(root.val);//先访问根节点
     preorder(root.left,res); // 遍历左子树
     preorder(root.right,res); // 遍历右子树
    }
}

采用栈：

// 迭代解决
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();//定义一个数组
        if (root == null){
            return res;
        }
        Deque<TreeNode> stk = new LinkedList<TreeNode>(); // 定义一个栈 不能将LinkedList转化为Stack 即不能将LinkedList转化为Stack
        TreeNode node = root;
        while((!stk.isEmpty()) || node != null){
            while(node != null){
                res.add(node.val);
                stk.push(node);//入栈
                node = node.left;
            }
            node = stk.pop();// 出栈 要有及节点进行接收。
            node = node.right;
        }
        return res;
    }
}


C：

采用递归
// 考虑递归：思考最小的重复子单元、避免人肉递归。
void MyTraversal(struct TreeNode* root,int *res,int *returnSize)
{

  if (!root) // 递归结束条件
  {
      return;
  }
  res[(*returnSize)++] = root->val; // 左子树遍历完，添加节点到缓冲区中
  MyTraversal(root->left,res,returnSize); // 遍历左子树
  MyTraversal(root->right,res,returnSize); // 遍历右子树
}
int* preorderTraversal(struct TreeNode* root, int* returnSize){
  *returnSize = 0;
  int *Mynum = malloc(501*sizeof(int));  // 需要手动开辟一段地址空间
   MyTraversal(root,Mynum,returnSize);// 将待遍历树的根节点、存储遍历结果的空间首地址、节点数量传入函数中
   return Mynum;// 最终的结果。
}

采用栈：

int* preorderTraversal(struct TreeNode* root,int* returnSize){
    int *res = malloc(sizeof(int)*2000); // 存储用于遍历后的的返回结果
    *returnSize = 0;
    if (root == NULL){
        return res;
    }
   struct TreeNode *stk[2000];// 开辟栈 开栈的方法
   struct TreeNode *node = root;
   int stack_top = 0;// 定义栈顶
   while(stack_top > 0 || node != NULL){
        while(node != NULL){
         res[(*returnSize)++] = node->val; // 这种指针取值后再执行加一的操作，要小心，不可写成res[*returnsize++]这种违规形式。同时指针操作转化为数组操作的这种用法要强加。
         stk[stack_top++] = node; // 入栈  入栈的时机
         node = node->left;//移动至左子树根节点

        }
        node = stk[--stack_top];//出栈 易写成stack_top--;
        node = node->right;
    }
    return res;
}





