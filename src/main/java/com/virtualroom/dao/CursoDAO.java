package com.virtualroom.dao;

import com.virtualroom.model.Curso;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pam_s
 */
public interface CursoDAO extends DAO<Curso, Long> {

    List<Curso> findByNome(String nome);
    
    List<Curso> findByInicio(Date inicio);
    
    List<Curso> findByPeriodo(Date inicio, Date fim);
}
