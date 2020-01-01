// Time Complexity :
//      n - number of houses
//      rob() - O(n)
//      
// Space Complexity :
//      rob() - O(n)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Problem2 {
	public int rob(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0)
            return 0;
        else if(nums.length == 1)
            return nums[0];
        else if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        else
        {
            //two cases:
            // 1. rob the house
            // 2. do not rob the house
            
            int[] R = new int[nums.length+1];
            R[0] = 0;
            R[1] = nums[0];
            R[2] = Math.max(nums[0], nums[1]);
            
            int maxR = Integer.MIN_VALUE;
            
            for(int i=0; i <= nums.length; ++i)
            {
                if(i >=3)
                    R[i] = nums[i-1] + Math.max(R[i-3],R[i-2]);
                    
                
                if(R[i] > maxR)
                    maxR = R[i];
            }
            
            return maxR;
        }
    }
}