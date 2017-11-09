/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualroom.service;

import com.virtualroom.model.Professor;
import javax.ws.rs.core.Response;

/**
 *
 * @author pam_s
 */
public interface ProfessorService extends CRUDRestService<Professor> {
   
    Response findByTitulacao(String Titulacao);
    
}
