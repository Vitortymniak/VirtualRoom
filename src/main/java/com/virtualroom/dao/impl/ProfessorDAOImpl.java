/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualroom.dao.impl;

import com.virtualroom.dao.GenericDAO;
import com.virtualroom.dao.ProfessorDAO;
import com.virtualroom.model.Professor;
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
public class ProfessorDAOImpl extends GenericDAO<Professor, Long> implements ProfessorDAO {

    private static final Logger LOG = LoggerFactory.getLogger(ProfessorDAOImpl.class);
    
    public ProfessorDAOImpl() {
        super(Professor.class);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public List<Professor> findByTitulacao(String titulacao) {
        Query query = getEntityManager().createNamedQuery("Professor.findByTitulacao",Professor.class);
        query.setParameter("titulacao", titulacao);
        return query.getResultList();
          
    }
    
    public List<Professor> findByNome(String nome) {
        Query query = getEntityManager().createNamedQuery("Professor.findByNome", Professor.class);
        query.setParameter("nome", nome + "%");
        return query.getResultList();
    }
    
}
