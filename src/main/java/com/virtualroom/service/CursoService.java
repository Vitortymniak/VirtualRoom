/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualroom.service;

import com.virtualroom.model.Curso;
import java.util.Date;
import javax.ws.rs.core.Response;

/**
 *
 * @author pam_s
 */
public interface CursoService extends CRUDRestService<Curso> {

    Response findByNome(String nome);

    Response findByInicio(Date inicio);

    Response findByPeriodo(Date inicio, Date fim);
}
