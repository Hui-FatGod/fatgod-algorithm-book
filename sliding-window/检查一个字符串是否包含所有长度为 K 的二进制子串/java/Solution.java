import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int length = s.length();
        if (length - k + 1 < (1 << k)) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int value = 0;
        for (int i = 0; i < k; i++) {
            value += (s.charAt(i) - 48) << (k - i - 1);
        }
        set.add(value);
        for (int i = k; i < length; i++) {
            value -= (s.charAt(i - k) - 48) << (k - 1);
            value <<= 1;
            value += s.charAt(i) - 48;
            set.add(value);
        }
        return set.size() == 1 << k;
    }
}