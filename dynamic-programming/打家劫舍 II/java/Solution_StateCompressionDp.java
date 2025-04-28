class Solution_StateCompressionDp {
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
        int prev = nums[start], current = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end + 1; i++) {
            int next = Math.max(nums[i] + prev, current);
            prev = current;
            current = next;
        }
        return current;
    }
}