/**
 * 项目名称: titilink-leetcode
 * 文件名称: UniquePaths.java
 * Date: 2015/8/11
 * Copyright: 2015 www.titilink.com Inc. All rights reserved.
 * 注意：本内容仅限于titilink公司内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.ganting.leetcode201508;

import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.Map;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * author by ganting
 * date 2015-08-11
 * since v1.0.0
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 4));
    }

    private static int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];
        for ( int i = 0; i < m; i++) {
            for ( int j = 0; j < n; j++) {
                if ( i == 0 && j == 0 )
                    d[i][j] = 1;
                else if ( i == 0 && j != 0 )
                    d[i][j] = d[i][j-1];
                else if ( j == 0 && i != 0 )
                    d[i][j] = d[i-1][j];
                else
                    d[i][j] = d[i-1][j] + d[i][j-1];
            }
        }
        return d[m-1][n-1];
    }

}
