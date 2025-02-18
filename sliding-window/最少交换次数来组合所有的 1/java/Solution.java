class Solution {
    public int minSwaps(int[] data) {
        int k = 0;
        for (int item : data) {
            k += item;
        }
        int n = data.length;
        if (k <= 1 || k == n) {
            return 0;
        }
        int swaps = 0;
        for (int i = 0; i < k; i++) {
            swaps += data[i] ^ 1;
        }
        int minSwaps = swaps;
        for (int i = k; i < n; i++) {
            swaps += (data[i] ^ 1) - (data[i - k] ^ 1);
            minSwaps = Math.min(minSwaps, swaps);
        }
        return minSwaps;
    }
}