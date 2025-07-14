

public class TrappingRainWater {
    
     public static int findTRW(int height[]){
        int n = height.length;

        // left max boundary
        
        int maxleftbound[] = new int[height.length];
        maxleftbound[0] = height[0];

        for(int i = 1; i<n ; i++){
            maxleftbound[i] = Math.max( height[i], maxleftbound[i-1]);
        }

        //right max bounday

        int maxrightbound[] = new int[height.length];
        maxrightbound[n-1] = height[n-1];

        for(int i = n-2 ; i>= 0 ; i--){
            maxrightbound[i] = Math.max(  height[i],  maxrightbound[i+1]);
        }

        //water level
        // trapping rain water
        int trappingRainWater= 0;
        for(int i=0 ; i<n ; i++) {

            int waterLevel = Math.min(maxleftbound[i], maxrightbound[i]);
            trappingRainWater += waterLevel - height[i];
        }

        return trappingRainWater;

     }



    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2 , 5};
        
       System.out.println(findTRW(height));
    }

}
