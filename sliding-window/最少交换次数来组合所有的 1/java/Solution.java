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
        int zeros = 0;
        for (int i = 0; i < k; i++) {
            zeros += data[i] ^ 1;
        }
        int minZeros = zeros;
        for (int i = k; i < n; i++) {
            zeros += (data[i] ^ 1) - (data[i - k] ^ 1);
            minZeros = Math.min(minZeros, zeros);
        }
        return minZeros;
    }
}