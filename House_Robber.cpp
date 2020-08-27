// Time Complexity :O(n)
// Space Complexity : O(1) as we used two pointer approach and not matrix method to store values.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Beginnning of DP... Building the idea is hard as this point..


// here we have used a DP approach with the option to choose or dont choose a house at each step.
// if we choose a house then we have to pick the dont choose value from previous since we cannot pick consecutive 
/// houses.. And if we dont choose a house then we have an option to pick the max value of
// choose / dont choose of previous house since we are intended to find the total maximum values.


// We can form a matrix to store all  these values but takes O(n) space, using an array or else the poiner 
// approach shown in code will be o(1) space.
class Solution {
public:
    int rob(vector<int>& nums) {
        int choose = 0;
        int d_choose = 0;
        
        for ( int i =0; i < nums.size(); i++){
            int temp = choose;
            
            choose = d_choose;
            d_choose =  max( temp + nums[i], d_choose);
        }
        return max(choose, d_choose);
    }
};