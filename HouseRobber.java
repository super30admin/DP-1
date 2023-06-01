// Time Complexity : O(n) as we're iterating through the input array (length n) to build our table
// Space Complexity : O(n) where n is the total number of houses as we need a 1D array of length n
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

public class HouseRobber
{
    private int maxProfit = 0;
    int[] arr;
    public int rob(int[] nums)
    {
        arr = new int[nums.length];
        return maxProfit(nums, nums.length-1);
    }
    public int maxProfit(int[] nums, int index)
    {
        if(nums.length == 1)
        {
            return nums[0];
        }
        else if(nums.length == 2)
        {
            return Math.max(nums[0], nums[1]);
        }
        if (index == -1) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++)
        {
            if(i ==0)
            {
                arr[i] = nums[i];
            }
            else if(i == 1)
            {
                arr[i] = Math.max(nums[i], nums[i-1]);
            }
            else{
                arr[i] =  Math.max(nums[i] + arr[i-2] , arr[i-1]);
            }
        }
        return arr[nums.length -1];
    }

    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();
        int[] nums = {1,2 ,3, 1};
        System.out.println(obj.rob(nums));
    }

}
