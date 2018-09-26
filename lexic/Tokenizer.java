import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

class Tokenizer {
    
    // Constantes
    private final String fileName = "teste.prog";
    
    // Variaveis
    private char character;
    private BufferedReader br;
    private Symbol symbols;


    // Métodos
    
    public void openFile() {
    	FileReader fileReader;
    	
    	// Abre o arquivo para leitura
        try{
        	fileReader = new FileReader(this.fileName);
	        this.br = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
        	System.out.println(e);
        }
    }
    
    public void closeFile() {
    	// Fecha o arquivo
	    try{
        	this.br.close();
	    } catch(IOException e) {
	    	System.out.println(e);
	    }
    }
    
    // Main
    public void getNewToken() {
        
        char ch;
        this.symbols = new Symbol();
        
		getNewCharacter();
		// Loop final de arquivo
		while (this.character == '{' || this.character == ' ' || this.character == '}') { //ou fim de arquivo
			getNewCharacter();
		}

		try {
			getToken();
		} catch (InvalidCharacterException e){
			System.out.println(e);
		}
        
    }
    
    // Lê o próximo caracter do programa e atualiza a variavel da instância.
    //  Parâmetros: Nenhum;
    //  Retorno: Nenhum.
    private void getNewCharacter() {
        try {
            this.character = (char) this.br.read();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public Token numberHandler() {
		String num = "";
		num = num + this.character;
		getNewCharacter();
		while(Character.isDigit(this.character)) {
			num = num + this.character;
			getNewCharacter();
		}
		
		// Salva simbolo do token como valor de snumero
		// Salva o valor de num em token.lexema
		return new Token(num, this.symbols.snumber);
	}
	
	public Token identifierAndReservedWordHandler() {
		
		int symbol = 0;
		String id = "";
		id = id + this.character;
		getNewCharacter();
		
		while (Character.isDigit(this.character) || Character.isLetter(this.character) || this.character == '_') {
			id = id + this.character;
			getNewCharacter();
		}
		
		// Salvar id em lexema e descobrir qual o simbolo eh
		switch(id) {
			case "programa":
				symbol = this.symbols.sprogram;
				break;
			case "se":
				symbol = this.symbols.sif;
				break;
			case "entao":
				symbol = this.symbols.sso;
				break;
			case "senao":
				symbol = this.symbols.selse;
				break;
			case "enquanto":
				symbol = this.symbols.swhile;
				break;
			case "faca":
				symbol = this.symbols.sdo;
				break;
			case "inicio":
				symbol = this.symbols.sbegin;
				break;
			case "fim":
				symbol = this.symbols.send;
				break;
			case "escreva":
				symbol = this.symbols.swrite;
				break;
			case "leia":
				//simbolo sprograma
				symbol = this.symbols.sread;
				break;
			case "var":
				//simbolo sprograma
				symbol = this.symbols.svar;
				break;
			case "inteiro":
				//simbolo sprograma
				symbol = this.symbols.sinteger;
				break;
			case "boolean":
				//simbolo sprograma
				symbol = this.symbols.sboolean;
				break;
			case "verdadeiro":
				//simbolo sprograma
				symbol = this.symbols.strue;
				break;
			case "falso":
				//simbolo sprograma
				symbol = this.symbols.sfalse;
				break;
			case "procedimento":
				//simbolo sprograma
				symbol = this.symbols.sprocedure;
				break;
			case "funcao":
				//simbolo sprograma
				symbol = this.symbols.sfunction;
				break;
			case "div":
				//simbolo sprograma
				symbol = this.symbols.sdiv;
				break;
			case "e":
				//simbolo sprograma
				symbol = this.symbols.sand;
				break;
			case "ou":
				//simbolo sprograma
				symbol = this.symbols.sor;
				break;
			case "nao":
				//simbolo sprograma
				symbol = this.symbols.sno;
				break;
			default:
				symbol = this.symbols.sidentifier;
				break;
		}
		
		System.out.println(id + " Type: " + symbol);
		return new Token(id, symbol);
	}
	
	
	private Token getToken()
		throws InvalidCharacterException {
			
		if (Character.isDigit(this.character)) {
			return numberHandler();
		}
		else {
			if (Character.isLetter(this.character)) {
				return identifierAndReservedWordHandler();
			}
			else {
				if (this.character == ':') {
					return atributionHandler();
				}
				else {
					if (this.character == '+' || this.character == '-' || this.character == '*') {
						return arithmeticOperatorHandler();
					}
					else {
						if (this.character == '<' || this.character == '>' || this.character == '=') {
							return relationalOperatorHandler();
						}
						else {
							if (this.character == ';' || this.character == ',' || this.character == '(' || this.character == '.') {
								return trataPontuacao();
							}
							else {
								throw new InvalidCharacterException("No character found.");
							}
						}
					}
				}
			}
		}
	}
	
	
	private Token atributionHandler() {
		String atr = "";
		atr += this.character;
		getNewCharacter();
		
		if (this.character == '=') {
			atr = atr + this.character;
			getNewCharacter();
			return new Token(atr, this.symbols.satribution);
		}
		else {
			getNewCharacter();
			return new Token(atr, this.symbols.stwodots);
		}
	}
	
	private Token arithmeticOperatorHandler()
		throws InvalidCharacterException {
			
		String operator = "";
		operator += this.character;
		
		if (this.character == '+') {
			//smais
			getNewCharacter();
			return new Token(operator, this.symbols.splus);
		}
		else {
			if (this.character == '-') {
				//smenos
				getNewCharacter();
				return new Token(operator, this.symbols.sminus);
			}
			else {
				if (this.character == '*') {
					//smult
					getNewCharacter();
					return new Token(operator, this.symbols.smult);
				}
				else{
					throw new InvalidCharacterException("Missing arithmetic operator.");
				}
			}
		}
	}
	
	private Token relationalOperatorHandler()
		throws InvalidCharacterException {
			
		String operator = "";
		operator += this.character;
		
		if (this.character == '<') {
			getNewCharacter();
			if (this.character == '=') {
				operator = operator + this.character;
				//smenoring
				getNewCharacter();
				return new Token(operator, this.symbols.slessereq);
			}
			else {
				//smenor
				getNewCharacter();
				return new Token(operator, this.symbols.slesser);
			}
		}
		else {
			if (this.character == '>') {
				getNewCharacter();
				if (this.character == '=') {
					operator = operator + this.character;
					//smaioring
					getNewCharacter();
					return new Token(operator, this.symbols.sgreatereq);
				}
				else {
					//smaior
					getNewCharacter();
					return new Token(operator, this.symbols.sgreater);
				}
			}
			else {
				if (this.character == '=') {
					//sig
					getNewCharacter();
					return new Token(operator, this.symbols.sequal);
				}
				else {
					throw new InvalidCharacterException("Missing relational operator.");
				}
			}
		}
	}
	
	private Token trataPontuacao()
		throws InvalidCharacterException {
		
		String punctuation = "";
		punctuation += this.character;
		
		if(this.character == ';')
			return new Token(punctuation, this.symbols.ssemi_colon);
		else if(this.character == ',')
			return new Token(punctuation, this.symbols.scolon);
		else if(this.character == '.')
			return new Token(punctuation, this.symbols.sdot);
		else throw new InvalidCharacterException("Missing punctuation.");
	}
	
}