import java.util.Arrays;

class Solution_Dfs {
    private final static int NOT_CALC = -1, MOD = (int) 1e9 + 7;

    public int goodBinaryStrings(int minLength, int maxLength, int oneGroup, int zeroGroup) {
        int[] memory = new int[maxLength + 1];
        Arrays.fill(memory, NOT_CALC);
        int goodBinaryStrCount = 0;
        for (int i = minLength; i < maxLength + 1; i++) {
            goodBinaryStrCount = (goodBinaryStrCount + dfs(i, oneGroup, zeroGroup, memory)) % MOD;
        }
        return goodBinaryStrCount;
    }

    private int dfs(int i, int oneGroup, int zeroGroup, int[] memory) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        if (memory[i] != NOT_CALC) {
            return memory[i];
        }
        return memory[i] = (dfs(i - zeroGroup, oneGroup, zeroGroup, memory) + dfs(i - oneGroup, oneGroup, zeroGroup, memory)) % MOD;
    }
}