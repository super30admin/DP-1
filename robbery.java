// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return findSum(nums, 0, map);
    }
    
    public int findSum(int[] nums, int index, HashMap<Integer, Integer> map) {
        if(map.containsKey(index)) {
            return map.get(index);
        }
        int arrLength = nums.length;
        
        if (index >= arrLength)
            return 0;
        else {
            int resToStore = Math.max(nums[index]+findSum(nums,index+2, map), findSum(nums, index+1, map));
            map.put(index, resToStore);
            return resToStore;
        }
    }
}
