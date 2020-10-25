
/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 */
public class 不同路径II {

    /**
     * 动态规划解法，初始化dp空间和更新状态转移的时候多了障碍物的判断
     * 
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 初始化dp状态空间
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        // 更最最后一行
        for (int i = obstacleGrid[0].length - 1; i >= 0; i--) {
            if (obstacleGrid[obstacleGrid.length - 1][i] == 1) {
                dp[obstacleGrid.length - 1][i] = 0;
                // 遇到障碍标识为0，跳出循环，障碍左边的都不能到达
                break;
            } else {
                dp[obstacleGrid.length - 1][i] = 1;
            }
        }

        // 更新最后一列
        for (int i = obstacleGrid.length - 1; i >= 0; i--) {
            if (obstacleGrid[i][obstacleGrid[0].length - 1] == 1) {
                dp[i][obstacleGrid[0].length - 1] = 0;
                // 遇到障碍标识为0，跳出循环，障碍上边的都不能到达
                break;
            } else {
                dp[i][obstacleGrid[0].length - 1] = 1;
            }
        }

        // 状态转移
        for (int i = obstacleGrid.length - 2; i >= 0; i--) {
            for (int j = obstacleGrid[0].length - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}
