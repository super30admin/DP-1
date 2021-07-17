class HouseRobber {
    
    //time:O(n)
    //space: O(1)
	//Did it run successfully on leetcode: yes
    public int rob(int[] nums) {
        //initializing variables
        int zero = 0;
        int one = nums[0];
        int prevZero = 0;
        
        //looping through the input array
        for(int i=1; i<nums.length;i++){
            prevZero = zero;
            //skip current element
            zero = Math.max(zero, one);
            //take current element
            one = prevZero+nums[i];
        }
        
        return Math.max(zero, one);
    }

}