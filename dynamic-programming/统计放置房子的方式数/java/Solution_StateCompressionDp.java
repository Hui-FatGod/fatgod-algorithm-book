class Solution_StateCompressionDp {
    private final static int MOD = (int) 1e9 + 7;

    public int countHousePlacements(int n) {
        if (n == 1) {
            return 2 * 2;
        }
        if (n == 2) {
            return 3 * 3;
        }
        int prev = 2, current = 3;
        for (int i = 3; i < n + 1; i++) {
            int next = (prev + current) % MOD;
            prev = current;
            current = next;
        }
        long count = current;
        return (int) (count * count % MOD);
    }
}