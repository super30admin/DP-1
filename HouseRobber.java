// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

//Use a bottom-up approach (tabulation). 
//If we rob house i, we can add house[i-2] or choose not to rob house i an add house[i-1]
// Maintain a dp[] array to store maximum money
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];//Only one house exists
        int[] dp = new int[nums.length];
        dp[0] = nums[0];//Max amount till first house
        dp[1] = Math.max(nums[0], nums[1]);//If two houses, rob the house with max amount
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);//choose or not choose a house
        }
        return dp[nums.length-1];
    }
}

// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

//Use two pointers: previous and current
//Previous represents dp[i-2] and current represents dp[i-1]


class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];//Only one house exists
        int previous = nums[0];//Max amount till first house
        int current = Math.max(nums[0], nums[1]);//If two houses, rob the house with max amount
        for(int i=2; i<nums.length; i++){
            int temp = current;
            current = Math.max(temp, nums[i]+previous);//choose or not choose a house
            previous = temp;
        }
        return current;
    }
}