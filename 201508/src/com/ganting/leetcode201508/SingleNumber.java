/**
 * 项目名称: titilink-leetcode
 * 文件名称: SingleNumber.java
 * Date: 2015/8/11
 * Copyright: 2015 www.titilink.com Inc. All rights reserved.
 * 注意：本内容仅限于titilink公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.ganting.leetcode201508;

import java.util.BitSet;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * author by ganting
 * date 2015-08-11
 * since v1.0.0
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 4,3, 3,4};
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        int len = nums.length;
        BitSet sets = new BitSet();

        for (int i = 0; i < len; i++) {
            sets.set(nums[i], sets.get(nums[i]) ? false : true);
        }
        for ( int i = sets.size() - 1;  i >= 0;  i-- ) {
            if ( sets.get(i) )
                return i;
        }
        return -1;
    }

}
