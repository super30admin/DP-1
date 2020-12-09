// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size()==0){
            return 0;
        }
        int skip = 0, take = nums[0];
        for(int i=1;i<nums.size();i++){
            int temp = max(skip, take);
            take = skip+nums[i];
            skip = temp;
        }
        return max(skip, take);
    }
};
