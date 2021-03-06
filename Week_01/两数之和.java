
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * 
 */
public class 两数之和 {

    /**
     * 利用hash表实现
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // key作为数组中的元素，value作为index的位置
            map.put(nums[i], i);
        }

        // 开始遍历，直到最终值减去遍历值再hash表中就返回
        for (int i = 0; i < nums.length; i++) {
            // 存在且不是自己
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[] { i, map.get(target - nums[i]) };
            }
        }
        return new int[0];
    }

    /**
     * 穷举解法
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[0];
    }
}
