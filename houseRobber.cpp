// Time Complexity :O(n) 
// Space Complexity : O(1) //optimized  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
public:
    int rob(vector<int>& nums) {
        int skip = 0;
        int take = nums[0];
        for(int i =1;i<nums.size();i++){
            int temp = skip;
            skip = max(skip,take);
            take = nums[i]+temp;
        }
        return max(skip,take);
    }
};