/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class GUI {

    /**
     * @param args the command line arguments
     */
    private static String [] colunsNames = {"ID", "Comando", "Entrada 1", "Entrada 2"};
    
    private static int cntColum = 0;
    
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
        tela.row(data);
        /*
        depois de criar e preencher a tabela na frame são adicionados dois listeners
        um para o botão continuar que começa a ler até achar um break,
        e um que percebe quando a tabela é modificada, ou seja, um break é criado.
        */
        //Listener do botão
        tela.ContButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                readTable(tela);
            }
        });
        //Listener da criação de Breaks/checkboxes
        tela.tableComandos.getModel().addTableModelListener((tme) -> {
            DefaultTableModel model = (DefaultTableModel) tela.tableComandos.getModel();
            //vericica qual linha foi altera
            int rowSelect = tela.tableComandos.getSelectedRow();
            //verifica qual foi a alteração
            boolean effect = (Boolean)model.getValueAt(rowSelect, 4);
            if(effect){
                tela.breakAdd(rowSelect);
            }
            else{
                tela.breakRemove(rowSelect);
            }
            
        });
        
        //tela.entradaPopup();
        
        tela.setVisible(true);
        //tela.getTable().getModel().setValueAt(data[0][0],0,0);
    }
    
    public static void readTable(GUINovo tela){
        boolean breakPoint = false, find = false;
        Object input = null;
        DefaultTableModel model = (DefaultTableModel) tela.tableComandos.getModel();
        for(;model.getColumnCount() >= cntColum; cntColum++){
            breakPoint = (Boolean)model.getValueAt(cntColum, 4);
            if(breakPoint){
                 find = true;
                 break;
            }
            if(Objects.equals(model.getValueAt(cntColum, 1), "SUM")){
                input = JOptionPane.showInputDialog("Entre os dados desejados");
                System.out.println("gui.GUI.readTable()"+input);
            }
            else{
                System.out.println("gui.GUI.readTable()"+(String)model.getValueAt(cntColum, 1));
            }
                    /*
                    lê os comandos aqui
                    */            
        }
                //reeinicia contador
        if(!find){
            System.out.println("\n");
            cntColum =0;
        }
        else{
            cntColum ++;
        }
    }
    
}
