
import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram" 输出: true 示例 2:
 * 
 * 输入: s = "rat", t = "car" 输出: false
 * 
 */
public class 有效的字母异位词 {
    /**
     * 简单暴力直接做法，对两个字符串做排序后比较是否相等
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        // 拆成数组->排序->比较数组是否相等
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    /**
     * 记录每个字母出现的频次，最后check表中出现的字母是否都清零
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        // 用一个26个字母的数组下标记录每个字母出现的频率
        int[] alphacount = new int[26];
        // 一个累加，一个减，最后如果不为零就代表不是异位词
        for (int i = 0; i < s.length(); i++) {
            alphacount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphacount[t.charAt(i) - 'a']--;
        }

        for (int num : alphacount) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

}
