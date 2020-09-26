
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1. 1 阶 + 1 阶 2. 2 阶 示例 2：
 *
 * 输入： 3 输出： 3 解释： 有三种方法可以爬到楼顶。 1. 1 阶 + 1 阶 + 1 阶 2. 1 阶 + 2 阶 3. 2 阶 + 1 阶
 *
 *
 */
class 爬楼梯 {

    private Map<Integer, Integer> tmp = new HashMap<>();

    /**
     * 传统傻递归方法，会超时
     */
    public int climbStairs1(int n) {
        if (n <= 2) {
            return n;
        } else {
            return climbStairs1(n - 1) + climbStairs1(n - 2);
        }
    }

    /**
     * 带一个保存中间值的递归方法，减少递归深度
     */
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        } else {
            if (!tmp.containsKey(n - 1)) {
                tmp.put(n - 1, climbStairs1(n - 1));
            }
            if (!tmp.containsKey(n - 2)) {
                tmp.put(n - 2, climbStairs1(n - 2));
            }
            return tmp.get(n - 1) + tmp.get(n - 2);
        }
    }

    /**
     * 动态规划方式
     */
    public int climbStairs3(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
