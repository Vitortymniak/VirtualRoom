/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualroom.dao.impl;

import com.virtualroom.dao.AlunoDAO;
import com.virtualroom.dao.GenericDAO;
import com.virtualroom.model.Aluno;
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
public class AlunoDAOImpl extends GenericDAO<Aluno, Long> implements AlunoDAO {

    private static final Logger LOG = LoggerFactory.getLogger(AlunoDAOImpl.class);

    public AlunoDAOImpl() {
        super(Aluno.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public Aluno findByRa(String ra) {
        Query query = getEntityManager().createNamedQuery("Aluno.findByRA", Aluno.class);
        query.setParameter("ra", ra);
        List<Aluno> alunos = query.getResultList();
        if (alunos == null || alunos.isEmpty()) {
            return null;
        } else if (alunos.size() > 1) {
            throw new NonUniqueResultException();
        } else {
            return alunos.get(0);
        }
    }

}
