import java.util.Scanner;

public class Main {
	
	
    public static void main (String[] args) {
	    
	    Symbol symbols = new Symbol();
        
        Tokenizer tokenizer = new Tokenizer();
		Token token;
        
        tokenizer.openFile();
		tokenizer.getNewCharacter();
        while( tokenizer.fileIsOpen() ) {
            // System.out.println(tokenizer.getCharacter());
			token = tokenizer.getNewToken();
			if(token.getSymbol() == symbols.sprogram){
			    
				System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
				token = tokenizer.getNewToken();
				
				if(token.getSymbol() == symbols.sidentifier){
					System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
					token = tokenizer.getNewToken();
					
					if(token.getSymbol() == symbols.ssemi_colon){
						System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
						
					}
					
				}
				
			}
            //tokenizer.getCharacter();
			
        }
        tokenizer.closeFile();
    }
}