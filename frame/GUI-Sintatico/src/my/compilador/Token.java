/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.compilador;

/**
 *
 * @author Felipe
 */

public class Token {
	private int symbol;
	private String lexeme;
	
	public Token(String lexeme, int symbol) {
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

