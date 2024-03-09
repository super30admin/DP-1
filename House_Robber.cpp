// {Approach 1}
// Time Complexity : O(2^n)  ... at each house we are taking 2 different paths to 
//                           ... choose it or not to choose it which makes time complexity 2^n.
//                   ...  n is number of houses                  
// Space Complexity :  O(1)  ... amount of new space required is constant irrespctive of number of houses

// {Approach 2}
// Time Complexity : O(n)  ... n is number of houses; we are traversing number of houses only once                  
// Space Complexity : O(n)  ... new array of size=number_of_house+1 is required.

// {Approach 3}
// Time Complexity : O(n)  ... n is number of houses; we are traversing number of houses only once                  
// Space Complexity : O(1)  ... only three new variables are required of size integer.

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leet code : https://leetcode.com/problems/house-robber/

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that 
adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
*/


// Aproaxh 1 : Exhaustive approach using recursion

class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        return helper(nums, 0, 0);
    }

    int helper (vector<int> &nums, int houseIdx, int robbedSum){
        // Base condition:
        if(houseIdx >= nums.size()) return robbedSum;

        //case 0:
        int sum0 = helper(nums, houseIdx+1, robbedSum);
        //case 1:
        int sum1 = helper(nums, houseIdx+2, robbedSum+nums[houseIdx]);

        return max(sum0, sum1);
    }
};


// Aproaxh 2 : Dynamic Programming using 1-D array

class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        if(nums.size() == 1) return nums[0];

        vector<int>dp(nums.size()+1, 0);
        dp[1] = nums[0];
        for (int i=2; i<dp.size(); i++){              // O(n)
            dp[i] = max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp.back();

    }
};


// Aproaxh 3 : Dynamic Programming using minumal space 
// using only three new variables instead of using array
// This reduces space complexity to O(1)

class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        if(nums.size() == 1) return nums[0];

        int prev = 0;
        int current = nums[0];

        for (int i=1; i<nums.size(); i++){
            int tmp = current;
            current = max(current, prev+nums[i]);
            prev = tmp;
        }
        return current;
    }
};