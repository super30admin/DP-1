// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/*

    Since we have to not choose adjacent values, 
    we can maintain a dp array where the current value is maximum amount that 
    can be robbed till that index.

    current dp[] value will be  Maximum value of nums[i]+dp[i-2], nums[i-1]

*/


public class HouseRobber {
    

    public static int rob(int[] nums)
    {
        if(nums==null || nums.length == 0)
        {
            return 0;
        }

        if(nums.length==1)
        {
            return nums[0];
        }

        if(nums.length==2)
        {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i =2;i<nums.length;i++)
        {
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }

        return dp[nums.length-1];
    }


    public static void main(String args[])
    {
        int nums[] = {1,2,3,1};
        System.out.println(rob(nums));
    }
}
