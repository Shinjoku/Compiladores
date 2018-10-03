import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        
        Tokenizer tokenizer = new Tokenizer();
        
        tokenizer.openFile();
		tokenizer.getNewCharacter();
        while(tokenizer.fileIsOpen() == true) {
            // System.out.println(tokenizer.getCharacter());
			tokenizer.getNewToken();
            //tokenizer.getCharacter();
        }
        tokenizer.closeFile();
    }
}