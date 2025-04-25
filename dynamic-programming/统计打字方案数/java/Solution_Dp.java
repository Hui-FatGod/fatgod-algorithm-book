import java.util.ArrayList;
import java.util.List;

class Solution_Dp {
    private final static int MOD = (int) 1e9 + 7;
    private final static int[] KEY_LETTERS = { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 };

    public int countTexts(String pressedKeys) {
        char[] chars = pressedKeys.toCharArray();
        List<int[]> tuples = new ArrayList<>();
        int count = 0, maxCount = 0;
        for (int i = 0; i < chars.length; i++) {
            count++;
            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                tuples.add(new int[] { count, KEY_LETTERS[chars[i] - '0'] });
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        int[] dp3 = new int[maxCount + 1], dp4 = new int[maxCount + 1];
        long texts = 1;
        for (int[] tuple : tuples) {
            texts = texts * (tuple[1] == 3 ? getDp(3, dp3) : getDp(4, dp4))[tuple[0]] % MOD;
        }
        return (int) texts;
    }

    private int[] getDp(int letters, int[] dp) {
        if (dp[0] == 1) {
            return dp;
        }
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < letters + 1; j++) {
                if (i < j) {
                    continue;
                }
                dp[i] = (dp[i] + dp[i - j]) % MOD;
            }
        }
        return dp;
    }
}