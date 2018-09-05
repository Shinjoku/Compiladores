/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe
 */
public class GUI {

    /**
     * @param args the command line arguments
     */
    private static String [] colunsNames = {"ID", "Comando", "Entrada 1", "Entrada 2"};
    
    private static Object [][] data = {
        {1, "ADD", "1", "2"},
        {2, "SUM", "2", ""},
        {3, "MOV", "", ""},
        {4, "MOV2", "", ""},
        {5, "ADD", "3", "5"},
        {6, "ADD", "7", "8"}
    };
    
    public static void main(String[] args) {
        // TODO code application logic here
        //new my.mvgui.MVGUI().setVisible(true);
        
        GUINovo tela = new GUINovo();
        System.out.println(tela.getTable().getRowCount());
        tela.row(data);
        //tela.entradaPopup();
        tela.wait();
        tela.setVisible(true);
        readTable(tela);
        //tela.getTable().getModel().setValueAt(data[0][0],0,0);
    }
    
    public static void readTable(GUINovo tela){
        int cntColum;
        boolean breakPoint = false;
        DefaultTableModel model = (DefaultTableModel) tela.tableComandos.getModel();
        for(cntColum = 0; model.getColumnCount() >= cntColum; cntColum++){
            breakPoint = (Boolean)model.getValueAt(cntColum, 4);
            if(breakPoint){
                System.out.println("Break Point Acionado");
            }
            System.out.println("gui.GUI.readTable()"+(String)model.getValueAt(cntColum, 1));
            /*
            lê os comandos aqui
            */            
        }
    }
    
}
