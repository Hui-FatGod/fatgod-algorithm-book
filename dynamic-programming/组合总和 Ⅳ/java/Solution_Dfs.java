import java.util.Arrays;

class Solution_Dfs {
    private final static int NOT_CALC = -1;

    public int combinationSum4(int[] nums, int target) {
        int[] memory = new int[target + 1];
        Arrays.fill(memory, NOT_CALC);
        return dfs(target, nums, memory);
    }

    private int dfs(int i, int[] nums, int[] memory) {
        if (i == 0) {
            return 1;
        }
        if (memory[i] != NOT_CALC) {
            return memory[i];
        }
        int combinations = 0;
        for (int num : nums) {
            if (i < num) {
                continue;
            }
            combinations += dfs(i - num, nums, memory);
        }
        return memory[i] = combinations;
    }
}