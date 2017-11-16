package com.virtualroom.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pam_s
 */
@Entity
@Table(name = "cursos")
@XmlRootElement(name = "curso")
@NamedQueries({
    @NamedQuery(name = "Curso.findByNome", query = "select c from Curso c where c.nome like :nome"),
    @NamedQuery(name = "Curso.findByInicio", query = "select c from Curso c where c.inicio >= :inicio"),
    @NamedQuery(name = "Curso.findByPeriodo", query = "select c from Curso c where c.inicio >= :inicio and c.fim <= :fim")
})
public class Curso extends AbstractEntity {

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicio;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fim;

    @ManyToOne
    private Escola escola;

    public Curso() {
    }

    public Curso(String nome, Date inicio, Date fim) {
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Curso(String nome, Date inicio, Date fim, Escola escola) {
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
        this.escola = escola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    @XmlTransient
    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    @Override
    public void updateParameters(Object entity) {
        Curso other = (Curso) entity;
        this.nome = other.nome;
        this.inicio = other.inicio;
        this.fim = other.fim;
        this.escola = other.escola;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.nome);
        hash = 11 * hash + Objects.hashCode(this.inicio);
        hash = 11 * hash + Objects.hashCode(this.fim);
        hash = 11 * hash + Objects.hashCode(this.escola);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.inicio, other.inicio)) {
            return false;
        }
        if (!Objects.equals(this.fim, other.fim)) {
            return false;
        }
        if (!Objects.equals(this.escola, other.escola)) {
            return false;
        }
        return true;
    }

}
