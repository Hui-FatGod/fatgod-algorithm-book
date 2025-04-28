class Solution_Dp {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(sequenceRob(nums, 0, n - 2), sequenceRob(nums, 1, n - 1));
    }

    private int sequenceRob(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n == 1) {
            return nums[start];
        }
        if (n == 2) {
            return Math.max(nums[start], nums[start + 1]);
        }
        int[] dp = new int[end + 1];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end + 1; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[end];
    }
}