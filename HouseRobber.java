// Time Complexity :O(n) --> beacuse of for loop
// Space Complexity :O(1)  ---> because of Hashmap
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Didn'' understand how to approach for different test cases


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        int even = 0,odd = 0;
        for(int i = 0;i < nums.length;i++){
            if(i%2==0)
                even+= nums[i];
            else
                odd+= nums[i];
        }
        return Math.max(even,odd);
    }
}
