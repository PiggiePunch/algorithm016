package medium;

import java.util.Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 请找出其中最小的元素。
 * 
 * 你可以假设数组中不存在重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,4,5,1,2] 输出: 1
 * 
 *
 */
public class 寻找旋转排序数组中的最小值 {

    /**
     * 两年前的我原来这么优秀。。。。
     * 
     * @param nums
     * @return
     */
    public int findMin3(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    /**
     * 遍历解法，这种写法竟然也可以击败了100.00%的用户
     * 
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }

    /**
     * 二分解法
     * 
     * @param num
     * @return
     */
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }

}
