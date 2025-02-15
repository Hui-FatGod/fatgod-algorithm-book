class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += calories[i];
        }
        int perf = sum < lower ? -1 : (sum > upper ? 1 : 0);
        for (int i = k; i < calories.length; i++) {
            sum += calories[i] - calories[i - k];
            perf += sum < lower ? -1 : (sum > upper ? 1 : 0);
        }
        return perf;
    }
}