
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 每次转换只能改变一个字母。 转换过程中的中间单词必须是字典中的单词。 说明:
 * 
 * 如果不存在这样的转换序列，返回 0。 所有单词具有相同的长度。 所有单词只由小写字母组成。 字典中不存在重复的单词。 你可以假设 beginWord 和
 * endWord 是非空的，且二者不相同。 示例 1:
 * 
 * 输入: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 
 */
public class 单词接龙 {

    /**
     * 思路：BFS记录每次可以转换的单词，直到endword和入队中的单词一样则跳出循环，返回层序遍历的深度
     * 
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (queue.size() != 0) {
            List<String> tmp = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String word = queue.poll();
                tmp.add(word);
                if (word.equals(endWord))
                    return ans.size() + 1;
                for (int j = 0; j < wordList.size(); j++) {
                    if (isChangeOneWordTouch(word, wordList.get(j)) && !visited.contains(wordList.get(j))) {
                        queue.add(wordList.get(j));
                        visited.add(wordList.get(j));
                    }
                }
            }
            ans.add(tmp);
        }
        return 0;
    }

    private boolean isChangeOneWordTouch(String one, String two) {
        if (one.length() != two.length())
            return false;
        int count = 0;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) != two.charAt(i))
                count++;
            if (count > 1)
                return false;
        }
        return count == 1;
    }
}
