
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 */
public class 验证二叉搜索树 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private long pre = Long.MIN_VALUE;

    /**
     * 思路：中序遍历时，判断当前节点是否大于中序遍历的前一个节点，如果大于，说明满足BST，继续遍历；否则直接返回 false。
     * 
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 中序遍历 左->根->右
        if (!isValidBST(root.left)) {
            return false;
        }
        // 判断当前节点是否大于中序遍历的前一个节点，如果大于，说明满足BST，继续遍历；否则直接返回 false
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }

    /**
     * 思路：中序遍历记录所有值，随后遍历list是否依次从小到大
     * 
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = inorder(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.addAll(inorder(root.left));
        list.add(root.val);
        list.addAll(inorder(root.right));
        return list;
    }
}
