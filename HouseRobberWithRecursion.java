package DynamicProgramming;

/*
-------------------------------------------------------------------------------------------------------
    Time complexity : exponential
    space complexity: exponential
    Did this code run successfully in leetcode : yes
    problems faces : no
    at every step either choose the element or not
*/

public class HouseRobberWithRecursion {

    public int rob(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;
        
        return helper(nums, 0, 0);
    }
    
    public int helper(int[] nums,int index,int robbings)
    {
        if(index >= nums.length-1) return robbings;
        
        //choose  house to rob
        int case1 = helper(nums, index+2, robbings+nums[index]);
        
        //not choose house to rob
        int case2 = helper(nums, index+1, robbings);
        
        return Math.max(case1, case2);
    }
    
}
