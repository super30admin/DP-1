//Time Complexity - O(n^2)
//Space complexity - O(n)
//Passed in LeetCode
class Solution {
public:
    int dp[100];
    int rob(vector<int>& nums) {
        for(int i=0;i<nums.size();i++){
            dp[i]=-1;
        }
        return helper(nums, 0, 0);
    }
    int helper(vector<int>&nums, int idx, int amount){
        if(idx>=nums.size()){
            return amount;
        }
        if(dp[idx]!=-1){
            return dp[idx]+amount;
        }
        int case1 = helper(nums,idx+1,amount);
        int case2 = helper(nums, idx+2, amount+nums[idx]);
        return dp[idx]=max(case1,case2);
    }
};