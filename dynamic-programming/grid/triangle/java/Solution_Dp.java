import java.util.List;

class Solution_Dp {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                if (i == n - 1) {
                    dp[n - 1][j] = triangle.get(n - 1).get(j);
                    continue;
                }
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}