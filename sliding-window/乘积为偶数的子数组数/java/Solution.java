class Solution {
    public long evenProduct(int[] nums) {
        int n = nums.length;
        long subs = 0;
        for (int left = 0, right = 0; right < n; right++) {
            if (nums[right] % 2 == 0) {
                subs += (long) (n - right) * (right - left + 1);
                left = right + 1;
            }
        }
        return subs;
    }
}