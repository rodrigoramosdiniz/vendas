/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.produto.bo;

import br.edu.ifms.loja.fornecedor.dao.FornecedorDAO;
import br.edu.ifms.loja.fornecedor.datamodel.Fornecedor;
import br.edu.ifms.loja.produto.dao.ProdutoDao;
import br.edu.ifms.loja.produto.datamodel.Produto;
import java.util.List;
import maruyama.components.mvc.GenericCRUDModel;

/**
 *
 * @author Rodrigo
 */
public class ProdutoBO extends GenericCRUDModel<Produto>{

    private ProdutoDao dao;
    private FornecedorDAO ForDao;
    
    
    

    public ProdutoBO() {
        dao = new ProdutoDao();
        ForDao = new FornecedorDAO();   
    }
    
    public List<Fornecedor> listar() {
        return ForDao.listarTodos();
    }
    
    
    
    @Override
    public void salvarEmBaseDeDados(Produto t) {
        dao.persistir(t);
              
    }

    @Override
    public void removerEmBaseDeDados(Produto t) {
        dao.remover(t);
    }

    @Override
    public List<Produto> carregarLista() {
       return dao.listarTodos();
        
    }

    @Override
    public List<Produto> buscar(String string, String string1) {
        return null;
        
    }
    
}
