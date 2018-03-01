
package product.cipher;

/**
 *
 * @author Prabhash
 */
public class Key {
    public static String generateKey(String enteredKey){
        String randkey = "";
        for(int i=0;i<8;i++){
            randkey += MathOperation.randomChar();
        }
    return MathOperation.xor(enteredKey,randkey);
    }
}
