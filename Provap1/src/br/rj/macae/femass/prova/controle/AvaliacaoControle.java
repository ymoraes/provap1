/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.prova.controle;

import br.rj.macae.femass.prova.dao.AvaliacaoDAO;
import br.rj.macae.femass.prova.modelo.Avaliacao;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JList;

/**
 *
 * @author YMoraes
 */
public class AvaliacaoControle {
    public void gravar(Avaliacao r, JList listaAvaliacao) throws SQLException{
        if(r.getId()<=0){
            cadastrar(r, listaAvaliacao);
        }else{
            alterar(r, listaAvaliacao);
        }
    }
    private void cadastrar(Avaliacao r, JList listaAvaliacao) throws SQLException{
        AvaliacaoDAO dao = new AvaliacaoDAO();
        dao.cadastrar(r);
        List avaliacao = dao.listarTodos();
        listaAvaliacao.setListData(avaliacao.toArray());
    }
    private void alterar(Avaliacao r, JList listaAvaliacao) throws SQLException{
        AvaliacaoDAO dao = new AvaliacaoDAO();
        dao.alterar(r);
        List avaliacao = dao.listarTodos();
        listaAvaliacao.setListData(avaliacao.toArray());
    }
    
    public void atualizarListaAvaliacao(JList listaAvaliacao) throws SQLException{
        AvaliacaoDAO dao = new AvaliacaoDAO();        
        List avaliacao = dao.listarTodos();
        listaAvaliacao.setListData(avaliacao.toArray());
    }
}
