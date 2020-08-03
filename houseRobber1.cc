// Time Complexity : O(n) - n is the length of sequence.
// Space Complexity : O(1) - Did not use extra space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size()==0) return 0;
        if(nums.size()==1) return nums[0];
        
        int rob = nums[0];
        int skip = 0;     //Simulating a nx2 matrix for seq length as rows and rob, skip as columns. But it is prgressive and hence we only care about a row before.
        for(int i = 1; i < nums.size(); ++i){
            int temp = skip;
            skip = max(rob, temp);
            rob=nums[i] + temp;
        }
        return max(rob,skip);
    }
};