package com.virtualroom.service;

import com.virtualroom.model.Aluno;
import javax.ws.rs.core.Response;

/**
 *
 * @author pam_s
 */
public interface AlunoService extends CRUDRestService<Aluno>{
    
    Response findByRa(String ra);
    
}
