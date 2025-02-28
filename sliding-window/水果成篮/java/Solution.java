import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFruits = 0;
        for (int left = 0, right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                int cnt = map.get(fruits[left]);
                if (cnt <= 1) {
                    map.remove(fruits[left++]);
                } else {
                    map.put(fruits[left++], cnt - 1);
                }
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }
}