import java.util.HashMap;
import java.util.Map;

class Solution {
    public int shareCandies(int[] candies, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int candy : candies) {
            map.put(candy, map.getOrDefault(candy, 0) + 1);
        }
        if (k == 0) {
            return map.size();
        }
        for (int i = 0; i < k; i++) {
            int cnt = map.get(candies[i]);
            if (cnt <= 1) {
                map.remove(candies[i]);
            } else {
                map.put(candies[i], cnt - 1);
            }
        }
        int maxType = map.size();
        for (int i = k; i < candies.length; i++) {
            int cnt = map.get(candies[i]);
            if (cnt <= 1) {
                map.remove(candies[i]);
            } else {
                map.put(candies[i], cnt - 1);
            }
            map.put(candies[i - k], map.getOrDefault(candies[i - k], 0) + 1);
            maxType = Math.max(maxType, map.size());
        }
        return maxType;
    }
}