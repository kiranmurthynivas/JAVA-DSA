import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GreedyAlgo {
    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,500,2000}; 

        Arrays.sort(coins, Comparator.reverseOrder());

        int count = 0;
        int amount = 590;
        ArrayList<Integer> coin = new ArrayList<>();

        for(int i=0; i<coins.length;i++){
            if(coins[i]<= amount){
                while(coins[i]<=amount){
                    count++;
                    coin.add(coins[i]);
                    amount = amount - coins[i];
                }
            }
        }

        System.out.println("Minimum number of coins = "+ count);
        for(int i = 0; i<coin.size();i++){
            System.out.print(coin.get(i)+" ");
        }
        
    }
}
