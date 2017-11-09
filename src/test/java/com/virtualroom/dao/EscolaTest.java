/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualroom.dao;

import com.virtualroom.dao.impl.EscolaDAOImpl;
import com.virtualroom.model.Escola;
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
@AdditionalClasses(EscolaDAOImpl.class)
public class EscolaTest {

    private static final Escola FAFIMAN;
    private static final Escola GORI;

    static {
        FAFIMAN = new Escola("Fafiman", "12345678910");
        GORI = new Escola("Gori", "09876543211");
    }

    @Inject
    private EscolaDAO escolaDAO;

    @Test
    public void injectionTest() {
        Assert.assertNotNull(escolaDAO);
    }

    @Test
    public void saveTest() {
        Escola fafiman = persisteSeNaoExiste(FAFIMAN);
        Assert.assertNotNull(fafiman);

        Escola gori = persisteSeNaoExiste(GORI);
        Assert.assertNotNull(gori);
    }

    private Escola persisteSeNaoExiste(Escola escola) {
        Escola encontrada = escolaDAO.findByCnpj(escola.getCnpj());
        if (encontrada == null) {
            escolaDAO.save(escola);
            encontrada = escolaDAO.findByCnpj(escola.getCnpj());
        }
        return encontrada;
    }
}
