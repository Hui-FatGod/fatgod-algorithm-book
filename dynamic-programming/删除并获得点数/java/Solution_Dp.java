import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution_Dp {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> countTable = new HashMap<>();
        for (int num : nums) {
            countTable.merge(num, 1, Integer::sum);
        }
        Set<Integer> set = countTable.keySet();
        int n = set.size(), start = 0;
        int[] newNums = new int[n];
        for (Integer num : set) {
            newNums[start++] = num;
        }
        Arrays.sort(newNums);
        if (n == 1) {
            return newNums[0] * countTable.get(newNums[0]);
        }
        int[] dp = new int[n];
        dp[0] = newNums[0] * countTable.get(newNums[0]);
        for (int i = 1; i < n; i++) {
            int points = newNums[i] * countTable.get(newNums[i]);
            dp[i] = newNums[i] - newNums[i - 1] > 1 ? points + dp[i - 1]
                    : Math.max(points + (i < 2 ? 0 : dp[i - 2]), dp[i - 1]);
        }
        return dp[n - 1];
    }
}