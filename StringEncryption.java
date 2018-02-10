public class StringEncryption {
    public static void main(String[] args){
        Encryptor e = new Encryptor(20);
        System.out.println(e.getKey());
        //System.out.println(e.EncryptedMessage("hey guys nick here im  a weak nigga that likes music and shit. go listen to the fire down"));
        System.out.println(e.EncryptedMessage("chris is a gay retatattatata"));
    }
}
