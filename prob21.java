prob 21:

//tc:o(n)

//sc:o(1)

class Solution {
    public int rob(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        int c=0;
        int dc=0;
        
        for(int x: nums){
            int temp = dc;
            dc= Math.max(c,dc);
            c= x + temp;
        }
        return Math.max(c,dc);
    }
}