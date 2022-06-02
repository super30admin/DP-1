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
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            int temp = a;
            a = Math.max(b, a);
            b = nums[i] + temp;
        }
        return Math.max(b, a);
    }
}
