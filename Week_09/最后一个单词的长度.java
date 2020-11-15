
/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * 
 * 示例:
 * 
 * 输入: "Hello World" 输出: 5
 *
 */
public class 最后一个单词的长度 {

    /**
     * 思路：预处理后找到最后一个出现空格的位置相减即是最后一个单词的长度
     * 
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }

    /**
     * 普通思路：找到最后一个单词后计算单词长度
     * 
     * @param s
     * @return
     */
    public int lengthOfLastWord1(String s) {
        String[] str = s.split(" ");
        if (str.length == 0) {
            return 0;
        }
        return str[str.length - 1].length();
    }
}
