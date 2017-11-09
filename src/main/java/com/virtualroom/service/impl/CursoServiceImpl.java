package com.virtualroom.service.impl;

import com.virtualroom.dao.CursoDAO;
import com.virtualroom.dao.DAO;
import com.virtualroom.model.Curso;
import com.virtualroom.service.CursoService;
import com.virtualroom.service.GenericCRUDRestService;
import java.util.Date;
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
 * @author pam_s
 */
@ManagedBean
@Path("/curso")
public class CursoServiceImpl extends GenericCRUDRestService<Curso> implements CursoService {

    private static final Logger LOG = LoggerFactory.getLogger(CursoServiceImpl.class);

    @Inject
    private CursoDAO cursoDAO;

    public CursoServiceImpl() {
        super(Curso.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Curso> list) {
        return new GenericEntity<List<Curso>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return cursoDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @GET
    @Path("/nome/{nome}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response findByNome(@PathParam("nome") String nome) {
        List<Curso> cursos = cursoDAO.findByNome(nome);
        if (cursos == null || cursos.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(cursos).build();
    }

    @GET
    @Path("/inicio/{param}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response findByInicio(@PathParam("param") Date inicio) {
        List<Curso> cursos = cursoDAO.findByInicio(inicio);
        if (cursos == null || cursos.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(cursos).build();
    }

    @GET
    @Path("/inicio/{inicio}/fim/{fim}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response findByPeriodo(@PathParam("inicio") Date inicio, @PathParam("fim") Date fim) {
        List<Curso> cursos = cursoDAO.findByPeriodo(inicio, fim);
        if (cursos == null || cursos.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(cursos).build();
    }

}
