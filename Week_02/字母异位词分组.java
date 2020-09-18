
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"] 输出: [ ["ate","eat","tea"],
 * ["nat","tan"], ["bat"] ]
 * 
 *
 */
public class 字母异位词分组 {
    /**
     * 思路：利用哈希表记录排序完的值，遍历的时候直接去查对应的key值放入value即可
     * 
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 一张维护排序后单词的表，value保存异位词分组
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            // 对单词进行排序后存入哈希表，找到相应的key存入单词
            Arrays.sort(chars);
            if (map.containsKey(new String(chars))) {
                map.get(new String(chars)).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(new String(chars), list);
            }
        }
        return new ArrayList<>(map.values());
    }

}
