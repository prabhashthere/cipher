
package product.cipher;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Prabhash
 */
public class MathOperation {
    
    public static char randomChar(){
        Random r = new Random();
        int randNo = 32 + r.nextInt(94);
        return (char)randNo;
    }
    
        
    public static String xor(String word1,String word2){
        String returnString = "";
        int xorCharAscii;
        char xorChar;
        try {
            for (int i = 0; i < word1.length(); i++) {
                int char1 = word1.charAt(i);
                int char2 = word2.charAt(i);
                xorCharAscii = char1 ^ char2;
                if(xorCharAscii<32){
                    xorCharAscii += 64;
                }
                if(xorCharAscii<32){
                    xorCharAscii -= 1;
                }
                xorChar = (char) xorCharAscii;
                returnString += xorChar;
            }
        } catch (Exception e) {
            System.err.println("erron in method xor"+e);
        }
        return returnString;
    }
    
    
    public static ArrayList<Integer> createOrderlist(String key){
        String asciiString = "";
        ArrayList<Integer> orderList = new ArrayList<Integer>();
        for (int i=0; i < key.length(); i++) {
            int char1 = (int) key.charAt(i);
            if (char1<100){
                asciiString += "0" + Integer.toString(char1);
            }
            else{
                asciiString += Integer.toString(char1);
            }
        }
        for (int i=0; i < asciiString.length(); i++) {
            char char1 = (char) asciiString.charAt(i);
            int charInt = Character.getNumericValue(char1);
            if(!orderList.contains(charInt)){
                orderList.add(charInt);
            }
        }
        for (int i=0;i<10;i++){
            if(!orderList.contains(i)){
                orderList.add(i);
            }
        }
        return orderList;
    }
    
}
