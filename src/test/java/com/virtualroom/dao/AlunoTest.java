package com.virtualroom.dao;

import com.virtualroom.dao.impl.AlunoDAOImpl;
import com.virtualroom.model.Aluno;
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
@AdditionalClasses(AlunoDAOImpl.class)
public class AlunoTest {

    private static final Aluno VITOR;

    static {
        VITOR = new Aluno("804079", "Vitor", new Date());
    }

    @Inject
    private AlunoDAO alunoDAO;

    @Test
    public void injectionTest() {
        Assert.assertNotNull(alunoDAO);
    }

    @Test
    public void saveAluno() {
        Aluno vitor = persisteSeNaoExiste(VITOR);
        Assert.assertNotNull(vitor);
        Assert.assertNotNull(vitor.getId());
    }

    private Aluno persisteSeNaoExiste(Aluno aluno) {
        Aluno existente = alunoDAO.findByRa(aluno.getRegistroAcademico());
        if (existente == null) {
            alunoDAO.save(aluno);
            existente = alunoDAO.findByRa(aluno.getRegistroAcademico());
        }
        return existente;
    }
}
