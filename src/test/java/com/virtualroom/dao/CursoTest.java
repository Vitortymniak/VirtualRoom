/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualroom.dao;

import com.virtualroom.dao.impl.CursoDAOImpl;
import com.virtualroom.dao.impl.EscolaDAOImpl;
import com.virtualroom.model.Curso;
import com.virtualroom.model.Escola;
import java.util.Date;
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
@AdditionalClasses({CursoDAOImpl.class, EscolaDAOImpl.class})
public class CursoTest {

    private static Curso INFORMATICA;
    private static Curso PEDAGOGIA;

    static {
        INFORMATICA = new Curso("Informática", new Date(), new Date());
        PEDAGOGIA = new Curso("Pedagogia", new Date(), new Date());
    }

    @Inject
    private CursoDAO cursoDAO;

    @Inject
    private EscolaDAO escolaDAO;

    private List<Escola> escolas;

    @Test
    public void injectionTest() {
        Assert.assertNotNull(cursoDAO);
        Assert.assertNotNull(escolaDAO);
    }

    @Before
    public void carregaEscolas() {
        escolas = escolaDAO.findAll();
    }

    @Test
    public void saveCurso() {
        Curso info = persisteSeNaoExiste(INFORMATICA);
        Assert.assertNotNull(info);

        Curso ped = persisteSeNaoExiste(PEDAGOGIA);
        Assert.assertNotNull(ped);
    }

    private Curso persisteSeNaoExiste(Curso curso) {
        List<Curso> cursos = cursoDAO.findByNome(curso.getNome());
        if (cursos == null || cursos.isEmpty()) {
            curso.setEscola(escolas.get(0));
            cursoDAO.save(curso);
            cursos = cursoDAO.findByNome(curso.getNome());
        }
        return cursos.get(0);
    }
}
