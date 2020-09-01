// Time Complexity : O(n) where n is the number of elements in the array
// Space Complexity :O(1) since no extra space is required
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//for a particular element in the nums array we calculate the max of either choose or not choose
// here choose means i + prev2prev whereas not choose means prev
// So for a particluar index , the max value that can be robbed is stored.
class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int prev2prev = 0;
        int tmp;
        for (int i : nums) {
            tmp = prev;
            prev = Math.max(prev2prev + i, prev);
            prev2prev = tmp;
        }

        return prev;

    }
}