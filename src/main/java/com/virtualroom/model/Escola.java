/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualroom.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pam_s
 */
@Entity
@Table(name = "escolas")
@XmlRootElement(name = "escola")
public class Escola extends AbstractEntity {

    @Column(length = 255, nullable = false, unique = true)
    private String nomeFantasia;

    @Column(length = 14, nullable = false, unique = true)
    private String cnpj;

    @OneToMany(mappedBy = "escola")
    private Set<Curso> cursos;

    public Escola() {
    }

    public Escola(String nomeFantasia, String cnpj) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public void updateParameters(Object entity) {
        Escola other = (Escola) entity;
        this.nomeFantasia = other.nomeFantasia;
        this.cnpj = other.cnpj;
        this.cursos = other.cursos;
    }

}
