/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualroom.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pam_s
 */
@Entity
@Table(name = "professores")
@XmlRootElement(name = "professor")
@NamedQueries({
    @NamedQuery(name = "Professor.findByNome", query = "select c from Professor c where c.nome like :nome")
    ,
    @NamedQuery(name = "Professor.findByTitulacao", query = "select c from Professor c where c.titulacao like :titulacao")
})
public class Professor extends Ator {

    @Column(length = 255, nullable = false)
    private String titulacao;

    @ManyToMany(mappedBy = "professores")
    private Set<Sala> salas;

    public Professor() {
    }

    public Professor(String titulacao, String nome, Date nascimento) {
        super(nome, nascimento);
        this.titulacao = titulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @XmlTransient
    public Set<Sala> getSalas() {
        return salas;
    }

    public void setSalas(Set<Sala> salas) {
        this.salas = salas;
    }

    @Override
    public void updateParameters(Object entity) {
        Professor other = (Professor) entity;
        this.setNome(other.getNome());
        this.setNascimento(other.getNascimento());
        this.titulacao = other.titulacao;
        this.salas = other.salas;
    }

}
