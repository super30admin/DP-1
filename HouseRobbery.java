// Time Complexity :O(n) n refers to the number of houses
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No





class HouseRobbery
{
    public int rob(int[] nums)
    {
        int count =0;
        int dont_count = 0;
        int temp=0;
        

        for(int i = 0; i<nums.length; i++)
        {
            temp = dont_count; //Stores the value where the previous house is not chosen
            dont_count=Math.max(count,dont_count); //The maximum value if the current house is not chosen comes from comparing the previous count and dont count values
            count = temp+nums[i]; //The previous dont count value add up to the current house value as the adjacent house cannot be chosen
        }
        return Math.max(count,dont_count);
        
    }
}