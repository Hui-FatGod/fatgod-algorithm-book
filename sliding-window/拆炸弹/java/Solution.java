class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length, absK = Math.abs(k);
        int[] pwd = new int[n];
        if (k == 0) {
            return pwd;
        }
        boolean forward = k > 0;
        int start = forward ? 1 : n - absK;
        int sum = 0, index = 0;
        for (int i = start; i < start + absK; i++) {
            sum += code[i];
        }
        pwd[index++] = sum;
        int end = forward ? n + absK : 2 * n - 1;
        for (int i = start + absK; i < end; i++) {
            sum += code[i % n] - code[(i - absK) % n];
            pwd[index++] = sum;
        }
        return pwd;
    }
}

