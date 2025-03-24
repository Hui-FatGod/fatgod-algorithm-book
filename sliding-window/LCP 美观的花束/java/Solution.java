import java.util.HashMap;
import java.util.Map;

class Solution {
    public int beautifulBouquet(int[] flowers, int cnt) {
        Map<Integer, Integer> countTable = new HashMap();
        int subs = 0;
        for (int left = 0, right = 0; right < flowers.length; right++) {
            countTable.merge(flowers[right], 1, Integer::sum);
            while (countTable.get(flowers[right]) > cnt) {
                countTable.merge(flowers[left++], -1, Integer::sum);
            }
            subs += right - left + 1;
        }
        return subs;
    }
}