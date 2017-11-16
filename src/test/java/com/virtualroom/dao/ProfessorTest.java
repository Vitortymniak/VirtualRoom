package com.virtualroom.dao;

import com.virtualroom.dao.impl.ProfessorDAOImpl;
import com.virtualroom.model.Professor;
import java.util.Date;
import java.util.List;
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
public class ProfessorTest {

    private static final Professor FERNANDO;

    static {
        FERNANDO = new Professor("Especialista", "Fernando", new Date());
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
        List<Professor> professores = professorDAO.findByTitulacao(professor.getTitulacao());
        if (professores == null || professores.isEmpty()) {
            professorDAO.save(professor);
            professores = professorDAO.findByTitulacao(professor.getTitulacao());
        }
        return professores.get(0);
    }
}
