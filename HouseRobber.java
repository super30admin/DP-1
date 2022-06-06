/* Time Complexity: O(n)
 * Space Complexity:O(1)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 */

class Solution {
    public int rob(int[] nums) {
        //null case
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length < 2) {
            return nums[0];
        }
        int n = nums.length;
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            int temp = curr;
            curr = Math.max(prev + nums[i], temp);
            prev = temp;  
        }
        return curr;
    }
}
