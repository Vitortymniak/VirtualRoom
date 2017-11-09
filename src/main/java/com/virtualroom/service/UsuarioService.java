package com.virtualroom.service;

import javax.ws.rs.core.Response;

/**
 *
 * @author fernando
 */
public interface UsuarioService {

    Response findByLogin(String login);

    Response findByCredenciais(String login, String senha);
}
