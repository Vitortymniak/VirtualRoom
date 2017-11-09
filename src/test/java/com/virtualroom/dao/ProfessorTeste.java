package com.virtualroom.dao;

import com.virtualroom.dao.impl.ProfessorDAOImpl;
import com.virtualroom.model.Professor;
import java.util.Date;
import javax.inject.Inject;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author pam_s
 */
@RunWith(CdiRunner.class)
@AdditionalClasses(ProfessorDAOImpl.class)
public class ProfessorTeste {
    
    private static final Professor FERNANDO;

    static {
        FERNANDO = new Professor("Fernando","Portugues", new Date());
    }

    @Inject
    private ProfessorDAO professorDAO;

    @Test
    public void injectionTest() {
        Assert.assertNotNull(professorDAO);
    }

    @Test
    public void saveProfessor() {
        Professor fernando = persisteSeNaoExiste(FERNANDO);
        Assert.assertNotNull(fernando);
        Assert.assertNotNull(fernando.getId());
    }

    private Professor persisteSeNaoExiste(Professor professor) {
        Professor existente =  (Professor) professorDAO.findByTitulacao(professor.getTitulacao());
        if (existente == null) {
            professorDAO.save(professor);
            existente = (Professor) professorDAO.findByTitulacao(professor.getTitulacao());
        }
        return existente;
    }
}
