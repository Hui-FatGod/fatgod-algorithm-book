class Solution_Dp {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            int nextIndex = i + questions[i][1] + 1;
            dp[i] = Math.max(questions[i][0] + (nextIndex >= n ? 0 : dp[nextIndex]), dp[i + 1]);
        }
        return dp[0];
    }
}