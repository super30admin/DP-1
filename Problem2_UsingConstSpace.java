// Problem 2: House Robber
class Problem2_UsingConstSpace {
    //with O(1) complexity
    public int rob(int[] nums) {
      if(nums== null ||nums.length ==0) return 0;
        int skip =0;
        int choose =nums[0]; 
       for(int i=1; i<nums.length; i++){
            int temp = skip;
            skip = Math.max(skip,choose);
            choose = temp+nums[i];
            
        }
        return Math.max(skip, choose);
    }
}

/*
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Approach:
- In the 2-D array approach, at each home, we use the information available in the 
immediately previous home.
- Therefore the previous information can be stored in constant spaces and be replaced
as we move through the array.
*/