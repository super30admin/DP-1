// Time Complexity :O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size()==0)
            return 0;
        if(nums.size()==1)
            return nums[0];
        if(nums.size()==2)
            return max(nums[0],nums[1]);
        
        vector<int> v(nums.size(),0);
        v[0]=nums[0];
        v[1]=max(nums[0],nums[1]);
        
        for(int i=2;i<nums.size();i++){
            v[i]=max(nums[i]+v[i-2],v[i-1]);
        }
        // for(int i=0;i<nums.size();i++){
        //     cout<<v[i]<<" ";
        // }
        return v[nums.size()-1];
    }
};