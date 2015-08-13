/**
 * 项目名称: titilink-leetcode
 * 文件名称: BuildTree.java
 * Date: 2015/8/12
 * Copyright: 2015 www.titilink.com Inc. All rights reserved.
 * 注意：本内容仅限于titilink公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.ganting.leetcode201508;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 *
 * author by ganting
 * date 2015-08-12
 * since v1.0.0
 */
 public class BuildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree0(int[] preorder, int[] inorder) {
        if ( preorder.length == 0 ) return null;
        int mVal = preorder[0];
        if ( preorder.length == 1) return new TreeNode(mVal);
        //寻找root index
        int m = 0;
        for (int i = 0; i < inorder.length; i++) {
            if ( inorder[i] == mVal ) m = i;
        }
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, m);
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, leftInOrder.length + 1);
        TreeNode left = buildTree(leftPreOrder, leftInOrder);
        int[] rightInOrder = Arrays.copyOfRange(inorder, m + 1, inorder.length);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, leftInOrder.length + 1, preorder.length);
        TreeNode right = buildTree(rightPreOrder, rightInOrder);
        TreeNode root = new TreeNode(mVal);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if ( null == preorder || null == inorder )
            return null;
        Map<Integer, Integer> rootIdxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            rootIdxMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder,
                0, inorder.length - 1, rootIdxMap);
    }

    private TreeNode helper(int[] preorder, int preL, int preR,
            int[] inorder, int inL, int inR, Map<Integer, Integer> rootIdxMap) {
        if ( preL > preR || inL > inR)
            return null;
        TreeNode root = new TreeNode(preorder[preL]);
        int rootIdx = rootIdxMap.get(root.val);
        root.left = helper(preorder, preL + 1, rootIdx + preL - inL,
                inorder, inL, rootIdx - 1, rootIdxMap);
        root.right = helper(preorder, rootIdx + preL - inL + 1, preR,
                inorder, rootIdx + 1, inR, rootIdxMap);
        return root;
    }

    @Test
    public void testBuildTree() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 8, 7};
        int[] inorder = {4, 2, 5, 1, 6, 8, 3, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }

}
