// Time Complexity :O(n) where n is the size of the array.
// Space Complexity :O(1) since there is no auxillary DS used.
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


class Solution {
    public int rob(int[] nums) {
        int evenSum = 0;
        int oddSum =0;
        for(int i=0;i<nums.length;i++)
        {
            if(i%2 == 0)
            {
                evenSum = Math.max(evenSum + nums[i],oddSum);
            }
            else
            {
                oddSum =  Math.max(oddSum + nums[i],evenSum);
            }
        }
        return (evenSum>=oddSum)? evenSum:oddSum;
    }
}