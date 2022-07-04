package com.compass.av3.avaliacaoapi.dto;

import com.compass.av3.avaliacaoapi.model.State;
import com.compass.av3.avaliacaoapi.model.StateRegion;

import java.util.List;
import java.util.stream.Collectors;

public class StateDTO {

    private Long id;
    private String nome;
    private StateRegion regiao;
    private Integer populacao;
    private String capital;
    private Integer area;

    public StateDTO(State state) {
        this.id = state.getId();
        this.nome = state.getNome();
        this.regiao = state.getRegiao();
        this.populacao = state.getPopulacao();
        this.capital = state.getCapital();
        this.area = state.getArea();
    }

    // convert
    public static List<StateDTO> converter(List<State> states) {
        return states.stream().map(StateDTO::new).collect(Collectors.toList());
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
        return regiao;
    }

    public void setRegiao(StateRegion regiao) {
        this.regiao = regiao;
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
