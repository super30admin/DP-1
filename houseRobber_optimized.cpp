// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


#include <algorithm>

class Solution {
public:
    int rob(vector<int>& nums) {
        
        if(nums.size()==0) return 0;
        int n= nums.size();
        int skip=0;
        int take = nums[0];   
        
        for(int i=1; i < nums.size(); i++){  
            int temp = skip;
            skip= max(skip, take);
            take= temp + nums[i];        
        }
        return max(skip,take);
    }
};
