import java.util.ArrayList;
import java.util.Random;

public class Encryptor {

    private static Random random = new Random();
    private String Key;

    public String getKey(){
        return Key;
    }
    public Encryptor(int digits){
        Key = CreateKey(digits);
    }
    public Encryptor(String key){
        Key = key;
    }
    public String EncryptedMessage(String message){
        ArrayList<Character> characters = new ArrayList<>();
        for(char c : message.toCharArray()){
            characters.add(c);
        }
        return Encrypt(characters,Key);
    }
    public String Encrypt(ArrayList<Character> characters, String key){
        //Iterate through message:
        //Given key '1234'.
        //Given message 'Hello World'
        //Return 'hleolw rodl';

        //Encryption Rules:
        //If Key[n] is even. Move CharacterInMessage[i] two spaces forward. If the character would be moved past the end of the message,
        //Place it at the beginning.

        //If Key[n] is odd. Move CharacterInMessage[i] one space backward. If the character would be moved past the beginning of the message.
        //Place it at the beginning.

        int i = 0;
        int x = 0;
        while(i < characters.size() - 1){
            if(x == key.length()){
                x = 0;
            }
            if(isEven(Integer.parseInt(Character.toString(key.charAt(x))))){
                char c = characters.get(i);
                characters.remove(i);
                if(i + 2 > characters.size()){
                    characters.add(0,c);
                }
                else{
                    characters.add(i + 2,c);
                }
            }
            else{
                char c = characters.get(i);
                characters.remove(i);
                if(i - 1 < 0){
                    characters.add(0, c);
                }
                else{
                    characters.add(i - 1, c);

                }
            }
            x++;
            i++;
        }
        String str = "";
        for(char c: characters){
            str += c;
        }
        System.out.println(str);
        return str;

    }
    public String Decrypt(String message, int key){
        return "";
    }
    private String CreateKey(int digits){
        String empty = "";
        int x = random.nextInt(9) + 1;
        empty = empty.concat(Integer.toString(x));
        digits--;
        return CreateKey(digits,empty);
    }
    private String CreateKey(int digits, String str){
        if(digits == 0){
            return str;
        }
        int x = random.nextInt(9) + 1;
        str += Integer.toString(x);
        digits--;
        return CreateKey(digits,str);
    }
    private boolean isEven(int num){
        String str = Integer.toBinaryString(num);
        if(str.charAt(str.length() - 1) == '0'){
            return true;
        }
        else{
            return false;
        }
    }

}
