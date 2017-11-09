package com.virtualroom.dao.impl;

import com.virtualroom.dao.GenericDAO;
import com.virtualroom.dao.SalaDAO;
import com.virtualroom.model.Sala;
import javax.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author pam_s
 */
@ApplicationScoped
public class SalaDAOImpl extends GenericDAO<Sala, Long> implements SalaDAO {

    private static final Logger LOG = LoggerFactory.getLogger(SalaDAOImpl.class);
    
    public SalaDAOImpl() {
        super(Sala.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }
    
}
