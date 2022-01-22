//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ['1','1','1','1','0'],
//  ['1','1','0','1','0'],
//  ['1','1','0','0','0'],
//  ['0','0','0','0','0']
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ['1','1','0','0','0'],
//  ['1','1','0','0','0'],
//  ['0','0','1','0','0'],
//  ['0','0','0','1','1']
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 1078 👎 0


package com.mengfg.leetcode.editor.cn;

class Problem_200_NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new Problem_200_NumberOfIslands().new Solution();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(solution.numIslands(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            return process(grid);
        }

        public int process(char[][] grid) {
            int row = grid.length;
            int column = grid[0].length;
            int res = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        infection(grid, i, j);
                    }
                }
            }
            return res;
        }

        public void infection(char[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return;
            }

            if (grid[x][y] == '1') {
                setValue(grid, x, y, '2');
                infection(grid, x - 1, y);
                infection(grid, x + 1, y);
                infection(grid, x, y - 1);
                infection(grid, x, y + 1);
            }
        }

        public void setValue(char[][] grid, int x, int y, char value) {
            grid[x][y] = value;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}