package com.virtualroom.service.impl;

import com.virtualroom.dao.AlunoDAO;
import com.virtualroom.dao.DAO;
import com.virtualroom.model.Aluno;
import com.virtualroom.service.AlunoService;
import com.virtualroom.service.GenericCRUDRestService;
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
@Path("/aluno")
public class AlunoServiceImpl extends GenericCRUDRestService<Aluno> implements AlunoService {

    private static final Logger LOG = LoggerFactory.getLogger(AlunoServiceImpl.class);

    @Inject
    private AlunoDAO alunoDAO;

    public AlunoServiceImpl() {
        super(Aluno.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Aluno> list) {
        return new GenericEntity<List<Aluno>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return alunoDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @GET
    @Path("/ra/{ra}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Override
    public Response findByRa(@PathParam("ra") String ra) {
        Aluno aluno = alunoDAO.findByRa(ra);
        if (aluno == null) {
            return Response.noContent().build();
        }
        return Response.ok().entity(aluno).build();
    }

}
