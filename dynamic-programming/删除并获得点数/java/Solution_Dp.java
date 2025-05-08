import java.util.Set;
import java.util.TreeMap;

class Solution_Dp {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> countTable = new TreeMap<>();
        for (int num : nums) {
            countTable.merge(num, 1, Integer::sum);
        }
        Set<Integer> set = countTable.keySet();
        int start = 0, n = set.size();
        int[] numArr = new int[n];
        for (int num : set) {
            numArr[start++] = num;
        }
        if (n == 1) {
            return numArr[0] * countTable.get(numArr[0]);
        }
        int[] dp = new int[n];
        dp[0] = numArr[0] * countTable.get(numArr[0]);
        for (int i = 1; i < n; i++) {
            int points = numArr[i] * countTable.get(numArr[i]);
            dp[i] = numArr[i] - numArr[i - 1] > 1 ? points + dp[i - 1] :
                    Math.max(points + (i - 2 < 0 ? 0 : dp[i - 2]), dp[i - 1]);
        }
        return dp[n - 1];
    }
}