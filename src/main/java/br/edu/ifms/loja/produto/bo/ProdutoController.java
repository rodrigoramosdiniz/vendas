/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.produto.bo;

import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import br.edu.ifms.loja.produto.datamodel.Produto;
import br.edu.ifms.loja.produto.view.FormProduto;
import java.math.BigDecimal;
import javax.swing.JPanel;
import maruyama.components.mvc.GenericCRUDController;
import maruyama.components.mvc.GenericCRUDModel;
import maruyama.components.mvc.GenericCRUDView;

/**
 *
 * @author Rodrigo
 */
public class ProdutoController extends GenericCRUDController<Produto>{

    public ProdutoController(GenericCRUDModel model, GenericCRUDView view) {
        super(model, view);
        carregarFornecedor_id(view,(ProdutoBO) model);
    }
    
    public void carregarFornecedor_id(GenericCRUDView view, ProdutoBO model){
        FormProduto form = (FormProduto) view.getFormulario();
        form.getComboFornecedor().removeAllItems();
        
        for(Fornecedor fornecedor: model.listar()){
            form.getComboFornecedor().addItem(fornecedor);
        }
    }

    @Override
    public void dadosViewParaModel(Produto t, JPanel pnl) {
        FormProduto form = (FormProduto)pnl;
        t.setDescricao(form.getCampoDescricao().getText());
        t.setMarca(form.getCampoMarca().getText());
        t.setModelo(form.getCampoModelo().getText());
        t.setQtde(new Integer(form.getCampoQuantidade().getText()));
        t.setValor(new BigDecimal(form.getCampoValor().getText()));
        t.setFornecedor((Fornecedor)form.getComboFornecedor().getSelectedItem());
        
    }

    @Override
    public void dadosModelParaView(Produto t, JPanel pnl) {
        FormProduto form = (FormProduto)pnl;
        form.getCampoDescricao().setText(t.getDescricao());
        form.getCampoMarca().setText(t.getMarca());
        form.getCampoModelo().setText(t.getModelo());
        form.getCampoQuantidade().setText(t.getQtde().toString());
        form.getCampoValor().setText(t.getValor().toString());
        form.getComboFornecedor().setSelectedItem(t.getFornecedor());
                
    }
    
}
