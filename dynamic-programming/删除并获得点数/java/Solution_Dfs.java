import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

class Solution_Dfs {
    private final static int NOT_CALC = -1;

    public int deleteAndEarn(int[] nums) {
        final Map<Integer, Integer> countTable = new HashMap<>();
        for (int num : nums) {
            countTable.merge(num, 1, Integer::sum);
        }
        Set<Integer> set = countTable.keySet();
        int n = set.size(), start = 0;
        final int[] newNums = new int[n], memory = new int[n];
        for (Integer num : set) {
            newNums[start++] = num;
        }
        Arrays.sort(newNums);
        Arrays.fill(memory, NOT_CALC);
        Function<Integer, Integer> dfs = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                if (i < 0) {
                    return 0;
                }
                if (i == 0) {
                    return newNums[0] * countTable.get(newNums[0]);
                }
                if (memory[i] != NOT_CALC) {
                    return memory[i];
                }
                int points = newNums[i] * countTable.get(newNums[i]);
                return memory[i] = newNums[i] - newNums[i - 1] > 1 ? points + this.apply(i - 1)
                        : Math.max(points + this.apply(i - 2), this.apply(i - 1));
            }
        };
        return dfs.apply(n - 1);
    }
}