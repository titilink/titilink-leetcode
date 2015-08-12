/**
 * 项目名称: titilink-leetcode
 * 文件名称: ZigzagLevelOrder.java
 * Date: 2015/8/12
 * Copyright: 2015 www.titilink.com Inc. All rights reserved.
 * 注意：本内容仅限于titilink公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.ganting.leetcode201508;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 *
 *  binary level order
 * author by ganting
 * date 2015-08-12
 * since v1.0.0
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {
        TreeNode l3 = new TreeNode(15, null, null);
        TreeNode l4 = new TreeNode(7, null, null);
        TreeNode l2 = new TreeNode(20, l3, l4);
        TreeNode l1 = new TreeNode(9 , null, null);
        TreeNode root = new TreeNode(3, l1, l2);
        List<List<Integer>> zigzag = zigzagLevelOrder(root);
        System.out.println(zigzag);
    }

    /**
     * 根据数的序列化字符串，构造数
     *
     * @param serializeTree 序列化字符串
     * @return 数的根节点
     */
    private static TreeNode constructTree(String serializeTree) {
        String[] splits = serializeTree.split(",");
        for ( int i = 0; i < splits.length; i++ ) {
        }
        return null;
    }

    /**
     * 有两点需要考虑
     * 1、如何实现广度优先算法
     * 2、如何实现数的层级
     *
     * @param root 根节点
     * @return zigzag数据结构
     */
    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int nextLevel = 0;
        int currentLevel = 1;
        TreeNode node;
        boolean left = true;
        while (!queue.isEmpty()) {
            node = queue.removeFirst();
            al.add(node.val);
            currentLevel--;
            if ( null != node.left ) {
                queue.addLast(node.left);
                nextLevel++;
            }
            if ( null != node.right ) {
                queue.addLast(node.right);
                nextLevel++;
            }
            if ( currentLevel == 0 ) {
                if (!left)
                    Collections.reverse(al);
                left = !left;
                ret.add(al);
                al = new ArrayList<>();
                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }

        return ret;
    }

    private static class TreeNode {

        public int val;

        public TreeNode left;

        public TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

}
