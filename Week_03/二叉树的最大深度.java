
/**
 * 给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 */
public class 二叉树的最大深度 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归方法：分解成最小子问题，获取当前层的最大深度，再递归左子树和右子树的最大深度
     * 
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        // terminator
        if (root == null) {
            return 0;
        }
        // process

        // drill down
        int maxleft = maxDepth(root.left);
        int maxright = maxDepth(root.right);

        return 1 + Math.max(maxleft, maxright);
    }

}
