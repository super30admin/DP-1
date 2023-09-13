//Max house robbings
//This is an exhaustive approach - using recursion
//Time complexity : O(2^n)
//Space complexity : O(1)


class Solution {
public:
    int rob(vector<int>& nums) {
        
        
        
        return helper(nums, 0, 0);
    }
    
    int helper(vector<int>& nums, int index, int max)
    {
        //base :
        if(index>=nums.size())
        {
            return max;
        }
        
        
        //case1: choose
        int case1= helper(nums, index+2, max+nums[index]);
        
        
        //case2:dont choose
        int case2= helper(nums, index+1, max);
        
        
        return std::max(case1,case2);
    }
};
