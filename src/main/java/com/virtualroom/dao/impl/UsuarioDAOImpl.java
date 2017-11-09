package com.virtualroom.dao.impl;

import com.virtualroom.dao.GenericDAO;
import com.virtualroom.dao.UsuarioDAO;
import com.virtualroom.model.Usuario;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fernando
 */
@ApplicationScoped
public class UsuarioDAOImpl extends GenericDAO<Usuario, Long> implements UsuarioDAO {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioDAOImpl.class);

    public UsuarioDAOImpl() {
        super(Usuario.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Usuario findByLogin(String login) {
        Query query = getEntityManager().createNamedQuery("Usuario.findByLogin", Usuario.class);
        query.setParameter("login", login);
        List<Usuario> usuarios = query.getResultList();
        if (usuarios == null || usuarios.isEmpty()) {
            return null;
        } else if (usuarios.size() > 1) {
            throw new NonUniqueResultException();
        } else {
            return usuarios.get(0);
        }
    }

    @Override
    public Usuario findByCredenciais(String login, String senha) {
        Query query = getEntityManager().createNamedQuery("Usuario.findByLogin", Usuario.class);
        query.setParameter("login", login);
        query.setParameter("senha", senha);
        List<Usuario> usuarios = query.getResultList();
        if (usuarios == null || usuarios.isEmpty()) {
            return null;
        } else if (usuarios.size() > 1) {
            throw new NonUniqueResultException();
        } else {
            return usuarios.get(0);
        }
    }

}
