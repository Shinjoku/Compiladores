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
public class CompiladorUI extends javax.swing.JFrame {

    private static Symbol symbols;
    private static Tokenizer tokenizer = new Tokenizer();
    private static Token token;
    /**
     * Creates new form CompiladorUI
     */
    public CompiladorUI() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CodePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CodeArea = new javax.swing.JTextArea();
        ErrorPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ErrorArea = new javax.swing.JTextArea();
        StartButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CodePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Área de Código", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        CodeArea.setColumns(20);
        CodeArea.setRows(5);
        jScrollPane1.setViewportView(CodeArea);

        javax.swing.GroupLayout CodePanelLayout = new javax.swing.GroupLayout(CodePanel);
        CodePanel.setLayout(CodePanelLayout);
        CodePanelLayout.setHorizontalGroup(
            CodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CodePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );
        CodePanelLayout.setVerticalGroup(
            CodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CodePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        ErrorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Erros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        ErrorArea.setEditable(false);
        ErrorArea.setColumns(20);
        ErrorArea.setRows(5);
        jScrollPane2.setViewportView(ErrorArea);

        javax.swing.GroupLayout ErrorPanelLayout = new javax.swing.GroupLayout(ErrorPanel);
        ErrorPanel.setLayout(ErrorPanelLayout);
        ErrorPanelLayout.setHorizontalGroup(
            ErrorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );
        ErrorPanelLayout.setVerticalGroup(
            ErrorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        StartButton.setText("Iniciar");
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CodePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(ErrorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(StartButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CodePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ErrorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StartButton)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
        // TODO add your handling code here:
        //sintatic_Analyze();
        int i =1, ln = 1;
        tokenizer.setCount(0,0);
        tokenizer.setFile(CodeArea.getText());
        System.out.println(CodeArea.getText().length());
        sintatic_Analyze();
    }//GEN-LAST:event_StartButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompiladorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompiladorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompiladorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompiladorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompiladorUI().setVisible(true);
            }
        });
    }
    
    private void sintatic_Analyze(){
        
        tokenizer.getNewCharacter();
        symbols = new Symbol();
		
        try {
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
                                                        System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
                                                        token = tokenizer.getNewToken();               
                                                            if(token.getSymbol() == symbols.sclose_file){
									System.out.println("The compilation was a success!");
									tokenizer.fileClose();
									break;
								}
                                                            else throw new InvalidTokenException("Error 1: Wrong dot before '" + tokenizer.getCharacter() + "', on line " + tokenizer.getLineCounter());
                                                    }
                                                    else throw new InvalidTokenException("Error 2: Missing dot before '" + tokenizer.getCharacter() + "', on line " + tokenizer.getLineCounter());
                                            }
                                            else throw new InvalidTokenException("Error 3: Missing semi colon before '" + tokenizer.getCharacter() + "', on line " + tokenizer.getLineCounter());
                                    }
                                    else throw new InvalidTokenException("Error 4: Missing identifier on line " + (tokenizer.getLineCounter() - 1) );
                            }
                            else throw new InvalidTokenException("Error 5: Missing keyword 'program' on line " + tokenizer.getLineCounter());
            }

            if(!tokenizer.fileIsOpen())
                    ErrorArea.setText("\n Analise Terminada\n");
        } catch(InvalidTokenException e) {
            ErrorArea.setText("SYNTATIC> " + e.getMessage());
            System.out.println("SYNTATIC> " + e.getMessage() );
        }
    }
    
    //-----------------Block---------------------//
	private static void block_Analyze() throws InvalidTokenException {
		try {
			token = tokenizer.getNewToken();
			variable_Et_Analyze();
			subroutines_Analyze();
			comands_Analyze();
		} catch(InvalidTokenException e) {
			throw new InvalidTokenException(e.getMessage());
		}
	}
	
	//--------------Varible Declration-----------------//
	private static void variable_Et_Analyze() throws InvalidTokenException {
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
					else throw new InvalidTokenException("Error 6: Expected ';' before '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
				}
			}
			else throw new InvalidTokenException("Error 7: Expected an identifier before " + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
		}
	}
	
	//------------------------------Variable------------------------------//
	private static void variable_Analyze() throws InvalidTokenException {
		do{
			if(token.getSymbol() == symbols.sidentifier){
				System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
				token = tokenizer.getNewToken();
				
				if((token.getSymbol() == symbols.scolon) || (token.getSymbol() == symbols.stwodots)){
					if(token.getSymbol() == symbols.scolon) {
						System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
						token = tokenizer.getNewToken();
						if(token.getSymbol() == symbols.stwodots){
							throw new InvalidTokenException("Error 8: Unexpected" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
						}
					}
				}
				else{
					throw new InvalidTokenException("Error 9: Expected ':' or ',' before '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
				}
			}
			else{
				throw new InvalidTokenException("Error 10: Unexpected identifier '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
			}
		} while(!(token.getSymbol() == symbols.stwodots));
		
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken();
		type_Analyze();
	}
	
	//-----------------------------Type--------------------------------//
	private static void type_Analyze() throws InvalidTokenException {
		if(!(token.getSymbol() == symbols.sinteger) && !(token.getSymbol() == symbols.sboolean)){
			throw new InvalidTokenException("Error 11: Invalid type name '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
		}
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken();
	}
	
	//---------------------------SubRotinas--------------------------------//
	private static void subroutines_Analyze() throws InvalidTokenException {
		while((token.getSymbol() == symbols.sprocedure) || (token.getSymbol() == symbols.sfunction)){
			
			if(token.getSymbol() == symbols.sprocedure){
				procedure_Analyze();
			}
			else {
				fuction_Analyze();
			}
			
			if(token.getSymbol() == symbols.ssemi_colon){
				System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
				token = tokenizer.getNewToken(); 
			}
			else throw new InvalidTokenException("Error 12: Expected ';' before '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
		}
	}
	
	//---------------------------Procedure Analyze-------------------------//
	private static void procedure_Analyze() throws InvalidTokenException {
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken();
		
		if(token.getSymbol() == symbols.sidentifier){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken(); 
			if(token.getSymbol() == symbols.ssemi_colon){
				block_Analyze();
			}
			else throw new InvalidTokenException("Error 13: Expected ';' before '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
		}
		else throw new InvalidTokenException("Error 14: Expected an identifier before '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
	}
	
	//-----------------------Function Analyze------------------------//
	private static void fuction_Analyze() throws InvalidTokenException {
		
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
					else throw new InvalidTokenException("Error 15: Expected ';' instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
				}
				else throw new InvalidTokenException("Error 16: Expected 'inteiro' or 'booleano' instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
			}
			else throw new InvalidTokenException("Error 17: Expected ':' instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
		}
		else throw new InvalidTokenException("Error 18: Expected an identifier instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
	}
	
	//------------------------Comands Analyze-------------------------//
	private static void comands_Analyze() throws InvalidTokenException {
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
				else throw new InvalidTokenException("Error 19: Expected ';' instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
			}
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken(); 
		}
		else throw new InvalidTokenException("Error 20: Keywords 'inicio' or 'var' expected instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
	}
	
	//----------------------------Comandos Simples---------------------------------//
	private static void simple_Comands_Analyze() throws InvalidTokenException {
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
	private static void atribute_Chprocidure_Analyze() throws InvalidTokenException {
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken(); 
		if(token.getSymbol() == symbols.satribution){
			atribute_Analyze();
		}
		else{
			//chamada procedimento - no momento não faz nada, só no semantico
		}
	}
	
	//---------------------------------Atributo Analyze---------------------------------//
	private static void atribute_Analyze() throws InvalidTokenException {
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken();
		expression_Analyze();
	}
	
	//--------------------------------IF----------------------------------------------//
	private static void if_Analyze() throws InvalidTokenException {
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
		else throw new InvalidTokenException("Error 21: Expected keyword 'entao' instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
	}
	
	//--------------------------------WHILE------------------------------------------//
	private static void while_Analyze() throws InvalidTokenException {
		System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
		token = tokenizer.getNewToken();
		expression_Analyze();
		if(token.getSymbol() == symbols.sdo){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken();
			simple_Comands_Analyze();
		}
		else throw new InvalidTokenException("Error 18: Expected keyword 'faca' instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
	}
	
	//-------------------------------Expression Analyze---------------------------------//
	private static void expression_Analyze() throws InvalidTokenException {
		simple_Expression_Analyze();
		if((token.getSymbol() == symbols.sgreater) || (token.getSymbol() == symbols.sgreatereq) || (token.getSymbol() == symbols.sequal) || (token.getSymbol() == symbols.slesser) || (token.getSymbol() == symbols.slessereq) || (token.getSymbol() == symbols.sdif)){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken();
			simple_Expression_Analyze();
		}
	}
	
	//--------------------------------Simples Expression-------------------------------//
	private static void simple_Expression_Analyze() throws InvalidTokenException {
		if((token.getSymbol() == symbols.splus) || (token.getSymbol() == symbols.sminus)){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken();
		}
		term_Analyze();
			while((token.getSymbol() == symbols.splus) || (token.getSymbol() == symbols.sminus) || (token.getSymbol() == symbols.sor)){
				System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
				token = tokenizer.getNewToken();
				term_Analyze();
			}
	}
	
	//-------------------------------Termo-----------------------------------------------//
	private static void term_Analyze() throws InvalidTokenException {
		fact_Analyze();
		while((token.getSymbol() == symbols.smult) || (token.getSymbol() == symbols.sdiv) || (token.getSymbol() == symbols.sand)){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken();
			fact_Analyze();
		}
	}
	
	//--------------------------------Factor-----------------------------------------------//
	private static void fact_Analyze() throws InvalidTokenException {
		if(token.getSymbol() == symbols.sidentifier){
			System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
			token = tokenizer.getNewToken();
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
						else throw new InvalidTokenException("Error 22: Expected keychar ')' instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
					}
					else{
						if((token.getSymbol() == symbols.strue) || (token.getSymbol() == symbols.sfalse)){
							System.out.println("SYNTATIC> " + token.getLexeme() + " Type: " + token.getSymbol());
							token = tokenizer.getNewToken();
						}
						else throw new InvalidTokenException("Error 23: Expected 'verdadeiro' or 'falso' instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
					}
				}
			}
		}
	}
	
	//-----------------------------------READ------------------------------------------------//
	private static void read_Analyze() throws InvalidTokenException {
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
				else throw new InvalidTokenException("Error 24: Expected keychar ')' instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
			}
			else throw new InvalidTokenException("Error 25: Expected an identifier instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
		}
		else throw new InvalidTokenException("Error 26: Expected keychar '(' instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
	}
	
	//----------------------------WRITE--------------------------------------------//
	private static void write_Analyze() throws InvalidTokenException {
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
				else throw new InvalidTokenException("Error 27: Expected keychar ')' instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
			}
			else throw new InvalidTokenException("Error 28: Expected an identifier instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
		}
		else throw new InvalidTokenException("Error 18: Expected keychar '(' instead of '" + token.getLexeme() + "', on line " + tokenizer.getLineCounter());
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea CodeArea;
    private javax.swing.JPanel CodePanel;
    private static javax.swing.JTextArea ErrorArea;
    private javax.swing.JPanel ErrorPanel;
    private javax.swing.JButton StartButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
