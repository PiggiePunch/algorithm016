package com.momo.algorithm;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的后序遍历 {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> post = new ArrayList<Integer>();
        if (root == null) {
            return post;
        }
        // 后序遍历 左->右->根
        post.addAll(postorderTraversal(root.left));
        post.addAll(postorderTraversal(root.right));
        post.add(root.val);
        return post;
    }
}
