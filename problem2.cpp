// Time Complexity : O(n) --> need to iterate through the entire array once
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : The algorithm wasn't intuitive


// Your code here along with comments explaining your approach

/*

1. Brute force solution is create an array of all possible arrays of combination 
   and calculate the maximum sum of the available options. Run time : O(2^n)

2. DP solution is creating two pointers for previous value and previous to the 
   previous value and updating the max sum of the available options and updating 
   them on each iteration. 

*/



#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
        
    }
};