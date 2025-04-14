class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length, freeTime = 0;
        for (int i = 0; i < k + 1; i++) {
            freeTime += getFreeTime(i, eventTime, startTime, endTime);
        }
        int maxFreeTime = freeTime;
        for (int i = k + 1; i < n + 1; i++) {
            freeTime += getFreeTime(i, eventTime, startTime, endTime) -
                    getFreeTime(i - k - 1, eventTime, startTime, endTime);
            maxFreeTime = Math.max(maxFreeTime, freeTime);
        }
        return maxFreeTime;
    }

    private int getFreeTime(int index, int eventTime, int[] startTime, int[] endTime) {
        if (index == 0) {
            return startTime[0];
        }
        int n = startTime.length;
        if (index == n) {
            return eventTime - endTime[n - 1];
        }
        return startTime[index] - endTime[index - 1];
    }
}