package com.example.fantasy.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "characters")
public class Carattere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "razza")
    private String razza;

    @Column(name = "classe")
    private String classe;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "livello")
    private Integer livello;

    public Carattere() {
    }

    public Carattere(Integer id, String nome, String razza, String classe, String descrizione, Integer livello) {
        this.id = id;
        this.nome = nome;
        this.razza = razza;
        this.classe = classe;
        this.descrizione = descrizione;
        this.livello = livello;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Integer getLivello() {
        return livello;
    }

    public void setLivello(Integer livello) {
        this.livello = livello;
    }
}
