package com.virtualroom.dao;

import com.virtualroom.model.Usuario;

/**
 *
 * @author fernando
 */
public interface UsuarioDAO extends DAO<Usuario, Long> {

    Usuario findByLogin(String login);
    
    Usuario findByCredenciais(String login, String senha);
    
}
