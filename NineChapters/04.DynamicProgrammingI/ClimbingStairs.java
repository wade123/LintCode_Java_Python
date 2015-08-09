public class ClimbingStairs {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        if (n <= 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        while (n > 1) {
            c = a + b;
            a = b;
            b = c;
            n--;
        }
        return c;
    }

    public static void main(String[] args) {
        ClimbingStairs test = new ClimbingStairs();
        int n = 20;
        System.out.println(test.climbStairs(n));
        System.out.println(test.climbStairs2(n));
    }
}