package com.momo.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的前序遍历 {
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
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        if (root == null) {
            return pre;
        }
        // 前序遍历 根->左->右
        pre.add(root.val);
        pre.addAll(preorderTraversal(root.left));
        pre.addAll(preorderTraversal(root.right));
        return pre;
    }

    /**
     * 迭代
     * 
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        if (root == null) {
            return pre;
        }
        Stack<TreeNode> tovisit = new Stack<>();
        tovisit.push(root);
        while (!tovisit.empty()) {
            TreeNode visiting = tovisit.pop();
            // 前序遍历 根->左->右
            pre.add(visiting.val);
            if (visiting.right != null) {
                tovisit.push(visiting.right);
            }
            if (visiting.left != null) {
                tovisit.push(visiting.left);
            }
        }
        return pre;
    }
}
