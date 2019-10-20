
// here time complexity is O(n) and space complexity is O(1)
class Solution {
    public int rob(int[] nums) {
        return helper(nums,0,0);
        
     }
    public int helper (int [] nums, int i, int maxamount)
    
    {
        //base case
        
        if(i>=nums.length)
        {
            return maxamount;
        }
        //if house is chosen
        //in this case we will move to next to next index as we cant choose adjacent house and now the maxamount becomes previous + the current house chosen amount
        int housechosen=helper(nums,i+2,maxamount+nums[i]);
        //if house is not chosen
        //in this case we will move to next leaving the current house and maxamount remains same since nothing has been robbed from this house.
        int housenottaken=helper(nums,i+1,maxamount);
        return Math.max( housechosen,housenottaken);
            
    }
}