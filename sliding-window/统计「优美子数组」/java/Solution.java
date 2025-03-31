class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int gtOddCount = 0, geOddCount = 0;
        int gtSubs = 0, geSubs = 0;
        for (int gtLeft = 0, geLeft = 0, right = 0; right < n; right++) {
            gtOddCount += nums[right] & 1;
            while (gtOddCount > k) {
                gtSubs += n - right;
                gtOddCount -= nums[gtLeft++] & 1;
            }
            geOddCount += nums[right] & 1;
            while (geOddCount >= k) {
                geSubs += n - right;
                geOddCount -= nums[geLeft++] & 1;
            }
        }
        return geSubs - gtSubs;
    }
}