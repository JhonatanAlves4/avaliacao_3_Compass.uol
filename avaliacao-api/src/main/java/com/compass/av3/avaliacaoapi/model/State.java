package com.compass.av3.avaliacaoapi.model;

import javax.persistence.*;

@Entity(name = "states")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String regiao;
    private Integer populacao;
    private String capital;
    private Integer area;

    public State() {}

    public State(String nome, StateRegion regiao, Integer populacao, String capital, Integer area) {
        this.nome = nome;
        setRegiao(regiao);
        this.populacao = populacao;
        this.capital = capital;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StateRegion getRegiao() {
        return StateRegion.RegionValue(regiao);
    }

    public void setRegiao(StateRegion regiao) {
        if (regiao != null) {
            this.regiao = regiao.getRegions();
        }
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}
