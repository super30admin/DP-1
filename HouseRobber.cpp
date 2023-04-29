// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Here the deciding factors are only the house value there is no target in this which is the case in Coin change
// Taking a 2D array with nums array as rows and 0,1 as columns 
// Matrix conatins the maximum profit
// Suppose if I select ith row the value of dp[i][0] ==> it means I have a choice of selecting or not 
// selecting (i-1)th row.So,  I will be choosing max of these values
// 
// dp[i][0]==>max profit till now without selecting ith house
// dp[i][1]==>max profit till now with selection of ith house

class Solution {
public:
    int rob(vector<int>& nums) {
     vector<vector<int>> dp(nums.size(), vector<int>(2));
     dp[0][0]=0;
     dp[0][1]=nums[0];
      int ans=INT_MAX;
     for(int i=1;i<dp.size();i++)
     {  
        // dp[i][0] ==> it means I have a choice of selecting or not selecting (i-1)th row.So,  
        // I will be choosing max of these values 
        dp[i][0]=max(dp[i-1][0],dp[i-1][1]);   

        //  If i decided to select ith row it means I cannot select (i-1)th ,
        // So I will add current house value with dp[1-1][0],which is the value of not selecting i-1 th house
        dp[i][1]=dp[i-1][0]+nums[i];
     }
       
     return max(dp[dp.size()-1][0],dp[dp.size()-1][1]);
    }
};