//TC - O(n) n - array length
//SC - O(n) 1-d array storage of maximum rob 
//leetcode - successful

//Approach: Storing the max of the rob value at that particular index by choosing the index value + sum of the previous max other than the adjacent house  

class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
       int dp[] = new int[nums.length+1];
        dp[0] =0;
        dp[1] = nums[0]; // the current max is by choosing the first house till now
        for(int i=1;i<nums.length;i++){
            dp[i+1] = Math.max(dp[i],dp[i-1]+nums[i]);
        }
        return dp[nums.length];
    }
}
