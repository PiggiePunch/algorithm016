package medium;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入: [ ['1','1','1','1','0'], ['1','1','0','1','0'], ['1','1','0','0','0'],
 * ['0','0','0','0','0'] ] 输出: 1
 * 
 */
public class 岛屿数量 {

    private int width;
    private int height;

    /**
     * 思路：遍历二维数组，遇到陆地统计一次，随后利用DFS清理这个陆地连接的所有陆地
     * 
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        width = grid[0].length;
        height = grid.length;

        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // 遇到陆地记录一个岛屿
                if (grid[i][j] == '1') {
                    count++;
                    // 清理这个陆地连接的所有陆地
                    dfsMarker(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfsMarker(char[][] grid, int i, int j) {
        // terminator
        if (i < 0 || j < 0 || i >= height || j >= width || grid[i][j] != '1') {
            return;
        }
        // process
        grid[i][j] = '0';
        // drill down
        dfsMarker(grid, i + 1, j);
        dfsMarker(grid, i - 1, j);
        dfsMarker(grid, i, j + 1);
        dfsMarker(grid, i, j - 1);
    }
}
