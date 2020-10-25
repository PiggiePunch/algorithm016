
/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 问总共有多少条不同的路径？
 *
 */
public class 不同路径 {

    /**
     * 动态规划解法
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 更新最后一行和最后一列的到达终点的路径数
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }

        // 找状态转移方程
        // 依次更新每个矩阵到终点的路径数为下和右的路径数字和
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}
