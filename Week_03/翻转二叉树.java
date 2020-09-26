
/**
 * 翻转一棵二叉树。
 * 
 * 示例：
 * 
 * 输入：
 * 
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 
 * 
 */
public class 翻转二叉树 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 思路：交换当前节点的左右节点，再递归的交换当前节点的左节点，递归的交换当前节点的右节点，直到最后的节点为叶子结点返回
     * 
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        // 递归退出条件
        if (root == null) {
            return null;
        }
        // 处理本层交换两个节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 下探到下层继续交换
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
