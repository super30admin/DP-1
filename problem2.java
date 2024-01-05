// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// the alogrithm iterates backward through nums array and calculate max amount that can be robbed
// calculates the maximum amount that can be robbed without adjacent houses using
// an iterative bottom-up approach
class problem2 {

    public int rob(int[] nums) {

        int N = nums.length;

        if (N == 0) {
            return 0;
        }

        int[] maxRobbedAmount = new int[nums.length + 1];

        maxRobbedAmount[N] = 0;
        maxRobbedAmount[N - 1] = nums[N - 1];

        for (int i = N - 2; i >= 0; --i) {

            maxRobbedAmount[i] = Math.max(maxRobbedAmount[i + 1], maxRobbedAmount[i + 2] + nums[i]);
        }

        return maxRobbedAmount[0];
    }
}