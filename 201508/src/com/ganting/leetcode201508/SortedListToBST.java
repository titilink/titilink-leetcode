/**
 * 项目名称: titilink-leetcode
 * 文件名称: SortedListToBST.java
 * Date: 2015/8/12
 * Copyright: 2015 www.titilink.com Inc. All rights reserved.
 * 注意：本内容仅限于titilink公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.ganting.leetcode201508;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * 
 * author by ganting
 * date 2015-08-12
 * since v1.0.0
 */
 public class SortedListToBST {

    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if ( null == head ) return null;
        Stack<Integer> vals = new Stack<>();
        while (null != head) {
            vals.push(head.val);
            head = head.next;
        }
        return helper(vals, 0, vals.size() - 1);
    }

    private TreeNode helper(Stack<Integer> nums, int l ,int r) {
        if ( l > r)
            return null;
        int m = ( l + r ) / 2;
        TreeNode left = helper(nums, l, m - 1);
        TreeNode right = helper(nums, m + 1, r);
        TreeNode root = new TreeNode(nums.get(m));
        root.left = left;
        root.right = right;
        return root;
    }

}
