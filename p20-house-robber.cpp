// Time complexity is O(n) - n = size of nums array
// Space complexity is O(n) Since 2nd dimension of dp array is 2(constant), we can ignore it
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach:

// Using 2-D array - dimensions [nums.size()][2]
class Solution {
public:
    int rob(vector<int>& nums) {
        if(!nums.size()) return 0;
        int rows = nums.size();
        int columns = 2;
        vector<vector<int>> dp(rows, vector<int>(2, 0));
        
        dp[0][1] = nums[0];
        for(int i = 1; i < rows; i++){
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return max(dp[rows-1][0], dp[rows-1][1]);
    }
};

// Time complexity is O(n) - n = size of nums array
// Space complexity is O(n) (dp array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

//Using 1-D array
class Solution {
public:
    int rob(vector<int>& nums) {
        if(!nums.size()) return 0;
        if(nums.size() == 1) return nums[0];
        int rows = nums.size();
        int columns = 2;
        vector<int> dp(rows, 0);
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        for(int i = 2; i < rows; i++){
            dp[i] = max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[rows-1];
    }
};

// Skip and Take variables
// Time complexity is O(n) - n = size of nums array
// Space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    int rob(vector<int>& nums) {
        if(!nums.size()) return 0;
        int skip = 0; // not robbing a particular house
        int take = nums[0]; // robbing a particular house
        
        for(int i = 1; i < nums.size(); i++) {
            int temp = skip;
            skip = max(skip, take);
            take = temp + nums[i];
        }
        return max(skip, take);
    }
};

// Recursive Solution
// Time complexity is ???
// Space complexity is ???
// Did this code successfully run on Leetcode : Time Limit Exceeded
// Any problem you faced while coding this : None
class Solution {
public:
    
    int recursiveFn(vector<int> nums, int index, int cost) {
        //base case
        if(index >= nums.size()) return cost;
        
        //logic
        //Don't choose
        int case1 = recursiveFn(nums, index+1, cost);
        
        //Choose
        int case2 = recursiveFn(nums, index+2, cost+nums[index]);
        
        return max(case1, case2);
    }
    
    int rob(vector<int>& nums) {
        return recursiveFn(nums, 0, 0);
    }
};
