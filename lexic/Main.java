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
		comands_Analyze();
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
	
	//------------------------Comands Analyze-------------------------//
	private static void comands_Analyze(){
		if(token.getSymbol() == symbols.sbegin){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken(); 
			simple_Comands_Analyze();
			while(token.getSymbol() != symbols.send){
				if(token.getSymbol() == symbols.ssemi_colon){
					System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
					token = tokenizer.getNewToken(); 
					if(token.getSymbol() != symbols.send){
						simple_Comands_Analyze();
					}
				}
				else{
					System.out.println("ERRO Comands analyze 1");
				}
			}
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken(); 
		}
		else{
			System.out.println("ERRO Comands analyze 2");
		}
	}
	
	private static void simple_Comands_Analyze(){
		int valor;
		
		valor = token.getSymbol();
		
		switch(valor){
			case 16:
				atribute_Chprocidure_Analyze();
				break;
			case 5:
				if_Analyze();
				break;
			case 8:
				while_Analyze();
				break;
			case 12:
				read_Analyze();
				break;
			case 11:
				write_Analyze();
				break;
			default:
				comands_Analyze();
				break;
		}
	}
	
	//------------------------------Atribute Chprocidure-------------------------------------//
	private static void atribute_Chprocidure_Analyze(){
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken(); 
		if(token.getSymbol() == symbols.satribution){
			//atribuição analise
		}
		else{
			//chamada procedimento
		}
	}
	
	//--------------------------------IF----------------------------------------------//
	private static void if_Analyze(){
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken();
		expression_Analyze();
		if(token.getSymbol() == symbols.sso){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken();
			simple_Comands_Analyze();
			if(token.getSymbol() == symbols.selse){
				System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
				token = tokenizer.getNewToken();
				simple_Comands_Analyze();
			}
		}
		else{
			System.out.println("ERRO IF");
		}
	}
	
	//--------------------------------WHILE------------------------------------------//
	private static void while_Analyze(){
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken();
		expression_Analyze();
		if(token.getSymbol() == symbols.sdo){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken();
			simple_Comands_Analyze();
		}
		else{
			System.out.println("ERRO While");
		}
	}
	
	//-------------------------------Expression Analyze---------------------------------//
	private static void expression_Analyze(){
		simple_Expression_Analyze();
		if((token.getSymbol() == symbols.sgreater) || (token.getSymbol() == symbols.sgreatereq) || (token.getSymbol() == symbols.sequal) || (token.getSymbol() == symbols.slesser) || (token.getSymbol() == symbols.slessereq) || (token.getSymbol() == symbols.sdif)){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken();
			simple_Expression_Analyze();
		}
	}
	
	//--------------------------------Simples Expression-------------------------------//
	private static void simple_Expression_Analyze(){
		if((token.getSymbol() == symbols.sgreater) || (token.getSymbol() == symbols.slesser)){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken();
			term_Analyze();
			while((token.getSymbol() == symbols.sgreater) || (token.getSymbol() == symbols.slesser) || (token.getSymbol() == symbols.sor)){
				System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
				token = tokenizer.getNewToken();
				term_Analyze();
			}
		}
	}
	
	//-------------------------------Termo-----------------------------------------------//
	private static void term_Analyze(){
		fact_Analyze();
		while((token.getSymbol() == symbols.smult) || (token.getSymbol() == symbols.sdiv) || (token.getSymbol() == symbols.sif)){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken();
			fact_Analyze();
		}
	}
	
	//--------------------------------Factor-----------------------------------------------//
	private static void fact_Analyze(){
		if(token.getSymbol() == symbols.sidentifier){
			//chamada de função
		}
		else{
			if(token.getSymbol() == symbols.snumber){
				System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
				token = tokenizer.getNewToken();
			}
			else{
				if(token.getSymbol() == symbols.sno){
					System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
					token = tokenizer.getNewToken();
					fact_Analyze();
				}
				else{
					if(token.getSymbol() == symbols.sopen_parenthesis){
						System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
						token = tokenizer.getNewToken();
						expression_Analyze();
						if(token.getSymbol() == symbols.sclose_parenthesis){
							System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
							token = tokenizer.getNewToken();
						}
						else{
							System.out.println("ERRO Fact 1");
						}
					}
					else{
						if((token.getSymbol() == symbols.strue) || (token.getSymbol() == symbols.sfalse)){
							System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
							token = tokenizer.getNewToken();
						}
						else{
							System.out.println("ERRO Fact 2");
						}
					}
				}
			}
		}
	}
	
	//-----------------------------------READ------------------------------------------------//
	private static void read_Analyze(){
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken(); 
		if(token.getSymbol() == symbols.sopen_parenthesis){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken(); 
			if(token.getSymbol() == symbols.sidentifier){
				System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
				token = tokenizer.getNewToken();
				if(token.getSymbol() == symbols.sclose_parenthesis){
					System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
					token = tokenizer.getNewToken(); 
				}
				else{
					System.out.println("ERRO Read 1");
				}
			}
			else{
				System.out.println("ERRO Read 2");
			}
		}
		else{
			System.out.println("ERRO Read 3");
		}
	}
	
	//----------------------------WRITE--------------------------------------------//
	private static void write_Analyze(){
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken();
		if(token.getSymbol() == symbols.sopen_parenthesis){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken(); 
			if(token.getSymbol() == symbols.sidentifier){
				System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
				token = tokenizer.getNewToken();
				if(token.getSymbol() == symbols.sclose_parenthesis){
					System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
					token = tokenizer.getNewToken(); 
				}
				else{
					System.out.println("ERRO Write 1");
				}
			}
			else{
				System.out.println("ERRO Write 2");
			}
		}
		else{
			System.out.println("ERRO Write 3");
		}
	}
}