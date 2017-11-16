package com.virtualroom.service.impl;

import com.virtualroom.dao.DAO;
import com.virtualroom.dao.EscolaDAO;
import com.virtualroom.model.Escola;
import com.virtualroom.service.EscolaService;
import com.virtualroom.service.GenericCRUDRestService;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author pam_s
 */
@ManagedBean
@Path("/escola")
public class EscolaServiceImpl extends GenericCRUDRestService<Escola> implements EscolaService{

    private static final Logger LOG = LoggerFactory.getLogger(EscolaServiceImpl.class);
    
   @Inject
    private EscolaDAO escolaDAO;
    
    public EscolaServiceImpl() {
        super(Escola.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Escola> list) {
        return new GenericEntity<List<Escola>>(list) {
        }; 
    }

    @Override
    public DAO getDao() {
        return escolaDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }
    
}
