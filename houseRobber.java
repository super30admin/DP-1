class houseRobber {
    public int rob(int[] nums) {
      if (nums == null || nums.length == 0 ) return 0;
        int notChoose = 0; 
        int Choose = nums[0];
        
        //iterating over the nums array
        for (int i = 1; i < nums.length; i++){
            int temp = notChoose; //for storing the value at notChoose index
            notChoose = Math.max(notChoose, Choose);
            Choose = temp + nums[i];
        }
        
        //returing the max value 
        return Math.max(notChoose, Choose); 
    }
    
}
