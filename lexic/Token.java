
public class Token {
	private static int id = 0;
	private int symbol;
	private String lexeme;
	
	public Token(String lexeme, int symbol) {
		this.id++;
		this.lexeme = lexeme;
		this.symbol = symbol;
	}
	
	public String getLexeme() {
		return this.lexeme;
	}
	
	public Integer getSymbol() {
		return this.symbol;
	}
}
