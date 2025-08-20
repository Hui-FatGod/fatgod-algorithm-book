class Solution_Dp {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n + 2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (j == 0 || j == n + 1) {
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                if (i == 0) {
                    dp[0][j] = matrix[i][j - 1];
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]) + matrix[i][j - 1];
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            minSum = Math.min(minSum, dp[m - 1][i]);
        }
        return minSum;
    }
}