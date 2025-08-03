class Solution {
public:
    int rob(vector<int>& nums) {
      return helper(nums,0,0);
    
        
    }
 private:
    int helper(vector<int>& nums, int i,int amount)
    {
        if(i>=nums.size())return amount ;
        int case0 = helper(nums,i+1,amount);
        int case1 = helper(nums,i+2,amount+nums[i]);

        return max(case0,case1);
    }   
};
/*******dp approch  one constrain : no of houses (use 1d array)********/
class Solution {
public:
    int rob(vector<int>& nums) {
      int n = nums.size();
      if (n==1)
      return nums[0];
      vector<int>dp(n);
      dp[0] = nums[0];
      dp[1] = max(nums[0],nums[1]);
      for(int i =2;i<nums.size();i++)
      {
        dp[i]=max(dp[i-1],dp[i-2]+nums[i]);
      }
      return dp[n-1];
    }   
};