ss Solution {
    public int rob(int[] nums) {
        int c = 0;
        int dc = 0;
        for(int i=0; i<nums.length; i++){
            int temp = dc;           
            dc = Math.max(c,dc);
            c = nums[i]+temp;
        }
        return Math.max(c,dc);
    }
}

//TC:O(n)
//SC:O(1)
