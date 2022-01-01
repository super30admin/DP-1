//Time complexity of this solution is O(n) as we are iterating
//over the array
// The space complexity is constant as we are not using any extra space


//Approach: First we tried the greedy approach but it failed in few cases.
//The second approach we used was exhaustive. In exhaustive approach, the time
//complexity was exponential. So, we tried the dynamic programming approach
//and started looking for the subproblems. After making sure it is a dynamic
//problem we created a table. For each valuer of the given array we calulated
//the money for skip and take cases. There we found that for every skip case,
//the money calulated was max value of the previous skip and take cases. 
//The money calculated for the take case was the sum of the money caluclated
//for the skip case of the previous index of array and the current index value of the 
//array. On further optimization, we found that the value for take is the maima
//of the previous take value and the sum of the previous skip value and the 
//value at the current index of the array and skip is the previous take value.
// for example: [1,2,3,1] is the given array. We have the following table for it
//      skip       take
//   1   0          1
//   2   1          2
//   3   2          4
//   1   4          3
//
//We designed our code based on the last optimization


//The code ran perfectly on leetcode.






class Solution {
public:
    int rob(vector<int>& nums) {
        
        int take = 0, skip = 0;
        int buff = 0;
        for(int i = 0; i <nums.size(); i++){
            buff =   max(take, skip + nums[i]);
            skip = take;
            take = buff;
        }
        return take; 
    }
};