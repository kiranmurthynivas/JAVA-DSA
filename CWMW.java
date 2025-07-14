
import java.util.*;

public class CWMW {

    // public static int maxContainer( ArrayList<Integer> height){
    //     int  max = 0;

    //    brute force
    //     // for(int i = 0; i<height.size(); i++){
    //     //     for(int j = i+1; j<height.size(); j++){
    //     //         int h = Math.min(height.get(i), height.get(j));
    //     //         int w = j-i;
    //     //         int water = h * w;
    //     //         max = Math.max(max,water);
    //     //     }
    //     // }
    //     // return max;
    // }


    public static int maxContainer(ArrayList<Integer> height){

        // 2 pointer
        int max = 0;
        int lp = 0;
        int rp = height.size()-1;

        while(lp<rp){

            int h = Math.min(height.get(lp), height.get(rp));
            int w = rp-lp;
            int currWater = h*w;
            max = Math.max(max, currWater);

            if(height.get(lp)< height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return max;
    }
        
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(maxContainer(height));

    }
}