class Solution {
  // Time Complexity: O(n)
  // Space complexity : O(1)
  // Using two variables skip and take

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        // Rows is the number of elements in nums array and we have 2 columns 
        // 0 or 1 where we store sum if we do not consider its corresponding value  amd 1 where we store sum if we consider the corresponding value.
        int skip = 0;
        int take = nums[0];

        for(int i=1;i<nums.length;i++)
        {   
            int tempTake = take;     
            take = skip + nums[i];
            skip = Math.max(skip,tempTake);
        }
// Return max value
        return Math.max(skip, take);
        
    }

    
}
