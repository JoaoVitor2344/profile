package com.profile.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_usuario")
    private Integer cod_usuario;

    @Column(name = "nome")
    private String nome;

    public Usuario() {
    }

    public Usuario(Integer cod_usuario, String nome) {
        this.cod_usuario = cod_usuario;
        this.nome = nome;
    }

    public Integer getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(Integer cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}