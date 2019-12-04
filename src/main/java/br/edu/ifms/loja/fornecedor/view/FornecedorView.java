/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.fornecedor.view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import maruyama.components.mvc.GenericCRUDView;

/**
 *
 * @author Rodrigo
 */
public class FornecedorView extends GenericCRUDView{

    private JDialog janela;
    
    public FornecedorView(JPanel formulario) {
        super(formulario);
        janela = new JDialog();
        janela.setSize(900, 800);
        janela.setModal(true);
        janela.add(this);
        janela.setTitle("Fornecedor");
        
    }

    @Override
    public String[] configurarCamposDeBusca() {
        return new String[0];
    }
    
    public void SetVisible(boolean b){
        janela.setVisible(b);
    }
    
}
