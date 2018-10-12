import java.util.Scanner;

public class Main {
	
	private Symbol symbols = new Symbol();
	
    public static void main (String[] args) {
        
        Tokenizer tokenizer = new Tokenizer();
		Token token = new Token(null, -1);
        
        tokenizer.openFile();
		tokenizer.getNewCharacter();
        while(tokenizer.fileIsOpen() == true) {
            // System.out.println(tokenizer.getCharacter());
			token = tokenizer.getNewToken();
			if(token.getSymbol() == 1){
				System.out.println(token.getLexeme() + " Type: " + token.getSymbol());
				token = tokenizer.getNewToken();
				if(token.getSymbol() == 16){
					System.out.println(token.getLexeme() + " Type: " + token.getSymbol());
					token = tokenizer.getNewToken();
					if(token.getSymbol() == 19){
						System.out.println(token.getLexeme() + " Type: " + token.getSymbol());
						
					}
					
				}
				
			}
            //tokenizer.getCharacter();
			
        }
        tokenizer.closeFile();
    }
}