//Time Complexity-O(n)
//Space Complexity-O(n)
//Did the code run on Leetcode? yes

class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size()==0)
        {
            return 0;
        }
        int n=nums.size()+1;
        int dp[n];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=1;i<nums.size();i++)
        {
            dp[i+1]=max(dp[i],dp[i-1]+nums[i]);
        }
        return dp[nums.size()];
    }
};
