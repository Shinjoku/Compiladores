import java.awt.List;
import java.util.ArrayList;

public class Tokenizer {

	public static String test = "teste de mesa.";
	private static char caracter;// local onde caracter lido fica
	private static int count = -1;
	//private List<Token> tokenList = new ArrayList<>();
	
	public static void main(String[] args) {
		// Enquanto nao fim
		getCharacter();	//funcao de leitura
		// Loop final de arquivo
			while (this.caracter == '{' || this.caracter == ' ') { //ou fim de arquivo
				if (this.caracter == '{') {
					while (this.caracter != '}') {// e arquivo n�o acabou
						Ler();
					}
				}
				while (this.caracter == ' ') {
					Ler();
				}
			}
			//se nao acabou
			pegarToken();
		//fim do loop final de arquivo
	}
	
	private static void pegarToken() {
		if (Character.isDigit(this.caracter)) {
			trataDigito();
		}
		else {
			if (Character.isLetter(this.caracter)) {
				trataIdentPalaReser();
			}
			else {
				if (this.caracter == ':') {
					trataAtribuicao();
				}
				else {
					if (this.caracter == '+' || this.caracter == '-' || this.caracter == '*') {
						trataOA();
					}
					else {
						if (this.caracter == '<' || this.caracter == '>' || this.caracter == '=') {
							trataOR();
						}
						else {
							if (this.caracter == ';' || this.caracter == ',' || this.caracter == '(' || this.caracter == '.') {
								trataPontuacao();
							}
							else {
								//ERRO
							}
						}
					}
				}
			}
		}
	}

	private static void trataDigito() {
		String num = null;
		num = num + this.caracter;
		Ler();
		while(Character.isDigit(this.caracter)) {
			num = num + this.caracter;
			Ler();
		}
		// Salva simbolo do token como valor de snumero
		// Salva o valor de num em token.lexema
	}
	
	private static void trataIdentPalaReser() {
		String id = null;
		id = id + this.caracter;
		Ler();
		while (Character.isDigit(this.caracter) || Character.isLetter(this.caracter) || this.caracter == '_') {
			id = id + this.caracter;
			Ler();
		}
		// Salvar id em lexema e descobrir qual o simbolo �
		switch(id) {
			case "programa":
				// Simbolo sprograma
				break;
			case "se":
				// Simbolo sprograma
				break;
			case "entao":
				// Simbolo sprograma
				break;
			case "senao":
				//simbolo sprograma
				break;
			case "enquanto":
				//simbolo sprograma
				break;
			case "faca":
				//simbolo sprograma
				break;
			case "inicio":
				//simbolo sprograma
				break;
			case "fim":
				//simbolo sprograma
				break;
			case "escreva":
				//simbolo sprograma
				break;
			case "leai":
				//simbolo sprograma
				break;
			case "var":
				//simbolo sprograma
				break;
			case "inteiro":
				//simbolo sprograma
				break;
			case "boolean":
				//simbolo sprograma
				break;
			case "verdadeiro":
				//simbolo sprograma
				break;
			case "falso":
				//simbolo sprograma
				break;
			case "procedimento":
				//simbolo sprograma
				break;
			case "funcao":
				//simbolo sprograma
				break;
			case "div":
				//simbolo sprograma
				break;
			case "e":
				//simbolo sprograma
				break;
			case "ou":
				//simbolo sprograma
				break;
			case "nao":
				//simbolo sprograma
				break;
			default:
				//simbolo sidentificador
				break;
		}
		
	}
	
	private static void trataAtribuicao() {
		String atr = null;
		atr = atr + this.caracter;
		if (this.caracter == ':') {
			Ler();
			if (this.caracter == '=') {
				atr = atr + this.caracter;
				//satribuicao
			}
			else {
				//sdoispontos
			}
		}
	}
	
	private static void trataOA() {
		if (this.caracter == '+') {
			//smais
		}
		else {
			if (this.caracter == '-') {
				//smenos
			}
			else {
				if (this.caracter == '*') {
					//smult
				}
			}
		}
		Ler();
	}
	
	private static void trataOR() {
		String or = null;
		or = or + this.caracter;
		if (this.caracter == '<') {
			Ler();
			if (this.caracter == '=') {
				or = or + this.caracter;
				//smenoring
			}
			else {
				//smenor
			}
		}
		else {
			if (this.caracter == '>') {
				Ler();
				if (this.caracter == '=') {
					or = or + this.caracter;
					//smaioring
				}
				else {
					//smaior
				}
			}
			else {
				if (this.caracter == '=') {
					//sig
					Ler();
				}
			}
		}
	}
	
	private static void trataPontuacao() {
		
	}
	
	private static void Ler() {
		count ++;
		this.caracter = test.charAt(count);
	}
}
