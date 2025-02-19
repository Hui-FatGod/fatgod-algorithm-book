class Solution {
    public int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int divisor = 0;
        for (int i = 0; i < k; i++) {
            divisor += (int) (Math.pow(10, k - i - 1) * (numStr.charAt(i) - 48));
        }
        int cnt = divisor != 0 && num % divisor == 0 ? 1 : 0;
        for (int i = k; i < numStr.length(); i++) {
            divisor -= (int) (Math.pow(10, k - 1) * (numStr.charAt(i - k) - 48));
            divisor *= 10;
            divisor += numStr.charAt(i) - 48;
            cnt += divisor != 0 && num % divisor == 0 ? 1 : 0;
        }
        return cnt;
    }
}