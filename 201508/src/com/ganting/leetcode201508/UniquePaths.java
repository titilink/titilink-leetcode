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

    private static Map<Position, Integer> roads = new HashMap<>();

    private static int sum = 0;

    private static int uniquePaths(int m, int n) {
        Position finish = new Position(m - 1, n - 1, null );
        findPosition(finish);
        return sum;
    }

    private static boolean findPosition(Position p) {
        if ( roads.containsKey(p) )
            return false;
        roads.put(p, 0);
        if ( p.x - 1 >= 0 ) {
            roads.put(p, roads.get(p) + 1);
            findPosition(new Position(p.x - 1, p.y, p));
        }
        if ( p.y - 1 >= 0 ) {
            roads.put(p, roads.get(p) + 1);
            findPosition(new Position(p.x, p.y - 1, p));
        }
        if ( p .x == 0 && p.y == 0 ) {
            sum += 1;
            return true;
        }
        return false;
    }

    private static class Position {
        public int x;
        public int y;
        public Position next;
        public Position(int x, int y, Position next) {
            this.x = x;
            this.y = y;
            this.next = next;
        }
        public int hashCode() {
            return (x * 14 + 7 ) * 7;
        }
        public boolean equals(Object obj) {
            Position p = (Position) obj;
            if ( p == this ) return true;
            if ( p.x == this.x && this.y == p.y) return true;
            return false;
        }
    }

}
