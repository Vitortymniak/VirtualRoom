package com.virtualroom.dao;

import com.virtualroom.model.Aluno;

/**
 *
 * @author pam_s
 */
public interface AlunoDAO extends DAO<Aluno, Long> {

    Aluno findByRa(String ra);

}
