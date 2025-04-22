class Solution_Dp {
    private final static int MOD = (int) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int goodStrCount = 0;
        for (int i = 1; i < high + 1; i++) {
            dp[i] = ((i >= zero ? dp[i - zero] : 0) + (i >= one ? dp[i - one] : 0)) % MOD;
            goodStrCount = (goodStrCount + (i >= low ? dp[i] : 0)) % MOD;
        }
        return goodStrCount;
    }
}