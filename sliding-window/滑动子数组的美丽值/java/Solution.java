class Solution {
    private final static int BIAS = 50;

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] counts = new int[BIAS * 2 + 1];
        for (int i = 0; i < k; i++) {
            counts[BIAS + nums[i]]++;
        }
        int[] beauties = new int[n - k + 1];
        int index = 0;
        beauties[index++] = getBeauty(counts, x);
        for (int i = k; i < n; i++) {
            counts[BIAS + nums[i]]++;
            counts[BIAS + nums[i - k]]--;
            beauties[index++] = getBeauty(counts, x);
        }
        return beauties;
    }

    private int getBeauty(int[] counts, int x) {
        for (int i = 0; i < BIAS; i++) {
            x -= counts[i];
            if (x <= 0) {
                return -BIAS + i;
            }
        }
        return 0;
    }
}