
/**
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 */
public class 二叉树的最小深度 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归方法：分解成最小子问题，获取当前层的最小深度，再递归左子树和右子树的最小深度
     * 
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        // terminator
        if (root == null) {
            return 0;
        }
        // process
        // drill down
        int minleft = minDepth(root.left);
        int minright = minDepth(root.right);

        // 区别于最大深度，左右子节点一个为空时，最小深度不是1
        return minleft == 0 || minright == 0 ? minleft + minright + 1 : 1 + Math.min(minleft, minright);
    }

}
