/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cidade.view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import maruyama.components.mvc.GenericCRUDView;

/**
 *
 * @author gusta
 */
public class CidadeView extends GenericCRUDView{

    private JDialog janela; 
            
    public CidadeView(JPanel formulario) {
        super(formulario);
        janela = new JDialog();
        janela.setModal(true);
        janela.add(this);
        janela.setSize(600, 500);
        janela.setTitle("Cidade");
    }

    @Override
    public String[] configurarCamposDeBusca() {
        return new String[0];
    }
 
    @Override
    public void setVisible(boolean b){
        super.setVisible(b);
        janela.setVisible(b);
    }
}
