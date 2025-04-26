import java.util.Arrays;

class Solution_Dfs {
    private final static int NOT_CALC = -1;

    public int rob(int[] nums) {
        int n = nums.length;
        int[] memory = new int[n];
        Arrays.fill(memory, -1);
        return dfs(n - 1, nums, memory);
    }

    private int dfs(int i, int[] nums, int[] memory) {
        if (i == 0) {
            return nums[0];
        }
        if (i == 1) {
            return Math.max(nums[0], nums[1]);
        }
        if (memory[i] != NOT_CALC) {
            return memory[i];
        }
        return memory[i] = Math.max(nums[i] + dfs(i - 2, nums, memory), dfs(i - 1, nums, memory));
    }
}