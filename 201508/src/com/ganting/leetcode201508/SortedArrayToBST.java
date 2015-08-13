/**
 * 项目名称: titilink-leetcode
 * 文件名称: SortedArrayToBST.java
 * Date: 2015/8/12
 * Copyright: 2015 www.titilink.com Inc. All rights reserved.
 * 注意：本内容仅限于titilink公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.ganting.leetcode201508;

import org.junit.Test;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * 
 * author by ganting
 * date 2015-08-12
 * since v1.0.0
 */
public class SortedArrayToBST {

    @Test
    public void testSortedArrayToBST() {
        int[] nums = {1, 2, 3, 4, 5, 6 ,7};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root);
    }

    private TreeNode sortedArrayToBST(int[] nums) {
        if ( null == nums || nums.length == 0 ) {
            return null;
        }
        if ( nums.length == 1 ) {
            return new TreeNode(nums[0], null, null);
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if ( l > r)
            return null;
        int m = ( l + r ) / 2;
        TreeNode left = helper(nums, l, m - 1);
        TreeNode right = helper(nums, m + 1, r);
        TreeNode root = new TreeNode(nums[m], left, right);
        return root;
    }

    private class TreeNode {
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
