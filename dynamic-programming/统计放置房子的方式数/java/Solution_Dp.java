class Solution_Dp {
    private final static int MOD = (int) 1e9 + 7;

    public int countHousePlacements(int n) {
        if (n == 1) {
            return 2 * 2;
        }
        if (n == 2) {
            return 3 * 3;
        }
        int[] dp = new int[n + 1];
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        long count = dp[n];
        return (int) (count * count % MOD);
    }
}