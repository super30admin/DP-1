// Time Complexity :
//      n - number of houses
//      rob() - O(n)
//      
// Space Complexity :
//      rob() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Problem1_SP_OP {
    public int rob(int[] nums) {
        //edge case
        if(nums == null || nums.length == 0)
            return 0;
        else
        {
            int chosen = 0, notChosen = 0;
            
            for(int i = 1; i <= nums.length; ++i)
            {
                int temp = chosen;
                
                chosen = notChosen + nums[i-1];
                notChosen = Math.max(temp, notChosen);
            }
            
            return Math.max(chosen, notChosen);
        }
    }
}