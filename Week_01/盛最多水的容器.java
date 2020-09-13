
/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线
 * i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 示例：
 * 
 * 输入：[1,8,6,2,5,4,8,3,7] 输出：49
 */
public class 盛最多水的容器 {
    /**
     * 最直接方法，嵌套循环遍历方法算出所有可能的面积，时间复杂度O(n^2)
     * 
     * @param height
     * @return 最大面积
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int area = minHeight * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    /**
     * 两边夹逼，遇到比右边小的就继续往里面走，否则右边开始往里走直到相遇，时间复杂度O(n)
     * 
     * @param height
     * @return 最大面积
     */
    public int maxArea2(int[] height) {
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            // 高度取值为左右最小的那个，随后小的那个指针继续往里移动
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = minHeight * (j - i + 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
