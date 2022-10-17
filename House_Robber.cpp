/*
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
*/
class Solution {
public:
    
    int rob(vector<int>& nums) {
        int ans;
        vector<int>dp(nums.size()+1,-1);
        dp[0]=-1;
        return ans = robb(nums,0, dp);
    }
    int robb(vector<int>& nums, int index, vector<int>& dp){
        int cnt=0;
        //base
            //valid
            if(index>=nums.size()){
                return 0;
            }
            //invalid
        //recursive
            if(dp[index]==-1){
            //select
            int sel = nums[index] + robb(nums,index+2,dp);
            //not select
            int notsel = robb(nums,index+1,dp);
            dp[index]=max(sel,notsel);
            }
        return dp[index];
    }
};