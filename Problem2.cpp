// House Robber


// Time Complexity : O(n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Not really.


// Your code here along with comments explaining your approach


#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() == 0) return 0;    // return 0 if no elements
        int skip = 0, take = nums[0];   // take 2 variables choose a house or skip it. initialize skip with 0 and take with the value of the first element
       for(int i =1; i<nums.size(); i++)
        {
           int temp = take; // store the temp variable as take will be changed. Needed for skip
           take = skip + nums[i];   // take 
           skip = max(temp, skip);  // maximum of the previous row
        }
        return max(skip, take); // return max
    }
};

// int main(){
    
//     return 0;
// }