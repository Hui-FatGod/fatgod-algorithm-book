class Solution {
    public long countSubarrays(int[] nums, long k) {
        long subs = 0, sum = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left++];
            }
            subs += right - left + 1;
        }
        return subs;
    }
}