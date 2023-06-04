// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No since time complexity is exponential which is why for some cases time limit exceeds.

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


class Solution {
public:
    int rob(vector<int>& nums) {
        return helper(nums, 0, 0);
    }

    int helper(vector<int>& nums, int idx, int robbings){
        //base 
        if(idx >= nums.size()) return robbings;
        //logic
        //choose
        int case1 = helper(nums, idx + 2, robbings + nums[idx]);

        //didnt choose
        int case2 = helper(nums, idx + 1, robbings);

        return max(case1, case2);
    }
};