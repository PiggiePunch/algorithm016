
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * 请你找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 
 * 示例：
 * 
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 *
 * 
 */
public class 三数之和 {
    /**
     * 暴力迭代，三层 时间复杂度O(n^3)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 结果集去重
        Set<List<Integer>> result = new HashSet<>();
        // 第一层作为结果，找是否存在23层的和为第一层的负值
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] == -(nums[j] + nums[k])) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        // 对结果排序后存入set去重
                        list.sort((o1, o2) -> o1 - o2);
                        result.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 排序后从第一个开始，随后两边夹逼往里走
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                List<Integer> list = new ArrayList<>();
                if (-nums[i] == nums[j] + nums[k]) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    Collections.sort(list);
                    result.add(list);
                    j++;
                    k--;
                } else if (-nums[i] > nums[j] + nums[k]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
