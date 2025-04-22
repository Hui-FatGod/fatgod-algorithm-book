class Solution_Dp {
    private final static int MOD = (int) 1e9 + 7;

    public int goodBinaryStrings(int minLength, int maxLength, int oneGroup, int zeroGroup) {
        int[] dp = new int[maxLength + 1];
        dp[0] = 1;
        int goodBinaryStrCount = 0;
        for (int i = 1; i < maxLength + 1; i++) {
            dp[i] = ((i >= oneGroup ? dp[i - oneGroup] : 0) + (i >= zeroGroup ? dp[i - zeroGroup] : 0)) % MOD;
            goodBinaryStrCount = (goodBinaryStrCount + (i >= minLength ? dp[i] : 0)) % MOD;
        }
        return goodBinaryStrCount;
    }
}