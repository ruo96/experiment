package com.experiment.algo.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuruohong
 * @date 2022-06-06 23:08
 */
public class FindNQueen {

    @Test
    public void Test14() {
        List<List<String>> lists = solveNQueens(3);

        lists.forEach(e->{
            e.forEach(f->{
                System.out.println(f);
            });
            System.out.println("====================");
        });

    }

    public List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //这个用来表示皇后的攻击方范围
        int[][] attack = new int[n][n];
        // queue用来记录皇后的位置
        char[][] queue = new char[n][n];

        // 初始化皇后的位置
        for (char[] c : queue) {
            Arrays.fill(c, '.');
        }

        // 初始化皇后的攻击范围 0 代表攻击不到， 1代表可以攻击到
        for (int[] c : attack) {
            Arrays.fill(c, 0);
        }

        backtrack(0, n, queue, attack);

        return res;
    }

    /**
     * 每行只能放置一个皇后
     * @param k 表示当前处理的行
     * @param n 表示需要放置多少个皇后，同时也代表棋盘的大小： n*n
     * @param queue 用来记录皇后的位置
     * @param attack 用来表示皇后的攻击方范围
     */
    private void backtrack(int k, int n, char[][] queue, int[][] attack) {
        //  先找到截至条件
        if (k == n) {
            List<String> list = new ArrayList<>();
            for (char[] c : queue) {
                list.add(String.copyValueOf(c));
            }
            res.add(list);
            return;
        }
        /** 每一行只能放置一个皇后，每一列也是一样的*/
        /** 所以在第k行中，从0列到n-1列， 判断皇后应该出现在哪个位置*/
        for (int i = 0; i < n; i++) {
            /** 如果这个位置发现attack == 0， 那么就说明可以放置皇后，可以来试试*/
            if (attack[k][i] == 0) {
                /** 如果在k行放置了皇后，那么就需要考虑在k+1行改怎么放置了，
                 *  而且有可能在这个位置放了之后，后续其他行就放不了了， 所以后续还需要能够回到这个装填，那么就需要记录此时的attack
                 *  而且要使用深拷贝，防止被同步修改掉
                 * */
                int[][] temp = new int[n][n];
                for (int l = 0; l < n; l++) {
                    for (int m = 0; m < n; m++) {
                        temp[l][m] = attack[l][m];
                    }
                }
                /** 保存好现场之后， 现在可以来修改queue的状态了*/
                queue[k][i] = 'Q';
                /** 由于更新了queue的位置，那么queue可以攻击的范围又更加多了， 那么还需要更新attack的范围*/
                checkQueenAttack(k, i, attack);
                /** 开始使用递归解决下一行问题*/
                backtrack(k+1, n, queue, attack);
                // 递归结束后，恢复原来的attack状态，考虑能够在k, i+1的位置放置
                attack = temp;
                // 恢复queue的点的状态
                queue[k][i] = '.';
            }
        }
    }

    private void checkQueenAttack(int x, int y, int[][] attack) {
        /**
         * 对于每个坐标来说，都有八个方向可以攻击，
         * 左上：  x-1, y-1
         * 上：    x-1, y
         * 右上：  x-1, y+1
         * 左：   x  y-1
         * 右；   x  y+1
         * 左下； x+1  y-1
         * 下；   x+1  y
         * 右下： x+1   y+1
         * 通过两个一维数组可以表示这八个方向，其中dx表示x轴的方向， 在二维矩阵中代表着某一行，是上下方向的
         */
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        /** 首先更新x，y所在位置*/
        attack[x][y] = 1;
        // 然后以x，y为中心，更新他的八个方向
        for (int j = 0; j < 8; j++) {
            for (int i = 1; i < attack.length; i++) {
                /** 更新x轴的坐标*/
                int nx = x + i * dx[j];
                /** 更新y轴的坐标*/
                int ny = y + i * dy[j];

                if (nx >= 0 && nx < attack.length && ny >= 0 && ny < attack.length) {
                    attack[nx][ny] = 1;
                }

            }
        }

    }
}
