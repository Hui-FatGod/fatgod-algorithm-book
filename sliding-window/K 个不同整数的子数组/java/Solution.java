class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return (int) (getSubs(nums, k) - getSubs(nums, k + 1));
    }

    private long getSubs(int[] nums, int ge) {
        int n = nums.length;
        int[] countTable = new int[n + 1];
        long subs = 0, types = 0;
        for (int left = 0, right = 0; right < n; right++) {
            types += ++countTable[nums[right]] == 1 ? 1 : 0;
            while (types >= ge) {
                subs += n - right;
                types -= --countTable[nums[left++]] == 0 ? 1 : 0;
            }
        }
        return subs;
    }
}