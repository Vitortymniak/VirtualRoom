package com.virtualroom.service.impl;

import com.virtualroom.dao.DAO;
import com.virtualroom.dao.ProfessorDAO;
import com.virtualroom.model.Professor;
import com.virtualroom.service.GenericCRUDRestService;
import com.virtualroom.service.ProfessorService;
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
@Path("/professor")
public class ProfessorServiceImpl extends GenericCRUDRestService<Professor> implements ProfessorService {

    private static final Logger LOG = LoggerFactory.getLogger(AlunoServiceImpl.class);
    
    @Inject
    private ProfessorDAO professorDAO;
    
    public ProfessorServiceImpl() {
        super(Professor.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Professor> list) {
        return new GenericEntity<List<Professor>>(list) {
        };    
    }

    @Override
    public DAO getDao() {
        return professorDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @GET
    @Path("/titulacao/{titulacao}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response findByTitulacao(@PathParam("titulacao")String Titulacao) {
        List<Professor> professor = professorDAO.findByTitulacao(Titulacao);
        if (professor == null || professor.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(professor).build();
    }
      
    }
