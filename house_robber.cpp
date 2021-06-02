// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - Some small length edge cases didn't work; Need to work on them

class Solution {
public:
    int rob(vector<int>& nums) {
        
        int lookup[100] = {0};
        int max = 0;
        int temp;
                
        for(int i = 0; i < nums.size(); i++)
        {
            if(i > 1)
            {
                //Find the Maximum Possible loot till i-2 index

                int max_num = -1;
                for(int j = 0; j <= i-2; j++)
                {
                    if(lookup[j] > max_num)
                    {
                        max_num = lookup[j];
                    }
                }
                
                temp = nums[i] + max_num;
            }
            else
                temp = nums[i];
            
            
            lookup[i] = temp;
            
            //Loot greater than max loot ?
            if(temp > max)
            {
                max = temp;
            }
        }
        
        return max;
    }
};