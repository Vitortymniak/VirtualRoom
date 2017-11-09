package com.virtualroom.dao.impl;

import com.virtualroom.dao.EscolaDAO;
import com.virtualroom.dao.GenericDAO;
import com.virtualroom.model.Escola;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author pam_s
 */
@ApplicationScoped
public class EscolaDAOImpl extends GenericDAO<Escola, Long> implements EscolaDAO {

    private static final Logger LOG = LoggerFactory.getLogger(EscolaDAOImpl.class);

    public EscolaDAOImpl() {
        super(Escola.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Escola findByCnpj(String cnpj) {
        String hql = "select e from Escola e where e.cnpj = :cnpj";
        Query query = getEntityManager().createQuery(hql);
        query.setParameter("cnpj", cnpj);
        List<Escola> escolas = query.getResultList();
        if (escolas == null || escolas.isEmpty()) {
            return null;
        } else if (escolas.size() > 1) {
            throw new NonUniqueResultException();
        } else {
            return escolas.get(0);
        }
    }

}
