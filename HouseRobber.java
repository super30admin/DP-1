// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(1) as we are using only two variables
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// As discussed in class, Greedy or selective approach will not work here, 
// as we might end up with a local optimal solution.
// We have to go with exhaustive approach, 
// where we will try all the combinations of houses to make up the amount.
// But it will lead to exponential time complexity,
//  so we will use dynamic programming to optimize it.
// The input variable is nums, which is changing, so we will create a dp array of size n 
// where n is the number of houses.
// For every house, if we choose to rob it,
//  we will take the value of that house and add it to the value of the house two steps
//  back, as we cannot rob adjacent houses.
//  If we choose not to rob it, we will take the value from the previous house.
// Lastly, we will return the value at the last index of the dp array, which will give us the maximum amount we can rob.


public class HouseRobber {
    class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) return nums[0];

        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];
    }
}
}
