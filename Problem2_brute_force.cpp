// Time Complexity : O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : NO time limit  exceeded
// Any problem you faced while coding this : 


#include<vector>

using namespace std;

class Solution {
public:
    int helper(vector<int>& nums,int idx,int sum){
        if(idx >=nums.size()) return sum;

        //logic

        int case_1 = helper(nums,idx+2,sum+nums.at(idx));
        int case_2 = helper(nums,idx+3,sum+nums.at(idx));

        return(case_1>case_2?case_1:case_2);
    }
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n==1){ 
            return nums.at(0);
        }
        else{
            int case_1 = helper(nums,0,0);
            int case_2 = helper(nums,1,0);
            return(case_1>case_2?case_1:case_2);
        }
        
    }
};