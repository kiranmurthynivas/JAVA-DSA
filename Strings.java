
import java.util.*;

public class Strings {
    public static boolean  palindrome( String str){
        int n = str.length();
       for(int i=0; i<n/2; i++){
        if(str.charAt(i) != str.charAt(n-1-i)){
            return false;
        }
       }
       return true;
    }

    public static float  getShortestPath(String path){
        int x = 0 , y=0;

        for(int i=0; i<path.length(); i++){
            char dir = path.charAt(i);
            
            if( dir == 'S'){
                y--;
            }
            else if(dir == 'N'){
                y++;
            }
            else if(dir =='W'){
                x--;
            }
            else{
                x++;
            }
        }
        int x2= x*x;
        int y2= y*y;

        return (float)Math.sqrt(x2+y2);
    }

    public static void subString(String str, int si, int ei){

        for(int i= si; i<ei; i++){
            System.out.print(str.charAt(i));
        }

    }

    public static void largest(String fruits[]){
        String largest = fruits[0];

        for(int i= 1; i<fruits.length; i++){
           if(largest.compareTo(fruits[i]) <0){
            largest = fruits[i];
           }
        }
        System.out.println(largest);
    }

    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder("");

        char ch= Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress( String str){
        StringBuilder sb = new StringBuilder("");
        char ch;
        for(int i=0; i<str.length(); i++){
            ch = str.charAt(i);
            Integer count= 1;
            while( i<str.length()-1 && str.charAt(i)== str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(ch);
            if(count > 1){
                sb.append(count);
            }
        }

        return sb.toString();
    }

 public static boolean  anagrams( String str1, String str2){
    boolean isanagram = true;
    for(int i=0; i<str1.length(); i++){
        for(int j=0; j<str2.length(); j++){
            if( str1.charAt(i) == str2.charAt(j)){
                isanagram = true;
            }else{
                isanagram = false;
            }
        }
    }
    return isanagram;
 }

    public static void main(String[] args) {
        try( Scanner sc = new Scanner(System.in)){
            String str1 = "race";
            String str2= "care";

            System.out.println(anagrams(str1, str2));
        }
    }
}
