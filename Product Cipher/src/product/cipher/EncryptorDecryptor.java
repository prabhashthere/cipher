/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.cipher;

import java.util.ArrayList;

/**
 *
 * @author Prabhash
 */
public class EncryptorDecryptor {
    public static String replaceLetters(String message){
        String string8;
        String replacedMessage = "";
        String xorString8;
        int charCount= 8-(message.length()%8);
        for(int i=1;i<charCount;i++){
            message += MathOperation.randomChar();
        }
        message += String.valueOf(charCount-1); //if number of elements we added is n, add n-1 lo the end of the message
        for(int i=0;i<message.length();i+=8){
            string8 = message.substring(i,i+8);
            xorString8 = MathOperation.xor(string8,EncryptHome.keyVal);
            replacedMessage += xorString8;
        }
        return replacedMessage;
    }
    
    public static String placeLetters(String key,String message){
        String string8;
        String xorString8;
        String placedMessage = "";
        String newPlacedMassage;
        for(int i=0;i<message.length();i+=8){
            string8 = message.substring(i,i+8);
            xorString8 = MathOperation.reXor(string8,key);
            placedMessage += xorString8;
        }
        int charCount = Character.getNumericValue(placedMessage.charAt(placedMessage.length()-1));
        newPlacedMassage = placedMessage.substring(0,placedMessage.length()-(charCount+1));
        return newPlacedMassage;
    }
    
    public static String shuffle(String key, String replacedMessage){
        String string10;
        String shuffled10;
        String shuffledMessage = "";
        ArrayList<Integer> orderList = MathOperation.createOrderlist(key);
        int charCount= 10-(replacedMessage.length()%10);
        for(int i=1;i<charCount;i++){
            replacedMessage += MathOperation.randomChar();
        }
        replacedMessage += String.valueOf(charCount-1); //if number of elements we added is n, add n-1 lo the end of the message
        for(int i=0;i<replacedMessage.length();i+=10){
            string10 = replacedMessage.substring(i,i+10);
            shuffled10 = "";
            for(int temp:orderList){
                char char1 = (char) string10.charAt(temp);
                shuffled10 += char1;
            }
            shuffledMessage += shuffled10;
        }
        return shuffledMessage;
    }
    
    public static String reOrder(String key,String message){
        String string10;
        String reOrdered10;
        String reOrderedMessage = "";
        String newReOrderedMassage;
        ArrayList<Integer> orderList = MathOperation.createOrderlist(key);
        for(int i=0;i<message.length()-1;i+=10){
            reOrdered10 = "";
            string10 = message.substring(i,i+10);
            for(int j=0;j<10;j++){
                char char1 = string10.charAt(orderList.indexOf(j));
                reOrdered10 += char1;
            }
            reOrderedMessage += reOrdered10;
        }
        int charCount = Character.getNumericValue(reOrderedMessage.charAt(reOrderedMessage.length()-1));
        newReOrderedMassage = reOrderedMessage.substring(0,reOrderedMessage.length()-(charCount+1));
        return newReOrderedMassage;
    }

    
    
}
