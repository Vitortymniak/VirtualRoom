package com.virtualroom.dao;

import com.virtualroom.model.Escola;

/**
 *
 * @author pam_s
 */
public interface EscolaDAO extends DAO<Escola, Long> {

    Escola findByCnpj(String cnpj);

}
