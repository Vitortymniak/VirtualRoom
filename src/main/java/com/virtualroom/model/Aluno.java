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

/**
 *
 * @author pam_s
 */
@Entity
@Table(name = "alunos")
@XmlRootElement(name = "aluno")
@NamedQueries({
    @NamedQuery(name = "Aluno.findByRA", query = "select a from Aluno a where a.registroAcademico = :ra")
})
public class Aluno extends Ator {

    @Column(name = "ra", length = 10, nullable = false, unique = true)
    private String registroAcademico;

    @ManyToMany(mappedBy = "alunos")
    private Set<Sala> salas;

    public Aluno() {
    }

    public Aluno(String registroAcademico, String nome, Date nascimento) {
        super(nome, nascimento);
        this.registroAcademico = registroAcademico;
    }

    public String getRegistroAcademico() {
        return registroAcademico;
    }

    public void setRegistroAcademico(String registroAcademico) {
        this.registroAcademico = registroAcademico;
    }

    public Set<Sala> getSalas() {
        return salas;
    }

    public void setSalas(Set<Sala> salas) {
        this.salas = salas;
    }

    @Override
    public void updateParameters(Object entity) {
        Aluno other = (Aluno) entity;
        this.registroAcademico = other.registroAcademico;
        this.salas = other.salas;
    }

}
