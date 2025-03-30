import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int length = 0, groups = nums.size();
        for (List<Integer> numList : nums) {
            length += numList.size();
        }
        int[][] paris = new int[length][2];
        int start = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                paris[start][0] = num;
                paris[start++][1] = i;
            }
        }
        Arrays.sort(paris, Comparator.comparingInt(arr -> arr[0]));
        int[] countTable = new int[groups];
        int leftBoundary = paris[0][0], rightBoundary = paris[length - 1][0] + 1;
        for (int left = 0, right = 0; right < length; right++) {
            groups -= ++countTable[paris[right][1]] == 1 ? 1 : 0;
            while (groups == 0) {
                if (paris[right][0] - paris[left][0] < rightBoundary - leftBoundary) {
                    leftBoundary = paris[left][0];
                    rightBoundary = paris[right][0];
                }
                groups += --countTable[paris[left++][1]] == 0 ? 1 : 0;
            }
        }
        return new int[]{leftBoundary, rightBoundary};
    }
}