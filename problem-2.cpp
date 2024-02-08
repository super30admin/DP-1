// 198. House Robber
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
    
Implementing dynamic programming to determine the maximum amount of money that can be robbed 
from houses represented by the nums vector. initializes a DP array dp of size n + 1, where n is the number of houses. 
It iterates through each house, calculating the maximum amount of money that can be obtained if the current house is robbed or skipped, 
and stores this information in the dp array. Finally, returns the maximum amount of money that can be robbed from all houses,
which is stored at dp[n].

*/
int rob(vector<int>& nums) {
    int n = nums.size();
    int dp[n+1]; 
    dp[0] = 0;
    dp[1] = nums[0];
    for(int i = 2; i < n+1; i++)
        dp[i] = max(dp[i-1], dp[i-2]+nums[i-1]);
    return dp[n];
}

