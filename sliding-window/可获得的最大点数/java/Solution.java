public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, n = cardPoints.length;
        for (int i = n - k; i < n; i++) {
            sum += cardPoints[i];
        }
        int maxSum = sum;
        for (int i = n; i < n + k; i++) {
            sum += cardPoints[i % n] - cardPoints[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
