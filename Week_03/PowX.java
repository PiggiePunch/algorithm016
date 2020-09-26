
public class PowX {

    /**
     * 传统迭代做法，时间复杂度O(n)
     * 
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        double ans = 1.0;
        for (int i = 0; i < b; i++) {
            ans = ans * x;
        }
        return ans;
    }

    /**
     * 递归做法，时间复杂度O(logN)
     * 
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        return fastPow(x, b);
    }

    private double fastPow(double x, long b) {
        // terminator
        if (b == 0) {
            return 1;
        }

        // process and drill down
        double half = fastPow(x, b / 2);
        // 此方数偶数的结果为两次half相乘，奇数为两次half*X
        return b % 2 == 0 ? half * half : x * half * half;
    }

}
