
/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde"
 * 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * 
 * 若这两个字符串没有公共子序列，则返回 0。
 * 
 * 示例 1:
 * 
 * 输入：text1 = "abcde", text2 = "ace" 输出：3 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 
 */
public class 最长公共子序列 {

    /**
     * 思路：动态规划
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // 初始化dp二维数组分别以text1和text2作为列和行
        int height = text2.length() + 1;
        int width = text1.length() + 1;
        int[][] dp = new int[height][width];

        // 比较行和列的单词如果字母相等那目前临时单词的最长子序列为左斜角的数字+1
        // 如果两个字母不想等，那目前临时单词的最长子序列为行-1或列-1的最大值
        // 依次往复，以后一行最后一列就是两个字符串的最长子序列
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (text1.charAt(j - 1) == text2.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[height - 1][width - 1];
    }
}
