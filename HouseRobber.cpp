/*
This program solves the problem using a dynamic programming approach.
An array to store the maximum loot obtainable when the robber reaches 
a house is created. This array stores the maximum of all loot obtainable
till a particular house. It is successively built up by calculating 
optimal loot, starting from the smallest subproblem.

Problems with this code: None

Did this code run on leetcode: Yes

*/




class Solution {
public:
    //Max function to calculate max value
    int max(int a, int b)
    {
        if(a > b)
            return a;
        return b;
    }
    //Time Complexity = O(n)
    //Space Complexity = O(n)
    int rob(vector<int>& nums) 
    {
        int size = nums.size();
        int loot[size];
        //Base case when there is only one house
        if(size == 1)
            return nums[0];
        //Base case when there are only two houses
        if(size == 2)
            return max(nums[0], nums[1]);
        //Setting initial loot values
        loot[0] = nums[0];
        loot[1] = max(nums[0], nums[1]);
        /*We start from i=2 because the algorithm has to check max loot at either the house before the current
        house or check max loot at the current house and the house two houses before the current house*/
        for(int i = 2; i < size; i++)
            loot[i] = max(loot[i - 1], nums[i] + loot[i - 2]);
        
        return loot[size-1];
        
    }
};