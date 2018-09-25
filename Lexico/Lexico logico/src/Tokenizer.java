import java.awt.List;
import java.util.ArrayList;

public class Tokenizer {

	public static String test = "teste de mesa.";
	private static char caracter;// local onde caracter lido fica
	private static int count = -1;
	//private List<Token> tokenList = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//enquanto não fim
		Ler();//função de leitura
		//loop final de arquivo
			while (caracter == '{' || caracter == ' ') { //ou fim de arquivo
				if (caracter == '{') {
					while (caracter != '}') {// e arquivo não acabou
						Ler();
					}
				}
				while (caracter == ' ') {
					Ler();
				}
			}
			//se não acabou
			pegarToken();
		//fim do loop final de arquivo
	}
	
	private static void pegarToken() {
		if (Character.isDigit(caracter)) {
			trataDigito();
		}
		else {
			if (Character.isLetter(caracter)) {
				trataIdentPalaReser();
			}
			else {
				if (caracter == ':') {
					trataAtribuicao();
				}
				else {
					if (caracter == '+' || caracter == '-' || caracter == '*') {
						trataOA();
					}
					else {
						if (caracter == '<' || caracter == '>' || caracter == '=') {
							trataOR();
						}
						else {
							if (caracter == ';' || caracter == ',' || caracter == '(' || caracter == '.') {
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
		num = num + caracter;
		Ler();
		while(Character.isDigit(caracter)) {
			num = num + caracter;
			Ler();
		}
		//salva simbolo do token como valor de snumero
		//salva o valor de num em token.lexema
		
	}
	
	private static void trataIdentPalaReser() {
		String id = null;
		id = id + caracter;
		Ler();
		while (Character.isDigit(caracter) || Character.isLetter(caracter) || caracter == '_') {
			id = id + caracter;
			Ler();
		}
		//salvar id em lexema e descobrir qual o simbolo é
		switch(id) {
			case "programa":
				//simbolo sprograma
				break;
			case "se":
				//simbolo sprograma
				break;
			case "entao":
				//simbolo sprograma
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
		atr = atr + caracter;
		if (caracter == ':') {
			Ler();
			if (caracter == '=') {
				atr = atr + caracter;
				//satribuição
			}
			else {
				//sdoispontos
			}
		}
	}
	
	private static void trataOA() {
		if (caracter == '+') {
			//smais
		}
		else {
			if (caracter == '-') {
				//smenos
			}
			else {
				if (caracter == '*') {
					//smult
				}
			}
		}
		Ler();
	}
	
	private static void trataOR() {
		String or = null;
		or = or + caracter;
		if (caracter == '<') {
			Ler();
			if (caracter == '=') {
				or = or + caracter;
				//smenoring
			}
			else {
				//smenor
			}
		}
		else {
			if (caracter == '>') {
				Ler();
				if (caracter == '=') {
					or = or + caracter;
					//smaioring
				}
				else {
					//smaior
				}
			}
			else {
				if (caracter == '=') {
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
		caracter = test.charAt(count);
	}
}
