package com.virtualroom.service.impl;

import com.virtualroom.dao.DAO;
import com.virtualroom.dao.SalaDAO;
import com.virtualroom.model.Sala;
import com.virtualroom.service.GenericCRUDRestService;
import com.virtualroom.service.SalaService;
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
@Path("/sala")
public class SalaServiceImpl extends  GenericCRUDRestService<Sala> implements SalaService {

    private static final Logger LOG = LoggerFactory.getLogger(SalaServiceImpl.class);
    
    @Inject
    private SalaDAO salaDAO;
    
    public SalaServiceImpl() {
        super(Sala.class);
    }

    @Override
    public GenericEntity listToGenericEntity(List<Sala> list) {
        return new GenericEntity<List<Sala>>(list) {
        };
    }

    @Override
    public DAO getDao() {
        return salaDAO;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }
    
}
