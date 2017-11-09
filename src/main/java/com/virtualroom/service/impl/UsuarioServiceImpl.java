package com.virtualroom.service.impl;

import com.virtualroom.dao.DAO;
import com.virtualroom.dao.UsuarioDAO;
import com.virtualroom.model.Usuario;
import com.virtualroom.service.GenericCRUDRestService;
import com.virtualroom.service.UsuarioService;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fernando
 */
@ManagedBean
@Path("/usuario")
public class UsuarioServiceImpl extends GenericCRUDRestService<Usuario> implements UsuarioService {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Inject
    private UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl() {
        super(Usuario.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Usuario> list) {
        return new GenericEntity<List<Usuario>>(list){};
    }

    @Override
    public DAO getDao() {
        return usuarioDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @GET
    @Path("/busca/{login}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response findByLogin(@PathParam("login") String login) {
        Usuario usuario = usuarioDAO.findByLogin(login);
        if(usuario == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(usuario).build();
    }

    @GET
    @Path("/login/{login}/{senha}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response findByCredenciais(@PathParam("login") String login, @PathParam("senha") String senha) {
        Usuario usuario = usuarioDAO.findByCredenciais(login, senha);
        if(usuario == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(usuario).build();
    }

}
