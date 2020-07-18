//Time Complexity - O(number of houses)
//Space Complexity - O(2 * number of houses)
//Ran successfuly on leetcode

class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size()==0)
            return 0;
        int dp[nums.size()][2];
        dp[0][0]=0;
        dp[0][1]=nums[0];
        for(int i=1;i<nums.size();i++)
        {
            dp[i][0]=max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        return max(dp[nums.size()-1][0],dp[nums.size()-1][1]);
    }
};