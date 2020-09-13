
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5,6,7] 和 k = 3 输出: [5,6,7,1,2,3,4] 解释:
 * 
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 示例 2:
 * 
 * 输入: [-1,-100,3,99] 和 k = 2 输出: [3,99,-1,-100] 解释:
 * 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 
 * 向右旋转 2 步: [3,99,-1,-100]
 * 
 */
public class 旋转数组 {

    /**
     * 优秀做法，核心思想为先全部反转，随后分别平移的前半部分和后半部分反转变成正常顺序
     * 
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        // 先全部倒过来
        reverse(nums, 0, nums.length - 1);
        // 第二遍把移动到前半部分的倒过来变成了移动到前半部分的顺序
        reverse(nums, 0, k - 1);
        // 第三遍把后半部分倒过来变成了正常的移到后半部分的顺序
        reverse(nums, k, nums.length - 1);
    }

    // 核心，原地反转数组
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 和移动0一个套路，先保存前面的，随后原地移动后面的，最后补齐
     * 
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        // 先保存前面几个
        int index = k % nums.length;
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < nums.length - index; i++) {
            tmp.add(nums[i]);
        }
        // 和移动0类似先把后面的开始移动到前面
        int startIndex = 0;
        for (int i = nums.length - index; i < nums.length; i++) {
            nums[startIndex] = nums[i];
            startIndex++;
        }

        // 补齐后面的元素
        int tmpindex = 0;
        for (int i = index; i < nums.length; i++) {
            nums[i] = tmp.get(tmpindex);
            tmpindex++;
        }
    }

    /**
     * 递归做法
     * 
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        if (k == 0 || k == nums.length) {
            return;
        }
        int[] clonenums = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums[i] = clonenums[nums.length - 1];
            } else {
                nums[i] = clonenums[i - 1];
            }
        }
        rotate3(nums, k - 1);
    }

}
