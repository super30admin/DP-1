// Time Complexity: O(n) where n is number of houses.
// Space Complexity: O(n+2) = O(n), we have taken an auxilliary array of length n+2 to store updated max robbed values
// Did you complete it at leetcode: Yes
// Any problems faced: Tried using single array with incorrect indexed caused array out of bound index, couldn't figure out how to handle them, with this approach it worked.

// Write your approach here:
// Idea is to use the solved subproblems at the end of the array and calculate the maximum amount robbed till the 0th index is reached
// To perform that we have taken an additional array holding 2 more values than existing house array with 0 values.
// the last house can only have 1 maximum loot, now we compare with each house if the new house and alternate house we calculated sum up to more loot than the previous house's calculated loot, and update the maximum loot till now in the array.
// As we update each element in array with the maximum loot till now, 1st house depicts what could be the maximum loot robber can gain in different decisions.

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+2];
        for(int i=nums.length-1; i>=0; i--) {
            dp[i] = Math.max(dp[i+2]+ nums[i], dp[i+1]);
        }
        return dp[0];
    }
}