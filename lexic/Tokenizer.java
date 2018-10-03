import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

class Tokenizer {
    
    // Constantes
    private final String fileName = "teste.prog";
    
    // Variaveis
    private char character;
    private boolean isReading = false;
    private Symbol symbols = new Symbol();
    private BufferedReader br;


    // Métodos
    
    public char getCharacter() {
    	return this.character;
    }
    
    public boolean fileIsOpen() {
    	return this.isReading;
    }
    
    public void openFile() {
    	FileReader fileReader;
    	
    	// Abre o arquivo para leitura
        try{
        	fileReader = new FileReader(this.fileName);
	        this.br = new BufferedReader(fileReader);
	        this.isReading = true;
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
    
    // Lê o próximo caracter do programa e atualiza a variavel da instância.
    public void getNewCharacter() {
        try {
        	
        	int res;
            res = this.br.read();
            
            if (res == -1) {
            	this.isReading = false;
            	this.character = ' ';
            }
            else
            	this.character = (char) res;
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    // Main
    public void getNewToken() {
        
        char ch;
        
		//getNewCharacter();
		// Loop final de arquivo
		while (this.character == '{' || this.character == ' ' || this.character == '\n' || this.character == '\t') { //ou fim de arquivo
			//System.out.print(this.character);
			if (this.character == '{') {
				while (this.character != '}') {// e arquivo n�o acabou
					getNewCharacter();
				}
				getNewCharacter();
			}
			while (this.character == ' ' || this.character == '\n') {
				getNewCharacter();
			}
			if(this.character == '\n'){
				System.out.print("achei fim \n");
				getNewCharacter();
			}
			if(this.character == '\t'){
				getNewCharacter();
			}
		}

		try {
			Token token = getToken();
			System.out.println(token.getLexeme() + " Type: " + token.getSymbol());
			//System.out.print(this.character + "\n");
		} catch (InvalidCharacterException e){
			getNewCharacter();
			System.out.println(e);
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
			return new Token(atr, this.symbols.stwodots);
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
		
		// Retorna um token com os dados coletados
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
				symbol = this.symbols.sread;
				break;
			case "var":
				symbol = this.symbols.svar;
				break;
			case "inteiro":
				symbol = this.symbols.sinteger;
				break;
			case "boolean":
				symbol = this.symbols.sboolean;
				break;
			case "verdadeiro":
				symbol = this.symbols.strue;
				break;
			case "falso":
				symbol = this.symbols.sfalse;
				break;
			case "procedimento":
				symbol = this.symbols.sprocedure;
				break;
			case "funcao":
				symbol = this.symbols.sfunction;
				break;
			case "div":
				symbol = this.symbols.sdiv;
				break;
			case "e":
				symbol = this.symbols.sand;
				break;
			case "ou":
				symbol = this.symbols.sor;
				break;
			case "nao":
				symbol = this.symbols.sno;
				break;
			default:
				symbol = this.symbols.sidentifier;
				break;
		}
		
		//getNewCharacter();
		return new Token(id, symbol);
	}
	
	
	private Token getToken()
		throws InvalidCharacterException {
			
		if (Character.isDigit(this.character)) {
			//System.out.print(this.character);
			return numberHandler();
		}
		else {
			if (Character.isLetter(this.character)) {
			//	System.out.print(this.character);
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
							if (this.character == ';' || this.character == ',' || this.character == '(' || this.character == '.' || this.character == ')') {
								//System.out.print(this.character);
								return punctuationHandler();
							}
							else {
								// this.isReading = false;
								if(this.character == '\n'){
									System.out.print("oi");
								}
								throw new InvalidCharacterException("No character found.");
							}
						}
					}
				}
			}
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
	
	private Token punctuationHandler()
		throws InvalidCharacterException {
		
		String punctuation = "";
		punctuation += this.character;
		
		if(this.character == ';'){
			getNewCharacter();
			return new Token(punctuation, this.symbols.ssemi_colon);
		}
			
		else if(this.character == ','){
			getNewCharacter();
			return new Token(punctuation, this.symbols.scolon);
		}
			
		else if(this.character == '.'){
			getNewCharacter();
			return new Token(punctuation, this.symbols.sdot);
		}
		
		else if(this.character == '('){
			getNewCharacter();
			return new Token(punctuation, this.symbols.sopen_parenthesis);
		}
		
		else if(this.character == ')'){
			getNewCharacter();
			return new Token(punctuation, this.symbols.sclose_parenthesis);
		}
		
		else throw new InvalidCharacterException("Missing punctuation.");
	}
	
}