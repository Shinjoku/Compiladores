import java.util.Scanner;

public class Main {
	
	private static Symbol symbols = new Symbol();
        
    private static Tokenizer tokenizer = new Tokenizer();
	private static Token token;
	
    public static void main (String[] args) {
        
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
						block_Analyze();
						if(token.getSymbol() == symbols.sdot){
							if(!tokenizer.fileIsOpen()){
								System.out.println("Sintativo lido com sucesso");
							}
							else{
								System.out.println("ERROR main 1");
								break;
							}
						}
						System.out.println("ERROR main 2");
						break;
					}
					System.out.println("ERROR main 3");
					break;
				}
				System.out.println("ERROR main 4");
				break;
			}
			System.out.println("ERROR main 5");
			break;
            //tokenizer.getCharacter();
			
        }
        tokenizer.closeFile();
    }
	
	//-----------------Block---------------------//
	private static void block_Analyze(){
		token = tokenizer.getNewToken();
		variable_Et_Analyze();
		subroutines_Analyze();
		//comandos
	}
	
	//--------------Varible Declration-----------------//
	private static void variable_Et_Analyze(){
		if(token.getSymbol() == symbols.svar){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken();
			if(token.getSymbol() == symbols.sidentifier){
				while(token.getSymbol() == symbols.sidentifier){
					variable_Analyze();
					if(token.getSymbol() == symbols.ssemi_colon){
						System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
						token = tokenizer.getNewToken();
					}
					else{
						System.out.println("ERROR et_var 1");
						break;
					}
				}
			}
			else{
				System.out.println("ERROR et_var 2");
			}
		}
	}
	
	//------------------------------Variable------------------------------//
	private static void variable_Analyze(){
		do{
			if(token.getSymbol() == symbols.sidentifier){
				System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
				token = tokenizer.getNewToken();
				if((token.getSymbol() == symbols.scolon) || (token.getSymbol() == symbols.stwodots)){
					if(token.getSymbol() == symbols.scolon){
						System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
						token = tokenizer.getNewToken();
						if(token.getSymbol() == symbols.stwodots){
							System.out.println("ERROR var 1");
							break;
						}
					}
					else{
					}
				}
				else{
					System.out.println("ERROR var 2");
					break;
				}
			}
			else{
				System.out.println("ERROR var 3");
				break;
			}
		}while(!(token.getSymbol() == symbols.stwodots));
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken();
		type_Analyze();
	}
	
	//-----------------------------Type--------------------------------//
	private static void type_Analyze(){
		if(!(token.getSymbol() == symbols.sinteger) && !(token.getSymbol() == symbols.sboolean)){
			System.out.println("ERROR type 1");
		}
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken();
	}
	
	//---------------------------SubRotinas--------------------------------//
	private static void subroutines_Analyze(){
		while((token.getSymbol() == symbols.sprocedure) || (token.getSymbol() == symbols.sfunction)){
			if(token.getSymbol() == symbols.sprocedure){
				procedire_Analyze();
			}
			else{
				fuction_Analyze();
			}
			if(token.getSymbol() == symbols.ssemi_colon){
				System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
				token = tokenizer.getNewToken(); 
			}
			else{
				System.out.println("ERRO subrotinas 1");
			}
		}
	}
	
	//---------------------------Procedure Analyze-------------------------//
	private static void procedire_Analyze(){
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken(); 
		if(token.getSymbol() == symbols.sidentifier){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken(); 
			if(token.getSymbol() == symbols.ssemi_colon){
				block_Analyze();
			}
			else{
				System.out.println("ERRO Procedure Analyze 1");
			}
		}
		else{
			System.out.println("ERRO Procedure Analyze 2");
		}
	}
	
	//-----------------------Function Analyze------------------------//
	private static void fuction_Analyze(){
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken(); 
		if(token.getSymbol() == symbols.sidentifier){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken(); 
			if(token.getSymbol() == symbols.stwodots){
				System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
				token = tokenizer.getNewToken(); 
				if((token.getSymbol() == symbols.sinteger) || (token.getSymbol() == symbols.sboolean)){
					System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
					token = tokenizer.getNewToken(); 
					if(token.getSymbol() == symbols.ssemi_colon){
						block_Analyze();
					}
					else{
						System.out.println("ERRO Function Analyze 1");
					}
				}
				else{
					System.out.println("ERRO Function Analyze 2");
				}
			}
			else{
				System.out.println("ERRO Function Analyze 3");
			}
		}
		else{
			System.out.println("ERRO Function Analyze 4");
		}
	}
}