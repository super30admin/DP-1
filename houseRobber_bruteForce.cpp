//time complexity: O(n)
//space complexity: O(1)

#include <algorithm>

int helper(vector<int>&  nums, int index, int amount){
    
    if(index >= nums.size()) return amount;
    
    int choose = helper(nums, index+2, amount+nums[index]);
    
    int notChoose = helper(nums, index+1, amount);
    
    return max(choose, notChoose);
}

class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() == 0){ return 0;}
         return helper(nums,0,0);     
    }
    
    
};
