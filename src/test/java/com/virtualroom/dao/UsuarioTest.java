package com.virtualroom.dao;

import com.virtualroom.dao.impl.UsuarioDAOImpl;
import com.virtualroom.model.NivelAcesso;
import com.virtualroom.model.Usuario;
import javax.inject.Inject;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author fernando
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({UsuarioDAOImpl.class})
public class UsuarioTest {

    private static final Usuario ROOT;
    private static final Usuario ADMIN;
    private static final Usuario USER;

    static {
        ROOT = new Usuario("root", "senha10", NivelAcesso.ROOT);
        ADMIN = new Usuario("admin", "abacaxi123", NivelAcesso.ADMIN);
        USER = new Usuario("user", "senha100", NivelAcesso.USER);
    }

    @Inject
    private UsuarioDAO usuarioDAO;

    @Test
    public void persisteUsuarioTeste() {
        Usuario root = persisteSeNaoExiste(ROOT);
        Assert.assertNotNull(root);
        Assert.assertNotNull(root.getId());
        
        Usuario admin = persisteSeNaoExiste(ADMIN);
        Assert.assertNotNull(admin);
        Assert.assertNotNull(admin.getId());
        
        Usuario user = persisteSeNaoExiste(USER);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }

    private Usuario persisteSeNaoExiste(Usuario usuario) {
        Usuario existente = usuarioDAO.findByLogin(usuario.getLogin());
        if (existente == null) {
            usuarioDAO.save(usuario);
            existente = usuarioDAO.findByLogin(usuario.getLogin());
        }
        return existente;
    }
}
