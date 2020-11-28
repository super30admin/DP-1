// Time Complexity - O(N)
// Space Complexity - O(1)


class Solution {
    public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int skip = 0;
    int take = 0;
    for (int num : nums) {
        int tmp = Math.max(skip, take);
        take = num + skip;
        skip = tmp;
    }
    return Math.max(skip, take);
    }
}
