package com.ycsyxt.util;

import java.util.Arrays;

/**
 * @author yuxt
 * @date 2021/5/9
 * @description 生命游戏，为1970年英国数学家J.H.Conway所提出，
 * 某一细胞的邻居包括上，下，左，右，左上，左下，右上与右下相邻的细胞，游戏规则如下：
 *
 * 1，孤单死亡：如果细胞的邻居小于一个，则该细胞在下一个状态死亡。
 *
 * 2，拥挤死亡：如果细胞的邻居在四个以上，则该细胞在下一个状态死亡。
 *
 * 3，稳定：如果细胞的邻居为两个或三个，则该细胞在下一个状态稳定。
 *
 * 4，复活：如果某位置原无细胞存活，而该位置的邻居为三个，则该位置将复活一个细胞。
 */
public class LifeGameUtil {
    /**
     * 棋盘行大小
     */
    public static int ROW;
    /**
     * 棋盘列大小
     */
    public static int COL;
    /**
     * 将该数组里的元素作为行下标，调用Arrays.fill()填充
     */
    public static int[] LIVE_ARRAY;
    /**
     * 当前棋盘
     */
    private static int[][] map = new int[0][];
    /**
     * 演化一次后的棋盘
     */
    private static int[][] nextMap = new int[0][];

    public static int[][] init(int row, int col, int[] liveArray) {
        ROW = row;
        COL = col;
        LIVE_ARRAY = liveArray;
        map = new int[ROW][COL];
        nextMap = new int[ROW][COL];

        if (liveArray.length == 0) {
            //没传初始化参数，初始化对角线上的值
            for (int i = 0, j = 0; i < ROW && j < COL; i++, j++) {
                map[i][j] = 1;
            }
            for (int i = ROW - 1, j = 0; i >= 0 && j < COL; i--, j++) {
                map[i][j] = 1;
            }
        } else {
            //根据参数初始化
            for (int item : liveArray) {
                Arrays.fill(map[item], 1);
            }
        }
        return map;
    }
    public static int[][] next() {
        for(int row = 0; row < map.length; row++) {
            for(int col = 0; col < map[0].length; col++) {
                switch (neighbors(row, col)) {
                    case 0:
                    case 1:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        nextMap[row][col] = 0;
                        break;
                    case 2:
                        nextMap[row][col] = map[row][col];
                        break;
                    case 3:
                        nextMap[row][col] = 1;
                        break;
                }
            }
        }
        int[][] temp = nextMap;
        nextMap = map;
        map = temp;
        return map;
    }

    private static int neighbors(int row, int col) {
        int count = 0;

        for(int r = row-1; r <= row+1; r++) {
            for(int c = col-1; c <= col+1; c++) {
                if(r < 0 || r >= map.length ||
                        c < 0 || c >= map[0].length)
                    continue;
                if(map[r][c] == 1) count++;
            }
        }

        if(map[row][col] == 1) count--;

        return count;
    }
}
