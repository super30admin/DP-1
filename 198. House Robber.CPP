//TC-0(N)
//SC-O(N*M)
class Solution {
public:
    int rob(vector<int>& nums) {
        //2d 
      int n=nums.size();
        if(nums.size()==0)return 0;
        if(nums.size()==1)return nums[0];
        vector<vector<int>>dp(n,vector<int>(2));
        dp[0][1]=nums[0];
        for(int i=1;i<n;i++){
            dp[i][0]=max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        return max(dp[n-1][0],dp[n-1][1]);
    }