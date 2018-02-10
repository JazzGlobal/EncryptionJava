public class StringEncryption {
    public static void main(String[] args){
        Encryptor e = new Encryptor(20);
        System.out.println(e.getKey());
        System.out.println(e.EncryptedMessage("Hello, This is a test message!"));
    }
}
