class Solution {
    public int rob(int[] nums) {
        
        
        int [] calc ;
        calc = new int[2];
        
        
        
        calc[0] = 0 ;
        
        int DN = 0;
        int D = 0;
        int prevDN = 0;
        
        for ( int i : nums )
        {
            
             DN = Math.max( prevDN , D);
            
            D = prevDN + i ; 
            
            prevDN = DN;
            
           
            
            
        }
        
        return Math.max(DN , D);
        
    }
}