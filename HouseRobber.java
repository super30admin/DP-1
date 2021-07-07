//space - O(n) - for the result array
//time - O(n)

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        if(nums.length == 1)
        {
            return nums[0];
        }
        if(nums.length == 2)
        {
            return Math.max(nums[0], nums[1]);
        }
        int[] result = new int[nums.length];
        result[0] = nums[0]; //if only one house is present, rob that
        result[1] = Math.max(nums[0], nums[1]); //if 2 houses are present, rob 1 house which has max cash
        for(int i = 2; i < nums.length; i++)
        {
            //either rob the current house and last but one leaving the prev
            //or rob the prev house
            result[i] = Math.max(nums[i] + result[i - 2], result[i - 1]);
        }
        return result[nums.length - 1];
    }
}
