package com.virtualroom.dao.impl;

import com.virtualroom.dao.CursoDAO;
import com.virtualroom.dao.GenericDAO;
import com.virtualroom.model.Curso;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author pam_s
 */
@ApplicationScoped
public class CursoDAOImpl extends GenericDAO<Curso, Long> implements CursoDAO {

    private static final Logger LOG = LoggerFactory.getLogger(EscolaDAOImpl.class);

    public CursoDAOImpl() {
        super(Curso.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public List<Curso> findByNome(String nome) {
        Query query = getEntityManager().createNamedQuery("Curso.findByNome", Curso.class);
        query.setParameter("nome", nome + "%");
        return query.getResultList();
    }

    @Override
    public List<Curso> findByInicio(Date inicio) {
        Query query = getEntityManager().createNamedQuery("Curso.findByInicio", Curso.class);
        query.setParameter("inicio", inicio);
        return query.getResultList();
    }
    
    @Override
    public List<Curso> findByPeriodo(Date inicio, Date fim) {
        Query query = getEntityManager().createNamedQuery("Curso.findByPeriodo", Curso.class);
        query.setParameter("inicio", inicio);
        query.setParameter("fim", fim);
        return query.getResultList();
    }

}
