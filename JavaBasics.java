import java.util.*;

public class JavaBasics {
     public static void binToDec (int binNum) {
            int dec = 0;
            int pow = 0;

            while(binNum > 0) {
                int last = ( binNum % 10);
                dec = dec + (last * (int) Math.pow(2, pow));
                pow ++;
                binNum = binNum/ 10;
            }
            System.out.println("Decimal number "+ dec);
     }

     public static void decToBin ( int dec){
        int bin = 0;
        int pow = 0;

        while(dec> 0) {
            int rem = dec % 2;
            bin =  bin + rem *(int) Math.pow(10, pow);
            pow ++;
            dec = dec / 2;
        }
        System.out.println("binary "+bin);
     }
   
     public static int reverse( int n){
         int rev =0;
        while (n > 0){
            int last = (n % 10);
            rev = (rev * 10 )+ last ;
            n = n /10;
        }
        return rev;

     }


     public static void palin(int n ) {
         if ( n == reverse(n)){
            System.out.println(n + " is palindrome");
         }else {
            System.out.println(n + " is not a palindrome");
         }
     }


    public static void main (String args[] ) {
        try( Scanner sc = new Scanner(System.in);){
          
         
        }         
    }
}
 
    
