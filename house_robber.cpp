//TC:O(N)
//SC:CONSTANT

class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size()==0){return 0;}
        if(nums.size()==1){return nums[0];}
        int prev=nums[0];
        int curr = max(nums[1],nums[0]);
        for(int i=2;i<nums.size();i++){
            int temp = curr;
            curr = max(nums[i]+prev,curr);
            prev = temp;
        }
        return curr;
    }
};
