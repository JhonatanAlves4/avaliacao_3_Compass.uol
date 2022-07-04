package com.compass.av3.avaliacaoapi.dto;

import com.compass.av3.avaliacaoapi.config.validation.ApiRequestException;
import com.compass.av3.avaliacaoapi.model.State;
import com.compass.av3.avaliacaoapi.model.StateRegion;
import com.compass.av3.avaliacaoapi.repository.StateRepository;

public class StateRequest {

    private Long id;
    private String nome;
    private StateRegion regiao;
    private Integer populacao;
    private String capital;
    private Integer area;

    public State toState() {
        return new State(nome, regiao, populacao, capital, area);
    }

    public State update(Long id, StateRepository stateRepository) {
        State state = stateRepository.getReferenceById(id);
        state.setNome(this.nome);
        state.setRegiao(this.regiao);
        state.setPopulacao(this.populacao);
        state.setCapital(this.capital);
        state.setArea(this.area);

        return state;
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
        try {
            this.regiao = regiao;
        } catch (Exception e) {
            throw new ApiRequestException("Erroo");
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
