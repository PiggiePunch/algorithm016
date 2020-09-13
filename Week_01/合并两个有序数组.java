
import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存
 * nums2 中的元素。
 *
 */
public class 合并两个有序数组 {
    /**
     * 偷懒办法，先把nums2放入nums1后让系统类库帮你排个序，主要是熟练System.arraycopy的用法
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1足够大，所以直接可以把nums2从0开始拷贝n个到nums1的m下表后
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);

    }
}
