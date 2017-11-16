package com.virtualroom.dao;

import com.virtualroom.dao.impl.AlunoDAOImpl;
import com.virtualroom.dao.impl.CursoDAOImpl;
import com.virtualroom.dao.impl.ProfessorDAOImpl;
import com.virtualroom.dao.impl.SalaDAOImpl;
import com.virtualroom.model.Aluno;
import com.virtualroom.model.Curso;
import com.virtualroom.model.Professor;
import com.virtualroom.model.Sala;
import java.util.List;
import javax.inject.Inject;
import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author pam_s
 */
@RunWith(CdiRunner.class)
@AdditionalClasses({SalaDAOImpl.class, CursoDAOImpl.class, AlunoDAOImpl.class, ProfessorDAOImpl.class})
public class SalaTest {

    @Inject
    private SalaDAO salaDAO;

    @Inject
    private CursoDAO cursoDAO;
    
    @Inject
    private AlunoDAO alunoDAO;

    @Inject
    private ProfessorDAO professorDAO;

    private List<Curso> cursos;
    private List<Aluno> alunos;
    private List<Professor> professores;

    @Before
    public void setUp() {
        cursos = cursoDAO.findAll();
        alunos = alunoDAO.findAll();
        professores = professorDAO.findAll();
    }

    @Test
    public void injectionTest() {
        Assert.assertNotNull(salaDAO);
        Assert.assertNotNull(cursoDAO);
        Assert.assertNotNull(alunoDAO);
        Assert.assertNotNull(professorDAO);
    }
    
    @Test
    public void saveTest() {
        List<Sala> salas = salaDAO.findAll();
        if(salas == null || salas.isEmpty()) {
            Sala sala = new Sala();
            sala.setNome("Turma de Computação");
            sala.setCurso(cursos.get(0));
            sala.getAlunos().add(alunos.get(0));
            sala.getProfessores().add(professores.get(0));
            salaDAO.save(sala);
            salas = salaDAO.findAll();
        }
        
        Assert.assertNotNull(salas);
        Assert.assertFalse(salas.isEmpty());
        
        Sala teste = salas.get(0);
        Assert.assertFalse(teste.getAlunos().isEmpty());
        Assert.assertFalse(teste.getProfessores().isEmpty());
    }
}
