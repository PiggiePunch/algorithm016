package medium;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个位置。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,1,1,4] 输出: true 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3
 * 步到达最后一个位置。
 * 
 */
public class 跳跃游戏 {

    /**
     * 思路：从后往前贪心，如果一个位置能够到达，那么这个位置左侧所有位置都能到达。
     * 
     * 更新最后能到达的下标，全部遍历完以后看下标是否归零
     * 
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int endReachIndex = nums.length - 1;
        // 从倒数第二个开始往前贪心
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= endReachIndex) {
                // 可达，更新下标
                endReachIndex = i;
            }
        }
        return endReachIndex == 0;
    }
}
