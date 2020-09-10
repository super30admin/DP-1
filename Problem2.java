Time Complexity: O(n)
Space Complexity: Constant
Ran successfully on leetcode?: yes

class Solution {
    public int rob(int[] nums) {
        
        int length = nums.length;
        int prev_choose = 0, prev_notChoose = 0;
        
        for(int i = 0; i < length; ++i){
            int curr_choose = prev_notChoose + nums[i];
            prev_notChoose = Math.max(prev_choose, prev_notChoose);
            prev_choose = curr_choose;
        }
        
        return Math.max(prev_choose, prev_notChoose);
    }
}
