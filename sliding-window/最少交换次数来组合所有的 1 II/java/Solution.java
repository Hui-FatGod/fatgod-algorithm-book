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
        int zeros = 0;
        for (int i = 0; i < k; i++) {
            zeros += nums[i] ^ 1;
        }
        int minZeros = zeros;
        for (int i = k; i < n + k - 1; i++) {
            zeros += (nums[i % n] ^ 1) - (nums[(i - k) % n] ^ 1);
            minZeros = Math.min(minZeros, zeros);
        }
        return minZeros;
    }
}