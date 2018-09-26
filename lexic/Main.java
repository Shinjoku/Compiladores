import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.openFile();
        tokenizer.getNewToken();
        tokenizer.getNewToken();
        tokenizer.getNewToken();
        tokenizer.getNewToken();
        tokenizer.closeFile();
    }
}