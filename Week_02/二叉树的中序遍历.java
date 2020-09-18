package com.momo.algorithm;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        if (root == null) {
            return in;
        }
        // 中序遍历 左->根->右
        in.addAll(inorderTraversal(root.left));
        in.add(root.val);
        in.addAll(inorderTraversal(root.right));
        return in;
    }
}
