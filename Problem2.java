// Time Complexity : O(n)
// Space Complexity : O(1)
    // n is the length of the given array

// Your code here along with comments explaining your approach
    //While traversing the houses, we maintain 2 integer variables, one for the most earned with the last house robbed, another for the most earned with either last house robbed or current house robbed.
    //When we arrive at a house, we check which is better, the earnings earned when "last house" was robbed, or the earnings earned when "previous of last house" and "current house" are robbed.
    //We keep storing the better value at all the houses. After traversing through all the house we end up with most earnings.

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1)
        {
            return nums[0];
        }
        int lastHouseRobbed = nums[0];
        int bestOfBoth = Math.max(nums[0], nums[1]);
        for (int i=2; i<n; i++)
        {
            int currentBest = bestOfBoth;
            bestOfBoth = Math.max(bestOfBoth, lastHouseRobbed+nums[i]);
            lastHouseRobbed = currentBest;
        }
        return bestOfBoth;
    }
}