/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cliente.bo;

import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.cliente.datamodel.Cliente;
import br.edu.ifms.loja.cliente.view.ClienteView;
import br.edu.ifms.loja.cliente.view.FormCliente;
import br.edu.ifms.loja.uf.datamodel.Uf;

import javax.swing.JPanel;
import javax.swing.text.View;
import maruyama.components.mvc.GenericCRUDController;
import maruyama.components.mvc.GenericCRUDModel;
import maruyama.components.mvc.GenericCRUDView;

/**
 *
 * @author Rodrigo
 */
public class ClienteController extends GenericCRUDController<Cliente>{

    private ClienteView view;
    private ClienteBO model;
    
    
    public ClienteController(GenericCRUDModel model, GenericCRUDView view) {
        super(model, view);
        this.view = (ClienteView) view;
        this.model = (ClienteBO) model;
        carregarUFs();
        inicializarAcoesComboBox();
    }
    
    public void inicializarAcoesComboBox() {
        FormCliente form = (FormCliente) view.getFormulario();
        form.getComboUf().addActionListener((evt) -> {
            carregarCidades();
        });
    }

    public void carregarUFs() {
        FormCliente form = (FormCliente) view.getFormulario();
        form.getComboUf().removeAllItems();
        for (Uf uf : model.listarUfs()) {
            form.getComboUf().addItem(uf);
        }
    }

    public void carregarCidades() {
        FormCliente form = (FormCliente) view.getFormulario();
        Uf uf = (Uf) form.getComboUf().getSelectedItem();
        form.getComboCidade().removeAllItems();
        if (uf == null) {
            return;
        }
        for (Cidade cidade : model.listarCidadesPorUf(uf)) {
            form.getComboCidade().addItem(cidade);
        }
    }


    @Override
    public void dadosViewParaModel(Cliente t, JPanel pnl) {
        FormCliente form = (FormCliente)pnl;
        t.setNome(form.getCampoNome().getText());
        t.setCpf(form.getCampoCpf().getText());
        t.setEndereço(form.getCampoEndereco().getText());
        t.setNumero(form.getCampoNumero().getText());
        t.setDataNascimento(form.getCampoDataNascimento().getText());
        t.setEmail(form.getCampoEmail().getText());
        t.setTelefone(form.getCampoTelefone().getText());
        t.setCep(form.getCampoCep().getText());
        t.setCidadeId((Cidade)form.getComboCidade().getSelectedItem());
           
    }

    @Override
    public void dadosModelParaView(Cliente t, JPanel pnl) {

        FormCliente form = (FormCliente)pnl;
      
       form.getCampoNome().setText(t.getNome());
       form.getCampoCpf().setText(t.getCpf());
       form.getCampoEndereco().setText(t.getEndereço());
       form.getCampoNumero().setText(t.getNumero());
       form.getCampoDataNascimento().setText(t.getDataNascimento());
       form.getCampoEmail().setText(t.getEmail());
       form.getCampoTelefone().setText(t.getTelefone());
       form.getCampoCep().setText(t.getCep());
       form.getComboCidade().setSelectedItem(t.getCidade());
       
       if (t.getCidade()== null) {
            return;
        }
        form.getComboUf().setSelectedItem(t.getCidade().getUf());
           
    }
    
}
