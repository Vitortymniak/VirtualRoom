
package com.virtualroom.dao;

import com.virtualroom.model.Professor;
import java.util.List;

/**
 *
 * @author pam_s
 */
public interface ProfessorDAO extends DAO<Professor, Long> {
    
    List<Professor> findByTitulacao (String titulacao);
    
}
