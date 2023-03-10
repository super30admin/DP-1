198. House Robber



/* int based recursion/ time limit exceed
class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size(); 
        if (n==0) return 0;

        return helper(nums, 0, 0);

    }
    int helper(vector<int>& nums, int idx, int robbings) {
        //base
            if (idx >= nums.size()) return robbings;
        //logic 
            int case1 = helper(nums, idx+2, robbings+nums[idx]);
            int case2 = helper(nums, idx+1, robbings);
            return max(case1, case2);
    }
};
*/
//void based recursion - time limit exceed
/*
class Solution {
public:
    int result;
    int rob(vector<int>& nums) {
        int n = nums.size(); 
        if (n==0) return 0;
        helper(nums, 0, 0);
        return result;

    }
    void helper(vector<int>& nums, int idx, int robbings) {
        //base
            if (idx >= nums.size()) {
                result = max(robbings, result);
                return;
            }

        //logic 
            helper(nums, idx+2, robbings+nums[idx]);
            helper(nums, idx+1, robbings);
    }
};
*/

//TC - O(n)
//SC - O(n)

/*
class Solution {
public:
    int result;
    int rob(vector<int>& nums) {
        int n = nums.size(); 
        if (n==0) return 0;
        if (n == 1) return nums[0];
        int dp[n];
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        for(int i=2; i<=n-1; i++) {
            dp[i] = max(dp[i-1], (nums[i] + dp[i-2]));
        }
        return dp[n-1];
    }
};
*/

//TC - O(n)
//SC - O(1)

class Solution {
public:
    int result;
    int rob(vector<int>& nums) {
        int n = nums.size(); 
        if (n==0) return 0;
        if (n == 1) return nums[0];
        int var1 = nums[0];
        int var2 = max(nums[0], nums[1]);
        for(int i=2; i<=n-1; i++) {
            int var3 = max(var2, (nums[i] + var1));
            var1 = var2; var2 = var3;
        }
        return var2;
    }
};


