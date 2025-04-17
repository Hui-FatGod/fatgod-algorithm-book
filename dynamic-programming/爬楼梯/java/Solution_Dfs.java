class Solution_Dfs {
    private final static int NOT_CALC = -1;

    public int climbStairs(int n) {
        int[] memory = new int[n + 1];
        Arrays.fill(memory, NOT_CALC);
        return dfs(n, memory);
    }

    private int dfs(int i, int[] memory) {
        if (i <= 2) {
            return i;
        }
        if (memory[i] != NOT_CALC) {
            return memory[i];
        }
        return memory[i] = dfs(i - 1, memory) + dfs(i - 2, memory);
    }
}