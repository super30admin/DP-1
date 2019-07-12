import java.util.*;

// Time Complexity : o(n) 
// Space Complexity :o(1)

class Rob Houses {
    public static int rob(int arr[]){
        if(arr.length==0) return 0;
        if(arr.length==1) return arr[0];
        if(arr.length==2) return Math.max(arr[0],arr[1]);
        
        for(int i=2;i<arr.length;i++){
            arr[i] = arr[i] + ((i-3>=0)? Math.max(arr[i-2],arr[i-3]):arr[i-2]);
        }
       return Math.max(arr[arr.length-1], arr[arr.length-2]);
    }
  
	public static void main (String[] args) {
	  int arr[] = {1,2,3,1};
		System.out.println(rob(arr));
		
	}
}