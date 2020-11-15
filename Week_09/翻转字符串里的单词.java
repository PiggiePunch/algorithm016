
import java.util.Arrays;
import java.util.Collections;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 
 * 说明：
 * 
 * 无空格字符构成一个 单词 。 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。  
 * 
 * 示例 1：
 * 
 * 输入："the sky is blue" 输出："blue is sky the"
 * 
 */
public class 翻转字符串里的单词 {

    /**
     * 思路：利用java特性翻转，连接
     * 
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    /**
     * 手动翻转
     * 
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        String[] res = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = res.length - 1; i > 0; i--) {
            sb.append(res[i]).append(" ");
        }
        return sb.append(res[0]).toString();
    }

}
