// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :yess about the logic


// Your code here along with comments explaining your approach: used bottom-up dynamic programming approach

class Solution {
    public int rob(int[] nums) {
        int n= nums.length;

        if(n==1) return nums[0];
        if(n==0) return 0;

        int previous=nums[0];
        int previous2=0;

        for(int i=1; i<n; i++){
            int take= nums[i]+ previous2;
            int notTake=0 +previous;

            int current= Math.max(take, notTake);

            previous2=previous;
            previous=current;
        }
       
        return previous;
    }
}