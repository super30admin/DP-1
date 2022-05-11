// Time Complexity :O(n)
// Space Complexity :O(1)
public class Rob {
        public int rob(int[] nums) {
            int len= nums.length;
            int nextrob, nextnext=0;
            if(len==0)return 0;
            nextrob=nums[len-1];
            for (int i = len - 2; i >= 0; --i) {
    
                int current = Math.max(nextrob, nextnext + nums[i]);
                nextnext = nextrob;
                nextrob = current;
            }
            return nextrob;  
            
        }
    
}
