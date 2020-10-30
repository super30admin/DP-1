// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


/* Your code here along with comments explaining your approach
either choose a value + dont choose from previous one or dont choose a value and select max from previous one

    c             dc    temp(copy dc value)
1   1             0      
2   temp(0)+2=2   1      0
3    1+3=4        2      1
1    2+1=3        4      2

*/
    
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int choose = nums[0];
        int dontChoose = 0;
        
        for(int i = 1; i < nums.length; i++){
            int temp = dontChoose;
            dontChoose = Math.max(choose, dontChoose);
            choose = temp + nums[i];
        }
        
        return Math.max(choose, dontChoose);
    }
}
