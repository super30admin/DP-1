//Approach 1 : Exhaustive recursive approach

// Time Complexity : exponential
// Space Complexity : O(n) max depth of recursion is n
// Did this code successfully run on Leetcode : No - Time Limit Exceeded


/*
Recursive function to calculate the total amount (max at each point) 
This is going to be an exhaustive search 
*/
class Solution {
private:
    int helper(vector<int>nums, int index, int amount){
        //base case
        if(index>=nums.size())
            return amount;

        //case 0 - you don't pick the house 
        int case1 = helper(nums, index+1, amount);

        //case 1 - you pick the house 
        //index = index +2 because you picked that and now you can't pick the neighbour 
        int case2 = helper(nums, index+2, amount+nums[index]);
        return(max(case1, case2));
    }

public:
    int rob(vector<int>& nums) {
        if(nums.size() == 0)
            return 0;
        return helper(nums, 0, 0);
    }
};


// Approach 2 :  (n+1 x 2) matrix approach
// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes



class Solution {
public:
    int rob(vector<int>& nums) {
        //initialising a 2d array of size n+1 and 2 full of 0s
        //2 columns because we have 2 possibilities, you pick it or you don't 
        vector<vector<int>> dp (nums.size()+1, vector<int>(2,0));
        for(int i=1; i<nums.size()+1; i++ ){
            //if you don't pick it, you are allowed to either pick the previous house or not as the contraint don't apply
            //so we take the max of the two
            dp[i][0] = max(dp[i-1][0],dp[i-1][1]);

            //if you pick the current house i, you can't pick i-1, so has to be the 0th case 
            dp[i][1] = dp[i-1][0] + nums[i-1];
        }
        //result is in the final row 
        return max(dp[nums.size()][0],dp[nums.size()][1]);
    }
};


// Approach 3: only 2 variables to store picked or skipped as we only need the last row for results
// Time Complexity : O(n) where n is the number of houses
// Space Complexity : O(1) we are using only 3 extra variables 
// Did this code successfully run on Leetcode : Yes

// Dynamic programming - storing picked and skipped cases in just 2 variables
class Solution {
public:
    int rob(vector<int>& nums) {
        //these will be our dp variables
        int pick=nums[0], skip=0;
        for(int i=1; i<nums.size(); i++ ){
            //temp to store the value we will lose - skip in this case
            int temp_skip = skip;
            skip = max(pick, skip);
            pick = temp_skip + nums[i];
        }
        return max(pick,skip);
    }
};




