
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],  
 * [1,2],   [] ]
 *
 */
public class 子集 {
    /**
     * 全量子集 [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> alllist = new ArrayList<List<Integer>>();
        alllist.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = alllist.size();
            for (int i = 0; i < size; i++) {
                List<Integer> tmp = new ArrayList<Integer>(alllist.get(i));
                tmp.add(n);
                alllist.add(tmp);
            }
        }
        return alllist;
    }
}
