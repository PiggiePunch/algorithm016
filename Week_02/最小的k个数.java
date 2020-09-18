
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 
 * 示例 1：
 * 
 * 输入：arr = [3,2,1], k = 2 输出：[1,2] 或者 [2,1] 示例 2：
 * 
 * 输入：arr = [0,1,2,1], k = 1 输出：[0]
 * 
 */
public class 最小的k个数 {

    /**
     * sort排序 时间复杂度O(NlogN)
     * 
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    /**
     * 通过小根堆PriorityQueue实现 时间复杂度O(NlogK)
     * 
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        // 默认是小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            // 从堆顶弹出
            ans[i] = heap.poll();
        }
        return ans;
    }

}
