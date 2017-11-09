package com.virtualroom.model;

import com.virtualroom.util.Criptography;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fernando
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuario.findByLogin", query = "select u from Usuario u where u.login = :login"),
    @NamedQuery(name = "Usuario.findByCredenciais", query = "select u from Usuario u where u.login = :login and u.senha = :senha")
})
@XmlRootElement(name = "usuario")
public class Usuario extends AbstractEntity {

    @Column(length = 255, nullable = false, unique = true)
    private String login;

    @Column(length = 255, nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    private NivelAcesso nivelAcesso;

    public Usuario() {
    }

    public Usuario(String login, String senha, NivelAcesso nivelAcesso) {
        this.login = login;
        this.senha = Criptography.encrypt(senha);
        this.nivelAcesso = nivelAcesso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = Criptography.encrypt(senha);
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public void updateParameters(Object entity) {
        Usuario outro = (Usuario) entity;
        this.login = outro.login;
        this.senha = outro.senha;
        this.nivelAcesso = outro.nivelAcesso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.login);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.login, other.login);
    }

    @Override
    public String toString() {
        return "Usuario{" + "login=" + login + ", senha=" + senha + ", nivelAcesso=" + nivelAcesso + '}';
    }

}
