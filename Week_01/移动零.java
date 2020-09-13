
/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12] 输出: [1,3,12,0,0]
 * 
 */
public class 移动零 {

    public void moveZeroes(int[] nums) {
        // 不创建新的数组情况下重新赋值
        int newIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[newIndex] = nums[i];
                newIndex++;
            }
        }
        // 末尾补0
        for (int j = newIndex; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

}
