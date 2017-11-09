/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualroom.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pam_s
 */
@Entity
@Table(name = "salas")
@XmlRootElement(name = "sala")
public class Sala extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String nome;

    @ManyToOne
    private Curso curso;

    @ManyToMany
    private Set<Aluno> alunos;

    @ManyToMany
    private Set<Professor> professores;

    public Sala() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Set<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(Set<Professor> professores) {
        this.professores = professores;
    }

    @Override
    public void updateParameters(Object entity) {
        Sala other = (Sala) entity;
        this.nome = other.nome;
        this.curso = other.curso;
        this.alunos = other.alunos;
        this.professores = other.professores;
    }

}
