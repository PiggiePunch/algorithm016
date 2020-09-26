
import java.util.ArrayList;
import java.util.List;


/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 示例： 输入：n = 3 输出：[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 */
public class 括号生成 {

    // 实例变量保存结果集
    private List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, "");
        return list;
    }

    /**
     * 递归的方法拼接有效的括号
     * 
     * @param i
     * @param j
     * @param n
     * @param str
     */
    private void backtrack(int left, int right, int n, String str) {
        // 退出条件，括号用完后推出递归
        if (left == n && right == n) {
            list.add(str);
            return;
        }

        // 拼接有效括号并且下探，直到左右括号用完
        if (left < n) {
            backtrack(left + 1, right, n, str + "(");
        }

        if (left > right) {
            backtrack(left, right + 1, n, str + ")");
        }
    }
}
