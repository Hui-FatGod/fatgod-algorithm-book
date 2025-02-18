class Solution {
    public int minSwaps(int[] nums) {
        int k = 0;
        for (int num : nums) {
            k += num;
        }
        int n = nums.length;
        if (k <= 1 || k == n) {
            return 0;
        }
        int swaps = 0;
        for (int i = 0; i < k; i++) {
            swaps += nums[i] ^ 1;
        }
        int minSwaps = swaps;
        for (int i = k; i < n + k - 1; i++) {
            swaps += (nums[i % n] ^ 1) - (nums[(i - k) % n] ^ 1);
            minSwaps = Math.min(minSwaps, swaps);
        }
        return minSwaps;
    }
}