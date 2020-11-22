学习笔记
求最近公共祖先的递归思路：
1、杜绝人肉递归。
2、思考不同树的结构下，最小公共祖先的几种情况：
   如果根节点的左右儿子均为空，说明节点不存在，则直接返回空。
   如果两个节点在根节点的一侧，则根节点的左儿子或者右儿子为最近的公共祖先。
   如果两个节点就在根节点的两侧，则根根节点就为最近的公共祖先。
3、左右儿子通过递归得到。
4、递归终结条件：不只是root为空，考虑当root如果为两个节点中的一个，就不需要再向    下递归，直接返回root即可。

通过前序和中序遍历序列构造二叉树的递归思路：
前序遍历的情况是：根节点->左子树节点->右子树节点。
中序遍历的情况是：左子树节点->根节点->右子树节点。
通过前序遍历结果可以找到树的根节点。
将根节点的左子树和右子树看成是独立的树，那么根节点的左儿子就是左子树的根节点，右儿子就是右子树的根节点。
重复上边的步骤继续求得左节点和右节点。
递归终结条件，前序遍历结果为空，说明是颗空树。
