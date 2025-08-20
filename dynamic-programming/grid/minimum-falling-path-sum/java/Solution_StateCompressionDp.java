class Solution_StateCompressionDp {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix[0].length;
        int[] current = new int[n + 2];
        current[0] = current[n + 1] = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            int prev = current[0];
            for (int j = 0; j < n; j++) {
                int temp = prev;
                prev = current[j + 1];
                current[j + 1] = Math.min(Math.min(temp, current[j + 1]), current[j + 2]) + row[j];
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            minSum = Math.min(minSum, current[i]);
        }
        return minSum;
    }
}